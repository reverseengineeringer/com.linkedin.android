package com.linkedin.android.feed.tracking;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.DefaultRequestDelegate;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredActivityType;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SponsoredUpdateTracker
{
  private static final Uri BASE_CSP_URL = Uri.parse("https://www.linkedin.com/csp/sct");
  private final Context appContext;
  private final LixManager lixManager;
  private final NetworkClient networkClient;
  final List<PendingActionEvent> pendingActionEvents = new ArrayList();
  private final ArrayMap<String, TrackingInfo> trackingInfos = new ArrayMap();
  
  public SponsoredUpdateTracker(Context paramContext, NetworkClient paramNetworkClient)
  {
    appContext = paramContext.getApplicationContext();
    networkClient = paramNetworkClient;
    FeatureLog.registerFeature("Sponsored Update Tracking");
    lixManager = Util.getAppComponent(paramContext).lixManager();
  }
  
  private TrackingInfo getTrackingInfo(TrackingData paramTrackingData, SponsoredMetadata paramSponsoredMetadata, int paramInt1, int paramInt2)
  {
    Object localObject2 = Uri.parse(tscpUrl).getQueryParameter("trk");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = trackingId;
    }
    TrackingInfo localTrackingInfo = (TrackingInfo)trackingInfos.get(localObject1);
    localObject2 = localTrackingInfo;
    if (localTrackingInfo == null)
    {
      localObject2 = new TrackingInfo(paramTrackingData, paramSponsoredMetadata, (byte)0);
      trackingInfos.put(localObject1, localObject2);
    }
    if ((position == -1) && (paramInt2 != -1)) {
      position = paramInt2;
    }
    if ((renderFormat == 0) && (paramInt1 != 0)) {
      renderFormat = paramInt1;
    }
    return (TrackingInfo)localObject2;
  }
  
  private String populateCspUrl(TrackingInfo paramTrackingInfo, String paramString, int paramInt)
  {
    Object localObject = cspBaseUrl;
    int i = renderFormat;
    SponsoredActivityType localSponsoredActivityType = atp;
    int j = position;
    paramTrackingInfo = ((Uri)localObject).buildUpon();
    localObject = FeedTracking.getSponsoredRenderFormatString(i);
    if (FeedLixHelper.isEnabled(lixManager, Lix.FEED_SU_ACTIVITY_TYPE))
    {
      if (paramInt != -1) {
        paramTrackingInfo.appendQueryParameter("seq", Integer.toString(paramInt));
      }
      paramTrackingInfo.appendQueryParameter("c", "3000");
      paramTrackingInfo.appendQueryParameter("action", paramString);
      if (SponsoredActivityType.SPONSORED == localSponsoredActivityType)
      {
        paramTrackingInfo.appendQueryParameter("atp", "sponsored");
        paramTrackingInfo.appendQueryParameter("pos", Integer.toString(j));
        paramTrackingInfo.appendQueryParameter("renderedFormat", (String)localObject);
      }
    }
    for (;;)
    {
      return paramTrackingInfo.build().toString();
      if (SponsoredActivityType.VIRAL == localSponsoredActivityType)
      {
        paramTrackingInfo.appendQueryParameter("atp", "viral");
      }
      else
      {
        Log.e("Sponsored Update Tracking", "Missing activity type or Unknown activity type");
        continue;
        paramTrackingInfo.appendQueryParameter("pos", Integer.toString(j));
        if (paramInt != -1) {
          paramTrackingInfo.appendQueryParameter("seq", Integer.toString(paramInt));
        }
        paramTrackingInfo.appendQueryParameter("c", "3000");
        paramTrackingInfo.appendQueryParameter("atp", "sponsored");
        paramTrackingInfo.appendQueryParameter("renderedFormat", (String)localObject);
        paramTrackingInfo.appendQueryParameter("action", paramString);
      }
    }
  }
  
  private void trackSponsoredEvent(final Map<String, String> paramMap, final String paramString, List<String> paramList)
  {
    ResponseListener local1 = new ResponseListener()
    {
      public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map<String, List<String>> paramAnonymousMap, IOException paramAnonymousIOException)
      {
        Log.e("Sponsored Update Tracking", SponsoredUpdateTracker.access$900$5bd6f0b3(paramString, paramAnonymousInt));
      }
      
      public final void onSuccess(int paramAnonymousInt, Object paramAnonymousObject, Map<String, List<String>> paramAnonymousMap)
      {
        if (paramAnonymousInt >= 300)
        {
          Log.e("Sponsored Update Tracking", SponsoredUpdateTracker.access$900$5bd6f0b3(paramString, paramAnonymousInt));
          return;
        }
        FeatureLog.d("Sponsored Update Tracking", SponsoredUpdateTracker.access$1000$5bd6f0b3(paramString, paramAnonymousInt), "Sponsored Update Tracking");
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
    };
    FeatureLog.d("Sponsored Update Tracking", "Hitting csp tracking url: ".concat(paramString), "Sponsored Update Tracking");
    DefaultRequestDelegate localDefaultRequestDelegate = null;
    if (paramMap != null) {
      localDefaultRequestDelegate = createsetAdditionalHeadersrequestDelegate;
    }
    networkClient.add(networkClient.factory.getAbsoluteRequest$3868be9b(0, paramString, local1, localDefaultRequestDelegate));
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        paramMap = (String)paramList.get(i);
        FeatureLog.d("Sponsored Update Tracking", "Hitting sponsored tracking url: ".concat(paramMap), "Sponsored Update Tracking");
        paramString = new ResponseListener()
        {
          public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map<String, List<String>> paramAnonymousMap, IOException paramAnonymousIOException)
          {
            Log.e("Sponsored Update Tracking", SponsoredUpdateTracker.access$900$5bd6f0b3(paramMap, paramAnonymousInt));
          }
          
          public final void onSuccess(int paramAnonymousInt, Object paramAnonymousObject, Map<String, List<String>> paramAnonymousMap)
          {
            if (paramAnonymousInt >= 300)
            {
              Log.e("Sponsored Update Tracking", SponsoredUpdateTracker.access$900$5bd6f0b3(paramMap, paramAnonymousInt));
              return;
            }
            FeatureLog.d("Sponsored Update Tracking", SponsoredUpdateTracker.access$1000$5bd6f0b3(paramMap, paramAnonymousInt), "Sponsored Update Tracking");
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
        };
        networkClient.add(networkClient.factory.getAbsoluteRequest$3868be9b(0, paramMap, paramString, localDefaultRequestDelegate));
        i += 1;
      }
    }
  }
  
  final void actuallyTrackAction(Map<String, String> paramMap, TrackingInfo paramTrackingInfo, String paramString)
  {
    paramString = populateCspUrl(paramTrackingInfo, paramString, -1);
    if (externalTracking == null) {}
    for (paramTrackingInfo = null;; paramTrackingInfo = externalTracking.impressionUrls)
    {
      trackSponsoredEvent(paramMap, paramString, paramTrackingInfo);
      return;
    }
  }
  
  final TrackingInfo getTrackingInfo(TrackingData paramTrackingData, SponsoredMetadata paramSponsoredMetadata)
  {
    return getTrackingInfo(paramTrackingData, paramSponsoredMetadata, 0, -1);
  }
  
  public final void trackDetailImpression(Map<String, String> paramMap, TrackingData paramTrackingData, SponsoredMetadata paramSponsoredMetadata)
  {
    paramTrackingData = getTrackingInfo(paramTrackingData, paramSponsoredMetadata);
    TrackingInfo.access$008(paramTrackingData);
    paramSponsoredMetadata = populateCspUrl(paramTrackingData, "impression", sequence);
    if (externalTracking == null) {}
    for (paramTrackingData = null;; paramTrackingData = externalTracking.impressionUrls)
    {
      trackSponsoredEvent(paramMap, paramSponsoredMetadata, paramTrackingData);
      return;
    }
  }
  
  public final void trackImpression(Map<String, String> paramMap, TrackingData paramTrackingData, SponsoredMetadata paramSponsoredMetadata, int paramInt1, int paramInt2)
  {
    paramSponsoredMetadata = getTrackingInfo(paramTrackingData, paramSponsoredMetadata, paramInt1, paramInt2);
    TrackingInfo.access$008(paramSponsoredMetadata);
    Object localObject = populateCspUrl(paramSponsoredMetadata, "impression", sequence);
    if (externalTracking == null) {}
    for (paramTrackingData = null;; paramTrackingData = externalTracking.impressionUrls)
    {
      trackSponsoredEvent(paramMap, (String)localObject, paramTrackingData);
      if (!TrackingInfo.access$200(paramSponsoredMetadata)) {
        break;
      }
      paramTrackingData = pendingActionEvents.iterator();
      while (paramTrackingData.hasNext())
      {
        localObject = (PendingActionEvent)paramTrackingData.next();
        if (info.trackingId.equals(trackingId))
        {
          paramTrackingData.remove();
          actuallyTrackAction(paramMap, info, action);
        }
      }
    }
  }
  
  private static final class PendingActionEvent
  {
    final String action;
    final SponsoredUpdateTracker.TrackingInfo info;
    
    private PendingActionEvent(SponsoredUpdateTracker.TrackingInfo paramTrackingInfo, String paramString)
    {
      info = paramTrackingInfo;
      action = paramString;
    }
  }
  
  private static final class TrackingInfo
  {
    SponsoredActivityType atp;
    final Uri cspBaseUrl;
    final ExternalTracking externalTracking;
    int position = -1;
    int renderFormat = 0;
    int sequence = -1;
    final String trackingId;
    
    private TrackingInfo(TrackingData paramTrackingData, SponsoredMetadata paramSponsoredMetadata)
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
      Uri.Builder localBuilder = SponsoredUpdateTracker.BASE_CSP_URL.buildUpon();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localBuilder.appendQueryParameter(str, paramString.getQueryParameter(str));
      }
      return localBuilder.build();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.SponsoredUpdateTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */