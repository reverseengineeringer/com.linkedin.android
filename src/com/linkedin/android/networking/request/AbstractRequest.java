package com.linkedin.android.networking.request;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.networking.interfaces.PerfEventListener;
import com.linkedin.android.networking.interfaces.RequestBody;
import com.linkedin.android.networking.interfaces.RequestDelegate;
import com.linkedin.android.networking.interfaces.ResponseListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class AbstractRequest
{
  public boolean isCacheable;
  public boolean isCanceled;
  public final int method;
  public PerfEventListener perfEventListener;
  public final RequestBody requestBody;
  public final RequestDelegate requestDelegate;
  private final String requestUrl;
  public final ResponseListener responseListener;
  public int socketTimeoutMillis;
  public int writeTimeoutMillis = -1;
  
  public AbstractRequest(int paramInt, String paramString, ResponseListener paramResponseListener, RequestDelegate paramRequestDelegate)
  {
    method = paramInt;
    String str = paramString;
    if (paramRequestDelegate != null) {
      str = appendParams(paramString, paramRequestDelegate.getParams());
    }
    requestUrl = str;
    requestDelegate = paramRequestDelegate;
    responseListener = paramResponseListener;
    perfEventListener = null;
    requestBody = null;
  }
  
  private static String appendParams(String paramString, Map<String, String> paramMap)
  {
    paramString = Uri.parse(paramString).buildUpon();
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.appendQueryParameter(str, (String)paramMap.get(str));
      }
    }
    paramString.appendQueryParameter("nc", Long.toString(System.currentTimeMillis()));
    return paramString.build().toString();
  }
  
  public Map<String, String> getHeaders()
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (requestDelegate != null)
    {
      Map localMap = requestDelegate.getHeaders();
      if (localMap != null) {
        localArrayMap.putAll(localMap);
      }
    }
    return localArrayMap;
  }
  
  public final String getUrl()
  {
    if (requestDelegate != null)
    {
      String str = requestDelegate.getUrl();
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return requestUrl;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.request.AbstractRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */