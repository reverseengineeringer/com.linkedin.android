package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class MediaProcessorSize
  implements FissileDataModel<MediaProcessorSize>, RecordTemplate<MediaProcessorSize>
{
  public static final MediaProcessorSizeBuilder BUILDER = MediaProcessorSizeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasHeight;
  public final boolean hasWidth;
  public final int height;
  public final int width;
  
  MediaProcessorSize(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    width = paramInt1;
    height = paramInt2;
    hasWidth = paramBoolean1;
    hasHeight = paramBoolean2;
    _cachedId = null;
  }
  
  public final MediaProcessorSize accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasWidth)
    {
      paramDataProcessor.startRecordField$505cff1c("width");
      paramDataProcessor.processInt(width);
    }
    if (hasHeight)
    {
      paramDataProcessor.startRecordField$505cff1c("height");
      paramDataProcessor.processInt(height);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasWidth) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize", "width");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasHeight) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize", "height");
      }
      return new MediaProcessorSize(width, height, hasWidth, hasHeight);
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
      paramObject = (MediaProcessorSize)paramObject;
      if (width != width) {
        return false;
      }
    } while (height == height);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasWidth) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasHeight) {
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
    int i = (width + 527) * 31 + height;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MediaProcessorSize");
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
        localByteBuffer.putInt(1467209000);
        if (hasWidth)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(width);
          if (!hasHeight) {
            break label201;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(height);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */