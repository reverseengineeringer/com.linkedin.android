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

public final class LixTreatment
  implements FissileDataModel<LixTreatment>, RecordTemplate<LixTreatment>
{
  public static final LixTreatmentBuilder BUILDER = LixTreatmentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasTestKey;
  public final boolean hasTreatment;
  public final String testKey;
  public final String treatment;
  
  LixTreatment(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    testKey = paramString1;
    treatment = paramString2;
    hasTestKey = paramBoolean1;
    hasTreatment = paramBoolean2;
    _cachedId = null;
  }
  
  private LixTreatment accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTestKey)
    {
      paramDataProcessor.startRecordField$505cff1c("testKey");
      paramDataProcessor.processString(testKey);
    }
    if (hasTreatment)
    {
      paramDataProcessor.startRecordField$505cff1c("treatment");
      paramDataProcessor.processString(treatment);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasTestKey) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.LixTreatment", "testKey");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasTreatment) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.LixTreatment", "treatment");
      }
      return new LixTreatment(testKey, treatment, hasTestKey, hasTreatment);
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
      paramObject = (LixTreatment)paramObject;
      if (testKey != null)
      {
        if (testKey.equals(testKey)) {}
      }
      else {
        while (testKey != null) {
          return false;
        }
      }
      if (treatment == null) {
        break;
      }
    } while (treatment.equals(treatment));
    for (;;)
    {
      return false;
      if (treatment == null) {
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
    if (hasTestKey) {
      i = PegasusBinaryUtils.getEncodedLength(testKey) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTreatment) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(treatment);
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
    if (testKey != null) {}
    for (int i = testKey.hashCode();; i = 0)
    {
      if (treatment != null) {
        j = treatment.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building LixTreatment");
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
        localByteBuffer.putInt(-2047019260);
        if (hasTestKey)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, testKey);
          if (!hasTreatment) {
            break label205;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, treatment);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.LixTreatment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */