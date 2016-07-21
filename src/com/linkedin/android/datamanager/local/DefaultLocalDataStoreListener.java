package com.linkedin.android.datamanager.local;

import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequest;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.data.lite.RecordTemplate;

public final class DefaultLocalDataStoreListener<RESPONSE extends RecordTemplate<RESPONSE>>
  implements LocalDataStoreListener<RESPONSE>
{
  private final DataManager manager;
  private final DataRequest<RESPONSE> request;
  
  public DefaultLocalDataStoreListener(DataManager paramDataManager, DataRequest<RESPONSE> paramDataRequest)
  {
    manager = paramDataManager;
    request = paramDataRequest;
  }
  
  public final void onResponse(RESPONSE paramRESPONSE, DataManagerException paramDataManagerException)
  {
    if (manager.isCancelled(request)) {
      return;
    }
    manager.removeRequestFromPool(request);
    if ((paramDataManagerException == null) && (paramRESPONSE != null)) {
      manager.cancelLowerPrecedenceRequests(request);
    }
    if (paramDataManagerException != null) {
      paramRESPONSE = DataStoreResponse.errorResponse(request.dataRequestWrapper, request.getType(), paramDataManagerException);
    }
    for (;;)
    {
      request.callListeners(paramRESPONSE);
      return;
      if (paramRESPONSE == null) {
        paramRESPONSE = new DataStoreResponse(request.dataRequestWrapper, request.getType(), null, null, null, -1, false);
      } else {
        paramRESPONSE = DataStoreResponse.localResponse(request.dataRequestWrapper, paramRESPONSE);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.local.DefaultLocalDataStoreListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */