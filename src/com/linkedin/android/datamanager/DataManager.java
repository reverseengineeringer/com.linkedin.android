package com.linkedin.android.datamanager;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.android.datamanager.interfaces.LocalDataStore;
import com.linkedin.android.datamanager.interfaces.NetworkDataStore;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.datamanager.local.DefaultLocalDataStoreListener;
import com.linkedin.android.datamanager.multiplex.MultiplexedRequestContent;
import com.linkedin.android.datamanager.multiplex.MultiplexedResponseContentBuilder;
import com.linkedin.android.datamanager.net.NetworkResponseListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataTemplateParserFactory;
import com.linkedin.data.lite.JsonGeneratorFactory;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.jackson.JacksonJsonGeneratorFactory;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;

public final class DataManager
{
  public static final JsonGeneratorFactory GENERATOR_FACTORY = new JacksonJsonGeneratorFactory();
  public static final DataTemplateParserFactory PARSER_FACTORY = new DataManagerParserFactory();
  protected final Map<String, DataRequestList> currentRequests = new HashMap();
  protected EventListener eventListener;
  protected ExecutorService executor;
  protected final LocalDataStore localDataStore;
  private final MultiplexSubmitter multiplexSubmitter;
  protected final NetworkDataStore networkDataStore;
  
  public DataManager(NetworkDataStore paramNetworkDataStore, LocalDataStore paramLocalDataStore)
  {
    networkDataStore = paramNetworkDataStore;
    localDataStore = paramLocalDataStore;
    multiplexSubmitter = new MultiplexSubmitter(this);
  }
  
  private <RESPONSE extends RecordTemplate<RESPONSE>> void executeLocalRequestWrapper(final DataRequest<RESPONSE> paramDataRequest, final LocalDataStore paramLocalDataStore, final RecordTemplateListener<RESPONSE> paramRecordTemplateListener)
  {
    for (;;)
    {
      try
      {
        if (executor == null)
        {
          executeLocalRequest(paramDataRequest, paramLocalDataStore, paramRecordTemplateListener);
          return;
        }
        if (executor.isShutdown())
        {
          if (paramRecordTemplateListener != null) {
            paramRecordTemplateListener.onResponse(DataStoreResponse.errorResponse(dataRequestWrapper, paramDataRequest.getType(), new DataManagerException("ExecutorService %s has been shutdown.", new Object[] { executor })));
          }
        }
        else {
          executor.execute(new Runnable()
          {
            public final void run()
            {
              executeLocalRequest(paramDataRequest, paramLocalDataStore, paramRecordTemplateListener);
            }
          });
        }
      }
      finally {}
    }
  }
  
  private <RESPONSE extends RecordTemplate<RESPONSE>> void executeNetworkRequest(DataRequest<RESPONSE> paramDataRequest, NetworkDataStore paramNetworkDataStore, RecordTemplateListener<RESPONSE> paramRecordTemplateListener)
  {
    try
    {
      if (paramDataRequest == poolRequest(paramDataRequest, paramRecordTemplateListener)) {
        paramNetworkDataStore.execute(paramDataRequest, new NetworkResponseListener(this, paramDataRequest));
      }
      return;
    }
    finally
    {
      paramDataRequest = finally;
      throw paramDataRequest;
    }
  }
  
  private <RESPONSE extends RecordTemplate<RESPONSE>> DataRequest<RESPONSE> poolRequest(DataRequest<RESPONSE> paramDataRequest, RecordTemplateListener<RESPONSE> paramRecordTemplateListener)
  {
    try
    {
      Object localObject3 = dataRequestWrapper.url;
      Object localObject2 = (DataRequestList)currentRequests.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new DataRequestList();
        currentRequests.put(localObject3, localObject1);
      }
      localObject3 = ((DataRequestList)localObject1).getOngoingRequest(paramDataRequest);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        ((DataRequestList)localObject1).add(paramDataRequest);
        localObject2 = paramDataRequest;
      }
      if ((paramRecordTemplateListener != null) && (!listeners.contains(paramRecordTemplateListener))) {
        listeners.add(paramRecordTemplateListener);
      }
      return (DataRequest<RESPONSE>)localObject2;
    }
    finally {}
  }
  
  public final <RESPONSE extends RecordTemplate<RESPONSE>> void cancelLowerPrecedenceRequests(DataRequest<RESPONSE> paramDataRequest)
  {
    try
    {
      String str = dataRequestWrapper.url;
      DataRequestList localDataRequestList = (DataRequestList)currentRequests.get(str);
      if ((localDataRequestList != null) && (!localDataRequestList.isEmpty()))
      {
        localDataRequestList.removeWithLowerPrecedence(paramDataRequest.getPrecedence());
        if (localDataRequestList.isEmpty()) {
          currentRequests.remove(str);
        }
      }
      return;
    }
    finally {}
  }
  
  protected final <RESPONSE extends RecordTemplate<RESPONSE>> void executeLocalRequest(DataRequest<RESPONSE> paramDataRequest, LocalDataStore paramLocalDataStore, RecordTemplateListener<RESPONSE> paramRecordTemplateListener)
  {
    if (paramDataRequest == poolRequest(paramDataRequest, paramRecordTemplateListener)) {
      paramLocalDataStore.execute(paramDataRequest, new DefaultLocalDataStoreListener(this, paramDataRequest));
    }
  }
  
  /* Error */
  public final <RESPONSE extends RecordTemplate<RESPONSE>> boolean isCancelled(DataRequest<RESPONSE> paramDataRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/linkedin/android/datamanager/DataManager:currentRequests	Ljava/util/Map;
    //   6: aload_1
    //   7: getfield 78	com/linkedin/android/datamanager/DataRequest:dataRequestWrapper	Lcom/linkedin/android/datamanager/DataRequestWrapper;
    //   10: getfield 133	com/linkedin/android/datamanager/DataRequestWrapper:url	Ljava/lang/String;
    //   13: invokeinterface 139 2 0
    //   18: checkcast 141	com/linkedin/android/datamanager/DataRequestList
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +13 -> 36
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 195	com/linkedin/android/datamanager/DataRequestList:contains	(Lcom/linkedin/android/datamanager/DataRequest;)Z
    //   31: istore_2
    //   32: iload_2
    //   33: ifne +9 -> 42
    //   36: iconst_1
    //   37: istore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	DataManager
    //   0	52	1	paramDataRequest	DataRequest<RESPONSE>
    //   31	13	2	bool	boolean
    //   21	6	3	localDataRequestList	DataRequestList
    // Exception table:
    //   from	to	target	type
    //   2	22	47	finally
    //   26	32	47	finally
  }
  
  public final <RESPONSE extends RecordTemplate<RESPONSE>> void process404Response(String paramString1, String paramString2, Map<String, List<String>> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = (List)paramMap.get("X-LI-UUID");
      if ((paramMap != null) && (!paramMap.isEmpty()))
      {
        if (paramString1 != null) {
          submit(DataRequestWrapper.delete().url(paramString1).filter(DataStoreFilter.LOCAL_ONLY).build());
        }
        if ((paramString2 != null) && (!paramString2.equals(paramString1))) {
          submit(DataRequestWrapper.delete().cacheKey(paramString2).filter(DataStoreFilter.LOCAL_ONLY).build());
        }
      }
    }
  }
  
  public final <RESPONSE extends RecordTemplate<RESPONSE>> void removeRequestFromPool(DataRequest<RESPONSE> paramDataRequest)
  {
    try
    {
      DataRequestList localDataRequestList = (DataRequestList)currentRequests.get(dataRequestWrapper.url);
      if (localDataRequestList != null) {
        localDataRequestList.remove(paramDataRequest);
      }
      return;
    }
    finally {}
  }
  
  public final DataManager setEventListener(EventListener paramEventListener)
  {
    eventListener = paramEventListener;
    return this;
  }
  
  public final DataManager setExecutorService(ExecutorService paramExecutorService)
  {
    executor = paramExecutorService;
    return this;
  }
  
  public final <RESPONSE extends RecordTemplate<RESPONSE>> void submit(DataRequestWrapper<RESPONSE> paramDataRequestWrapper)
  {
    DataRequest localDataRequest;
    if ((networkDataStore != null) && (DataStoreFilter.LOCAL_ONLY != filter))
    {
      localDataRequest = DataRequest.create(paramDataRequestWrapper, networkDataStore);
      if ((trackingSessionId != null) && (eventListener != null)) {
        eventListener = eventListener;
      }
      executeNetworkRequest(localDataRequest, networkDataStore, listener);
    }
    if ((localDataStore != null) && (DataStoreFilter.NETWORK_ONLY != filter))
    {
      localDataRequest = DataRequest.create(paramDataRequestWrapper, localDataStore);
      if ((trackingSessionId != null) && (eventListener != null))
      {
        eventListener = eventListener;
        eventListener.cacheRequestEnqueued(trackingSessionId, url);
      }
      executeLocalRequestWrapper(localDataRequest, localDataStore, listener);
    }
  }
  
  public final void submit(MultiplexRequest paramMultiplexRequest)
  {
    int i = 0;
    if ((trackingSessionId != null) && (eventListener != null)) {
      eventListener = eventListener;
    }
    MultiplexSubmitter localMultiplexSubmitter = multiplexSubmitter;
    Object localObject1;
    Object localObject2;
    if ((filter == DataStoreFilter.ALL) || (filter == DataStoreFilter.LOCAL_ONLY))
    {
      localObject1 = requests.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DataRequestWrapper)((Iterator)localObject1).next();
        listener = new MultiplexSubmitter.2(localMultiplexSubmitter, paramMultiplexRequest);
        dataManager.submit((DataRequestWrapper)localObject2);
      }
    }
    if ((filter == DataStoreFilter.ALL) || (filter == DataStoreFilter.NETWORK_ONLY)) {}
    try
    {
      localObject1 = multiplexerUrl;
      Object localObject3 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf('/'));
      localObject2 = requests;
      localObject3 = new MultiplexedRequestContent(localMultiplexSubmitter.buildRequestMap(paramMultiplexRequest, (List)localObject2, (String)localObject3, 0), true);
      EventListener localEventListener = eventListener;
      String str1 = trackingSessionId;
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      while (i < ((List)localObject2).size())
      {
        String str2 = String.valueOf(i);
        DataRequestWrapper localDataRequestWrapper = (DataRequestWrapper)((List)localObject2).get(i);
        localArrayMap1.put(str2, builder);
        localArrayMap2.put(str2, url);
        i += 1;
      }
      localObject1 = new DataRequestWrapper.Builder("POST").url((String)localObject1).filter(DataStoreFilter.NETWORK_ONLY).model((RecordTemplate)localObject3).trackingSessionId(trackingSessionId).customHeaders(customHeaders).timeout(timeout).builder(new MultiplexedResponseContentBuilder(localArrayMap1, str1, localEventListener, localArrayMap2)).listener(new MultiplexSubmitter.1(localMultiplexSubmitter, (List)localObject2, localEventListener, str1, paramMultiplexRequest)).build();
      dataManager.submit((DataRequestWrapper)localObject1);
      return;
    }
    catch (BuilderException localBuilderException)
    {
      DataManagerException localDataManagerException = new DataManagerException(localBuilderException);
      paramMultiplexRequest.notifyMultiplexListeners(Collections.emptyMap(), DataStore.Type.NETWORK, localDataManagerException);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public static enum DataStoreFilter
  {
    ALL,  LOCAL_ONLY,  NETWORK_ONLY;
    
    private DataStoreFilter() {}
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */