package com.linkedin.android.pegasus.gen.common;

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

public final class Rectangle
  implements FissileDataModel<Rectangle>, RecordTemplate<Rectangle>
{
  public static final RectangleBuilder BUILDER = RectangleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasHeight;
  public final boolean hasWidth;
  public final boolean hasX;
  public final boolean hasY;
  public final int height;
  public final int width;
  public final int x;
  public final int y;
  
  Rectangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    x = paramInt1;
    y = paramInt2;
    width = paramInt3;
    height = paramInt4;
    hasX = paramBoolean1;
    hasY = paramBoolean2;
    hasWidth = paramBoolean3;
    hasHeight = paramBoolean4;
    _cachedId = null;
  }
  
  public final Rectangle accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasX)
    {
      paramDataProcessor.startRecordField$505cff1c("x");
      paramDataProcessor.processInt(x);
    }
    if (hasY)
    {
      paramDataProcessor.startRecordField$505cff1c("y");
      paramDataProcessor.processInt(y);
    }
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
        if (!hasX) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.common.Rectangle", "x");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasY) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.common.Rectangle", "y");
      }
      if (!hasWidth) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.common.Rectangle", "width");
      }
      if (!hasHeight) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.common.Rectangle", "height");
      }
      return new Rectangle(x, y, width, height, hasX, hasY, hasWidth, hasHeight);
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
      paramObject = (Rectangle)paramObject;
      if (x != x) {
        return false;
      }
      if (y != y) {
        return false;
      }
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
    if (hasX) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasY) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
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
    int i = (((x + 527) * 31 + y) * 31 + width) * 31 + height;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Rectangle");
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
    label182:
    label249:
    label259:
    label269:
    label277:
    label279:
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
        localByteBuffer.putInt(1896039813);
        if (hasX)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(x);
          if (!hasY) {
            break label249;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(y);
          if (!hasWidth) {
            break label259;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(width);
          if (!hasHeight) {
            break label269;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(height);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label277;
          }
          if (str != null) {
            break label279;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label158;
          localByteBuffer.put((byte)0);
          break label182;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.Rectangle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */