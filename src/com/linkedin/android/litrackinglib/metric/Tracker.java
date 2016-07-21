package com.linkedin.android.litrackinglib.metric;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import com.linkedin.android.litrackinglib.TrackingEventListener;
import com.linkedin.android.litrackinglib.network.MetricQueue;
import com.linkedin.android.litrackinglib.network.MetricQueueIntentService;
import com.linkedin.android.litrackinglib.utils.Utils;
import com.linkedin.android.litrackinglib.viewport.ImpressionTracker;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.networking.util.XLiTrackHeader;
import com.linkedin.android.tracking.v2.app.TrackingAppInterface;
import com.linkedin.android.tracking.v2.event.AbstractTrackingEvent;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.NavigationEvent;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.event.TrackingEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.event.TrackingEventMetricAdapter;
import com.linkedin.android.tracking.v2.network.TrackingNetworkStack;
import com.linkedin.android.tracking.v2.network.TrackingServer;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class Tracker
  implements ImpressionTracker
{
  private static final String TAG = Tracker.class.getSimpleName();
  public String advertiserId;
  public Context appContext;
  public String appId;
  public String applicationViewerUrn;
  public String artifactoryVersion = "unknown";
  public PageInstance currentPageInstance;
  public boolean isAdTrackingLimited;
  public boolean isDebugBuild;
  PageViewEvent lastAnchorPageViewEvent;
  private MetricQueue metricQueue;
  private Stack<AbstractTrackingEvent> navigationTrackingEvents;
  private TrackingNetworkStack networkClient;
  private String serverUrl;
  private String topicNamePrefix;
  public String trackingCodePrefix;
  public TrackingEventListener trackingEventListener;
  public Map<String, String> trackingInfo;
  
  Tracker() {}
  
  public Tracker(Context paramContext, String paramString1, String paramString2, TrackingServer paramTrackingServer)
  {
    this(paramContext, paramString1, paramString2, paramTrackingServer, (byte)0);
  }
  
  public Tracker(Context paramContext, String paramString1, String paramString2, TrackingServer paramTrackingServer, byte paramByte) {}
  
  private Tracker(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    FeatureLog.registerFeature("Tracking");
    appContext = paramContext.getApplicationContext();
    if (!(appContext instanceof TrackingAppInterface)) {
      throw new RuntimeException("Host application class needs to implement TrackingAppInterface");
    }
    networkClient = ((TrackingAppInterface)appContext).getTrackingNetworkStack();
    trackingCodePrefix = paramString2;
    topicNamePrefix = paramString1;
    serverUrl = paramString3;
    isDebugBuild = false;
    metricQueue = new MetricQueue(appContext, networkClient.getClass(), paramString3);
    metricQueue.isDebugBuild = false;
    appContext.getApplicationInfo();
    appId = appContext.getPackageName();
    navigationTrackingEvents = new Stack();
    trackingInfo = new ArrayMap();
    paramContext = XLiTrackHeader.getOsVersion();
    trackingInfo.put("0", paramContext);
    trackingInfo.put("osVersion", paramContext);
    paramContext = XLiTrackHeader.getOsName();
    trackingInfo.put("1", paramContext);
    trackingInfo.put("osName", paramContext);
    paramString1 = XLiTrackHeader.getClientMinorVersion(appContext);
    paramContext = paramString1;
    if (isDebugBuild) {
      paramContext = paramString1 + "-DEBUG";
    }
    if (paramContext != null)
    {
      trackingInfo.put("2", paramContext);
      trackingInfo.put("appVersion", paramContext);
    }
    paramContext = XLiTrackHeader.getCarrier(appContext);
    if (paramContext != null)
    {
      trackingInfo.put("3", paramContext);
      trackingInfo.put("carrier", paramContext);
    }
    paramContext = XLiTrackHeader.getModel();
    trackingInfo.put("4", paramContext);
    trackingInfo.put("deviceModel", paramContext);
    paramContext = appContext.getResources().getConfiguration().locale.toString();
    trackingInfo.put("5", paramContext);
    trackingInfo.put("locale", paramContext);
    switch (appContext.getResources().getConfiguration().orientation)
    {
    default: 
      paramContext = "P";
    }
    for (;;)
    {
      trackingInfo.put("9", paramContext);
      trackingInfo.put("orientation", paramContext);
      return;
      paramContext = "L";
      continue;
      paramContext = "P";
    }
  }
  
  public static Map<String, String> createPageInstanceHeader(PageInstance paramPageInstance)
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("X-li-page-instance", paramPageInstance.toHeaderString());
    return localArrayMap;
  }
  
  private void sendTrackingEvent(TrackingEvent paramTrackingEvent)
  {
    FeatureLog.d(TAG, "Sending Tracking Event: " + paramTrackingEvent.toString(), "Tracking");
    metricQueue.queueMetric(paramTrackingEvent);
    if (trackingEventListener != null) {
      trackingEventListener.onTrackingEventReceived(paramTrackingEvent.getTrackingDetailsForOverlay());
    }
  }
  
  public final void flushQueue()
  {
    MetricQueue localMetricQueue = metricQueue;
    Intent localIntent = new Intent(appContext, MetricQueueIntentService.class);
    localIntent.putExtra("force", true);
    localIntent.putExtra("serverUrl", serverUrl);
    localIntent.putExtra("networkClass", networkClientClass);
    localIntent.putExtra("headers", headers);
    localIntent.putExtra("debugOn", isDebugBuild);
    FeatureLog.d("MetricQueue", "Flushing queue...", "Tracking");
    localMetricQueue.startMetricService(localIntent);
  }
  
  public final PageInstance generateBackgroundPageInstance()
  {
    return new PageInstance(this, "background", UUID.randomUUID());
  }
  
  public final PageInstance getCurrentPageInstance()
  {
    if (currentPageInstance == null) {
      currentPageInstance = new PageInstance(this, "unknown", UUID.randomUUID());
    }
    return currentPageInstance;
  }
  
  public final void send(TrackingEvent paramTrackingEvent)
  {
    PageViewEvent localPageViewEvent;
    Object localObject3;
    String str1;
    Object localObject2;
    String str2;
    if ((paramTrackingEvent instanceof PageViewEvent))
    {
      localPageViewEvent = (PageViewEvent)paramTrackingEvent;
      localObject3 = referer;
      str1 = path;
      if (str1 != null)
      {
        localObject1 = Uri.parse(str1);
        localObject2 = Utils.getParameterValueFromUri((Uri)localObject1, "trk");
        str2 = Utils.getParameterValueFromUri((Uri)localObject1, "lipi");
        localObject1 = Utils.getParameterValueFromUri((Uri)localObject1, "licu");
        if (localObject2 == null) {
          break label202;
        }
        previousPageKey = ((String)localObject2);
        label73:
        if (isAnchorPage)
        {
          lastAnchorPageViewEvent = localPageViewEvent;
          if (navigationTrackingEvents.isEmpty()) {
            break label293;
          }
          if (!(navigationTrackingEvents.peek() instanceof ControlInteractionEvent)) {
            break label443;
          }
        }
      }
    }
    label202:
    label293:
    label336:
    label370:
    label443:
    for (Object localObject1 = (ControlInteractionEvent)navigationTrackingEvents.pop();; localObject1 = null)
    {
      if ((!navigationTrackingEvents.isEmpty()) && ((navigationTrackingEvents.peek() instanceof PageViewEvent))) {}
      for (localObject2 = (PageViewEvent)navigationTrackingEvents.pop();; localObject2 = null)
      {
        if (localObject2 != null)
        {
          if (pageInstance.equals(pageInstance))
          {
            navigationTrackingEvents.clear();
            navigationTrackingEvents.push(localPageViewEvent);
            sendTrackingEvent(paramTrackingEvent);
            return;
            localObject1 = null;
            break;
            if (lastAnchorPageViewEvent == null) {
              break label73;
            }
            if (isAnchorPage)
            {
              previousPageKey = lastAnchorPageViewEvent.pageKey;
              break label73;
            }
            previousPageKey = lastAnchorPageViewEvent.previousPageKey;
            break label73;
          }
          localObject1 = new NavigationEvent(this, localPageViewEvent, (PageViewEvent)localObject2, (ControlInteractionEvent)localObject1, (String)localObject3, str1);
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            sendTrackingEvent((TrackingEvent)localObject1);
            navigationTrackingEvents.clear();
          }
          navigationTrackingEvents.push(localPageViewEvent);
          break;
          localObject2 = new NavigationEvent(this, localPageViewEvent, null, null, (String)localObject3, str1);
          localObject3 = PageInstance.createPageUrnAndTrackingIdFromString(str2);
          controlUrn = ((String)localObject1);
          if (localObject3 != null)
          {
            localObject1 = (String)first;
            previousFullPageUrn = ((String)localObject1);
            if (localObject3 == null) {
              break label370;
            }
          }
          for (localObject1 = (String)second;; localObject1 = null)
          {
            previousFullPageTrackingId = ((String)localObject1);
            localObject1 = localObject2;
            break;
            localObject1 = null;
            break label336;
          }
          if (!(paramTrackingEvent instanceof ControlInteractionEvent)) {
            break;
          }
          localObject1 = (ControlInteractionEvent)paramTrackingEvent;
          if ((!navigationTrackingEvents.isEmpty()) && (((AbstractTrackingEvent)navigationTrackingEvents.peek() instanceof ControlInteractionEvent))) {
            navigationTrackingEvents.pop();
          }
          navigationTrackingEvents.push(localObject1);
          break;
          localObject1 = null;
        }
      }
    }
  }
  
  public final void send(TrackingEventBuilder paramTrackingEventBuilder)
  {
    send(paramTrackingEventBuilder, getCurrentPageInstance());
  }
  
  public final void send(TrackingEventBuilder paramTrackingEventBuilder, PageInstance paramPageInstance)
  {
    FeatureLog.d(TAG, "Sending Tracking Event with builder: " + paramTrackingEventBuilder.toString(), "Tracking");
    if (lastAnchorPageViewEvent != null) {}
    for (String str = lastAnchorPageViewEvent.previousPageKey;; str = null)
    {
      paramPageInstance = new TrackingEventMetricAdapter(this, paramTrackingEventBuilder, paramPageInstance, str, "");
      metricQueue.queueMetric(paramPageInstance);
      if (trackingEventListener != null) {
        trackingEventListener.onTrackingEventReceived(paramTrackingEventBuilder);
      }
      return;
    }
  }
  
  public final JSONObject wrapMetric(JSONObject paramJSONObject, String paramString)
  {
    return wrapMetricWithEventName(paramJSONObject, paramString, "");
  }
  
  public final JSONObject wrapMetricWithEventName(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (TextUtils.isEmpty(paramString2))
    {
      localArrayMap.put("eventName", paramString1);
      localArrayMap.put("topicName", topicNamePrefix + paramString1);
    }
    for (;;)
    {
      localArrayMap.put("appId", appId);
      paramString2 = new JSONObject(localArrayMap);
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("eventInfo", paramString2);
        paramString1.put("eventBody", paramJSONObject);
        return paramString1;
      }
      catch (JSONException paramJSONObject)
      {
        Log.e(TAG, paramJSONObject.getMessage());
      }
      localArrayMap.put("eventName", paramString1);
      localArrayMap.put("topicName", paramString2);
    }
    return paramString1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.metric.Tracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */