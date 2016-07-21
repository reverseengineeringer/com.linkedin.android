package com.google.android.exoplayer;

public abstract interface ExoPlayer
{
  public abstract void addListener(Listener paramListener);
  
  public abstract void blockingSendMessage$2158118c(ExoPlayerComponent paramExoPlayerComponent, Object paramObject);
  
  public abstract int getBufferedPercentage();
  
  public abstract long getCurrentPosition();
  
  public abstract long getDuration();
  
  public abstract boolean getPlayWhenReady();
  
  public abstract int getPlaybackState();
  
  public abstract boolean getRendererEnabled$134632();
  
  public abstract void prepare(TrackRenderer... paramVarArgs);
  
  public abstract void release();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void sendMessage$2158118c(ExoPlayerComponent paramExoPlayerComponent, Object paramObject);
  
  public abstract void setPlayWhenReady(boolean paramBoolean);
  
  public abstract void setRendererEnabled(int paramInt, boolean paramBoolean);
  
  public abstract void stop();
  
  public static abstract interface ExoPlayerComponent
  {
    public abstract void handleMessage(int paramInt, Object paramObject)
      throws ExoPlaybackException;
  }
  
  public static abstract interface Listener
  {
    public abstract void onPlayWhenReadyCommitted();
    
    public abstract void onPlayerError(ExoPlaybackException paramExoPlaybackException);
    
    public abstract void onPlayerStateChanged(boolean paramBoolean, int paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.ExoPlayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */