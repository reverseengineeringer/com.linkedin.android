package com.linkedin.gen.avro2pegasus.events.lego;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class LegoWidgetActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<LegoWidgetActionEvent>
{
  public WidgetActionCategory actionCategory = null;
  public int actionCount = 0;
  public String actionName = null;
  public boolean hasActionCategory = false;
  public boolean hasActionCount = false;
  public boolean hasActionName = false;
  private boolean hasHeader = false;
  public boolean hasIsSyncTrack = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasTrackingToken = false;
  private boolean hasWidgetTrackingId = false;
  private EventHeader header = null;
  public boolean isSyncTrack = false;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public String trackingToken = null;
  private String widgetTrackingId = null;
  
  private LegoWidgetActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (LegoWidgetActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new LegoWidgetActionEvent(header, requestHeader, mobileHeader, trackingToken, widgetTrackingId, actionCategory, actionName, actionCount, isSyncTrack, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingToken, hasWidgetTrackingId, hasActionCategory, hasActionName, hasActionCount, hasIsSyncTrack);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "requestHeader");
      }
      if (!hasTrackingToken) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "trackingToken");
      }
    } while (hasActionCategory);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "actionCategory");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */