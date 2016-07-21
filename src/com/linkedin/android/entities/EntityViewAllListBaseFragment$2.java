package com.linkedin.android.entities;

import android.net.Uri;
import android.text.TextUtils;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;

final class EntityViewAllListBaseFragment$2
  extends InfiniteScrollListener
{
  EntityViewAllListBaseFragment$2(EntityViewAllListBaseFragment paramEntityViewAllListBaseFragment, String paramString, CollectionTemplateHelper paramCollectionTemplateHelper) {}
  
  public final void loadMore()
  {
    if ((!TextUtils.isEmpty(val$route)) && (val$collectionHelper.hasMoreDataToFetch()))
    {
      this$0.arrayAdapter.showLoadingView(true);
      EntityViewAllListBaseFragment.DataLoadListener localDataLoadListener = this$0.getDataLoadListener();
      if (localDataLoadListener != null)
      {
        String str = RUMHelper.pageInitLoadMore(this$0);
        val$collectionHelper.fetchLoadMoreData(Tracker.createPageInstanceHeader(this$0.getPageInstance()), 0, null, Uri.parse(val$route), localDataLoadListener, str);
      }
    }
    else
    {
      return;
    }
    this$0.arrayAdapter.showLoadingView(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityViewAllListBaseFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */