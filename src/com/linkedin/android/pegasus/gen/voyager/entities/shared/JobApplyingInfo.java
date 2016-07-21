package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobApplyingInfo
  implements FissileDataModel<JobApplyingInfo>, RecordTemplate<JobApplyingInfo>
{
  public static final JobApplyingInfoBuilder BUILDER = JobApplyingInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean applied;
  public final long appliedAt;
  public final long appliedTime;
  public final Urn entityUrn;
  public final boolean hasApplied;
  public final boolean hasAppliedAt;
  public final boolean hasAppliedTime;
  public final boolean hasEntityUrn;
  
  JobApplyingInfo(Urn paramUrn, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    entityUrn = paramUrn;
    applied = paramBoolean1;
    appliedTime = paramLong1;
    appliedAt = paramLong2;
    hasEntityUrn = paramBoolean2;
    hasApplied = paramBoolean3;
    hasAppliedTime = paramBoolean4;
    hasAppliedAt = paramBoolean5;
    UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final JobApplyingInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasApplied)
    {
      paramDataProcessor.startRecordField$505cff1c("applied");
      paramDataProcessor.processBoolean(applied);
    }
    if (hasAppliedTime)
    {
      paramDataProcessor.startRecordField$505cff1c("appliedTime");
      paramDataProcessor.processLong(appliedTime);
    }
    if (hasAppliedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("appliedAt");
      paramDataProcessor.processLong(appliedAt);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasApplied) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo", "applied");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new JobApplyingInfo(entityUrn, applied, appliedTime, appliedAt, hasEntityUrn, hasApplied, hasAppliedTime, hasAppliedAt);
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
      paramObject = (JobApplyingInfo)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (applied != applied) {
        return false;
      }
      if (appliedTime != appliedTime) {
        return false;
      }
    } while (appliedAt == appliedAt);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasApplied) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasAppliedTime) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasAppliedAt) {
      i = j + 8;
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
    if (entityUrn != null) {}
    for (int i = entityUrn.hashCode();; i = 0)
    {
      if (applied) {
        j = 1;
      }
      i = (((i + 527) * 31 + j) * 31 + (int)(appliedTime ^ appliedTime >>> 32)) * 31 + (int)(appliedAt ^ appliedAt >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JobApplyingInfo");
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
    label168:
    label177:
    label201:
    label268:
    label274:
    label284:
    label294:
    label302:
    label304:
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
        localByteBuffer.putInt(1046571988);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasApplied) {
            break label274;
          }
          localByteBuffer.put((byte)1);
          if (!applied) {
            break label268;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasAppliedTime) {
            break label284;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(appliedTime);
          if (!hasAppliedAt) {
            break label294;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(appliedAt);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label302;
          }
          if (str != null) {
            break label304;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label168;
          localByteBuffer.put((byte)0);
          break label177;
          localByteBuffer.put((byte)0);
          break label201;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */