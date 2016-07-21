package com.linkedin.android.feed.utils;

import android.content.Context;
import dagger.internal.Factory;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class FeedModule_ProvideFeedKeyValueStoreFactory
  implements Factory<FeedKeyValueStore>
{
  private final Provider<Context> contextProvider;
  private final Provider<ExecutorService> executorServiceProvider;
  private final FeedModule module;
  
  static
  {
    if (!FeedModule_ProvideFeedKeyValueStoreFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedModule_ProvideFeedKeyValueStoreFactory(FeedModule paramFeedModule, Provider<Context> paramProvider, Provider<ExecutorService> paramProvider1)
  {
    assert (paramFeedModule != null);
    module = paramFeedModule;
    assert (paramProvider != null);
    contextProvider = paramProvider;
    assert (paramProvider1 != null);
    executorServiceProvider = paramProvider1;
  }
  
  public static Factory<FeedKeyValueStore> create(FeedModule paramFeedModule, Provider<Context> paramProvider, Provider<ExecutorService> paramProvider1)
  {
    return new FeedModule_ProvideFeedKeyValueStoreFactory(paramFeedModule, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule_ProvideFeedKeyValueStoreFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */