package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SuggestedEditTaskInfo
  implements FissileDataModel<SuggestedEditTaskInfo>, RecordTemplate<SuggestedEditTaskInfo>
{
  public static final SuggestedEditTaskInfoBuilder BUILDER = SuggestedEditTaskInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasSuggestions;
  public final boolean hasTaskName;
  public final List<Suggestion> suggestions;
  public final TaskNames taskName;
  
  SuggestedEditTaskInfo(List<Suggestion> paramList, TaskNames paramTaskNames, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      suggestions = paramList;
      taskName = paramTaskNames;
      hasSuggestions = paramBoolean1;
      hasTaskName = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final SuggestedEditTaskInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    Suggestion localSuggestion = null;
    boolean bool = false;
    if (hasSuggestions)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestions");
      suggestions.size();
      paramDataProcessor.startArray$13462e();
      localObject = localSuggestion;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = suggestions.iterator();
      if (localIterator.hasNext())
      {
        localSuggestion = (Suggestion)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localSuggestion = localSuggestion.accept(paramDataProcessor);; localSuggestion = (Suggestion)paramDataProcessor.processDataTemplate(localSuggestion))
        {
          if ((localObject != null) && (localSuggestion != null)) {
            ((List)localObject).add(localSuggestion);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label251;
      }
    }
    label251:
    for (bool = true;; bool = false)
    {
      if (hasTaskName)
      {
        paramDataProcessor.startRecordField$505cff1c("taskName");
        paramDataProcessor.processEnum(taskName);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label344;
      }
      try
      {
        if (hasSuggestions) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SuggestedEditTaskInfo", "suggestions");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTaskName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SuggestedEditTaskInfo", "taskName");
    }
    if (suggestions != null)
    {
      paramDataProcessor = suggestions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Suggestion)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SuggestedEditTaskInfo", "suggestions");
        }
      }
    }
    return new SuggestedEditTaskInfo((List)localObject, taskName, bool, hasTaskName);
    label344:
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
      paramObject = (SuggestedEditTaskInfo)paramObject;
      if (suggestions != null)
      {
        if (suggestions.equals(suggestions)) {}
      }
      else {
        while (suggestions != null) {
          return false;
        }
      }
      if (taskName == null) {
        break;
      }
    } while (taskName.equals(taskName));
    for (;;)
    {
      return false;
      if (taskName == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j = i;
    if (hasSuggestions)
    {
      i += 2;
      Iterator localIterator = suggestions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Suggestion localSuggestion = (Suggestion)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localSuggestion.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTaskName) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (suggestions != null) {}
    for (int i = suggestions.hashCode();; i = 0)
    {
      if (taskName != null) {
        j = taskName.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedEditTaskInfo");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label319:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(1543363495);
        if (hasSuggestions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, suggestions.size());
          Iterator localIterator = suggestions.iterator();
          while (localIterator.hasNext())
          {
            Suggestion localSuggestion = (Suggestion)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localSuggestion.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localSuggestion.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTaskName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, taskName.ordinal());
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label319;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SuggestedEditTaskInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */