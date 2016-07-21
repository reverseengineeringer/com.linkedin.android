package com.linkedin.android.feed.utils;

import android.content.Context;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.infra.network.NetworkClient;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FeedModule_ProvideSponsoredUpdateTrackerFactory
  implements Factory<SponsoredUpdateTracker>
{
  private final Provider<Context> contextProvider;
  private final FeedModule module;
  private final Provider<NetworkClient> networkClientProvider;
  
  static
  {
    if (!FeedModule_ProvideSponsoredUpdateTrackerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedModule_ProvideSponsoredUpdateTrackerFactory(FeedModule paramFeedModule, Provider<Context> paramProvider, Provider<NetworkClient> paramProvider1)
  {
    assert (paramFeedModule != null);
    module = paramFeedModule;
    assert (paramProvider != null);
    contextProvider = paramProvider;
    assert (paramProvider1 != null);
    networkClientProvider = paramProvider1;
  }
  
  public static Factory<SponsoredUpdateTracker> create(FeedModule paramFeedModule, Provider<Context> paramProvider, Provider<NetworkClient> paramProvider1)
  {
    return new FeedModule_ProvideSponsoredUpdateTrackerFactory(paramFeedModule, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule_ProvideSponsoredUpdateTrackerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */