package com.linkedin.android.networking.cookies;

import com.linkedin.android.networking.AbstractNetworkClient;
import java.io.IOException;
import java.net.CookieManager;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;

public final class SetCookieInterceptor
  implements Interceptor
{
  private final AbstractNetworkClient abstractNetworkClient;
  
  public SetCookieInterceptor(AbstractNetworkClient paramAbstractNetworkClient)
  {
    abstractNetworkClient = paramAbstractNetworkClient;
  }
  
  public final Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    paramChain = paramChain.proceed(paramChain.request());
    abstractNetworkClient.cookieUtil.cookieManager().put(request.url.uri(), headers.toMultimap());
    return paramChain;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.cookies.SetCookieInterceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */