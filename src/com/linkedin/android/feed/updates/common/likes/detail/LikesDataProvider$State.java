package com.linkedin.android.feed.updates.common.likes.detail;

import com.linkedin.android.feed.utils.FeedCollectionHelper;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;

public final class LikesDataProvider$State
  extends DataProvider.State
{
  FeedCollectionHelper<Like, Metadata> collectionHelper;
  
  public LikesDataProvider$State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDataProvider.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */