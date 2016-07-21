package com.linkedin.android.feed.aggregate;

import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.consistency.ConsistencyManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AggregateFragment_MembersInjector
  implements MembersInjector<AggregateFragment>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final Provider<ConsistencyManager> consistencyManagerProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<Bus> eventBusProvider;
  private final Provider<FragmentComponent> fragmentComponentProvider;
  private final Provider<MediaCenter> mediaCenterProvider;
  private final MembersInjector<FeedTrackableFragment> supertypeInjector;
  private final Provider<ViewPortManager> viewPortManagerProvider;
  
  static
  {
    if (!AggregateFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AggregateFragment_MembersInjector(MembersInjector<FeedTrackableFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<ActivityComponent> paramProvider1, Provider<FragmentComponent> paramProvider2, Provider<ConsistencyManager> paramProvider3, Provider<FlagshipDataManager> paramProvider4, Provider<MediaCenter> paramProvider5, Provider<ViewPortManager> paramProvider6)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    eventBusProvider = paramProvider;
    assert (paramProvider1 != null);
    activityComponentProvider = paramProvider1;
    assert (paramProvider2 != null);
    fragmentComponentProvider = paramProvider2;
    assert (paramProvider3 != null);
    consistencyManagerProvider = paramProvider3;
    assert (paramProvider4 != null);
    dataManagerProvider = paramProvider4;
    assert (paramProvider5 != null);
    mediaCenterProvider = paramProvider5;
    assert (paramProvider6 != null);
    viewPortManagerProvider = paramProvider6;
  }
  
  public static MembersInjector<AggregateFragment> create(MembersInjector<FeedTrackableFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<ActivityComponent> paramProvider1, Provider<FragmentComponent> paramProvider2, Provider<ConsistencyManager> paramProvider3, Provider<FlagshipDataManager> paramProvider4, Provider<MediaCenter> paramProvider5, Provider<ViewPortManager> paramProvider6)
  {
    return new AggregateFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */