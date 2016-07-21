package com.linkedin.android.datamanager;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.datamanager.multiplex.IndividualBody;
import com.linkedin.android.datamanager.multiplex.IndividualResponse;
import com.linkedin.android.datamanager.multiplex.MultiplexedResponseContent;
import com.linkedin.data.lite.RecordTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class MultiplexSubmitter$1
  implements RecordTemplateListener<MultiplexedResponseContent>
{
  MultiplexSubmitter$1(MultiplexSubmitter paramMultiplexSubmitter, List paramList, EventListener paramEventListener, String paramString, MultiplexRequest paramMultiplexRequest) {}
  
  public final void onResponse(DataStoreResponse<MultiplexedResponseContent> paramDataStoreResponse)
  {
    ArrayMap localArrayMap1;
    Object localObject2;
    ArrayMap localArrayMap2;
    IndividualResponse localIndividualResponse;
    DataRequestWrapper localDataRequestWrapper;
    long l1;
    if (model != null)
    {
      localObject1 = model).responses;
      localArrayMap1 = new ArrayMap();
      localObject2 = ((Map)localObject1).entrySet().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label590;
      }
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      localArrayMap2 = new ArrayMap();
      if (headers != null) {
        localArrayMap2.putAll(headers);
      }
      localIndividualResponse = (IndividualResponse)((Map.Entry)localObject1).getValue();
      localDataRequestWrapper = (DataRequestWrapper)val$requests.get(Integer.valueOf((String)((Map.Entry)localObject1).getKey()).intValue());
      if ((val$eventListener != null) && (val$trackingSessionId != null))
      {
        localObject1 = headers;
        long l2 = -1L;
        l1 = l2;
        if (localObject1 != null)
        {
          localObject1 = (String)((Map)localObject1).get("X-LI-Server-Time");
          l1 = l2;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            l1 = Long.parseLong((String)localObject1);
          }
        }
        localObject1 = headers;
        if (localObject1 == null) {
          break label360;
        }
        localObject1 = (String)((Map)localObject1).get("X-LI-UUID");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label360;
        }
      }
    }
    for (;;)
    {
      val$eventListener.multiplexedNetworkRequestDidEnd(val$trackingSessionId, url, bodySize, l1, (String)localObject1);
      if (headers == null) {
        break label366;
      }
      localObject1 = headers.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = ((Iterator)localObject1).next();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add((String)headers.get(localObject3));
        localArrayMap2.put((String)localObject3, localArrayList);
      }
      localObject1 = Collections.emptyMap();
      break;
      label360:
      localObject1 = null;
    }
    label366:
    if (status == 404) {
      this$0.dataManager.process404Response(url, cacheKey, localArrayMap2);
    }
    if (responseParseException != null) {
      localObject1 = DataStoreResponse.errorResponse(localDataRequestWrapper, DataStore.Type.NETWORK, responseParseException);
    }
    for (;;)
    {
      localArrayMap1.put(localDataRequestWrapper, localObject1);
      break;
      if ((builder != null) && ((body == null) || (body.recordTemplate == null)))
      {
        localObject1 = DataStoreResponse.errorResponse(localDataRequestWrapper, DataStore.Type.NETWORK, new DataManagerException("Model fetch failed. Expected body, but response body was null", new Object[0]));
      }
      else
      {
        if (status / 100 == 2) {
          break label546;
        }
        localObject1 = DataStoreResponse.errorResponse(localDataRequestWrapper, DataStore.Type.NETWORK, new DataManagerException("Received error status code for request:" + status, new Object[0]));
      }
    }
    label546:
    if (body == null) {}
    for (Object localObject1 = null;; localObject1 = body.recordTemplate)
    {
      localObject1 = DataStoreResponse.networkResponse(localDataRequestWrapper, (RecordTemplate)localObject1, localArrayMap2, status, false);
      break;
    }
    label590:
    val$multiplexRequest.notifyMultiplexListeners(localArrayMap1, DataStore.Type.NETWORK, error);
    if (error == null)
    {
      paramDataStoreResponse = localArrayMap1.keySet().iterator();
      while (paramDataStoreResponse.hasNext())
      {
        localObject1 = (DataRequestWrapper)paramDataStoreResponse.next();
        if ((method.equals("GET")) && (updateCache))
        {
          localObject2 = (DataStoreResponse)localArrayMap1.get(localObject1);
          if ((model != null) && (error == null)) {
            this$0.dataManager.submit(DataRequestWrapper.put().url(url).cacheKey(cacheKey).model(model).builder(builder).filter(DataManager.DataStoreFilter.LOCAL_ONLY).build());
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.MultiplexSubmitter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */