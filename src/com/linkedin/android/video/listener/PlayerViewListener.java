package com.linkedin.android.video.listener;

public abstract interface PlayerViewListener
{
  public abstract void onError(Exception paramException);
  
  public abstract void onRenderStart();
  
  public abstract void onStateChanged(boolean paramBoolean, int paramInt);
}

/* Location:
 * Qualified Name:     com.linkedin.android.video.listener.PlayerViewListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */