package com.linkedin.gen.avro2pegasus.events.me;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class NotificationImpression$Builder
  implements RecordTemplateBuilder<NotificationImpression>
{
  public long duration = 0L;
  public boolean hasDuration = false;
  public boolean hasInsight = false;
  public boolean hasListPosition = false;
  public boolean hasNotification = false;
  public boolean hasSize = false;
  public boolean hasVisibleTime = false;
  public TrackingObject insight = null;
  public ListPosition listPosition = null;
  public TrackingObject notification = null;
  public EntityDimension size = null;
  public long visibleTime = 0L;
  
  public final NotificationImpression build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NotificationImpression.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NotificationImpression(notification, listPosition, visibleTime, duration, size, insight, hasNotification, hasListPosition, hasVisibleTime, hasDuration, hasSize, hasInsight);
      if (!hasNotification) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "notification");
      }
      if (!hasVisibleTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "visibleTime");
      }
      if (!hasDuration) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "duration");
      }
    } while (hasSize);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "size");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.NotificationImpression.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */