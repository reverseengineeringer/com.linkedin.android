package com.linkedin.gen.avro2pegasus.events.me.wvmp;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class WvmpOverviewInsightImpression$Builder
  implements RecordTemplateBuilder<WvmpOverviewInsightImpression>
{
  public long duration = 0L;
  public boolean hasDuration = false;
  public boolean hasInsight = false;
  public boolean hasListPosition = false;
  public boolean hasSize = false;
  public boolean hasVisibleTime = false;
  public boolean hasWvmpOverviewInsight = false;
  public TrackingObject insight = null;
  public ListPosition listPosition = null;
  public EntityDimension size = null;
  public long visibleTime = 0L;
  public TrackingObject wvmpOverviewInsight = null;
  
  public final WvmpOverviewInsightImpression build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (WvmpOverviewInsightImpression.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new WvmpOverviewInsightImpression(wvmpOverviewInsight, listPosition, visibleTime, duration, size, insight, hasWvmpOverviewInsight, hasListPosition, hasVisibleTime, hasDuration, hasSize, hasInsight);
      if (!hasWvmpOverviewInsight) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpression", "wvmpOverviewInsight");
      }
      if (!hasVisibleTime) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpression", "visibleTime");
      }
      if (!hasDuration) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpression", "duration");
      }
    } while (hasSize);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpression", "size");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpression.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */