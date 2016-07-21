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

public final class SearchFacet
  implements FissileDataModel<SearchFacet>, RecordTemplate<SearchFacet>
{
  public static final SearchFacetBuilder BUILDER = SearchFacetBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String displayName;
  public final String facetParameterName;
  public final SearchFacetType facetType;
  public final SearchFacetTypeV2 facetTypeV2;
  public final List<SearchFacetValue> facetValues;
  public final boolean hasDisplayName;
  public final boolean hasFacetParameterName;
  public final boolean hasFacetType;
  public final boolean hasFacetTypeV2;
  public final boolean hasFacetValues;
  
  SearchFacet(String paramString1, String paramString2, SearchFacetType paramSearchFacetType, SearchFacetTypeV2 paramSearchFacetTypeV2, List<SearchFacetValue> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    displayName = paramString1;
    facetParameterName = paramString2;
    facetType = paramSearchFacetType;
    facetTypeV2 = paramSearchFacetTypeV2;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      facetValues = paramString1;
      hasDisplayName = paramBoolean1;
      hasFacetParameterName = paramBoolean2;
      hasFacetType = paramBoolean3;
      hasFacetTypeV2 = paramBoolean4;
      hasFacetValues = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final SearchFacet accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasDisplayName)
    {
      paramDataProcessor.startRecordField$505cff1c("displayName");
      paramDataProcessor.processString(displayName);
    }
    if (hasFacetParameterName)
    {
      paramDataProcessor.startRecordField$505cff1c("facetParameterName");
      paramDataProcessor.processString(facetParameterName);
    }
    if (hasFacetType)
    {
      paramDataProcessor.startRecordField$505cff1c("facetType");
      paramDataProcessor.processEnum(facetType);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label131:
    int i;
    if (hasFacetTypeV2)
    {
      paramDataProcessor.startRecordField$505cff1c("facetTypeV2");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = facetTypeV2.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label297;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localSearchFacetValue = null;
      bool2 = false;
      if (!hasFacetValues) {
        break label336;
      }
      paramDataProcessor.startRecordField$505cff1c("facetValues");
      facetValues.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localSearchFacetValue;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = facetValues.iterator();
      label206:
      if (!localIterator.hasNext()) {
        break label322;
      }
      localSearchFacetValue = (SearchFacetValue)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label306;
      }
    }
    label297:
    label306:
    for (SearchFacetValue localSearchFacetValue = localSearchFacetValue.accept(paramDataProcessor);; localSearchFacetValue = (SearchFacetValue)paramDataProcessor.processDataTemplate(localSearchFacetValue))
    {
      if ((localObject1 != null) && (localSearchFacetValue != null)) {
        ((List)localObject1).add(localSearchFacetValue);
      }
      i += 1;
      break label206;
      localObject1 = (SearchFacetTypeV2)paramDataProcessor.processDataTemplate(facetTypeV2);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label131;
    }
    label322:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label336:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label513;
      }
      try
      {
        if (hasDisplayName) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchFacet", "displayName");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasFacetParameterName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchFacet", "facetParameterName");
    }
    if (!hasFacetValues) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchFacet", "facetValues");
    }
    if (facetValues != null)
    {
      paramDataProcessor = facetValues.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchFacetValue)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchFacet", "facetValues");
        }
      }
    }
    return new SearchFacet(displayName, facetParameterName, facetType, (SearchFacetTypeV2)localObject2, (List)localObject1, hasDisplayName, hasFacetParameterName, hasFacetType, bool1, bool2);
    label513:
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
      paramObject = (SearchFacet)paramObject;
      if (displayName != null)
      {
        if (displayName.equals(displayName)) {}
      }
      else {
        while (displayName != null) {
          return false;
        }
      }
      if (facetParameterName != null)
      {
        if (facetParameterName.equals(facetParameterName)) {}
      }
      else {
        while (facetParameterName != null) {
          return false;
        }
      }
      if (facetType != null)
      {
        if (facetType.equals(facetType)) {}
      }
      else {
        while (facetType != null) {
          return false;
        }
      }
      if (facetTypeV2 != null)
      {
        if (facetTypeV2.equals(facetTypeV2)) {}
      }
      else {
        while (facetTypeV2 != null) {
          return false;
        }
      }
      if (facetValues == null) {
        break;
      }
    } while (facetValues.equals(facetValues));
    for (;;)
    {
      return false;
      if (facetValues == null) {
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
    if (hasDisplayName) {
      i = PegasusBinaryUtils.getEncodedLength(displayName) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasFacetParameterName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(facetParameterName);
    }
    j = i + 1;
    i = j;
    if (hasFacetType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    Iterator localIterator;
    if (hasFacetTypeV2)
    {
      i = j + 1;
      if (facetTypeV2._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(facetTypeV2._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasFacetValues) {
        break label223;
      }
      i += 2;
      localIterator = facetValues.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label223;
      }
      SearchFacetValue localSearchFacetValue = (SearchFacetValue)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += facetTypeV2.getSerializedSize();
        break;
      }
      i += localSearchFacetValue.getSerializedSize();
    }
    label223:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (displayName != null)
    {
      i = displayName.hashCode();
      if (facetParameterName == null) {
        break label134;
      }
      j = facetParameterName.hashCode();
      if (facetType == null) {
        break label139;
      }
      k = facetType.hashCode();
      label60:
      if (facetTypeV2 == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = facetTypeV2.hashCode();; m = 0)
    {
      if (facetValues != null) {
        n = facetValues.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchFacet");
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
    label191:
    label251:
    label368:
    label378:
    label388:
    label413:
    label446:
    label453:
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
        localByteBuffer.putInt(541982206);
        Iterator localIterator;
        if (hasDisplayName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayName);
          if (!hasFacetParameterName) {
            break label368;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, facetParameterName);
          if (!hasFacetType) {
            break label378;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, facetType.ordinal());
          if (!hasFacetTypeV2) {
            break label413;
          }
          localByteBuffer.put((byte)1);
          if (facetTypeV2._cachedId == null) {
            break label388;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, facetTypeV2._cachedId);
          facetTypeV2.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFacetValues) {
            break label446;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, facetValues.size());
          localIterator = facetValues.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label453;
          }
          SearchFacetValue localSearchFacetValue = (SearchFacetValue)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localSearchFacetValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label162;
            localByteBuffer.put((byte)0);
            break label191;
            localByteBuffer.put((byte)1);
            facetTypeV2.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label251;
            localByteBuffer.put((byte)0);
            break label251;
          }
          localByteBuffer.put((byte)1);
          localSearchFacetValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchFacet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */