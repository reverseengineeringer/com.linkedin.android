package com.linkedin.android.feed.detail;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class FeedUpdateDetailFragment$4
  extends DefaultModelListener<Update>
{
  FeedUpdateDetailFragment$4(FeedUpdateDetailFragment paramFeedUpdateDetailFragment) {}
  
  public final void onCacheError(DataManagerException paramDataManagerException)
  {
    if (!this$0.isAdded()) {
      return;
    }
    FeedUpdateDetailFragment.access$700(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */