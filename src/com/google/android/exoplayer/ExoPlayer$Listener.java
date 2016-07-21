package com.google.android.exoplayer;

public abstract interface ExoPlayer$Listener
{
  public abstract void onPlayWhenReadyCommitted();
  
  public abstract void onPlayerError(ExoPlaybackException paramExoPlaybackException);
  
  public abstract void onPlayerStateChanged(boolean paramBoolean, int paramInt);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.ExoPlayer.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */