package com.linkedin.android.datamanager;

import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Map;

public class DataRequestWrapper$Builder<RESPONSE_MODEL extends RecordTemplate<RESPONSE_MODEL>>
{
  DataTemplateBuilder<RESPONSE_MODEL> builder;
  String cacheKey;
  Map<String, String> customHeaders;
  DataManager.DataStoreFilter filter;
  RecordTemplateListener<RESPONSE_MODEL> listener;
  String method;
  RecordTemplate model;
  Map<String, String> params;
  int timeout;
  String trackingSessionId;
  boolean updateCache = true;
  String url;
  String urlEncodedData;
  
  public DataRequestWrapper$Builder(String paramString)
  {
    method = paramString;
    trackingSessionId = "";
  }
  
  public DataRequestWrapper<RESPONSE_MODEL> build()
  {
    return new DataRequestWrapper(this);
  }
  
  public Builder<RESPONSE_MODEL> builder(DataTemplateBuilder<RESPONSE_MODEL> paramDataTemplateBuilder)
  {
    builder = paramDataTemplateBuilder;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> cacheKey(String paramString)
  {
    cacheKey = paramString;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> customHeaders(Map<String, String> paramMap)
  {
    customHeaders = paramMap;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> filter(DataManager.DataStoreFilter paramDataStoreFilter)
  {
    filter = paramDataStoreFilter;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> listener(RecordTemplateListener<RESPONSE_MODEL> paramRecordTemplateListener)
  {
    listener = paramRecordTemplateListener;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> model(RecordTemplate paramRecordTemplate)
  {
    model = paramRecordTemplate;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> shouldUpdateCache(boolean paramBoolean)
  {
    updateCache = paramBoolean;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> timeout(int paramInt)
  {
    timeout = paramInt;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> trackingSessionId(String paramString)
  {
    trackingSessionId = paramString;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> url(String paramString)
  {
    url = paramString;
    return this;
  }
  
  public Builder<RESPONSE_MODEL> urlEncodedData(String paramString)
  {
    urlEncodedData = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataRequestWrapper.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */