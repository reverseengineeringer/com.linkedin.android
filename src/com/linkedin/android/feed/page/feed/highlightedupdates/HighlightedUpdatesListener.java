package com.linkedin.android.feed.page.feed.highlightedupdates;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.page.feed.BaseFeedFragment;
import com.linkedin.android.feed.page.feed.FeedFragment;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.lang.ref.WeakReference;
import java.util.List;

public final class HighlightedUpdatesListener
  extends CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>>
{
  WeakReference<FeedFragment> feedFragmentWeakReference;
  
  public HighlightedUpdatesListener(FeedFragment paramFeedFragment)
  {
    feedFragmentWeakReference = new WeakReference(paramFeedFragment);
  }
  
  public final void onDataFinishedLoading(DataStore.Type paramType, DataManagerException paramDataManagerException) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */