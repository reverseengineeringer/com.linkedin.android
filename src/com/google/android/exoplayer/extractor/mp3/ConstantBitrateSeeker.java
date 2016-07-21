package com.google.android.exoplayer.extractor.mp3;

final class ConstantBitrateSeeker
  implements Mp3Extractor.Seeker
{
  private final int bitrate;
  private final long durationUs;
  private final long firstFramePosition;
  
  public ConstantBitrateSeeker(long paramLong1, int paramInt, long paramLong2)
  {
    firstFramePosition = paramLong1;
    bitrate = paramInt;
    if (paramLong2 == -1L) {}
    for (paramLong1 = l;; paramLong1 = getTimeUs(paramLong2))
    {
      durationUs = paramLong1;
      return;
    }
  }
  
  public final long getDurationUs()
  {
    return durationUs;
  }
  
  public final long getPosition(long paramLong)
  {
    if (durationUs == -1L) {
      return 0L;
    }
    return firstFramePosition + bitrate * paramLong / 8000000L;
  }
  
  public final long getTimeUs(long paramLong)
  {
    return (paramLong - firstFramePosition) * 1000000L * 8L / bitrate;
  }
  
  public final boolean isSeekable()
  {
    return durationUs != -1L;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp3.ConstantBitrateSeeker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */