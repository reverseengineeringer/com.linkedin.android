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

public final class MediaInitializationStartEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MediaInitializationStartEvent>
{
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
  
  private MediaInitializationStartEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MediaInitializationStartEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MediaInitializationStartEvent(header, requestHeader, mobileHeader, mediaTrackingObject, initializationStartTime, hasHeader, hasRequestHeader, hasMobileHeader, hasMediaTrackingObject, hasInitializationStartTime);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationStartEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationStartEvent", "requestHeader");
      }
      if (!hasMediaTrackingObject) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationStartEvent", "mediaTrackingObject");
      }
    } while (hasInitializationStartTime);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaInitializationStartEvent", "initializationStartTime");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.media.MediaInitializationStartEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */