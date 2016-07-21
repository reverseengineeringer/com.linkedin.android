package com.linkedin.android.feed.detail;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class FeedUpdateDetailFragment$6
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  FeedUpdateDetailFragment$6(FeedUpdateDetailFragment paramFeedUpdateDetailFragment, int paramInt) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if ((!this$0.isAdded()) || (this$0.detailAdapter == null)) {
      return;
    }
    UpdateDataModel localUpdateDataModel = (UpdateDataModel)dataModel;
    FeedUpdateDetailAdapter localFeedUpdateDetailAdapter = this$0.detailAdapter;
    FeedUpdateViewModel localFeedUpdateViewModel = (FeedUpdateViewModel)viewModel;
    localFeedUpdateDetailAdapter.changeViewModel(0, new FeedComponentListViewModel(viewPool, localFeedUpdateViewModel.getComponents()));
    FeedUpdateDetailFragment.access$1402(this$0, viewModel).controlMenuClickListener);
    if ((localUpdateDataModel instanceof SingleUpdateDataModel)) {
      FeedUpdateDetailFragment.access$1502(this$0, detailTitle);
    }
    FeedUpdateDetailFragment.access$1600(this$0);
    if ((val$updateType == 1) && (FeedUpdateDetailFragment.access$1700(this$0) != null)) {
      FeedUpdateDetailFragment.access$1800$4cc49715(this$0, FeedUpdateDetailFragment.access$1700(this$0));
    }
    FeedUpdateDetailFragment.access$1900(this$0, localUpdateDataModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */