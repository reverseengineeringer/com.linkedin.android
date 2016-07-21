package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.extractor.SeekMap;

abstract interface Mp3Extractor$Seeker
  extends SeekMap
{
  public abstract long getDurationUs();
  
  public abstract long getTimeUs(long paramLong);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp3.Mp3Extractor.Seeker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */