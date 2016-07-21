package com.linkedin.android.feed.utils;

import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.LixManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FeedModule_ProvideCommentPublisherFactory
  implements Factory<CommentPublisher>
{
  private final Provider<Bus> busProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<LixManager> lixManagerProvider;
  private final FeedModule module;
  
  static
  {
    if (!FeedModule_ProvideCommentPublisherFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedModule_ProvideCommentPublisherFactory(FeedModule paramFeedModule, Provider<FlagshipDataManager> paramProvider, Provider<Bus> paramProvider1, Provider<LixManager> paramProvider2)
  {
    assert (paramFeedModule != null);
    module = paramFeedModule;
    assert (paramProvider != null);
    dataManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    busProvider = paramProvider1;
    assert (paramProvider2 != null);
    lixManagerProvider = paramProvider2;
  }
  
  public static Factory<CommentPublisher> create(FeedModule paramFeedModule, Provider<FlagshipDataManager> paramProvider, Provider<Bus> paramProvider1, Provider<LixManager> paramProvider2)
  {
    return new FeedModule_ProvideCommentPublisherFactory(paramFeedModule, paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule_ProvideCommentPublisherFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */