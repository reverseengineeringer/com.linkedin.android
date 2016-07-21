package com.linkedin.android.feed.page.feed;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.ArrayList;
import java.util.List;

final class FeedFragment$11
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  FeedFragment$11(FeedFragment paramFeedFragment) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    if (!this$0.isAdded()) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramModelsData = viewModels;
      int i = 0;
      int j = paramModelsData.size();
      while (i < j)
      {
        FeedUpdateViewModel localFeedUpdateViewModel = (FeedUpdateViewModel)paramModelsData.get(i);
        if (!this$0.feedAdapter.containsUpdate(localFeedUpdateViewModel))
        {
          localArrayList.add(localFeedUpdateViewModel);
          FeedFragment.access$1500(this$0, updateUrn);
        }
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    this$0.feedAdapter.prependValues(localArrayList);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */