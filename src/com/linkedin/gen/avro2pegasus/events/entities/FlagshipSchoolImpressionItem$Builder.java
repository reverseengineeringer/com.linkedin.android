package com.linkedin.gen.avro2pegasus.events.entities;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import java.util.Iterator;
import java.util.List;

public final class FlagshipSchoolImpressionItem$Builder
  implements RecordTemplateBuilder<FlagshipSchoolImpressionItem>
{
  private long duration = 0L;
  private GridPosition gridPosition = null;
  private boolean hasDuration = false;
  private boolean hasGridPosition = false;
  public boolean hasItemTrackingId = false;
  public boolean hasListPosition = false;
  public boolean hasSize = false;
  public boolean hasUrns = false;
  public boolean hasVisibleTime = false;
  public String itemTrackingId = null;
  public ListPosition listPosition = null;
  public EntityDimension size = null;
  public List<String> urns = null;
  public long visibleTime = 0L;
  
  public final FlagshipSchoolImpressionItem build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipSchoolImpressionItem.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (urns != null)
    {
      paramFlavor = urns.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "urns");
            if (!hasItemTrackingId) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "itemTrackingId");
            }
            if (!hasVisibleTime) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "visibleTime");
            }
            if (hasUrns) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "urns");
          }
        }
      }
    }
    return new FlagshipSchoolImpressionItem(itemTrackingId, visibleTime, duration, gridPosition, listPosition, size, urns, hasItemTrackingId, hasVisibleTime, hasDuration, hasGridPosition, hasListPosition, hasSize, hasUrns);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */