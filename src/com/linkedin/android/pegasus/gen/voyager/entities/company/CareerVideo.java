package com.linkedin.android.pegasus.gen.voyager.entities.company;

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

public final class CareerVideo
  implements FissileDataModel<CareerVideo>, RecordTemplate<CareerVideo>
{
  public static final CareerVideoBuilder BUILDER = CareerVideoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasRichMediaUrl;
  public final boolean hasVideoCode;
  public final boolean hasVideoType;
  public final String richMediaUrl;
  public final String videoCode;
  public final CareerVideoType videoType;
  
  CareerVideo(CareerVideoType paramCareerVideoType, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    videoType = paramCareerVideoType;
    videoCode = paramString1;
    richMediaUrl = paramString2;
    hasVideoType = paramBoolean1;
    hasVideoCode = paramBoolean2;
    hasRichMediaUrl = paramBoolean3;
    _cachedId = null;
  }
  
  public final CareerVideo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasVideoType)
    {
      paramDataProcessor.startRecordField$505cff1c("videoType");
      paramDataProcessor.processEnum(videoType);
    }
    if (hasVideoCode)
    {
      paramDataProcessor.startRecordField$505cff1c("videoCode");
      paramDataProcessor.processString(videoCode);
    }
    if (hasRichMediaUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("richMediaUrl");
      paramDataProcessor.processString(richMediaUrl);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasVideoCode) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.CareerVideo", "videoCode");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new CareerVideo(videoType, videoCode, richMediaUrl, hasVideoType, hasVideoCode, hasRichMediaUrl);
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
      paramObject = (CareerVideo)paramObject;
      if (videoType != null)
      {
        if (videoType.equals(videoType)) {}
      }
      else {
        while (videoType != null) {
          return false;
        }
      }
      if (videoCode != null)
      {
        if (videoCode.equals(videoCode)) {}
      }
      else {
        while (videoCode != null) {
          return false;
        }
      }
      if (richMediaUrl == null) {
        break;
      }
    } while (richMediaUrl.equals(richMediaUrl));
    for (;;)
    {
      return false;
      if (richMediaUrl == null) {
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
    if (hasVideoType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasVideoCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(videoCode);
    }
    j = i + 1;
    i = j;
    if (hasRichMediaUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(richMediaUrl);
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
    if (videoType != null)
    {
      i = videoType.hashCode();
      if (videoCode == null) {
        break label87;
      }
    }
    label87:
    for (int j = videoCode.hashCode();; j = 0)
    {
      if (richMediaUrl != null) {
        k = richMediaUrl.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CareerVideo");
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
    label165:
    label234:
    label244:
    label252:
    label254:
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
        localByteBuffer.putInt(1288844718);
        if (hasVideoType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, videoType.ordinal());
          if (!hasVideoCode) {
            break label234;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, videoCode);
          if (!hasRichMediaUrl) {
            break label244;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, richMediaUrl);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label252;
          }
          if (str != null) {
            break label254;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerVideo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */