package com.linkedin.CrossPromoLib.utils.Network;

import com.linkedin.CrossPromoLib.api.CrossPromoManager;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RequestDelegate.ContentType;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.LinkedInRequestBodyFactory;
import com.linkedin.android.networking.request.RequestDelegateBuilder;

public abstract class BasePostRequest
{
  public static void sendRequest(String paramString, byte[] paramArrayOfByte, ResponseListener paramResponseListener)
  {
    AbstractNetworkClient localAbstractNetworkClient = CrossPromoManager.getNetworkClient();
    paramArrayOfByte = LinkedInRequestBodyFactory.create(RequestDelegate.ContentType.JSON_CONTENT_TYPE, paramArrayOfByte);
    RequestFactory localRequestFactory = localAbstractNetworkClient.getRequestFactory();
    CrossPromoManager.getApplicationContext();
    localAbstractNetworkClient.add(localRequestFactory.getRelativeRequest$3868be9b(1, paramString, paramResponseListener, createsetBodyrequestDelegate));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Network.BasePostRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */