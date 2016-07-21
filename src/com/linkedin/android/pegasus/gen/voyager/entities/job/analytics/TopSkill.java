package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TopSkill
  implements FissileDataModel<TopSkill>, RecordTemplate<TopSkill>
{
  public static final TopSkillBuilder BUILDER = TopSkillBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long count;
  public final boolean hasCount;
  public final boolean hasMiniSkill;
  public final boolean hasSharedSkill;
  public final MiniSkill miniSkill;
  public final boolean sharedSkill;
  
  TopSkill(MiniSkill paramMiniSkill, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    miniSkill = paramMiniSkill;
    count = paramLong;
    sharedSkill = paramBoolean1;
    hasMiniSkill = paramBoolean2;
    hasCount = paramBoolean3;
    hasSharedSkill = paramBoolean4;
    _cachedId = null;
  }
  
  public final TopSkill accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniSkill localMiniSkill = null;
    boolean bool = false;
    if (hasMiniSkill)
    {
      paramDataProcessor.startRecordField$505cff1c("miniSkill");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localMiniSkill = miniSkill.accept(paramDataProcessor);
      if (localMiniSkill == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      if (hasCount)
      {
        paramDataProcessor.startRecordField$505cff1c("count");
        paramDataProcessor.processLong(count);
      }
      if (hasSharedSkill)
      {
        paramDataProcessor.startRecordField$505cff1c("sharedSkill");
        paramDataProcessor.processBoolean(sharedSkill);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label229;
      }
      try
      {
        if (hasMiniSkill) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill", "miniSkill");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniSkill = (MiniSkill)paramDataProcessor.processDataTemplate(miniSkill);
      break;
    }
    label165:
    if (!hasCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill", "count");
    }
    if (!hasSharedSkill) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill", "sharedSkill");
    }
    return new TopSkill(localMiniSkill, count, sharedSkill, bool, hasCount, hasSharedSkill);
    label229:
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
      paramObject = (TopSkill)paramObject;
      if (miniSkill != null)
      {
        if (miniSkill.equals(miniSkill)) {}
      }
      else {
        while (miniSkill != null) {
          return false;
        }
      }
      if (count != count) {
        return false;
      }
    } while (sharedSkill == sharedSkill);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasMiniSkill) {
      if (miniSkill._cachedId == null) {
        break label93;
      }
    }
    label93:
    for (i = PegasusBinaryUtils.getEncodedLength(miniSkill._cachedId) + 9;; i = miniSkill.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasCount) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasSharedSkill) {
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
    if (miniSkill != null) {}
    for (int i = miniSkill.hashCode();; i = 0)
    {
      int k = (int)(count ^ count >>> 32);
      if (sharedSkill) {
        j = 1;
      }
      i = ((i + 527) * 31 + k) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TopSkill");
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
    label295:
    label305:
    label311:
    label319:
    label321:
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
        localByteBuffer.putInt(-1223433540);
        if (hasMiniSkill)
        {
          localByteBuffer.put((byte)1);
          if (miniSkill._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniSkill._cachedId);
            miniSkill.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCount) {
              break label295;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putLong(count);
            if (!hasSharedSkill) {
              break label311;
            }
            localByteBuffer.put((byte)1);
            if (!sharedSkill) {
              break label305;
            }
            i = 1;
            localByteBuffer.put((byte)i);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label319;
          }
          if (str != null) {
            break label321;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniSkill.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label194;
          i = 0;
          break label218;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */