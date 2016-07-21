package com.google.android.exoplayer.hls;

public final class HlsMediaPlaylist$Segment
  implements Comparable<Long>
{
  public final int byterangeLength;
  public final int byterangeOffset;
  public final boolean discontinuity;
  public final double durationSecs;
  public final String encryptionIV;
  public final String encryptionKeyUri;
  public final boolean isEncrypted;
  public final long startTimeUs;
  public final String url;
  
  public HlsMediaPlaylist$Segment(String paramString1, double paramDouble, boolean paramBoolean1, long paramLong, boolean paramBoolean2, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    url = paramString1;
    durationSecs = paramDouble;
    discontinuity = paramBoolean1;
    startTimeUs = paramLong;
    isEncrypted = paramBoolean2;
    encryptionKeyUri = paramString2;
    encryptionIV = paramString3;
    byterangeOffset = paramInt1;
    byterangeLength = paramInt2;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsMediaPlaylist.Segment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */