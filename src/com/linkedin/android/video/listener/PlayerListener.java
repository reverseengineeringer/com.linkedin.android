package com.linkedin.android.video.listener;

public abstract interface PlayerListener
{
  public abstract void onError(Exception paramException);
  
  public abstract void onRenderStart();
  
  public abstract void onRenderStop();
  
  public abstract void onStateChanged(boolean paramBoolean, int paramInt);
  
  public abstract void onVideoSizeChanged(int paramInt1, int paramInt2, float paramFloat);
}

/* Location:
 * Qualified Name:     com.linkedin.android.video.listener.PlayerListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */