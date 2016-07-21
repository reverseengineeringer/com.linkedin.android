package com.linkedin.android.feed.updates.common.likes.detail;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;

final class LikesDetailFragment$5
  extends CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Like, Metadata>>
{
  LikesDetailFragment$5(LikesDetailFragment paramLikesDetailFragment) {}
  
  public final void onDataFinishedLoading(DataStore.Type paramType, DataManagerException paramDataManagerException) {}
  
  public final void onFetching()
  {
    if ((!this$0.isAdded()) || (LikesDetailFragment.access$700(this$0) == null)) {}
    while (!LikesDetailFragment.access$100(this$0)) {
      return;
    }
    LikesDetailFragment.access$700(this$0).showLoadingView(true);
  }
  
  public final void onFinishedFetching()
  {
    if ((!this$0.isAdded()) || (LikesDetailFragment.access$700(this$0) == null)) {}
    while (!LikesDetailFragment.access$100(this$0)) {
      return;
    }
    LikesDetailFragment.access$700(this$0).showLoadingView(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */