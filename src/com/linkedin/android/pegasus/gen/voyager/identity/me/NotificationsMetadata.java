package com.linkedin.android.pegasus.gen.voyager.identity.me;

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

public final class NotificationsMetadata
  implements FissileDataModel<NotificationsMetadata>, RecordTemplate<NotificationsMetadata>
{
  public static final NotificationsMetadataBuilder BUILDER = NotificationsMetadataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasLatestPublishedAt;
  public final boolean hasNextStart;
  public final boolean hasNumUnseen;
  public final long latestPublishedAt;
  public final int nextStart;
  public final long numUnseen;
  
  NotificationsMetadata(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    numUnseen = paramLong1;
    latestPublishedAt = paramLong2;
    nextStart = paramInt;
    hasNumUnseen = paramBoolean1;
    hasLatestPublishedAt = paramBoolean2;
    hasNextStart = paramBoolean3;
    _cachedId = null;
  }
  
  private NotificationsMetadata accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumUnseen)
    {
      paramDataProcessor.startRecordField$505cff1c("numUnseen");
      paramDataProcessor.processLong(numUnseen);
    }
    if (hasLatestPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("latestPublishedAt");
      paramDataProcessor.processLong(latestPublishedAt);
    }
    if (hasNextStart)
    {
      paramDataProcessor.startRecordField$505cff1c("nextStart");
      paramDataProcessor.processInt(nextStart);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumUnseen) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.NotificationsMetadata", "numUnseen");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new NotificationsMetadata(numUnseen, latestPublishedAt, nextStart, hasNumUnseen, hasLatestPublishedAt, hasNextStart);
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
      paramObject = (NotificationsMetadata)paramObject;
      if (numUnseen != numUnseen) {
        return false;
      }
      if (latestPublishedAt != latestPublishedAt) {
        return false;
      }
    } while (nextStart == nextStart);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasNumUnseen) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasLatestPublishedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasNextStart) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i = (((int)(numUnseen ^ numUnseen >>> 32) + 527) * 31 + (int)(latestPublishedAt ^ latestPublishedAt >>> 32)) * 31 + nextStart;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NotificationsMetadata");
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
        localByteBuffer.putInt(1449783779);
        if (hasNumUnseen)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numUnseen);
          if (!hasLatestPublishedAt) {
            break label225;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(latestPublishedAt);
          if (!hasNextStart) {
            break label235;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(nextStart);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.NotificationsMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */