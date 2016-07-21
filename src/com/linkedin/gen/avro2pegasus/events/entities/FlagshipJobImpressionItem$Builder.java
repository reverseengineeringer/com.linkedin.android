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

public final class FlagshipJobImpressionItem$Builder
  implements RecordTemplateBuilder<FlagshipJobImpressionItem>
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
  
  public final FlagshipJobImpressionItem build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipJobImpressionItem.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem", "urns");
            if (!hasItemTrackingId) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem", "itemTrackingId");
            }
            if (!hasVisibleTime) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem", "visibleTime");
            }
            if (hasUrns) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem", "urns");
          }
        }
      }
    }
    return new FlagshipJobImpressionItem(itemTrackingId, visibleTime, duration, gridPosition, listPosition, size, urns, hasItemTrackingId, hasVisibleTime, hasDuration, hasGridPosition, hasListPosition, hasSize, hasUrns);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */