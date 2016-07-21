package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer.ExoPlayerComponent;
import com.google.android.exoplayer.util.Assertions;

public final class MultiTrackChunkSource
  implements ExoPlayer.ExoPlayerComponent, ChunkSource
{
  public final ChunkSource[] allSources;
  private boolean enabled;
  private ChunkSource selectedSource;
  
  public final void handleMessage(int paramInt, Object paramObject)
    throws ExoPlaybackException
  {
    if (!enabled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      if (paramInt == 1) {
        selectedSource = allSources[((Integer)paramObject).intValue()];
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.chunk.MultiTrackChunkSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */