package com.linkedin.android.feed.shared.videoviewer;

public abstract interface VideoControl$MediaPlayerControl
{
  public abstract int getBufferPercentage();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void start();
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoControl.MediaPlayerControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */