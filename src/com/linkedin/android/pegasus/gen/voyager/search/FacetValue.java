package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class FacetValue
  implements FissileDataModel<FacetValue>, RecordTemplate<FacetValue>
{
  public static final FacetValueBuilder BUILDER = FacetValueBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String displayValue;
  public final boolean hasDisplayValue;
  public final boolean hasValue;
  public final String value;
  
  FacetValue(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    value = paramString1;
    displayValue = paramString2;
    hasValue = paramBoolean1;
    hasDisplayValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final FacetValue accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      paramDataProcessor.processString(value);
    }
    if (hasDisplayValue)
    {
      paramDataProcessor.startRecordField$505cff1c("displayValue");
      paramDataProcessor.processString(displayValue);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasValue) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.FacetValue", "value");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasDisplayValue) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.FacetValue", "displayValue");
      }
      return new FacetValue(value, displayValue, hasValue, hasDisplayValue);
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
      paramObject = (FacetValue)paramObject;
      if (value != null)
      {
        if (value.equals(value)) {}
      }
      else {
        while (value != null) {
          return false;
        }
      }
      if (displayValue == null) {
        break;
      }
    } while (displayValue.equals(displayValue));
    for (;;)
    {
      return false;
      if (displayValue == null) {
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
    if (hasValue) {
      i = PegasusBinaryUtils.getEncodedLength(value) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDisplayValue) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displayValue);
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
    if (value != null) {}
    for (int i = value.hashCode();; i = 0)
    {
      if (displayValue != null) {
        j = displayValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FacetValue");
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
        localByteBuffer.putInt(-857199476);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, value);
          if (!hasDisplayValue) {
            break label205;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayValue);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.FacetValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */