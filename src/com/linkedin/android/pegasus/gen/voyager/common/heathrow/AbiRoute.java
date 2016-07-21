package com.linkedin.android.pegasus.gen.voyager.common.heathrow;

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

public final class AbiRoute
  implements FissileDataModel<AbiRoute>, RecordTemplate<AbiRoute>
{
  public static final AbiRouteBuilder BUILDER = AbiRouteBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLegoTrackingToken;
  public final boolean hasSplashOperation;
  public final String legoTrackingToken;
  public final SplashOperationType splashOperation;
  
  AbiRoute(SplashOperationType paramSplashOperationType, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    splashOperation = paramSplashOperationType;
    legoTrackingToken = paramString;
    hasSplashOperation = paramBoolean1;
    hasLegoTrackingToken = paramBoolean2;
    _cachedId = null;
  }
  
  public final AbiRoute accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSplashOperation)
    {
      paramDataProcessor.startRecordField$505cff1c("splashOperation");
      paramDataProcessor.processEnum(splashOperation);
    }
    if (hasLegoTrackingToken)
    {
      paramDataProcessor.startRecordField$505cff1c("legoTrackingToken");
      paramDataProcessor.processString(legoTrackingToken);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasSplashOperation) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.heathrow.AbiRoute", "splashOperation");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new AbiRoute(splashOperation, legoTrackingToken, hasSplashOperation, hasLegoTrackingToken);
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
      paramObject = (AbiRoute)paramObject;
      if (splashOperation != null)
      {
        if (splashOperation.equals(splashOperation)) {}
      }
      else {
        while (splashOperation != null) {
          return false;
        }
      }
      if (legoTrackingToken == null) {
        break;
      }
    } while (legoTrackingToken.equals(legoTrackingToken));
    for (;;)
    {
      return false;
      if (legoTrackingToken == null) {
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
    if (hasSplashOperation) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasLegoTrackingToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingToken);
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
    if (splashOperation != null) {}
    for (int i = splashOperation.hashCode();; i = 0)
    {
      if (legoTrackingToken != null) {
        j = legoTrackingToken.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AbiRoute");
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
    label208:
    label216:
    label218:
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
        localByteBuffer.putInt(-726480623);
        if (hasSplashOperation)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, splashOperation.ordinal());
          if (!hasLegoTrackingToken) {
            break label208;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label216;
          }
          if (str != null) {
            break label218;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.heathrow.AbiRoute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */