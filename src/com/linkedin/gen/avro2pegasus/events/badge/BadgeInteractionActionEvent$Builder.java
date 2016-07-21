package com.linkedin.gen.avro2pegasus.events.badge;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.badge.AppTabType;
import com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ControlInteractionType;

public final class BadgeInteractionActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<BadgeInteractionActionEvent>
{
  public int appBadgeCount = 0;
  public AppTabType badgeTabCleared = null;
  public String controlUrn = null;
  public boolean hasAppBadgeCount = false;
  public boolean hasBadgeTabCleared = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  public boolean hasInteractionType = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasTabBadgeDetails = false;
  private EventHeader header = null;
  public ControlInteractionType interactionType = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public TabBadgeDetails tabBadgeDetails = null;
  
  private BadgeInteractionActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (BadgeInteractionActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new BadgeInteractionActionEvent(header, requestHeader, mobileHeader, badgeTabCleared, controlUrn, interactionType, tabBadgeDetails, appBadgeCount, hasHeader, hasRequestHeader, hasMobileHeader, hasBadgeTabCleared, hasControlUrn, hasInteractionType, hasTabBadgeDetails, hasAppBadgeCount);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "requestHeader");
      }
    } while (hasTabBadgeDetails);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "tabBadgeDetails");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */