package com.linkedin.android.feed.followhub;

import com.linkedin.android.infra.ui.slidingtab.SimpleOnTabSelectedListener;
import com.linkedin.android.infra.ui.slidingtab.TabLayout.Tab;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Map;

final class FollowHubFragment$2
  extends SimpleOnTabSelectedListener
{
  FollowHubFragment$2(FollowHubFragment paramFollowHubFragment) {}
  
  public final void onTabSelected(TabLayout.Tab paramTab, boolean paramBoolean)
  {
    paramTab = (TrackingOnClickListener)FollowHubFragment.access$100(this$0).get(Integer.valueOf(mPosition));
    if (paramTab != null) {
      paramTab.onClick(this$0.tabLayout);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */