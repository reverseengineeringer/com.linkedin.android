package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EventCreateResponse
  implements FissileDataModel<EventCreateResponse>, RecordTemplate<EventCreateResponse>
{
  public static final EventCreateResponseBuilder BUILDER = EventCreateResponseBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn conversationUrn;
  public final long createdAt;
  public final Urn eventUrn;
  public final boolean hasConversationUrn;
  public final boolean hasCreatedAt;
  public final boolean hasEventUrn;
  
  EventCreateResponse(long paramLong, Urn paramUrn1, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    createdAt = paramLong;
    conversationUrn = paramUrn1;
    eventUrn = paramUrn2;
    hasCreatedAt = paramBoolean1;
    hasConversationUrn = paramBoolean2;
    hasEventUrn = paramBoolean3;
    _cachedId = null;
  }
  
  private EventCreateResponse accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCreatedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("createdAt");
      paramDataProcessor.processLong(createdAt);
    }
    UrnCoercer localUrnCoercer;
    if (hasConversationUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("conversationUrn");
      localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(conversationUrn));
    }
    if (hasEventUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("eventUrn");
      localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(eventUrn));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasCreatedAt) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse", "createdAt");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasConversationUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse", "conversationUrn");
      }
      if (!hasEventUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse", "eventUrn");
      }
      return new EventCreateResponse(createdAt, conversationUrn, eventUrn, hasCreatedAt, hasConversationUrn, hasEventUrn);
    }
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
      paramObject = (EventCreateResponse)paramObject;
      if (createdAt != createdAt) {
        return false;
      }
      if (conversationUrn != null)
      {
        if (conversationUrn.equals(conversationUrn)) {}
      }
      else {
        while (conversationUrn != null) {
          return false;
        }
      }
      if (eventUrn == null) {
        break;
      }
    } while (eventUrn.equals(eventUrn));
    for (;;)
    {
      return false;
      if (eventUrn == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasCreatedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    UrnCoercer localUrnCoercer;
    if (hasConversationUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(conversationUrn));
    }
    j = i + 1;
    i = j;
    if (hasEventUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(eventUrn));
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
    int k = (int)(createdAt ^ createdAt >>> 32);
    if (conversationUrn != null) {}
    for (int i = conversationUrn.hashCode();; i = 0)
    {
      if (eventUrn != null) {
        j = eventUrn.hashCode();
      }
      i = (i + (k + 527) * 31) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EventCreateResponse");
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
    label168:
    label245:
    label255:
    label263:
    label265:
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
        localByteBuffer.putInt(278143833);
        if (hasCreatedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdAt);
          if (!hasConversationUrn) {
            break label245;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(conversationUrn));
          if (!hasEventUrn) {
            break label255;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(eventUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label263;
          }
          if (str != null) {
            break label265;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label168;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */