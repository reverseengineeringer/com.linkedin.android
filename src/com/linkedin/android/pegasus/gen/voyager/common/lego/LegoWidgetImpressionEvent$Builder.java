package com.linkedin.android.pegasus.gen.voyager.common.lego;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class LegoWidgetImpressionEvent$Builder
  implements RecordTemplateBuilder<LegoWidgetImpressionEvent>
{
  public boolean hasTrackingId = false;
  private boolean hasTrackingToken = false;
  private boolean hasVisibility = false;
  public String trackingId = null;
  private String trackingToken = null;
  private Visibility visibility = null;
  
  public final LegoWidgetImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (LegoWidgetImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new LegoWidgetImpressionEvent(trackingToken, trackingId, visibility, hasTrackingToken, hasTrackingId, hasVisibility);
      if (!hasTrackingToken) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent", "trackingToken");
      }
    } while (hasVisibility);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent", "visibility");
  }
  
  public final Builder setTrackingToken(String paramString)
  {
    if (paramString == null)
    {
      hasTrackingToken = false;
      trackingToken = null;
      return this;
    }
    hasTrackingToken = true;
    trackingToken = paramString;
    return this;
  }
  
  public final Builder setVisibility(Visibility paramVisibility)
  {
    if (paramVisibility == null)
    {
      hasVisibility = false;
      visibility = null;
      return this;
    }
    hasVisibility = true;
    visibility = paramVisibility;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */