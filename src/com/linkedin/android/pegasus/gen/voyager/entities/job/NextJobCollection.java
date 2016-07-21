package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
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

public final class NextJobCollection
  implements FissileDataModel<NextJobCollection>, RecordTemplate<NextJobCollection>
{
  public static final NextJobCollectionBuilder BUILDER = NextJobCollectionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasItems;
  public final boolean hasPagingInfo;
  public final List<NextJob> items;
  public final PagingInfo pagingInfo;
  
  NextJobCollection(List<NextJob> paramList, PagingInfo paramPagingInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      items = paramList;
      pagingInfo = paramPagingInfo;
      hasItems = paramBoolean1;
      hasPagingInfo = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final NextJobCollection accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    if (hasItems)
    {
      paramDataProcessor.startRecordField$505cff1c("items");
      items.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = items.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (NextJob)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((NextJob)localObject2).accept(paramDataProcessor);; localObject2 = (NextJob)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      localObject1 = null;
      bool2 = false;
      if (hasPagingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("pagingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label283;
        }
        localObject1 = pagingInfo.accept(paramDataProcessor);
        label222:
        if (localObject1 == null) {
          break label301;
        }
      }
    }
    label283:
    label301:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label391;
      }
      try
      {
        if (hasItems) {
          break label307;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.NextJobCollection", "items");
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
    }
    label307:
    if (!hasPagingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.NextJobCollection", "pagingInfo");
    }
    if (items != null)
    {
      paramDataProcessor = items.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((NextJob)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.NextJobCollection", "items");
        }
      }
    }
    return new NextJobCollection((List)localObject2, (PagingInfo)localObject1, bool1, bool2);
    label391:
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
      paramObject = (NextJobCollection)paramObject;
      if (items != null)
      {
        if (items.equals(items)) {}
      }
      else {
        while (items != null) {
          return false;
        }
      }
      if (pagingInfo == null) {
        break;
      }
    } while (pagingInfo.equals(pagingInfo));
    for (;;)
    {
      return false;
      if (pagingInfo == null) {
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
        NextJob localNextJob = (NextJob)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localNextJob.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasPagingInfo)
    {
      i = j + 1;
      if (pagingInfo._cachedId == null) {
        break label153;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(pagingInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label153:
      i += pagingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (items != null) {}
    for (int i = items.hashCode();; i = 0)
    {
      if (pagingInfo != null) {
        j = pagingInfo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NextJobCollection");
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
    label375:
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
        localByteBuffer.putInt(520541228);
        if (hasItems)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, items.size());
          Iterator localIterator = items.iterator();
          while (localIterator.hasNext())
          {
            NextJob localNextJob = (NextJob)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localNextJob.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localNextJob.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label375;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          pagingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.NextJobCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */