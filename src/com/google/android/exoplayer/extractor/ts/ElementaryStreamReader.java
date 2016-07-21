package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.ParsableByteArray;

abstract class ElementaryStreamReader
{
  protected final TrackOutput output;
  
  protected ElementaryStreamReader(TrackOutput paramTrackOutput)
  {
    output = paramTrackOutput;
  }
  
  public abstract void consume(ParsableByteArray paramParsableByteArray, long paramLong, boolean paramBoolean);
  
  public abstract void packetFinished();
  
  public abstract void seek();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.ElementaryStreamReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */