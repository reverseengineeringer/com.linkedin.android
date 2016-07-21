package com.linkedin.android.datamanager;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.data.lite.RecordTemplate;
import java.util.List;
import java.util.Map;

public final class DataStoreResponse<RESPONSE_MODEL extends RecordTemplate<RESPONSE_MODEL>>
{
  public final DataManagerException error;
  public final Map<String, List<String>> headers;
  public final RESPONSE_MODEL model;
  public final boolean notModified;
  public final DataRequestWrapper<RESPONSE_MODEL> request;
  public final int statusCode;
  public final DataStore.Type type;
  
  public DataStoreResponse(DataRequestWrapper<RESPONSE_MODEL> paramDataRequestWrapper, DataStore.Type paramType, RESPONSE_MODEL paramRESPONSE_MODEL, DataManagerException paramDataManagerException, Map<String, List<String>> paramMap, int paramInt, boolean paramBoolean)
  {
    request = paramDataRequestWrapper;
    type = paramType;
    model = paramRESPONSE_MODEL;
    error = paramDataManagerException;
    headers = paramMap;
    statusCode = paramInt;
    notModified = paramBoolean;
  }
  
  public static <RESPONSE extends RecordTemplate<RESPONSE>> DataStoreResponse<RESPONSE> errorResponse(DataRequestWrapper<RESPONSE> paramDataRequestWrapper, DataStore.Type paramType, DataManagerException paramDataManagerException)
  {
    return new DataStoreResponse(paramDataRequestWrapper, paramType, null, paramDataManagerException, null, -1, false);
  }
  
  public static <RESPONSE extends RecordTemplate<RESPONSE>> DataStoreResponse<RESPONSE> localResponse(DataRequestWrapper<RESPONSE> paramDataRequestWrapper, RESPONSE paramRESPONSE)
  {
    return new DataStoreResponse(paramDataRequestWrapper, DataStore.Type.LOCAL, paramRESPONSE, null, null, -1, false);
  }
  
  public static <RESPONSE extends RecordTemplate<RESPONSE>> DataStoreResponse<RESPONSE> networkResponse(DataRequestWrapper<RESPONSE> paramDataRequestWrapper, RESPONSE paramRESPONSE, Map<String, List<String>> paramMap, int paramInt, boolean paramBoolean)
  {
    return new DataStoreResponse(paramDataRequestWrapper, DataStore.Type.NETWORK, paramRESPONSE, null, paramMap, paramInt, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataStoreResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */