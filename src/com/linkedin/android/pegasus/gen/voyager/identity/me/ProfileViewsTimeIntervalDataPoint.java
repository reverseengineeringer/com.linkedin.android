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

public final class ProfileViewsTimeIntervalDataPoint
  implements FissileDataModel<ProfileViewsTimeIntervalDataPoint>, RecordTemplate<ProfileViewsTimeIntervalDataPoint>
{
  public static final ProfileViewsTimeIntervalDataPointBuilder BUILDER = ProfileViewsTimeIntervalDataPointBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long endTimestamp;
  public final boolean hasEndTimestamp;
  public final boolean hasNumViews;
  public final long numViews;
  
  ProfileViewsTimeIntervalDataPoint(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    endTimestamp = paramLong1;
    numViews = paramLong2;
    hasEndTimestamp = paramBoolean1;
    hasNumViews = paramBoolean2;
    _cachedId = null;
  }
  
  public final ProfileViewsTimeIntervalDataPoint accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEndTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("endTimestamp");
      paramDataProcessor.processLong(endTimestamp);
    }
    if (hasNumViews)
    {
      paramDataProcessor.startRecordField$505cff1c("numViews");
      paramDataProcessor.processLong(numViews);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEndTimestamp) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsTimeIntervalDataPoint", "endTimestamp");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasNumViews) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsTimeIntervalDataPoint", "numViews");
      }
      return new ProfileViewsTimeIntervalDataPoint(endTimestamp, numViews, hasEndTimestamp, hasNumViews);
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
      paramObject = (ProfileViewsTimeIntervalDataPoint)paramObject;
      if (endTimestamp != endTimestamp) {
        return false;
      }
    } while (numViews == numViews);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasEndTimestamp) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasNumViews) {
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
    int i = ((int)(endTimestamp ^ endTimestamp >>> 32) + 527) * 31 + (int)(numViews ^ numViews >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileViewsTimeIntervalDataPoint");
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
    label201:
    label209:
    label211:
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
        localByteBuffer.putInt(-1032769998);
        if (hasEndTimestamp)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(endTimestamp);
          if (!hasNumViews) {
            break label201;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViews);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label209;
          }
          if (str != null) {
            break label211;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsTimeIntervalDataPoint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */