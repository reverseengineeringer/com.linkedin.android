package com.linkedin.android.feed.page.feed;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class BaseFeedFragment$4
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  BaseFeedFragment$4(BaseFeedFragment paramBaseFeedFragment, FeedUpdateViewModel paramFeedUpdateViewModel) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {
      return;
    }
    ((FeedUpdateViewModel)viewModel).onRestoreUpdateViewState(this$0.feedAdapter.getViewState().getState("updateViewState" + viewModel).updateUrn));
    this$0.feedAdapter.changeViewModel(val$originalViewModel, viewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.BaseFeedFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */