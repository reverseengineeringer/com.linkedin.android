package com.linkedin.android.feed.page.feed;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Iterator;
import java.util.List;

final class FeedFragment$10
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  FeedFragment$10(FeedFragment paramFeedFragment) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    if (!this$0.isAdded()) {}
    for (;;)
    {
      return;
      paramModelsData = viewModels.iterator();
      while (paramModelsData.hasNext())
      {
        FeedUpdateViewModel localFeedUpdateViewModel1 = (FeedUpdateViewModel)paramModelsData.next();
        FeedUpdateViewModel localFeedUpdateViewModel2 = this$0.feedAdapter.getUpdateViewModel(updateUrn);
        if (localFeedUpdateViewModel2 != null) {
          this$0.feedAdapter.changeViewModel(localFeedUpdateViewModel2, localFeedUpdateViewModel1);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */