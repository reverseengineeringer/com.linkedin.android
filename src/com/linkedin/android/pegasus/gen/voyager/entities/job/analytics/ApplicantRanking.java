package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

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

public final class ApplicantRanking
  implements FissileDataModel<ApplicantRanking>, RecordTemplate<ApplicantRanking>
{
  public static final ApplicantRankingBuilder BUILDER = ApplicantRankingBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasNumberOfApplicants;
  public final boolean hasPercentileRank;
  public final boolean hasRank;
  public final long numberOfApplicants;
  public final int percentileRank;
  public final int rank;
  
  ApplicantRanking(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    rank = paramInt1;
    percentileRank = paramInt2;
    numberOfApplicants = paramLong;
    hasRank = paramBoolean1;
    hasPercentileRank = paramBoolean2;
    hasNumberOfApplicants = paramBoolean3;
    _cachedId = null;
  }
  
  public final ApplicantRanking accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasRank)
    {
      paramDataProcessor.startRecordField$505cff1c("rank");
      paramDataProcessor.processInt(rank);
    }
    if (hasPercentileRank)
    {
      paramDataProcessor.startRecordField$505cff1c("percentileRank");
      paramDataProcessor.processInt(percentileRank);
    }
    if (hasNumberOfApplicants)
    {
      paramDataProcessor.startRecordField$505cff1c("numberOfApplicants");
      paramDataProcessor.processLong(numberOfApplicants);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumberOfApplicants) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.ApplicantRanking", "numberOfApplicants");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new ApplicantRanking(rank, percentileRank, numberOfApplicants, hasRank, hasPercentileRank, hasNumberOfApplicants);
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
      paramObject = (ApplicantRanking)paramObject;
      if (rank != rank) {
        return false;
      }
      if (percentileRank != percentileRank) {
        return false;
      }
    } while (numberOfApplicants == numberOfApplicants);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasRank) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasPercentileRank) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasNumberOfApplicants) {
      i = j + 8;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i = ((rank + 527) * 31 + percentileRank) * 31 + (int)(numberOfApplicants ^ numberOfApplicants >>> 32);
    _cachedHashCode = i;
    return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ApplicantRanking");
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
    label225:
    label235:
    label243:
    label245:
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
        localByteBuffer.putInt(2126266683);
        if (hasRank)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(rank);
          if (!hasPercentileRank) {
            break label225;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(percentileRank);
          if (!hasNumberOfApplicants) {
            break label235;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numberOfApplicants);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label243;
          }
          if (str != null) {
            break label245;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label158;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.ApplicantRanking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */