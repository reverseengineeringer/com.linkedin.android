package com.linkedin.android.feed.page.feed;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class FeedFragment$9
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  FeedFragment$9(FeedFragment paramFeedFragment) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {
      return;
    }
    this$0.feedAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */