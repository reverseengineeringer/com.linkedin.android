package com.linkedin.android.feed.aggregate;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

final class AggregateFragment$7
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  AggregateFragment$7(AggregateFragment paramAggregateFragment, Update paramUpdate) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    if ((AggregateFragment.access$100(this$0) != null) && (viewModels.size() > 0))
    {
      AggregateFragment.access$300(this$0, (FeedUpdateViewModel)viewModels.get(0), val$update);
      AggregateFragment.access$100(this$0).appendValues(viewModels.subList(1, viewModels.size()));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */