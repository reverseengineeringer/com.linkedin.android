package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SimpleTaskInfo
  implements FissileDataModel<SimpleTaskInfo>, RecordTemplate<SimpleTaskInfo>
{
  public static final SimpleTaskInfoBuilder BUILDER = SimpleTaskInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasSimpleTaskType;
  public final boolean hasTaskName;
  public final SimpleTaskTypes simpleTaskType;
  public final TaskNames taskName;
  
  SimpleTaskInfo(SimpleTaskTypes paramSimpleTaskTypes, TaskNames paramTaskNames, boolean paramBoolean1, boolean paramBoolean2)
  {
    simpleTaskType = paramSimpleTaskTypes;
    taskName = paramTaskNames;
    hasSimpleTaskType = paramBoolean1;
    hasTaskName = paramBoolean2;
    _cachedId = null;
  }
  
  public final SimpleTaskInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSimpleTaskType)
    {
      paramDataProcessor.startRecordField$505cff1c("simpleTaskType");
      paramDataProcessor.processEnum(simpleTaskType);
    }
    if (hasTaskName)
    {
      paramDataProcessor.startRecordField$505cff1c("taskName");
      paramDataProcessor.processEnum(taskName);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasSimpleTaskType) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SimpleTaskInfo", "simpleTaskType");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasTaskName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SimpleTaskInfo", "taskName");
      }
      return new SimpleTaskInfo(simpleTaskType, taskName, hasSimpleTaskType, hasTaskName);
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
      paramObject = (SimpleTaskInfo)paramObject;
      if (simpleTaskType != null)
      {
        if (simpleTaskType.equals(simpleTaskType)) {}
      }
      else {
        while (simpleTaskType != null) {
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
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasSimpleTaskType) {
      i = j + 2;
    }
    j = i + 1;
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
    if (simpleTaskType != null) {}
    for (int i = simpleTaskType.hashCode();; i = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SimpleTaskInfo");
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
    label211:
    label219:
    label221:
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
        localByteBuffer.putInt(1421251770);
        if (hasSimpleTaskType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, simpleTaskType.ordinal());
          if (!hasTaskName) {
            break label211;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, taskName.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label219;
          }
          if (str != null) {
            break label221;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SimpleTaskInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */