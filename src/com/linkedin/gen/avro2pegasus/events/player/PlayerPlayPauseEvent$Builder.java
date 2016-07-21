package com.linkedin.gen.avro2pegasus.events.player;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class PlayerPlayPauseEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerPlayPauseEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */