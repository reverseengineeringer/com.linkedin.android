package com.linkedin.android.infra.data;

import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataRequestWrapper.Builder;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Map;

public final class Request$Builder<RESPONSE_MODEL extends RecordTemplate<RESPONSE_MODEL>>
  extends DataRequestWrapper.Builder<RESPONSE_MODEL>
{
  String cacheKey;
  RecordTemplateListener<RESPONSE_MODEL> listener;
  String method;
  RecordTemplate<RESPONSE_MODEL> model;
  public String url;
  
  private Request$Builder(String paramString)
  {
    super(paramString);
    method = paramString;
  }
  
  public final Request<RESPONSE_MODEL> build()
  {
    super.build();
    return new Request(this);
  }
  
  public final Builder<RESPONSE_MODEL> builder(DataTemplateBuilder<RESPONSE_MODEL> paramDataTemplateBuilder)
  {
    super.builder(paramDataTemplateBuilder);
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> cacheKey(String paramString)
  {
    super.cacheKey(paramString);
    cacheKey = paramString;
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> customHeaders(Map<String, String> paramMap)
  {
    super.customHeaders(paramMap);
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> filter(DataManager.DataStoreFilter paramDataStoreFilter)
  {
    super.filter(paramDataStoreFilter);
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> listener(RecordTemplateListener<RESPONSE_MODEL> paramRecordTemplateListener)
  {
    super.listener(paramRecordTemplateListener);
    listener = paramRecordTemplateListener;
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> model(RecordTemplate paramRecordTemplate)
  {
    super.model(paramRecordTemplate);
    model = paramRecordTemplate;
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> shouldUpdateCache(boolean paramBoolean)
  {
    super.shouldUpdateCache(paramBoolean);
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> timeout(int paramInt)
  {
    super.timeout(paramInt);
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> trackingSessionId(String paramString)
  {
    super.trackingSessionId(paramString);
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> url(String paramString)
  {
    super.url(paramString);
    url = paramString;
    return this;
  }
  
  public final Builder<RESPONSE_MODEL> urlEncodedData(String paramString)
  {
    super.urlEncodedData(paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.Request.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */