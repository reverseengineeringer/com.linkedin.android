package com.linkedin.android.feed.shared;

import android.view.View;
import com.linkedin.android.identity.profile.view.topcard.events.SendInvitationEvent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class ConnectInvitationOnClickListener
  extends TrackingOnClickListener
{
  private final Bus eventBus;
  private final MiniProfile miniProfile;
  
  public ConnectInvitationOnClickListener(FragmentComponent paramFragmentComponent, MiniProfile paramMiniProfile, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    eventBus = paramFragmentComponent.eventBus();
    miniProfile = paramMiniProfile;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    Bus.publish(new SendInvitationEvent(miniProfile, 2));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.ConnectInvitationOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */