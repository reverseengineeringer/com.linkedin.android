package com.linkedin.android.identity.me.notifications;

import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.TabSelectedEvent;
import com.linkedin.android.home.badging.BadgeUpdateEvent;
import com.linkedin.android.identity.me.shared.paging.CollectionDataErrorEvent;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.RecyclerViewUtils;
import org.greenrobot.eventbus.Subscribe;

final class NotificationsFragment$5
{
  NotificationsFragment$5(NotificationsFragment paramNotificationsFragment) {}
  
  @Subscribe
  public final void onEvent(TabSelectedEvent paramTabSelectedEvent)
  {
    if ((tab == HomeTabInfo.NOTIFICATIONS) && (alreadySelected) && (tapSelected) && (!this$0.isDetached())) {
      RecyclerViewUtils.smoothScrollToTop(this$0.recyclerView, NotificationsFragment.access$200(this$0), 15);
    }
  }
  
  @Subscribe
  public final void onEvent(BadgeUpdateEvent paramBadgeUpdateEvent)
  {
    if (("enabled".equals(this$0.applicationComponent.lixManager().getTreatment(Lix.ME_LIVE_UPDATE))) && (tabInfo == HomeTabInfo.NOTIFICATIONS))
    {
      if (this$0.prevBadgeValue != -1L) {
        break label75;
      }
      this$0.prevBadgeValue = count.longValue();
      this$0.shouldRefresh = false;
    }
    label75:
    while (this$0.prevBadgeValue == count.longValue()) {
      return;
    }
    this$0.prevBadgeValue = count.longValue();
    this$0.shouldRefresh = true;
  }
  
  @Subscribe
  public final void onEvent(CollectionDataErrorEvent paramCollectionDataErrorEvent)
  {
    NotificationsFragment.access$300(this$0, paramCollectionDataErrorEvent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.NotificationsFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */