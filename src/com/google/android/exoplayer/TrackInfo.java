package com.google.android.exoplayer;

public final class TrackInfo
{
  public final long durationUs;
  public final String mimeType;
  
  public TrackInfo(String paramString, long paramLong)
  {
    mimeType = paramString;
    durationUs = paramLong;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.TrackInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */