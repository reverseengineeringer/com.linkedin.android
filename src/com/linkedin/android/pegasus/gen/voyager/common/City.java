package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class City
  implements FissileDataModel<City>, RecordTemplate<City>
{
  public static final CityBuilder BUILDER = CityBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String centralizedPostalCode;
  public final String cityCode;
  public final String cityName;
  public final Urn entityUrn;
  public final boolean hasCentralizedPostalCode;
  public final boolean hasCityCode;
  public final boolean hasCityName;
  public final boolean hasEntityUrn;
  
  City(Urn paramUrn, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramUrn;
    cityName = paramString1;
    cityCode = paramString2;
    centralizedPostalCode = paramString3;
    hasEntityUrn = paramBoolean1;
    hasCityName = paramBoolean2;
    hasCityCode = paramBoolean3;
    hasCentralizedPostalCode = paramBoolean4;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private City accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasCityName)
    {
      paramDataProcessor.startRecordField$505cff1c("cityName");
      paramDataProcessor.processString(cityName);
    }
    if (hasCityCode)
    {
      paramDataProcessor.startRecordField$505cff1c("cityCode");
      paramDataProcessor.processString(cityCode);
    }
    if (hasCentralizedPostalCode)
    {
      paramDataProcessor.startRecordField$505cff1c("centralizedPostalCode");
      paramDataProcessor.processString(centralizedPostalCode);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.City", "entityUrn");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCityName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.City", "cityName");
      }
      if (!hasCityCode) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.City", "cityCode");
      }
      return new City(entityUrn, cityName, cityCode, centralizedPostalCode, hasEntityUrn, hasCityName, hasCityCode, hasCentralizedPostalCode);
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
      paramObject = (City)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (cityName != null)
      {
        if (cityName.equals(cityName)) {}
      }
      else {
        while (cityName != null) {
          return false;
        }
      }
      if (cityCode != null)
      {
        if (cityCode.equals(cityCode)) {}
      }
      else {
        while (cityCode != null) {
          return false;
        }
      }
      if (centralizedPostalCode == null) {
        break;
      }
    } while (centralizedPostalCode.equals(centralizedPostalCode));
    for (;;)
    {
      return false;
      if (centralizedPostalCode == null) {
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
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCityName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(cityName);
    }
    j = i + 1;
    i = j;
    if (hasCityCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(cityCode);
    }
    j = i + 1;
    i = j;
    if (hasCentralizedPostalCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(centralizedPostalCode);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (cityName == null) {
        break label110;
      }
      j = cityName.hashCode();
      label45:
      if (cityCode == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = cityCode.hashCode();; k = 0)
    {
      if (centralizedPostalCode != null) {
        m = centralizedPostalCode.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building City");
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
    label170:
    label196:
    label265:
    label275:
    label285:
    label293:
    label295:
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
        localByteBuffer.putInt(840897666);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasCityName) {
            break label265;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, cityName);
          if (!hasCityCode) {
            break label275;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, cityCode);
          if (!hasCentralizedPostalCode) {
            break label285;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, centralizedPostalCode);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label293;
          }
          if (str != null) {
            break label295;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label196;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.City
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */