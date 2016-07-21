package com.linkedin.android.pegasus.gen.voyager.messaging.realtime;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.messaging.MessagingProfileEntity;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RealtimeTypingIndicator
  implements FissileDataModel<RealtimeTypingIndicator>, RecordTemplate<RealtimeTypingIndicator>
{
  public static final RealtimeTypingIndicatorBuilder BUILDER = RealtimeTypingIndicatorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn conversation;
  public final MessagingProfileEntity fromParticipant;
  public final boolean hasConversation;
  public final boolean hasFromParticipant;
  
  RealtimeTypingIndicator(Urn paramUrn, MessagingProfileEntity paramMessagingProfileEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    conversation = paramUrn;
    fromParticipant = paramMessagingProfileEntity;
    hasConversation = paramBoolean1;
    hasFromParticipant = paramBoolean2;
    _cachedId = null;
  }
  
  private RealtimeTypingIndicator accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasConversation)
    {
      paramDataProcessor.startRecordField$505cff1c("conversation");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(conversation));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasFromParticipant)
    {
      paramDataProcessor.startRecordField$505cff1c("fromParticipant");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label125;
      }
      localObject = fromParticipant.accept(paramDataProcessor);
      if (localObject == null) {
        break label142;
      }
    }
    label125:
    label142:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label184;
      }
      try
      {
        if (hasConversation) {
          break label147;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeTypingIndicator", "conversation");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (MessagingProfileEntity)paramDataProcessor.processDataTemplate(fromParticipant);
      break;
    }
    label147:
    if (!hasFromParticipant) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeTypingIndicator", "fromParticipant");
    }
    return new RealtimeTypingIndicator(conversation, (MessagingProfileEntity)localObject, hasConversation, bool);
    label184:
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
      paramObject = (RealtimeTypingIndicator)paramObject;
      if (conversation != null)
      {
        if (conversation.equals(conversation)) {}
      }
      else {
        while (conversation != null) {
          return false;
        }
      }
      if (fromParticipant == null) {
        break;
      }
    } while (fromParticipant.equals(fromParticipant));
    for (;;)
    {
      return false;
      if (fromParticipant == null) {
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
    if (hasConversation)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(conversation)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasFromParticipant)
    {
      i = j + 1;
      if (fromParticipant._cachedId == null) {
        break label94;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(fromParticipant._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label94:
      i += fromParticipant.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (conversation != null) {}
    for (int i = conversation.hashCode();; i = 0)
    {
      if (fromParticipant != null) {
        j = fromParticipant.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RealtimeTypingIndicator");
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
    label247:
    label272:
    label280:
    label282:
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
        localByteBuffer.putInt(460644971);
        if (hasConversation)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(conversation));
          if (!hasFromParticipant) {
            break label272;
          }
          localByteBuffer.put((byte)1);
          if (fromParticipant._cachedId == null) {
            break label247;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, fromParticipant._cachedId);
          fromParticipant.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label280;
          }
          if (str != null) {
            break label282;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          fromParticipant.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeTypingIndicator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */