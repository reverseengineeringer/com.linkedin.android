package com.linkedin.gen.avro2pegasus.events.me;

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

public class WvmpProfileViewActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<WvmpProfileViewActionEvent>
{
  public ActionCategory actionCategory = null;
  public String controlUrn = null;
  public boolean hasActionCategory = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasProfileView = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public TrackingObject profileView = null;
  private UserRequestHeader requestHeader = null;
  
  private WvmpProfileViewActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (WvmpProfileViewActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new WvmpProfileViewActionEvent(header, requestHeader, mobileHeader, profileView, controlUrn, actionCategory, hasHeader, hasRequestHeader, hasMobileHeader, hasProfileView, hasControlUrn, hasActionCategory);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewActionEvent", "requestHeader");
      }
      if (!hasProfileView) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewActionEvent", "profileView");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewActionEvent", "controlUrn");
      }
    } while (hasActionCategory);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewActionEvent", "actionCategory");
  }
  
  public WvmpProfileViewActionEvent build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.WvmpProfileViewActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */