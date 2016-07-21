package com.linkedin.android.pegasus.gen.voyager.messaging.event;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.messaging.MessagingProfile;
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

public final class ParticipantChangeEvent
  implements FissileDataModel<ParticipantChangeEvent>, RecordTemplate<ParticipantChangeEvent>
{
  public static final ParticipantChangeEventBuilder BUILDER = ParticipantChangeEventBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<MessagingProfile> addedParticipants;
  public final boolean hasAddedParticipants;
  public final boolean hasRemovedParticipants;
  public final List<MessagingProfile> removedParticipants;
  
  ParticipantChangeEvent(List<MessagingProfile> paramList1, List<MessagingProfile> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList1 == null)
    {
      paramList1 = null;
      addedParticipants = paramList1;
      if (paramList2 != null) {
        break label61;
      }
    }
    label61:
    for (paramList1 = null;; paramList1 = Collections.unmodifiableList(paramList2))
    {
      removedParticipants = paramList1;
      hasAddedParticipants = paramBoolean1;
      hasRemovedParticipants = paramBoolean2;
      _cachedId = null;
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
    }
  }
  
  public final ParticipantChangeEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    if (hasAddedParticipants)
    {
      paramDataProcessor.startRecordField$505cff1c("addedParticipants");
      addedParticipants.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = addedParticipants.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (MessagingProfile)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((MessagingProfile)localObject2).accept(paramDataProcessor);; localObject2 = (MessagingProfile)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      localObject3 = null;
      bool2 = false;
      if (!hasRemovedParticipants) {
        break label369;
      }
      paramDataProcessor.startRecordField$505cff1c("removedParticipants");
      removedParticipants.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = removedParticipants.iterator();
      label257:
      if (!localIterator.hasNext()) {
        break label355;
      }
      localObject3 = (MessagingProfile)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label339;
      }
    }
    label339:
    for (Object localObject3 = ((MessagingProfile)localObject3).accept(paramDataProcessor);; localObject3 = (MessagingProfile)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject1 != null) && (localObject3 != null)) {
        ((List)localObject1).add(localObject3);
      }
      i += 1;
      break label257;
      bool1 = false;
      localObject2 = localObject1;
      break;
    }
    label355:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label369:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label546;
      }
      if (!hasRemovedParticipants) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasAddedParticipants) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.ParticipantChangeEvent", "addedParticipants");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (addedParticipants != null)
    {
      paramDataProcessor = addedParticipants.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MessagingProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.event.ParticipantChangeEvent", "addedParticipants");
        }
      }
    }
    if (removedParticipants != null)
    {
      paramDataProcessor = removedParticipants.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MessagingProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.event.ParticipantChangeEvent", "removedParticipants");
        }
      }
    }
    return new ParticipantChangeEvent((List)localObject2, (List)localObject1, bool1, bool2);
    label546:
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
      paramObject = (ParticipantChangeEvent)paramObject;
      if (addedParticipants != null)
      {
        if (addedParticipants.equals(addedParticipants)) {}
      }
      else {
        while (addedParticipants != null) {
          return false;
        }
      }
      if (removedParticipants == null) {
        break;
      }
    } while (removedParticipants.equals(removedParticipants));
    for (;;)
    {
      return false;
      if (removedParticipants == null) {
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
    MessagingProfile localMessagingProfile;
    if (hasAddedParticipants)
    {
      i += 2;
      localIterator = addedParticipants.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localMessagingProfile = (MessagingProfile)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localMessagingProfile.getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasRemovedParticipants)
    {
      i += 2;
      localIterator = removedParticipants.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localMessagingProfile = (MessagingProfile)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localMessagingProfile.getSerializedSize();
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
    if (addedParticipants != null) {}
    for (int i = addedParticipants.hashCode();; i = 0)
    {
      if (removedParticipants != null) {
        j = removedParticipants.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ParticipantChangeEvent");
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
        localByteBuffer.putInt(1724797289);
        Iterator localIterator;
        MessagingProfile localMessagingProfile;
        if (hasAddedParticipants)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, addedParticipants.size());
          localIterator = addedParticipants.iterator();
          while (localIterator.hasNext())
          {
            localMessagingProfile = (MessagingProfile)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localMessagingProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localMessagingProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasRemovedParticipants)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, removedParticipants.size());
          localIterator = removedParticipants.iterator();
          while (localIterator.hasNext())
          {
            localMessagingProfile = (MessagingProfile)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localMessagingProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localMessagingProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.ParticipantChangeEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */