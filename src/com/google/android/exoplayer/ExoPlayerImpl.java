package com.google.android.exoplayer;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ExoPlayerImpl
  implements ExoPlayer
{
  private final Handler eventHandler;
  private final ExoPlayerImplInternal internalPlayer;
  final CopyOnWriteArraySet<ExoPlayer.Listener> listeners;
  int pendingPlayWhenReadyAcks;
  boolean playWhenReady;
  int playbackState;
  private final boolean[] rendererEnabledFlags;
  final boolean[] rendererHasMediaFlags;
  
  @SuppressLint({"HandlerLeak"})
  public ExoPlayerImpl(int paramInt1, int paramInt2)
  {
    Log.i("ExoPlayerImpl", "Init 1.4.2");
    playWhenReady = false;
    playbackState = 1;
    listeners = new CopyOnWriteArraySet();
    rendererHasMediaFlags = new boolean[5];
    rendererEnabledFlags = new boolean[5];
    int i = 0;
    while (i < rendererEnabledFlags.length)
    {
      rendererEnabledFlags[i] = true;
      i += 1;
    }
    eventHandler = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        Object localObject = ExoPlayerImpl.this;
        switch (what)
        {
        }
        for (;;)
        {
          return;
          boolean[] arrayOfBoolean = (boolean[])obj;
          System.arraycopy(arrayOfBoolean, 0, rendererHasMediaFlags, 0, arrayOfBoolean.length);
          playbackState = arg1;
          paramAnonymousMessage = listeners.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((ExoPlayer.Listener)paramAnonymousMessage.next()).onPlayerStateChanged(playWhenReady, playbackState);
          }
          continue;
          playbackState = arg1;
          paramAnonymousMessage = listeners.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((ExoPlayer.Listener)paramAnonymousMessage.next()).onPlayerStateChanged(playWhenReady, playbackState);
          }
          continue;
          pendingPlayWhenReadyAcks -= 1;
          if (pendingPlayWhenReadyAcks == 0)
          {
            paramAnonymousMessage = listeners.iterator();
            while (paramAnonymousMessage.hasNext()) {
              ((ExoPlayer.Listener)paramAnonymousMessage.next()).onPlayWhenReadyCommitted();
            }
            continue;
            paramAnonymousMessage = (ExoPlaybackException)obj;
            localObject = listeners.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((ExoPlayer.Listener)((Iterator)localObject).next()).onPlayerError(paramAnonymousMessage);
            }
          }
        }
      }
    };
    internalPlayer = new ExoPlayerImplInternal(eventHandler, playWhenReady, rendererEnabledFlags, paramInt1, paramInt2);
  }
  
  public final void addListener(ExoPlayer.Listener paramListener)
  {
    listeners.add(paramListener);
  }
  
  public final void blockingSendMessage$2158118c(ExoPlayer.ExoPlayerComponent paramExoPlayerComponent, Object paramObject)
  {
    internalPlayer.blockingSendMessage$2158118c(paramExoPlayerComponent, paramObject);
  }
  
  public final int getBufferedPercentage()
  {
    ExoPlayerImplInternal localExoPlayerImplInternal = internalPlayer;
    if (bufferedPositionUs == -1L) {}
    long l2;
    for (long l1 = -1L;; l1 = bufferedPositionUs / 1000L)
    {
      l2 = getDuration();
      if ((l1 != -1L) && (l2 != -1L)) {
        break;
      }
      return 0;
    }
    if (l2 == 0L) {}
    for (l1 = 100L;; l1 = l1 * 100L / l2) {
      return (int)l1;
    }
  }
  
  public final long getCurrentPosition()
  {
    return internalPlayer.positionUs / 1000L;
  }
  
  public final long getDuration()
  {
    ExoPlayerImplInternal localExoPlayerImplInternal = internalPlayer;
    if (durationUs == -1L) {
      return -1L;
    }
    return durationUs / 1000L;
  }
  
  public final boolean getPlayWhenReady()
  {
    return playWhenReady;
  }
  
  public final int getPlaybackState()
  {
    return playbackState;
  }
  
  public final boolean getRendererEnabled$134632()
  {
    return rendererEnabledFlags[1];
  }
  
  public final void prepare(TrackRenderer... paramVarArgs)
  {
    Arrays.fill(rendererHasMediaFlags, false);
    internalPlayer.handler.obtainMessage(1, paramVarArgs).sendToTarget();
  }
  
  public final void release()
  {
    internalPlayer.release();
    eventHandler.removeCallbacksAndMessages(null);
  }
  
  public final void seekTo(long paramLong)
  {
    internalPlayer.handler.obtainMessage(6, Long.valueOf(paramLong)).sendToTarget();
  }
  
  public final void sendMessage$2158118c(ExoPlayer.ExoPlayerComponent paramExoPlayerComponent, Object paramObject)
  {
    ExoPlayerImplInternal localExoPlayerImplInternal = internalPlayer;
    customMessagesSent += 1;
    handler.obtainMessage(9, 1, 0, Pair.create(paramExoPlayerComponent, paramObject)).sendToTarget();
  }
  
  public final void setPlayWhenReady(boolean paramBoolean)
  {
    if (playWhenReady != paramBoolean)
    {
      playWhenReady = paramBoolean;
      pendingPlayWhenReadyAcks += 1;
      Object localObject = internalPlayer.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(3, i, 0).sendToTarget();
        localObject = listeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ExoPlayer.Listener)((Iterator)localObject).next()).onPlayerStateChanged(paramBoolean, playbackState);
        }
      }
    }
  }
  
  public final void setRendererEnabled(int paramInt, boolean paramBoolean)
  {
    Handler localHandler;
    if (rendererEnabledFlags[paramInt] != paramBoolean)
    {
      rendererEnabledFlags[paramInt] = paramBoolean;
      localHandler = internalPlayer.handler;
      if (!paramBoolean) {
        break label45;
      }
    }
    label45:
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(8, paramInt, i).sendToTarget();
      return;
    }
  }
  
  public final void stop()
  {
    internalPlayer.handler.sendEmptyMessage(4);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.ExoPlayerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */