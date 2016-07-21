package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchFacetTypeV2
  implements FissileDataModel<SearchFacetTypeV2>, UnionTemplate<SearchFacetTypeV2>
{
  public static final SearchFacetTypeV2Builder BUILDER = SearchFacetTypeV2Builder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasJobSearchFacetTypeValue;
  public final boolean hasPeopleSearchFacetTypeValue;
  public final JobSearchFacetType jobSearchFacetTypeValue;
  public final PeopleSearchFacetType peopleSearchFacetTypeValue;
  
  SearchFacetTypeV2(JobSearchFacetType paramJobSearchFacetType, PeopleSearchFacetType paramPeopleSearchFacetType, boolean paramBoolean1, boolean paramBoolean2)
  {
    jobSearchFacetTypeValue = paramJobSearchFacetType;
    peopleSearchFacetTypeValue = paramPeopleSearchFacetType;
    hasJobSearchFacetTypeValue = paramBoolean1;
    hasPeopleSearchFacetTypeValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final SearchFacetTypeV2 accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    if (hasJobSearchFacetTypeValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.JobSearchFacetType");
      paramDataProcessor.processEnum(jobSearchFacetTypeValue);
    }
    if (hasPeopleSearchFacetTypeValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.PeopleSearchFacetType");
      paramDataProcessor.processEnum(peopleSearchFacetTypeValue);
    }
    paramDataProcessor.endUnion();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new SearchFacetTypeV2(jobSearchFacetTypeValue, peopleSearchFacetTypeValue, hasJobSearchFacetTypeValue, hasPeopleSearchFacetTypeValue);
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
      paramObject = (SearchFacetTypeV2)paramObject;
      if (jobSearchFacetTypeValue != null)
      {
        if (jobSearchFacetTypeValue.equals(jobSearchFacetTypeValue)) {}
      }
      else {
        while (jobSearchFacetTypeValue != null) {
          return false;
        }
      }
      if (peopleSearchFacetTypeValue == null) {
        break;
      }
    } while (peopleSearchFacetTypeValue.equals(peopleSearchFacetTypeValue));
    for (;;)
    {
      return false;
      if (peopleSearchFacetTypeValue == null) {
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
    if (hasJobSearchFacetTypeValue) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasPeopleSearchFacetTypeValue) {
      i = j + 2;
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
    if (jobSearchFacetTypeValue != null) {}
    for (int i = jobSearchFacetTypeValue.hashCode();; i = 0)
    {
      if (peopleSearchFacetTypeValue != null) {
        j = peopleSearchFacetTypeValue.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchFacetTypeV2");
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
    label211:
    label219:
    label221:
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
        localByteBuffer.putInt(1759935903);
        if (hasJobSearchFacetTypeValue)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, jobSearchFacetTypeValue.ordinal());
          if (!hasPeopleSearchFacetTypeValue) {
            break label211;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, peopleSearchFacetTypeValue.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label219;
          }
          if (str != null) {
            break label221;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchFacetTypeV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */