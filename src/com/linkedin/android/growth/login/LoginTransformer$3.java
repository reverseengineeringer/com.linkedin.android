package com.linkedin.android.growth.login;

import android.view.View;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class LoginTransformer$3
  extends TrackingOnClickListener
{
  public LoginTransformer$3(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, PreRegListener paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    val$preRegListener.showJoinScreen();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginTransformer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */