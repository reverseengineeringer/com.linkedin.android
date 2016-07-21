package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RecommendedEntity
  implements FissileDataModel<RecommendedEntity>, UnionTemplate<RecommendedEntity>
{
  public static final RecommendedEntityBuilder BUILDER = RecommendedEntityBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasRecommendedChannelValue;
  public final boolean hasRecommendedCompanyValue;
  public final boolean hasRecommendedMemberValue;
  public final RecommendedChannel recommendedChannelValue;
  public final RecommendedCompany recommendedCompanyValue;
  public final RecommendedMember recommendedMemberValue;
  
  RecommendedEntity(RecommendedCompany paramRecommendedCompany, RecommendedChannel paramRecommendedChannel, RecommendedMember paramRecommendedMember, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    recommendedCompanyValue = paramRecommendedCompany;
    recommendedChannelValue = paramRecommendedChannel;
    recommendedMemberValue = paramRecommendedMember;
    hasRecommendedCompanyValue = paramBoolean1;
    hasRecommendedChannelValue = paramBoolean2;
    hasRecommendedMemberValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final RecommendedEntity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasRecommendedCompanyValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.packageRecommendations.RecommendedCompany");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = recommendedCompanyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label205;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasRecommendedChannelValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.packageRecommendations.RecommendedChannel");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localObject1 = recommendedChannelValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label232;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasRecommendedMemberValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.packageRecommendations.RecommendedMember");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localObject1 = recommendedMemberValue.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label259;
        }
      }
    }
    label205:
    label214:
    label232:
    label241:
    label259:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label265;
      }
      return new RecommendedEntity((RecommendedCompany)localObject2, (RecommendedChannel)localObject3, (RecommendedMember)localObject1, bool1, bool2, bool3);
      localObject1 = (RecommendedCompany)paramDataProcessor.processDataTemplate(recommendedCompanyValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (RecommendedChannel)paramDataProcessor.processDataTemplate(recommendedChannelValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (RecommendedMember)paramDataProcessor.processDataTemplate(recommendedMemberValue);
      break label146;
    }
    label265:
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
      paramObject = (RecommendedEntity)paramObject;
      if (recommendedCompanyValue != null)
      {
        if (recommendedCompanyValue.equals(recommendedCompanyValue)) {}
      }
      else {
        while (recommendedCompanyValue != null) {
          return false;
        }
      }
      if (recommendedChannelValue != null)
      {
        if (recommendedChannelValue.equals(recommendedChannelValue)) {}
      }
      else {
        while (recommendedChannelValue != null) {
          return false;
        }
      }
      if (recommendedMemberValue == null) {
        break;
      }
    } while (recommendedMemberValue.equals(recommendedMemberValue));
    for (;;)
    {
      return false;
      if (recommendedMemberValue == null) {
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
    if (hasRecommendedCompanyValue)
    {
      if (recommendedCompanyValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(recommendedCompanyValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasRecommendedChannelValue)
      {
        i = j + 1;
        if (recommendedChannelValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(recommendedChannelValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasRecommendedMemberValue)
      {
        i = j + 1;
        if (recommendedMemberValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(recommendedMemberValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = recommendedCompanyValue.getSerializedSize() + 7;
      break;
      label156:
      i += recommendedChannelValue.getSerializedSize();
      break label93;
      label169:
      i += recommendedMemberValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (recommendedCompanyValue != null)
    {
      i = recommendedCompanyValue.hashCode();
      if (recommendedChannelValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = recommendedChannelValue.hashCode();; j = 0)
    {
      if (recommendedMemberValue != null) {
        k = recommendedMemberValue.hashCode();
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
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RecommendedEntity");
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
    label358:
    label383:
    label393:
    label418:
    label426:
    label428:
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
        localByteBuffer.putInt(-269256184);
        if (hasRecommendedCompanyValue)
        {
          localByteBuffer.put((byte)1);
          if (recommendedCompanyValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, recommendedCompanyValue._cachedId);
            recommendedCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasRecommendedChannelValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (recommendedChannelValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, recommendedChannelValue._cachedId);
            recommendedChannelValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasRecommendedMemberValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (recommendedMemberValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, recommendedMemberValue._cachedId);
            recommendedMemberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label426;
          }
          if (str != null) {
            break label428;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          recommendedCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          recommendedChannelValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          recommendedMemberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */