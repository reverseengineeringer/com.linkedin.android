package com.linkedin.android.feed;

import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.widget.Toast;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.utils.FeedCollectionHelper;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.infra.app.CollectionDataProvider;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.collections.CollectionTemplateHelper.CollectionTemplateHelperListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.data.lite.VoidRecord;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

public class FeedUpdatesDataProvider
  extends CollectionDataProvider<State, CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>>>
  implements CollectionTemplateHelper.CollectionTemplateHelperListener<Update>
{
  private static final String TAG = FeedUpdatesDataProvider.class.getSimpleName();
  @Inject
  public ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager;
  
  @Inject
  public FeedUpdatesDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
    boolean bool = "enabled".equals(paramActivityComponent.lixManager().getTreatment(Lix.FEED_COLLECTION_HELPER_COPY_METADATA_AND_PAGING));
    state).collectionHelper = new FeedCollectionHelper(paramActivityComponent.dataManager(), this, Update.BUILDER, Metadata.BUILDER, bool);
  }
  
  private DefaultModelListener<CollectionTemplate<Update, Metadata>> modelListener(final int paramInt, final String paramString)
  {
    new DefaultModelListener()
    {
      public final void onCacheError(DataManagerException paramAnonymousDataManagerException)
      {
        notifyProviderListener(null, DataStore.Type.LOCAL, paramAnonymousDataManagerException, paramInt, paramString);
      }
      
      public final void onNetworkError(DataManagerException paramAnonymousDataManagerException)
      {
        notifyProviderListener(null, DataStore.Type.NETWORK, paramAnonymousDataManagerException, paramInt, paramString);
      }
    };
  }
  
  public final void fetchCrossPromo(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new PromoListener(this, paramString2, paramString3, (byte)0);
    paramString1 = Request.get().url(Routes.crossPromoPath(paramString1)).builder(Promo.BUILDER).listener(paramString2).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    activityComponent.dataManager().submit(paramString1);
  }
  
  public final void loadMoreData$727f7092(Map<String, String> paramMap, String paramString, Uri paramUri)
  {
    String str = null;
    if (state).collectionHelper.getCollectionTemplate() != null) {
      str = state).collectionHelper.getCollectionTemplate().metadata).paginationToken;
    }
    state).collectionHelper.fetchLoadMoreData(paramMap, 0, str, paramUri, modelListener(5, paramString), paramString);
  }
  
  public void notifyProviderListener(CollectionTemplate<Update, Metadata> paramCollectionTemplate, DataStore.Type paramType, DataManagerException paramDataManagerException, int paramInt, String paramString)
  {
    Iterator localIterator = dataListeners.iterator();
    while (localIterator.hasNext())
    {
      CollectionDataProvider.CollectionDataProviderListener localCollectionDataProviderListener = (CollectionDataProvider.CollectionDataProviderListener)localIterator.next();
      switch (paramInt)
      {
      case 6: 
      default: 
        Log.e(TAG, "Unknown request type: " + paramInt);
        break;
      case 2: 
      case 3: 
      case 4: 
        localCollectionDataProviderListener.onInitialFetchFinished(paramCollectionTemplate, paramType, paramDataManagerException, paramString);
        break;
      case 7: 
        localCollectionDataProviderListener.onRefreshFetchFinished(paramCollectionTemplate, paramType, paramDataManagerException, paramString);
        break;
      case 5: 
        localCollectionDataProviderListener.onLoadMoreFetchFinished(paramCollectionTemplate, paramType, paramDataManagerException, paramString);
      }
    }
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
  
  public final void performInitialFetch(Map<String, String> paramMap, int paramInt, String paramString1, String paramString2)
  {
    state).collectionHelper.fetchInitialData(paramMap, paramInt, paramString2, modelListener(paramInt, paramString1), paramString1);
  }
  
  public final void refreshFeed(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    FeedCollectionHelper localFeedCollectionHelper = state).collectionHelper;
    localFeedCollectionHelper.fetchData(paramMap, paramString1, localFeedCollectionHelper.createWrapperModelListener(modelListener(7, paramString2), 7), 7, paramString2);
  }
  
  private static final class PromoListener
    implements RecordTemplateListener<Promo>
  {
    private final WeakReference<FeedUpdatesDataProvider> provider;
    private final String rumSessionId;
    private final String subscriberId;
    
    private PromoListener(FeedUpdatesDataProvider paramFeedUpdatesDataProvider, String paramString1, String paramString2)
    {
      provider = new WeakReference(paramFeedUpdatesDataProvider);
      subscriberId = paramString1;
      rumSessionId = paramString2;
    }
    
    public final void onResponse(DataStoreResponse<Promo> paramDataStoreResponse)
    {
      FeedUpdatesDataProvider localFeedUpdatesDataProvider = (FeedUpdatesDataProvider)provider.get();
      if (localFeedUpdatesDataProvider == null) {}
      do
      {
        return;
        if (error != null)
        {
          ((FeedUpdatesDataProvider.State)state).setError(request.url, error);
          paramDataStoreResponse = new DataErrorEvent(subscriberId, rumSessionId, Collections.singleton(request.url), type, error);
          activityComponent.eventBus();
          Bus.publish(paramDataStoreResponse);
          return;
        }
      } while (model == null);
      Object localObject = (FeedUpdatesDataProvider.State)state;
      String str = request.url;
      ((FeedUpdatesDataProvider.State)localObject).setModel(str, model, subscriberId);
      ((FeedUpdatesDataProvider.State)localObject).getCrossPromoDismissed(str).set(false);
      ((FeedUpdatesDataProvider.State)localObject).getCrossPromoImpressed(str).set(false);
      localObject = new ArrayMap();
      ((Map)localObject).put(request.url, paramDataStoreResponse);
      paramDataStoreResponse = new DataReceivedEvent(subscriberId, rumSessionId, ((Map)localObject).keySet(), type, (Map)localObject);
      activityComponent.eventBus();
      Bus.publish(paramDataStoreResponse);
    }
  }
  
  public static final class State
    extends DataProvider.State
  {
    public FeedCollectionHelper<Update, Metadata> collectionHelper;
    private final Map<String, AtomicBoolean> crossPromoDismissed = new ArrayMap();
    private final Map<String, AtomicBoolean> crossPromoImpressed = new ArrayMap();
    
    public State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
    
    private static AtomicBoolean getFlag(Map<String, AtomicBoolean> paramMap, String paramString)
    {
      String str = Routes.crossPromoPath(paramString);
      AtomicBoolean localAtomicBoolean = (AtomicBoolean)paramMap.get(str);
      paramString = localAtomicBoolean;
      if (localAtomicBoolean == null)
      {
        paramString = new AtomicBoolean(false);
        paramMap.put(str, paramString);
      }
      return paramString;
    }
    
    public final Promo getCrossPromo(String paramString)
    {
      return (Promo)getModel(Routes.crossPromoPath(paramString));
    }
    
    public final AtomicBoolean getCrossPromoDismissed(String paramString)
    {
      return getFlag(crossPromoDismissed, paramString);
    }
    
    public final Throwable getCrossPromoError(String paramString)
    {
      return getError(Routes.crossPromoPath(paramString));
    }
    
    public final AtomicBoolean getCrossPromoImpressed(String paramString)
    {
      return getFlag(crossPromoImpressed, paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedUpdatesDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */