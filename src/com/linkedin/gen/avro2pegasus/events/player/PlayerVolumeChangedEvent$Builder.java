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

public final class PlayerVolumeChangedEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PlayerVolumeChangedEvent>
{
  private boolean hasHeader = false;
  public boolean hasMediaTrackingObject = false;
  private boolean hasMobileHeader = false;
  public boolean hasPreviousVolume = false;
  private boolean hasRequestHeader = false;
  public boolean hasState = false;
  private EventHeader header = null;
  public TrackingObject mediaTrackingObject = null;
  private MobileHeader mobileHeader = null;
  public int previousVolume = 0;
  private UserRequestHeader requestHeader = null;
  public PlayerState state = null;
  
  private PlayerVolumeChangedEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PlayerVolumeChangedEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PlayerVolumeChangedEvent(header, requestHeader, mobileHeader, state, previousVolume, mediaTrackingObject, hasHeader, hasRequestHeader, hasMobileHeader, hasState, hasPreviousVolume, hasMediaTrackingObject);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerVolumeChangedEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerVolumeChangedEvent", "requestHeader");
      }
      if (!hasState) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerVolumeChangedEvent", "state");
      }
    } while (hasPreviousVolume);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.player.PlayerVolumeChangedEvent", "previousVolume");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerVolumeChangedEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */