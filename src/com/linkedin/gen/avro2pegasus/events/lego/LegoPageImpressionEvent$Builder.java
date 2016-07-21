package com.linkedin.gen.avro2pegasus.events.lego;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class LegoPageImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<LegoPageImpressionEvent>
{
  private boolean hasHeader = false;
  public boolean hasIsSyncTrack = false;
  private boolean hasMobileHeader = false;
  private boolean hasPageTrackingId = false;
  private boolean hasRequestHeader = false;
  public boolean hasTrackingToken = false;
  private EventHeader header = null;
  public boolean isSyncTrack = false;
  private MobileHeader mobileHeader = null;
  private String pageTrackingId = null;
  private UserRequestHeader requestHeader = null;
  public String trackingToken = null;
  
  private LegoPageImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (LegoPageImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new LegoPageImpressionEvent(header, requestHeader, mobileHeader, trackingToken, pageTrackingId, isSyncTrack, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingToken, hasPageTrackingId, hasIsSyncTrack);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "requestHeader");
      }
    } while (hasTrackingToken);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "trackingToken");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */