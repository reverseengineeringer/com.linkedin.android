package okhttp3;

import okhttp3.internal.http.HttpMethod;

public final class Request$Builder
{
  RequestBody body;
  public Headers.Builder headers;
  String method;
  Object tag;
  HttpUrl url;
  
  public Request$Builder()
  {
    method = "GET";
    headers = new Headers.Builder();
  }
  
  private Request$Builder(Request paramRequest)
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

/* Location:
 * Qualified Name:     okhttp3.Request.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */