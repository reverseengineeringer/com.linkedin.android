package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class EntityDimension$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */