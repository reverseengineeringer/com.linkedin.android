package com.linkedin.android.feed.utils;

import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

public final class FeedWebRouterUtil
{
  public static void sendMenuTracking(ApplicationComponent paramApplicationComponent, String paramString1, String paramString2, String paramString3)
  {
    paramApplicationComponent = paramApplicationComponent.tracker();
    paramApplicationComponent.send(FeedTracking.createFeedActionEvent(paramApplicationComponent, ActionCategory.EXPAND, "more", "expandMoreShareOptions", paramString2, paramString1, paramString3, "feed-item:phone"));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedWebRouterUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */