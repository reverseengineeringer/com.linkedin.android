package com.linkedin.android.feed.page.feed.newupdatespill;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

final class NewUpdatesManager$3
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  NewUpdatesManager$3(NewUpdatesManager paramNewUpdatesManager) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    FeatureLog.i("NewUpdatesManager", "changed update transformed", "Realtime Feed Updates");
    int i = 0;
    int j = this$0.newUpdates.size();
    while (i < j)
    {
      FeedItemViewModel localFeedItemViewModel = (FeedItemViewModel)this$0.newUpdates.get(i);
      if (((localFeedItemViewModel instanceof FeedUpdateViewModel)) && (Util.safeEquals(updateUrn, viewModel).updateUrn)))
      {
        FeatureLog.i("NewUpdatesManager", "changed update found, replacing", "Realtime Feed Updates");
        this$0.newUpdates.set(i, viewModel);
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesManager.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */