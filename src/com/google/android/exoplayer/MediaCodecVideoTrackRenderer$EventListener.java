package com.google.android.exoplayer;

import android.view.Surface;

public abstract interface MediaCodecVideoTrackRenderer$EventListener
  extends MediaCodecTrackRenderer.EventListener
{
  public abstract void onDrawnToSurface(Surface paramSurface);
  
  public abstract void onDroppedFrames(int paramInt, long paramLong);
  
  public abstract void onVideoSizeChanged(int paramInt1, int paramInt2, float paramFloat);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecVideoTrackRenderer.EventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */