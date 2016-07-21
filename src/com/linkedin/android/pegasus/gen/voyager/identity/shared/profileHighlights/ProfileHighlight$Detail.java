package com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileHighlight$Detail
  implements FissileDataModel<Detail>, UnionTemplate<Detail>
{
  public static final ProfileHighlightBuilder.DetailBuilder BUILDER = ProfileHighlightBuilder.DetailBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasSharedConnectionsInfoValue;
  public final boolean hasSharedEducationsInfoValue;
  public final boolean hasSharedExperiencesInfoValue;
  public final boolean hasSharedGroupsInfoValue;
  public final boolean hasSharedLocationInfoValue;
  public final SharedConnectionsInfo sharedConnectionsInfoValue;
  public final SharedEducationsInfo sharedEducationsInfoValue;
  public final SharedExperiencesInfo sharedExperiencesInfoValue;
  public final SharedGroupsInfo sharedGroupsInfoValue;
  public final SharedLocationInfo sharedLocationInfoValue;
  
  ProfileHighlight$Detail(SharedExperiencesInfo paramSharedExperiencesInfo, SharedEducationsInfo paramSharedEducationsInfo, SharedLocationInfo paramSharedLocationInfo, SharedConnectionsInfo paramSharedConnectionsInfo, SharedGroupsInfo paramSharedGroupsInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    sharedExperiencesInfoValue = paramSharedExperiencesInfo;
    sharedEducationsInfoValue = paramSharedEducationsInfo;
    sharedLocationInfoValue = paramSharedLocationInfo;
    sharedConnectionsInfoValue = paramSharedConnectionsInfo;
    sharedGroupsInfoValue = paramSharedGroupsInfo;
    hasSharedExperiencesInfoValue = paramBoolean1;
    hasSharedEducationsInfoValue = paramBoolean2;
    hasSharedLocationInfoValue = paramBoolean3;
    hasSharedConnectionsInfoValue = paramBoolean4;
    hasSharedGroupsInfoValue = paramBoolean5;
    _cachedId = null;
  }
  
  public final Detail accept(DataProcessor paramDataProcessor)
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
    label146:
    label158:
    Object localObject5;
    boolean bool4;
    if (hasSharedExperiencesInfoValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.profileHighlights.SharedExperiencesInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = sharedExperiencesInfoValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label317;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasSharedEducationsInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.profileHighlights.SharedEducationsInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label326;
        }
        localObject1 = sharedEducationsInfoValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label344;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasSharedLocationInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.profileHighlights.SharedLocationInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label353;
        }
        localObject1 = sharedLocationInfoValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label371;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasSharedConnectionsInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.profileHighlights.SharedConnectionsInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label381;
        }
        localObject1 = sharedConnectionsInfoValue.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label399;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label210:
      localObject1 = null;
      bool5 = false;
      if (hasSharedGroupsInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.profileHighlights.SharedGroupsInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label409;
        }
        localObject1 = sharedGroupsInfoValue.accept(paramDataProcessor);
        label250:
        if (localObject1 == null) {
          break label427;
        }
      }
    }
    label317:
    label326:
    label344:
    label353:
    label371:
    label381:
    label399:
    label409:
    label427:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label433;
      }
      return new Detail((SharedExperiencesInfo)localObject2, (SharedEducationsInfo)localObject3, (SharedLocationInfo)localObject4, (SharedConnectionsInfo)localObject5, (SharedGroupsInfo)localObject1, bool1, bool2, bool3, bool4, bool5);
      localObject1 = (SharedExperiencesInfo)paramDataProcessor.processDataTemplate(sharedExperiencesInfoValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SharedEducationsInfo)paramDataProcessor.processDataTemplate(sharedEducationsInfoValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (SharedLocationInfo)paramDataProcessor.processDataTemplate(sharedLocationInfoValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (SharedConnectionsInfo)paramDataProcessor.processDataTemplate(sharedConnectionsInfoValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (SharedGroupsInfo)paramDataProcessor.processDataTemplate(sharedGroupsInfoValue);
      break label250;
    }
    label433:
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
      paramObject = (Detail)paramObject;
      if (sharedExperiencesInfoValue != null)
      {
        if (sharedExperiencesInfoValue.equals(sharedExperiencesInfoValue)) {}
      }
      else {
        while (sharedExperiencesInfoValue != null) {
          return false;
        }
      }
      if (sharedEducationsInfoValue != null)
      {
        if (sharedEducationsInfoValue.equals(sharedEducationsInfoValue)) {}
      }
      else {
        while (sharedEducationsInfoValue != null) {
          return false;
        }
      }
      if (sharedLocationInfoValue != null)
      {
        if (sharedLocationInfoValue.equals(sharedLocationInfoValue)) {}
      }
      else {
        while (sharedLocationInfoValue != null) {
          return false;
        }
      }
      if (sharedConnectionsInfoValue != null)
      {
        if (sharedConnectionsInfoValue.equals(sharedConnectionsInfoValue)) {}
      }
      else {
        while (sharedConnectionsInfoValue != null) {
          return false;
        }
      }
      if (sharedGroupsInfoValue == null) {
        break;
      }
    } while (sharedGroupsInfoValue.equals(sharedGroupsInfoValue));
    for (;;)
    {
      return false;
      if (sharedGroupsInfoValue == null) {
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
    if (hasSharedExperiencesInfoValue)
    {
      if (sharedExperiencesInfoValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(sharedExperiencesInfoValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSharedEducationsInfoValue)
      {
        i = j + 1;
        if (sharedEducationsInfoValue._cachedId == null) {
          break label240;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedEducationsInfoValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasSharedLocationInfoValue)
      {
        i = j + 1;
        if (sharedLocationInfoValue._cachedId == null) {
          break label253;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedLocationInfoValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasSharedConnectionsInfoValue)
      {
        i = j + 1;
        if (sharedConnectionsInfoValue._cachedId == null) {
          break label266;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedConnectionsInfoValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasSharedGroupsInfoValue)
      {
        i = j + 1;
        if (sharedGroupsInfoValue._cachedId == null) {
          break label279;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedGroupsInfoValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = sharedExperiencesInfoValue.getSerializedSize() + 7;
      break;
      label240:
      i += sharedEducationsInfoValue.getSerializedSize();
      break label93;
      label253:
      i += sharedLocationInfoValue.getSerializedSize();
      break label135;
      label266:
      i += sharedConnectionsInfoValue.getSerializedSize();
      break label177;
      label279:
      i += sharedGroupsInfoValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (sharedExperiencesInfoValue != null)
    {
      i = sharedExperiencesInfoValue.hashCode();
      if (sharedEducationsInfoValue == null) {
        break label132;
      }
      j = sharedEducationsInfoValue.hashCode();
      if (sharedLocationInfoValue == null) {
        break label137;
      }
      k = sharedLocationInfoValue.hashCode();
      label60:
      if (sharedConnectionsInfoValue == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = sharedConnectionsInfoValue.hashCode();; m = 0)
    {
      if (sharedGroupsInfoValue != null) {
        n = sharedGroupsInfoValue.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Detail");
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
    label350:
    label478:
    label503:
    label513:
    label538:
    label548:
    label573:
    label583:
    label608:
    label616:
    label618:
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
        localByteBuffer.putInt(-2142679242);
        if (hasSharedExperiencesInfoValue)
        {
          localByteBuffer.put((byte)1);
          if (sharedExperiencesInfoValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sharedExperiencesInfoValue._cachedId);
            sharedExperiencesInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSharedEducationsInfoValue) {
              break label503;
            }
            localByteBuffer.put((byte)1);
            if (sharedEducationsInfoValue._cachedId == null) {
              break label478;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sharedEducationsInfoValue._cachedId);
            sharedEducationsInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSharedLocationInfoValue) {
              break label538;
            }
            localByteBuffer.put((byte)1);
            if (sharedLocationInfoValue._cachedId == null) {
              break label513;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sharedLocationInfoValue._cachedId);
            sharedLocationInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSharedConnectionsInfoValue) {
              break label573;
            }
            localByteBuffer.put((byte)1);
            if (sharedConnectionsInfoValue._cachedId == null) {
              break label548;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sharedConnectionsInfoValue._cachedId);
            sharedConnectionsInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSharedGroupsInfoValue) {
              break label608;
            }
            localByteBuffer.put((byte)1);
            if (sharedGroupsInfoValue._cachedId == null) {
              break label583;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sharedGroupsInfoValue._cachedId);
            sharedGroupsInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label616;
          }
          if (str != null) {
            break label618;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          sharedExperiencesInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          sharedEducationsInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          sharedLocationInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          sharedConnectionsInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          sharedGroupsInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlight.Detail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */