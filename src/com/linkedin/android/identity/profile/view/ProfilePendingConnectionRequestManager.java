package com.linkedin.android.identity.profile.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public final class ProfilePendingConnectionRequestManager
{
  static final Long PENDING_CONNECTION_REQUEST_THRESHOLD_MS = Long.valueOf(TimeUnit.MINUTES.toMillis(10L));
  public Map<String, ProfilePendingConnectionRequestManager.PendingStateWrapper> pendingStates = new HashMap();
  
  private static boolean isValidTimeDifference(Long paramLong1, Long paramLong2)
  {
    return paramLong1.longValue() - paramLong2.longValue() < PENDING_CONNECTION_REQUEST_THRESHOLD_MS.longValue();
  }
  
  public final ProfilePendingConnectionRequestManager.PendingState getPendingState(String paramString)
  {
    ProfilePendingConnectionRequestManager.PendingStateWrapper localPendingStateWrapper = (ProfilePendingConnectionRequestManager.PendingStateWrapper)pendingStates.get(paramString);
    long l = System.currentTimeMillis();
    if (localPendingStateWrapper != null)
    {
      if (isValidTimeDifference(Long.valueOf(l), Long.valueOf(timestamp))) {
        return pendingState;
      }
      pendingStates.remove(paramString);
    }
    return ProfilePendingConnectionRequestManager.PendingState.NO_PENDING_STATE;
  }
  
  public final void setPendingState(String paramString, ProfilePendingConnectionRequestManager.PendingState paramPendingState)
  {
    Iterator localIterator = pendingStates.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!isValidTimeDifference(Long.valueOf(System.currentTimeMillis()), Long.valueOf(getValuetimestamp))) {
        localIterator.remove();
      }
    }
    pendingStates.put(paramString, new ProfilePendingConnectionRequestManager.PendingStateWrapper(System.currentTimeMillis(), paramPendingState));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */