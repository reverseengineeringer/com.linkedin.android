package com.linkedin.android.entities.shared;

import android.view.View;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class ChannelOnClickListener
  extends TrackingOnClickListener
{
  private final ActivityComponent activityComponent;
  private final Channel channel;
  
  public ChannelOnClickListener(Channel paramChannel, ActivityComponent paramActivityComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramActivityComponent.tracker(), paramString, paramVarArgs);
    channel = paramChannel;
    activityComponent = paramActivityComponent;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedNavigationUtils.openChannel(channel, activityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.ChannelOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */