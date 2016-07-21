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

public class WvmpOverviewInsightActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<WvmpOverviewInsightActionEvent>
{
  public ActionCategory actionCategory = null;
  public String controlUrn = null;
  public boolean hasActionCategory = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasWvmpOverviewInsight = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public TrackingObject wvmpOverviewInsight = null;
  
  private WvmpOverviewInsightActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (WvmpOverviewInsightActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new WvmpOverviewInsightActionEvent(header, requestHeader, mobileHeader, wvmpOverviewInsight, controlUrn, actionCategory, hasHeader, hasRequestHeader, hasMobileHeader, hasWvmpOverviewInsight, hasControlUrn, hasActionCategory);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpOverviewInsightActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpOverviewInsightActionEvent", "requestHeader");
      }
      if (!hasWvmpOverviewInsight) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpOverviewInsightActionEvent", "wvmpOverviewInsight");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpOverviewInsightActionEvent", "controlUrn");
      }
    } while (hasActionCategory);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpOverviewInsightActionEvent", "actionCategory");
  }
  
  public WvmpOverviewInsightActionEvent build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpOverviewInsightActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */