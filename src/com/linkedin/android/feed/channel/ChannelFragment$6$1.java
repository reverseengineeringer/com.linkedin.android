package com.linkedin.android.feed.channel;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

final class ChannelFragment$6$1
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  ChannelFragment$6$1(ChannelFragment.6 param6, DataStore.Type paramType, String paramString) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    boolean bool = false;
    if (!this$1.this$0.isAdded()) {}
    do
    {
      return;
      if ((val$type == DataStore.Type.LOCAL) && (viewModels.size() > 0)) {
        ChannelFragment.access$100(this$1.this$0).showLoadingView(false);
      }
      ChannelFragment.access$100(this$1.this$0).clearViewState();
      ChannelFragment.access$100(this$1.this$0).setValues(viewModels);
    } while (val$rumSessionId == null);
    paramModelsData = val$rumSessionId;
    if (DataStore.Type.NETWORK != val$type) {
      bool = true;
    }
    RUMHelper.callRenderEndOnNextLoop(paramModelsData, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment.6.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */