package com.linkedin.android.feed.utils;

import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.consistency.ConsistencyManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FeedModule_ProvideUpdateChangeCoordinatorFactory
  implements Factory<UpdateChangeCoordinator>
{
  private final Provider<FlagshipApplication> appProvider;
  private final Provider<ConsistencyManager> consistencyManagerProvider;
  private final FeedModule module;
  
  static
  {
    if (!FeedModule_ProvideUpdateChangeCoordinatorFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedModule_ProvideUpdateChangeCoordinatorFactory(FeedModule paramFeedModule, Provider<FlagshipApplication> paramProvider, Provider<ConsistencyManager> paramProvider1)
  {
    assert (paramFeedModule != null);
    module = paramFeedModule;
    assert (paramProvider != null);
    appProvider = paramProvider;
    assert (paramProvider1 != null);
    consistencyManagerProvider = paramProvider1;
  }
  
  public static Factory<UpdateChangeCoordinator> create(FeedModule paramFeedModule, Provider<FlagshipApplication> paramProvider, Provider<ConsistencyManager> paramProvider1)
  {
    return new FeedModule_ProvideUpdateChangeCoordinatorFactory(paramFeedModule, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule_ProvideUpdateChangeCoordinatorFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */