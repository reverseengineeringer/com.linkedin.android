package com.linkedin.android.feed.page.feed;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class BaseFeedFragment$3$2
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  BaseFeedFragment$3$2(BaseFeedFragment.3 param3, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    boolean bool = false;
    if (!this$1.this$0.isAdded()) {
      return;
    }
    BaseFeedFragment.access$100(this$1.this$0, false);
    this$1.this$0.displayRefreshUpdates(val$model, viewModels, val$type);
    if (val$rumSessionId != null)
    {
      paramModelsData = val$rumSessionId;
      if (DataStore.Type.NETWORK != val$type) {
        bool = true;
      }
      RUMHelper.callRenderEndOnNextLoop(paramModelsData, bool);
    }
    this$1.this$0.hideErrorView();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.BaseFeedFragment.3.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */