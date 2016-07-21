package com.google.android.exoplayer;

import android.text.TextUtils;

final class MediaCodecUtil$CodecKey
{
  public final String mimeType;
  public final boolean secure;
  
  public MediaCodecUtil$CodecKey(String paramString, boolean paramBoolean)
  {
    mimeType = paramString;
    secure = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != CodecKey.class)) {
        return false;
      }
      paramObject = (CodecKey)paramObject;
    } while ((TextUtils.equals(mimeType, mimeType)) && (secure == secure));
    return false;
  }
  
  public final int hashCode()
  {
    int i;
    if (mimeType == null)
    {
      i = 0;
      if (!secure) {
        break label41;
      }
    }
    label41:
    for (int j = 1231;; j = 1237)
    {
      return j + (i + 31) * 31;
      i = mimeType.hashCode();
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecUtil.CodecKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */