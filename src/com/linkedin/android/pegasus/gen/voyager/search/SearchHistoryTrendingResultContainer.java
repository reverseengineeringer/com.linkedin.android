package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SearchHistoryTrendingResultContainer
  implements FissileDataModel<SearchHistoryTrendingResultContainer>, RecordTemplate<SearchHistoryTrendingResultContainer>
{
  public static final SearchHistoryTrendingResultContainerBuilder BUILDER = SearchHistoryTrendingResultContainerBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasTrendingResults;
  public final List<SearchHistoryTrendingResult> trendingResults;
  
  SearchHistoryTrendingResultContainer(List<SearchHistoryTrendingResult> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      trendingResults = paramList;
      hasTrendingResults = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final SearchHistoryTrendingResultContainer accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    SearchHistoryTrendingResult localSearchHistoryTrendingResult = null;
    boolean bool = false;
    if (hasTrendingResults)
    {
      paramDataProcessor.startRecordField$505cff1c("trendingResults");
      trendingResults.size();
      paramDataProcessor.startArray$13462e();
      localObject = localSearchHistoryTrendingResult;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = trendingResults.iterator();
      if (localIterator.hasNext())
      {
        localSearchHistoryTrendingResult = (SearchHistoryTrendingResult)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localSearchHistoryTrendingResult = localSearchHistoryTrendingResult.accept(paramDataProcessor);; localSearchHistoryTrendingResult = (SearchHistoryTrendingResult)paramDataProcessor.processDataTemplate(localSearchHistoryTrendingResult))
        {
          if ((localObject != null) && (localSearchHistoryTrendingResult != null)) {
            ((List)localObject).add(localSearchHistoryTrendingResult);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label226;
      }
    }
    label226:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label292;
      }
      try
      {
        if (hasTrendingResults) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResultContainer", "trendingResults");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (trendingResults != null)
    {
      paramDataProcessor = trendingResults.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchHistoryTrendingResult)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResultContainer", "trendingResults");
        }
      }
    }
    return new SearchHistoryTrendingResultContainer((List)localObject, bool);
    label292:
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
      paramObject = (SearchHistoryTrendingResultContainer)paramObject;
      if (trendingResults == null) {
        break;
      }
    } while (trendingResults.equals(trendingResults));
    for (;;)
    {
      return false;
      if (trendingResults == null) {
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
    int j = i;
    if (hasTrendingResults)
    {
      i += 2;
      Iterator localIterator = trendingResults.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        SearchHistoryTrendingResult localSearchHistoryTrendingResult = (SearchHistoryTrendingResult)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localSearchHistoryTrendingResult.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (trendingResults != null) {}
    for (int i = trendingResults.hashCode();; i = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchHistoryTrendingResultContainer");
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
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1594582982);
        if (hasTrendingResults)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, trendingResults.size());
          Iterator localIterator = trendingResults.iterator();
          while (localIterator.hasNext())
          {
            SearchHistoryTrendingResult localSearchHistoryTrendingResult = (SearchHistoryTrendingResult)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localSearchHistoryTrendingResult.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localSearchHistoryTrendingResult.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryTrendingResultContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */