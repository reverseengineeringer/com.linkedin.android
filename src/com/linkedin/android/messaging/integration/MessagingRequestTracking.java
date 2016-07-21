package com.linkedin.android.messaging.integration;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.PageInstance;
import java.util.Map;

public final class MessagingRequestTracking
{
  final String loadMorePageKey;
  final Map<String, String> pageInstanceHeader;
  public final String pageKey;
  final String refreshPageKey;
  
  public MessagingRequestTracking(PageInstance paramPageInstance, String paramString)
  {
    if (paramPageInstance != null) {}
    for (paramPageInstance = Tracker.createPageInstanceHeader(paramPageInstance);; paramPageInstance = null)
    {
      pageInstanceHeader = paramPageInstance;
      pageKey = paramString;
      loadMorePageKey = paramString;
      refreshPageKey = paramString;
      return;
    }
  }
  
  public MessagingRequestTracking(PageInstance paramPageInstance, String paramString1, String paramString2, String paramString3)
  {
    if (paramPageInstance != null) {}
    for (paramPageInstance = Tracker.createPageInstanceHeader(paramPageInstance);; paramPageInstance = null)
    {
      pageInstanceHeader = paramPageInstance;
      pageKey = paramString1;
      loadMorePageKey = paramString2;
      refreshPageKey = paramString3;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.integration.MessagingRequestTracking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */