package okhttp3.internal.http;

import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;

public final class CacheStrategy
{
  public final Response cacheResponse;
  public final Request networkRequest;
  
  private CacheStrategy(Request paramRequest, Response paramResponse)
  {
    networkRequest = paramRequest;
    cacheResponse = paramResponse;
  }
  
  public static boolean isCacheable(Response paramResponse, Request paramRequest)
  {
    switch (code)
    {
    }
    do
    {
      return false;
    } while (((paramResponse.header("Expires") == null) && (cacheControlmaxAgeSeconds == -1) && (!cacheControlisPublic) && (!cacheControlisPrivate)) || (cacheControlnoStore) || (cacheControlnoStore));
    return true;
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.http.CacheStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */