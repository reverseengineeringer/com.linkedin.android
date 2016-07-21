package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class MobileApplicationStackFrame
  implements RecordTemplate<MobileApplicationStackFrame>
{
  public static final MobileApplicationStackFrameBuilder BUILDER = MobileApplicationStackFrameBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String fileName;
  public final String function;
  public final boolean hasFileName;
  public final boolean hasFunction;
  public final boolean hasLineNumber;
  public final boolean hasParent;
  public final int lineNumber;
  public final String parent;
  
  MobileApplicationStackFrame(String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    parent = paramString1;
    function = paramString2;
    lineNumber = paramInt;
    fileName = paramString3;
    hasParent = paramBoolean1;
    hasFunction = paramBoolean2;
    hasLineNumber = paramBoolean3;
    hasFileName = paramBoolean4;
    _cachedId = null;
  }
  
  public final MobileApplicationStackFrame accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasParent)
    {
      paramDataProcessor.startRecordField$505cff1c("parent");
      paramDataProcessor.processString(parent);
    }
    if (hasFunction)
    {
      paramDataProcessor.startRecordField$505cff1c("function");
      paramDataProcessor.processString(function);
    }
    if (hasLineNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("lineNumber");
      paramDataProcessor.processInt(lineNumber);
    }
    if (hasFileName)
    {
      paramDataProcessor.startRecordField$505cff1c("fileName");
      paramDataProcessor.processString(fileName);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new MobileApplicationStackFrame(parent, function, lineNumber, fileName, hasParent, hasFunction, hasLineNumber, hasFileName);
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
      paramObject = (MobileApplicationStackFrame)paramObject;
      if (parent != null)
      {
        if (parent.equals(parent)) {}
      }
      else {
        while (parent != null) {
          return false;
        }
      }
      if (function != null)
      {
        if (function.equals(function)) {}
      }
      else {
        while (function != null) {
          return false;
        }
      }
      if (lineNumber != lineNumber) {
        return false;
      }
      if (fileName == null) {
        break;
      }
    } while (fileName.equals(fileName));
    for (;;)
    {
      return false;
      if (fileName == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (parent != null)
    {
      i = parent.hashCode();
      if (function == null) {
        break label99;
      }
    }
    label99:
    for (int j = function.hashCode();; j = 0)
    {
      int m = lineNumber;
      if (fileName != null) {
        k = fileName.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + m) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationStackFrame
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */