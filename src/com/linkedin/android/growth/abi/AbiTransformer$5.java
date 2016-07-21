package com.linkedin.android.growth.abi;

import android.view.View;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseLegoWidget;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class AbiTransformer$5
  extends TrackingOnClickListener
{
  AbiTransformer$5(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, AbiSplashBaseLegoWidget paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    val$abiSplashBaseLegoWidget.showLearnMoreFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiTransformer.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */