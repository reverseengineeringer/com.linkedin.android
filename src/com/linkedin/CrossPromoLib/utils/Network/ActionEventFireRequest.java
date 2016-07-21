package com.linkedin.CrossPromoLib.utils.Network;

import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;

public class ActionEventFireRequest
  extends BasePostRequest
{
  public static final String TAG = ActionEventFireRequest.class.getSimpleName();
  
  public static void fire(PromoModel paramPromoModel, ResponseListener paramResponseListener, MetricsInfo paramMetricsInfo)
  {
    BasePostRequest.sendRequest("/cross-promo-fe/api/actionEvent/", paramPromoModel.getPostBody(paramMetricsInfo), paramResponseListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Network.ActionEventFireRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */