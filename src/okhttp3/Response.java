package okhttp3;

public final class Response
{
  public final ResponseBody body;
  private volatile CacheControl cacheControl;
  Response cacheResponse;
  public final int code;
  public final Handshake handshake;
  public final Headers headers;
  final String message;
  public Response networkResponse;
  final Response priorResponse;
  final Protocol protocol;
  public final Request request;
  
  private Response(Builder paramBuilder)
  {
    request = request;
    protocol = protocol;
    code = code;
    message = message;
    handshake = handshake;
    headers = headers.build();
    body = body;
    networkResponse = networkResponse;
    cacheResponse = cacheResponse;
    priorResponse = priorResponse;
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
    paramString = headers.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public final Builder newBuilder()
  {
    return new Builder(this, (byte)0);
  }
  
  public final String toString()
  {
    return "Response{protocol=" + protocol + ", code=" + code + ", message=" + message + ", url=" + request.url + '}';
  }
  
  public static final class Builder
  {
    public ResponseBody body;
    Response cacheResponse;
    public int code = -1;
    public Handshake handshake;
    Headers.Builder headers;
    public String message;
    Response networkResponse;
    Response priorResponse;
    public Protocol protocol;
    public Request request;
    
    public Builder()
    {
      headers = new Headers.Builder();
    }
    
    private Builder(Response paramResponse)
    {
      request = request;
      protocol = protocol;
      code = code;
      message = message;
      handshake = handshake;
      headers = headers.newBuilder();
      body = body;
      networkResponse = networkResponse;
      cacheResponse = cacheResponse;
      priorResponse = priorResponse;
    }
    
    private static void checkSupportResponse(String paramString, Response paramResponse)
    {
      if (body != null) {
        throw new IllegalArgumentException(paramString + ".body != null");
      }
      if (networkResponse != null) {
        throw new IllegalArgumentException(paramString + ".networkResponse != null");
      }
      if (cacheResponse != null) {
        throw new IllegalArgumentException(paramString + ".cacheResponse != null");
      }
      if (priorResponse != null) {
        throw new IllegalArgumentException(paramString + ".priorResponse != null");
      }
    }
    
    public final Builder addHeader(String paramString1, String paramString2)
    {
      headers.add(paramString1, paramString2);
      return this;
    }
    
    public final Response build()
    {
      if (request == null) {
        throw new IllegalStateException("request == null");
      }
      if (protocol == null) {
        throw new IllegalStateException("protocol == null");
      }
      if (code < 0) {
        throw new IllegalStateException("code < 0: " + code);
      }
      return new Response(this, (byte)0);
    }
    
    public final Builder cacheResponse(Response paramResponse)
    {
      if (paramResponse != null) {
        checkSupportResponse("cacheResponse", paramResponse);
      }
      cacheResponse = paramResponse;
      return this;
    }
    
    public final Builder header(String paramString1, String paramString2)
    {
      headers.set(paramString1, paramString2);
      return this;
    }
    
    public final Builder headers(Headers paramHeaders)
    {
      headers = paramHeaders.newBuilder();
      return this;
    }
    
    public final Builder networkResponse(Response paramResponse)
    {
      if (paramResponse != null) {
        checkSupportResponse("networkResponse", paramResponse);
      }
      networkResponse = paramResponse;
      return this;
    }
    
    public final Builder priorResponse(Response paramResponse)
    {
      if ((paramResponse != null) && (body != null)) {
        throw new IllegalArgumentException("priorResponse.body != null");
      }
      priorResponse = paramResponse;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */