package com.linkedin.android.growth.abi;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class MainAbiResultFragment$3
  extends TrackingOnClickListener
{
  MainAbiResultFragment$3(MainAbiResultFragment paramMainAbiResultFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    AbiActivity.restartAbiFlow(this$0.getActivity());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.MainAbiResultFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */