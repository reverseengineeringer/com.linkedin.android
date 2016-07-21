package com.linkedin.android.litrackinglib.network;

import java.util.Map;

public final class RequestData
  implements IRequestData
{
  public String postBody;
  public Map<String, String> requestHeaders;
  public String requestUrl;
  
  public RequestData(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    requestUrl = paramString1;
    requestHeaders = paramMap;
    postBody = paramString2;
  }
  
  public final String getPostBody()
  {
    return postBody;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return requestHeaders;
  }
  
  public final String getRequestUrl()
  {
    return requestUrl;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.network.RequestData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */