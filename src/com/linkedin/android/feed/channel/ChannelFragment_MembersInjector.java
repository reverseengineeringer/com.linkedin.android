package com.linkedin.android.feed.channel;

import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.consistency.ConsistencyManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ChannelFragment_MembersInjector
  implements MembersInjector<ChannelFragment>
{
  private final Provider<ConsistencyManager> consistencyManagerProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<Bus> eventBusProvider;
  private final Provider<FollowPublisher> followPublisherProvider;
  private final Provider<I18NManager> i18NManagerProvider;
  private final MembersInjector<FeedTrackableFragment> supertypeInjector;
  private final Provider<ViewPortManager> viewportManagerProvider;
  
  static
  {
    if (!ChannelFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private ChannelFragment_MembersInjector(MembersInjector<FeedTrackableFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<FollowPublisher> paramProvider1, Provider<FlagshipDataManager> paramProvider2, Provider<ViewPortManager> paramProvider3, Provider<ConsistencyManager> paramProvider4, Provider<I18NManager> paramProvider5)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    eventBusProvider = paramProvider;
    assert (paramProvider1 != null);
    followPublisherProvider = paramProvider1;
    assert (paramProvider2 != null);
    dataManagerProvider = paramProvider2;
    assert (paramProvider3 != null);
    viewportManagerProvider = paramProvider3;
    assert (paramProvider4 != null);
    consistencyManagerProvider = paramProvider4;
    assert (paramProvider5 != null);
    i18NManagerProvider = paramProvider5;
  }
  
  public static MembersInjector<ChannelFragment> create(MembersInjector<FeedTrackableFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<FollowPublisher> paramProvider1, Provider<FlagshipDataManager> paramProvider2, Provider<ViewPortManager> paramProvider3, Provider<ConsistencyManager> paramProvider4, Provider<I18NManager> paramProvider5)
  {
    return new ChannelFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */