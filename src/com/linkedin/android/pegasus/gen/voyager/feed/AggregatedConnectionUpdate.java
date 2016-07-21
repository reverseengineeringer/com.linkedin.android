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

public final class AggregatedConnectionUpdate
  implements FissileDataModel<AggregatedConnectionUpdate>, RecordTemplate<AggregatedConnectionUpdate>
{
  public static final AggregatedConnectionUpdateBuilder BUILDER = AggregatedConnectionUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final List<Update> connectionUpdates;
  public final boolean hasActions;
  public final boolean hasConnectionUpdates;
  
  AggregatedConnectionUpdate(List<UpdateAction> paramList, List<Update> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null)
    {
      paramList = null;
      actions = paramList;
      if (paramList1 != null) {
        break label61;
      }
    }
    label61:
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList1))
    {
      connectionUpdates = paramList;
      hasActions = paramBoolean1;
      hasConnectionUpdates = paramBoolean2;
      _cachedId = null;
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final AggregatedConnectionUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    if (hasActions)
    {
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = actions.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (UpdateAction)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((UpdateAction)localObject2).accept(paramDataProcessor);; localObject2 = (UpdateAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      localObject2 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasConnectionUpdates) {
        break label365;
      }
      paramDataProcessor.startRecordField$505cff1c("connectionUpdates");
      connectionUpdates.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = connectionUpdates.iterator();
      label257:
      if (!localIterator.hasNext()) {
        break label351;
      }
      localObject3 = (Update)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label335;
      }
    }
    label335:
    for (Object localObject3 = ((Update)localObject3).accept(paramDataProcessor);; localObject3 = (Update)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label257;
      bool1 = false;
      break;
    }
    label351:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label365:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label542;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasConnectionUpdates) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate", "connectionUpdates");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate", "actions");
        }
      }
    }
    if (connectionUpdates != null)
    {
      paramDataProcessor = connectionUpdates.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Update)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate", "connectionUpdates");
        }
      }
    }
    return new AggregatedConnectionUpdate((List)localObject1, (List)localObject2, bool1, bool2);
    label542:
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
      paramObject = (AggregatedConnectionUpdate)paramObject;
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (connectionUpdates == null) {
        break;
      }
    } while (connectionUpdates.equals(connectionUpdates));
    for (;;)
    {
      return false;
      if (connectionUpdates == null) {
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
    Iterator localIterator;
    Object localObject;
    if (hasActions)
    {
      i += 2;
      localIterator = actions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (UpdateAction)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((UpdateAction)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasConnectionUpdates)
    {
      i += 2;
      localIterator = connectionUpdates.iterator();
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
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (actions != null) {}
    for (int i = actions.hashCode();; i = 0)
    {
      if (connectionUpdates != null) {
        j = connectionUpdates.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AggregatedConnectionUpdate");
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
        localByteBuffer.putInt(-146227224);
        Iterator localIterator;
        Object localObject;
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localIterator = actions.iterator();
          while (localIterator.hasNext())
          {
            localObject = (UpdateAction)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((UpdateAction)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((UpdateAction)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasConnectionUpdates)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, connectionUpdates.size());
          localIterator = connectionUpdates.iterator();
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */