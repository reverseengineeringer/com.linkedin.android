package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHistoryTrendingResult$ContextEntity
  implements FissileDataModel<ContextEntity>, UnionTemplate<ContextEntity>
{
  public static final SearchHistoryTrendingResultBuilder.ContextEntityBuilder BUILDER = SearchHistoryTrendingResultBuilder.ContextEntityBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasMiniCompanyUrnValue;
  public final Urn miniCompanyUrnValue;
  
  SearchHistoryTrendingResult$ContextEntity(Urn paramUrn, boolean paramBoolean)
  {
    miniCompanyUrnValue = paramUrn;
    hasMiniCompanyUrnValue = paramBoolean;
    _cachedId = null;
  }
  
  public final ContextEntity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    if (hasMiniCompanyUrnValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("string");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(miniCompanyUrnValue));
    }
    paramDataProcessor.endUnion();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new ContextEntity(miniCompanyUrnValue, hasMiniCompanyUrnValue);
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
      paramObject = (ContextEntity)paramObject;
      if (miniCompanyUrnValue == null) {
        break;
      }
    } while (miniCompanyUrnValue.equals(miniCompanyUrnValue));
    for (;;)
    {
      return false;
      if (miniCompanyUrnValue == null) {
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
    if (hasMiniCompanyUrnValue)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(miniCompanyUrnValue)) + 8;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (miniCompanyUrnValue != null) {}
    for (int i = miniCompanyUrnValue.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ContextEntity");
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
    label187:
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
        localByteBuffer.putInt(-17675516);
        if (hasMiniCompanyUrnValue)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(miniCompanyUrnValue));
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label187;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResult.ContextEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */