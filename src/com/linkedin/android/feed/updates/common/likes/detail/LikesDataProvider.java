package com.linkedin.android.feed.updates.common.likes.detail;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.utils.FeedCollectionHelper;
import com.linkedin.android.infra.app.CollectionDataProvider;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper.CollectionTemplateHelperListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public final class LikesDataProvider
  extends CollectionDataProvider<State, CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Like, Metadata>>>
  implements CollectionTemplateHelper.CollectionTemplateHelperListener<Like>
{
  @Inject
  public LikesDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final boolean hasMoreLikes()
  {
    return state).collectionHelper.hasMoreDataToFetch();
  }
  
  public final void initWithCollectionTemplate(ActivityComponent paramActivityComponent, CollectionTemplate<Like, Metadata> paramCollectionTemplate)
  {
    state).collectionHelper = new FeedCollectionHelper(paramActivityComponent.dataManager(), this, paramCollectionTemplate, Like.BUILDER, Metadata.BUILDER);
  }
  
  final DefaultModelListener<CollectionTemplate<Like, Metadata>> modelListener(final boolean paramBoolean)
  {
    new DefaultModelListener()
    {
      public final void onNetworkError(DataManagerException paramAnonymousDataManagerException)
      {
        LikesDataProvider.access$200(LikesDataProvider.this, null, DataStore.Type.NETWORK, paramAnonymousDataManagerException, paramBoolean);
      }
    };
  }
  
  public final void onFetchingData()
  {
    Iterator localIterator = dataListeners.iterator();
    while (localIterator.hasNext()) {
      ((CollectionDataProvider.CollectionDataProviderListener)localIterator.next()).onFetching();
    }
  }
  
  public final void onFinishedFetchingData()
  {
    Iterator localIterator = dataListeners.iterator();
    while (localIterator.hasNext()) {
      ((CollectionDataProvider.CollectionDataProviderListener)localIterator.next()).onFinishedFetching();
    }
  }
  
  public static final class State
    extends DataProvider.State
  {
    FeedCollectionHelper<Like, Metadata> collectionHelper;
    
    public State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */