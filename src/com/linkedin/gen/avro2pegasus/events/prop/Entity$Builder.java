package com.linkedin.gen.avro2pegasus.events.prop;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;

public final class Entity$Builder
  implements RecordTemplateBuilder<Entity>
{
  private long duration = 0L;
  private GridPosition gridPosition = null;
  private boolean hasDuration = false;
  private boolean hasGridPosition = false;
  private boolean hasListPosition = false;
  private boolean hasSize = false;
  private boolean hasTrackingId = false;
  private boolean hasUrn = false;
  private boolean hasVisibleTime = false;
  private ListPosition listPosition = null;
  private EntityDimension size = null;
  private String trackingId = null;
  private String urn = null;
  private long visibleTime = 0L;
  
  public final Entity build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Entity.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Entity(urn, trackingId, visibleTime, duration, gridPosition, listPosition, size, hasUrn, hasTrackingId, hasVisibleTime, hasDuration, hasGridPosition, hasListPosition, hasSize);
      if (!hasUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "urn");
      }
      if (!hasTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "trackingId");
      }
    } while (hasVisibleTime);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "visibleTime");
  }
  
  public final Builder setDuration(Long paramLong)
  {
    if (paramLong == null)
    {
      hasDuration = false;
      duration = 0L;
      return this;
    }
    hasDuration = true;
    duration = paramLong.longValue();
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
  
  public final Builder setTrackingId(String paramString)
  {
    if (paramString == null)
    {
      hasTrackingId = false;
      trackingId = null;
      return this;
    }
    hasTrackingId = true;
    trackingId = paramString;
    return this;
  }
  
  public final Builder setUrn(String paramString)
  {
    if (paramString == null)
    {
      hasUrn = false;
      urn = null;
      return this;
    }
    hasUrn = true;
    urn = paramString;
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
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.prop.Entity.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */