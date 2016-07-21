package com.linkedin.gen.avro2pegasus.events.badge;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.badge.AppTabType;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class AppForegroundBadgeEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<AppForegroundBadgeEvent>
{
  public ActionSource actionSource = null;
  public int appBadgeCount = 0;
  public boolean hasActionSource = false;
  public boolean hasAppBadgeCount = false;
  private boolean hasHeader = false;
  public boolean hasLandingTab = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public AppTabType landingTab = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private AppForegroundBadgeEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AppForegroundBadgeEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new AppForegroundBadgeEvent(header, requestHeader, mobileHeader, appBadgeCount, actionSource, landingTab, hasHeader, hasRequestHeader, hasMobileHeader, hasAppBadgeCount, hasActionSource, hasLandingTab);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "requestHeader");
      }
    } while (hasAppBadgeCount);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "appBadgeCount");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */