package com.google.android.exoplayer.extractor.webm;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.drm.DrmInitData.Universal;
import com.google.android.exoplayer.extractor.ChunkIndex;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.LongArray;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class WebmExtractor
  implements Extractor
{
  TrackFormat audioTrackFormat;
  byte[] blockEncryptionKeyId;
  int blockFlags;
  int blockLacingSampleCount;
  int blockLacingSampleIndex;
  int[] blockLacingSampleSizes;
  int blockState;
  long blockTimeUs;
  int blockTrackNumber;
  int blockTrackNumberLength;
  long clusterTimecodeUs = -1L;
  LongArray cueClusterPositions;
  LongArray cueTimesUs;
  long cuesContentPosition = -1L;
  int cuesState = 0;
  long durationTimecode = -1L;
  long durationUs = -1L;
  ExtractorOutput extractorOutput;
  private final ParsableByteArray nalLength;
  private final ParsableByteArray nalStartCode;
  private final EbmlReader reader;
  private int sampleBytesRead;
  private int sampleBytesWritten;
  private int sampleCurrentNalBytesRemaining;
  private boolean sampleEncodingHandled;
  private boolean sampleRead;
  boolean sampleSeenReferenceBlock;
  private final ParsableByteArray sampleStrippedBytes;
  final ParsableByteArray scratch;
  int seekEntryId;
  final ParsableByteArray seekEntryIdBytes;
  long seekEntryPosition;
  boolean seekForCues;
  private long seekPositionAfterBuildingCues = -1L;
  boolean seenClusterPositionForCurrentCuePoint;
  long segmentContentPosition = -1L;
  long segmentContentSize = -1L;
  boolean sentDrmInitData;
  long timecodeScale = -1L;
  TrackFormat trackFormat;
  final VarintReader varintReader;
  TrackFormat videoTrackFormat;
  private final ParsableByteArray vorbisNumPageSamples;
  
  public WebmExtractor()
  {
    this(new DefaultEbmlReader());
  }
  
  private WebmExtractor(EbmlReader paramEbmlReader)
  {
    reader = paramEbmlReader;
    reader.init(new InnerEbmlReaderOutput((byte)0));
    varintReader = new VarintReader();
    scratch = new ParsableByteArray(4);
    vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
    seekEntryIdBytes = new ParsableByteArray(4);
    nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    nalLength = new ParsableByteArray(4);
    sampleStrippedBytes = new ParsableByteArray();
  }
  
  static int[] ensureArrayCapacity(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[paramInt];
    }
    do
    {
      return arrayOfInt;
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= paramInt);
    return new int[Math.max(paramArrayOfInt.length * 2, paramInt)];
  }
  
  static int getElementType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 160: 
    case 174: 
    case 183: 
    case 187: 
    case 224: 
    case 225: 
    case 18407: 
    case 19899: 
    case 20532: 
    case 20533: 
    case 25152: 
    case 28032: 
    case 290298740: 
    case 357149030: 
    case 374648427: 
    case 408125543: 
    case 440786851: 
    case 475249515: 
    case 524531317: 
      return 1;
    case 131: 
    case 159: 
    case 176: 
    case 179: 
    case 186: 
    case 215: 
    case 231: 
    case 241: 
    case 251: 
    case 16980: 
    case 17029: 
    case 17143: 
    case 18401: 
    case 18408: 
    case 20529: 
    case 20530: 
    case 21420: 
    case 22186: 
    case 22203: 
    case 2352003: 
    case 2807729: 
      return 2;
    case 134: 
    case 17026: 
      return 3;
    case 161: 
    case 163: 
    case 16981: 
    case 18402: 
    case 21419: 
    case 25506: 
      return 4;
    }
    return 5;
  }
  
  static boolean isCodecSupported(String paramString)
  {
    return ("V_VP8".equals(paramString)) || ("V_VP9".equals(paramString)) || ("V_MPEG4/ISO/SP".equals(paramString)) || ("V_MPEG4/ISO/ASP".equals(paramString)) || ("V_MPEG4/ISO/AP".equals(paramString)) || ("V_MPEG4/ISO/AVC".equals(paramString)) || ("V_MPEGH/ISO/HEVC".equals(paramString)) || ("A_OPUS".equals(paramString)) || ("A_VORBIS".equals(paramString)) || ("A_AAC".equals(paramString)) || ("A_MPEG/L3".equals(paramString)) || ("A_AC3".equals(paramString));
  }
  
  private int readToOutput(ExtractorInput paramExtractorInput, TrackOutput paramTrackOutput, int paramInt)
    throws IOException, InterruptedException
  {
    int i = sampleStrippedBytes.bytesLeft();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramTrackOutput.sampleData(sampleStrippedBytes, paramInt);
    }
    for (;;)
    {
      sampleBytesRead += paramInt;
      sampleBytesWritten += paramInt;
      return paramInt;
      paramInt = paramTrackOutput.sampleData(paramExtractorInput, paramInt, false);
    }
  }
  
  private void resetSample()
  {
    sampleBytesRead = 0;
    sampleBytesWritten = 0;
    sampleCurrentNalBytesRemaining = 0;
    sampleEncodingHandled = false;
    sampleStrippedBytes.reset();
  }
  
  public final void init(ExtractorOutput paramExtractorOutput)
  {
    extractorOutput = paramExtractorOutput;
  }
  
  final void outputSampleMetadata(TrackOutput paramTrackOutput, long paramLong)
  {
    paramTrackOutput.sampleMetadata(paramLong, blockFlags, sampleBytesWritten, 0, blockEncryptionKeyId);
    sampleRead = true;
    resetSample();
  }
  
  public final int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException
  {
    sampleRead = false;
    int j = 1;
    while ((j != 0) && (!sampleRead))
    {
      boolean bool = reader.read(paramExtractorInput);
      j = bool;
      if (bool)
      {
        long l = paramExtractorInput.getPosition();
        int i;
        if (seekForCues)
        {
          seekPositionAfterBuildingCues = l;
          position = cuesContentPosition;
          cuesState = 1;
          seekForCues = false;
          i = 1;
        }
        for (;;)
        {
          j = bool;
          if (i == 0) {
            break;
          }
          return 1;
          if ((cuesState == 2) && (seekPositionAfterBuildingCues != -1L))
          {
            position = seekPositionAfterBuildingCues;
            seekPositionAfterBuildingCues = -1L;
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    if (j != 0) {
      return 0;
    }
    return -1;
  }
  
  final void readScratch(ExtractorInput paramExtractorInput, int paramInt)
    throws IOException, InterruptedException
  {
    if (scratch.limit >= paramInt) {
      return;
    }
    ParsableByteArray localParsableByteArray = scratch;
    if (data == null) {}
    for (int i = 0;; i = data.length)
    {
      if (i < paramInt) {
        scratch.reset(Arrays.copyOf(scratch.data, Math.max(scratch.data.length * 2, paramInt)), scratch.limit);
      }
      paramExtractorInput.readFully(scratch.data, scratch.limit, paramInt - scratch.limit);
      scratch.setLimit(paramInt);
      return;
    }
  }
  
  final long scaleTimecodeToUs(long paramLong)
    throws ParserException
  {
    if (timecodeScale == -1L) {
      throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }
    return Util.scaleLargeTimestamp(paramLong, timecodeScale, 1000L);
  }
  
  public final void seek()
  {
    clusterTimecodeUs = -1L;
    blockState = 0;
    reader.reset();
    varintReader.reset();
    resetSample();
  }
  
  public final boolean sniff(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    Sniffer localSniffer = new Sniffer();
    long l2 = paramExtractorInput.getLength();
    if ((l2 == -1L) || (l2 > 1024L)) {}
    for (long l1 = 1024L;; l1 = l2)
    {
      int i = (int)l1;
      paramExtractorInput.peekFully(scratch.data, 0, 4);
      l1 = scratch.readUnsignedInt();
      peekLength = 4;
      while (l1 != 440786851L)
      {
        int j = peekLength + 1;
        peekLength = j;
        if (j == i) {
          break label306;
        }
        paramExtractorInput.peekFully(scratch.data, 0, 1);
        l1 = l1 << 8 & 0xFFFFFFFFFFFFFF00 | scratch.data[0] & 0xFF;
      }
    }
    l1 = localSniffer.readUint(paramExtractorInput);
    long l3 = peekLength;
    if ((l1 == Long.MIN_VALUE) || ((l2 != -1L) && (l3 + l1 >= l2))) {
      return false;
    }
    do
    {
      if (l2 != 0L)
      {
        paramExtractorInput.advancePeekPosition((int)l2);
        peekLength = ((int)(l2 + peekLength));
      }
      if (peekLength >= l3 + l1) {
        break;
      }
      if (localSniffer.readUint(paramExtractorInput) == Long.MIN_VALUE) {
        break label306;
      }
      l2 = localSniffer.readUint(paramExtractorInput);
    } while ((l2 >= 0L) && (l2 <= 2147483647L));
    return false;
    return peekLength == l1 + l3;
  }
  
  final void writeSampleData(ExtractorInput paramExtractorInput, TrackOutput paramTrackOutput, TrackFormat paramTrackFormat, int paramInt)
    throws IOException, InterruptedException
  {
    byte[] arrayOfByte;
    int i;
    int j;
    if (!sampleEncodingHandled)
    {
      if (hasContentEncryption)
      {
        blockFlags &= 0xFFFFFFFD;
        paramExtractorInput.readFully(scratch.data, 0, 1);
        sampleBytesRead += 1;
        if ((scratch.data[0] & 0x80) == 128) {
          throw new ParserException("Extension bit is set in signal byte");
        }
        if ((scratch.data[0] & 0x1) == 1)
        {
          scratch.data[0] = 8;
          scratch.setPosition(0);
          paramTrackOutput.sampleData(scratch, 1);
          sampleBytesWritten += 1;
          blockFlags |= 0x2;
        }
        sampleEncodingHandled = true;
      }
    }
    else
    {
      paramInt += sampleStrippedBytes.limit;
      if ((!"V_MPEG4/ISO/AVC".equals(codecId)) && (!"V_MPEGH/ISO/HEVC".equals(codecId))) {
        break label400;
      }
      arrayOfByte = nalLength.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      i = nalUnitLengthFieldLength;
      j = 4 - nalUnitLengthFieldLength;
    }
    for (;;)
    {
      if (sampleBytesRead < paramInt)
      {
        if (sampleCurrentNalBytesRemaining == 0)
        {
          int k = Math.min(i, sampleStrippedBytes.bytesLeft());
          paramExtractorInput.readFully(arrayOfByte, j + k, i - k);
          if (k > 0) {
            sampleStrippedBytes.readBytes(arrayOfByte, j, k);
          }
          sampleBytesRead += i;
          nalLength.setPosition(0);
          sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
          nalStartCode.setPosition(0);
          paramTrackOutput.sampleData(nalStartCode, 4);
          sampleBytesWritten += 4;
          continue;
          if (sampleStrippedBytes == null) {
            break;
          }
          sampleStrippedBytes.reset(sampleStrippedBytes, sampleStrippedBytes.length);
          break;
        }
        sampleCurrentNalBytesRemaining -= readToOutput(paramExtractorInput, paramTrackOutput, sampleCurrentNalBytesRemaining);
        continue;
        label400:
        while (sampleBytesRead < paramInt) {
          readToOutput(paramExtractorInput, paramTrackOutput, paramInt - sampleBytesRead);
        }
      }
    }
    if ("A_VORBIS".equals(codecId))
    {
      vorbisNumPageSamples.setPosition(0);
      paramTrackOutput.sampleData(vorbisNumPageSamples, 4);
      sampleBytesWritten += 4;
    }
  }
  
  private final class InnerEbmlReaderOutput
    implements EbmlReaderOutput
  {
    private InnerEbmlReaderOutput() {}
    
    public final void binaryElement(int paramInt1, int paramInt2, ExtractorInput paramExtractorInput)
      throws IOException, InterruptedException
    {
      WebmExtractor localWebmExtractor = WebmExtractor.this;
      switch (paramInt1)
      {
      default: 
        throw new ParserException("Unexpected id: " + paramInt1);
      case 21419: 
        Arrays.fill(seekEntryIdBytes.data, (byte)0);
        paramExtractorInput.readFully(seekEntryIdBytes.data, 4 - paramInt2, paramInt2);
        seekEntryIdBytes.setPosition(0);
        seekEntryId = ((int)seekEntryIdBytes.readUnsignedInt());
        return;
      case 25506: 
        trackFormat.codecPrivate = new byte[paramInt2];
        paramExtractorInput.readFully(trackFormat.codecPrivate, 0, paramInt2);
        return;
      case 16981: 
        trackFormat.sampleStrippedBytes = new byte[paramInt2];
        paramExtractorInput.readFully(trackFormat.sampleStrippedBytes, 0, paramInt2);
        return;
      case 18402: 
        trackFormat.encryptionKeyId = new byte[paramInt2];
        paramExtractorInput.readFully(trackFormat.encryptionKeyId, 0, paramInt2);
        return;
      }
      if (blockState == 0)
      {
        blockTrackNumber = ((int)varintReader.readUnsignedVarint(paramExtractorInput, false, true));
        blockTrackNumberLength = varintReader.length;
        blockState = 1;
        scratch.reset();
      }
      if (((audioTrackFormat != null) && (videoTrackFormat != null) && (audioTrackFormat.number != blockTrackNumber) && (videoTrackFormat.number != blockTrackNumber)) || ((audioTrackFormat != null) && (videoTrackFormat == null) && (audioTrackFormat.number != blockTrackNumber)) || ((audioTrackFormat == null) && (videoTrackFormat != null) && (videoTrackFormat.number != blockTrackNumber)))
      {
        paramExtractorInput.skipFully(paramInt2 - blockTrackNumberLength);
        blockState = 0;
        return;
      }
      WebmExtractor.TrackFormat localTrackFormat;
      TrackOutput localTrackOutput;
      int i;
      if ((audioTrackFormat != null) && (blockTrackNumber == audioTrackFormat.number))
      {
        localTrackFormat = audioTrackFormat;
        localTrackOutput = trackOutput;
        if (blockState == 1)
        {
          localWebmExtractor.readScratch(paramExtractorInput, 3);
          i = (scratch.data[2] & 0x6) >> 1;
          if (i != 0) {
            break label764;
          }
          blockLacingSampleCount = 1;
          blockLacingSampleSizes = WebmExtractor.ensureArrayCapacity(blockLacingSampleSizes, 1);
          blockLacingSampleSizes[0] = (paramInt2 - blockTrackNumberLength - 3);
          label522:
          paramInt2 = scratch.data[0];
          i = scratch.data[1];
          blockTimeUs = (clusterTimecodeUs + localWebmExtractor.scaleTimecodeToUs(paramInt2 << 8 | i & 0xFF));
          if ((scratch.data[2] & 0x8) != 8) {
            break label1427;
          }
          paramInt2 = 1;
          label593:
          if ((paramInt1 != 163) || ((scratch.data[2] & 0x80) != 128)) {
            break label1432;
          }
          i = 1;
          label623:
          if (i == 0) {
            break label1438;
          }
          i = 1;
          label631:
          if (paramInt2 == 0) {
            break label1444;
          }
        }
      }
      label764:
      label1300:
      label1427:
      label1432:
      label1438:
      label1444:
      for (paramInt2 = 134217728;; paramInt2 = 0)
      {
        blockFlags = (paramInt2 | i);
        blockEncryptionKeyId = encryptionKeyId;
        blockState = 2;
        blockLacingSampleIndex = 0;
        if (paramInt1 != 163) {
          break label1456;
        }
        while (blockLacingSampleIndex < blockLacingSampleCount)
        {
          localWebmExtractor.writeSampleData(paramExtractorInput, localTrackOutput, localTrackFormat, blockLacingSampleSizes[blockLacingSampleIndex]);
          localWebmExtractor.outputSampleMetadata(localTrackOutput, blockTimeUs + blockLacingSampleIndex * defaultSampleDurationNs / 1000);
          blockLacingSampleIndex += 1;
        }
        localTrackFormat = videoTrackFormat;
        break;
        if (paramInt1 != 163) {
          throw new ParserException("Lacing only supported in SimpleBlocks.");
        }
        localWebmExtractor.readScratch(paramExtractorInput, 4);
        blockLacingSampleCount = ((scratch.data[3] & 0xFF) + 1);
        blockLacingSampleSizes = WebmExtractor.ensureArrayCapacity(blockLacingSampleSizes, blockLacingSampleCount);
        if (i == 2)
        {
          paramInt2 = (paramInt2 - blockTrackNumberLength - 4) / blockLacingSampleCount;
          Arrays.fill(blockLacingSampleSizes, 0, blockLacingSampleCount, paramInt2);
          break label522;
        }
        int j;
        int k;
        int m;
        int n;
        int[] arrayOfInt;
        if (i == 1)
        {
          j = 0;
          i = 4;
          k = 0;
          while (k < blockLacingSampleCount - 1)
          {
            blockLacingSampleSizes[k] = 0;
            m = i;
            do
            {
              i = m + 1;
              localWebmExtractor.readScratch(paramExtractorInput, i);
              n = scratch.data[(i - 1)] & 0xFF;
              arrayOfInt = blockLacingSampleSizes;
              arrayOfInt[k] += n;
              m = i;
            } while (n == 255);
            j += blockLacingSampleSizes[k];
            k += 1;
          }
          blockLacingSampleSizes[(blockLacingSampleCount - 1)] = (paramInt2 - blockTrackNumberLength - i - j);
          break label522;
        }
        if (i == 3)
        {
          j = 0;
          i = 4;
          k = 0;
          if (k < blockLacingSampleCount - 1)
          {
            blockLacingSampleSizes[k] = 0;
            n = i + 1;
            localWebmExtractor.readScratch(paramExtractorInput, n);
            if (scratch.data[(n - 1)] == 0) {
              throw new ParserException("No valid varint length mask found");
            }
            long l2 = 0L;
            m = 0;
            long l1;
            for (;;)
            {
              i = n;
              l1 = l2;
              if (m < 8)
              {
                i = 1 << 7 - m;
                if ((scratch.data[(n - 1)] & i) == 0) {
                  break label1300;
                }
                int i1 = n - 1;
                n += m;
                localWebmExtractor.readScratch(paramExtractorInput, n);
                l2 = scratch.data[i1] & 0xFF & (i ^ 0xFFFFFFFF);
                i = i1 + 1;
                while (i < n)
                {
                  l2 = scratch.data[i] & 0xFF | l2 << 8;
                  i += 1;
                }
                i = n;
                l1 = l2;
                if (k > 0)
                {
                  l1 = l2 - ((1L << m * 7 + 6) - 1L);
                  i = n;
                }
              }
              if ((l1 >= -2147483648L) && (l1 <= 2147483647L)) {
                break;
              }
              throw new ParserException("EBML lacing sample size out of range.");
              m += 1;
            }
            m = (int)l1;
            arrayOfInt = blockLacingSampleSizes;
            if (k == 0) {}
            for (;;)
            {
              arrayOfInt[k] = m;
              j += blockLacingSampleSizes[k];
              k += 1;
              break;
              m += blockLacingSampleSizes[(k - 1)];
            }
          }
          blockLacingSampleSizes[(blockLacingSampleCount - 1)] = (paramInt2 - blockTrackNumberLength - i - j);
          break label522;
        }
        throw new IllegalStateException("Unexpected lacing value: " + i);
        paramInt2 = 0;
        break label593;
        i = 0;
        break label623;
        i = 0;
        break label631;
      }
      blockState = 0;
      return;
      label1456:
      localWebmExtractor.writeSampleData(paramExtractorInput, localTrackOutput, localTrackFormat, blockLacingSampleSizes[0]);
    }
    
    public final void endMasterElement(int paramInt)
      throws ParserException
    {
      WebmExtractor localWebmExtractor = WebmExtractor.this;
      switch (paramInt)
      {
      default: 
      case 357149030: 
      case 19899: 
      case 475249515: 
      case 160: 
      case 25152: 
      case 28032: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (timecodeScale == -1L) {
                        timecodeScale = 1000000L;
                      }
                    } while (durationTimecode == -1L);
                    durationUs = localWebmExtractor.scaleTimecodeToUs(durationTimecode);
                    return;
                    if ((seekEntryId == -1) || (seekEntryPosition == -1L)) {
                      throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                    }
                  } while (seekEntryId != 475249515);
                  cuesContentPosition = seekEntryPosition;
                  return;
                } while (cuesState == 2);
                ExtractorOutput localExtractorOutput = extractorOutput;
                if ((segmentContentPosition == -1L) || (durationUs == -1L) || (cueTimesUs == null) || (cueTimesUs.size == 0) || (cueClusterPositions == null) || (cueClusterPositions.size != cueTimesUs.size))
                {
                  cueTimesUs = null;
                  cueClusterPositions = null;
                }
                long[] arrayOfLong1;
                long[] arrayOfLong2;
                long[] arrayOfLong3;
                for (localObject = SeekMap.UNSEEKABLE;; localObject = new ChunkIndex((int[])localObject, arrayOfLong1, arrayOfLong2, arrayOfLong3))
                {
                  localExtractorOutput.seekMap((SeekMap)localObject);
                  cuesState = 2;
                  return;
                  int i = cueTimesUs.size;
                  localObject = new int[i];
                  arrayOfLong1 = new long[i];
                  arrayOfLong2 = new long[i];
                  arrayOfLong3 = new long[i];
                  paramInt = 0;
                  while (paramInt < i)
                  {
                    arrayOfLong3[paramInt] = cueTimesUs.get(paramInt);
                    arrayOfLong1[paramInt] = (segmentContentPosition + cueClusterPositions.get(paramInt));
                    paramInt += 1;
                  }
                  paramInt = 0;
                  while (paramInt < i - 1)
                  {
                    localObject[paramInt] = ((int)(arrayOfLong1[(paramInt + 1)] - arrayOfLong1[paramInt]));
                    arrayOfLong2[paramInt] = (arrayOfLong3[(paramInt + 1)] - arrayOfLong3[paramInt]);
                    paramInt += 1;
                  }
                  localObject[(i - 1)] = ((int)(segmentContentPosition + segmentContentSize - arrayOfLong1[(i - 1)]));
                  arrayOfLong2[(i - 1)] = (durationUs - arrayOfLong3[(i - 1)]);
                  cueTimesUs = null;
                  cueClusterPositions = null;
                }
              } while (blockState != 2);
              if (!sampleSeenReferenceBlock) {
                blockFlags |= 0x1;
              }
              if ((audioTrackFormat != null) && (blockTrackNumber == audioTrackFormat.number)) {}
              for (Object localObject = audioTrackFormat.trackOutput;; localObject = videoTrackFormat.trackOutput)
              {
                localWebmExtractor.outputSampleMetadata((TrackOutput)localObject, blockTimeUs);
                blockState = 0;
                return;
              }
            } while (!trackFormat.hasContentEncryption);
            if (trackFormat.encryptionKeyId == null) {
              throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            }
          } while (sentDrmInitData);
          extractorOutput.drmInitData(new DrmInitData.Universal("video/webm", trackFormat.encryptionKeyId));
          sentDrmInitData = true;
          return;
        } while ((!trackFormat.hasContentEncryption) || (trackFormat.sampleStrippedBytes == null));
        throw new ParserException("Combining encryption and compression is not supported");
      case 174: 
        if ((trackFormat.number == -1) || (trackFormat.type == -1)) {
          throw new ParserException("Mandatory element TrackNumber or TrackType not found");
        }
        if (((trackFormat.type == 2) && (audioTrackFormat != null)) || ((trackFormat.type == 1) && (videoTrackFormat != null)))
        {
          trackFormat = null;
          return;
        }
        if ((trackFormat.type == 2) && (WebmExtractor.isCodecSupported(trackFormat.codecId)))
        {
          audioTrackFormat = trackFormat;
          audioTrackFormat.trackOutput = extractorOutput.track(audioTrackFormat.number);
          audioTrackFormat.trackOutput.format(audioTrackFormat.getMediaFormat(durationUs));
        }
        for (;;)
        {
          trackFormat = null;
          return;
          if ((trackFormat.type == 1) && (WebmExtractor.isCodecSupported(trackFormat.codecId)))
          {
            videoTrackFormat = trackFormat;
            videoTrackFormat.trackOutput = extractorOutput.track(videoTrackFormat.number);
            videoTrackFormat.trackOutput.format(videoTrackFormat.getMediaFormat(durationUs));
          }
        }
      }
      if ((videoTrackFormat == null) && (audioTrackFormat == null)) {
        throw new ParserException("No valid tracks were found");
      }
      extractorOutput.endTracks();
    }
    
    public final void floatElement(int paramInt, double paramDouble)
      throws ParserException
    {
      WebmExtractor localWebmExtractor = WebmExtractor.this;
      switch (paramInt)
      {
      default: 
        return;
      case 17545: 
        durationTimecode = (paramDouble);
        return;
      }
      trackFormat.sampleRate = ((int)paramDouble);
    }
    
    public final int getElementType(int paramInt)
    {
      return WebmExtractor.getElementType(paramInt);
    }
    
    public final void integerElement(int paramInt, long paramLong)
      throws ParserException
    {
      WebmExtractor localWebmExtractor = WebmExtractor.this;
      switch (paramInt)
      {
      default: 
      case 17143: 
      case 17029: 
      case 21420: 
      case 2807729: 
      case 176: 
      case 186: 
      case 215: 
      case 131: 
      case 2352003: 
      case 22186: 
      case 22203: 
      case 159: 
      case 251: 
      case 20529: 
      case 20530: 
      case 16980: 
      case 18401: 
      case 18408: 
      case 179: 
      case 241: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (paramLong == 1L);
                      throw new ParserException("EBMLReadVersion " + paramLong + " not supported");
                    } while ((paramLong >= 1L) && (paramLong <= 2L));
                    throw new ParserException("DocTypeReadVersion " + paramLong + " not supported");
                    seekEntryPosition = (segmentContentPosition + paramLong);
                    return;
                    timecodeScale = paramLong;
                    return;
                    trackFormat.pixelWidth = ((int)paramLong);
                    return;
                    trackFormat.pixelHeight = ((int)paramLong);
                    return;
                    trackFormat.number = ((int)paramLong);
                    return;
                    trackFormat.type = ((int)paramLong);
                    return;
                    trackFormat.defaultSampleDurationNs = ((int)paramLong);
                    return;
                    trackFormat.codecDelayNs = paramLong;
                    return;
                    trackFormat.seekPreRollNs = paramLong;
                    return;
                    trackFormat.channelCount = ((int)paramLong);
                    return;
                    sampleSeenReferenceBlock = true;
                    return;
                  } while (paramLong == 0L);
                  throw new ParserException("ContentEncodingOrder " + paramLong + " not supported");
                } while (paramLong == 1L);
                throw new ParserException("ContentEncodingScope " + paramLong + " not supported");
              } while (paramLong == 3L);
              throw new ParserException("ContentCompAlgo " + paramLong + " not supported");
            } while (paramLong == 5L);
            throw new ParserException("ContentEncAlgo " + paramLong + " not supported");
          } while (paramLong == 1L);
          throw new ParserException("AESSettingsCipherMode " + paramLong + " not supported");
          cueTimesUs.add(localWebmExtractor.scaleTimecodeToUs(paramLong));
          return;
        } while (seenClusterPositionForCurrentCuePoint);
        cueClusterPositions.add(paramLong);
        seenClusterPositionForCurrentCuePoint = true;
        return;
      }
      clusterTimecodeUs = localWebmExtractor.scaleTimecodeToUs(paramLong);
    }
    
    public final void startMasterElement(int paramInt, long paramLong1, long paramLong2)
      throws ParserException
    {
      WebmExtractor localWebmExtractor = WebmExtractor.this;
      switch (paramInt)
      {
      case 25152: 
      default: 
      case 408125543: 
      case 19899: 
      case 475249515: 
      case 187: 
      case 524531317: 
        do
        {
          return;
          if ((segmentContentPosition != -1L) && (segmentContentPosition != paramLong1)) {
            throw new ParserException("Multiple Segment elements not supported");
          }
          segmentContentPosition = paramLong1;
          segmentContentSize = paramLong2;
          return;
          seekEntryId = -1;
          seekEntryPosition = -1L;
          return;
          cueTimesUs = new LongArray();
          cueClusterPositions = new LongArray();
          return;
          seenClusterPositionForCurrentCuePoint = false;
          return;
        } while (cuesState != 0);
        if (cuesContentPosition != -1L)
        {
          seekForCues = true;
          return;
        }
        extractorOutput.seekMap(SeekMap.UNSEEKABLE);
        cuesState = 2;
        return;
      case 160: 
        sampleSeenReferenceBlock = false;
        return;
      case 20533: 
        trackFormat.hasContentEncryption = true;
        return;
      }
      trackFormat = new WebmExtractor.TrackFormat((byte)0);
    }
    
    public final void stringElement(int paramInt, String paramString)
      throws ParserException
    {
      WebmExtractor localWebmExtractor = WebmExtractor.this;
      switch (paramInt)
      {
      default: 
      case 17026: 
        do
        {
          return;
        } while (("webm".equals(paramString)) || ("matroska".equals(paramString)));
        throw new ParserException("DocType " + paramString + " not supported");
      }
      trackFormat.codecId = paramString;
    }
  }
  
  private static final class TrackFormat
  {
    public int channelCount = -1;
    public long codecDelayNs = -1L;
    public String codecId;
    public byte[] codecPrivate;
    public int defaultSampleDurationNs = -1;
    public byte[] encryptionKeyId;
    public boolean hasContentEncryption;
    public int nalUnitLengthFieldLength = -1;
    public int number = -1;
    public int pixelHeight = -1;
    public int pixelWidth = -1;
    public int sampleRate = -1;
    public byte[] sampleStrippedBytes;
    public long seekPreRollNs = -1L;
    public TrackOutput trackOutput;
    public int type = -1;
    
    private static Pair<List<byte[]>, Integer> parseAvcCodecPrivate(ParsableByteArray paramParsableByteArray)
      throws ParserException
    {
      for (;;)
      {
        try
        {
          paramParsableByteArray.setPosition(4);
          int j = (paramParsableByteArray.readUnsignedByte() & 0x3) + 1;
          if (j != 3)
          {
            bool = true;
            Assertions.checkState(bool);
            ArrayList localArrayList = new ArrayList();
            int k = paramParsableByteArray.readUnsignedByte();
            int i = 0;
            if (i < (k & 0x1F))
            {
              localArrayList.add(NalUnitUtil.parseChildNalUnit(paramParsableByteArray));
              i += 1;
              continue;
            }
            k = paramParsableByteArray.readUnsignedByte();
            i = 0;
            if (i < k)
            {
              localArrayList.add(NalUnitUtil.parseChildNalUnit(paramParsableByteArray));
              i += 1;
              continue;
            }
            paramParsableByteArray = Pair.create(localArrayList, Integer.valueOf(j));
            return paramParsableByteArray;
          }
        }
        catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
        {
          throw new ParserException("Error parsing AVC codec private");
        }
        boolean bool = false;
      }
    }
    
    private static Pair<List<byte[]>, Integer> parseHevcCodecPrivate(ParsableByteArray paramParsableByteArray)
      throws ParserException
    {
      for (;;)
      {
        int i;
        int j;
        try
        {
          paramParsableByteArray.setPosition(21);
          int n = paramParsableByteArray.readUnsignedByte();
          int i1 = paramParsableByteArray.readUnsignedByte();
          i = 0;
          int m = position;
          j = 0;
          if (j < i1)
          {
            paramParsableByteArray.skipBytes(1);
            i2 = paramParsableByteArray.readUnsignedShort();
            k = 0;
            if (k >= i2) {
              break label221;
            }
            i3 = paramParsableByteArray.readUnsignedShort();
            i += i3 + 4;
            paramParsableByteArray.skipBytes(i3);
            k += 1;
            continue;
          }
          paramParsableByteArray.setPosition(m);
          arrayOfByte = new byte[i];
          m = 0;
          j = 0;
          if (j >= i1) {
            break label235;
          }
          paramParsableByteArray.skipBytes(1);
          int i2 = paramParsableByteArray.readUnsignedShort();
          int k = 0;
          if (k >= i2) {
            break label228;
          }
          int i3 = paramParsableByteArray.readUnsignedShort();
          System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, arrayOfByte, m, NalUnitUtil.NAL_START_CODE.length);
          m += NalUnitUtil.NAL_START_CODE.length;
          System.arraycopy(data, position, arrayOfByte, m, i3);
          m += i3;
          paramParsableByteArray.skipBytes(i3);
          k += 1;
          continue;
          return Pair.create(paramParsableByteArray, Integer.valueOf((n & 0x3) + 1));
        }
        catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
        {
          byte[] arrayOfByte;
          throw new ParserException("Error parsing HEVC codec private");
        }
        paramParsableByteArray = Collections.singletonList(arrayOfByte);
        continue;
        label221:
        j += 1;
        continue;
        label228:
        j += 1;
        continue;
        label235:
        if (i == 0) {
          paramParsableByteArray = null;
        }
      }
    }
    
    private static List<byte[]> parseVorbisCodecPrivate(byte[] paramArrayOfByte)
      throws ParserException
    {
      if (paramArrayOfByte[0] != 2) {
        try
        {
          throw new ParserException("Error parsing vorbis codec private");
        }
        catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
        {
          throw new ParserException("Error parsing vorbis codec private");
        }
      }
      int j = 0;
      int i = 1;
      while (paramArrayOfByte[i] == -1)
      {
        j += 255;
        i += 1;
      }
      for (;;)
      {
        int k = j + 1;
        j = paramArrayOfByte[j];
        if (paramArrayOfByte[k] != 1) {
          throw new ParserException("Error parsing vorbis codec private");
        }
        byte[] arrayOfByte1 = new byte[m];
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, m);
        k += m;
        if (paramArrayOfByte[k] != 3) {
          throw new ParserException("Error parsing vorbis codec private");
        }
        i = k + (i + j);
        if (paramArrayOfByte[i] != 5) {
          throw new ParserException("Error parsing vorbis codec private");
        }
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i];
        System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, paramArrayOfByte.length - i);
        paramArrayOfByte = new ArrayList(2);
        paramArrayOfByte.add(arrayOfByte1);
        paramArrayOfByte.add(arrayOfByte2);
        return paramArrayOfByte;
        int m = j + paramArrayOfByte[i];
        j = 0;
        k = i + 1;
        i = j;
        j = k;
        while (paramArrayOfByte[j] == -1)
        {
          i += 255;
          j += 1;
        }
      }
    }
    
    public final MediaFormat getMediaFormat(long paramLong)
      throws ParserException
    {
      Object localObject = null;
      int j = -1;
      String str = codecId;
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          throw new ParserException("Unrecognized codec identifier.");
          if (str.equals("V_VP8"))
          {
            i = 0;
            continue;
            if (str.equals("V_VP9"))
            {
              i = 1;
              continue;
              if (str.equals("V_MPEG4/ISO/SP"))
              {
                i = 2;
                continue;
                if (str.equals("V_MPEG4/ISO/ASP"))
                {
                  i = 3;
                  continue;
                  if (str.equals("V_MPEG4/ISO/AP"))
                  {
                    i = 4;
                    continue;
                    if (str.equals("V_MPEG4/ISO/AVC"))
                    {
                      i = 5;
                      continue;
                      if (str.equals("V_MPEGH/ISO/HEVC"))
                      {
                        i = 6;
                        continue;
                        if (str.equals("A_VORBIS"))
                        {
                          i = 7;
                          continue;
                          if (str.equals("A_OPUS"))
                          {
                            i = 8;
                            continue;
                            if (str.equals("A_AAC"))
                            {
                              i = 9;
                              continue;
                              if (str.equals("A_MPEG/L3"))
                              {
                                i = 10;
                                continue;
                                if (str.equals("A_AC3")) {
                                  i = 11;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      str = "video/x-vnd.on2.vp8";
      i = j;
      while (MimeTypes.isAudio(str))
      {
        return MediaFormat.createAudioFormat(str, i, paramLong, channelCount, sampleRate, (List)localObject);
        str = "video/x-vnd.on2.vp9";
        i = j;
        continue;
        str = "video/mp4v-es";
        if (codecPrivate == null) {}
        for (localObject = null;; localObject = Collections.singletonList(codecPrivate))
        {
          i = j;
          break;
        }
        str = "video/avc";
        Pair localPair = parseAvcCodecPrivate(new ParsableByteArray(codecPrivate));
        localObject = (List)first;
        nalUnitLengthFieldLength = ((Integer)second).intValue();
        i = j;
        continue;
        str = "video/hevc";
        localPair = parseHevcCodecPrivate(new ParsableByteArray(codecPrivate));
        localObject = (List)first;
        nalUnitLengthFieldLength = ((Integer)second).intValue();
        i = j;
        continue;
        str = "audio/vorbis";
        i = 8192;
        localObject = parseVorbisCodecPrivate(codecPrivate);
        continue;
        str = "audio/opus";
        i = 5760;
        localObject = new ArrayList(3);
        ((List)localObject).add(codecPrivate);
        ((List)localObject).add(ByteBuffer.allocate(64).putLong(codecDelayNs).array());
        ((List)localObject).add(ByteBuffer.allocate(64).putLong(seekPreRollNs).array());
        continue;
        str = "audio/mp4a-latm";
        localObject = Collections.singletonList(codecPrivate);
        i = j;
        continue;
        i = 4096;
        str = "audio/mpeg";
        continue;
        str = "audio/ac3";
        i = j;
      }
      if (MimeTypes.isVideo(str)) {
        return MediaFormat.createVideoFormat(str, i, paramLong, pixelWidth, pixelHeight, 1.0F, (List)localObject);
      }
      throw new ParserException("Unexpected MIME type.");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.webm.WebmExtractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */