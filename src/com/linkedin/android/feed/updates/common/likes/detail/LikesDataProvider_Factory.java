package com.linkedin.android.feed.updates.common.likes.detail;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LikesDataProvider_Factory
  implements Factory<LikesDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<LikesDataProvider> membersInjector;
  
  static
  {
    if (!LikesDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LikesDataProvider_Factory(MembersInjector<LikesDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<LikesDataProvider> create(MembersInjector<LikesDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new LikesDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */