package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ViralUpdate$ViralType
  implements FissileDataModel<ViralType>, UnionTemplate<ViralType>
{
  public static final ViralUpdateBuilder.ViralTypeBuilder BUILDER = ViralUpdateBuilder.ViralTypeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasViralCommentOnCommentTypeValue;
  public final boolean hasViralCommentTypeValue;
  public final boolean hasViralLikeOnCommentTypeValue;
  public final boolean hasViralLikeTypeValue;
  public final ViralCommentOnCommentType viralCommentOnCommentTypeValue;
  public final ViralCommentType viralCommentTypeValue;
  public final ViralLikeOnCommentType viralLikeOnCommentTypeValue;
  public final ViralLikeType viralLikeTypeValue;
  
  ViralUpdate$ViralType(ViralLikeType paramViralLikeType, ViralCommentType paramViralCommentType, ViralLikeOnCommentType paramViralLikeOnCommentType, ViralCommentOnCommentType paramViralCommentOnCommentType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    viralLikeTypeValue = paramViralLikeType;
    viralCommentTypeValue = paramViralCommentType;
    viralLikeOnCommentTypeValue = paramViralLikeOnCommentType;
    viralCommentOnCommentTypeValue = paramViralCommentOnCommentType;
    hasViralLikeTypeValue = paramBoolean1;
    hasViralCommentTypeValue = paramBoolean2;
    hasViralLikeOnCommentTypeValue = paramBoolean3;
    hasViralCommentOnCommentTypeValue = paramBoolean4;
    _cachedId = null;
  }
  
  public final ViralType accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label52:
    Object localObject3;
    boolean bool2;
    label91:
    label102:
    Object localObject4;
    boolean bool3;
    if (hasViralLikeTypeValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralLikeType");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = ViralLikeType.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label249;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasViralCommentTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralCommentType");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label258;
        }
        localObject1 = viralCommentTypeValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label276;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasViralLikeOnCommentTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralLikeOnCommentType");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label285;
        }
        localObject1 = ViralLikeOnCommentType.accept(paramDataProcessor);
        label138:
        if (localObject1 == null) {
          break label303;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label150:
      localObject1 = null;
      bool4 = false;
      if (hasViralCommentOnCommentTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralCommentOnCommentType");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label313;
        }
        localObject1 = ViralCommentOnCommentType.accept(paramDataProcessor);
        label186:
        if (localObject1 == null) {
          break label331;
        }
      }
    }
    label249:
    label258:
    label276:
    label285:
    label303:
    label313:
    label331:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label337;
      }
      return new ViralType((ViralLikeType)localObject2, (ViralCommentType)localObject3, (ViralLikeOnCommentType)localObject4, (ViralCommentOnCommentType)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (ViralLikeType)paramDataProcessor.processDataTemplate(viralLikeTypeValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label52;
      localObject1 = (ViralCommentType)paramDataProcessor.processDataTemplate(viralCommentTypeValue);
      break label91;
      bool2 = false;
      localObject3 = localObject1;
      break label102;
      localObject1 = (ViralLikeOnCommentType)paramDataProcessor.processDataTemplate(viralLikeOnCommentTypeValue);
      break label138;
      bool3 = false;
      localObject4 = localObject1;
      break label150;
      localObject1 = (ViralCommentOnCommentType)paramDataProcessor.processDataTemplate(viralCommentOnCommentTypeValue);
      break label186;
    }
    label337:
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
      paramObject = (ViralType)paramObject;
      if (viralLikeTypeValue != null)
      {
        if (viralLikeTypeValue.equals(viralLikeTypeValue)) {}
      }
      else {
        while (viralLikeTypeValue != null) {
          return false;
        }
      }
      if (viralCommentTypeValue != null)
      {
        if (viralCommentTypeValue.equals(viralCommentTypeValue)) {}
      }
      else {
        while (viralCommentTypeValue != null) {
          return false;
        }
      }
      if (viralLikeOnCommentTypeValue != null)
      {
        if (viralLikeOnCommentTypeValue.equals(viralLikeOnCommentTypeValue)) {}
      }
      else {
        while (viralLikeOnCommentTypeValue != null) {
          return false;
        }
      }
      if (viralCommentOnCommentTypeValue == null) {
        break;
      }
    } while (viralCommentOnCommentTypeValue.equals(viralCommentOnCommentTypeValue));
    for (;;)
    {
      return false;
      if (viralCommentOnCommentTypeValue == null) {
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
    if (hasViralLikeTypeValue)
    {
      if (viralLikeTypeValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(viralLikeTypeValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasViralCommentTypeValue)
      {
        i = j + 1;
        if (viralCommentTypeValue._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(viralCommentTypeValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasViralLikeOnCommentTypeValue)
      {
        i = j + 1;
        if (viralLikeOnCommentTypeValue._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(viralLikeOnCommentTypeValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasViralCommentOnCommentTypeValue)
      {
        i = j + 1;
        if (viralCommentOnCommentTypeValue._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(viralCommentOnCommentTypeValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = viralLikeTypeValue.getSerializedSize() + 7;
      break;
      label198:
      i += viralCommentTypeValue.getSerializedSize();
      break label93;
      label211:
      i += viralLikeOnCommentTypeValue.getSerializedSize();
      break label135;
      label224:
      i += viralCommentOnCommentTypeValue.getSerializedSize();
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
    if (viralLikeTypeValue != null)
    {
      i = viralLikeTypeValue.hashCode();
      if (viralCommentTypeValue == null) {
        break label110;
      }
      j = viralCommentTypeValue.hashCode();
      label45:
      if (viralLikeOnCommentTypeValue == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = viralLikeOnCommentTypeValue.hashCode();; k = 0)
    {
      if (viralCommentOnCommentTypeValue != null) {
        m = viralCommentOnCommentTypeValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ViralType");
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
        localByteBuffer.putInt(1982842573);
        if (hasViralLikeTypeValue)
        {
          localByteBuffer.put((byte)1);
          if (viralLikeTypeValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, viralLikeTypeValue._cachedId);
            viralLikeTypeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasViralCommentTypeValue) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (viralCommentTypeValue._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, viralCommentTypeValue._cachedId);
            viralCommentTypeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasViralLikeOnCommentTypeValue) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (viralLikeOnCommentTypeValue._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, viralLikeOnCommentTypeValue._cachedId);
            viralLikeOnCommentTypeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasViralCommentOnCommentTypeValue) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (viralCommentOnCommentTypeValue._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, viralCommentOnCommentTypeValue._cachedId);
            viralCommentOnCommentTypeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          viralLikeTypeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          viralCommentTypeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          viralLikeOnCommentTypeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          viralCommentOnCommentTypeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate.ViralType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */