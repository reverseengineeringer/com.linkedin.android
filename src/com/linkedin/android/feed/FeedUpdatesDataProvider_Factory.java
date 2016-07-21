package com.linkedin.android.feed;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FeedUpdatesDataProvider_Factory
  implements Factory<FeedUpdatesDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<FeedUpdatesDataProvider> membersInjector;
  
  static
  {
    if (!FeedUpdatesDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedUpdatesDataProvider_Factory(MembersInjector<FeedUpdatesDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<FeedUpdatesDataProvider> create(MembersInjector<FeedUpdatesDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new FeedUpdatesDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedUpdatesDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */