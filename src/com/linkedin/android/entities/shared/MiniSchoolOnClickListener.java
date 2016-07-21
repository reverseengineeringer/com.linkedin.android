package com.linkedin.android.entities.shared;

import android.view.View;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class MiniSchoolOnClickListener
  extends TrackingOnClickListener
{
  private ActivityComponent activityComponent;
  private MiniSchool miniSchool;
  
  public MiniSchoolOnClickListener(MiniSchool paramMiniSchool, ActivityComponent paramActivityComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramActivityComponent.tracker(), paramString, paramVarArgs);
    miniSchool = paramMiniSchool;
    activityComponent = paramActivityComponent;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedNavigationUtils.openMiniSchool(miniSchool, activityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.MiniSchoolOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */