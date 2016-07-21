package com.linkedin.android.pegasus.gen.voyager.feed.actions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UnfollowType
  implements FissileDataModel<UnfollowType>, UnionTemplate<UnfollowType>
{
  public static final UnfollowTypeBuilder BUILDER = UnfollowTypeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasUnfollowChannelValue;
  public final boolean hasUnfollowCompanyValue;
  public final boolean hasUnfollowGroupValue;
  public final boolean hasUnfollowMemberValue;
  public final boolean hasUnfollowSchoolValue;
  public final UnfollowChannel unfollowChannelValue;
  public final UnfollowCompany unfollowCompanyValue;
  public final UnfollowGroup unfollowGroupValue;
  public final UnfollowMember unfollowMemberValue;
  public final UnfollowSchool unfollowSchoolValue;
  
  UnfollowType(UnfollowMember paramUnfollowMember, UnfollowCompany paramUnfollowCompany, UnfollowChannel paramUnfollowChannel, UnfollowSchool paramUnfollowSchool, UnfollowGroup paramUnfollowGroup, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    unfollowMemberValue = paramUnfollowMember;
    unfollowCompanyValue = paramUnfollowCompany;
    unfollowChannelValue = paramUnfollowChannel;
    unfollowSchoolValue = paramUnfollowSchool;
    unfollowGroupValue = paramUnfollowGroup;
    hasUnfollowMemberValue = paramBoolean1;
    hasUnfollowCompanyValue = paramBoolean2;
    hasUnfollowChannelValue = paramBoolean3;
    hasUnfollowSchoolValue = paramBoolean4;
    hasUnfollowGroupValue = paramBoolean5;
    _cachedId = null;
  }
  
  public final UnfollowType accept(DataProcessor paramDataProcessor)
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
    if (hasUnfollowMemberValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowMember");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = unfollowMemberValue.accept(paramDataProcessor);
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
      if (hasUnfollowCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label326;
        }
        localObject1 = unfollowCompanyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label344;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasUnfollowChannelValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowChannel");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label353;
        }
        localObject1 = unfollowChannelValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label371;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasUnfollowSchoolValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowSchool");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label381;
        }
        localObject1 = unfollowSchoolValue.accept(paramDataProcessor);
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
      if (hasUnfollowGroupValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowGroup");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label409;
        }
        localObject1 = unfollowGroupValue.accept(paramDataProcessor);
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
      return new UnfollowType((UnfollowMember)localObject2, (UnfollowCompany)localObject3, (UnfollowChannel)localObject4, (UnfollowSchool)localObject5, (UnfollowGroup)localObject1, bool1, bool2, bool3, bool4, bool5);
      localObject1 = (UnfollowMember)paramDataProcessor.processDataTemplate(unfollowMemberValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UnfollowCompany)paramDataProcessor.processDataTemplate(unfollowCompanyValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (UnfollowChannel)paramDataProcessor.processDataTemplate(unfollowChannelValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (UnfollowSchool)paramDataProcessor.processDataTemplate(unfollowSchoolValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (UnfollowGroup)paramDataProcessor.processDataTemplate(unfollowGroupValue);
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
      paramObject = (UnfollowType)paramObject;
      if (unfollowMemberValue != null)
      {
        if (unfollowMemberValue.equals(unfollowMemberValue)) {}
      }
      else {
        while (unfollowMemberValue != null) {
          return false;
        }
      }
      if (unfollowCompanyValue != null)
      {
        if (unfollowCompanyValue.equals(unfollowCompanyValue)) {}
      }
      else {
        while (unfollowCompanyValue != null) {
          return false;
        }
      }
      if (unfollowChannelValue != null)
      {
        if (unfollowChannelValue.equals(unfollowChannelValue)) {}
      }
      else {
        while (unfollowChannelValue != null) {
          return false;
        }
      }
      if (unfollowSchoolValue != null)
      {
        if (unfollowSchoolValue.equals(unfollowSchoolValue)) {}
      }
      else {
        while (unfollowSchoolValue != null) {
          return false;
        }
      }
      if (unfollowGroupValue == null) {
        break;
      }
    } while (unfollowGroupValue.equals(unfollowGroupValue));
    for (;;)
    {
      return false;
      if (unfollowGroupValue == null) {
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
    if (hasUnfollowMemberValue)
    {
      if (unfollowMemberValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(unfollowMemberValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasUnfollowCompanyValue)
      {
        i = j + 1;
        if (unfollowCompanyValue._cachedId == null) {
          break label240;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowCompanyValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasUnfollowChannelValue)
      {
        i = j + 1;
        if (unfollowChannelValue._cachedId == null) {
          break label253;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowChannelValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasUnfollowSchoolValue)
      {
        i = j + 1;
        if (unfollowSchoolValue._cachedId == null) {
          break label266;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowSchoolValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasUnfollowGroupValue)
      {
        i = j + 1;
        if (unfollowGroupValue._cachedId == null) {
          break label279;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowGroupValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = unfollowMemberValue.getSerializedSize() + 7;
      break;
      label240:
      i += unfollowCompanyValue.getSerializedSize();
      break label93;
      label253:
      i += unfollowChannelValue.getSerializedSize();
      break label135;
      label266:
      i += unfollowSchoolValue.getSerializedSize();
      break label177;
      label279:
      i += unfollowGroupValue.getSerializedSize();
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
    if (unfollowMemberValue != null)
    {
      i = unfollowMemberValue.hashCode();
      if (unfollowCompanyValue == null) {
        break label132;
      }
      j = unfollowCompanyValue.hashCode();
      if (unfollowChannelValue == null) {
        break label137;
      }
      k = unfollowChannelValue.hashCode();
      label60:
      if (unfollowSchoolValue == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = unfollowSchoolValue.hashCode();; m = 0)
    {
      if (unfollowGroupValue != null) {
        n = unfollowGroupValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building UnfollowType");
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
        localByteBuffer.putInt(1826357317);
        if (hasUnfollowMemberValue)
        {
          localByteBuffer.put((byte)1);
          if (unfollowMemberValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, unfollowMemberValue._cachedId);
            unfollowMemberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUnfollowCompanyValue) {
              break label503;
            }
            localByteBuffer.put((byte)1);
            if (unfollowCompanyValue._cachedId == null) {
              break label478;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, unfollowCompanyValue._cachedId);
            unfollowCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUnfollowChannelValue) {
              break label538;
            }
            localByteBuffer.put((byte)1);
            if (unfollowChannelValue._cachedId == null) {
              break label513;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, unfollowChannelValue._cachedId);
            unfollowChannelValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUnfollowSchoolValue) {
              break label573;
            }
            localByteBuffer.put((byte)1);
            if (unfollowSchoolValue._cachedId == null) {
              break label548;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, unfollowSchoolValue._cachedId);
            unfollowSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUnfollowGroupValue) {
              break label608;
            }
            localByteBuffer.put((byte)1);
            if (unfollowGroupValue._cachedId == null) {
              break label583;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, unfollowGroupValue._cachedId);
            unfollowGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          unfollowMemberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          unfollowCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          unfollowChannelValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          unfollowSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          unfollowGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */