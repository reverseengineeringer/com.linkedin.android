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

public final class CareerSlide
  implements FissileDataModel<CareerSlide>, RecordTemplate<CareerSlide>
{
  public static final CareerSlideBuilder BUILDER = CareerSlideBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String code;
  public final boolean hasCode;
  public final boolean hasRichMediaUrl;
  public final String richMediaUrl;
  
  CareerSlide(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    code = paramString1;
    richMediaUrl = paramString2;
    hasCode = paramBoolean1;
    hasRichMediaUrl = paramBoolean2;
    _cachedId = null;
  }
  
  public final CareerSlide accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCode)
    {
      paramDataProcessor.startRecordField$505cff1c("code");
      paramDataProcessor.processString(code);
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
        if (!hasCode) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.CareerSlide", "code");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new CareerSlide(code, richMediaUrl, hasCode, hasRichMediaUrl);
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
      paramObject = (CareerSlide)paramObject;
      if (code != null)
      {
        if (code.equals(code)) {}
      }
      else {
        while (code != null) {
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
    int i = 0 + 1 + 4 + 1;
    if (hasCode) {
      i = PegasusBinaryUtils.getEncodedLength(code) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasRichMediaUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(richMediaUrl);
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
    if (code != null) {}
    for (int i = code.hashCode();; i = 0)
    {
      if (richMediaUrl != null) {
        j = richMediaUrl.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CareerSlide");
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
        localByteBuffer.putInt(-717094404);
        if (hasCode)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, code);
          if (!hasRichMediaUrl) {
            break label205;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, richMediaUrl);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerSlide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */