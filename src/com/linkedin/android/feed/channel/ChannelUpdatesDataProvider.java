package com.linkedin.android.feed.channel;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class ChannelUpdatesDataProvider
  extends FeedUpdatesDataProvider
{
  private static final String TAG = ChannelUpdatesDataProvider.class.getSimpleName();
  String channelId;
  
  @Inject
  public ChannelUpdatesDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  protected final void notifyProviderListener(CollectionTemplate<Update, Metadata> paramCollectionTemplate, DataStore.Type paramType, DataManagerException paramDataManagerException, int paramInt, String paramString)
  {
    Iterator localIterator = dataListeners.iterator();
    while (localIterator.hasNext())
    {
      CollectionDataProvider.CollectionDataProviderListener localCollectionDataProviderListener = (CollectionDataProvider.CollectionDataProviderListener)localIterator.next();
      switch (paramInt)
      {
      case 3: 
      case 4: 
      default: 
        Log.e(TAG, "Unknown request type: " + paramInt);
        break;
      case 2: 
        localCollectionDataProviderListener.onInitialFetchFinished(paramCollectionTemplate, paramType, paramDataManagerException, paramString);
        break;
      case 5: 
        localCollectionDataProviderListener.onLoadMoreFetchFinished(paramCollectionTemplate, paramType, paramDataManagerException, paramString);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelUpdatesDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */