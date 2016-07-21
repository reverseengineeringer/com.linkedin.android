package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class FinancialInformation
  implements FissileDataModel<FinancialInformation>, RecordTemplate<FinancialInformation>
{
  public static final FinancialInformationBuilder BUILDER = FinancialInformationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean financialAidAvailable;
  public final float financialAidPercentage;
  public final boolean hasFinancialAidAvailable;
  public final boolean hasFinancialAidPercentage;
  public final boolean hasInStateTuition;
  public final boolean hasOutOfStateTuition;
  public final String inStateTuition;
  public final String outOfStateTuition;
  
  FinancialInformation(boolean paramBoolean1, float paramFloat, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    financialAidAvailable = paramBoolean1;
    financialAidPercentage = paramFloat;
    inStateTuition = paramString1;
    outOfStateTuition = paramString2;
    hasFinancialAidAvailable = paramBoolean2;
    hasFinancialAidPercentage = paramBoolean3;
    hasInStateTuition = paramBoolean4;
    hasOutOfStateTuition = paramBoolean5;
    _cachedId = null;
  }
  
  public final FinancialInformation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFinancialAidAvailable)
    {
      paramDataProcessor.startRecordField$505cff1c("financialAidAvailable");
      paramDataProcessor.processBoolean(financialAidAvailable);
    }
    if (hasFinancialAidPercentage)
    {
      paramDataProcessor.startRecordField$505cff1c("financialAidPercentage");
      paramDataProcessor.processFloat(financialAidPercentage);
    }
    if (hasInStateTuition)
    {
      paramDataProcessor.startRecordField$505cff1c("inStateTuition");
      paramDataProcessor.processString(inStateTuition);
    }
    if (hasOutOfStateTuition)
    {
      paramDataProcessor.startRecordField$505cff1c("outOfStateTuition");
      paramDataProcessor.processString(outOfStateTuition);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new FinancialInformation(financialAidAvailable, financialAidPercentage, inStateTuition, outOfStateTuition, hasFinancialAidAvailable, hasFinancialAidPercentage, hasInStateTuition, hasOutOfStateTuition);
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
      paramObject = (FinancialInformation)paramObject;
      if (financialAidAvailable != financialAidAvailable) {
        return false;
      }
      if (financialAidPercentage != financialAidPercentage) {
        return false;
      }
      if (inStateTuition != null)
      {
        if (inStateTuition.equals(inStateTuition)) {}
      }
      else {
        while (inStateTuition != null) {
          return false;
        }
      }
      if (outOfStateTuition == null) {
        break;
      }
    } while (outOfStateTuition.equals(outOfStateTuition));
    for (;;)
    {
      return false;
      if (outOfStateTuition == null) {
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
    if (hasFinancialAidAvailable) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasFinancialAidPercentage) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasInStateTuition) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(inStateTuition);
    }
    j = i + 1;
    i = j;
    if (hasOutOfStateTuition) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(outOfStateTuition);
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
    if (financialAidAvailable)
    {
      i = 1;
      if (financialAidPercentage == 0.0F) {
        break label106;
      }
      j = Float.floatToIntBits(financialAidPercentage);
      label41:
      if (inStateTuition == null) {
        break label111;
      }
    }
    label106:
    label111:
    for (int k = inStateTuition.hashCode();; k = 0)
    {
      if (outOfStateTuition != null) {
        m = outOfStateTuition.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label41;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FinancialInformation");
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
    label143:
    label167:
    label193:
    label268:
    label278:
    label288:
    label296:
    label298:
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
        localByteBuffer.putInt(-1614407804);
        if (hasFinancialAidAvailable)
        {
          localByteBuffer.put((byte)1);
          if (financialAidAvailable)
          {
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasFinancialAidPercentage) {
              break label268;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putFloat(financialAidPercentage);
            if (!hasInStateTuition) {
              break label278;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, inStateTuition);
            if (!hasOutOfStateTuition) {
              break label288;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, outOfStateTuition);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label296;
          }
          if (str != null) {
            break label298;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          i = 0;
          break;
          localByteBuffer.put((byte)0);
          break label143;
          localByteBuffer.put((byte)0);
          break label167;
          localByteBuffer.put((byte)0);
          break label193;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.FinancialInformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */