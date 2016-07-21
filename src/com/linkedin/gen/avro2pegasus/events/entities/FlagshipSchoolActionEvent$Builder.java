package com.linkedin.gen.avro2pegasus.events.entities;

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

public final class FlagshipSchoolActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipSchoolActionEvent>
{
  public ActionCategory actionCategory = null;
  public String controlUrn = null;
  public boolean hasActionCategory = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasSchool = false;
  public boolean hasSubItemUrn = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public TrackingObject school = null;
  public String subItemUrn = null;
  
  private FlagshipSchoolActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipSchoolActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FlagshipSchoolActionEvent(header, requestHeader, mobileHeader, controlUrn, actionCategory, subItemUrn, school, hasHeader, hasRequestHeader, hasMobileHeader, hasControlUrn, hasActionCategory, hasSubItemUrn, hasSchool);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolActionEvent", "requestHeader");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolActionEvent", "controlUrn");
      }
      if (!hasActionCategory) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolActionEvent", "actionCategory");
      }
    } while (hasSchool);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolActionEvent", "school");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */