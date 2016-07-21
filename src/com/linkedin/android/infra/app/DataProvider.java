package com.linkedin.android.infra.app;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexCompletionCallback;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.CollectionDataEvent;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class DataProvider<STATE extends State, LISTENER extends DataProviderListener>
{
  private static final String TAG = DataProvider.class.getSimpleName();
  public final ActivityComponent activityComponent;
  public final List<LISTENER> dataListeners;
  private final List<BaseFragment> referencingFragments;
  public STATE state;
  
  public DataProvider(ActivityComponent paramActivityComponent)
  {
    activityComponent = paramActivityComponent;
    referencingFragments = new ArrayList();
    dataListeners = new ArrayList();
    state = createStateWrapper();
  }
  
  @Deprecated
  public final void addListener(LISTENER paramLISTENER)
  {
    dataListeners.add(paramLISTENER);
  }
  
  public final <E extends FissileDataModel<E>, M extends FissileDataModel<M>, EMB extends FissileDataModelBuilder<E>, MMB extends FissileDataModelBuilder<M>> RecordTemplateListener<CollectionTemplate<E, M>> collectionCompletionCallback(final String paramString1, final String paramString2, final String paramString3, final int paramInt)
  {
    new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<CollectionTemplate<E, M>> paramAnonymousDataStoreResponse)
      {
        if (!hasReferencingFragments()) {
          return;
        }
        if (error != null)
        {
          state.setError(paramString3, error);
          activityComponent.eventBus();
          Bus.publish(new DataErrorEvent(paramString1, paramString2, Collections.singleton(request.url), type, error));
          return;
        }
        state.setModel(paramString3, model, paramString1);
        CollectionTemplate localCollectionTemplate = (CollectionTemplate)model;
        paramAnonymousDataStoreResponse = new CollectionDataEvent(paramString1, paramString2, paramString3, type, localCollectionTemplate, paramInt);
        activityComponent.eventBus();
        Bus.publish(paramAnonymousDataStoreResponse);
      }
    };
  }
  
  public abstract STATE createStateWrapper();
  
  public final boolean hasReferencingFragments()
  {
    return !referencingFragments.isEmpty();
  }
  
  public final <T extends RecordTemplate<T>> RecordTemplateListener<T> newModelListener(String paramString1, String paramString2)
  {
    return new WeakMultiplexCompletionCallback(this, paramString1, paramString2);
  }
  
  @Deprecated
  public final void notifyListeners(DataStore.Type paramType, DataManagerException paramDataManagerException)
  {
    int i = 0;
    while (i < dataListeners.size())
    {
      ((DataProviderListener)dataListeners.get(i)).onDataFinishedLoading(paramType, paramDataManagerException);
      i += 1;
    }
  }
  
  public final <T extends RecordTemplate<T>> void performFetch(DataTemplateBuilder<T> paramDataTemplateBuilder, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    paramDataTemplateBuilder = Request.get().url(paramString1).builder(paramDataTemplateBuilder).listener(newModelListener(paramString2, paramString3));
    paramDataTemplateBuilder.trackingSessionId(paramString3).customHeaders(paramMap);
    activityComponent.dataManager().submit(paramDataTemplateBuilder);
  }
  
  public final void performMultiplexedFetch(String paramString1, String paramString2, Map<String, String> paramMap, MultiplexRequest.Builder paramBuilder)
  {
    trackingSessionId = paramString2;
    completionCallback = new WeakMultiplexCompletionCallback(this, paramString1, paramString2);
    customHeaders = paramMap;
    activityComponent.dataManager().submit(paramBuilder.build());
  }
  
  public final void register(BaseFragment paramBaseFragment)
  {
    if (!referencingFragments.contains(paramBaseFragment)) {
      referencingFragments.add(paramBaseFragment);
    }
  }
  
  @Deprecated
  public final void removeListener(LISTENER paramLISTENER)
  {
    dataListeners.remove(paramLISTENER);
  }
  
  public final void unregister(BaseFragment paramBaseFragment)
  {
    referencingFragments.remove(paramBaseFragment);
    if (referencingFragments.size() == 0)
    {
      paramBaseFragment = state;
      errors.clear();
      int i = 0;
      while (i < modelListenerMap.keySet().size())
      {
        dataManager.removeListener((ConsistencyManagerListener)modelListenerMap.get(Integer.valueOf(i)));
        i += 1;
      }
      modelListenerMap.clear();
      dataListeners.clear();
      state = createStateWrapper();
    }
  }
  
  private static final class DataProviderDefaultConsistencyListener<T extends DataTemplate<T>>
    extends DefaultConsistencyListener<T>
  {
    public DataProviderDefaultConsistencyListener(T paramT)
    {
      super();
    }
    
    public final void safeModelUpdated(DataTemplate paramDataTemplate) {}
  }
  
  @Deprecated
  public static abstract interface DataProviderListener
  {
    public abstract void onDataFinishedLoading(DataStore.Type paramType, DataManagerException paramDataManagerException);
  }
  
  public static class State
  {
    public final Bus bus;
    public final FlagshipDataManager dataManager;
    public final Map<String, Throwable> errors;
    public final ArrayMap<String, DefaultConsistencyListener> modelListenerMap;
    
    public State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      dataManager = paramFlagshipDataManager;
      bus = paramBus;
      errors = new ArrayMap();
      modelListenerMap = new ArrayMap();
    }
    
    public final void clearModel(String paramString)
    {
      modelListenerMap.remove(paramString);
    }
    
    public DefaultConsistencyListener createConsistencyListener(RecordTemplate paramRecordTemplate, String paramString1, String paramString2)
    {
      return new DataProvider.DataProviderDefaultConsistencyListener(paramRecordTemplate);
    }
    
    public Throwable getError(String paramString)
    {
      return (Throwable)errors.get(paramString);
    }
    
    public final <T> T getModel(String paramString)
    {
      paramString = (DefaultConsistencyListener)modelListenerMap.get(paramString);
      if (paramString != null) {
        return currentModel;
      }
      return null;
    }
    
    public final void setError(String paramString, Throwable paramThrowable)
    {
      errors.put(paramString, paramThrowable);
    }
    
    public final void setModel(String paramString1, RecordTemplate paramRecordTemplate, String paramString2)
    {
      Object localObject = (DefaultConsistencyListener)modelListenerMap.get(paramString1);
      if (localObject != null) {
        dataManager.removeListener((ConsistencyManagerListener)localObject);
      }
      if (paramRecordTemplate == null) {}
      for (;;)
      {
        return;
        localObject = createConsistencyListener(paramRecordTemplate, paramString1, paramString2);
        modelListenerMap.put(paramString1, localObject);
        dataManager.consistencyManager.listenForUpdates((ConsistencyManagerListener)localObject);
        if ((paramRecordTemplate instanceof CollectionTemplate))
        {
          paramString1 = (CollectionTemplate)paramRecordTemplate;
          if (elements != null)
          {
            paramString1 = elements.iterator();
            while (paramString1.hasNext())
            {
              paramRecordTemplate = (RecordTemplate)paramString1.next();
              localObject = paramRecordTemplate.id();
              if (localObject != null) {
                setModel((String)localObject, paramRecordTemplate, paramString2);
              }
            }
          }
        }
      }
    }
    
    public final void setModels(Map<String, DataStoreResponse> paramMap, String paramString)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        setModel((String)localEntry.getKey(), getValuemodel, paramString);
      }
    }
  }
  
  private static final class WeakMultiplexCompletionCallback<T extends RecordTemplate<T>>
    implements MultiplexCompletionCallback, RecordTemplateListener<T>
  {
    private String rumSessionId;
    private String subscriberId;
    private WeakReference<DataProvider> wrapper;
    
    public WeakMultiplexCompletionCallback(DataProvider paramDataProvider, String paramString1, String paramString2)
    {
      wrapper = new WeakReference(paramDataProvider);
      subscriberId = paramString1;
      rumSessionId = paramString2;
    }
    
    public final void onRequestComplete(Map<String, DataStoreResponse> paramMap, DataManagerException paramDataManagerException, DataStore.Type paramType)
    {
      DataProvider localDataProvider = (DataProvider)wrapper.get();
      if (localDataProvider == null) {
        Log.d(DataProvider.TAG, "Cannot deliver completion callback since the Activity/Fragment was already destroyed");
      }
      while (!localDataProvider.hasReferencingFragments()) {
        return;
      }
      Object localObject;
      if (paramDataManagerException != null)
      {
        localObject = paramMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          state.setError(str, paramDataManagerException);
        }
        localDataProvider.notifyListeners(paramType, paramDataManagerException);
        activityComponent.eventBus();
        Bus.publish(new DataErrorEvent(subscriberId, rumSessionId, paramMap.keySet(), paramType, paramDataManagerException));
        return;
      }
      state.setModels(paramMap, subscriberId);
      paramDataManagerException = paramMap.values().iterator();
      while (paramDataManagerException.hasNext())
      {
        localObject = nextmodel;
        activityComponent.consistencyManager().updateModel((DataTemplate)localObject);
      }
      localDataProvider.notifyListeners(paramType, null);
      paramMap = new DataReceivedEvent(subscriberId, rumSessionId, paramMap.keySet(), paramType, paramMap);
      activityComponent.eventBus();
      Bus.publish(paramMap);
    }
    
    public final void onResponse(DataStoreResponse paramDataStoreResponse)
    {
      DataProvider localDataProvider = (DataProvider)wrapper.get();
      if (localDataProvider == null) {
        Log.d(DataProvider.TAG, "Cannot deliver completion callback since the Activity/Fragment was already destroyed");
      }
      while (!localDataProvider.hasReferencingFragments()) {
        return;
      }
      if (error != null)
      {
        state.setError(request.url, error);
        localDataProvider.notifyListeners(type, error);
        activityComponent.eventBus();
        Bus.publish(new DataErrorEvent(subscriberId, rumSessionId, Collections.singleton(request.url), type, error));
        return;
      }
      state.setModel(request.url, model, subscriberId);
      localDataProvider.notifyListeners(type, null);
      ArrayMap localArrayMap = new ArrayMap();
      localArrayMap.put(request.url, paramDataStoreResponse);
      paramDataStoreResponse = new DataReceivedEvent(subscriberId, rumSessionId, localArrayMap.keySet(), type, localArrayMap);
      activityComponent.eventBus();
      Bus.publish(paramDataStoreResponse);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.DataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */