package com.linkedin.android.feed.updates.common.likes.detail;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class LikesDetailFragment$2
  extends DefaultModelListener<Update>
{
  LikesDetailFragment$2(LikesDetailFragment paramLikesDetailFragment) {}
  
  public final void onCacheError(DataManagerException paramDataManagerException)
  {
    LikesDetailFragment.access$400(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */