package com.conviva.session;

import com.conviva.api.player.PlayerStateManager.PlayerState;
import com.conviva.internal.StreamerError;
import java.util.Map;

public abstract interface IMonitorNotifier
{
  public abstract void onError(StreamerError paramStreamerError);
  
  public abstract void onMetadata(Map<String, String> paramMap);
  
  public abstract void setBitrateKbps(int paramInt);
  
  public abstract void setPlayerState(PlayerStateManager.PlayerState paramPlayerState);
}

/* Location:
 * Qualified Name:     com.conviva.session.IMonitorNotifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */