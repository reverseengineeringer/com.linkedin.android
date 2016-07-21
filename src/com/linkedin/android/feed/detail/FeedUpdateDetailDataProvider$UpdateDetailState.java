package com.linkedin.android.feed.detail;

import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class FeedUpdateDetailDataProvider$UpdateDetailState
  extends DataProvider.State
{
  public CollectionTemplateHelper<Comment, Metadata> commentsCollectionHelper;
  public String socialDetailRoute;
  public String updateRoute;
  
  public FeedUpdateDetailDataProvider$UpdateDetailState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
  
  public final Comment comment(String paramString)
  {
    return (Comment)getModel(FeedRouteUtils.getSingleCommentUrl(paramString));
  }
  
  public final Update update()
  {
    return (Update)getModel(updateRoute);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider.UpdateDetailState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */