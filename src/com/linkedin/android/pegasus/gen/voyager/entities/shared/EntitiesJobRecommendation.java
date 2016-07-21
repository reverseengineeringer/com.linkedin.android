package com.linkedin.android.pegasus.gen.voyager.entities.shared;

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

public final class EntitiesJobRecommendation
  implements FissileDataModel<EntitiesJobRecommendation>, RecordTemplate<EntitiesJobRecommendation>
{
  public static final EntitiesJobRecommendationBuilder BUILDER = EntitiesJobRecommendationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final long createdAt;
  public final boolean hasCreatedAt;
  public final boolean hasJobUrl;
  public final boolean hasMiniJob;
  public final String jobUrl;
  public final MiniJob miniJob;
  
  EntitiesJobRecommendation(long paramLong, MiniJob paramMiniJob, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    createdAt = paramLong;
    miniJob = paramMiniJob;
    jobUrl = paramString;
    hasCreatedAt = paramBoolean1;
    hasMiniJob = paramBoolean2;
    hasJobUrl = paramBoolean3;
    _cachedId = null;
  }
  
  public final EntitiesJobRecommendation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCreatedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("createdAt");
      paramDataProcessor.processLong(createdAt);
    }
    MiniJob localMiniJob = null;
    boolean bool = false;
    if (hasMiniJob)
    {
      paramDataProcessor.startRecordField$505cff1c("miniJob");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localMiniJob = miniJob.accept(paramDataProcessor);
      if (localMiniJob == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      if (hasJobUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("jobUrl");
        paramDataProcessor.processString(jobUrl);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasCreatedAt) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation", "createdAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniJob = (MiniJob)paramDataProcessor.processDataTemplate(miniJob);
      break;
    }
    label165:
    if (!hasMiniJob) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation", "miniJob");
    }
    return new EntitiesJobRecommendation(createdAt, localMiniJob, jobUrl, hasCreatedAt, bool, hasJobUrl);
    label210:
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
      paramObject = (EntitiesJobRecommendation)paramObject;
      if (createdAt != createdAt) {
        return false;
      }
      if (miniJob != null)
      {
        if (miniJob.equals(miniJob)) {}
      }
      else {
        while (miniJob != null) {
          return false;
        }
      }
      if (jobUrl == null) {
        break;
      }
    } while (jobUrl.equals(jobUrl));
    for (;;)
    {
      return false;
      if (jobUrl == null) {
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
    if (hasCreatedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasMiniJob)
    {
      i = j + 1;
      if (miniJob._cachedId == null) {
        break label108;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniJob._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasJobUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(jobUrl);
      }
      __sizeOfObject = i;
      return i;
      label108:
      i += miniJob.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int k = (int)(createdAt ^ createdAt >>> 32);
    if (miniJob != null) {}
    for (int i = miniJob.hashCode();; i = 0)
    {
      if (jobUrl != null) {
        j = jobUrl.hashCode();
      }
      i = (i + (k + 527) * 31) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EntitiesJobRecommendation");
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
    label194:
    label263:
    label288:
    label298:
    label306:
    label308:
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
        localByteBuffer.putInt(750881252);
        if (hasCreatedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdAt);
          if (!hasMiniJob) {
            break label288;
          }
          localByteBuffer.put((byte)1);
          if (miniJob._cachedId == null) {
            break label263;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniJob._cachedId);
          miniJob.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasJobUrl) {
            break label298;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, jobUrl);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label306;
          }
          if (str != null) {
            break label308;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniJob.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label194;
          localByteBuffer.put((byte)0);
          break label194;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */