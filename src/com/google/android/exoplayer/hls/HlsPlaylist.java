package com.google.android.exoplayer.hls;

public abstract class HlsPlaylist
{
  public final String baseUri;
  public final int type;
  
  protected HlsPlaylist(String paramString, int paramInt)
  {
    baseUri = paramString;
    type = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsPlaylist
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */