package com.linkedin.android.feed.shared.following;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.feed.events.FollowRequestedEvent;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import com.linkedin.consistency.DefaultConsistencyListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;

public final class FollowPublisher
{
  final Set<String> activeRequesters = new HashSet();
  private final FlagshipApplication app;
  private final Map<String, ConsistencyManagerListener> cmListeners = new ArrayMap();
  private final ConsistencyManager consistencyManager;
  private final FlagshipDataManager dataManager;
  final Map<String, FollowToggleRequester> followRequesters = new ArrayMap();
  
  public FollowPublisher(FlagshipApplication paramFlagshipApplication, FlagshipDataManager paramFlagshipDataManager, ConsistencyManager paramConsistencyManager)
  {
    app = paramFlagshipApplication;
    dataManager = paramFlagshipDataManager;
    consistencyManager = paramConsistencyManager;
    Bus.subscribe(this);
  }
  
  @Subscribe
  public final void onEvent(FollowRequestedEvent paramFollowRequestedEvent)
  {
    toggleFollow(id, route, followingInfo, trackingHeader);
  }
  
  public final void toggleFollow(String paramString, Routes paramRoutes, FollowingInfo paramFollowingInfo, Map<String, String> paramMap)
  {
    final String str = entityUrn.toString();
    Object localObject = (ConsistencyManagerListener)cmListeners.remove(str);
    if (localObject != null) {
      consistencyManager.removeListener((ConsistencyManagerListener)localObject);
    }
    localObject = new DefaultConsistencyListener(paramFollowingInfo) {};
    cmListeners.put(str, localObject);
    consistencyManager.listenForUpdates((ConsistencyManagerListener)localObject);
    FollowToggleRequester localFollowToggleRequester = (FollowToggleRequester)followRequesters.get(str);
    localObject = localFollowToggleRequester;
    if (localFollowToggleRequester == null)
    {
      localObject = new FollowToggleRequester(app, dataManager, paramRoutes, paramString, paramFollowingInfo);
      followRequesters.put(str, localObject);
    }
    activeRequesters.add(str);
    ((FollowToggleRequester)localObject).toggle(paramMap);
    activeRequesters.remove(str);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.following.FollowPublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */