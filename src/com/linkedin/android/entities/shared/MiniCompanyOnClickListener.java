package com.linkedin.android.entities.shared;

import android.view.View;
import android.widget.ImageView;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public class MiniCompanyOnClickListener
  extends TrackingOnClickListener
{
  private final ActivityComponent activityComponent;
  private final ImageView logoView;
  private final MiniCompany miniCompany;
  
  public MiniCompanyOnClickListener(MiniCompany paramMiniCompany, ActivityComponent paramActivityComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramActivityComponent.tracker(), paramString, paramVarArgs);
    miniCompany = paramMiniCompany;
    activityComponent = paramActivityComponent;
    logoView = null;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedNavigationUtils.openMiniCompany(miniCompany, activityComponent, logoView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.MiniCompanyOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */