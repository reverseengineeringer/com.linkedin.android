package com.linkedin.android.growth.boost.error;

import android.view.View;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class BoostErrorFragment$1
  extends TrackingOnClickListener
{
  BoostErrorFragment$1(BoostErrorFragment paramBoostErrorFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.startActivity(this$0.intentRegistry.home.newIntent(this$0.getActivity(), new HomeBundle()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.error.BoostErrorFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */