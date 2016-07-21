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

public final class MediaProcessorFilters
  implements FissileDataModel<MediaProcessorFilters>, RecordTemplate<MediaProcessorFilters>
{
  public static final MediaProcessorFiltersBuilder BUILDER = MediaProcessorFiltersBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String contain;
  public final String cover;
  public final String fill;
  public final boolean hasContain;
  public final boolean hasCover;
  public final boolean hasFill;
  public final boolean hasOriginal;
  public final String original;
  
  MediaProcessorFilters(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    contain = paramString1;
    cover = paramString2;
    fill = paramString3;
    original = paramString4;
    hasContain = paramBoolean1;
    hasCover = paramBoolean2;
    hasFill = paramBoolean3;
    hasOriginal = paramBoolean4;
    _cachedId = null;
  }
  
  public final MediaProcessorFilters accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasContain)
    {
      paramDataProcessor.startRecordField$505cff1c("contain");
      paramDataProcessor.processString(contain);
    }
    if (hasCover)
    {
      paramDataProcessor.startRecordField$505cff1c("cover");
      paramDataProcessor.processString(cover);
    }
    if (hasFill)
    {
      paramDataProcessor.startRecordField$505cff1c("fill");
      paramDataProcessor.processString(fill);
    }
    if (hasOriginal)
    {
      paramDataProcessor.startRecordField$505cff1c("original");
      paramDataProcessor.processString(original);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasContain) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters", "contain");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCover) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters", "cover");
      }
      if (!hasFill) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters", "fill");
      }
      if (!hasOriginal) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters", "original");
      }
      return new MediaProcessorFilters(contain, cover, fill, original, hasContain, hasCover, hasFill, hasOriginal);
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
      paramObject = (MediaProcessorFilters)paramObject;
      if (contain != null)
      {
        if (contain.equals(contain)) {}
      }
      else {
        while (contain != null) {
          return false;
        }
      }
      if (cover != null)
      {
        if (cover.equals(cover)) {}
      }
      else {
        while (cover != null) {
          return false;
        }
      }
      if (fill != null)
      {
        if (fill.equals(fill)) {}
      }
      else {
        while (fill != null) {
          return false;
        }
      }
      if (original == null) {
        break;
      }
    } while (original.equals(original));
    for (;;)
    {
      return false;
      if (original == null) {
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
    if (hasContain) {
      i = PegasusBinaryUtils.getEncodedLength(contain) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCover) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(cover);
    }
    j = i + 1;
    i = j;
    if (hasFill) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(fill);
    }
    j = i + 1;
    i = j;
    if (hasOriginal) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(original);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (contain != null)
    {
      i = contain.hashCode();
      if (cover == null) {
        break label110;
      }
      j = cover.hashCode();
      label45:
      if (fill == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = fill.hashCode();; k = 0)
    {
      if (original != null) {
        m = original.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MediaProcessorFilters");
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
    label162:
    label188:
    label257:
    label267:
    label277:
    label285:
    label287:
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
        localByteBuffer.putInt(-881796484);
        if (hasContain)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contain);
          if (!hasCover) {
            break label257;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, cover);
          if (!hasFill) {
            break label267;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, fill);
          if (!hasOriginal) {
            break label277;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, original);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label285;
          }
          if (str != null) {
            break label287;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label188;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */