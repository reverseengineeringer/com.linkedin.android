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

public final class FlagshipCompanyImpressionItem$Builder
  implements RecordTemplateBuilder<FlagshipCompanyImpressionItem>
{
  private long duration = 0L;
  private GridPosition gridPosition = null;
  private boolean hasDuration = false;
  private boolean hasGridPosition = false;
  private boolean hasItemTrackingId = false;
  private boolean hasListPosition = false;
  private boolean hasSize = false;
  private boolean hasUrns = false;
  private boolean hasVisibleTime = false;
  private String itemTrackingId = null;
  private ListPosition listPosition = null;
  private EntityDimension size = null;
  private List<String> urns = null;
  private long visibleTime = 0L;
  
  private FlagshipCompanyImpressionItem build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipCompanyImpressionItem.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyImpressionItem", "urns");
            if (!hasItemTrackingId) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyImpressionItem", "itemTrackingId");
            }
            if (!hasVisibleTime) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyImpressionItem", "visibleTime");
            }
            if (hasUrns) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyImpressionItem", "urns");
          }
        }
      }
    }
    return new FlagshipCompanyImpressionItem(itemTrackingId, visibleTime, duration, gridPosition, listPosition, size, urns, hasItemTrackingId, hasVisibleTime, hasDuration, hasGridPosition, hasListPosition, hasSize, hasUrns);
  }
  
  public final FlagshipCompanyImpressionItem build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Builder setItemTrackingId(String paramString)
  {
    if (paramString == null)
    {
      hasItemTrackingId = false;
      itemTrackingId = null;
      return this;
    }
    hasItemTrackingId = true;
    itemTrackingId = paramString;
    return this;
  }
  
  public final Builder setListPosition(ListPosition paramListPosition)
  {
    if (paramListPosition == null)
    {
      hasListPosition = false;
      listPosition = null;
      return this;
    }
    hasListPosition = true;
    listPosition = paramListPosition;
    return this;
  }
  
  public final Builder setSize(EntityDimension paramEntityDimension)
  {
    if (paramEntityDimension == null)
    {
      hasSize = false;
      size = null;
      return this;
    }
    hasSize = true;
    size = paramEntityDimension;
    return this;
  }
  
  public final Builder setUrns(List<String> paramList)
  {
    if (paramList == null)
    {
      hasUrns = false;
      urns = null;
      return this;
    }
    hasUrns = true;
    urns = paramList;
    return this;
  }
  
  public final Builder setVisibleTime(Long paramLong)
  {
    if (paramLong == null)
    {
      hasVisibleTime = false;
      visibleTime = 0L;
      return this;
    }
    hasVisibleTime = true;
    visibleTime = paramLong.longValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyImpressionItem.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */