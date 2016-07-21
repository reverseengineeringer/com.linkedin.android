package com.linkedin.android.pegasus.gen.restli.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ErrorResponse
  implements FissileDataModel<ErrorResponse>, RecordTemplate<ErrorResponse>
{
  public static final ErrorResponseBuilder BUILDER = ErrorResponseBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String exceptionClass;
  public final boolean hasExceptionClass;
  public final boolean hasMessage;
  public final boolean hasServiceErrorCode;
  public final boolean hasStackTrace;
  public final boolean hasStatus;
  public final String message;
  public final int serviceErrorCode;
  public final String stackTrace;
  public final int status;
  
  ErrorResponse(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    status = paramInt1;
    serviceErrorCode = paramInt2;
    message = paramString1;
    exceptionClass = paramString2;
    stackTrace = paramString3;
    hasStatus = paramBoolean1;
    hasServiceErrorCode = paramBoolean2;
    hasMessage = paramBoolean3;
    hasExceptionClass = paramBoolean4;
    hasStackTrace = paramBoolean5;
    _cachedId = null;
  }
  
  public final ErrorResponse accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("status");
      paramDataProcessor.processInt(status);
    }
    if (hasServiceErrorCode)
    {
      paramDataProcessor.startRecordField$505cff1c("serviceErrorCode");
      paramDataProcessor.processInt(serviceErrorCode);
    }
    if (hasMessage)
    {
      paramDataProcessor.startRecordField$505cff1c("message");
      paramDataProcessor.processString(message);
    }
    if (hasExceptionClass)
    {
      paramDataProcessor.startRecordField$505cff1c("exceptionClass");
      paramDataProcessor.processString(exceptionClass);
    }
    if (hasStackTrace)
    {
      paramDataProcessor.startRecordField$505cff1c("stackTrace");
      paramDataProcessor.processString(stackTrace);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new ErrorResponse(status, serviceErrorCode, message, exceptionClass, stackTrace, hasStatus, hasServiceErrorCode, hasMessage, hasExceptionClass, hasStackTrace);
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
      paramObject = (ErrorResponse)paramObject;
      if (status != status) {
        return false;
      }
      if (serviceErrorCode != serviceErrorCode) {
        return false;
      }
      if (message != null)
      {
        if (message.equals(message)) {}
      }
      else {
        while (message != null) {
          return false;
        }
      }
      if (exceptionClass != null)
      {
        if (exceptionClass.equals(exceptionClass)) {}
      }
      else {
        while (exceptionClass != null) {
          return false;
        }
      }
      if (stackTrace == null) {
        break;
      }
    } while (stackTrace.equals(stackTrace));
    for (;;)
    {
      return false;
      if (stackTrace == null) {
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
    if (hasStatus) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasServiceErrorCode) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasMessage) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(message);
    }
    j = i + 1;
    i = j;
    if (hasExceptionClass) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(exceptionClass);
    }
    j = i + 1;
    i = j;
    if (hasStackTrace) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(stackTrace);
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
    int m = status;
    int n = serviceErrorCode;
    int i;
    if (message != null)
    {
      i = message.hashCode();
      if (exceptionClass == null) {
        break label111;
      }
    }
    label111:
    for (int j = exceptionClass.hashCode();; j = 0)
    {
      if (stackTrace != null) {
        k = stackTrace.hashCode();
      }
      i = (j + (i + ((m + 527) * 31 + n) * 31) * 31) * 31 + k;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ErrorResponse");
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
    label158:
    label184:
    label210:
    label279:
    label289:
    label299:
    label309:
    label317:
    label319:
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
        localByteBuffer.putInt(-1197169867);
        if (hasStatus)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(status);
          if (!hasServiceErrorCode) {
            break label279;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(serviceErrorCode);
          if (!hasMessage) {
            break label289;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, message);
          if (!hasExceptionClass) {
            break label299;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, exceptionClass);
          if (!hasStackTrace) {
            break label309;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, stackTrace);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label317;
          }
          if (str != null) {
            break label319;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label158;
          localByteBuffer.put((byte)0);
          break label184;
          localByteBuffer.put((byte)0);
          break label210;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.restli.common.ErrorResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */