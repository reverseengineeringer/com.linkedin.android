package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SchoolRanking
  implements FissileDataModel<SchoolRanking>, RecordTemplate<SchoolRanking>
{
  public static final SchoolRankingBuilder BUILDER = SchoolRankingBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long count;
  public final boolean hasCount;
  public final boolean hasMiniSchool;
  public final boolean hasRank;
  public final boolean hasViewerFromSchool;
  public final MiniSchool miniSchool;
  public final int rank;
  public final boolean viewerFromSchool;
  
  SchoolRanking(MiniSchool paramMiniSchool, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    miniSchool = paramMiniSchool;
    count = paramLong;
    rank = paramInt;
    viewerFromSchool = paramBoolean1;
    hasMiniSchool = paramBoolean2;
    hasCount = paramBoolean3;
    hasRank = paramBoolean4;
    hasViewerFromSchool = paramBoolean5;
    _cachedId = null;
  }
  
  public final SchoolRanking accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniSchool localMiniSchool = null;
    boolean bool = false;
    if (hasMiniSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("miniSchool");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label168;
      }
      localMiniSchool = miniSchool.accept(paramDataProcessor);
      if (localMiniSchool == null) {
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
      if (hasViewerFromSchool)
      {
        paramDataProcessor.startRecordField$505cff1c("viewerFromSchool");
        paramDataProcessor.processBoolean(viewerFromSchool);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label281;
      }
      try
      {
        if (hasMiniSchool) {
          break label190;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking", "miniSchool");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniSchool = (MiniSchool)paramDataProcessor.processDataTemplate(miniSchool);
      break;
    }
    label190:
    if (!hasCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking", "count");
    }
    if (!hasRank) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking", "rank");
    }
    if (!hasViewerFromSchool) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking", "viewerFromSchool");
    }
    return new SchoolRanking(localMiniSchool, count, rank, viewerFromSchool, bool, hasCount, hasRank, hasViewerFromSchool);
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
      paramObject = (SchoolRanking)paramObject;
      if (miniSchool != null)
      {
        if (miniSchool.equals(miniSchool)) {}
      }
      else {
        while (miniSchool != null) {
          return false;
        }
      }
      if (count != count) {
        return false;
      }
      if (rank != rank) {
        return false;
      }
    } while (viewerFromSchool == viewerFromSchool);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasMiniSchool) {
      if (miniSchool._cachedId == null) {
        break label110;
      }
    }
    label110:
    for (i = PegasusBinaryUtils.getEncodedLength(miniSchool._cachedId) + 9;; i = miniSchool.getSerializedSize() + 7)
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
      if (hasViewerFromSchool) {
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
    if (miniSchool != null) {}
    for (int i = miniSchool.hashCode();; i = 0)
    {
      int k = (int)(count ^ count >>> 32);
      int m = rank;
      if (viewerFromSchool) {
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SchoolRanking");
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
        localByteBuffer.putInt(2142228839);
        if (hasMiniSchool)
        {
          localByteBuffer.put((byte)1);
          if (miniSchool._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniSchool._cachedId);
            miniSchool.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            if (!hasViewerFromSchool) {
              break label345;
            }
            localByteBuffer.put((byte)1);
            if (!viewerFromSchool) {
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
          miniSchool.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */