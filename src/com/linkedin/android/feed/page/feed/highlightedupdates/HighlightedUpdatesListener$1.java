package com.linkedin.android.feed.page.feed.highlightedupdates;

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
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.lang.ref.WeakReference;
import java.util.List;

final class HighlightedUpdatesListener$1
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  HighlightedUpdatesListener$1(HighlightedUpdatesListener paramHighlightedUpdatesListener, CollectionTemplate paramCollectionTemplate, String paramString, DataStore.Type paramType) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    boolean bool = false;
    FeedFragment localFeedFragment = (FeedFragment)this$0.feedFragmentWeakReference.get();
    if ((localFeedFragment == null) || (!localFeedFragment.isAdded())) {}
    FeedAdapter localFeedAdapter;
    do
    {
      return;
      localFeedAdapter = feedAdapter;
    } while (localFeedAdapter == null);
    if (localFeedAdapter.containsHighlightedUpdates())
    {
      paramModelsData = viewModels;
      highlightedItemViewModels = paramModelsData;
      int i = 0;
      while (i < paramModelsData.size())
      {
        localFeedAdapter.changeViewModel(i, (ViewModel)paramModelsData.get(i));
        i += 1;
      }
      if (highlightedUpdateHelper == null) {
        break label179;
      }
    }
    label179:
    for (paramModelsData = highlightedUpdateHelper;; paramModelsData = null)
    {
      if ((paramModelsData != null) && (val$model.elements != null)) {
        FeedTracking.fireFeedHighLightedUpdateEvent(fragmentComponent, val$model.elements, highlightedUpdateSource, sourceTrackingId);
      }
      if (val$rumSessionId == null) {
        break;
      }
      paramModelsData = val$rumSessionId;
      if (DataStore.Type.NETWORK != val$type) {
        bool = true;
      }
      RUMHelper.callRenderEndOnNextLoop(paramModelsData, bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesListener.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */