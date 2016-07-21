package com.linkedin.android.feed.channel;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

final class ChannelFragment$6
  extends CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>>
{
  ChannelFragment$6(ChannelFragment paramChannelFragment) {}
  
  public final void onDataFinishedLoading(DataStore.Type paramType, DataManagerException paramDataManagerException) {}
  
  public final void onFetching()
  {
    ChannelFragment.access$100(this$0).showLoadingView(true);
  }
  
  public final void onFinishedFetching()
  {
    ChannelFragment.access$100(this$0).showLoadingView(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */