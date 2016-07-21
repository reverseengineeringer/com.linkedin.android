package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ReconnectionEntity
  implements FissileDataModel<ReconnectionEntity>, RecordTemplate<ReconnectionEntity>
{
  public static final ReconnectionEntityBuilder BUILDER = ReconnectionEntityBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ConcreteEntity concreteEntity;
  public final boolean hasConcreteEntity;
  
  ReconnectionEntity(ConcreteEntity paramConcreteEntity, boolean paramBoolean)
  {
    concreteEntity = paramConcreteEntity;
    hasConcreteEntity = paramBoolean;
    _cachedId = null;
  }
  
  public final ReconnectionEntity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    ConcreteEntity localConcreteEntity = null;
    boolean bool = false;
    if (hasConcreteEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("concreteEntity");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label93;
      }
      localConcreteEntity = concreteEntity.accept(paramDataProcessor);
      if (localConcreteEntity == null) {
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
        if (hasConcreteEntity) {
          break label115;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionEntity", "concreteEntity");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localConcreteEntity = (ConcreteEntity)paramDataProcessor.processDataTemplate(concreteEntity);
      break;
    }
    label115:
    return new ReconnectionEntity(localConcreteEntity, bool);
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
      paramObject = (ReconnectionEntity)paramObject;
      if (concreteEntity == null) {
        break;
      }
    } while (concreteEntity.equals(concreteEntity));
    for (;;)
    {
      return false;
      if (concreteEntity == null) {
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
    if (hasConcreteEntity) {
      if (concreteEntity._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(concreteEntity._cachedId) + 9;; i = concreteEntity.getSerializedSize() + 7)
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
    if (concreteEntity != null) {}
    for (int i = concreteEntity.hashCode();; i = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ReconnectionEntity");
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
        localByteBuffer.putInt(1515186802);
        if (hasConcreteEntity)
        {
          localByteBuffer.put((byte)1);
          if (concreteEntity._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, concreteEntity._cachedId);
            concreteEntity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          concreteEntity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class ConcreteEntity
    implements FissileDataModel<ConcreteEntity>, UnionTemplate<ConcreteEntity>
  {
    public static final ReconnectionEntityBuilder.ConcreteEntityBuilder BUILDER = ReconnectionEntityBuilder.ConcreteEntityBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasReconnectionMemberValue;
    public final ReconnectionMember reconnectionMemberValue;
    
    ConcreteEntity(ReconnectionMember paramReconnectionMember, boolean paramBoolean)
    {
      reconnectionMemberValue = paramReconnectionMember;
      hasReconnectionMemberValue = paramBoolean;
      _cachedId = null;
    }
    
    public final ConcreteEntity accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      ReconnectionMember localReconnectionMember = null;
      boolean bool = false;
      if (hasReconnectionMemberValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.peripheral.reconnect.ReconnectionMember");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label74;
        }
        localReconnectionMember = reconnectionMemberValue.accept(paramDataProcessor);
        if (localReconnectionMember == null) {
          break label91;
        }
      }
      label74:
      label91:
      for (bool = true;; bool = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label96;
        }
        return new ConcreteEntity(localReconnectionMember, bool);
        localReconnectionMember = (ReconnectionMember)paramDataProcessor.processDataTemplate(reconnectionMemberValue);
        break;
      }
      label96:
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
        paramObject = (ConcreteEntity)paramObject;
        if (reconnectionMemberValue == null) {
          break;
        }
      } while (reconnectionMemberValue.equals(reconnectionMemberValue));
      for (;;)
      {
        return false;
        if (reconnectionMemberValue == null) {
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
      if (hasReconnectionMemberValue) {
        if (reconnectionMemberValue._cachedId == null) {
          break label58;
        }
      }
      label58:
      for (i = PegasusBinaryUtils.getEncodedLength(reconnectionMemberValue._cachedId) + 9;; i = reconnectionMemberValue.getSerializedSize() + 7)
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
      if (reconnectionMemberValue != null) {}
      for (int i = reconnectionMemberValue.hashCode();; i = 0)
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ConcreteEntity");
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
          localByteBuffer.putInt(647652952);
          if (hasReconnectionMemberValue)
          {
            localByteBuffer.put((byte)1);
            if (reconnectionMemberValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, reconnectionMemberValue._cachedId);
              reconnectionMemberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            reconnectionMemberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.reconnect.ReconnectionEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */