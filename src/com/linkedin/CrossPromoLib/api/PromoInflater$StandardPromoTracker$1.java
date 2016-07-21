package com.linkedin.CrossPromoLib.api;

import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import java.io.IOException;
import java.util.Map;

final class PromoInflater$StandardPromoTracker$1
  implements ResponseListener
{
  PromoInflater$StandardPromoTracker$1(PromoInflater.StandardPromoTracker paramStandardPromoTracker, Runnable paramRunnable) {}
  
  public final void onFailure(int paramInt, Object paramObject, Map paramMap, IOException paramIOException) {}
  
  public final void onSuccess(int paramInt, Object paramObject, Map paramMap)
  {
    val$next.run();
  }
  
  public final Object parseErrorResponse(RawResponse paramRawResponse)
    throws IOException
  {
    return null;
  }
  
  public final Object parseSuccessResponse(RawResponse paramRawResponse)
    throws IOException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoInflater.StandardPromoTracker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */