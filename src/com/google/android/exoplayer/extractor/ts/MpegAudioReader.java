package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;

final class MpegAudioReader
  extends ElementaryStreamReader
{
  private int frameBytesRead;
  private long frameDurationUs;
  private int frameSize;
  private boolean hasOutputFormat;
  private final MpegAudioHeader header;
  private final ParsableByteArray headerScratch = new ParsableByteArray(4);
  private boolean lastByteWasFF;
  private int state = 0;
  private long timeUs;
  
  public MpegAudioReader(TrackOutput paramTrackOutput)
  {
    super(paramTrackOutput);
    headerScratch.data[0] = -1;
    header = new MpegAudioHeader();
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
      switch (state)
      {
      default: 
        break;
      case 0: 
        localObject = data;
        i = position;
        int k = limit;
        for (;;)
        {
          if (i >= k) {
            break label191;
          }
          if ((localObject[i] & 0xFF) == 255)
          {
            paramBoolean = true;
            if ((!lastByteWasFF) || ((localObject[i] & 0xE0) != 224)) {
              break label176;
            }
          }
          for (int j = 1;; j = 0)
          {
            lastByteWasFF = paramBoolean;
            if (j == 0) {
              break label182;
            }
            paramParsableByteArray.setPosition(i + 1);
            lastByteWasFF = false;
            headerScratch.data[1] = localObject[i];
            frameBytesRead = 2;
            state = 1;
            break;
            paramBoolean = false;
            break label94;
          }
          i += 1;
        }
        paramParsableByteArray.setPosition(k);
        break;
      case 1: 
        i = Math.min(paramParsableByteArray.bytesLeft(), 4 - frameBytesRead);
        paramParsableByteArray.readBytes(headerScratch.data, frameBytesRead, i);
        frameBytesRead = (i + frameBytesRead);
        if (frameBytesRead >= 4)
        {
          headerScratch.setPosition(0);
          if (!MpegAudioHeader.populateHeader(headerScratch.readInt(), header))
          {
            frameBytesRead = 0;
            state = 1;
          }
          else
          {
            frameSize = header.frameSize;
            if (!hasOutputFormat)
            {
              frameDurationUs = (1000000L * header.samplesPerFrame / header.sampleRate);
              localObject = MediaFormat.createAudioFormat(header.mimeType, 4096, -1L, header.channels, header.sampleRate, null);
              output.format((MediaFormat)localObject);
              hasOutputFormat = true;
            }
            headerScratch.setPosition(0);
            output.sampleData(headerScratch, 4);
            state = 2;
          }
        }
        break;
      case 2: 
        label94:
        label176:
        label182:
        label191:
        i = Math.min(paramParsableByteArray.bytesLeft(), frameSize - frameBytesRead);
        output.sampleData(paramParsableByteArray, i);
        frameBytesRead = (i + frameBytesRead);
        if (frameBytesRead >= frameSize)
        {
          output.sampleMetadata(timeUs, 1, frameSize, 0, null);
          timeUs += frameDurationUs;
          frameBytesRead = 0;
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
    frameBytesRead = 0;
    lastByteWasFF = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.MpegAudioReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */