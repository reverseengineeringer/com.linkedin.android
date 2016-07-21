package com.linkedin.android.pegasus.gen.videocontent;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Thumbnail
  implements FissileDataModel<Thumbnail>, RecordTemplate<Thumbnail>
{
  public static final ThumbnailBuilder BUILDER = ThumbnailBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final boolean hasUrl;
  public final String url;
  
  Thumbnail(String paramString, boolean paramBoolean)
  {
    url = paramString;
    hasUrl = paramBoolean;
  }
  
  public final Thumbnail accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new Thumbnail(url, hasUrl);
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
      paramObject = (Thumbnail)paramObject;
      if (url == null) {
        break;
      }
    } while (url.equals(url));
    for (;;)
    {
      return false;
      if (url == null) {
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
    if (hasUrl) {
      i = PegasusBinaryUtils.getEncodedLength(url) + 8;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (url != null) {}
    for (int i = url.hashCode();; i = 0)
    {
      i += 527;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    if ((paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Thumbnail");
    }
    if (paramBoolean) {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
    }
    for (;;)
    {
      return;
      ByteBuffer localByteBuffer = paramByteBuffer;
      if (paramByteBuffer == null) {
        localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
      }
      localByteBuffer.put((byte)1);
      localByteBuffer.putInt(-1673705908);
      if (hasUrl)
      {
        localByteBuffer.put((byte)1);
        paramFissionAdapter.writeString(localByteBuffer, url);
      }
      while (paramByteBuffer == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
        localByteBuffer.put((byte)0);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.videocontent.Thumbnail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */