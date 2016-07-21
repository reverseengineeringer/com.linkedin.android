package com.linkedin.android.feed.updates.common.likes.detail;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;

final class LikesDataProvider$1
  extends DefaultModelListener<CollectionTemplate<Like, Metadata>>
{
  LikesDataProvider$1(LikesDataProvider paramLikesDataProvider, boolean paramBoolean) {}
  
  public final void onNetworkError(DataManagerException paramDataManagerException)
  {
    LikesDataProvider.access$200(this$0, null, DataStore.Type.NETWORK, paramDataManagerException, val$isLoadMore);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */