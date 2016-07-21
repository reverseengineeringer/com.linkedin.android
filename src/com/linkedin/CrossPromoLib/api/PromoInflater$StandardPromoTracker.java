package com.linkedin.CrossPromoLib.api;

import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.utils.Network.ActionEventFireRequest;
import com.linkedin.CrossPromoLib.utils.Network.ImpressionEventFireRequest;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import java.io.IOException;
import java.util.Map;

public final class PromoInflater$StandardPromoTracker
  implements PromoTracker
{
  public final void trackAction(PromoModel paramPromoModel, MetricsInfo paramMetricsInfo, final Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    for (paramRunnable = null;; paramRunnable = new ResponseListener()
        {
          public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map paramAnonymousMap, IOException paramAnonymousIOException) {}
          
          public final void onSuccess(int paramAnonymousInt, Object paramAnonymousObject, Map paramAnonymousMap)
          {
            paramRunnable.run();
          }
          
          public final Object parseErrorResponse(RawResponse paramAnonymousRawResponse)
            throws IOException
          {
            return null;
          }
          
          public final Object parseSuccessResponse(RawResponse paramAnonymousRawResponse)
            throws IOException
          {
            return null;
          }
        })
    {
      ActionEventFireRequest.fire(paramPromoModel, paramRunnable, paramMetricsInfo);
      return;
    }
  }
  
  public final void trackImpression(PromoModel paramPromoModel, MetricsInfo paramMetricsInfo, final Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    for (paramRunnable = null;; paramRunnable = new ResponseListener()
        {
          public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map paramAnonymousMap, IOException paramAnonymousIOException) {}
          
          public final void onSuccess(int paramAnonymousInt, Object paramAnonymousObject, Map paramAnonymousMap)
          {
            paramRunnable.run();
          }
          
          public final Object parseErrorResponse(RawResponse paramAnonymousRawResponse)
            throws IOException
          {
            return null;
          }
          
          public final Object parseSuccessResponse(RawResponse paramAnonymousRawResponse)
            throws IOException
          {
            return null;
          }
        })
    {
      ImpressionEventFireRequest.fire(paramPromoModel, paramRunnable, paramMetricsInfo);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoInflater.StandardPromoTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */