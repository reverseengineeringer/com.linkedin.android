package com.google.android.exoplayer;

import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class ExoPlayerImpl$1
  extends Handler
{
  ExoPlayerImpl$1(ExoPlayerImpl paramExoPlayerImpl) {}
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject = this$0;
    switch (what)
    {
    }
    for (;;)
    {
      return;
      boolean[] arrayOfBoolean = (boolean[])obj;
      System.arraycopy(arrayOfBoolean, 0, rendererHasMediaFlags, 0, arrayOfBoolean.length);
      playbackState = arg1;
      paramMessage = listeners.iterator();
      while (paramMessage.hasNext()) {
        ((ExoPlayer.Listener)paramMessage.next()).onPlayerStateChanged(playWhenReady, playbackState);
      }
      continue;
      playbackState = arg1;
      paramMessage = listeners.iterator();
      while (paramMessage.hasNext()) {
        ((ExoPlayer.Listener)paramMessage.next()).onPlayerStateChanged(playWhenReady, playbackState);
      }
      continue;
      pendingPlayWhenReadyAcks -= 1;
      if (pendingPlayWhenReadyAcks == 0)
      {
        paramMessage = listeners.iterator();
        while (paramMessage.hasNext()) {
          ((ExoPlayer.Listener)paramMessage.next()).onPlayWhenReadyCommitted();
        }
        continue;
        paramMessage = (ExoPlaybackException)obj;
        localObject = listeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ExoPlayer.Listener)((Iterator)localObject).next()).onPlayerError(paramMessage);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.ExoPlayerImpl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */