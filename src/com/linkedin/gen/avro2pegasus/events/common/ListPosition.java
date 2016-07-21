package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ListPosition
  implements RecordTemplate<ListPosition>
{
  public static final ListPositionBuilder BUILDER = ListPositionBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasIndex;
  public final int index;
  
  ListPosition(int paramInt, boolean paramBoolean)
  {
    index = paramInt;
    hasIndex = paramBoolean;
    _cachedId = null;
  }
  
  public final ListPosition accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasIndex)
    {
      paramDataProcessor.startRecordField$505cff1c("index");
      paramDataProcessor.processInt(index);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasIndex) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.ListPosition", "index");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new ListPosition(index, hasIndex);
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
      paramObject = (ListPosition)paramObject;
    } while (index == index);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i = index + 527;
    _cachedHashCode = i;
    return i;
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<ListPosition>
  {
    private boolean hasIndex = false;
    private int index = 0;
    
    public final ListPosition build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ListPosition.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ListPosition(index, hasIndex);
      } while (hasIndex);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.ListPosition", "index");
    }
    
    public final Builder setIndex(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasIndex = false;
        index = 0;
        return this;
      }
      hasIndex = true;
      index = paramInteger.intValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.ListPosition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */