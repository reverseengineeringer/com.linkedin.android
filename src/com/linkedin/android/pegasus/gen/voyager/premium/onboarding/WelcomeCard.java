package com.linkedin.android.pegasus.gen.voyager.premium.onboarding;

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

public final class WelcomeCard
  implements FissileDataModel<WelcomeCard>, RecordTemplate<WelcomeCard>
{
  public static final WelcomeCardBuilder BUILDER = WelcomeCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasProductDescription;
  public final boolean hasProductName;
  public final String productDescription;
  public final String productName;
  
  WelcomeCard(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    productName = paramString1;
    productDescription = paramString2;
    hasProductName = paramBoolean1;
    hasProductDescription = paramBoolean2;
    _cachedId = null;
  }
  
  public final WelcomeCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasProductName)
    {
      paramDataProcessor.startRecordField$505cff1c("productName");
      paramDataProcessor.processString(productName);
    }
    if (hasProductDescription)
    {
      paramDataProcessor.startRecordField$505cff1c("productDescription");
      paramDataProcessor.processString(productDescription);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasProductName) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WelcomeCard", "productName");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasProductDescription) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WelcomeCard", "productDescription");
      }
      return new WelcomeCard(productName, productDescription, hasProductName, hasProductDescription);
    }
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
      paramObject = (WelcomeCard)paramObject;
      if (productName != null)
      {
        if (productName.equals(productName)) {}
      }
      else {
        while (productName != null) {
          return false;
        }
      }
      if (productDescription == null) {
        break;
      }
    } while (productDescription.equals(productDescription));
    for (;;)
    {
      return false;
      if (productDescription == null) {
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
    if (hasProductName) {
      i = PegasusBinaryUtils.getEncodedLength(productName) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasProductDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(productDescription);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (productName != null) {}
    for (int i = productName.hashCode();; i = 0)
    {
      if (productDescription != null) {
        j = productDescription.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WelcomeCard");
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
    label205:
    label213:
    label215:
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
        localByteBuffer.putInt(1998172770);
        if (hasProductName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, productName);
          if (!hasProductDescription) {
            break label205;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, productDescription);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label213;
          }
          if (str != null) {
            break label215;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WelcomeCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */