package com.linkedin.android.infra.tos;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.LinkedInRequestBodyFactory;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.android.tos.HttpNetworkInterface;
import com.linkedin.android.tos.HttpNetworkInterface.ResponseListener;
import java.net.CookieManager;
import java.net.CookieStore;
import java.util.Map;

public final class ToSHttpNetwork
  implements HttpNetworkInterface
{
  private final Context appContext;
  private final NetworkClient networkClient;
  
  public ToSHttpNetwork(NetworkClient paramNetworkClient, Context paramContext)
  {
    networkClient = paramNetworkClient;
    appContext = paramContext;
  }
  
  private ResponseListener getResponseListener(HttpNetworkInterface.ResponseListener paramResponseListener)
  {
    return new ToSHttpNetwork.1(this, paramResponseListener);
  }
  
  public final void get(String paramString, HttpNetworkInterface.ResponseListener paramResponseListener)
  {
    paramString = networkClient.factory.getAbsoluteRequest$3868be9b(0, paramString, getResponseListener(paramResponseListener), null);
    networkClient.add(paramString);
  }
  
  public final CookieStore getCookieStore()
  {
    return networkClient.cookieUtil.cookieManager().getCookieStore();
  }
  
  public final void post(String paramString1, String paramString2, byte[] paramArrayOfByte, HttpNetworkInterface.ResponseListener paramResponseListener)
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("Content-Type", paramString2);
    paramString2 = networkClient.factory;
    paramArrayOfByte = createsetAdditionalHeaderssetBodycreaterequestDelegate;
    paramString1 = paramString2.getAbsoluteRequest$3868be9b(1, paramString1, getResponseListener(paramResponseListener), paramArrayOfByte);
    networkClient.add(paramString1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.tos.ToSHttpNetwork
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */