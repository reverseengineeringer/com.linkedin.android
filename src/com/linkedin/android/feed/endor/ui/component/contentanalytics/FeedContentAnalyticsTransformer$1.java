package com.linkedin.android.feed.endor.ui.component.contentanalytics;

import android.view.View;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsBundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.NavigationManager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class FeedContentAnalyticsTransformer$1
  extends TrackingOnClickListener
{
  FeedContentAnalyticsTransformer$1(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, Urn paramUrn, SocialUpdateType paramSocialUpdateType, NavigationManager paramNavigationManager, IntentRegistry paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = new ContentAnalyticsBundleBuilder(val$updateUrn, val$type);
    val$navigationManager.navigate(val$intentRegistry.contentAnalytics, paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentanalytics.FeedContentAnalyticsTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */