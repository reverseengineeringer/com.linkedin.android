package com.linkedin.android.pegasus.gen.voyager.messaging.realtime;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.messaging.Event;
import com.linkedin.android.pegasus.gen.voyager.messaging.ParticipantReceipts;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RealtimeEvent
  implements FissileDataModel<RealtimeEvent>, RecordTemplate<RealtimeEvent>
{
  public static final RealtimeEventBuilder BUILDER = RealtimeEventBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int conversationUnreadCount;
  public final Event event;
  public final boolean hasConversationUnreadCount;
  public final boolean hasEvent;
  public final boolean hasParticipantReceipts;
  public final ParticipantReceipts participantReceipts;
  
  RealtimeEvent(Event paramEvent, int paramInt, ParticipantReceipts paramParticipantReceipts, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    event = paramEvent;
    conversationUnreadCount = paramInt;
    participantReceipts = paramParticipantReceipts;
    hasEvent = paramBoolean1;
    hasConversationUnreadCount = paramBoolean2;
    hasParticipantReceipts = paramBoolean3;
    _cachedId = null;
  }
  
  private RealtimeEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasEvent)
    {
      paramDataProcessor.startRecordField$505cff1c("event");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = event.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label189;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      if (hasConversationUnreadCount)
      {
        paramDataProcessor.startRecordField$505cff1c("conversationUnreadCount");
        paramDataProcessor.processInt(conversationUnreadCount);
      }
      localObject1 = null;
      bool2 = false;
      if (hasParticipantReceipts)
      {
        paramDataProcessor.startRecordField$505cff1c("participantReceipts");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label198;
        }
        localObject1 = participantReceipts.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label216;
        }
      }
    }
    label189:
    label198:
    label216:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label262;
      }
      try
      {
        if (hasEvent) {
          break label221;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeEvent", "event");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Event)paramDataProcessor.processDataTemplate(event);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ParticipantReceipts)paramDataProcessor.processDataTemplate(participantReceipts);
      break label120;
    }
    label221:
    if (!hasConversationUnreadCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeEvent", "conversationUnreadCount");
    }
    return new RealtimeEvent((Event)localObject2, conversationUnreadCount, (ParticipantReceipts)localObject1, bool1, hasConversationUnreadCount, bool2);
    label262:
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
      paramObject = (RealtimeEvent)paramObject;
      if (event != null)
      {
        if (event.equals(event)) {}
      }
      else {
        while (event != null) {
          return false;
        }
      }
      if (conversationUnreadCount != conversationUnreadCount) {
        return false;
      }
      if (participantReceipts == null) {
        break;
      }
    } while (participantReceipts.equals(participantReceipts));
    for (;;)
    {
      return false;
      if (participantReceipts == null) {
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
    if (hasEvent)
    {
      if (event._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(event._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasConversationUnreadCount) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasParticipantReceipts)
      {
        i = j + 1;
        if (participantReceipts._cachedId == null) {
          break label131;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(participantReceipts._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = event.getSerializedSize() + 7;
      break;
      label131:
      i += participantReceipts.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (event != null) {}
    for (int i = event.hashCode();; i = 0)
    {
      int k = conversationUnreadCount;
      if (participantReceipts != null) {
        j = participantReceipts.hashCode();
      }
      i = ((i + 527) * 31 + k) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RealtimeEvent");
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
    label194:
    label322:
    label332:
    label357:
    label365:
    label367:
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
        localByteBuffer.putInt(1599097708);
        if (hasEvent)
        {
          localByteBuffer.put((byte)1);
          if (event._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, event._cachedId);
            event.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasConversationUnreadCount) {
              break label322;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(conversationUnreadCount);
            if (!hasParticipantReceipts) {
              break label357;
            }
            localByteBuffer.put((byte)1);
            if (participantReceipts._cachedId == null) {
              break label332;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, participantReceipts._cachedId);
            participantReceipts.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label365;
          }
          if (str != null) {
            break label367;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          event.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label194;
          localByteBuffer.put((byte)1);
          participantReceipts.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */