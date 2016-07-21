package com.linkedin.android.infra.app;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DataProvider$State
{
  public final Bus bus;
  public final FlagshipDataManager dataManager;
  public final Map<String, Throwable> errors;
  public final ArrayMap<String, DefaultConsistencyListener> modelListenerMap;
  
  public DataProvider$State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
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

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.DataProvider.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */