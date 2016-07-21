package com.linkedin.android.growth.login.join;

import android.os.Bundle;
import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class JoinFragment$4
  extends TrackingOnClickListener
{
  JoinFragment$4(JoinFragment paramJoinFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = new Bundle();
    paramView.putBoolean("wwe_lix", JoinFragment.access$000(this$0));
    LegalTextChooserDialogBuilder localLegalTextChooserDialogBuilder = new LegalTextChooserDialogBuilder();
    localLegalTextChooserDialogBuilder.setArguments(paramView);
    localLegalTextChooserDialogBuilder.show(this$0.getFragmentManager(), null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */