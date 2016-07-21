package com.google.android.exoplayer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import com.google.android.exoplayer.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MediaFormat
{
  public final int channelCount;
  public final long durationUs;
  public android.media.MediaFormat frameworkMediaFormat;
  private int hashCode;
  public final int height;
  public final List<byte[]> initializationData;
  public int maxHeight;
  public final int maxInputSize;
  public int maxWidth;
  public final String mimeType;
  public final float pixelWidthHeightRatio;
  public final int sampleRate;
  public final int width;
  
  private MediaFormat(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, float paramFloat, int paramInt4, int paramInt5, List<byte[]> paramList)
  {
    mimeType = paramString;
    maxInputSize = paramInt1;
    durationUs = paramLong;
    width = paramInt2;
    height = paramInt3;
    pixelWidthHeightRatio = paramFloat;
    channelCount = paramInt4;
    sampleRate = paramInt5;
    paramString = paramList;
    if (paramList == null) {
      paramString = Collections.emptyList();
    }
    initializationData = paramString;
    maxWidth = -1;
    maxHeight = -1;
  }
  
  public static MediaFormat createAudioFormat(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, List<byte[]> paramList)
  {
    return new MediaFormat(paramString, paramInt1, paramLong, -1, -1, -1.0F, paramInt2, paramInt3, paramList);
  }
  
  public static MediaFormat createAudioFormat$7493b6ef(String paramString, int paramInt1, int paramInt2, List<byte[]> paramList)
  {
    return createAudioFormat(paramString, -1, -1L, paramInt1, paramInt2, paramList);
  }
  
  public static MediaFormat createTextFormat(String paramString, long paramLong)
  {
    return new MediaFormat(paramString, -1, paramLong, -1, -1, -1.0F, -1, -1, null);
  }
  
  public static MediaFormat createVideoFormat(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, float paramFloat, List<byte[]> paramList)
  {
    return new MediaFormat(paramString, paramInt1, paramLong, paramInt2, paramInt3, paramFloat, -1, -1, paramList);
  }
  
  @TargetApi(16)
  private static final void maybeSetIntegerV16(android.media.MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if (paramInt != -1) {
      paramMediaFormat.setInteger(paramString, paramInt);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    return equalsInternal((MediaFormat)paramObject, false);
  }
  
  public final boolean equalsInternal(MediaFormat paramMediaFormat, boolean paramBoolean)
  {
    if ((maxInputSize != maxInputSize) || (width != width) || (height != height) || (pixelWidthHeightRatio != pixelWidthHeightRatio) || ((!paramBoolean) && ((maxWidth != maxWidth) || (maxHeight != maxHeight))) || (channelCount != channelCount) || (sampleRate != sampleRate) || (!Util.areEqual(mimeType, mimeType)) || (initializationData.size() != initializationData.size())) {
      return false;
    }
    int i = 0;
    while (i < initializationData.size())
    {
      if (!Arrays.equals((byte[])initializationData.get(i), (byte[])initializationData.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @TargetApi(16)
  public final android.media.MediaFormat getFrameworkMediaFormatV16()
  {
    if (frameworkMediaFormat == null)
    {
      android.media.MediaFormat localMediaFormat = new android.media.MediaFormat();
      localMediaFormat.setString("mime", mimeType);
      maybeSetIntegerV16(localMediaFormat, "max-input-size", maxInputSize);
      maybeSetIntegerV16(localMediaFormat, "width", width);
      maybeSetIntegerV16(localMediaFormat, "height", height);
      maybeSetIntegerV16(localMediaFormat, "channel-count", channelCount);
      maybeSetIntegerV16(localMediaFormat, "sample-rate", sampleRate);
      float f = pixelWidthHeightRatio;
      if (f != -1.0F) {
        localMediaFormat.setFloat("com.google.android.videos.pixelWidthHeightRatio", f);
      }
      int i = 0;
      while (i < initializationData.size())
      {
        localMediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[])initializationData.get(i)));
        i += 1;
      }
      if (durationUs != -1L) {
        localMediaFormat.setLong("durationUs", durationUs);
      }
      maybeSetMaxDimensionsV16(localMediaFormat);
      frameworkMediaFormat = localMediaFormat;
    }
    return frameworkMediaFormat;
  }
  
  public final int hashCode()
  {
    if (hashCode == 0)
    {
      if (mimeType == null) {}
      int j;
      for (int i = 0;; i = mimeType.hashCode())
      {
        j = (((((((((i + 527) * 31 + maxInputSize) * 31 + width) * 31 + height) * 31 + Float.floatToRawIntBits(pixelWidthHeightRatio)) * 31 + (int)durationUs) * 31 + maxWidth) * 31 + maxHeight) * 31 + channelCount) * 31 + sampleRate;
        i = 0;
        while (i < initializationData.size())
        {
          j = j * 31 + Arrays.hashCode((byte[])initializationData.get(i));
          i += 1;
        }
      }
      hashCode = j;
    }
    return hashCode;
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final void maybeSetMaxDimensionsV16(android.media.MediaFormat paramMediaFormat)
  {
    maybeSetIntegerV16(paramMediaFormat, "max-width", maxWidth);
    maybeSetIntegerV16(paramMediaFormat, "max-height", maxHeight);
  }
  
  public final String toString()
  {
    return "MediaFormat(" + mimeType + ", " + maxInputSize + ", " + width + ", " + height + ", " + pixelWidthHeightRatio + ", " + channelCount + ", " + sampleRate + ", " + durationUs + ", " + maxWidth + ", " + maxHeight + ")";
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */