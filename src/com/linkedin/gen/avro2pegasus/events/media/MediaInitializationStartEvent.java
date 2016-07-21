package com.linkedin.gen.avro2pegasus.events.media;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class MediaInitializationStartEvent
  implements RecordTemplate<MediaInitializationStartEvent>
{
  public static final MediaInitializationStartEventBuilder BUILDER = MediaInitializationStartEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasInitializationStartTime;
  public final boolean hasMediaTrackingObject;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final long initializationStartTime;
  public final TrackingObject mediaTrackingObject;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  MediaInitializationStartEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    mediaTrackingObject = paramTrackingObject;
    initializationStartTime = paramLong;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasMediaTrackingObject = paramBoolean4;
    hasInitializationStartTime = paramBoolean5;
    _cachedId = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (MediaInitializationStartEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (mediaTrackingObject != null)
      {
        if (mediaTrackingObject.equals(mediaTrackingObject)) {}
      }
      else {
        while (mediaTrackingObject != null) {
          return false;
        }
      }
    } while (initializationStartTime == initializationStartTime);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label127;
      }
      j = requestHeader.hashCode();
      label45:
      if (mobileHeader == null) {
        break label132;
      }
    }
    label127:
    label132:
    for (int k = mobileHeader.hashCode();; k = 0)
    {
      if (mediaTrackingObject != null) {
        m = mediaTrackingObject.hashCode();
      }
      i = ((k + (j + (i + 527) * 31) * 31) * 31 + m) * 31 + (int)(initializationStartTime ^ initializationStartTime >>> 32);
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.media.MediaInitializationStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */