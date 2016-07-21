package com.google.android.exoplayer;

import android.media.MediaCodec.CryptoException;

public abstract interface MediaCodecTrackRenderer$EventListener
{
  public abstract void onCryptoError(MediaCodec.CryptoException paramCryptoException);
  
  public abstract void onDecoderInitializationError(MediaCodecTrackRenderer.DecoderInitializationException paramDecoderInitializationException);
  
  public abstract void onDecoderInitialized(String paramString, long paramLong1, long paramLong2);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecTrackRenderer.EventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */