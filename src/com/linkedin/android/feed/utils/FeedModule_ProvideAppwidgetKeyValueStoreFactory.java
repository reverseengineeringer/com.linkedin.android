package com.linkedin.android.feed.utils;

import android.content.Context;
import com.linkedin.android.appwidget.AppWidgetKeyValueStore;
import dagger.internal.Factory;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class FeedModule_ProvideAppwidgetKeyValueStoreFactory
  implements Factory<AppWidgetKeyValueStore>
{
  private final Provider<Context> contextProvider;
  private final Provider<ExecutorService> executorServiceProvider;
  private final FeedModule module;
  
  static
  {
    if (!FeedModule_ProvideAppwidgetKeyValueStoreFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedModule_ProvideAppwidgetKeyValueStoreFactory(FeedModule paramFeedModule, Provider<Context> paramProvider, Provider<ExecutorService> paramProvider1)
  {
    assert (paramFeedModule != null);
    module = paramFeedModule;
    assert (paramProvider != null);
    contextProvider = paramProvider;
    assert (paramProvider1 != null);
    executorServiceProvider = paramProvider1;
  }
  
  public static Factory<AppWidgetKeyValueStore> create(FeedModule paramFeedModule, Provider<Context> paramProvider, Provider<ExecutorService> paramProvider1)
  {
    return new FeedModule_ProvideAppwidgetKeyValueStoreFactory(paramFeedModule, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule_ProvideAppwidgetKeyValueStoreFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */