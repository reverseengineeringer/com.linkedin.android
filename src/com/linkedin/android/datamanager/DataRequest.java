package com.linkedin.android.datamanager;

import com.linkedin.android.datamanager.interfaces.DataStore;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.data.lite.RecordTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class DataRequest<RESPONSE extends RecordTemplate<RESPONSE>>
{
  public final DataRequestWrapper<RESPONSE> dataRequestWrapper;
  public final DataStore dataStore;
  public EventListener eventListener;
  final List<RecordTemplateListener<RESPONSE>> listeners;
  
  private DataRequest(DataRequestWrapper<RESPONSE> paramDataRequestWrapper, DataStore paramDataStore)
  {
    dataRequestWrapper = paramDataRequestWrapper;
    dataStore = paramDataStore;
    listeners = new ArrayList();
  }
  
  public static <RESPONSE extends RecordTemplate<RESPONSE>> DataRequest<RESPONSE> create(DataRequestWrapper<RESPONSE> paramDataRequestWrapper, DataStore paramDataStore)
  {
    return new DataRequest(paramDataRequestWrapper, paramDataStore);
  }
  
  public final void callListeners(DataStoreResponse<RESPONSE> paramDataStoreResponse)
  {
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      ((RecordTemplateListener)localIterator.next()).onResponse(paramDataStoreResponse);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DataRequest)paramObject;
      if (dataRequestWrapper != null)
      {
        if (dataRequestWrapper.equals(dataRequestWrapper)) {}
      }
      else {
        while (dataRequestWrapper != null) {
          return false;
        }
      }
      if (dataStore == null) {
        break;
      }
    } while (dataStore.equals(dataStore));
    for (;;)
    {
      return false;
      if (dataStore == null) {
        break;
      }
    }
  }
  
  public final int getMethod()
  {
    int j = 1;
    String str = dataRequestWrapper.method;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        j = 0;
      case 1: 
        return j;
        if (str.equals("POST"))
        {
          i = 0;
          continue;
          if (str.equals("PUT"))
          {
            i = 1;
            continue;
            if (str.equals("DELETE"))
            {
              i = 2;
              continue;
              if (str.equals("GET")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return 4;
    return 2;
  }
  
  public final int getPrecedence()
  {
    return dataStore.getPrecedence();
  }
  
  public final DataStore.Type getType()
  {
    return dataStore.getType();
  }
  
  public final int hashCode()
  {
    if (dataRequestWrapper != null) {
      return dataRequestWrapper.hashCode();
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */