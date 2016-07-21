package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CompanyRanking
  implements FissileDataModel<CompanyRanking>, RecordTemplate<CompanyRanking>
{
  public static final CompanyRankingBuilder BUILDER = CompanyRankingBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long count;
  public final boolean hasCount;
  public final boolean hasMiniCompany;
  public final boolean hasRank;
  public final boolean hasViewerFromCompany;
  public final MiniCompany miniCompany;
  public final int rank;
  public final boolean viewerFromCompany;
  
  CompanyRanking(MiniCompany paramMiniCompany, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    miniCompany = paramMiniCompany;
    count = paramLong;
    rank = paramInt;
    viewerFromCompany = paramBoolean1;
    hasMiniCompany = paramBoolean2;
    hasCount = paramBoolean3;
    hasRank = paramBoolean4;
    hasViewerFromCompany = paramBoolean5;
    _cachedId = null;
  }
  
  public final CompanyRanking accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniCompany localMiniCompany = null;
    boolean bool = false;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label168;
      }
      localMiniCompany = miniCompany.accept(paramDataProcessor);
      if (localMiniCompany == null) {
        break label185;
      }
    }
    label168:
    label185:
    for (bool = true;; bool = false)
    {
      if (hasCount)
      {
        paramDataProcessor.startRecordField$505cff1c("count");
        paramDataProcessor.processLong(count);
      }
      if (hasRank)
      {
        paramDataProcessor.startRecordField$505cff1c("rank");
        paramDataProcessor.processInt(rank);
      }
      if (hasViewerFromCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("viewerFromCompany");
        paramDataProcessor.processBoolean(viewerFromCompany);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label281;
      }
      try
      {
        if (hasMiniCompany) {
          break label190;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking", "miniCompany");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniCompany = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break;
    }
    label190:
    if (!hasCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking", "count");
    }
    if (!hasRank) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking", "rank");
    }
    if (!hasViewerFromCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking", "viewerFromCompany");
    }
    return new CompanyRanking(localMiniCompany, count, rank, viewerFromCompany, bool, hasCount, hasRank, hasViewerFromCompany);
    label281:
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
      paramObject = (CompanyRanking)paramObject;
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
          return false;
        }
      }
      if (count != count) {
        return false;
      }
      if (rank != rank) {
        return false;
      }
    } while (viewerFromCompany == viewerFromCompany);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasMiniCompany) {
      if (miniCompany._cachedId == null) {
        break label110;
      }
    }
    label110:
    for (i = PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId) + 9;; i = miniCompany.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasCount) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasRank) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasViewerFromCompany) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (miniCompany != null) {}
    for (int i = miniCompany.hashCode();; i = 0)
    {
      int k = (int)(count ^ count >>> 32);
      int m = rank;
      if (viewerFromCompany) {
        j = 1;
      }
      i = (((i + 527) * 31 + k) * 31 + m) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CompanyRanking");
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
    label218:
    label242:
    label319:
    label329:
    label339:
    label345:
    label353:
    label355:
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
        localByteBuffer.putInt(-69884295);
        if (hasMiniCompany)
        {
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
            miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCount) {
              break label319;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putLong(count);
            if (!hasRank) {
              break label329;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(rank);
            if (!hasViewerFromCompany) {
              break label345;
            }
            localByteBuffer.put((byte)1);
            if (!viewerFromCompany) {
              break label339;
            }
            i = 1;
            localByteBuffer.put((byte)i);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label353;
          }
          if (str != null) {
            break label355;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label194;
          localByteBuffer.put((byte)0);
          break label218;
          i = 0;
          break label242;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */