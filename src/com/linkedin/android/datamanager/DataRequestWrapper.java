package com.linkedin.android.datamanager;

import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Map;

public class DataRequestWrapper<RESPONSE_MODEL extends RecordTemplate<RESPONSE_MODEL>>
{
  public final DataTemplateBuilder<RESPONSE_MODEL> builder;
  public final String cacheKey;
  public final Map<String, String> customHeaders;
  public final DataManager.DataStoreFilter filter;
  public RecordTemplateListener<RESPONSE_MODEL> listener;
  public final String method;
  public final RecordTemplate model;
  public final Map<String, String> params;
  public final int timeout;
  public final String trackingSessionId;
  public final boolean updateCache;
  public final String url;
  public final String urlEncodedData;
  
  public DataRequestWrapper(Builder<RESPONSE_MODEL> paramBuilder)
  {
    method = method;
    url = url;
    params = params;
    if ((cacheKey == null) || (cacheKey.isEmpty())) {}
    for (String str = url;; str = cacheKey)
    {
      cacheKey = str;
      model = model;
      builder = builder;
      listener = listener;
      filter = filter;
      updateCache = updateCache;
      trackingSessionId = trackingSessionId;
      customHeaders = customHeaders;
      urlEncodedData = urlEncodedData;
      timeout = timeout;
      return;
    }
  }
  
  public static <RESPONSE_MODEL extends RecordTemplate<RESPONSE_MODEL>> Builder<RESPONSE_MODEL> delete()
  {
    return new Builder("DELETE");
  }
  
  public static <RESPONSE_MODEL extends RecordTemplate<RESPONSE_MODEL>> Builder<RESPONSE_MODEL> put()
  {
    return new Builder("PUT");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DataRequestWrapper)paramObject;
      if (updateCache != updateCache) {
        return false;
      }
      if (!method.equals(method)) {
        return false;
      }
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (params != null)
      {
        if (params.equals(params)) {}
      }
      else {
        while (params != null) {
          return false;
        }
      }
      if (cacheKey != null)
      {
        if (cacheKey.equals(cacheKey)) {}
      }
      else {
        while (cacheKey != null) {
          return false;
        }
      }
      if (model != null)
      {
        if (model.equals(model)) {}
      }
      else {
        while (model != null) {
          return false;
        }
      }
      if (builder != null)
      {
        if (builder.equals(builder)) {}
      }
      else {
        while (builder != null) {
          return false;
        }
      }
      if (filter != filter) {
        return false;
      }
      if (trackingSessionId == null) {
        break;
      }
    } while (trackingSessionId.equals(trackingSessionId));
    while (trackingSessionId != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int i3 = 0;
    int i4 = method.hashCode();
    int i;
    int j;
    label44:
    int k;
    label59:
    int m;
    label75:
    int n;
    label91:
    int i1;
    if (url != null)
    {
      i = url.hashCode();
      if (params == null) {
        break label186;
      }
      j = params.hashCode();
      if (cacheKey == null) {
        break label191;
      }
      k = cacheKey.hashCode();
      if (model == null) {
        break label196;
      }
      m = model.hashCode();
      if (builder == null) {
        break label202;
      }
      n = builder.hashCode();
      if (filter == null) {
        break label208;
      }
      i1 = filter.hashCode();
      label107:
      if (!updateCache) {
        break label214;
      }
    }
    label186:
    label191:
    label196:
    label202:
    label208:
    label214:
    for (int i2 = 1;; i2 = 0)
    {
      if (trackingSessionId != null) {
        i3 = trackingSessionId.hashCode();
      }
      return (((((((i4 * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
      i = 0;
      break;
      j = 0;
      break label44;
      k = 0;
      break label59;
      m = 0;
      break label75;
      n = 0;
      break label91;
      i1 = 0;
      break label107;
    }
  }
  
  public static class Builder<RESPONSE_MODEL extends RecordTemplate<RESPONSE_MODEL>>
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
    
    public Builder(String paramString)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */