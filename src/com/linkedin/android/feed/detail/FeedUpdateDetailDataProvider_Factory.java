package com.linkedin.android.feed.detail;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FeedUpdateDetailDataProvider_Factory
  implements Factory<FeedUpdateDetailDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<FeedUpdateDetailDataProvider> membersInjector;
  
  static
  {
    if (!FeedUpdateDetailDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedUpdateDetailDataProvider_Factory(MembersInjector<FeedUpdateDetailDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<FeedUpdateDetailDataProvider> create(MembersInjector<FeedUpdateDetailDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new FeedUpdateDetailDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */