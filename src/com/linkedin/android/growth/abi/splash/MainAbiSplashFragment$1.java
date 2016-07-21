package com.linkedin.android.growth.abi.splash;

import android.view.View;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class MainAbiSplashFragment$1
  extends TrackingOnClickListener
{
  MainAbiSplashFragment$1(MainAbiSplashFragment paramMainAbiSplashFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    NavigationUtils.onUpPressed(this$0.getActivity(), true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */