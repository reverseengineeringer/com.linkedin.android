package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.util.Assertions;
import java.util.Comparator;

public final class Format
{
  public final int audioSamplingRate;
  public final int bitrate;
  public final String codecs;
  public final float frameRate;
  public final int height;
  public final String id;
  public final String language;
  public final String mimeType;
  public final int numChannels;
  public final int width;
  
  public Format(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    id = ((String)Assertions.checkNotNull(paramString1));
    mimeType = paramString2;
    width = paramInt1;
    height = paramInt2;
    frameRate = -1.0F;
    numChannels = -1;
    audioSamplingRate = -1;
    bitrate = paramInt3;
    language = null;
    codecs = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    return id.equals(id);
  }
  
  public final int hashCode()
  {
    return id.hashCode();
  }
  
  public static final class DecreasingBandwidthComparator
    implements Comparator<Format>
  {}
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.chunk.Format
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */