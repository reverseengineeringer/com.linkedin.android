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

public final class MediaBufferingEndEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MediaBufferingEndEvent>
{
  public long bufferingStartTime = 0L;
  public BufferingType bufferingType = null;
  public long duration = 0L;
  public boolean hasBufferingStartTime = false;
  public boolean hasBufferingType = false;
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
  
  private MediaBufferingEndEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MediaBufferingEndEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MediaBufferingEndEvent(header, requestHeader, mobileHeader, mediaTrackingObject, bufferingType, initializationStartTime, bufferingStartTime, duration, hasHeader, hasRequestHeader, hasMobileHeader, hasMediaTrackingObject, hasBufferingType, hasInitializationStartTime, hasBufferingStartTime, hasDuration);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingEndEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingEndEvent", "requestHeader");
      }
      if (!hasMediaTrackingObject) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingEndEvent", "mediaTrackingObject");
      }
      if (!hasInitializationStartTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingEndEvent", "initializationStartTime");
      }
      if (!hasBufferingStartTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingEndEvent", "bufferingStartTime");
      }
    } while (hasDuration);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.media.MediaBufferingEndEvent", "duration");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.media.MediaBufferingEndEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */