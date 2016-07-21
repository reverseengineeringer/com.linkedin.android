package com.linkedin.android.datamanager;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class MultiplexSubmitter$2
  implements RecordTemplateListener
{
  MultiplexSubmitter$2(MultiplexSubmitter paramMultiplexSubmitter, MultiplexRequest paramMultiplexRequest) {}
  
  public final void onResponse(DataStoreResponse paramDataStoreResponse)
  {
    MultiplexRequest localMultiplexRequest = val$multiplexRequest;
    Object localObject = request;
    if (!cacheResponseMap.containsKey(localObject))
    {
      cacheResponseMap.put(localObject, paramDataStoreResponse);
      if (isNetworkRequestFinished) {
        break label116;
      }
      paramDataStoreResponse = cacheResponseMap;
      localObject = requests.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!paramDataStoreResponse.containsKey((DataRequestWrapper)((Iterator)localObject).next()))
        {
          i = 0;
          if (i == 0) {
            break label116;
          }
        }
      }
    }
    label116:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localMultiplexRequest.notifyMultiplexListeners(cacheResponseMap, DataStore.Type.LOCAL, null);
      }
      return;
      i = 1;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.MultiplexSubmitter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */