package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class MessagingRecommendationActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MessagingRecommendationActionEvent>
{
  public MessagingRecommendationActionType actionCategory = null;
  public String controlUrn = null;
  public boolean hasActionCategory = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasRecommendationTrackingId = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public String recommendationTrackingId = null;
  private UserRequestHeader requestHeader = null;
  
  private MessagingRecommendationActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MessagingRecommendationActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MessagingRecommendationActionEvent(header, requestHeader, mobileHeader, actionCategory, controlUrn, recommendationTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasActionCategory, hasControlUrn, hasRecommendationTrackingId);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "requestHeader");
      }
      if (!hasActionCategory) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "actionCategory");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "controlUrn");
      }
    } while (hasRecommendationTrackingId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "recommendationTrackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */