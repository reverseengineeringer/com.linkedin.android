package com.google.android.exoplayer.hls;

import java.util.List;

public final class HlsMediaPlaylist
  extends HlsPlaylist
{
  public final long durationUs;
  public final boolean live;
  public final int mediaSequence;
  public final List<Segment> segments;
  public final int targetDurationSecs;
  public final int version;
  
  public HlsMediaPlaylist(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, List<Segment> paramList)
  {
    super(paramString, 1);
    mediaSequence = paramInt1;
    targetDurationSecs = paramInt2;
    version = paramInt3;
    live = paramBoolean;
    segments = paramList;
    if (!paramList.isEmpty())
    {
      paramString = (Segment)paramList.get(paramList.size() - 1);
      durationUs = (startTimeUs + (durationSecs * 1000000.0D));
      return;
    }
    durationUs = 0L;
  }
  
  public static final class Segment
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
    
    public Segment(String paramString1, double paramDouble, boolean paramBoolean1, long paramLong, boolean paramBoolean2, String paramString2, String paramString3, int paramInt1, int paramInt2)
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
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsMediaPlaylist
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */