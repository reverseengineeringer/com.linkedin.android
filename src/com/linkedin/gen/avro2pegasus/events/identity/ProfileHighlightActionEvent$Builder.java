package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class ProfileHighlightActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<ProfileHighlightActionEvent>
{
  public ActionCategory actionCategory = null;
  public String controlUrn = null;
  public boolean hasActionCategory = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  public boolean hasHighlightTracking = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public TrackingObject highlightTracking = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private ProfileHighlightActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfileHighlightActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ProfileHighlightActionEvent(header, requestHeader, mobileHeader, highlightTracking, controlUrn, actionCategory, hasHeader, hasRequestHeader, hasMobileHeader, hasHighlightTracking, hasControlUrn, hasActionCategory);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.ProfileHighlightActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.ProfileHighlightActionEvent", "requestHeader");
      }
      if (!hasHighlightTracking) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.ProfileHighlightActionEvent", "highlightTracking");
      }
    } while (hasActionCategory);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.ProfileHighlightActionEvent", "actionCategory");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.ProfileHighlightActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */