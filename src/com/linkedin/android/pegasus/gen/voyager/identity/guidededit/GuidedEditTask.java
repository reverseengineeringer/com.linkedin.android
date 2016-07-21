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
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GuidedEditTask
  implements FissileDataModel<GuidedEditTask>, RecordTemplate<GuidedEditTask>
{
  public static final GuidedEditTaskBuilder BUILDER = GuidedEditTaskBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean counted;
  public final boolean hasCounted;
  public final boolean hasLegoTrackingId;
  public final boolean hasRequired;
  public final boolean hasTaskInfo;
  public final boolean hasTaskName;
  public final String legoTrackingId;
  public final boolean required;
  public final TaskInfo taskInfo;
  public final TaskNames taskName;
  
  GuidedEditTask(String paramString, boolean paramBoolean1, boolean paramBoolean2, TaskNames paramTaskNames, TaskInfo paramTaskInfo, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    legoTrackingId = paramString;
    required = paramBoolean1;
    counted = paramBoolean2;
    taskName = paramTaskNames;
    taskInfo = paramTaskInfo;
    hasLegoTrackingId = paramBoolean3;
    hasRequired = paramBoolean4;
    hasCounted = paramBoolean5;
    hasTaskName = paramBoolean6;
    hasTaskInfo = paramBoolean7;
    _cachedId = null;
  }
  
  public final GuidedEditTask accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasLegoTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("legoTrackingId");
      paramDataProcessor.processString(legoTrackingId);
    }
    if (hasRequired)
    {
      paramDataProcessor.startRecordField$505cff1c("required");
      paramDataProcessor.processBoolean(required);
    }
    if (hasCounted)
    {
      paramDataProcessor.startRecordField$505cff1c("counted");
      paramDataProcessor.processBoolean(counted);
    }
    if (hasTaskName)
    {
      paramDataProcessor.startRecordField$505cff1c("taskName");
      paramDataProcessor.processEnum(taskName);
    }
    TaskInfo localTaskInfo = null;
    boolean bool = false;
    if (hasTaskInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("taskInfo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label193;
      }
      localTaskInfo = taskInfo.accept(paramDataProcessor);
      if (localTaskInfo == null) {
        break label210;
      }
    }
    label193:
    label210:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label314;
      }
      try
      {
        if (hasLegoTrackingId) {
          break label215;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask", "legoTrackingId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localTaskInfo = (TaskInfo)paramDataProcessor.processDataTemplate(taskInfo);
      break;
    }
    label215:
    if (!hasRequired) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask", "required");
    }
    if (!hasCounted) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask", "counted");
    }
    if (!hasTaskInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask", "taskInfo");
    }
    return new GuidedEditTask(legoTrackingId, required, counted, taskName, localTaskInfo, hasLegoTrackingId, hasRequired, hasCounted, hasTaskName, bool);
    label314:
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
      paramObject = (GuidedEditTask)paramObject;
      if (legoTrackingId != null)
      {
        if (legoTrackingId.equals(legoTrackingId)) {}
      }
      else {
        while (legoTrackingId != null) {
          return false;
        }
      }
      if (required != required) {
        return false;
      }
      if (counted != counted) {
        return false;
      }
      if (taskName != null)
      {
        if (taskName.equals(taskName)) {}
      }
      else {
        while (taskName != null) {
          return false;
        }
      }
      if (taskInfo == null) {
        break;
      }
    } while (taskInfo.equals(taskInfo));
    for (;;)
    {
      return false;
      if (taskInfo == null) {
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
    if (hasLegoTrackingId) {
      i = PegasusBinaryUtils.getEncodedLength(legoTrackingId) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasRequired) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasCounted) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasTaskName) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasTaskInfo)
    {
      i = j + 1;
      if (taskInfo._cachedId == null) {
        break label138;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(taskInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label138:
      i += taskInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 1;
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (legoTrackingId != null)
    {
      i = legoTrackingId.hashCode();
      if (!required) {
        break label120;
      }
      j = 1;
      label41:
      if (!counted) {
        break label125;
      }
      label48:
      if (taskName == null) {
        break label130;
      }
    }
    label120:
    label125:
    label130:
    for (int m = taskName.hashCode();; m = 0)
    {
      if (taskInfo != null) {
        n = taskInfo.hashCode();
      }
      i = (m + ((j + (i + 527) * 31) * 31 + k) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label41;
      k = 0;
      break label48;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building GuidedEditTask");
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
    label160:
    label169:
    label193:
    label202:
    label231:
    label334:
    label340:
    label350:
    label356:
    label366:
    label376:
    label401:
    label409:
    label411:
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
        localByteBuffer.putInt(-1004849691);
        if (hasLegoTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingId);
          if (!hasRequired) {
            break label340;
          }
          localByteBuffer.put((byte)1);
          if (!required) {
            break label334;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasCounted) {
            break label356;
          }
          localByteBuffer.put((byte)1);
          if (!counted) {
            break label350;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasTaskName) {
            break label366;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, taskName.ordinal());
          if (!hasTaskInfo) {
            break label401;
          }
          localByteBuffer.put((byte)1);
          if (taskInfo._cachedId == null) {
            break label376;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, taskInfo._cachedId);
          taskInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label409;
          }
          if (str != null) {
            break label411;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label160;
          localByteBuffer.put((byte)0);
          break label169;
          i = 0;
          break label193;
          localByteBuffer.put((byte)0);
          break label202;
          localByteBuffer.put((byte)0);
          break label231;
          localByteBuffer.put((byte)1);
          taskInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
  
  public static final class TaskInfo
    implements FissileDataModel<TaskInfo>, UnionTemplate<TaskInfo>
  {
    public static final GuidedEditTaskBuilder.TaskInfoBuilder BUILDER = GuidedEditTaskBuilder.TaskInfoBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final CustomTaskInfo customTaskInfoValue;
    public final boolean hasCustomTaskInfoValue;
    public final boolean hasProfileEditTaskInfoValue;
    public final boolean hasSimpleTaskInfoValue;
    public final boolean hasSuggestedEditTaskInfoValue;
    public final ProfileEditTaskInfo profileEditTaskInfoValue;
    public final SimpleTaskInfo simpleTaskInfoValue;
    public final SuggestedEditTaskInfo suggestedEditTaskInfoValue;
    
    TaskInfo(ProfileEditTaskInfo paramProfileEditTaskInfo, SimpleTaskInfo paramSimpleTaskInfo, CustomTaskInfo paramCustomTaskInfo, SuggestedEditTaskInfo paramSuggestedEditTaskInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      profileEditTaskInfoValue = paramProfileEditTaskInfo;
      simpleTaskInfoValue = paramSimpleTaskInfo;
      customTaskInfoValue = paramCustomTaskInfo;
      suggestedEditTaskInfoValue = paramSuggestedEditTaskInfo;
      hasProfileEditTaskInfoValue = paramBoolean1;
      hasSimpleTaskInfoValue = paramBoolean2;
      hasCustomTaskInfoValue = paramBoolean3;
      hasSuggestedEditTaskInfoValue = paramBoolean4;
      _cachedId = null;
    }
    
    public final TaskInfo accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      label95:
      label106:
      Object localObject4;
      boolean bool3;
      if (hasProfileEditTaskInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.guidededit.ProfileEditTaskInfo");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = profileEditTaskInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label261;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasSimpleTaskInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.guidededit.SimpleTaskInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label270;
          }
          localObject1 = simpleTaskInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label288;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasCustomTaskInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.guidededit.CustomTaskInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label297;
          }
          localObject1 = customTaskInfoValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label315;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        label158:
        localObject1 = null;
        bool4 = false;
        if (hasSuggestedEditTaskInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.guidededit.SuggestedEditTaskInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label325;
          }
          localObject1 = suggestedEditTaskInfoValue.accept(paramDataProcessor);
          label198:
          if (localObject1 == null) {
            break label343;
          }
        }
      }
      label261:
      label270:
      label288:
      label297:
      label315:
      label325:
      label343:
      for (boolean bool4 = true;; bool4 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label349;
        }
        return new TaskInfo((ProfileEditTaskInfo)localObject2, (SimpleTaskInfo)localObject3, (CustomTaskInfo)localObject4, (SuggestedEditTaskInfo)localObject1, bool1, bool2, bool3, bool4);
        localObject1 = (ProfileEditTaskInfo)paramDataProcessor.processDataTemplate(profileEditTaskInfoValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (SimpleTaskInfo)paramDataProcessor.processDataTemplate(simpleTaskInfoValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (CustomTaskInfo)paramDataProcessor.processDataTemplate(customTaskInfoValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (SuggestedEditTaskInfo)paramDataProcessor.processDataTemplate(suggestedEditTaskInfoValue);
        break label198;
      }
      label349:
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
        paramObject = (TaskInfo)paramObject;
        if (profileEditTaskInfoValue != null)
        {
          if (profileEditTaskInfoValue.equals(profileEditTaskInfoValue)) {}
        }
        else {
          while (profileEditTaskInfoValue != null) {
            return false;
          }
        }
        if (simpleTaskInfoValue != null)
        {
          if (simpleTaskInfoValue.equals(simpleTaskInfoValue)) {}
        }
        else {
          while (simpleTaskInfoValue != null) {
            return false;
          }
        }
        if (customTaskInfoValue != null)
        {
          if (customTaskInfoValue.equals(customTaskInfoValue)) {}
        }
        else {
          while (customTaskInfoValue != null) {
            return false;
          }
        }
        if (suggestedEditTaskInfoValue == null) {
          break;
        }
      } while (suggestedEditTaskInfoValue.equals(suggestedEditTaskInfoValue));
      for (;;)
      {
        return false;
        if (suggestedEditTaskInfoValue == null) {
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
      if (hasProfileEditTaskInfoValue)
      {
        if (profileEditTaskInfoValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(profileEditTaskInfoValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasSimpleTaskInfoValue)
        {
          i = j + 1;
          if (simpleTaskInfoValue._cachedId == null) {
            break label198;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(simpleTaskInfoValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasCustomTaskInfoValue)
        {
          i = j + 1;
          if (customTaskInfoValue._cachedId == null) {
            break label211;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(customTaskInfoValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasSuggestedEditTaskInfoValue)
        {
          i = j + 1;
          if (suggestedEditTaskInfoValue._cachedId == null) {
            break label224;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestedEditTaskInfoValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = profileEditTaskInfoValue.getSerializedSize() + 7;
        break;
        label198:
        i += simpleTaskInfoValue.getSerializedSize();
        break label93;
        label211:
        i += customTaskInfoValue.getSerializedSize();
        break label135;
        label224:
        i += suggestedEditTaskInfoValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int m = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      int j;
      if (profileEditTaskInfoValue != null)
      {
        i = profileEditTaskInfoValue.hashCode();
        if (simpleTaskInfoValue == null) {
          break label110;
        }
        j = simpleTaskInfoValue.hashCode();
        label45:
        if (customTaskInfoValue == null) {
          break label115;
        }
      }
      label110:
      label115:
      for (int k = customTaskInfoValue.hashCode();; k = 0)
      {
        if (suggestedEditTaskInfoValue != null) {
          m = suggestedEditTaskInfoValue.hashCode();
        }
        i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
        _cachedHashCode = i;
        return i;
        i = 0;
        break;
        j = 0;
        break label45;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TaskInfo");
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
      label230:
      label290:
      label418:
      label443:
      label453:
      label478:
      label488:
      label513:
      label521:
      label523:
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
          localByteBuffer.putInt(-1755834724);
          if (hasProfileEditTaskInfoValue)
          {
            localByteBuffer.put((byte)1);
            if (profileEditTaskInfoValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, profileEditTaskInfoValue._cachedId);
              profileEditTaskInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSimpleTaskInfoValue) {
                break label443;
              }
              localByteBuffer.put((byte)1);
              if (simpleTaskInfoValue._cachedId == null) {
                break label418;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, simpleTaskInfoValue._cachedId);
              simpleTaskInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCustomTaskInfoValue) {
                break label478;
              }
              localByteBuffer.put((byte)1);
              if (customTaskInfoValue._cachedId == null) {
                break label453;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, customTaskInfoValue._cachedId);
              customTaskInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSuggestedEditTaskInfoValue) {
                break label513;
              }
              localByteBuffer.put((byte)1);
              if (suggestedEditTaskInfoValue._cachedId == null) {
                break label488;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, suggestedEditTaskInfoValue._cachedId);
              suggestedEditTaskInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label521;
            }
            if (str != null) {
              break label523;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            profileEditTaskInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            simpleTaskInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            customTaskInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
            localByteBuffer.put((byte)1);
            suggestedEditTaskInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            continue;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */