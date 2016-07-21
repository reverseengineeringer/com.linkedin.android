package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class BasicLocation
  implements FissileDataModel<BasicLocation>, RecordTemplate<BasicLocation>
{
  public static final BasicLocationBuilder BUILDER = BasicLocationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String countryCode;
  public final String countryName;
  public final boolean hasCountryCode;
  public final boolean hasCountryName;
  public final boolean hasPostalCode;
  public final String postalCode;
  
  BasicLocation(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    countryCode = paramString1;
    postalCode = paramString2;
    countryName = paramString3;
    hasCountryCode = paramBoolean1;
    hasPostalCode = paramBoolean2;
    hasCountryName = paramBoolean3;
    _cachedId = null;
  }
  
  private BasicLocation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCountryCode)
    {
      paramDataProcessor.startRecordField$505cff1c("countryCode");
      paramDataProcessor.processString(countryCode);
    }
    if (hasPostalCode)
    {
      paramDataProcessor.startRecordField$505cff1c("postalCode");
      paramDataProcessor.processString(postalCode);
    }
    if (hasCountryName)
    {
      paramDataProcessor.startRecordField$505cff1c("countryName");
      paramDataProcessor.processString(countryName);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasCountryCode) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.BasicLocation", "countryCode");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCountryName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.BasicLocation", "countryName");
      }
      return new BasicLocation(countryCode, postalCode, countryName, hasCountryCode, hasPostalCode, hasCountryName);
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
      paramObject = (BasicLocation)paramObject;
      if (countryCode != null)
      {
        if (countryCode.equals(countryCode)) {}
      }
      else {
        while (countryCode != null) {
          return false;
        }
      }
      if (postalCode != null)
      {
        if (postalCode.equals(postalCode)) {}
      }
      else {
        while (postalCode != null) {
          return false;
        }
      }
      if (countryName == null) {
        break;
      }
    } while (countryName.equals(countryName));
    for (;;)
    {
      return false;
      if (countryName == null) {
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
    if (hasCountryCode) {
      i = PegasusBinaryUtils.getEncodedLength(countryCode) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasPostalCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(postalCode);
    }
    j = i + 1;
    i = j;
    if (hasCountryName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(countryName);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (countryCode != null)
    {
      i = countryCode.hashCode();
      if (postalCode == null) {
        break label87;
      }
    }
    label87:
    for (int j = postalCode.hashCode();; j = 0)
    {
      if (countryName != null) {
        k = countryName.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building BasicLocation");
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
    label231:
    label241:
    label249:
    label251:
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
        localByteBuffer.putInt(-1515574714);
        if (hasCountryCode)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, countryCode);
          if (!hasPostalCode) {
            break label231;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, postalCode);
          if (!hasCountryName) {
            break label241;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, countryName);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label249;
          }
          if (str != null) {
            break label251;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.BasicLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */