package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
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

public class TypeaheadSuggestion
  implements FissileDataModel<TypeaheadSuggestion>, RecordTemplate<TypeaheadSuggestion>
{
  public static final TypeaheadSuggestionBuilder BUILDER = TypeaheadSuggestionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasQuery;
  public final boolean hasSuggestedEntities;
  public final boolean hasType;
  public final SearchQuery query;
  public final List<SuggestedEntity> suggestedEntities;
  public final SearchType type;
  
  TypeaheadSuggestion(SearchType paramSearchType, SearchQuery paramSearchQuery, List<SuggestedEntity> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    type = paramSearchType;
    query = paramSearchQuery;
    if (paramList == null) {}
    for (paramSearchType = null;; paramSearchType = Collections.unmodifiableList(paramList))
    {
      suggestedEntities = paramSearchType;
      hasType = paramBoolean1;
      hasQuery = paramBoolean2;
      hasSuggestedEntities = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final TypeaheadSuggestion accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    int i;
    if (hasQuery)
    {
      paramDataProcessor.startRecordField$505cff1c("query");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = query.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localSuggestedEntity = null;
      bool2 = false;
      if (!hasSuggestedEntities) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("suggestedEntities");
      suggestedEntities.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localSuggestedEntity;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = suggestedEntities.iterator();
      label156:
      if (!localIterator.hasNext()) {
        break label272;
      }
      localSuggestedEntity = (SuggestedEntity)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (SuggestedEntity localSuggestedEntity = localSuggestedEntity.accept(paramDataProcessor);; localSuggestedEntity = (SuggestedEntity)paramDataProcessor.processDataTemplate(localSuggestedEntity))
    {
      if ((localObject1 != null) && (localSuggestedEntity != null)) {
        ((List)localObject1).add(localSuggestedEntity);
      }
      i += 1;
      break label156;
      localObject1 = (SearchQuery)paramDataProcessor.processDataTemplate(query);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
    }
    label272:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label286:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label428;
      }
      try
      {
        if (hasType) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion", "type");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasQuery) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion", "query");
    }
    if (suggestedEntities != null)
    {
      paramDataProcessor = suggestedEntities.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SuggestedEntity)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion", "suggestedEntities");
        }
      }
    }
    return new TypeaheadSuggestion(type, (SearchQuery)localObject2, (List)localObject1, hasType, bool1, bool2);
    label428:
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TypeaheadSuggestion)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (query != null)
      {
        if (query.equals(query)) {}
      }
      else {
        while (query != null) {
          return false;
        }
      }
      if (suggestedEntities == null) {
        break;
      }
    } while (suggestedEntities.equals(suggestedEntities));
    for (;;)
    {
      return false;
      if (suggestedEntities == null) {
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
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    Iterator localIterator;
    if (hasQuery)
    {
      i = j + 1;
      if (query._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(query._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasSuggestedEntities) {
        break label176;
      }
      i += 2;
      localIterator = suggestedEntities.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label176;
      }
      SuggestedEntity localSuggestedEntity = (SuggestedEntity)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += query.getSerializedSize();
        break;
      }
      i += localSuggestedEntity.getSerializedSize();
    }
    label176:
    __sizeOfObject = j;
    return j;
  }
  
  public int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (type != null)
    {
      i = type.hashCode();
      if (query == null) {
        break label89;
      }
    }
    label89:
    for (int j = query.hashCode();; j = 0)
    {
      if (suggestedEntities != null) {
        k = suggestedEntities.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TypeaheadSuggestion");
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
    label199:
    label316:
    label341:
    label374:
    label381:
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
        localByteBuffer.putInt(535944511);
        Iterator localIterator;
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasQuery) {
            break label341;
          }
          localByteBuffer.put((byte)1);
          if (query._cachedId == null) {
            break label316;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, query._cachedId);
          query.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSuggestedEntities) {
            break label374;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, suggestedEntities.size());
          localIterator = suggestedEntities.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label381;
          }
          SuggestedEntity localSuggestedEntity = (SuggestedEntity)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localSuggestedEntity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            query.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label199;
            localByteBuffer.put((byte)0);
            break label199;
          }
          localByteBuffer.put((byte)1);
          localSuggestedEntity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */