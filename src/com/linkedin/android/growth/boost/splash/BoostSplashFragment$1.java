package com.linkedin.android.growth.boost.splash;

import android.view.View;
import com.linkedin.android.growth.boost.BoostUtil;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PegasusTrackingEventBuilder;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent.Builder;
import java.util.Collections;

final class BoostSplashFragment$1
  extends TrackingOnClickListener
{
  BoostSplashFragment$1(BoostSplashFragment paramBoostSplashFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    Tracker localTracker = this$0.tracker;
    PromotionActionEvent.Builder localBuilder = new PromotionActionEvent.Builder().setControlUrn(PegasusTrackingEventBuilder.buildControlUrn(this$0.tracker.getCurrentPageInstance().pageKey, "continue")).setPhoneNumberInfo(BoostUtil.getPhoneNumberInfo(this$0.getActivity()));
    FlagshipSharedPreferences localFlagshipSharedPreferences = this$0.sharedPreferences;
    this$0.getActivity();
    localTracker.send(localBuilder.setProductUrns(Collections.singletonList(BoostUtil.getProductUrn$63ab225c(localFlagshipSharedPreferences))));
    super.onClick(paramView);
    ((LegoWidget)this$0.getParentFragment()).finishCurrentFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.splash.BoostSplashFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */