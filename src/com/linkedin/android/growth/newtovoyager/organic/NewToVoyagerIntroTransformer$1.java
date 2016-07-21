package com.linkedin.android.growth.newtovoyager.organic;

import android.view.View;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class NewToVoyagerIntroTransformer$1
  extends TrackingOnClickListener
{
  NewToVoyagerIntroTransformer$1(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    val$fragmentComponent.eventBus();
    Bus.publish(new NewToVoyagerIntroWelcomeFragment.NewToVoyagerSkipEvent());
    paramView = val$fragmentComponent.activity();
    if (paramView != null)
    {
      HomeIntent localHomeIntent = val$fragmentComponent.intentRegistry().home;
      HomeBundle localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.FEED;
      NavigationUtils.navigateUp(paramView, localHomeIntent.newIntent(paramView, localHomeBundle), false);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */