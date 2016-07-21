package com.linkedin.android.entities.shared;

import android.view.View;
import android.widget.ImageView;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class MiniGroupOnClickListener
  extends TrackingOnClickListener
{
  private final ActivityComponent activityComponent;
  private final ImageView logoView;
  private final MiniGroup miniGroup;
  
  public MiniGroupOnClickListener(MiniGroup paramMiniGroup, ActivityComponent paramActivityComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramActivityComponent.tracker(), paramString, paramVarArgs);
    miniGroup = paramMiniGroup;
    activityComponent = paramActivityComponent;
    logoView = null;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedNavigationUtils.openMiniGroup(miniGroup, activityComponent, logoView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.MiniGroupOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */