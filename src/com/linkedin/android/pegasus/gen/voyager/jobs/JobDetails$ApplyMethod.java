package com.linkedin.android.pegasus.gen.voyager.jobs;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobDetails$ApplyMethod
  implements FissileDataModel<ApplyMethod>, UnionTemplate<ApplyMethod>
{
  public static final JobDetailsBuilder.ApplyMethodBuilder BUILDER = JobDetailsBuilder.ApplyMethodBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasOffsiteApplyValue;
  public final boolean hasSimpleOnsiteApplyValue;
  public final OffsiteApply offsiteApplyValue;
  public final SimpleOnsiteApply simpleOnsiteApplyValue;
  
  JobDetails$ApplyMethod(OffsiteApply paramOffsiteApply, SimpleOnsiteApply paramSimpleOnsiteApply, boolean paramBoolean1, boolean paramBoolean2)
  {
    offsiteApplyValue = paramOffsiteApply;
    simpleOnsiteApplyValue = paramSimpleOnsiteApply;
    hasOffsiteApplyValue = paramBoolean1;
    hasSimpleOnsiteApplyValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final ApplyMethod accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasOffsiteApplyValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.jobs.OffsiteApply");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = offsiteApplyValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label145;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasSimpleOnsiteApplyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.jobs.SimpleOnsiteApply");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label154;
        }
        localObject1 = SimpleOnsiteApply.accept(paramDataProcessor);
        label91:
        if (localObject1 == null) {
          break label172;
        }
      }
    }
    label145:
    label154:
    label172:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label177;
      }
      return new ApplyMethod((OffsiteApply)localObject2, (SimpleOnsiteApply)localObject1, bool1, bool2);
      localObject1 = (OffsiteApply)paramDataProcessor.processDataTemplate(offsiteApplyValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SimpleOnsiteApply)paramDataProcessor.processDataTemplate(simpleOnsiteApplyValue);
      break label91;
    }
    label177:
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
      paramObject = (ApplyMethod)paramObject;
      if (offsiteApplyValue != null)
      {
        if (offsiteApplyValue.equals(offsiteApplyValue)) {}
      }
      else {
        while (offsiteApplyValue != null) {
          return false;
        }
      }
      if (simpleOnsiteApplyValue == null) {
        break;
      }
    } while (simpleOnsiteApplyValue.equals(simpleOnsiteApplyValue));
    for (;;)
    {
      return false;
      if (simpleOnsiteApplyValue == null) {
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
    if (hasOffsiteApplyValue)
    {
      if (offsiteApplyValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(offsiteApplyValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSimpleOnsiteApplyValue)
      {
        i = j + 1;
        if (simpleOnsiteApplyValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(simpleOnsiteApplyValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = offsiteApplyValue.getSerializedSize() + 7;
      break;
      label114:
      i += simpleOnsiteApplyValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (offsiteApplyValue != null) {}
    for (int i = offsiteApplyValue.hashCode();; i = 0)
    {
      if (simpleOnsiteApplyValue != null) {
        j = simpleOnsiteApplyValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ApplyMethod");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(1225190631);
        if (hasOffsiteApplyValue)
        {
          localByteBuffer.put((byte)1);
          if (offsiteApplyValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, offsiteApplyValue._cachedId);
            offsiteApplyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSimpleOnsiteApplyValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (simpleOnsiteApplyValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, simpleOnsiteApplyValue._cachedId);
            simpleOnsiteApplyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          offsiteApplyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          simpleOnsiteApplyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails.ApplyMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */