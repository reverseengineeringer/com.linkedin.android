package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatWrapper;

public final class Variant
  implements FormatWrapper
{
  public final Format format;
  public final String url;
  
  public Variant(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, int paramInt4)
  {
    url = paramString1;
    format = new Format(Integer.toString(paramInt1), "application/x-mpegURL", paramInt3, paramInt4, paramInt2, paramString2);
  }
  
  public final Format getFormat()
  {
    return format;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.Variant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */