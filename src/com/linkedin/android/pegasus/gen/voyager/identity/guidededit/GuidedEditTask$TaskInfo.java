package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GuidedEditTask$TaskInfo
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
  
  GuidedEditTask$TaskInfo(ProfileEditTaskInfo paramProfileEditTaskInfo, SimpleTaskInfo paramSimpleTaskInfo, CustomTaskInfo paramCustomTaskInfo, SuggestedEditTaskInfo paramSuggestedEditTaskInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask.TaskInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */