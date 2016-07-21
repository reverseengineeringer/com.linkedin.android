package com.linkedin.android.pegasus.gen.voyager.search.shared;

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

public final class SearchSpellingCorrection
  implements FissileDataModel<SearchSpellingCorrection>, RecordTemplate<SearchSpellingCorrection>
{
  public static final SearchSpellingCorrectionBuilder BUILDER = SearchSpellingCorrectionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasOriginalSearchCount;
  public final boolean hasSpellingCorrectionType;
  public final boolean hasSuggestion;
  public final int originalSearchCount;
  public final SpellingCorrectionType spellingCorrectionType;
  public final String suggestion;
  
  SearchSpellingCorrection(String paramString, SpellingCorrectionType paramSpellingCorrectionType, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    suggestion = paramString;
    spellingCorrectionType = paramSpellingCorrectionType;
    originalSearchCount = paramInt;
    hasSuggestion = paramBoolean1;
    hasSpellingCorrectionType = paramBoolean2;
    hasOriginalSearchCount = paramBoolean3;
    _cachedId = null;
  }
  
  public final SearchSpellingCorrection accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSuggestion)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestion");
      paramDataProcessor.processString(suggestion);
    }
    if (hasSpellingCorrectionType)
    {
      paramDataProcessor.startRecordField$505cff1c("spellingCorrectionType");
      paramDataProcessor.processEnum(spellingCorrectionType);
    }
    if (hasOriginalSearchCount)
    {
      paramDataProcessor.startRecordField$505cff1c("originalSearchCount");
      paramDataProcessor.processInt(originalSearchCount);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasSuggestion) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrection", "suggestion");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasSpellingCorrectionType) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrection", "spellingCorrectionType");
      }
      return new SearchSpellingCorrection(suggestion, spellingCorrectionType, originalSearchCount, hasSuggestion, hasSpellingCorrectionType, hasOriginalSearchCount);
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
      paramObject = (SearchSpellingCorrection)paramObject;
      if (suggestion != null)
      {
        if (suggestion.equals(suggestion)) {}
      }
      else {
        while (suggestion != null) {
          return false;
        }
      }
      if (spellingCorrectionType != null)
      {
        if (spellingCorrectionType.equals(spellingCorrectionType)) {}
      }
      else {
        while (spellingCorrectionType != null) {
          return false;
        }
      }
    } while (originalSearchCount == originalSearchCount);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasSuggestion) {
      i = PegasusBinaryUtils.getEncodedLength(suggestion) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSpellingCorrectionType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasOriginalSearchCount) {
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
    if (suggestion != null) {}
    for (int i = suggestion.hashCode();; i = 0)
    {
      if (spellingCorrectionType != null) {
        j = spellingCorrectionType.hashCode();
      }
      i = ((i + 527) * 31 + j) * 31 + originalSearchCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchSpellingCorrection");
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
    label165:
    label232:
    label242:
    label250:
    label252:
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
        localByteBuffer.putInt(626252773);
        if (hasSuggestion)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, suggestion);
          if (!hasSpellingCorrectionType) {
            break label232;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, spellingCorrectionType.ordinal());
          if (!hasOriginalSearchCount) {
            break label242;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(originalSearchCount);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label250;
          }
          if (str != null) {
            break label252;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.shared.SearchSpellingCorrection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */