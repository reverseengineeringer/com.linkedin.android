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

public final class PlayerPositionChangedEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerPositionChangedEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */