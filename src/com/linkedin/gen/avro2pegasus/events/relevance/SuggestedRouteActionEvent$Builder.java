package com.linkedin.gen.avro2pegasus.events.relevance;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SuggestedRouteActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedRouteActionEvent>
{
  public ErrorType error = null;
  public boolean hasError = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasRouteServed = false;
  public boolean hasTrackingId = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public Route routeServed = null;
  public String trackingId = null;
  
  private SuggestedRouteActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SuggestedRouteActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SuggestedRouteActionEvent(header, requestHeader, mobileHeader, trackingId, routeServed, error, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingId, hasRouteServed, hasError);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "requestHeader");
      }
      if (!hasTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "trackingId");
      }
    } while (hasRouteServed);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "routeServed");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */