package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.ParsableByteArray;

final class Id3Reader
  extends ElementaryStreamReader
{
  private int sampleSize;
  private long sampleTimeUs;
  private boolean writingSample;
  
  public Id3Reader(TrackOutput paramTrackOutput)
  {
    super(paramTrackOutput);
    paramTrackOutput.format(MediaFormat.createTextFormat("application/id3", -1L));
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      writingSample = true;
      sampleTimeUs = paramLong;
      sampleSize = 0;
    }
    if (writingSample)
    {
      sampleSize += paramParsableByteArray.bytesLeft();
      output.sampleData(paramParsableByteArray, paramParsableByteArray.bytesLeft());
    }
  }
  
  public final void packetFinished()
  {
    output.sampleMetadata(sampleTimeUs, 1, sampleSize, 0, null);
    writingSample = false;
  }
  
  public final void seek()
  {
    writingSample = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.Id3Reader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */