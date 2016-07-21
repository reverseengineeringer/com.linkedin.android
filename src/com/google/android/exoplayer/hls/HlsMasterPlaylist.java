package com.google.android.exoplayer.hls;

import java.util.List;

public final class HlsMasterPlaylist
  extends HlsPlaylist
{
  public final List<Subtitle> subtitles;
  public final List<Variant> variants;
  
  public HlsMasterPlaylist(String paramString, List<Variant> paramList, List<Subtitle> paramList1)
  {
    super(paramString, 0);
    variants = paramList;
    subtitles = paramList1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsMasterPlaylist
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */