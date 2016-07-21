package com.linkedin.android.feed;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class FeedUpdatesDataProvider$1
  extends DefaultModelListener<CollectionTemplate<Update, Metadata>>
{
  FeedUpdatesDataProvider$1(FeedUpdatesDataProvider paramFeedUpdatesDataProvider, int paramInt, String paramString) {}
  
  public final void onCacheError(DataManagerException paramDataManagerException)
  {
    this$0.notifyProviderListener(null, DataStore.Type.LOCAL, paramDataManagerException, val$requestType, val$rumSessionId);
  }
  
  public final void onNetworkError(DataManagerException paramDataManagerException)
  {
    this$0.notifyProviderListener(null, DataStore.Type.NETWORK, paramDataManagerException, val$requestType, val$rumSessionId);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedUpdatesDataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */