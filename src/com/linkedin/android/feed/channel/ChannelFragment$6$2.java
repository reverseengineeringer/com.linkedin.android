package com.linkedin.android.feed.channel;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class ChannelFragment$6$2
  implements ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  ChannelFragment$6$2(ChannelFragment.6 param6, String paramString, DataStore.Type paramType) {}
  
  public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsData)
  {
    if (!this$1.this$0.isAdded()) {}
    do
    {
      return;
      ChannelFragment.access$100(this$1.this$0).appendValues(viewModels);
    } while (val$rumSessionId == null);
    paramModelsData = val$rumSessionId;
    if (DataStore.Type.NETWORK != val$type) {}
    for (boolean bool = true;; bool = false)
    {
      RUMHelper.callRenderEndOnNextLoop(paramModelsData, bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment.6.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */