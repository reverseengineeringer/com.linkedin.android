package com.linkedin.android.realtime.realtimefrontend;

import com.linkedin.android.pegasus.gen.realtimefrontend.ClientConnection;
import com.linkedin.android.pegasus.gen.realtimefrontend.Heartbeat;
import com.linkedin.data.lite.UnionTemplate;

public final class RealtimeEvent
  implements UnionTemplate<RealtimeEvent>
{
  private volatile int _cachedHashCode = -1;
  public final ClientConnection clientConnectionValue;
  public final DecoratedEvent decoratedEventValue;
  public final boolean hasClientConnectionValue;
  public final boolean hasDecoratedEventValue;
  public final boolean hasHeartbeatValue;
  public final Heartbeat heartbeatValue;
  
  RealtimeEvent(ClientConnection paramClientConnection, Heartbeat paramHeartbeat, DecoratedEvent paramDecoratedEvent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    clientConnectionValue = paramClientConnection;
    heartbeatValue = paramHeartbeat;
    decoratedEventValue = paramDecoratedEvent;
    hasClientConnectionValue = paramBoolean1;
    hasHeartbeatValue = paramBoolean2;
    hasDecoratedEventValue = paramBoolean3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (RealtimeEvent)paramObject;
      if (clientConnectionValue != null)
      {
        if (clientConnectionValue.equals(clientConnectionValue)) {}
      }
      else {
        while (clientConnectionValue != null) {
          return false;
        }
      }
      if (heartbeatValue != null)
      {
        if (heartbeatValue.equals(heartbeatValue)) {}
      }
      else {
        while (heartbeatValue != null) {
          return false;
        }
      }
      if (decoratedEventValue == null) {
        break;
      }
    } while (decoratedEventValue.equals(decoratedEventValue));
    for (;;)
    {
      return false;
      if (decoratedEventValue == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (clientConnectionValue != null)
    {
      i = clientConnectionValue.hashCode();
      if (heartbeatValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = heartbeatValue.hashCode();; j = 0)
    {
      if (decoratedEventValue != null) {
        k = decoratedEventValue.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.realtime.realtimefrontend.RealtimeEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */