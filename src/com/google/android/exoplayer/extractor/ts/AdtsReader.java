package com.google.android.exoplayer.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.Collections;

final class AdtsReader
  extends ElementaryStreamReader
{
  private final ParsableBitArray adtsScratch = new ParsableBitArray(new byte[7]);
  private int bytesRead;
  private long frameDurationUs;
  private boolean hasCrc;
  private boolean hasOutputFormat;
  private boolean lastByteWasFF;
  private int sampleSize;
  private int state = 0;
  private long timeUs;
  
  public AdtsReader(TrackOutput paramTrackOutput)
  {
    super(paramTrackOutput);
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      timeUs = paramLong;
    }
    while (paramParsableByteArray.bytesLeft() > 0)
    {
      Object localObject;
      int i;
      label69:
      label94:
      int j;
      switch (state)
      {
      default: 
        break;
      case 0: 
        localObject = data;
        i = position;
        int k = limit;
        if (i < k) {
          if ((localObject[i] & 0xFF) == 255)
          {
            paramBoolean = true;
            if ((!lastByteWasFF) || (paramBoolean) || ((localObject[i] & 0xF0) != 240)) {
              break label194;
            }
            j = 1;
            lastByteWasFF = paramBoolean;
            if (j == 0) {
              break label206;
            }
            if ((localObject[i] & 0x1) != 0) {
              break label200;
            }
            paramBoolean = true;
            hasCrc = paramBoolean;
            paramParsableByteArray.setPosition(i + 1);
            lastByteWasFF = false;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          bytesRead = 0;
          state = 1;
          break;
          paramBoolean = false;
          break label94;
          j = 0;
          break label124;
          paramBoolean = false;
          break label148;
          i += 1;
          break label69;
          paramParsableByteArray.setPosition(k);
        }
      case 1: 
        if (hasCrc)
        {
          i = 7;
          localObject = adtsScratch.data;
          j = Math.min(paramParsableByteArray.bytesLeft(), i - bytesRead);
          paramParsableByteArray.readBytes((byte[])localObject, bytesRead, j);
          bytesRead += j;
          if (bytesRead != i) {
            break label496;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          adtsScratch.setPosition$13462e();
          if (hasOutputFormat) {
            break label502;
          }
          i = adtsScratch.readBits(2);
          j = adtsScratch.readBits(4);
          adtsScratch.skipBits(1);
          localObject = CodecSpecificDataUtil.buildAacAudioSpecificConfig(i + 1, j, adtsScratch.readBits(3));
          Pair localPair = CodecSpecificDataUtil.parseAacAudioSpecificConfig((byte[])localObject);
          localObject = MediaFormat.createAudioFormat$7493b6ef("audio/mp4a-latm", ((Integer)second).intValue(), ((Integer)first).intValue(), Collections.singletonList(localObject));
          frameDurationUs = (1024000000L / sampleRate);
          output.format((MediaFormat)localObject);
          hasOutputFormat = true;
        }
        for (;;)
        {
          adtsScratch.skipBits(4);
          sampleSize = (adtsScratch.readBits(13) - 2 - 5);
          if (hasCrc) {
            sampleSize -= 2;
          }
          bytesRead = 0;
          state = 2;
          break;
          i = 5;
          break label238;
          i = 0;
          break label298;
          adtsScratch.skipBits(10);
        }
      case 2: 
        label124:
        label148:
        label194:
        label200:
        label206:
        label238:
        label298:
        label496:
        label502:
        i = Math.min(paramParsableByteArray.bytesLeft(), sampleSize - bytesRead);
        output.sampleData(paramParsableByteArray, i);
        bytesRead += i;
        if (bytesRead == sampleSize)
        {
          output.sampleMetadata(timeUs, 1, sampleSize, 0, null);
          timeUs += frameDurationUs;
          bytesRead = 0;
          state = 0;
        }
        break;
      }
    }
  }
  
  public final void packetFinished() {}
  
  public final void seek()
  {
    state = 0;
    bytesRead = 0;
    lastByteWasFF = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.AdtsReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */