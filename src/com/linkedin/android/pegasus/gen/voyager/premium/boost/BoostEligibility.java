package com.linkedin.android.pegasus.gen.voyager.premium.boost;

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

public final class BoostEligibility
  implements FissileDataModel<BoostEligibility>, RecordTemplate<BoostEligibility>
{
  public static final BoostEligibilityBuilder BUILDER = BoostEligibilityBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasPromotionData;
  public final boolean hasUserEligible;
  public final BoostPromotionalData promotionData;
  public final boolean userEligible;
  
  BoostEligibility(boolean paramBoolean1, BoostPromotionalData paramBoostPromotionalData, boolean paramBoolean2, boolean paramBoolean3)
  {
    userEligible = paramBoolean1;
    promotionData = paramBoostPromotionalData;
    hasUserEligible = paramBoolean2;
    hasPromotionData = paramBoolean3;
    _cachedId = null;
  }
  
  private BoostEligibility accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasUserEligible)
    {
      paramDataProcessor.startRecordField$505cff1c("userEligible");
      paramDataProcessor.processBoolean(userEligible);
    }
    BoostPromotionalData localBoostPromotionalData = null;
    boolean bool = false;
    if (hasPromotionData)
    {
      paramDataProcessor.startRecordField$505cff1c("promotionData");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localBoostPromotionalData = promotionData.accept(paramDataProcessor);
      if (localBoostPromotionalData == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label158;
      }
      try
      {
        if (hasUserEligible) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostEligibility", "userEligible");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localBoostPromotionalData = (BoostPromotionalData)paramDataProcessor.processDataTemplate(promotionData);
      break;
    }
    label140:
    return new BoostEligibility(userEligible, localBoostPromotionalData, hasUserEligible, bool);
    label158:
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
      paramObject = (BoostEligibility)paramObject;
      if (userEligible != userEligible) {
        return false;
      }
      if (promotionData == null) {
        break;
      }
    } while (promotionData.equals(promotionData));
    for (;;)
    {
      return false;
      if (promotionData == null) {
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
    if (hasUserEligible) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasPromotionData)
    {
      i = j + 1;
      if (promotionData._cachedId == null) {
        break label82;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(promotionData._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label82:
      i += promotionData.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (userEligible) {}
    for (int i = 1;; i = 0)
    {
      if (promotionData != null) {
        j = promotionData.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building BoostEligibility");
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
    label143:
    label252:
    label277:
    label285:
    label287:
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
        localByteBuffer.putInt(-1927383649);
        if (hasUserEligible)
        {
          localByteBuffer.put((byte)1);
          if (userEligible)
          {
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasPromotionData) {
              break label277;
            }
            localByteBuffer.put((byte)1);
            if (promotionData._cachedId == null) {
              break label252;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, promotionData._cachedId);
            promotionData.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label285;
          }
          if (str != null) {
            break label287;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          i = 0;
          break;
          localByteBuffer.put((byte)0);
          break label143;
          localByteBuffer.put((byte)1);
          promotionData.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostEligibility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */