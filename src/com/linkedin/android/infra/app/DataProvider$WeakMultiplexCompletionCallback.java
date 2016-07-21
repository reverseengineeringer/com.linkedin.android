package com.linkedin.android.infra.app;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexCompletionCallback;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.android.logger.Log;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class DataProvider$WeakMultiplexCompletionCallback<T extends RecordTemplate<T>>
  implements MultiplexCompletionCallback, RecordTemplateListener<T>
{
  private String rumSessionId;
  private String subscriberId;
  private WeakReference<DataProvider> wrapper;
  
  public DataProvider$WeakMultiplexCompletionCallback(DataProvider paramDataProvider, String paramString1, String paramString2)
  {
    wrapper = new WeakReference(paramDataProvider);
    subscriberId = paramString1;
    rumSessionId = paramString2;
  }
  
  public final void onRequestComplete(Map<String, DataStoreResponse> paramMap, DataManagerException paramDataManagerException, DataStore.Type paramType)
  {
    DataProvider localDataProvider = (DataProvider)wrapper.get();
    if (localDataProvider == null) {
      Log.d(DataProvider.access$000(), "Cannot deliver completion callback since the Activity/Fragment was already destroyed");
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
      DataProvider.access$100(localDataProvider).consistencyManager().updateModel((DataTemplate)localObject);
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
      Log.d(DataProvider.access$000(), "Cannot deliver completion callback since the Activity/Fragment was already destroyed");
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

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.DataProvider.WeakMultiplexCompletionCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */