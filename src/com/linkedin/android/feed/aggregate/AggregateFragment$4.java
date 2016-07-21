package com.linkedin.android.feed.aggregate;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class AggregateFragment$4
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  AggregateFragment$4(AggregateFragment paramAggregateFragment) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (AggregateFragment.access$100(this$0) != null) {
      AggregateFragment.access$100(this$0).relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel, inputModel).urn.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */