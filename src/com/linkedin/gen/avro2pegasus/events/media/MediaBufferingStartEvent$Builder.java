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

public final class MediaBufferingStartEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MediaBufferingStartEvent>
{
  public long bufferingStartTime = 0L;
  public BufferingType bufferingType = null;
  public boolean hasBufferingStartTime = false;
  public boolean hasBufferingType = false;
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
  
  private MediaBufferingStartEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MediaBufferingStartEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MediaBufferingStartEvent(header, requestHeader, mobileHeader, mediaTrackingObject, bufferingType, initializationStartTime, bufferingStartTime, hasHeader, hasRequestHeader, hasMobileHeader, hasMediaTrackingObject, hasBufferingType, hasInitializationStartTime, hasBufferingStartTime);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingStartEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingStartEvent", "requestHeader");
      }
      if (!hasMediaTrackingObject) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingStartEvent", "mediaTrackingObject");
      }
      if (!hasInitializationStartTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingStartEvent", "initializationStartTime");
      }
    } while (hasBufferingStartTime);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingStartEvent", "bufferingStartTime");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.media.MediaBufferingStartEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */