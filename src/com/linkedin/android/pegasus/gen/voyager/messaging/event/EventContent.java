package com.linkedin.android.pegasus.gen.voyager.messaging.event;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EventContent
  implements FissileDataModel<EventContent>, UnionTemplate<EventContent>
{
  public static final EventContentBuilder BUILDER = EventContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final GenericMessageEvent genericMessageEventValue;
  public final boolean hasGenericMessageEventValue;
  public final boolean hasMessageEventValue;
  public final boolean hasParticipantChangeEventValue;
  public final boolean hasStickerEventValue;
  public final MessageEvent messageEventValue;
  public final ParticipantChangeEvent participantChangeEventValue;
  public final StickerEvent stickerEventValue;
  
  EventContent(MessageEvent paramMessageEvent, ParticipantChangeEvent paramParticipantChangeEvent, StickerEvent paramStickerEvent, GenericMessageEvent paramGenericMessageEvent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    messageEventValue = paramMessageEvent;
    participantChangeEventValue = paramParticipantChangeEvent;
    stickerEventValue = paramStickerEvent;
    genericMessageEventValue = paramGenericMessageEvent;
    hasMessageEventValue = paramBoolean1;
    hasParticipantChangeEventValue = paramBoolean2;
    hasStickerEventValue = paramBoolean3;
    hasGenericMessageEventValue = paramBoolean4;
    _cachedId = null;
  }
  
  public final EventContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasMessageEventValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.MessageEvent");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = messageEventValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label261;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasParticipantChangeEventValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.ParticipantChangeEvent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label270;
        }
        localObject1 = participantChangeEventValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label288;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasStickerEventValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.StickerEvent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label297;
        }
        localObject1 = stickerEventValue.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label315;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasGenericMessageEventValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.GenericMessageEvent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label325;
        }
        localObject1 = genericMessageEventValue.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label343;
        }
      }
    }
    label261:
    label270:
    label288:
    label297:
    label315:
    label325:
    label343:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label349;
      }
      return new EventContent((MessageEvent)localObject2, (ParticipantChangeEvent)localObject3, (StickerEvent)localObject4, (GenericMessageEvent)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (MessageEvent)paramDataProcessor.processDataTemplate(messageEventValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ParticipantChangeEvent)paramDataProcessor.processDataTemplate(participantChangeEventValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (StickerEvent)paramDataProcessor.processDataTemplate(stickerEventValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (GenericMessageEvent)paramDataProcessor.processDataTemplate(genericMessageEventValue);
      break label198;
    }
    label349:
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
      paramObject = (EventContent)paramObject;
      if (messageEventValue != null)
      {
        if (messageEventValue.equals(messageEventValue)) {}
      }
      else {
        while (messageEventValue != null) {
          return false;
        }
      }
      if (participantChangeEventValue != null)
      {
        if (participantChangeEventValue.equals(participantChangeEventValue)) {}
      }
      else {
        while (participantChangeEventValue != null) {
          return false;
        }
      }
      if (stickerEventValue != null)
      {
        if (stickerEventValue.equals(stickerEventValue)) {}
      }
      else {
        while (stickerEventValue != null) {
          return false;
        }
      }
      if (genericMessageEventValue == null) {
        break;
      }
    } while (genericMessageEventValue.equals(genericMessageEventValue));
    for (;;)
    {
      return false;
      if (genericMessageEventValue == null) {
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
    if (hasMessageEventValue)
    {
      if (messageEventValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(messageEventValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasParticipantChangeEventValue)
      {
        i = j + 1;
        if (participantChangeEventValue._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(participantChangeEventValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasStickerEventValue)
      {
        i = j + 1;
        if (stickerEventValue._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(stickerEventValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasGenericMessageEventValue)
      {
        i = j + 1;
        if (genericMessageEventValue._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(genericMessageEventValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = messageEventValue.getSerializedSize() + 7;
      break;
      label198:
      i += participantChangeEventValue.getSerializedSize();
      break label93;
      label211:
      i += stickerEventValue.getSerializedSize();
      break label135;
      label224:
      i += genericMessageEventValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (messageEventValue != null)
    {
      i = messageEventValue.hashCode();
      if (participantChangeEventValue == null) {
        break label110;
      }
      j = participantChangeEventValue.hashCode();
      label45:
      if (stickerEventValue == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = stickerEventValue.hashCode();; k = 0)
    {
      if (genericMessageEventValue != null) {
        m = genericMessageEventValue.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EventContent");
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
    label230:
    label290:
    label418:
    label443:
    label453:
    label478:
    label488:
    label513:
    label521:
    label523:
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
        localByteBuffer.putInt(78911678);
        if (hasMessageEventValue)
        {
          localByteBuffer.put((byte)1);
          if (messageEventValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, messageEventValue._cachedId);
            messageEventValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasParticipantChangeEventValue) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (participantChangeEventValue._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, participantChangeEventValue._cachedId);
            participantChangeEventValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasStickerEventValue) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (stickerEventValue._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, stickerEventValue._cachedId);
            stickerEventValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasGenericMessageEventValue) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (genericMessageEventValue._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, genericMessageEventValue._cachedId);
            genericMessageEventValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label521;
          }
          if (str != null) {
            break label523;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          messageEventValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          participantChangeEventValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          stickerEventValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          genericMessageEventValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.EventContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */