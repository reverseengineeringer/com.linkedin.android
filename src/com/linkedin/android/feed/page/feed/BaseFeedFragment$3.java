package com.linkedin.android.feed.page.feed;

import android.support.v4.widget.SwipeRefreshLayout;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class BaseFeedFragment$3
  extends CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>>
{
  BaseFeedFragment$3(BaseFeedFragment paramBaseFeedFragment) {}
  
  public final void onDataFinishedLoading(DataStore.Type paramType, DataManagerException paramDataManagerException)
  {
    if (!this$0.isActive()) {
      return;
    }
    if ((paramDataManagerException != null) && (paramType == DataStore.Type.NETWORK))
    {
      this$0.showErrorView(paramDataManagerException);
      return;
    }
    this$0.hideErrorView();
  }
  
  public final void onFetching()
  {
    this$0.isDataReady = false;
    if (!this$0.isActive()) {}
    while ((this$0.swipeRefreshLayout == null) || (this$0.swipeRefreshLayout.mRefreshing)) {
      return;
    }
    BaseFeedFragment.access$100(this$0, true);
  }
  
  public final void onFinishedFetching()
  {
    this$0.isDataReady = true;
    if (!this$0.isActive()) {}
    while ((this$0.swipeRefreshLayout == null) || (!this$0.swipeRefreshLayout.mRefreshing)) {
      return;
    }
    this$0.swipeRefreshLayout.setRefreshing(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.BaseFeedFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */