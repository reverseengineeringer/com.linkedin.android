package com.linkedin.android.growth.login.join;

import android.view.KeyEvent;
import android.widget.TextView;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnEditorActionListener;

final class JoinFragment$3
  extends TrackingOnEditorActionListener
{
  JoinFragment$3(JoinFragment paramJoinFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    super.onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return this$0.onEditorAction(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */