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

public final class MediaBufferingStartEvent
  implements RecordTemplate<MediaBufferingStartEvent>
{
  public static final MediaBufferingStartEventBuilder BUILDER = MediaBufferingStartEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final long bufferingStartTime;
  public final BufferingType bufferingType;
  public final boolean hasBufferingStartTime;
  public final boolean hasBufferingType;
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
  
  MediaBufferingStartEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject, BufferingType paramBufferingType, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    mediaTrackingObject = paramTrackingObject;
    bufferingType = paramBufferingType;
    initializationStartTime = paramLong1;
    bufferingStartTime = paramLong2;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasMediaTrackingObject = paramBoolean4;
    hasBufferingType = paramBoolean5;
    hasInitializationStartTime = paramBoolean6;
    hasBufferingStartTime = paramBoolean7;
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
      paramObject = (MediaBufferingStartEvent)paramObject;
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
      if (bufferingType != null)
      {
        if (bufferingType.equals(bufferingType)) {}
      }
      else {
        while (bufferingType != null) {
          return false;
        }
      }
      if (initializationStartTime != initializationStartTime) {
        return false;
      }
    } while (bufferingStartTime == bufferingStartTime);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label166;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label171;
      }
      k = mobileHeader.hashCode();
      label60:
      if (mediaTrackingObject == null) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (int m = mediaTrackingObject.hashCode();; m = 0)
    {
      if (bufferingType != null) {
        n = bufferingType.hashCode();
      }
      i = (((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n) * 31 + (int)(initializationStartTime ^ initializationStartTime >>> 32)) * 31 + (int)(bufferingStartTime ^ bufferingStartTime >>> 32);
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.media.MediaBufferingStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */