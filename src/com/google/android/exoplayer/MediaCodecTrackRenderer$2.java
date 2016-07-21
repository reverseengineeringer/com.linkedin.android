package com.google.android.exoplayer;

import android.media.MediaCodec.CryptoException;

final class MediaCodecTrackRenderer$2
  implements Runnable
{
  MediaCodecTrackRenderer$2(MediaCodecTrackRenderer paramMediaCodecTrackRenderer, MediaCodec.CryptoException paramCryptoException) {}
  
  public final void run()
  {
    this$0.eventListener.onCryptoError(val$e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecTrackRenderer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */