package com.linkedin.android.feed.followhub;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class FollowHubFragment$1
  extends TrackingOnClickListener
{
  FollowHubFragment$1(FollowHubFragment paramFollowHubFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FollowHubFragment.access$000(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */