package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EventCreate
  implements FissileDataModel<EventCreate>, RecordTemplate<EventCreate>
{
  public static final EventCreateBuilder BUILDER = EventCreateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasValue;
  public final Value value;
  
  EventCreate(Value paramValue, boolean paramBoolean)
  {
    value = paramValue;
    hasValue = paramBoolean;
    _cachedId = null;
  }
  
  public final EventCreate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Value localValue = null;
    boolean bool = false;
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label93;
      }
      localValue = value.accept(paramDataProcessor);
      if (localValue == null) {
        break label110;
      }
    }
    label93:
    label110:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label125;
      }
      try
      {
        if (hasValue) {
          break label115;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate", "value");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localValue = (Value)paramDataProcessor.processDataTemplate(value);
      break;
    }
    label115:
    return new EventCreate(localValue, bool);
    label125:
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
      paramObject = (EventCreate)paramObject;
      if (value == null) {
        break;
      }
    } while (value.equals(value));
    for (;;)
    {
      return false;
      if (value == null) {
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
    if (hasValue) {
      if (value._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(value._cachedId) + 9;; i = value.getSerializedSize() + 7)
    {
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (value != null) {}
    for (int i = value.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EventCreate");
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
    label238:
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
        localByteBuffer.putInt(548192314);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          if (value._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, value._cachedId);
            value.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label238;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          value.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<EventCreate>
  {
    private boolean hasValue = false;
    private EventCreate.Value value = null;
    
    public final EventCreate build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (EventCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new EventCreate(value, hasValue);
      } while (hasValue);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate", "value");
    }
    
    public final Builder setValue(EventCreate.Value paramValue)
    {
      if (paramValue == null)
      {
        hasValue = false;
        value = null;
        return this;
      }
      hasValue = true;
      value = paramValue;
      return this;
    }
  }
  
  public static final class Value
    implements FissileDataModel<Value>, UnionTemplate<Value>
  {
    public static final EventCreateBuilder.ValueBuilder BUILDER = EventCreateBuilder.ValueBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasMessageCreateValue;
    public final boolean hasParticipantChangeCreateValue;
    public final boolean hasStickerCreateValue;
    public final MessageCreate messageCreateValue;
    public final ParticipantChangeCreate participantChangeCreateValue;
    public final StickerCreate stickerCreateValue;
    
    Value(MessageCreate paramMessageCreate, ParticipantChangeCreate paramParticipantChangeCreate, StickerCreate paramStickerCreate, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      messageCreateValue = paramMessageCreate;
      participantChangeCreateValue = paramParticipantChangeCreate;
      stickerCreateValue = paramStickerCreate;
      hasMessageCreateValue = paramBoolean1;
      hasParticipantChangeCreateValue = paramBoolean2;
      hasStickerCreateValue = paramBoolean3;
      _cachedId = null;
    }
    
    public final Value accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      if (hasMessageCreateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.create.MessageCreate");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = messageCreateValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label205;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasParticipantChangeCreateValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.create.ParticipantChangeCreate");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label214;
          }
          localObject1 = participantChangeCreateValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label232;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        label106:
        localObject1 = null;
        bool3 = false;
        if (hasStickerCreateValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.create.StickerCreate");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label241;
          }
          localObject1 = stickerCreateValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label259;
          }
        }
      }
      label205:
      label214:
      label232:
      label241:
      label259:
      for (boolean bool3 = true;; bool3 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label265;
        }
        return new Value((MessageCreate)localObject2, (ParticipantChangeCreate)localObject3, (StickerCreate)localObject1, bool1, bool2, bool3);
        localObject1 = (MessageCreate)paramDataProcessor.processDataTemplate(messageCreateValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (ParticipantChangeCreate)paramDataProcessor.processDataTemplate(participantChangeCreateValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (StickerCreate)paramDataProcessor.processDataTemplate(stickerCreateValue);
        break label146;
      }
      label265:
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
        paramObject = (Value)paramObject;
        if (messageCreateValue != null)
        {
          if (messageCreateValue.equals(messageCreateValue)) {}
        }
        else {
          while (messageCreateValue != null) {
            return false;
          }
        }
        if (participantChangeCreateValue != null)
        {
          if (participantChangeCreateValue.equals(participantChangeCreateValue)) {}
        }
        else {
          while (participantChangeCreateValue != null) {
            return false;
          }
        }
        if (stickerCreateValue == null) {
          break;
        }
      } while (stickerCreateValue.equals(stickerCreateValue));
      for (;;)
      {
        return false;
        if (stickerCreateValue == null) {
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
      if (hasMessageCreateValue)
      {
        if (messageCreateValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(messageCreateValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasParticipantChangeCreateValue)
        {
          i = j + 1;
          if (participantChangeCreateValue._cachedId == null) {
            break label156;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(participantChangeCreateValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasStickerCreateValue)
        {
          i = j + 1;
          if (stickerCreateValue._cachedId == null) {
            break label169;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(stickerCreateValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = messageCreateValue.getSerializedSize() + 7;
        break;
        label156:
        i += participantChangeCreateValue.getSerializedSize();
        break label93;
        label169:
        i += stickerCreateValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      if (messageCreateValue != null)
      {
        i = messageCreateValue.hashCode();
        if (participantChangeCreateValue == null) {
          break label87;
        }
      }
      label87:
      for (int j = participantChangeCreateValue.hashCode();; j = 0)
      {
        if (stickerCreateValue != null) {
          k = stickerCreateValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Value");
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
      label358:
      label383:
      label393:
      label418:
      label426:
      label428:
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
          localByteBuffer.putInt(-1057560543);
          if (hasMessageCreateValue)
          {
            localByteBuffer.put((byte)1);
            if (messageCreateValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, messageCreateValue._cachedId);
              messageCreateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasParticipantChangeCreateValue) {
                break label383;
              }
              localByteBuffer.put((byte)1);
              if (participantChangeCreateValue._cachedId == null) {
                break label358;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, participantChangeCreateValue._cachedId);
              participantChangeCreateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasStickerCreateValue) {
                break label418;
              }
              localByteBuffer.put((byte)1);
              if (stickerCreateValue._cachedId == null) {
                break label393;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, stickerCreateValue._cachedId);
              stickerCreateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label426;
            }
            if (str != null) {
              break label428;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            messageCreateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            participantChangeCreateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            stickerCreateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    
    public static final class Builder
    {
      private boolean hasMessageCreateValue = false;
      public boolean hasParticipantChangeCreateValue = false;
      private boolean hasStickerCreateValue = false;
      private MessageCreate messageCreateValue = null;
      public ParticipantChangeCreate participantChangeCreateValue = null;
      private StickerCreate stickerCreateValue = null;
      
      public final EventCreate.Value build()
        throws BuilderException
      {
        int j = 0;
        if (hasMessageCreateValue) {
          j = 0 + 1;
        }
        int i = j;
        if (hasParticipantChangeCreateValue) {
          i = j + 1;
        }
        j = i;
        if (hasStickerCreateValue) {
          j = i + 1;
        }
        if (j > 1) {
          throw new UnionMemberCountException("Value", j);
        }
        return new EventCreate.Value(messageCreateValue, participantChangeCreateValue, stickerCreateValue, hasMessageCreateValue, hasParticipantChangeCreateValue, hasStickerCreateValue);
      }
      
      public final Builder setMessageCreateValue(MessageCreate paramMessageCreate)
      {
        if (paramMessageCreate == null)
        {
          hasMessageCreateValue = false;
          messageCreateValue = null;
          return this;
        }
        hasMessageCreateValue = true;
        messageCreateValue = paramMessageCreate;
        return this;
      }
      
      public final Builder setStickerCreateValue(StickerCreate paramStickerCreate)
      {
        if (paramStickerCreate == null)
        {
          hasStickerCreateValue = false;
          stickerCreateValue = null;
          return this;
        }
        hasStickerCreateValue = true;
        stickerCreateValue = paramStickerCreate;
        return this;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */