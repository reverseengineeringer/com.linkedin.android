package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.IOException;

public final class TsExtractor
  implements Extractor
{
  final SparseBooleanArray allowedPassthroughStreamTypes;
  final long firstSampleTimestampUs;
  Id3Reader id3Reader;
  private final boolean idrKeyframesOnly;
  long lastPts;
  private ExtractorOutput output;
  final SparseBooleanArray streamTypes;
  long timestampOffsetUs;
  private final ParsableByteArray tsPacketBuffer;
  final SparseArray<TsPayloadReader> tsPayloadReaders;
  private final ParsableBitArray tsScratch;
  
  public TsExtractor()
  {
    this((byte)0);
  }
  
  private TsExtractor(byte paramByte)
  {
    this(0L, null);
  }
  
  public TsExtractor(long paramLong, AudioCapabilities paramAudioCapabilities)
  {
    this(paramLong, paramAudioCapabilities, (byte)0);
  }
  
  private TsExtractor(long paramLong, AudioCapabilities paramAudioCapabilities, byte paramByte)
  {
    firstSampleTimestampUs = paramLong;
    idrKeyframesOnly = true;
    tsScratch = new ParsableBitArray(new byte[3]);
    tsPacketBuffer = new ParsableByteArray(188);
    streamTypes = new SparseBooleanArray();
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    if (paramAudioCapabilities != null)
    {
      if (paramAudioCapabilities.supportsEncoding(5)) {
        localSparseBooleanArray.put(129, true);
      }
      paramAudioCapabilities.supportsEncoding(6);
    }
    allowedPassthroughStreamTypes = localSparseBooleanArray;
    tsPayloadReaders = new SparseArray();
    tsPayloadReaders.put(0, new PatReader());
    lastPts = Long.MIN_VALUE;
  }
  
  public final void init(ExtractorOutput paramExtractorOutput)
  {
    output = paramExtractorOutput;
    paramExtractorOutput.seekMap(SeekMap.UNSEEKABLE);
  }
  
  public final int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException
  {
    int j = 0;
    int i;
    if (!paramExtractorInput.readFully(tsPacketBuffer.data, 0, 188, true)) {
      i = -1;
    }
    boolean bool1;
    do
    {
      int k;
      boolean bool3;
      do
      {
        do
        {
          return i;
          tsPacketBuffer.setPosition(0);
          tsPacketBuffer.setLimit(188);
          i = j;
        } while (tsPacketBuffer.readUnsignedByte() != 71);
        tsPacketBuffer.readBytes(tsScratch, 3);
        tsScratch.skipBits(1);
        bool1 = tsScratch.readBit();
        tsScratch.skipBits(1);
        k = tsScratch.readBits(13);
        tsScratch.skipBits(2);
        boolean bool2 = tsScratch.readBit();
        bool3 = tsScratch.readBit();
        if (bool2)
        {
          i = tsPacketBuffer.readUnsignedByte();
          tsPacketBuffer.skipBytes(i);
        }
        i = j;
      } while (!bool3);
      paramExtractorInput = (TsPayloadReader)tsPayloadReaders.get(k);
      i = j;
    } while (paramExtractorInput == null);
    paramExtractorInput.consume(tsPacketBuffer, bool1, output);
    return 0;
  }
  
  public final void seek()
  {
    timestampOffsetUs = 0L;
    lastPts = Long.MIN_VALUE;
    int i = 0;
    while (i < tsPayloadReaders.size())
    {
      ((TsPayloadReader)tsPayloadReaders.valueAt(i)).seek();
      i += 1;
    }
  }
  
  public final boolean sniff(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    byte[] arrayOfByte = new byte[1];
    int i = 0;
    while (i < 5)
    {
      paramExtractorInput.peekFully(arrayOfByte, 0, 1);
      if ((arrayOfByte[0] & 0xFF) != 71) {
        return false;
      }
      paramExtractorInput.advancePeekPosition(187);
      i += 1;
    }
    return true;
  }
  
  private final class PatReader
    extends TsExtractor.TsPayloadReader
  {
    private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);
    
    public PatReader()
    {
      super();
    }
    
    public final void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean, ExtractorOutput paramExtractorOutput)
    {
      if (paramBoolean) {
        paramParsableByteArray.skipBytes(paramParsableByteArray.readUnsignedByte());
      }
      paramParsableByteArray.readBytes(patScratch, 3);
      patScratch.skipBits(12);
      int i = patScratch.readBits(12);
      paramParsableByteArray.skipBytes(5);
      int j = (i - 9) / 4;
      i = 0;
      while (i < j)
      {
        paramParsableByteArray.readBytes(patScratch, 4);
        patScratch.skipBits(19);
        int k = patScratch.readBits(13);
        tsPayloadReaders.put(k, new TsExtractor.PmtReader(TsExtractor.this));
        i += 1;
      }
    }
    
    public final void seek() {}
  }
  
  private final class PesReader
    extends TsExtractor.TsPayloadReader
  {
    private boolean bodyStarted;
    private int bytesRead;
    private int extendedHeaderLength;
    private int payloadSize;
    private final ElementaryStreamReader pesPayloadReader;
    private final ParsableBitArray pesScratch;
    private boolean ptsFlag;
    private int state;
    private long timeUs;
    
    public PesReader(ElementaryStreamReader paramElementaryStreamReader)
    {
      super();
      pesPayloadReader = paramElementaryStreamReader;
      pesScratch = new ParsableBitArray(new byte[9]);
      state = 0;
    }
    
    private boolean continueRead(ParsableByteArray paramParsableByteArray, byte[] paramArrayOfByte, int paramInt)
    {
      int i = Math.min(paramParsableByteArray.bytesLeft(), paramInt - bytesRead);
      if (i <= 0) {
        return true;
      }
      if (paramArrayOfByte == null) {
        paramParsableByteArray.skipBytes(i);
      }
      for (;;)
      {
        bytesRead += i;
        if (bytesRead == paramInt) {
          break;
        }
        return false;
        paramParsableByteArray.readBytes(paramArrayOfByte, bytesRead, i);
      }
    }
    
    private void setState(int paramInt)
    {
      state = paramInt;
      bytesRead = 0;
    }
    
    public final void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean, ExtractorOutput paramExtractorOutput)
    {
      if (paramBoolean) {
        switch (state)
        {
        case 0: 
        case 1: 
        default: 
          setState(1);
        }
      }
      int i;
      label355:
      long l1;
      long l2;
      for (;;)
      {
        if (paramParsableByteArray.bytesLeft() > 0) {
          switch (state)
          {
          default: 
            break;
          case 0: 
            paramParsableByteArray.skipBytes(paramParsableByteArray.bytesLeft());
            continue;
            Log.w("TsExtractor", "Unexpected start indicator reading extended header");
            break;
            if (payloadSize != -1) {
              Log.w("TsExtractor", "Unexpected start indicator: expected " + payloadSize + " more bytes");
            }
            if (!bodyStarted) {
              break;
            }
            pesPayloadReader.packetFinished();
            break;
          case 1: 
            if (continueRead(paramParsableByteArray, pesScratch.data, 9))
            {
              pesScratch.setPosition$13462e();
              i = pesScratch.readBits(24);
              if (i != 1)
              {
                Log.w("TsExtractor", "Unexpected start code prefix: " + i);
                payloadSize = -1;
                i = 0;
                if (i == 0) {
                  break label355;
                }
              }
              for (i = 2;; i = 0)
              {
                setState(i);
                break;
                pesScratch.skipBits(8);
                i = pesScratch.readBits(16);
                pesScratch.skipBits(8);
                ptsFlag = pesScratch.readBit();
                pesScratch.skipBits(7);
                extendedHeaderLength = pesScratch.readBits(8);
                if (i == 0) {}
                for (payloadSize = -1;; payloadSize = (i + 6 - 9 - extendedHeaderLength))
                {
                  i = 1;
                  break;
                }
              }
            }
            break;
          case 2: 
            i = Math.min(5, extendedHeaderLength);
            if ((continueRead(paramParsableByteArray, pesScratch.data, i)) && (continueRead(paramParsableByteArray, null, extendedHeaderLength)))
            {
              pesScratch.setPosition$13462e();
              timeUs = 0L;
              if (ptsFlag)
              {
                pesScratch.skipBits(4);
                l1 = pesScratch.readBits(3);
                pesScratch.skipBits(1);
                l2 = pesScratch.readBits(15) << 15;
                pesScratch.skipBits(1);
                l2 = pesScratch.readBits(15) | l1 << 30 | l2;
                pesScratch.skipBits(1);
                paramExtractorOutput = TsExtractor.this;
                if (lastPts == Long.MIN_VALUE) {
                  break label784;
                }
                long l3 = (lastPts + 4294967295L) / 8589934591L;
                l1 = 8589934591L * (l3 - 1L) + l2;
                l2 += l3 * 8589934591L;
                if (Math.abs(l1 - lastPts) >= Math.abs(l2 - lastPts)) {
                  break label641;
                }
              }
            }
            break;
          }
        }
      }
      for (;;)
      {
        l2 = 1000000L * l1 / 90000L;
        if (lastPts == Long.MIN_VALUE) {
          timestampOffsetUs = (firstSampleTimestampUs - l2);
        }
        lastPts = l1;
        timeUs = (timestampOffsetUs + l2);
        bodyStarted = false;
        setState(3);
        break;
        label641:
        l1 = l2;
        continue;
        int k = paramParsableByteArray.bytesLeft();
        label665:
        int j;
        if (payloadSize == -1)
        {
          i = 0;
          j = k;
          if (i > 0)
          {
            j = k - i;
            paramParsableByteArray.setLimit(position + j);
          }
          paramExtractorOutput = pesPayloadReader;
          l1 = timeUs;
          if (bodyStarted) {
            break label778;
          }
        }
        label778:
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramExtractorOutput.consume(paramParsableByteArray, l1, paramBoolean);
          bodyStarted = true;
          if (payloadSize == -1) {
            break;
          }
          payloadSize -= j;
          if (payloadSize != 0) {
            break;
          }
          pesPayloadReader.packetFinished();
          setState(1);
          break;
          i = k - payloadSize;
          break label665;
        }
        return;
        label784:
        l1 = l2;
      }
    }
    
    public final void seek()
    {
      state = 0;
      bytesRead = 0;
      bodyStarted = false;
      pesPayloadReader.seek();
    }
  }
  
  private final class PmtReader
    extends TsExtractor.TsPayloadReader
  {
    private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
    
    public PmtReader()
    {
      super();
    }
    
    public final void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean, ExtractorOutput paramExtractorOutput)
    {
      if (paramBoolean) {
        paramParsableByteArray.skipBytes(paramParsableByteArray.readUnsignedByte());
      }
      paramParsableByteArray.readBytes(pmtScratch, 3);
      pmtScratch.skipBits(12);
      int i = pmtScratch.readBits(12);
      paramParsableByteArray.skipBytes(7);
      paramParsableByteArray.readBytes(pmtScratch, 2);
      pmtScratch.skipBits(4);
      int j = pmtScratch.readBits(12);
      paramParsableByteArray.skipBytes(j);
      if (id3Reader == null) {
        id3Reader = new Id3Reader(paramExtractorOutput.track(21));
      }
      i = i - 9 - j - 4;
      while (i > 0)
      {
        paramParsableByteArray.readBytes(pmtScratch, 5);
        int k = pmtScratch.readBits(8);
        pmtScratch.skipBits(3);
        int m = pmtScratch.readBits(13);
        pmtScratch.skipBits(4);
        j = pmtScratch.readBits(12);
        paramParsableByteArray.skipBytes(j);
        j = i - (j + 5);
        i = j;
        if (!streamTypes.get(k))
        {
          Object localObject = null;
          switch (k)
          {
          }
          for (;;)
          {
            i = j;
            if (localObject == null) {
              break;
            }
            streamTypes.put(k, true);
            tsPayloadReaders.put(m, new TsExtractor.PesReader(TsExtractor.this, (ElementaryStreamReader)localObject));
            i = j;
            break;
            localObject = new MpegAudioReader(paramExtractorOutput.track(3));
            continue;
            localObject = new MpegAudioReader(paramExtractorOutput.track(4));
            continue;
            localObject = new AdtsReader(paramExtractorOutput.track(15));
            continue;
            i = j;
            if (!allowedPassthroughStreamTypes.get(k)) {
              break;
            }
            localObject = new Ac3Reader(paramExtractorOutput.track(k));
            continue;
            localObject = new H264Reader(paramExtractorOutput.track(27), new SeiReader(paramExtractorOutput.track(256)), idrKeyframesOnly);
            continue;
            localObject = new H265Reader(paramExtractorOutput.track(36), new SeiReader(paramExtractorOutput.track(256)));
            continue;
            localObject = id3Reader;
          }
        }
      }
      paramExtractorOutput.endTracks();
    }
    
    public final void seek() {}
  }
  
  private static abstract class TsPayloadReader
  {
    public abstract void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean, ExtractorOutput paramExtractorOutput);
    
    public abstract void seek();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.TsExtractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */