package com.linkedin.android.growth.abi;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class MainAbiResultFragment$1
  extends TrackingOnClickListener
{
  MainAbiResultFragment$1(MainAbiResultFragment paramMainAbiResultFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.getActivity().onBackPressed();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.MainAbiResultFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */