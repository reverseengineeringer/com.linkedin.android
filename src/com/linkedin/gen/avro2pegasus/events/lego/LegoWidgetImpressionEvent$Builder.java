package com.linkedin.gen.avro2pegasus.events.lego;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class LegoWidgetImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<LegoWidgetImpressionEvent>
{
  private boolean hasHeader = false;
  public boolean hasIsSyncTrack = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasTrackingToken = false;
  public boolean hasVisibility = false;
  private boolean hasWidgetTrackingId = false;
  private EventHeader header = null;
  public boolean isSyncTrack = false;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public String trackingToken = null;
  public WidgetVisibility visibility = null;
  private String widgetTrackingId = null;
  
  private LegoWidgetImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (LegoWidgetImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new LegoWidgetImpressionEvent(header, requestHeader, mobileHeader, trackingToken, widgetTrackingId, visibility, isSyncTrack, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingToken, hasWidgetTrackingId, hasVisibility, hasIsSyncTrack);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "requestHeader");
      }
    } while (hasTrackingToken);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "trackingToken");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */