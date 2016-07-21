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

public final class FlagshipGroupActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipGroupActionEvent>
{
  public ActionCategory actionCategory = null;
  public String controlUrn = null;
  public TrackingObject group = null;
  public boolean hasActionCategory = false;
  public boolean hasControlUrn = false;
  public boolean hasGroup = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasSubItemUrn = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public String subItemUrn = null;
  
  private FlagshipGroupActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipGroupActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FlagshipGroupActionEvent(header, requestHeader, mobileHeader, controlUrn, actionCategory, subItemUrn, group, hasHeader, hasRequestHeader, hasMobileHeader, hasControlUrn, hasActionCategory, hasSubItemUrn, hasGroup);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupActionEvent", "requestHeader");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupActionEvent", "controlUrn");
      }
      if (!hasActionCategory) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupActionEvent", "actionCategory");
      }
    } while (hasGroup);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupActionEvent", "group");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */