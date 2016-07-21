package com.linkedin.gen.avro2pegasus.events.me;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class MeNotificationImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MeNotificationImpressionEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasNotifications = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public List<NotificationImpression> notifications = null;
  private UserRequestHeader requestHeader = null;
  
  private MeNotificationImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MeNotificationImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (notifications != null)
    {
      paramFlavor = notifications.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((NotificationImpression)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.me.MeNotificationImpressionEvent", "notifications");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.MeNotificationImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.MeNotificationImpressionEvent", "requestHeader");
            }
            if (hasNotifications) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.MeNotificationImpressionEvent", "notifications");
          }
        }
      }
    }
    return new MeNotificationImpressionEvent(header, requestHeader, mobileHeader, notifications, hasHeader, hasRequestHeader, hasMobileHeader, hasNotifications);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.MeNotificationImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */