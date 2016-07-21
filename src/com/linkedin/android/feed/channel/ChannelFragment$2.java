package com.linkedin.android.feed.channel;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class ChannelFragment$2
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  ChannelFragment$2(ChannelFragment paramChannelFragment, FeedUpdateViewModel paramFeedUpdateViewModel) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {
      return;
    }
    ((FeedUpdateViewModel)viewModel).onRestoreUpdateViewState(ChannelFragment.access$100(this$0).getViewState().getState("updateViewState" + viewModel).updateUrn));
    ChannelFragment.access$100(this$0).changeViewModel(val$originalViewModel, viewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */