package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

final class TsExtractor$PesReader
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
  
  public TsExtractor$PesReader(TsExtractor paramTsExtractor, ElementaryStreamReader paramElementaryStreamReader)
  {
    super((byte)0);
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
              paramExtractorOutput = this$0;
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

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.TsExtractor.PesReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */