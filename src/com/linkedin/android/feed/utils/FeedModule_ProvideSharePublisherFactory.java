package com.linkedin.android.feed.utils;

import android.content.Context;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.consistency.ConsistencyManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FeedModule_ProvideSharePublisherFactory
  implements Factory<FeedSharePublisher>
{
  private final Provider<Bus> busProvider;
  private final Provider<ConsistencyManager> consistencyManagerProvider;
  private final Provider<Context> contextProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<ImageLoaderCache> imageCacheProvider;
  private final Provider<MediaUploader> mediaUploaderProvider;
  private final FeedModule module;
  
  static
  {
    if (!FeedModule_ProvideSharePublisherFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedModule_ProvideSharePublisherFactory(FeedModule paramFeedModule, Provider<Context> paramProvider, Provider<FlagshipDataManager> paramProvider1, Provider<Bus> paramProvider2, Provider<MediaUploader> paramProvider3, Provider<ImageLoaderCache> paramProvider4, Provider<ConsistencyManager> paramProvider5)
  {
    assert (paramFeedModule != null);
    module = paramFeedModule;
    assert (paramProvider != null);
    contextProvider = paramProvider;
    assert (paramProvider1 != null);
    dataManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    busProvider = paramProvider2;
    assert (paramProvider3 != null);
    mediaUploaderProvider = paramProvider3;
    assert (paramProvider4 != null);
    imageCacheProvider = paramProvider4;
    assert (paramProvider5 != null);
    consistencyManagerProvider = paramProvider5;
  }
  
  public static Factory<FeedSharePublisher> create(FeedModule paramFeedModule, Provider<Context> paramProvider, Provider<FlagshipDataManager> paramProvider1, Provider<Bus> paramProvider2, Provider<MediaUploader> paramProvider3, Provider<ImageLoaderCache> paramProvider4, Provider<ConsistencyManager> paramProvider5)
  {
    return new FeedModule_ProvideSharePublisherFactory(paramFeedModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule_ProvideSharePublisherFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */