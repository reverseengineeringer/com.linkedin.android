package com.linkedin.android.infra.network;

import android.content.Context;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.request.LinkedInRequestBodyFactory;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.android.perf.commons.IHttpStack;
import java.util.Map;

public final class VoyagerPerfEKGHttpStack
  implements IHttpStack
{
  private Context context;
  private AbstractNetworkClient networkClient;
  
  public VoyagerPerfEKGHttpStack(AbstractNetworkClient paramAbstractNetworkClient, Context paramContext)
  {
    networkClient = paramAbstractNetworkClient;
    context = paramContext;
  }
  
  public final void sendHttpPost(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte)
    throws Exception
  {
    RequestFactory localRequestFactory = networkClient.getRequestFactory();
    paramArrayOfByte = LinkedInRequestBodyFactory.create(null, paramArrayOfByte);
    paramString = localRequestFactory.getAbsoluteRequest$3868be9b(1, paramString, null, createsetAdditionalHeaderssetBodyrequestDelegate);
    networkClient.add(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.VoyagerPerfEKGHttpStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */