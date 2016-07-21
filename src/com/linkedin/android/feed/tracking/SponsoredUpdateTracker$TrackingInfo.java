package com.linkedin.android.feed.tracking;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredActivityType;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import java.util.Iterator;
import java.util.Set;

final class SponsoredUpdateTracker$TrackingInfo
{
  SponsoredActivityType atp;
  final Uri cspBaseUrl;
  final ExternalTracking externalTracking;
  int position = -1;
  int renderFormat = 0;
  int sequence = -1;
  final String trackingId;
  
  private SponsoredUpdateTracker$TrackingInfo(TrackingData paramTrackingData, SponsoredMetadata paramSponsoredMetadata)
  {
    trackingId = trackingId;
    cspBaseUrl = createBaseCspUrl(tscpUrl);
    externalTracking = externalTracking;
    atp = activityType;
  }
  
  private static Uri createBaseCspUrl(String paramString)
  {
    paramString = Uri.parse(paramString);
    Object localObject = paramString.getQueryParameterNames();
    Uri.Builder localBuilder = SponsoredUpdateTracker.access$1200().buildUpon();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localBuilder.appendQueryParameter(str, paramString.getQueryParameter(str));
    }
    return localBuilder.build();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.SponsoredUpdateTracker.TrackingInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */