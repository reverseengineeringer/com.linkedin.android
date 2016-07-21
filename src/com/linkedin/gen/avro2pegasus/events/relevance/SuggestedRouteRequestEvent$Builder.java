package com.linkedin.gen.avro2pegasus.events.relevance;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SuggestedRouteRequestEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedRouteRequestEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasOrigin = false;
  private boolean hasRequestHeader = false;
  public boolean hasTrackingId = false;
  public boolean hasUserActionType = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public Origin origin = null;
  private UserRequestHeader requestHeader = null;
  public String trackingId = null;
  public UserActionType userActionType = null;
  
  private SuggestedRouteRequestEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SuggestedRouteRequestEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SuggestedRouteRequestEvent(header, requestHeader, mobileHeader, trackingId, origin, userActionType, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingId, hasOrigin, hasUserActionType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "requestHeader");
      }
      if (!hasTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "trackingId");
      }
      if (!hasOrigin) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "origin");
      }
    } while (hasUserActionType);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "userActionType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */