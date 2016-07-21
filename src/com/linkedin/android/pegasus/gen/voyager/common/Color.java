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

public final class Color
  implements FissileDataModel<Color>, RecordTemplate<Color>
{
  public static final ColorBuilder BUILDER = ColorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final int alpha;
  public final int blue;
  public final int green;
  public final boolean hasAlpha;
  public final boolean hasBlue;
  public final boolean hasGreen;
  public final boolean hasRed;
  public final int red;
  
  Color(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    red = paramInt1;
    green = paramInt2;
    blue = paramInt3;
    alpha = paramInt4;
    hasRed = paramBoolean1;
    hasGreen = paramBoolean2;
    hasBlue = paramBoolean3;
    hasAlpha = paramBoolean4;
    _cachedId = null;
  }
  
  public final Color accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasRed)
    {
      paramDataProcessor.startRecordField$505cff1c("red");
      paramDataProcessor.processInt(red);
    }
    if (hasGreen)
    {
      paramDataProcessor.startRecordField$505cff1c("green");
      paramDataProcessor.processInt(green);
    }
    if (hasBlue)
    {
      paramDataProcessor.startRecordField$505cff1c("blue");
      paramDataProcessor.processInt(blue);
    }
    if (hasAlpha)
    {
      paramDataProcessor.startRecordField$505cff1c("alpha");
      paramDataProcessor.processInt(alpha);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasRed) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Color", "red");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasGreen) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Color", "green");
      }
      if (!hasBlue) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Color", "blue");
      }
      if (!hasAlpha) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Color", "alpha");
      }
      return new Color(red, green, blue, alpha, hasRed, hasGreen, hasBlue, hasAlpha);
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
      paramObject = (Color)paramObject;
      if (red != red) {
        return false;
      }
      if (green != green) {
        return false;
      }
      if (blue != blue) {
        return false;
      }
    } while (alpha == alpha);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasRed) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasGreen) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasBlue) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasAlpha) {
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
    int i = (((red + 527) * 31 + green) * 31 + blue) * 31 + alpha;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Color");
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
        localByteBuffer.putInt(1809173179);
        if (hasRed)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(red);
          if (!hasGreen) {
            break label249;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(green);
          if (!hasBlue) {
            break label259;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(blue);
          if (!hasAlpha) {
            break label269;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(alpha);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Color
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */