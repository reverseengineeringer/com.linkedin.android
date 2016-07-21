package com.linkedin.android.feed.page.feed.newupdatespill;

import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;

public final class NewUpdatesPillTrackingEvent
  extends ControlInteractionEvent
{
  private final ApplicationComponent appComponent;
  
  public NewUpdatesPillTrackingEvent(ApplicationComponent paramApplicationComponent, String paramString, ControlType paramControlType, InteractionType paramInteractionType)
  {
    super(paramApplicationComponent.tracker(), paramString, paramControlType, paramInteractionType);
    appComponent = paramApplicationComponent;
  }
  
  public final String getTopic()
  {
    return ControlInteractionEvent.class.getSimpleName();
  }
  
  public final void send()
  {
    super.send();
    appComponent.newUpdatesChecker().resetCurrentPageInstance();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillTrackingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */