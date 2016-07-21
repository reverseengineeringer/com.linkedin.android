package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect;

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

public final class ReconnectionSuggestion
  implements FissileDataModel<ReconnectionSuggestion>, RecordTemplate<ReconnectionSuggestion>
{
  public static final ReconnectionSuggestionBuilder BUILDER = ReconnectionSuggestionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<ReconnectionBrief> briefs;
  public final boolean hasBriefs;
  public final boolean hasSuggestedEntity;
  public final boolean hasTrackingId;
  public final ReconnectionEntity suggestedEntity;
  public final String trackingId;
  
  ReconnectionSuggestion(ReconnectionEntity paramReconnectionEntity, List<ReconnectionBrief> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    suggestedEntity = paramReconnectionEntity;
    if (paramList == null) {}
    for (paramReconnectionEntity = null;; paramReconnectionEntity = Collections.unmodifiableList(paramList))
    {
      briefs = paramReconnectionEntity;
      trackingId = paramString;
      hasSuggestedEntity = paramBoolean1;
      hasBriefs = paramBoolean2;
      hasTrackingId = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final ReconnectionSuggestion accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasSuggestedEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestedEntity");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = suggestedEntity.accept(paramDataProcessor);
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
      localReconnectionBrief = null;
      bool2 = false;
      if (!hasBriefs) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("briefs");
      briefs.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localReconnectionBrief;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = briefs.iterator();
      label131:
      if (!localIterator.hasNext()) {
        break label247;
      }
      localReconnectionBrief = (ReconnectionBrief)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (ReconnectionBrief localReconnectionBrief = localReconnectionBrief.accept(paramDataProcessor);; localReconnectionBrief = (ReconnectionBrief)paramDataProcessor.processDataTemplate(localReconnectionBrief))
    {
      if ((localObject1 != null) && (localReconnectionBrief != null)) {
        ((List)localObject1).add(localReconnectionBrief);
      }
      i += 1;
      break label131;
      localObject1 = (ReconnectionEntity)paramDataProcessor.processDataTemplate(suggestedEntity);
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
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label447;
      }
      try
      {
        if (hasSuggestedEntity) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestion", "suggestedEntity");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasBriefs) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestion", "briefs");
    }
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestion", "trackingId");
    }
    if (briefs != null)
    {
      paramDataProcessor = briefs.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ReconnectionBrief)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestion", "briefs");
        }
      }
    }
    return new ReconnectionSuggestion((ReconnectionEntity)localObject2, (List)localObject1, trackingId, bool1, bool2, hasTrackingId);
    label447:
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
      paramObject = (ReconnectionSuggestion)paramObject;
      if (suggestedEntity != null)
      {
        if (suggestedEntity.equals(suggestedEntity)) {}
      }
      else {
        while (suggestedEntity != null) {
          return false;
        }
      }
      if (briefs == null) {
        break;
      }
    } while (briefs.equals(briefs));
    for (;;)
    {
      return false;
      if (briefs == null) {
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
    if (hasSuggestedEntity)
    {
      if (suggestedEntity._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(suggestedEntity._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasBriefs) {
        break label153;
      }
      i += 2;
      localIterator = briefs.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      ReconnectionBrief localReconnectionBrief = (ReconnectionBrief)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = suggestedEntity.getSerializedSize() + 7;
        break;
      }
      i += localReconnectionBrief.getSerializedSize();
    }
    label153:
    j += 1;
    i = j;
    if (hasTrackingId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
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
    if (suggestedEntity != null) {}
    for (int i = suggestedEntity.hashCode();; i = 0)
    {
      if (briefs != null) {
        j = briefs.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ReconnectionSuggestion");
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
    label411:
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
        localByteBuffer.putInt(-1272842479);
        Iterator localIterator;
        if (hasSuggestedEntity)
        {
          localByteBuffer.put((byte)1);
          if (suggestedEntity._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, suggestedEntity._cachedId);
            suggestedEntity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBriefs) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, briefs.size());
            localIterator = briefs.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          ReconnectionBrief localReconnectionBrief = (ReconnectionBrief)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localReconnectionBrief.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            suggestedEntity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          localReconnectionBrief.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label411;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionSuggestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */