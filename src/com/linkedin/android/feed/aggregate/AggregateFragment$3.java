package com.linkedin.android.feed.aggregate;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

final class AggregateFragment$3
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  AggregateFragment$3(AggregateFragment paramAggregateFragment) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    if (AggregateFragment.access$100(this$0) == null) {}
    for (;;)
    {
      return;
      if (viewModels.size() > 0)
      {
        int i = 0;
        int j = viewModels.size();
        while (i < j)
        {
          AggregateFragment.access$100(this$0).relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModels.get(i));
          i += 1;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */