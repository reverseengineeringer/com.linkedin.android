package com.linkedin.android.pegasus.gen.voyager.premium.boost;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Duration;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BoostPromotionalData
  implements FissileDataModel<BoostPromotionalData>, RecordTemplate<BoostPromotionalData>
{
  public static final BoostPromotionalDataBuilder BUILDER = BoostPromotionalDataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String carrierName;
  public final Duration duration;
  public final String formattedSubscriptionPrice;
  public final boolean hasCarrierName;
  public final boolean hasDuration;
  public final boolean hasFormattedSubscriptionPrice;
  public final boolean hasProductId;
  public final boolean hasSubscriptionName;
  public final int productId;
  public final String subscriptionName;
  
  BoostPromotionalData(String paramString1, String paramString2, String paramString3, int paramInt, Duration paramDuration, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    carrierName = paramString1;
    formattedSubscriptionPrice = paramString2;
    subscriptionName = paramString3;
    productId = paramInt;
    duration = paramDuration;
    hasCarrierName = paramBoolean1;
    hasFormattedSubscriptionPrice = paramBoolean2;
    hasSubscriptionName = paramBoolean3;
    hasProductId = paramBoolean4;
    hasDuration = paramBoolean5;
    _cachedId = null;
  }
  
  public final BoostPromotionalData accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCarrierName)
    {
      paramDataProcessor.startRecordField$505cff1c("carrierName");
      paramDataProcessor.processString(carrierName);
    }
    if (hasFormattedSubscriptionPrice)
    {
      paramDataProcessor.startRecordField$505cff1c("formattedSubscriptionPrice");
      paramDataProcessor.processString(formattedSubscriptionPrice);
    }
    if (hasSubscriptionName)
    {
      paramDataProcessor.startRecordField$505cff1c("subscriptionName");
      paramDataProcessor.processString(subscriptionName);
    }
    if (hasProductId)
    {
      paramDataProcessor.startRecordField$505cff1c("productId");
      paramDataProcessor.processInt(productId);
    }
    Duration localDuration = null;
    boolean bool = false;
    if (hasDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("duration");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label193;
      }
      localDuration = duration.accept(paramDataProcessor);
      if (localDuration == null) {
        break label210;
      }
    }
    label193:
    label210:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label333;
      }
      try
      {
        if (hasCarrierName) {
          break label215;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData", "carrierName");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localDuration = (Duration)paramDataProcessor.processDataTemplate(duration);
      break;
    }
    label215:
    if (!hasFormattedSubscriptionPrice) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData", "formattedSubscriptionPrice");
    }
    if (!hasSubscriptionName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData", "subscriptionName");
    }
    if (!hasProductId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData", "productId");
    }
    if (!hasDuration) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData", "duration");
    }
    return new BoostPromotionalData(carrierName, formattedSubscriptionPrice, subscriptionName, productId, localDuration, hasCarrierName, hasFormattedSubscriptionPrice, hasSubscriptionName, hasProductId, bool);
    label333:
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
      paramObject = (BoostPromotionalData)paramObject;
      if (carrierName != null)
      {
        if (carrierName.equals(carrierName)) {}
      }
      else {
        while (carrierName != null) {
          return false;
        }
      }
      if (formattedSubscriptionPrice != null)
      {
        if (formattedSubscriptionPrice.equals(formattedSubscriptionPrice)) {}
      }
      else {
        while (formattedSubscriptionPrice != null) {
          return false;
        }
      }
      if (subscriptionName != null)
      {
        if (subscriptionName.equals(subscriptionName)) {}
      }
      else {
        while (subscriptionName != null) {
          return false;
        }
      }
      if (productId != productId) {
        return false;
      }
      if (duration == null) {
        break;
      }
    } while (duration.equals(duration));
    for (;;)
    {
      return false;
      if (duration == null) {
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
    if (hasCarrierName) {
      i = PegasusBinaryUtils.getEncodedLength(carrierName) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasFormattedSubscriptionPrice) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(formattedSubscriptionPrice);
    }
    j = i + 1;
    i = j;
    if (hasSubscriptionName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(subscriptionName);
    }
    j = i + 1;
    i = j;
    if (hasProductId) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasDuration)
    {
      i = j + 1;
      if (duration._cachedId == null) {
        break label154;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(duration._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label154:
      i += duration.getSerializedSize();
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
    if (carrierName != null)
    {
      i = carrierName.hashCode();
      if (formattedSubscriptionPrice == null) {
        break label122;
      }
      j = formattedSubscriptionPrice.hashCode();
      label45:
      if (subscriptionName == null) {
        break label127;
      }
    }
    label122:
    label127:
    for (int k = subscriptionName.hashCode();; k = 0)
    {
      int n = productId;
      if (duration != null) {
        m = duration.hashCode();
      }
      i = ((k + (j + (i + 527) * 31) * 31) * 31 + n) * 31 + m;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building BoostPromotionalData");
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
    label162:
    label188:
    label212:
    label315:
    label325:
    label335:
    label345:
    label370:
    label378:
    label380:
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
        localByteBuffer.putInt(478053976);
        if (hasCarrierName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, carrierName);
          if (!hasFormattedSubscriptionPrice) {
            break label315;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, formattedSubscriptionPrice);
          if (!hasSubscriptionName) {
            break label325;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subscriptionName);
          if (!hasProductId) {
            break label335;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(productId);
          if (!hasDuration) {
            break label370;
          }
          localByteBuffer.put((byte)1);
          if (duration._cachedId == null) {
            break label345;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, duration._cachedId);
          duration.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label378;
          }
          if (str != null) {
            break label380;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label188;
          localByteBuffer.put((byte)0);
          break label212;
          localByteBuffer.put((byte)1);
          duration.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */