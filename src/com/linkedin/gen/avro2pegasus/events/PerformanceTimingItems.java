package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PerformanceTimingItems
  implements RecordTemplate<PerformanceTimingItems>
{
  public static final PerformanceTimingItemsBuilder BUILDER = PerformanceTimingItemsBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final long functionDuration;
  public final String functionName;
  public final long functionStartTime;
  public final boolean hasFunctionDuration;
  public final boolean hasFunctionName;
  public final boolean hasFunctionStartTime;
  
  PerformanceTimingItems(String paramString, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    functionName = paramString;
    functionStartTime = paramLong1;
    functionDuration = paramLong2;
    hasFunctionName = paramBoolean1;
    hasFunctionStartTime = paramBoolean2;
    hasFunctionDuration = paramBoolean3;
    _cachedId = null;
  }
  
  public final PerformanceTimingItems accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFunctionName)
    {
      paramDataProcessor.startRecordField$505cff1c("functionName");
      paramDataProcessor.processString(functionName);
    }
    if (hasFunctionStartTime)
    {
      paramDataProcessor.startRecordField$505cff1c("functionStartTime");
      paramDataProcessor.processLong(functionStartTime);
    }
    if (hasFunctionDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("functionDuration");
      paramDataProcessor.processLong(functionDuration);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new PerformanceTimingItems(functionName, functionStartTime, functionDuration, hasFunctionName, hasFunctionStartTime, hasFunctionDuration);
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
      paramObject = (PerformanceTimingItems)paramObject;
      if (functionName != null)
      {
        if (functionName.equals(functionName)) {}
      }
      else {
        while (functionName != null) {
          return false;
        }
      }
      if (functionStartTime != functionStartTime) {
        return false;
      }
    } while (functionDuration == functionDuration);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (functionName != null) {}
    for (int i = functionName.hashCode();; i = 0)
    {
      i = ((i + 527) * 31 + (int)(functionStartTime ^ functionStartTime >>> 32)) * 31 + (int)(functionDuration ^ functionDuration >>> 32);
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<PerformanceTimingItems>
  {
    public long functionDuration = 0L;
    public String functionName = null;
    public long functionStartTime = 0L;
    public boolean hasFunctionDuration = false;
    public boolean hasFunctionName = false;
    public boolean hasFunctionStartTime = false;
    
    public final PerformanceTimingItems build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PerformanceTimingItems.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PerformanceTimingItems(functionName, functionStartTime, functionDuration, hasFunctionName, hasFunctionStartTime, hasFunctionDuration);
      } while (hasFunctionName);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.PerformanceTimingItems", "functionName");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.PerformanceTimingItems
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */