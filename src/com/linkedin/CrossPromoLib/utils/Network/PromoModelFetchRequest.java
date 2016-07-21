package com.linkedin.CrossPromoLib.utils.Network;

import com.linkedin.CrossPromoLib.api.CrossPromoManager;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.RequestDelegateBuilder;

public class PromoModelFetchRequest
{
  public static final String TAG = PromoModelFetchRequest.class.getSimpleName();
  
  public static void sendRequest$313b03d7(String paramString, ResponseListener paramResponseListener)
  {
    AbstractNetworkClient localAbstractNetworkClient = CrossPromoManager.getNetworkClient();
    RequestFactory localRequestFactory = localAbstractNetworkClient.getRequestFactory();
    paramString = "/cross-promo-fe/api/promo/" + paramString;
    CrossPromoManager.getApplicationContext();
    localAbstractNetworkClient.add(localRequestFactory.getRelativeRequest$3868be9b(0, paramString, paramResponseListener, createrequestDelegate));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Network.PromoModelFetchRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */