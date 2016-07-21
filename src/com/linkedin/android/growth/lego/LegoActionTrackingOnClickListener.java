package com.linkedin.android.growth.lego;

import android.view.View;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public class LegoActionTrackingOnClickListener
  extends TrackingOnClickListener
{
  private ActionCategory actionCategory;
  private LegoTrackingDataProvider legoTrackingDataProvider;
  private String token;
  
  public LegoActionTrackingOnClickListener(String paramString1, ActionCategory paramActionCategory, LegoTrackingDataProvider paramLegoTrackingDataProvider, Tracker paramTracker, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString2, paramVarArgs);
    token = paramString1;
    actionCategory = paramActionCategory;
    legoTrackingDataProvider = paramLegoTrackingDataProvider;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    legoTrackingDataProvider.sendActionEvent$67c7f505(token, actionCategory);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */