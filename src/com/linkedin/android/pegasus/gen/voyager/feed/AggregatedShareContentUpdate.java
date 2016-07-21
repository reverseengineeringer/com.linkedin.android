package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
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

public final class AggregatedShareContentUpdate
  implements FissileDataModel<AggregatedShareContentUpdate>, RecordTemplate<AggregatedShareContentUpdate>
{
  public static final AggregatedShareContentUpdateBuilder BUILDER = AggregatedShareContentUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final ShareUpdateContent.Content content;
  public final boolean hasActions;
  public final boolean hasContent;
  public final boolean hasRollup;
  public final List<Update> rollup;
  
  AggregatedShareContentUpdate(ShareUpdateContent.Content paramContent, List<UpdateAction> paramList, List<Update> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    content = paramContent;
    if (paramList == null)
    {
      paramContent = null;
      actions = paramContent;
      if (paramList1 != null) {
        break label73;
      }
    }
    label73:
    for (paramContent = null;; paramContent = Collections.unmodifiableList(paramList1))
    {
      rollup = paramContent;
      hasContent = paramBoolean1;
      hasActions = paramBoolean2;
      hasRollup = paramBoolean3;
      _cachedId = null;
      return;
      paramContent = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final AggregatedShareContentUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject3 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    boolean bool2;
    int i;
    if (hasContent)
    {
      paramDataProcessor.startRecordField$505cff1c("content");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = content.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasActions) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = actions.iterator();
      label131:
      if (!((Iterator)localObject4).hasNext()) {
        break label247;
      }
      localObject2 = (UpdateAction)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (Object localObject2 = ((UpdateAction)localObject2).accept(paramDataProcessor);; localObject2 = (UpdateAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label131;
      localObject1 = (ShareUpdateContent.Content)paramDataProcessor.processDataTemplate(content);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool2 = true;
      label261:
      localObject2 = null;
      localObject4 = null;
      bool3 = false;
      if (!hasRollup) {
        break label445;
      }
      paramDataProcessor.startRecordField$505cff1c("rollup");
      rollup.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = rollup.iterator();
      label336:
      if (!localIterator.hasNext()) {
        break label431;
      }
      localObject4 = (Update)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label415;
      }
    }
    label415:
    for (Object localObject4 = ((Update)localObject4).accept(paramDataProcessor);; localObject4 = (Update)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject2 != null) && (localObject4 != null)) {
        ((List)localObject2).add(localObject4);
      }
      i += 1;
      break label336;
      bool2 = false;
      break;
    }
    label431:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label445:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label645;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasContent) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate", "content");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRollup) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate", "rollup");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate", "actions");
        }
      }
    }
    if (rollup != null)
    {
      paramDataProcessor = rollup.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Update)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate", "rollup");
        }
      }
    }
    return new AggregatedShareContentUpdate((ShareUpdateContent.Content)localObject3, (List)localObject1, (List)localObject2, bool1, bool2, bool3);
    label645:
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
      paramObject = (AggregatedShareContentUpdate)paramObject;
      if (content != null)
      {
        if (content.equals(content)) {}
      }
      else {
        while (content != null) {
          return false;
        }
      }
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (rollup == null) {
        break;
      }
    } while (rollup.equals(rollup));
    for (;;)
    {
      return false;
      if (rollup == null) {
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
    Iterator localIterator;
    if (hasContent)
    {
      if (content._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(content._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasActions) {
        break label153;
      }
      i += 2;
      localIterator = actions.iterator();
    }
    Object localObject;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      localObject = (UpdateAction)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = content.getSerializedSize() + 7;
        break;
      }
      i += ((UpdateAction)localObject).getSerializedSize();
    }
    label153:
    i = j + 1;
    int j = i;
    if (hasRollup)
    {
      i += 2;
      localIterator = rollup.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Update)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Update)localObject).getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (content != null)
    {
      i = content.hashCode();
      if (actions == null) {
        break label91;
      }
    }
    label91:
    for (int j = actions.hashCode();; j = 0)
    {
      if (rollup != null) {
        k = rollup.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AggregatedShareContentUpdate");
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
        localByteBuffer.putInt(718253746);
        Iterator localIterator;
        if (hasContent)
        {
          localByteBuffer.put((byte)1);
          if (content._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, content._cachedId);
            content.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasActions) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
            localIterator = actions.iterator();
          }
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          localObject = (UpdateAction)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((UpdateAction)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            content.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          ((UpdateAction)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasRollup)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, rollup.size());
          localIterator = rollup.iterator();
          while (localIterator.hasNext())
          {
            localObject = (Update)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((Update)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((Update)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */