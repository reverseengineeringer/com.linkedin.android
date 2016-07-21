package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GuidedEditProfileUpdate$ProfileUpdate
  implements FissileDataModel<ProfileUpdate>, UnionTemplate<ProfileUpdate>
{
  public static final GuidedEditProfileUpdateBuilder.ProfileUpdateBuilder BUILDER = GuidedEditProfileUpdateBuilder.ProfileUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasNormEducationValue;
  public final boolean hasNormPositionValue;
  public final NormEducation normEducationValue;
  public final NormPosition normPositionValue;
  
  public GuidedEditProfileUpdate$ProfileUpdate(NormPosition paramNormPosition, NormEducation paramNormEducation, boolean paramBoolean1, boolean paramBoolean2)
  {
    normPositionValue = paramNormPosition;
    normEducationValue = paramNormEducation;
    hasNormPositionValue = paramBoolean1;
    hasNormEducationValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final ProfileUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasNormPositionValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.NormPosition");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = normPositionValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label149;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasNormEducationValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.NormEducation");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = normEducationValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label176;
        }
      }
    }
    label149:
    label158:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label181;
      }
      return new ProfileUpdate((NormPosition)localObject2, (NormEducation)localObject1, bool1, bool2);
      localObject1 = (NormPosition)paramDataProcessor.processDataTemplate(normPositionValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (NormEducation)paramDataProcessor.processDataTemplate(normEducationValue);
      break label95;
    }
    label181:
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
      paramObject = (ProfileUpdate)paramObject;
      if (normPositionValue != null)
      {
        if (normPositionValue.equals(normPositionValue)) {}
      }
      else {
        while (normPositionValue != null) {
          return false;
        }
      }
      if (normEducationValue == null) {
        break;
      }
    } while (normEducationValue.equals(normEducationValue));
    for (;;)
    {
      return false;
      if (normEducationValue == null) {
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
    if (hasNormPositionValue)
    {
      if (normPositionValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(normPositionValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasNormEducationValue)
      {
        i = j + 1;
        if (normEducationValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(normEducationValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = normPositionValue.getSerializedSize() + 7;
      break;
      label114:
      i += normEducationValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (normPositionValue != null) {}
    for (int i = normPositionValue.hashCode();; i = 0)
    {
      if (normEducationValue != null) {
        j = normEducationValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileUpdate");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(-518974580);
        if (hasNormPositionValue)
        {
          localByteBuffer.put((byte)1);
          if (normPositionValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, normPositionValue._cachedId);
            normPositionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasNormEducationValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (normEducationValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, normEducationValue._cachedId);
            normEducationValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          normPositionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          normEducationValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
  {
    public boolean hasNormEducationValue = false;
    public boolean hasNormPositionValue = false;
    public NormEducation normEducationValue = null;
    public NormPosition normPositionValue = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate.ProfileUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */