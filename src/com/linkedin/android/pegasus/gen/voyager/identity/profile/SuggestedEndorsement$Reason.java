package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedEndorsement$Reason
  implements FissileDataModel<Reason>, UnionTemplate<Reason>
{
  public static final SuggestedEndorsementBuilder.ReasonBuilder BUILDER = SuggestedEndorsementBuilder.ReasonBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasSuggestedEndorsementReasonExpertValue;
  public final boolean hasSuggestedEndorsementReasonStandardValue;
  public final SuggestedEndorsementReasonExpert suggestedEndorsementReasonExpertValue;
  public final SuggestedEndorsementReasonStandard suggestedEndorsementReasonStandardValue;
  
  SuggestedEndorsement$Reason(SuggestedEndorsementReasonExpert paramSuggestedEndorsementReasonExpert, SuggestedEndorsementReasonStandard paramSuggestedEndorsementReasonStandard, boolean paramBoolean1, boolean paramBoolean2)
  {
    suggestedEndorsementReasonExpertValue = paramSuggestedEndorsementReasonExpert;
    suggestedEndorsementReasonStandardValue = paramSuggestedEndorsementReasonStandard;
    hasSuggestedEndorsementReasonExpertValue = paramBoolean1;
    hasSuggestedEndorsementReasonStandardValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final Reason accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasSuggestedEndorsementReasonExpertValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.SuggestedEndorsementReasonExpert");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = suggestedEndorsementReasonExpertValue.accept(paramDataProcessor);
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
      if (hasSuggestedEndorsementReasonStandardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.SuggestedEndorsementReasonStandard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = suggestedEndorsementReasonStandardValue.accept(paramDataProcessor);
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
      return new Reason((SuggestedEndorsementReasonExpert)localObject2, (SuggestedEndorsementReasonStandard)localObject1, bool1, bool2);
      localObject1 = (SuggestedEndorsementReasonExpert)paramDataProcessor.processDataTemplate(suggestedEndorsementReasonExpertValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SuggestedEndorsementReasonStandard)paramDataProcessor.processDataTemplate(suggestedEndorsementReasonStandardValue);
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
      paramObject = (Reason)paramObject;
      if (suggestedEndorsementReasonExpertValue != null)
      {
        if (suggestedEndorsementReasonExpertValue.equals(suggestedEndorsementReasonExpertValue)) {}
      }
      else {
        while (suggestedEndorsementReasonExpertValue != null) {
          return false;
        }
      }
      if (suggestedEndorsementReasonStandardValue == null) {
        break;
      }
    } while (suggestedEndorsementReasonStandardValue.equals(suggestedEndorsementReasonStandardValue));
    for (;;)
    {
      return false;
      if (suggestedEndorsementReasonStandardValue == null) {
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
    if (hasSuggestedEndorsementReasonExpertValue)
    {
      if (suggestedEndorsementReasonExpertValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(suggestedEndorsementReasonExpertValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSuggestedEndorsementReasonStandardValue)
      {
        i = j + 1;
        if (suggestedEndorsementReasonStandardValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestedEndorsementReasonStandardValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = suggestedEndorsementReasonExpertValue.getSerializedSize() + 7;
      break;
      label114:
      i += suggestedEndorsementReasonStandardValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (suggestedEndorsementReasonExpertValue != null) {}
    for (int i = suggestedEndorsementReasonExpertValue.hashCode();; i = 0)
    {
      if (suggestedEndorsementReasonStandardValue != null) {
        j = suggestedEndorsementReasonStandardValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Reason");
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
        localByteBuffer.putInt(-2025818847);
        if (hasSuggestedEndorsementReasonExpertValue)
        {
          localByteBuffer.put((byte)1);
          if (suggestedEndorsementReasonExpertValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, suggestedEndorsementReasonExpertValue._cachedId);
            suggestedEndorsementReasonExpertValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSuggestedEndorsementReasonStandardValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (suggestedEndorsementReasonStandardValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, suggestedEndorsementReasonStandardValue._cachedId);
            suggestedEndorsementReasonStandardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          suggestedEndorsementReasonExpertValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          suggestedEndorsementReasonStandardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsement.Reason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */