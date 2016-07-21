package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.drm.DrmInitData.Universal;
import com.google.android.exoplayer.extractor.ChunkIndex;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.LongArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

final class WebmExtractor$InnerEbmlReaderOutput
  implements EbmlReaderOutput
{
  private WebmExtractor$InnerEbmlReaderOutput(WebmExtractor paramWebmExtractor) {}
  
  public final void binaryElement(int paramInt1, int paramInt2, ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    WebmExtractor localWebmExtractor = this$0;
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
    WebmExtractor localWebmExtractor = this$0;
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
    WebmExtractor localWebmExtractor = this$0;
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
    WebmExtractor localWebmExtractor = this$0;
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
    WebmExtractor localWebmExtractor = this$0;
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
    WebmExtractor localWebmExtractor = this$0;
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

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.webm.WebmExtractor.InnerEbmlReaderOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */