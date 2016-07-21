package com.linkedin.android.entities;

import com.linkedin.android.infra.FragmentReferencingPagerAdapter;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.ui.slidingtab.TabLayout;
import com.linkedin.android.infra.ui.slidingtab.TabLayout.OnTabSelectedListener;
import com.linkedin.android.infra.ui.slidingtab.TabLayout.Tab;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class EntityCoordinatorBaseFragment$5
  implements TabLayout.OnTabSelectedListener
{
  EntityCoordinatorBaseFragment$5(EntityCoordinatorBaseFragment paramEntityCoordinatorBaseFragment, TabLayout paramTabLayout, FragmentReferencingPagerAdapter paramFragmentReferencingPagerAdapter) {}
  
  public final void onTabReselected(TabLayout.Tab paramTab, boolean paramBoolean) {}
  
  public final void onTabScrollEnd(TabLayout.Tab paramTab) {}
  
  public final void onTabScrollStart(TabLayout.Tab paramTab) {}
  
  public final void onTabSelectAnimationEnd(TabLayout.Tab paramTab)
  {
    paramTab = val$pagerAdapter.getItemAtPosition(mPosition);
    if ((paramTab instanceof EntityBaseTabFragment))
    {
      paramTab = (EntityBaseTabFragment)paramTab;
      if ((paramTab.isVisible()) && (paramTab.isResumed())) {
        paramTab.toggleImpressionTracking(true);
      }
    }
  }
  
  public final void onTabSelectAnimationStart(TabLayout.Tab paramTab) {}
  
  public final void onTabSelected(TabLayout.Tab paramTab, boolean paramBoolean)
  {
    if (paramBoolean) {
      new TrackingOnClickListener(this$0.tracker, "header_nav", new TrackingEventBuilder[0]).onClick(val$tabLayout);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityCoordinatorBaseFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */