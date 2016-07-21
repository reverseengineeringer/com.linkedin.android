package com.linkedin.gen.avro2pegasus.events.player;

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

public final class PlayerPositionChangedEvent
  implements RecordTemplate<PlayerPositionChangedEvent>
{
  public static final PlayerPositionChangedEventBuilder BUILDER = PlayerPositionChangedEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final boolean hasHeader;
  public final boolean hasMediaTrackingObject;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasState;
  public final EventHeader header;
  public final TrackingObject mediaTrackingObject;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final PlayerState state;
  
  PlayerPositionChangedEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, PlayerState paramPlayerState, TrackingObject paramTrackingObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    state = paramPlayerState;
    mediaTrackingObject = paramTrackingObject;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasState = paramBoolean4;
    hasMediaTrackingObject = paramBoolean5;
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
      paramObject = (PlayerPositionChangedEvent)paramObject;
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
      if (state != null)
      {
        if (state.equals(state)) {}
      }
      else {
        while (state != null) {
          return false;
        }
      }
      if (mediaTrackingObject == null) {
        break;
      }
    } while (mediaTrackingObject.equals(mediaTrackingObject));
    for (;;)
    {
      return false;
      if (mediaTrackingObject == null) {
        break;
      }
    }
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
        break label132;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label137;
      }
      k = mobileHeader.hashCode();
      label60:
      if (state == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = state.hashCode();; m = 0)
    {
      if (mediaTrackingObject != null) {
        n = mediaTrackingObject.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
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
    return null;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<PlayerPositionChangedEvent>
  {
    private boolean hasHeader = false;
    public boolean hasMediaTrackingObject = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasState = false;
    private EventHeader header = null;
    public TrackingObject mediaTrackingObject = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public PlayerState state = null;
    
    private PlayerPositionChangedEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PlayerPositionChangedEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PlayerPositionChangedEvent(header, requestHeader, mobileHeader, state, mediaTrackingObject, hasHeader, hasRequestHeader, hasMobileHeader, hasState, hasMediaTrackingObject);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerPositionChangedEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerPositionChangedEvent", "requestHeader");
        }
      } while (hasState);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerPositionChangedEvent", "state");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerPositionChangedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */