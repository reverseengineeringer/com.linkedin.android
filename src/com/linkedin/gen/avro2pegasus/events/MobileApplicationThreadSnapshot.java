package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MobileApplicationThreadSnapshot
  implements RecordTemplate<MobileApplicationThreadSnapshot>
{
  public static final MobileApplicationThreadSnapshotBuilder BUILDER = MobileApplicationThreadSnapshotBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasIsCauseOfError;
  public final boolean hasStackTrace;
  public final boolean hasThreadName;
  public final boolean isCauseOfError;
  public final List<MobileApplicationStackFrame> stackTrace;
  public final String threadName;
  
  MobileApplicationThreadSnapshot(List<MobileApplicationStackFrame> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      stackTrace = paramList;
      threadName = paramString;
      isCauseOfError = paramBoolean1;
      hasStackTrace = paramBoolean2;
      hasThreadName = paramBoolean3;
      hasIsCauseOfError = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final MobileApplicationThreadSnapshot accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    MobileApplicationStackFrame localMobileApplicationStackFrame = null;
    boolean bool = false;
    if (hasStackTrace)
    {
      paramDataProcessor.startRecordField$505cff1c("stackTrace");
      stackTrace.size();
      paramDataProcessor.startArray$13462e();
      localObject = localMobileApplicationStackFrame;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = stackTrace.iterator();
      if (localIterator.hasNext())
      {
        localMobileApplicationStackFrame = (MobileApplicationStackFrame)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localMobileApplicationStackFrame = localMobileApplicationStackFrame.accept(paramDataProcessor);; localMobileApplicationStackFrame = (MobileApplicationStackFrame)paramDataProcessor.processDataTemplate(localMobileApplicationStackFrame))
        {
          if ((localObject != null) && (localMobileApplicationStackFrame != null)) {
            ((List)localObject).add(localMobileApplicationStackFrame);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label274;
      }
    }
    label274:
    for (bool = true;; bool = false)
    {
      if (hasThreadName)
      {
        paramDataProcessor.startRecordField$505cff1c("threadName");
        paramDataProcessor.processString(threadName);
      }
      if (hasIsCauseOfError)
      {
        paramDataProcessor.startRecordField$505cff1c("isCauseOfError");
        paramDataProcessor.processBoolean(isCauseOfError);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new MobileApplicationThreadSnapshot((List)localObject, threadName, isCauseOfError, bool, hasThreadName, hasIsCauseOfError);
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
      paramObject = (MobileApplicationThreadSnapshot)paramObject;
      if (stackTrace != null)
      {
        if (stackTrace.equals(stackTrace)) {}
      }
      else {
        while (stackTrace != null) {
          return false;
        }
      }
      if (threadName != null)
      {
        if (threadName.equals(threadName)) {}
      }
      else {
        while (threadName != null) {
          return false;
        }
      }
    } while (isCauseOfError == isCauseOfError);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (stackTrace != null)
    {
      i = stackTrace.hashCode();
      if (threadName == null) {
        break label83;
      }
    }
    label83:
    for (int j = threadName.hashCode();; j = 0)
    {
      if (isCauseOfError) {
        k = 1;
      }
      i = (j + (i + 527) * 31) * 31 + k;
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
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationThreadSnapshot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */