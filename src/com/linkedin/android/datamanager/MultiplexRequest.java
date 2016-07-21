package com.linkedin.android.datamanager;

import android.support.v4.util.ArrayMap;
import android.util.SparseIntArray;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.EventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MultiplexRequest
{
  final ArrayMap<DataRequestWrapper, DataStoreResponse> cacheResponseMap;
  private final MultiplexCompletionCallback completionCallback;
  public final Map<String, String> customHeaders;
  EventListener eventListener;
  public final DataManager.DataStoreFilter filter;
  boolean isNetworkRequestFinished;
  public final boolean isParallel;
  final String multiplexerUrl;
  private final SparseIntArray requestStatusList;
  final List<DataRequestWrapper<?>> requests;
  public final int timeout;
  final String trackingSessionId;
  
  private MultiplexRequest(String paramString1, List<DataRequestWrapper<?>> paramList, SparseIntArray paramSparseIntArray, DataManager.DataStoreFilter paramDataStoreFilter, MultiplexCompletionCallback paramMultiplexCompletionCallback, boolean paramBoolean, String paramString2, Map<String, String> paramMap, int paramInt)
  {
    multiplexerUrl = paramString1;
    requests = paramList;
    requestStatusList = paramSparseIntArray;
    filter = paramDataStoreFilter;
    completionCallback = paramMultiplexCompletionCallback;
    isParallel = paramBoolean;
    trackingSessionId = paramString2;
    customHeaders = paramMap;
    timeout = paramInt;
    cacheResponseMap = new ArrayMap(paramList.size());
  }
  
  final void notifyMultiplexListeners(Map<DataRequestWrapper, DataStoreResponse> paramMap, DataStore.Type paramType, DataManagerException paramDataManagerException)
  {
    if (paramType == DataStore.Type.NETWORK) {
      isNetworkRequestFinished = true;
    }
    HashMap localHashMap;
    if (completionCallback != null)
    {
      localHashMap = new HashMap(requests.size());
      if (paramDataManagerException != null) {
        completionCallback.onRequestComplete(localHashMap, paramDataManagerException, paramType);
      }
    }
    else
    {
      return;
    }
    DataManagerException localDataManagerException = null;
    int i = 0;
    if (i < requests.size())
    {
      DataRequestWrapper localDataRequestWrapper = (DataRequestWrapper)requests.get(i);
      DataStoreResponse localDataStoreResponse = (DataStoreResponse)paramMap.get(localDataRequestWrapper);
      String str;
      if (localDataStoreResponse != null)
      {
        paramDataManagerException = localDataManagerException;
        if (error == null) {}
      }
      else
      {
        paramDataManagerException = localDataManagerException;
        if (requestStatusList.get(i) == 0)
        {
          paramDataManagerException = localDataManagerException;
          if (localDataManagerException == null) {
            paramDataManagerException = new ArrayMap();
          }
          str = url;
          if (localDataStoreResponse != null) {
            break label214;
          }
        }
      }
      label214:
      for (localDataManagerException = new DataManagerException("Required request failed with no response", new Object[0]);; localDataManagerException = new DataManagerException(new Throwable("Required request failed", error)))
      {
        paramDataManagerException.put(str, localDataManagerException);
        localHashMap.put(url, localDataStoreResponse);
        i += 1;
        localDataManagerException = paramDataManagerException;
        break;
      }
    }
    paramMap = null;
    if (localDataManagerException != null) {
      paramMap = new MultiplexRequestException(localDataManagerException);
    }
    completionCallback.onRequestComplete(localHashMap, paramMap, paramType);
  }
  
  public static final class Builder
  {
    private final List<DataRequestWrapper.Builder<?>> builders = new ArrayList();
    public MultiplexCompletionCallback completionCallback;
    public Map<String, String> customHeaders;
    private DataManager.DataStoreFilter filter;
    private final boolean isParallel;
    public String multiplexerUrl;
    private final SparseIntArray requiredRequests = new SparseIntArray();
    public int timeout;
    public String trackingSessionId;
    
    private Builder(boolean paramBoolean, DataManager.DataStoreFilter paramDataStoreFilter)
    {
      filter = paramDataStoreFilter;
      isParallel = paramBoolean;
    }
    
    public static Builder parallel()
    {
      return new Builder(true, DataManager.DataStoreFilter.ALL);
    }
    
    public static Builder sequential()
    {
      return new Builder(false, DataManager.DataStoreFilter.NETWORK_ONLY);
    }
    
    public final MultiplexRequest build()
    {
      if (multiplexerUrl == null) {
        throw new IllegalArgumentException("Must include multiplexer url");
      }
      ArrayList localArrayList = new ArrayList(builders.size());
      int i = 0;
      int j = builders.size();
      while (i < j)
      {
        DataRequestWrapper.Builder localBuilder = (DataRequestWrapper.Builder)builders.get(i);
        trackingSessionId = trackingSessionId;
        customHeaders = customHeaders;
        filter = DataManager.DataStoreFilter.LOCAL_ONLY;
        localArrayList.add(localBuilder.build());
        i += 1;
      }
      return new MultiplexRequest(multiplexerUrl, localArrayList, requiredRequests, filter, completionCallback, isParallel, trackingSessionId, customHeaders, timeout, (byte)0);
    }
    
    public final Builder filter(DataManager.DataStoreFilter paramDataStoreFilter)
    {
      if (isParallel) {
        filter = paramDataStoreFilter;
      }
      return this;
    }
    
    public final Builder optional(DataRequestWrapper.Builder<?> paramBuilder)
    {
      requiredRequests.put(builders.size(), 1);
      builders.add(paramBuilder);
      return this;
    }
    
    public final Builder required(DataRequestWrapper.Builder<?> paramBuilder)
    {
      requiredRequests.put(builders.size(), 0);
      builders.add(paramBuilder);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.MultiplexRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */