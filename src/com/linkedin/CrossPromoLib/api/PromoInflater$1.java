package com.linkedin.CrossPromoLib.api;

import android.util.Log;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class PromoInflater$1
  implements ResponseListener<byte[], Object>
{
  PromoInflater$1(PromoInflater paramPromoInflater, String paramString, Map paramMap) {}
  
  public final void onFailure(int paramInt, Object paramObject, Map<String, List<String>> paramMap, IOException paramIOException)
  {
    Log.e(PromoInflater.access$000(), "Failed to render promo", paramIOException);
  }
  
  public final Object parseErrorResponse(RawResponse paramRawResponse)
    throws IOException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoInflater.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */