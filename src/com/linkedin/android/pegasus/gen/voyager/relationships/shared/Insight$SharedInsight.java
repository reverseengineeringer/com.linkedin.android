package com.linkedin.android.pegasus.gen.voyager.relationships.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Insight$SharedInsight
  implements FissileDataModel<SharedInsight>, UnionTemplate<SharedInsight>
{
  public static final InsightBuilder.SharedInsightBuilder BUILDER = InsightBuilder.SharedInsightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasSharedCompanyInsightValue;
  public final boolean hasSharedConnectionsInsightValue;
  public final boolean hasSharedEducationInsightValue;
  public final SharedCompanyInsight sharedCompanyInsightValue;
  public final SharedConnectionsInsight sharedConnectionsInsightValue;
  public final SharedEducationInsight sharedEducationInsightValue;
  
  Insight$SharedInsight(SharedCompanyInsight paramSharedCompanyInsight, SharedConnectionsInsight paramSharedConnectionsInsight, SharedEducationInsight paramSharedEducationInsight, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    sharedCompanyInsightValue = paramSharedCompanyInsight;
    sharedConnectionsInsightValue = paramSharedConnectionsInsight;
    sharedEducationInsightValue = paramSharedEducationInsight;
    hasSharedCompanyInsightValue = paramBoolean1;
    hasSharedConnectionsInsightValue = paramBoolean2;
    hasSharedEducationInsightValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final SharedInsight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasSharedCompanyInsightValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.SharedCompanyInsight");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = sharedCompanyInsightValue.accept(paramDataProcessor);
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
      if (hasSharedConnectionsInsightValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.SharedConnectionsInsight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localObject1 = sharedConnectionsInsightValue.accept(paramDataProcessor);
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
      if (hasSharedEducationInsightValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.SharedEducationInsight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localObject1 = sharedEducationInsightValue.accept(paramDataProcessor);
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
      return new SharedInsight((SharedCompanyInsight)localObject2, (SharedConnectionsInsight)localObject3, (SharedEducationInsight)localObject1, bool1, bool2, bool3);
      localObject1 = (SharedCompanyInsight)paramDataProcessor.processDataTemplate(sharedCompanyInsightValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SharedConnectionsInsight)paramDataProcessor.processDataTemplate(sharedConnectionsInsightValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (SharedEducationInsight)paramDataProcessor.processDataTemplate(sharedEducationInsightValue);
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
      paramObject = (SharedInsight)paramObject;
      if (sharedCompanyInsightValue != null)
      {
        if (sharedCompanyInsightValue.equals(sharedCompanyInsightValue)) {}
      }
      else {
        while (sharedCompanyInsightValue != null) {
          return false;
        }
      }
      if (sharedConnectionsInsightValue != null)
      {
        if (sharedConnectionsInsightValue.equals(sharedConnectionsInsightValue)) {}
      }
      else {
        while (sharedConnectionsInsightValue != null) {
          return false;
        }
      }
      if (sharedEducationInsightValue == null) {
        break;
      }
    } while (sharedEducationInsightValue.equals(sharedEducationInsightValue));
    for (;;)
    {
      return false;
      if (sharedEducationInsightValue == null) {
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
    if (hasSharedCompanyInsightValue)
    {
      if (sharedCompanyInsightValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(sharedCompanyInsightValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSharedConnectionsInsightValue)
      {
        i = j + 1;
        if (sharedConnectionsInsightValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedConnectionsInsightValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasSharedEducationInsightValue)
      {
        i = j + 1;
        if (sharedEducationInsightValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedEducationInsightValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = sharedCompanyInsightValue.getSerializedSize() + 7;
      break;
      label156:
      i += sharedConnectionsInsightValue.getSerializedSize();
      break label93;
      label169:
      i += sharedEducationInsightValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (sharedCompanyInsightValue != null)
    {
      i = sharedCompanyInsightValue.hashCode();
      if (sharedConnectionsInsightValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = sharedConnectionsInsightValue.hashCode();; j = 0)
    {
      if (sharedEducationInsightValue != null) {
        k = sharedEducationInsightValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SharedInsight");
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
        localByteBuffer.putInt(-1820056029);
        if (hasSharedCompanyInsightValue)
        {
          localByteBuffer.put((byte)1);
          if (sharedCompanyInsightValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sharedCompanyInsightValue._cachedId);
            sharedCompanyInsightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSharedConnectionsInsightValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (sharedConnectionsInsightValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sharedConnectionsInsightValue._cachedId);
            sharedConnectionsInsightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSharedEducationInsightValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (sharedEducationInsightValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, sharedEducationInsightValue._cachedId);
            sharedEducationInsightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          sharedCompanyInsightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          sharedConnectionsInsightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          sharedEducationInsightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.Insight.SharedInsight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */