package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class EntityDimension
  implements RecordTemplate<EntityDimension>
{
  public static final EntityDimensionBuilder BUILDER = EntityDimensionBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeight;
  public final boolean hasWidth;
  public final int height;
  public final int width;
  
  EntityDimension(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    height = paramInt1;
    width = paramInt2;
    hasHeight = paramBoolean1;
    hasWidth = paramBoolean2;
    _cachedId = null;
  }
  
  public final EntityDimension accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasHeight)
    {
      paramDataProcessor.startRecordField$505cff1c("height");
      paramDataProcessor.processInt(height);
    }
    if (hasWidth)
    {
      paramDataProcessor.startRecordField$505cff1c("width");
      paramDataProcessor.processInt(width);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasHeight) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.EntityDimension", "height");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasWidth) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.EntityDimension", "width");
      }
      return new EntityDimension(height, width, hasHeight, hasWidth);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (EntityDimension)paramObject;
      if (height != height) {
        return false;
      }
    } while (width == width);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i = (height + 527) * 31 + width;
    _cachedHashCode = i;
    return i;
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<EntityDimension>
  {
    private boolean hasHeight = false;
    private boolean hasWidth = false;
    private int height = 0;
    private int width = 0;
    
    public final EntityDimension build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (EntityDimension.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new EntityDimension(height, width, hasHeight, hasWidth);
        if (!hasHeight) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.EntityDimension", "height");
        }
      } while (hasWidth);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.EntityDimension", "width");
    }
    
    public final Builder setHeight(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasHeight = false;
        height = 0;
        return this;
      }
      hasHeight = true;
      height = paramInteger.intValue();
      return this;
    }
    
    public final Builder setWidth(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasWidth = false;
        width = 0;
        return this;
      }
      hasWidth = true;
      width = paramInteger.intValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.EntityDimension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */