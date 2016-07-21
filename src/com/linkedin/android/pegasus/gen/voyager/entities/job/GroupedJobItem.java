package com.linkedin.android.pegasus.gen.voyager.entities.job;

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

public final class GroupedJobItem
  implements FissileDataModel<GroupedJobItem>, RecordTemplate<GroupedJobItem>
{
  public static final GroupedJobItemBuilder BUILDER = GroupedJobItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<JobItem> additionalItems;
  public final boolean hasAdditionalItems;
  public final boolean hasMainItem;
  public final JobItem mainItem;
  
  GroupedJobItem(JobItem paramJobItem, List<JobItem> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    mainItem = paramJobItem;
    if (paramList == null) {}
    for (paramJobItem = null;; paramJobItem = Collections.unmodifiableList(paramList))
    {
      additionalItems = paramJobItem;
      hasMainItem = paramBoolean1;
      hasAdditionalItems = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final GroupedJobItem accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasMainItem)
    {
      paramDataProcessor.startRecordField$505cff1c("mainItem");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = mainItem.accept(paramDataProcessor);
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
      localJobItem = null;
      bool2 = false;
      if (!hasAdditionalItems) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("additionalItems");
      additionalItems.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localJobItem;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = additionalItems.iterator();
      label131:
      if (!localIterator.hasNext()) {
        break label247;
      }
      localJobItem = (JobItem)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (JobItem localJobItem = localJobItem.accept(paramDataProcessor);; localJobItem = (JobItem)paramDataProcessor.processDataTemplate(localJobItem))
    {
      if ((localObject1 != null) && (localJobItem != null)) {
        ((List)localObject1).add(localJobItem);
      }
      i += 1;
      break label131;
      localObject1 = (JobItem)paramDataProcessor.processDataTemplate(mainItem);
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
        break label388;
      }
      if (!hasAdditionalItems) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasMainItem) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.GroupedJobItem", "mainItem");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (additionalItems != null)
    {
      paramDataProcessor = additionalItems.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((JobItem)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.GroupedJobItem", "additionalItems");
        }
      }
    }
    return new GroupedJobItem((JobItem)localObject2, (List)localObject1, bool1, bool2);
    label388:
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
      paramObject = (GroupedJobItem)paramObject;
      if (mainItem != null)
      {
        if (mainItem.equals(mainItem)) {}
      }
      else {
        while (mainItem != null) {
          return false;
        }
      }
      if (additionalItems == null) {
        break;
      }
    } while (additionalItems.equals(additionalItems));
    for (;;)
    {
      return false;
      if (additionalItems == null) {
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
    if (hasMainItem)
    {
      if (mainItem._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(mainItem._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasAdditionalItems) {
        break label153;
      }
      i += 2;
      localIterator = additionalItems.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      JobItem localJobItem = (JobItem)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = mainItem.getSerializedSize() + 7;
        break;
      }
      i += localJobItem.getSerializedSize();
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
    if (mainItem != null) {}
    for (int i = mainItem.hashCode();; i = 0)
    {
      if (additionalItems != null) {
        j = additionalItems.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building GroupedJobItem");
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
        localByteBuffer.putInt(733076833);
        Iterator localIterator;
        if (hasMainItem)
        {
          localByteBuffer.put((byte)1);
          if (mainItem._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mainItem._cachedId);
            mainItem.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAdditionalItems) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, additionalItems.size());
            localIterator = additionalItems.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          JobItem localJobItem = (JobItem)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localJobItem.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            mainItem.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          localJobItem.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.GroupedJobItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */