package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.me.notifications.cards.MeCardDismissListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class NewToVoyagerBannerViewTransformer
{
  public static LegoTrackingDataProvider getLegoTrackingDataProvider(FragmentComponent paramFragmentComponent)
  {
    paramFragmentComponent = paramFragmentComponent.activity();
    if (paramFragmentComponent == null) {
      return null;
    }
    return activityComponent.legoTrackingDataProvider();
  }
  
  public static void sendLegoWidgetImpressionEvent(FragmentComponent paramFragmentComponent, String paramString)
  {
    paramFragmentComponent = getLegoTrackingDataProvider(paramFragmentComponent);
    if (paramFragmentComponent != null) {
      paramFragmentComponent.sendWidgetImpressionEvent$4bb724c7(paramString, Visibility.SHOW);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerBannerViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */