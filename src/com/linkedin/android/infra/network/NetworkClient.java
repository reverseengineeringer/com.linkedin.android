package com.linkedin.android.infra.network;

import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.InternationalizationApi;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.request.AbstractRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;

public class NetworkClient
  extends AbstractNetworkClient
{
  private final ApplicationComponent appComponent;
  public final VoyagerRequestFactory factory;
  public boolean handledUnauthorizedStatusCode;
  private final IntentRegistry intentRegistry;
  private final FlagshipSharedPreferences sharedPreferences;
  
  public NetworkClient(ApplicationComponent paramApplicationComponent, VoyagerRequestFactory paramVoyagerRequestFactory, InternationalizationApi paramInternationalizationApi)
  {
    super(paramApplicationComponent.appContext(), paramInternationalizationApi);
    appComponent = paramApplicationComponent;
    sharedPreferences = paramApplicationComponent.flagshipSharedPreferences();
    intentRegistry = paramApplicationComponent.intentRegistry();
    factory = paramVoyagerRequestFactory;
    customHeaders.put("X-RestLi-Protocol-Version", "2.0.0");
    registerStatusCodeHandler(401, new NetworkClient.UnauthorizedStatusCodeHandler(this, (byte)0));
    registerStatusCodeHandler(403, new NetworkClient.ForbiddenStatusCodeHandler(this, (byte)0));
  }
  
  private URI getVoyagerUri(AbstractRequest paramAbstractRequest)
  {
    Object localObject2 = null;
    String str = paramAbstractRequest.getUrl();
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (!str.startsWith(sharedPreferences.getBaseUrl())) {}
    }
    try
    {
      localObject1 = new URI(paramAbstractRequest.getUrl());
      return (URI)localObject1;
    }
    catch (URISyntaxException paramAbstractRequest)
    {
      return null;
    }
    catch (IllegalArgumentException paramAbstractRequest) {}
    return null;
  }
  
  protected final boolean forceIpv4NetworkStrategy()
  {
    return true;
  }
  
  public final String getAdvertiserId()
  {
    return null;
  }
  
  protected final List<Interceptor> getInterceptors()
  {
    return Collections.singletonList(new NetworkClient.FlagshipInterceptor((byte)0));
  }
  
  public final String getMpName()
  {
    return "voyager-android";
  }
  
  public final String getMpVersion()
  {
    return "0.21.208";
  }
  
  public final RequestFactory getRequestFactory()
  {
    return factory;
  }
  
  public final String getStoreId()
  {
    return "us_googleplay";
  }
  
  public final boolean isAdTrackingLimited()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.NetworkClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */