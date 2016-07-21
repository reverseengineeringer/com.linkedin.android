package com.linkedin.android.tracking.v2.event;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public abstract interface TrackingEventBuilder<T extends RecordTemplate<T>>
{
  public abstract T build()
    throws BuilderException;
  
  public abstract TrackingEventBuilder<T> setHeader(EventHeader paramEventHeader);
  
  public abstract TrackingEventBuilder<T> setMobileHeader(MobileHeader paramMobileHeader);
  
  public abstract TrackingEventBuilder<T> setRequestHeader(UserRequestHeader paramUserRequestHeader);
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.event.TrackingEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */