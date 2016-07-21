package com.linkedin.android.feed.channel;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ChannelUpdatesDataProvider_Factory
  implements Factory<ChannelUpdatesDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<ChannelUpdatesDataProvider> membersInjector;
  
  static
  {
    if (!ChannelUpdatesDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private ChannelUpdatesDataProvider_Factory(MembersInjector<ChannelUpdatesDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<ChannelUpdatesDataProvider> create(MembersInjector<ChannelUpdatesDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new ChannelUpdatesDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelUpdatesDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */