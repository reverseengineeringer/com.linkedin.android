package com.linkedin.android.feed.updates.common.comment.detail;

import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;

public final class CommentDetailDataProvider$CommentDetailState
  extends DataProvider.State
{
  public CollectionTemplateHelper<Comment, Metadata> commentsCollectionHelper;
  public String singleCommentRoute;
  public String socialDetailRoute;
  
  public CommentDetailDataProvider$CommentDetailState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailDataProvider.CommentDetailState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */