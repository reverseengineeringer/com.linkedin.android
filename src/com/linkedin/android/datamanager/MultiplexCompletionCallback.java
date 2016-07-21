package com.linkedin.android.datamanager;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import java.util.Map;

public abstract interface MultiplexCompletionCallback
{
  public abstract void onRequestComplete(Map<String, DataStoreResponse> paramMap, DataManagerException paramDataManagerException, DataStore.Type paramType);
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.MultiplexCompletionCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */