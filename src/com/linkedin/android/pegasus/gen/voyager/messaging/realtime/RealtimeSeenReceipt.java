package com.linkedin.android.pegasus.gen.voyager.messaging.realtime;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.messaging.MessagingProfileEntity;
import com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceipt;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RealtimeSeenReceipt
  implements FissileDataModel<RealtimeSeenReceipt>, RecordTemplate<RealtimeSeenReceipt>
{
  public static final RealtimeSeenReceiptBuilder BUILDER = RealtimeSeenReceiptBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final MessagingProfileEntity fromParticipant;
  public final boolean hasFromParticipant;
  public final boolean hasSeenReceipt;
  public final SeenReceipt seenReceipt;
  
  RealtimeSeenReceipt(MessagingProfileEntity paramMessagingProfileEntity, SeenReceipt paramSeenReceipt, boolean paramBoolean1, boolean paramBoolean2)
  {
    fromParticipant = paramMessagingProfileEntity;
    seenReceipt = paramSeenReceipt;
    hasFromParticipant = paramBoolean1;
    hasSeenReceipt = paramBoolean2;
    _cachedId = null;
  }
  
  private RealtimeSeenReceipt accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasFromParticipant)
    {
      paramDataProcessor.startRecordField$505cff1c("fromParticipant");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = fromParticipant.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label164;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasSeenReceipt)
      {
        paramDataProcessor.startRecordField$505cff1c("seenReceipt");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label173;
        }
        localObject1 = seenReceipt.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label191;
        }
      }
    }
    label164:
    label173:
    label191:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label229;
      }
      try
      {
        if (hasFromParticipant) {
          break label196;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeSeenReceipt", "fromParticipant");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MessagingProfileEntity)paramDataProcessor.processDataTemplate(fromParticipant);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (SeenReceipt)paramDataProcessor.processDataTemplate(seenReceipt);
      break label95;
    }
    label196:
    if (!hasSeenReceipt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeSeenReceipt", "seenReceipt");
    }
    return new RealtimeSeenReceipt((MessagingProfileEntity)localObject2, (SeenReceipt)localObject1, bool1, bool2);
    label229:
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
      paramObject = (RealtimeSeenReceipt)paramObject;
      if (fromParticipant != null)
      {
        if (fromParticipant.equals(fromParticipant)) {}
      }
      else {
        while (fromParticipant != null) {
          return false;
        }
      }
      if (seenReceipt == null) {
        break;
      }
    } while (seenReceipt.equals(seenReceipt));
    for (;;)
    {
      return false;
      if (seenReceipt == null) {
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
    if (hasFromParticipant)
    {
      if (fromParticipant._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(fromParticipant._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasSeenReceipt)
      {
        i = j + 1;
        if (seenReceipt._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(seenReceipt._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = fromParticipant.getSerializedSize() + 7;
      break;
      label114:
      i += seenReceipt.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (fromParticipant != null) {}
    for (int i = fromParticipant.hashCode();; i = 0)
    {
      if (seenReceipt != null) {
        j = seenReceipt.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RealtimeSeenReceipt");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(-525838008);
        if (hasFromParticipant)
        {
          localByteBuffer.put((byte)1);
          if (fromParticipant._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, fromParticipant._cachedId);
            fromParticipant.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSeenReceipt) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (seenReceipt._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, seenReceipt._cachedId);
            seenReceipt.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          fromParticipant.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          seenReceipt.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeSeenReceipt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */