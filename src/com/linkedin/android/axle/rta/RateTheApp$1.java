package com.linkedin.android.axle.rta;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;

final class RateTheApp$1
  extends TrackingOnClickListener
{
  RateTheApp$1(RateTheApp paramRateTheApp, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Context paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    try
    {
      RateTheAppTransformer.sendLegoWidgetActionEvent(val$fragmentComponent, this$0.legoTrackingToken, ActionCategory.DISMISS);
      paramView = AnimationUtils.loadAnimation(val$context, 2131034149);
      this$0.firstView.startAnimation(paramView);
      this$0.firstView.setVisibility(8);
      return;
    }
    catch (BuilderException paramView)
    {
      for (;;)
      {
        val$fragmentComponent.context();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create Dismiss lego action event"));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */