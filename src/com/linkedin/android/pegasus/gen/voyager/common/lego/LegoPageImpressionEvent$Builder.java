package com.linkedin.android.pegasus.gen.voyager.common.lego;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class LegoPageImpressionEvent$Builder
  implements RecordTemplateBuilder<LegoPageImpressionEvent>
{
  public boolean hasTrackingToken = false;
  public String trackingToken = null;
  
  public final LegoPageImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (LegoPageImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new LegoPageImpressionEvent(trackingToken, hasTrackingToken);
    } while (hasTrackingToken);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoPageImpressionEvent", "trackingToken");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.lego.LegoPageImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */