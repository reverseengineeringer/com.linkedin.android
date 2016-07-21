package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SecondarySearchResultInfo
  implements RecordTemplate<SecondarySearchResultInfo>
{
  public static final SecondarySearchResultInfoBuilder BUILDER = SecondarySearchResultInfoBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasVertical;
  public final SearchVertical vertical;
  
  SecondarySearchResultInfo(SearchVertical paramSearchVertical, boolean paramBoolean)
  {
    vertical = paramSearchVertical;
    hasVertical = paramBoolean;
    _cachedId = null;
  }
  
  public final SecondarySearchResultInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasVertical)
    {
      paramDataProcessor.startRecordField$505cff1c("vertical");
      paramDataProcessor.processEnum(vertical);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasVertical) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SecondarySearchResultInfo", "vertical");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new SecondarySearchResultInfo(vertical, hasVertical);
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
      paramObject = (SecondarySearchResultInfo)paramObject;
      if (vertical == null) {
        break;
      }
    } while (vertical.equals(vertical));
    for (;;)
    {
      return false;
      if (vertical == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (vertical != null) {}
    for (int i = vertical.hashCode();; i = 0)
    {
      i += 527;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<SecondarySearchResultInfo>
  {
    public boolean hasVertical = false;
    public SearchVertical vertical = null;
    
    public final SecondarySearchResultInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SecondarySearchResultInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SecondarySearchResultInfo(vertical, hasVertical);
      } while (hasVertical);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SecondarySearchResultInfo", "vertical");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SecondarySearchResultInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */