package com.linkedin.android.infra.data;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.logger.Log;
import com.linkedin.data.lite.RecordTemplate;

public class DefaultModelListener<T extends RecordTemplate<T>>
  implements RecordTemplateListener<T>
{
  private static final String TAG = DefaultModelListener.class.getSimpleName();
  protected DataRequestWrapper<T> request;
  
  public void onCacheError(DataManagerException paramDataManagerException) {}
  
  public void onCacheSuccess(T paramT) {}
  
  public void onNetworkError(DataManagerException paramDataManagerException) {}
  
  public void onNetworkSuccess(T paramT) {}
  
  public void onResponse(DataStoreResponse<T> paramDataStoreResponse)
  {
    RecordTemplate localRecordTemplate = model;
    DataManagerException localDataManagerException = error;
    request = request;
    String str = request.url;
    if (localDataManagerException != null)
    {
      if (type == DataStore.Type.NETWORK)
      {
        Log.w(TAG, "Error executing request for network, url = " + str + ": " + localDataManagerException.getClass().getName() + "; " + localDataManagerException.getMessage());
        onNetworkError(localDataManagerException);
        return;
      }
      Log.w(TAG, "Error executing request for cache, url = " + str + ": " + localDataManagerException.getClass().getName() + "; " + localDataManagerException.getMessage());
      onCacheError(localDataManagerException);
      return;
    }
    if (type == DataStore.Type.NETWORK)
    {
      onNetworkSuccess(localRecordTemplate);
      return;
    }
    onCacheSuccess(localRecordTemplate);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.DefaultModelListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */