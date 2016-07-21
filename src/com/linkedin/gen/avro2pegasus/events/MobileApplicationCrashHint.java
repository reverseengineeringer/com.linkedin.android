package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class MobileApplicationCrashHint
  implements RecordTemplate<MobileApplicationCrashHint>
{
  public static final MobileApplicationCrashHintBuilder BUILDER = MobileApplicationCrashHintBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHint;
  public final boolean hasTimestamp;
  public final String hint;
  public final long timestamp;
  
  MobileApplicationCrashHint(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    hint = paramString;
    timestamp = paramLong;
    hasHint = paramBoolean1;
    hasTimestamp = paramBoolean2;
    _cachedId = null;
  }
  
  public final MobileApplicationCrashHint accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasHint)
    {
      paramDataProcessor.startRecordField$505cff1c("hint");
      paramDataProcessor.processString(hint);
    }
    if (hasTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("timestamp");
      paramDataProcessor.processLong(timestamp);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new MobileApplicationCrashHint(hint, timestamp, hasHint, hasTimestamp);
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
      paramObject = (MobileApplicationCrashHint)paramObject;
      if (hint != null)
      {
        if (hint.equals(hint)) {}
      }
      else {
        while (hint != null) {
          return false;
        }
      }
    } while (timestamp == timestamp);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (hint != null) {}
    for (int i = hint.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + (int)(timestamp ^ timestamp >>> 32);
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationCrashHint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */