package com.linkedin.android.feed.page.feed.newupdatespill;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class NewUpdatesManager$2
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  NewUpdatesManager$2(NewUpdatesManager paramNewUpdatesManager, FragmentComponent paramFragmentComponent, CollectionTemplate paramCollectionTemplate) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    FeatureLog.i("NewUpdatesManager", "updates transformed", "Realtime Feed Updates");
    this$0.storeNewUpdates(val$fragmentComponent, val$feed, inputModels, viewModels);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */