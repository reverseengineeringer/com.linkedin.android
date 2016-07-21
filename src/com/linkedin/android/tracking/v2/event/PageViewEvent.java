package com.linkedin.android.tracking.v2.event;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.Page;

public class PageViewEvent
  extends AbstractTrackingEvent
{
  public boolean isAnchorPage;
  public PageInstance pageInstance;
  public String pageKey;
  public String path;
  public String previousPageKey;
  public String referer;
  public final long timestamp = System.currentTimeMillis();
  
  public PageViewEvent(Tracker paramTracker, Page paramPage)
  {
    this(paramTracker, paramPage.pageKey(), paramPage.isAnchorPage());
  }
  
  public PageViewEvent(Tracker paramTracker, String paramString, boolean paramBoolean)
  {
    this(paramTracker, paramString, paramBoolean, paramTracker.getCurrentPageInstance());
  }
  
  public PageViewEvent(Tracker paramTracker, String paramString, boolean paramBoolean, PageInstance paramPageInstance)
  {
    super(paramTracker);
    pageKey = (trackingCodePrefix + '_' + paramString);
    isAnchorPage = paramBoolean;
    if ((paramBoolean) && (paramPageInstance != null)) {}
    for (;;)
    {
      pageInstance = paramPageInstance;
      return;
      paramPageInstance = paramTracker.getCurrentPageInstance();
    }
  }
  
  public final String getTrackingDetailsForOverlay()
  {
    return PageViewEvent.class.getSimpleName() + " - " + pageKey;
  }
  
  public String toString()
  {
    return "pageKey: " + pageKey + ", isAnchorPage: " + isAnchorPage + ", pageInstance: [" + pageInstance.toString() + "]";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.event.PageViewEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */