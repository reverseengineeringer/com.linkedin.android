package com.linkedin.android.pegasus.gen.common;

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

public final class PhoneNumber
  implements FissileDataModel<PhoneNumber>, RecordTemplate<PhoneNumber>
{
  public static final PhoneNumberBuilder BUILDER = PhoneNumberBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String extension;
  public final boolean hasExtension;
  public final boolean hasNumber;
  public final String number;
  
  PhoneNumber(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    number = paramString1;
    extension = paramString2;
    hasNumber = paramBoolean1;
    hasExtension = paramBoolean2;
    _cachedId = null;
  }
  
  public final PhoneNumber accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("number");
      paramDataProcessor.processString(number);
    }
    if (hasExtension)
    {
      paramDataProcessor.startRecordField$505cff1c("extension");
      paramDataProcessor.processString(extension);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumber) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.common.PhoneNumber", "number");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new PhoneNumber(number, extension, hasNumber, hasExtension);
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
      paramObject = (PhoneNumber)paramObject;
      if (number != null)
      {
        if (number.equals(number)) {}
      }
      else {
        while (number != null) {
          return false;
        }
      }
      if (extension == null) {
        break;
      }
    } while (extension.equals(extension));
    for (;;)
    {
      return false;
      if (extension == null) {
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
    if (hasNumber) {
      i = PegasusBinaryUtils.getEncodedLength(number) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasExtension) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(extension);
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
    if (number != null) {}
    for (int i = number.hashCode();; i = 0)
    {
      if (extension != null) {
        j = extension.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PhoneNumber");
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
        localByteBuffer.putInt(-1365380675);
        if (hasNumber)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, number);
          if (!hasExtension) {
            break label205;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, extension);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.PhoneNumber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */