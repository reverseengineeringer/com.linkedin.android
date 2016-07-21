package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class Paywall
  implements FissileDataModel<Paywall>, RecordTemplate<Paywall>
{
  public static final PaywallBuilder BUILDER = PaywallBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLimit;
  public final boolean hasRemainingSearches;
  public final boolean hasSearchVertical;
  public final boolean hasType;
  public final int limit;
  public final int remainingSearches;
  public final SearchType searchVertical;
  public final PaywallType type;
  
  Paywall(PaywallType paramPaywallType, SearchType paramSearchType, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    type = paramPaywallType;
    searchVertical = paramSearchType;
    limit = paramInt1;
    remainingSearches = paramInt2;
    hasType = paramBoolean1;
    hasSearchVertical = paramBoolean2;
    hasLimit = paramBoolean3;
    hasRemainingSearches = paramBoolean4;
    _cachedId = null;
  }
  
  public final Paywall accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    if (hasSearchVertical)
    {
      paramDataProcessor.startRecordField$505cff1c("searchVertical");
      paramDataProcessor.processEnum(searchVertical);
    }
    if (hasLimit)
    {
      paramDataProcessor.startRecordField$505cff1c("limit");
      paramDataProcessor.processInt(limit);
    }
    if (hasRemainingSearches)
    {
      paramDataProcessor.startRecordField$505cff1c("remainingSearches");
      paramDataProcessor.processInt(remainingSearches);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasType) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.Paywall", "type");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new Paywall(type, searchVertical, limit, remainingSearches, hasType, hasSearchVertical, hasLimit, hasRemainingSearches);
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
      paramObject = (Paywall)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (searchVertical != null)
      {
        if (searchVertical.equals(searchVertical)) {}
      }
      else {
        while (searchVertical != null) {
          return false;
        }
      }
      if (limit != limit) {
        return false;
      }
    } while (remainingSearches == remainingSearches);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasSearchVertical) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasLimit) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasRemainingSearches) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (type != null) {}
    for (int i = type.hashCode();; i = 0)
    {
      if (searchVertical != null) {
        j = searchVertical.hashCode();
      }
      i = (((i + 527) * 31 + j) * 31 + limit) * 31 + remainingSearches;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Paywall");
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
    label168:
    label192:
    label259:
    label269:
    label279:
    label287:
    label289:
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
        localByteBuffer.putInt(-1186480116);
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasSearchVertical) {
            break label259;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, searchVertical.ordinal());
          if (!hasLimit) {
            break label269;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(limit);
          if (!hasRemainingSearches) {
            break label279;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(remainingSearches);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label287;
          }
          if (str != null) {
            break label289;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label168;
          localByteBuffer.put((byte)0);
          break label192;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.Paywall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */