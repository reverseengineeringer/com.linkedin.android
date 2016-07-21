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

public final class PlayerPlayPauseEvent
  implements RecordTemplate<PlayerPlayPauseEvent>
{
  public static final PlayerPlayPauseEventBuilder BUILDER = PlayerPlayPauseEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final boolean hasHeader;
  public final boolean hasMediaTrackingObject;
  public final boolean hasMobileHeader;
  public final boolean hasReason;
  public final boolean hasRequestHeader;
  public final boolean hasState;
  public final EventHeader header;
  public final TrackingObject mediaTrackingObject;
  public final MobileHeader mobileHeader;
  public final PlayPauseChangedReason reason;
  public final UserRequestHeader requestHeader;
  public final PlayerState state;
  
  PlayerPlayPauseEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, PlayerState paramPlayerState, PlayPauseChangedReason paramPlayPauseChangedReason, TrackingObject paramTrackingObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    state = paramPlayerState;
    reason = paramPlayPauseChangedReason;
    mediaTrackingObject = paramTrackingObject;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasState = paramBoolean4;
    hasReason = paramBoolean5;
    hasMediaTrackingObject = paramBoolean6;
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
      paramObject = (PlayerPlayPauseEvent)paramObject;
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
      if (reason != null)
      {
        if (reason.equals(reason)) {}
      }
      else {
        while (reason != null) {
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
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label154;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label159;
      }
      k = mobileHeader.hashCode();
      if (state == null) {
        break label164;
      }
      m = state.hashCode();
      label76:
      if (reason == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = reason.hashCode();; n = 0)
    {
      if (mediaTrackingObject != null) {
        i1 = mediaTrackingObject.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<PlayerPlayPauseEvent>
  {
    private boolean hasHeader = false;
    public boolean hasMediaTrackingObject = false;
    private boolean hasMobileHeader = false;
    public boolean hasReason = false;
    private boolean hasRequestHeader = false;
    public boolean hasState = false;
    private EventHeader header = null;
    public TrackingObject mediaTrackingObject = null;
    private MobileHeader mobileHeader = null;
    public PlayPauseChangedReason reason = null;
    private UserRequestHeader requestHeader = null;
    public PlayerState state = null;
    
    private PlayerPlayPauseEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PlayerPlayPauseEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PlayerPlayPauseEvent(header, requestHeader, mobileHeader, state, reason, mediaTrackingObject, hasHeader, hasRequestHeader, hasMobileHeader, hasState, hasReason, hasMediaTrackingObject);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerPlayPauseEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerPlayPauseEvent", "requestHeader");
        }
        if (!hasState) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerPlayPauseEvent", "state");
        }
      } while (hasReason);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerPlayPauseEvent", "reason");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerPlayPauseEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */