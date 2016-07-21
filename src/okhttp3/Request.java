package okhttp3;

import okhttp3.internal.http.HttpMethod;

public final class Request
{
  public final RequestBody body;
  private volatile CacheControl cacheControl;
  public final Headers headers;
  public final String method;
  final Object tag;
  public final HttpUrl url;
  
  private Request(Builder paramBuilder)
  {
    url = url;
    method = method;
    headers = headers.build();
    body = body;
    if (tag != null) {}
    for (paramBuilder = tag;; paramBuilder = this)
    {
      tag = paramBuilder;
      return;
    }
  }
  
  public final CacheControl cacheControl()
  {
    CacheControl localCacheControl = cacheControl;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.parse(headers);
    cacheControl = localCacheControl;
    return localCacheControl;
  }
  
  public final String header(String paramString)
  {
    return headers.get(paramString);
  }
  
  public final Builder newBuilder()
  {
    return new Builder(this, (byte)0);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request{method=").append(method).append(", url=").append(url).append(", tag=");
    if (tag != this) {}
    for (Object localObject = tag;; localObject = null) {
      return localObject + '}';
    }
  }
  
  public static final class Builder
  {
    RequestBody body;
    public Headers.Builder headers;
    String method;
    Object tag;
    HttpUrl url;
    
    public Builder()
    {
      method = "GET";
      headers = new Headers.Builder();
    }
    
    private Builder(Request paramRequest)
    {
      url = url;
      method = method;
      body = body;
      tag = tag;
      headers = headers.newBuilder();
    }
    
    public final Request build()
    {
      if (url == null) {
        throw new IllegalStateException("url == null");
      }
      return new Request(this, (byte)0);
    }
    
    public final Builder header(String paramString1, String paramString2)
    {
      headers.set(paramString1, paramString2);
      return this;
    }
    
    public final Builder method(String paramString, RequestBody paramRequestBody)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        throw new IllegalArgumentException("method == null || method.length() == 0");
      }
      if ((paramRequestBody != null) && (!HttpMethod.permitsRequestBody(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((paramRequestBody == null) && (HttpMethod.requiresRequestBody(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      method = paramString;
      body = paramRequestBody;
      return this;
    }
    
    public final Builder removeHeader(String paramString)
    {
      headers.removeAll(paramString);
      return this;
    }
    
    public final Builder url(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        paramString = HttpUrl.parse(str);
        if (paramString != null) {
          break;
        }
        throw new IllegalArgumentException("unexpected url: " + str);
        str = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
          str = "https:" + paramString.substring(4);
        }
      }
      return url(paramString);
    }
    
    public final Builder url(HttpUrl paramHttpUrl)
    {
      if (paramHttpUrl == null) {
        throw new IllegalArgumentException("url == null");
      }
      url = paramHttpUrl;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */