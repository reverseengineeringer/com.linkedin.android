package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.typeahead.SuggestedEntity;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class EntityAwareSearchQuery
  implements FissileDataModel<EntityAwareSearchQuery>, RecordTemplate<EntityAwareSearchQuery>
{
  public static final EntityAwareSearchQueryBuilder BUILDER = EntityAwareSearchQueryBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasQuery;
  public final boolean hasSuggestedEntities;
  public final SearchQuery query;
  public final List<SuggestedEntity> suggestedEntities;
  
  EntityAwareSearchQuery(SearchQuery paramSearchQuery, List<SuggestedEntity> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    query = paramSearchQuery;
    if (paramList == null) {}
    for (paramSearchQuery = null;; paramSearchQuery = Collections.unmodifiableList(paramList))
    {
      suggestedEntities = paramSearchQuery;
      hasQuery = paramBoolean1;
      hasSuggestedEntities = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final EntityAwareSearchQuery accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasQuery)
    {
      paramDataProcessor.startRecordField$505cff1c("query");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = query.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
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
        break label261;
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
      label131:
      if (!localIterator.hasNext()) {
        break label247;
      }
      localSuggestedEntity = (SuggestedEntity)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (SuggestedEntity localSuggestedEntity = localSuggestedEntity.accept(paramDataProcessor);; localSuggestedEntity = (SuggestedEntity)paramDataProcessor.processDataTemplate(localSuggestedEntity))
    {
      if ((localObject1 != null) && (localSuggestedEntity != null)) {
        ((List)localObject1).add(localSuggestedEntity);
      }
      i += 1;
      break label131;
      localObject1 = (SearchQuery)paramDataProcessor.processDataTemplate(query);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label261:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label395;
      }
      try
      {
        if (hasQuery) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "query");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasSuggestedEntities) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "suggestedEntities");
    }
    if (suggestedEntities != null)
    {
      paramDataProcessor = suggestedEntities.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SuggestedEntity)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "suggestedEntities");
        }
      }
    }
    return new EntityAwareSearchQuery((SearchQuery)localObject2, (List)localObject1, bool1, bool2);
    label395:
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
      paramObject = (EntityAwareSearchQuery)paramObject;
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
    int i = 0 + 1 + 4 + 1;
    int j;
    Iterator localIterator;
    if (hasQuery)
    {
      if (query._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(query._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasSuggestedEntities) {
        break label153;
      }
      i += 2;
      localIterator = suggestedEntities.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      SuggestedEntity localSuggestedEntity = (SuggestedEntity)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = query.getSerializedSize() + 7;
        break;
      }
      i += localSuggestedEntity.getSerializedSize();
    }
    label153:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (query != null) {}
    for (int i = query.hashCode();; i = 0)
    {
      if (suggestedEntities != null) {
        j = suggestedEntities.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EntityAwareSearchQuery");
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
    label335:
    label342:
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
        localByteBuffer.putInt(314355863);
        Iterator localIterator;
        if (hasQuery)
        {
          localByteBuffer.put((byte)1);
          if (query._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, query._cachedId);
            query.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSuggestedEntities) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, suggestedEntities.size());
            localIterator = suggestedEntities.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          SuggestedEntity localSuggestedEntity = (SuggestedEntity)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localSuggestedEntity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            query.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<EntityAwareSearchQuery>
  {
    public boolean hasQuery = false;
    public boolean hasSuggestedEntities = false;
    public SearchQuery query = null;
    public List<SuggestedEntity> suggestedEntities = null;
    
    public final EntityAwareSearchQuery build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (EntityAwareSearchQuery.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (suggestedEntities != null)
      {
        paramFlavor = suggestedEntities.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((SuggestedEntity)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "suggestedEntities");
              if (!hasQuery) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "query");
              }
              if (hasSuggestedEntities) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "suggestedEntities");
            }
          }
        }
      }
      return new EntityAwareSearchQuery(query, suggestedEntities, hasQuery, hasSuggestedEntities);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */