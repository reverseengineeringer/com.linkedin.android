package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Event
  implements FissileDataModel<Event>, RecordTemplate<Event>
{
  public static final EventBuilder BUILDER = EventBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final long createdAt;
  public final Urn entityUrn;
  public final EventContent eventContent;
  public final MessagingProfile from;
  public final boolean hasCreatedAt;
  public final boolean hasEntityUrn;
  public final boolean hasEventContent;
  public final boolean hasFrom;
  public final boolean hasPreviousEventInConversation;
  public final boolean hasSubtype;
  public final Urn previousEventInConversation;
  public final EventSubtype subtype;
  
  Event(Urn paramUrn1, long paramLong, MessagingProfile paramMessagingProfile, EventSubtype paramEventSubtype, EventContent paramEventContent, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn1;
    createdAt = paramLong;
    from = paramMessagingProfile;
    subtype = paramEventSubtype;
    eventContent = paramEventContent;
    previousEventInConversation = paramUrn2;
    hasEntityUrn = paramBoolean1;
    hasCreatedAt = paramBoolean2;
    hasFrom = paramBoolean3;
    hasSubtype = paramBoolean4;
    hasEventContent = paramBoolean5;
    hasPreviousEventInConversation = paramBoolean6;
    paramMessagingProfile = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final Event accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasCreatedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("createdAt");
      paramDataProcessor.processLong(createdAt);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasFrom)
    {
      paramDataProcessor.startRecordField$505cff1c("from");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = from.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label280;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label114:
      if (hasSubtype)
      {
        paramDataProcessor.startRecordField$505cff1c("subtype");
        paramDataProcessor.processEnum(subtype);
      }
      localObject1 = null;
      bool2 = false;
      if (hasEventContent)
      {
        paramDataProcessor.startRecordField$505cff1c("eventContent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label289;
        }
        localObject1 = eventContent.accept(paramDataProcessor);
        label178:
        if (localObject1 == null) {
          break label307;
        }
      }
    }
    label280:
    label289:
    label307:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasPreviousEventInConversation)
      {
        paramDataProcessor.startRecordField$505cff1c("previousEventInConversation");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(previousEventInConversation));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label434;
      }
      try
      {
        if (hasEntityUrn) {
          break label312;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Event", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MessagingProfile)paramDataProcessor.processDataTemplate(from);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (EventContent)paramDataProcessor.processDataTemplate(eventContent);
      break label178;
    }
    label312:
    if (!hasCreatedAt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Event", "createdAt");
    }
    if (!hasFrom) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Event", "from");
    }
    if (!hasSubtype) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Event", "subtype");
    }
    if (!hasEventContent) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Event", "eventContent");
    }
    return new Event(entityUrn, createdAt, (MessagingProfile)localObject2, subtype, (EventContent)localObject1, previousEventInConversation, hasEntityUrn, hasCreatedAt, bool1, hasSubtype, bool2, hasPreviousEventInConversation);
    label434:
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
      paramObject = (Event)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (createdAt != createdAt) {
        return false;
      }
      if (from != null)
      {
        if (from.equals(from)) {}
      }
      else {
        while (from != null) {
          return false;
        }
      }
      if (subtype != null)
      {
        if (subtype.equals(subtype)) {}
      }
      else {
        while (subtype != null) {
          return false;
        }
      }
      if (eventContent != null)
      {
        if (eventContent.equals(eventContent)) {}
      }
      else {
        while (eventContent != null) {
          return false;
        }
      }
      if (previousEventInConversation == null) {
        break;
      }
    } while (previousEventInConversation.equals(previousEventInConversation));
    for (;;)
    {
      return false;
      if (previousEventInConversation == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCreatedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasFrom)
    {
      i = j + 1;
      if (from._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(from._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasSubtype) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasEventContent)
      {
        i = j + 1;
        if (eventContent._cachedId == null) {
          break label216;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(eventContent._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasPreviousEventInConversation)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(previousEventInConversation));
      }
      __sizeOfObject = i;
      return i;
      i += from.getSerializedSize();
      break;
      label216:
      i += eventContent.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int i1;
    int j;
    label60:
    int k;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      i1 = (int)(createdAt ^ createdAt >>> 32);
      if (from == null) {
        break label153;
      }
      j = from.hashCode();
      if (subtype == null) {
        break label158;
      }
      k = subtype.hashCode();
      label75:
      if (eventContent == null) {
        break label163;
      }
    }
    label153:
    label158:
    label163:
    for (int m = eventContent.hashCode();; m = 0)
    {
      if (previousEventInConversation != null) {
        n = previousEventInConversation.hashCode();
      }
      i = (m + (k + (j + ((i + 527) * 31 + i1) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label60;
      k = 0;
      break label75;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Event");
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
    label228:
    label257:
    label317:
    label394:
    label404:
    label429:
    label439:
    label449:
    label474:
    label484:
    label492:
    label494:
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
        localByteBuffer.putInt(-227089407);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasCreatedAt) {
            break label394;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdAt);
          if (!hasFrom) {
            break label429;
          }
          localByteBuffer.put((byte)1);
          if (from._cachedId == null) {
            break label404;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, from._cachedId);
          from.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSubtype) {
            break label439;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, subtype.ordinal());
          if (!hasEventContent) {
            break label474;
          }
          localByteBuffer.put((byte)1);
          if (eventContent._cachedId == null) {
            break label449;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, eventContent._cachedId);
          eventContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPreviousEventInConversation) {
            break label484;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(previousEventInConversation));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label492;
          }
          if (str != null) {
            break label494;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label168;
          localByteBuffer.put((byte)1);
          from.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label228;
          localByteBuffer.put((byte)0);
          break label228;
          localByteBuffer.put((byte)0);
          break label257;
          localByteBuffer.put((byte)1);
          eventContent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label317;
          localByteBuffer.put((byte)0);
          break label317;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.Event
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */