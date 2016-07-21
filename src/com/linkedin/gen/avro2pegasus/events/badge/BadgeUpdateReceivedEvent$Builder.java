package com.linkedin.gen.avro2pegasus.events.badge;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class BadgeUpdateReceivedEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<BadgeUpdateReceivedEvent>
{
  public int existingAppBadgeCount = 0;
  public TabBadgeDetails existingTabBadgeDetails = null;
  public boolean hasExistingAppBadgeCount = false;
  public boolean hasExistingTabBadgeDetails = false;
  private boolean hasHeader = false;
  public boolean hasIsFirstUpdate = false;
  private boolean hasMobileHeader = false;
  public boolean hasNewAppBadgeCount = false;
  public boolean hasNewTabBadgeDetails = false;
  private boolean hasRequestHeader = false;
  public boolean hasUpdateType = false;
  private EventHeader header = null;
  public boolean isFirstUpdate = false;
  private MobileHeader mobileHeader = null;
  public int newAppBadgeCount = 0;
  public TabBadgeDetails newTabBadgeDetails = null;
  private UserRequestHeader requestHeader = null;
  public UpdateType updateType = null;
  
  private BadgeUpdateReceivedEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (BadgeUpdateReceivedEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new BadgeUpdateReceivedEvent(header, requestHeader, mobileHeader, isFirstUpdate, updateType, existingTabBadgeDetails, existingAppBadgeCount, newTabBadgeDetails, newAppBadgeCount, hasHeader, hasRequestHeader, hasMobileHeader, hasIsFirstUpdate, hasUpdateType, hasExistingTabBadgeDetails, hasExistingAppBadgeCount, hasNewTabBadgeDetails, hasNewAppBadgeCount);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "requestHeader");
      }
      if (!hasIsFirstUpdate) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "isFirstUpdate");
      }
    } while (hasNewTabBadgeDetails);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "newTabBadgeDetails");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */