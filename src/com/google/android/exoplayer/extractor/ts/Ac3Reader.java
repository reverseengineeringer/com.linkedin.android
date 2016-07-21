package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Ac3Util;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

final class Ac3Reader
  extends ElementaryStreamReader
{
  private int bitrate;
  private int bytesRead;
  private long frameDurationUs;
  private final ParsableBitArray headerScratchBits = new ParsableBitArray(new byte[8]);
  private final ParsableByteArray headerScratchBytes = new ParsableByteArray(headerScratchBits.data);
  private boolean lastByteWas0B;
  private MediaFormat mediaFormat;
  private int sampleSize;
  private int state = 0;
  private long timeUs;
  
  public Ac3Reader(TrackOutput paramTrackOutput)
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
      int i;
      switch (state)
      {
      default: 
        break;
      case 0: 
        if (paramParsableByteArray.bytesLeft() > 0)
        {
          if (!lastByteWas0B)
          {
            if (paramParsableByteArray.readUnsignedByte() == 11) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              lastByteWas0B = paramBoolean;
              break;
            }
          }
          i = paramParsableByteArray.readUnsignedByte();
          if (i == 119) {
            lastByteWas0B = false;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          state = 1;
          headerScratchBytes.data[0] = 11;
          headerScratchBytes.data[1] = 119;
          bytesRead = 2;
          break;
          if (i == 11) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            lastByteWas0B = paramBoolean;
            break;
          }
        }
      case 1: 
        byte[] arrayOfByte = headerScratchBytes.data;
        i = Math.min(paramParsableByteArray.bytesLeft(), 8 - bytesRead);
        paramParsableByteArray.readBytes(arrayOfByte, bytesRead, i);
        bytesRead += i;
        if (bytesRead == 8) {}
        for (i = 1; i != 0; i = 0)
        {
          headerScratchBits.setPosition$13462e();
          sampleSize = Ac3Util.parseFrameSize(headerScratchBits);
          if (mediaFormat == null)
          {
            headerScratchBits.setPosition$13462e();
            mediaFormat = Ac3Util.parseFrameAc3Format(headerScratchBits);
            output.format(mediaFormat);
            bitrate = Ac3Util.getBitrate(sampleSize, mediaFormat.sampleRate);
          }
          frameDurationUs = ((int)(8000L * sampleSize / bitrate));
          headerScratchBytes.setPosition(0);
          output.sampleData(headerScratchBytes, 8);
          state = 2;
          break;
        }
      case 2: 
        i = Math.min(paramParsableByteArray.bytesLeft(), sampleSize - bytesRead);
        output.sampleData(paramParsableByteArray, i);
        bytesRead += i;
        if (bytesRead == sampleSize)
        {
          output.sampleMetadata(timeUs, 1, sampleSize, 0, null);
          timeUs += frameDurationUs;
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
    lastByteWas0B = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.Ac3Reader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */