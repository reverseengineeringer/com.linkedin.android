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

public final class WvmpAnonymousProfileViewCard
  implements FissileDataModel<WvmpAnonymousProfileViewCard>, RecordTemplate<WvmpAnonymousProfileViewCard>
{
  public static final WvmpAnonymousProfileViewCardBuilder BUILDER = WvmpAnonymousProfileViewCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasNumViewers;
  public final boolean hasViewedAt;
  public final long numViewers;
  public final long viewedAt;
  
  WvmpAnonymousProfileViewCard(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    viewedAt = paramLong1;
    numViewers = paramLong2;
    hasViewedAt = paramBoolean1;
    hasNumViewers = paramBoolean2;
    _cachedId = null;
  }
  
  public final WvmpAnonymousProfileViewCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasViewedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("viewedAt");
      paramDataProcessor.processLong(viewedAt);
    }
    if (hasNumViewers)
    {
      paramDataProcessor.startRecordField$505cff1c("numViewers");
      paramDataProcessor.processLong(numViewers);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasViewedAt) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpAnonymousProfileViewCard", "viewedAt");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasNumViewers) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpAnonymousProfileViewCard", "numViewers");
      }
      return new WvmpAnonymousProfileViewCard(viewedAt, numViewers, hasViewedAt, hasNumViewers);
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
      paramObject = (WvmpAnonymousProfileViewCard)paramObject;
      if (viewedAt != viewedAt) {
        return false;
      }
    } while (numViewers == numViewers);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasViewedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasNumViewers) {
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
    int i = ((int)(viewedAt ^ viewedAt >>> 32) + 527) * 31 + (int)(numViewers ^ numViewers >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpAnonymousProfileViewCard");
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
        localByteBuffer.putInt(1059457040);
        if (hasViewedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(viewedAt);
          if (!hasNumViewers) {
            break label201;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViewers);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpAnonymousProfileViewCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */