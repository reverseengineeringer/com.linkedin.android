package com.linkedin.android.feed.channel;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class ChannelFragment$9
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  ChannelFragment$9(ChannelFragment paramChannelFragment) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {
      return;
    }
    ChannelFragment.access$100(this$0).relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */