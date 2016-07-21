package com.linkedin.android.feed.events;

import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import java.util.Map;

public final class FollowRequestedEvent
{
  public final FollowingInfo followingInfo;
  public final String id;
  public final Routes route;
  public final Map<String, String> trackingHeader;
  
  public FollowRequestedEvent(String paramString, Routes paramRoutes, FollowingInfo paramFollowingInfo, Map<String, String> paramMap)
  {
    id = paramString;
    route = paramRoutes;
    followingInfo = paramFollowingInfo;
    trackingHeader = paramMap;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.FollowRequestedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */