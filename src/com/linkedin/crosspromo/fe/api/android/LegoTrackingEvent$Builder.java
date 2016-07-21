package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class LegoTrackingEvent$Builder
  implements RecordTemplateBuilder<LegoTrackingEvent>
{
  public boolean hasLegoTrackingToken = false;
  public boolean hasMetricsObject = false;
  public String legoTrackingToken = null;
  public MetricsInfo metricsObject = null;
  
  public final LegoTrackingEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (LegoTrackingEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new LegoTrackingEvent(legoTrackingToken, metricsObject, hasLegoTrackingToken, hasMetricsObject);
    } while (hasLegoTrackingToken);
    throw new MissingRecordFieldException("com.linkedin.crosspromo.fe.api.android.LegoTrackingEvent", "legoTrackingToken");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.LegoTrackingEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */