package com.linkedin.android.feed.tracking;

import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class SponsoredUpdateTracker$2
  implements ResponseListener<Object, Object>
{
  SponsoredUpdateTracker$2(SponsoredUpdateTracker paramSponsoredUpdateTracker, String paramString) {}
  
  public final void onFailure(int paramInt, Object paramObject, Map<String, List<String>> paramMap, IOException paramIOException)
  {
    Log.e("Sponsored Update Tracking", SponsoredUpdateTracker.access$900$5bd6f0b3(val$event, paramInt));
  }
  
  public final void onSuccess(int paramInt, Object paramObject, Map<String, List<String>> paramMap)
  {
    if (paramInt >= 300)
    {
      Log.e("Sponsored Update Tracking", SponsoredUpdateTracker.access$900$5bd6f0b3(val$event, paramInt));
      return;
    }
    FeatureLog.d("Sponsored Update Tracking", SponsoredUpdateTracker.access$1000$5bd6f0b3(val$event, paramInt), "Sponsored Update Tracking");
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
 * Qualified Name:     com.linkedin.android.feed.tracking.SponsoredUpdateTracker.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */