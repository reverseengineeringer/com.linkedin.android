package com.linkedin.gen.avro2pegasus.events.media;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class MediaInitializationEndEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MediaInitializationEndEvent>
{
  public long duration = 0L;
  public boolean hasDuration = false;
  private boolean hasHeader = false;
  public boolean hasInitializationStartTime = false;
  public boolean hasMediaTrackingObject = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public long initializationStartTime = 0L;
  public TrackingObject mediaTrackingObject = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private MediaInitializationEndEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MediaInitializationEndEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MediaInitializationEndEvent(header, requestHeader, mobileHeader, mediaTrackingObject, initializationStartTime, duration, hasHeader, hasRequestHeader, hasMobileHeader, hasMediaTrackingObject, hasInitializationStartTime, hasDuration);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationEndEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationEndEvent", "requestHeader");
      }
      if (!hasMediaTrackingObject) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationEndEvent", "mediaTrackingObject");
      }
      if (!hasInitializationStartTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationEndEvent", "initializationStartTime");
      }
    } while (hasDuration);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationEndEvent", "duration");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.media.MediaInitializationEndEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */