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

public final class PlayerSeekEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PlayerSeekEvent>
{
  private boolean hasHeader = false;
  public boolean hasMediaTrackingObject = false;
  private boolean hasMobileHeader = false;
  public boolean hasPreviousTimeElapsed = false;
  private boolean hasRequestHeader = false;
  public boolean hasState = false;
  private EventHeader header = null;
  public TrackingObject mediaTrackingObject = null;
  private MobileHeader mobileHeader = null;
  public int previousTimeElapsed = 0;
  private UserRequestHeader requestHeader = null;
  public PlayerState state = null;
  
  private PlayerSeekEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PlayerSeekEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PlayerSeekEvent(header, requestHeader, mobileHeader, state, previousTimeElapsed, mediaTrackingObject, hasHeader, hasRequestHeader, hasMobileHeader, hasState, hasPreviousTimeElapsed, hasMediaTrackingObject);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerSeekEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerSeekEvent", "requestHeader");
      }
      if (!hasState) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerSeekEvent", "state");
      }
    } while (hasPreviousTimeElapsed);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerSeekEvent", "previousTimeElapsed");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerSeekEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */