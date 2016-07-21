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

public final class EnrichedLocation
  implements FissileDataModel<EnrichedLocation>, RecordTemplate<EnrichedLocation>
{
  public static final EnrichedLocationBuilder BUILDER = EnrichedLocationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String cityCode;
  public final String cityName;
  public final boolean hasCityCode;
  public final boolean hasCityName;
  public final boolean hasRegionCode;
  public final boolean hasRegionName;
  public final String regionCode;
  public final String regionName;
  
  EnrichedLocation(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    cityCode = paramString1;
    cityName = paramString2;
    regionCode = paramString3;
    regionName = paramString4;
    hasCityCode = paramBoolean1;
    hasCityName = paramBoolean2;
    hasRegionCode = paramBoolean3;
    hasRegionName = paramBoolean4;
    _cachedId = null;
  }
  
  public final EnrichedLocation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCityCode)
    {
      paramDataProcessor.startRecordField$505cff1c("cityCode");
      paramDataProcessor.processString(cityCode);
    }
    if (hasCityName)
    {
      paramDataProcessor.startRecordField$505cff1c("cityName");
      paramDataProcessor.processString(cityName);
    }
    if (hasRegionCode)
    {
      paramDataProcessor.startRecordField$505cff1c("regionCode");
      paramDataProcessor.processString(regionCode);
    }
    if (hasRegionName)
    {
      paramDataProcessor.startRecordField$505cff1c("regionName");
      paramDataProcessor.processString(regionName);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasCityCode) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.EnrichedLocation", "cityCode");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCityName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.EnrichedLocation", "cityName");
      }
      if (!hasRegionCode) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.EnrichedLocation", "regionCode");
      }
      if (!hasRegionName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.EnrichedLocation", "regionName");
      }
      return new EnrichedLocation(cityCode, cityName, regionCode, regionName, hasCityCode, hasCityName, hasRegionCode, hasRegionName);
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
      paramObject = (EnrichedLocation)paramObject;
      if (cityCode != null)
      {
        if (cityCode.equals(cityCode)) {}
      }
      else {
        while (cityCode != null) {
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
      if (regionCode != null)
      {
        if (regionCode.equals(regionCode)) {}
      }
      else {
        while (regionCode != null) {
          return false;
        }
      }
      if (regionName == null) {
        break;
      }
    } while (regionName.equals(regionName));
    for (;;)
    {
      return false;
      if (regionName == null) {
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
    if (hasCityCode) {
      i = PegasusBinaryUtils.getEncodedLength(cityCode) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCityName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(cityName);
    }
    j = i + 1;
    i = j;
    if (hasRegionCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(regionCode);
    }
    j = i + 1;
    i = j;
    if (hasRegionName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(regionName);
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
    if (cityCode != null)
    {
      i = cityCode.hashCode();
      if (cityName == null) {
        break label110;
      }
      j = cityName.hashCode();
      label45:
      if (regionCode == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = regionCode.hashCode();; k = 0)
    {
      if (regionName != null) {
        m = regionName.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EnrichedLocation");
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
    label257:
    label267:
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
        localByteBuffer.putInt(-983218803);
        if (hasCityCode)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, cityCode);
          if (!hasCityName) {
            break label257;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, cityName);
          if (!hasRegionCode) {
            break label267;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, regionCode);
          if (!hasRegionName) {
            break label277;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, regionName);
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
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label188;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.EnrichedLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */