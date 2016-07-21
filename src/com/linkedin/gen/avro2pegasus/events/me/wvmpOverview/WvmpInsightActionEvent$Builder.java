package com.linkedin.gen.avro2pegasus.events.me.wvmpOverview;

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

public class WvmpInsightActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<WvmpInsightActionEvent>
{
  public ActionCategory actionCategory = null;
  public String controlUrn = null;
  public boolean hasActionCategory = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  public boolean hasInsight = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public TrackingObject insight = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private WvmpInsightActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (WvmpInsightActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new WvmpInsightActionEvent(header, requestHeader, mobileHeader, insight, controlUrn, actionCategory, hasHeader, hasRequestHeader, hasMobileHeader, hasInsight, hasControlUrn, hasActionCategory);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "requestHeader");
      }
      if (!hasInsight) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "insight");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "controlUrn");
      }
    } while (hasActionCategory);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "actionCategory");
  }
  
  public WvmpInsightActionEvent build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */