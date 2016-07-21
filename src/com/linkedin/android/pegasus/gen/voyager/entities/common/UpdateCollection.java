package com.linkedin.android.pegasus.gen.voyager.entities.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class UpdateCollection
  implements FissileDataModel<UpdateCollection>, RecordTemplate<UpdateCollection>
{
  public static final UpdateCollectionBuilder BUILDER = UpdateCollectionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasItems;
  public final boolean hasMetadata;
  public final boolean hasPagingInfo;
  public final List<Update> items;
  public final Metadata metadata;
  public final PagingInfo pagingInfo;
  
  UpdateCollection(List<Update> paramList, PagingInfo paramPagingInfo, Metadata paramMetadata, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      items = paramList;
      pagingInfo = paramPagingInfo;
      metadata = paramMetadata;
      hasItems = paramBoolean1;
      hasPagingInfo = paramBoolean2;
      hasMetadata = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final UpdateCollection accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    if (hasItems)
    {
      paramDataProcessor.startRecordField$505cff1c("items");
      items.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject3 = items.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Update)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((Update)localObject2).accept(paramDataProcessor);; localObject2 = (Update)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasPagingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("pagingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label335;
        }
        localObject1 = pagingInfo.accept(paramDataProcessor);
        label222:
        if (localObject1 == null) {
          break label353;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label234:
      localObject1 = null;
      bool3 = false;
      if (hasMetadata)
      {
        paramDataProcessor.startRecordField$505cff1c("metadata");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label363;
        }
        localObject1 = metadata.accept(paramDataProcessor);
        label274:
        if (localObject1 == null) {
          break label381;
        }
      }
    }
    label335:
    label353:
    label363:
    label381:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label494;
      }
      try
      {
        if (hasItems) {
          break label387;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection", "items");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (PagingInfo)paramDataProcessor.processDataTemplate(pagingInfo);
      break label222;
      bool2 = false;
      localObject3 = localObject1;
      break label234;
      localObject1 = (Metadata)paramDataProcessor.processDataTemplate(metadata);
      break label274;
    }
    label387:
    if (!hasPagingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection", "pagingInfo");
    }
    if (!hasMetadata) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection", "metadata");
    }
    if (items != null)
    {
      paramDataProcessor = items.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Update)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection", "items");
        }
      }
    }
    return new UpdateCollection((List)localObject2, (PagingInfo)localObject3, (Metadata)localObject1, bool1, bool2, bool3);
    label494:
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
      paramObject = (UpdateCollection)paramObject;
      if (items != null)
      {
        if (items.equals(items)) {}
      }
      else {
        while (items != null) {
          return false;
        }
      }
      if (pagingInfo != null)
      {
        if (pagingInfo.equals(pagingInfo)) {}
      }
      else {
        while (pagingInfo != null) {
          return false;
        }
      }
      if (metadata == null) {
        break;
      }
    } while (metadata.equals(metadata));
    for (;;)
    {
      return false;
      if (metadata == null) {
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
    if (hasItems)
    {
      i += 2;
      Iterator localIterator = items.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Update localUpdate = (Update)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localUpdate.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasPagingInfo)
    {
      i = j + 1;
      if (pagingInfo._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(pagingInfo._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasMetadata)
      {
        i = j + 1;
        if (metadata._cachedId == null) {
          break label208;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(metadata._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += pagingInfo.getSerializedSize();
      break;
      label208:
      i += metadata.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (items != null)
    {
      i = items.hashCode();
      if (pagingInfo == null) {
        break label89;
      }
    }
    label89:
    for (int j = pagingInfo.hashCode();; j = 0)
    {
      if (metadata != null) {
        k = metadata.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building UpdateCollection");
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
    label435:
    label460:
    label468:
    label470:
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
        localByteBuffer.putInt(1273179523);
        if (hasItems)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, items.size());
          Iterator localIterator = items.iterator();
          while (localIterator.hasNext())
          {
            Update localUpdate = (Update)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localUpdate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localUpdate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasPagingInfo)
        {
          localByteBuffer.put((byte)1);
          if (pagingInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pagingInfo._cachedId);
            pagingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMetadata) {
              break label460;
            }
            localByteBuffer.put((byte)1);
            if (metadata._cachedId == null) {
              break label435;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, metadata._cachedId);
            metadata.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label468;
          }
          if (str != null) {
            break label470;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          pagingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          metadata.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */