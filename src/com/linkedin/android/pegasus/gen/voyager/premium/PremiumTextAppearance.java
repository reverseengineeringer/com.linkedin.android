package com.linkedin.android.pegasus.gen.voyager.premium;

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

public final class PremiumTextAppearance
  implements FissileDataModel<PremiumTextAppearance>, RecordTemplate<PremiumTextAppearance>
{
  public static final PremiumTextAppearanceBuilder BUILDER = PremiumTextAppearanceBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String appearance;
  public final boolean hasAppearance;
  public final boolean hasLength;
  public final boolean hasStart;
  public final int length;
  public final int start;
  
  PremiumTextAppearance(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    start = paramInt1;
    length = paramInt2;
    appearance = paramString;
    hasStart = paramBoolean1;
    hasLength = paramBoolean2;
    hasAppearance = paramBoolean3;
    _cachedId = null;
  }
  
  public final PremiumTextAppearance accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStart)
    {
      paramDataProcessor.startRecordField$505cff1c("start");
      paramDataProcessor.processInt(start);
    }
    if (hasLength)
    {
      paramDataProcessor.startRecordField$505cff1c("length");
      paramDataProcessor.processInt(length);
    }
    if (hasAppearance)
    {
      paramDataProcessor.startRecordField$505cff1c("appearance");
      paramDataProcessor.processString(appearance);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasStart) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance", "start");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasLength) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance", "length");
      }
      if (!hasAppearance) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance", "appearance");
      }
      return new PremiumTextAppearance(start, length, appearance, hasStart, hasLength, hasAppearance);
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
      paramObject = (PremiumTextAppearance)paramObject;
      if (start != start) {
        return false;
      }
      if (length != length) {
        return false;
      }
      if (appearance == null) {
        break;
      }
    } while (appearance.equals(appearance));
    for (;;)
    {
      return false;
      if (appearance == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasStart) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasLength) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasAppearance) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(appearance);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int j = start;
    int k = length;
    if (appearance != null) {}
    for (int i = appearance.hashCode();; i = 0)
    {
      i = ((j + 527) * 31 + k) * 31 + i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PremiumTextAppearance");
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
    label227:
    label237:
    label245:
    label247:
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
        localByteBuffer.putInt(966483357);
        if (hasStart)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(start);
          if (!hasLength) {
            break label227;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(length);
          if (!hasAppearance) {
            break label237;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, appearance);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label245;
          }
          if (str != null) {
            break label247;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */