package com.google.android.exoplayer.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
public abstract interface DrmSessionManager
{
  public abstract Exception getError();
  
  public abstract MediaCrypto getMediaCrypto();
  
  public abstract int getState();
  
  public abstract boolean requiresSecureDecoderComponent$552c4dfd();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.drm.DrmSessionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */