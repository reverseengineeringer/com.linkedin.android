package com.linkedin.android.pegasus.gen.voyager.messaging;

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

public final class SeenReceipt
  implements FissileDataModel<SeenReceipt>, RecordTemplate<SeenReceipt>
{
  public static final SeenReceiptBuilder BUILDER = SeenReceiptBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn eventUrn;
  public final boolean hasEventUrn;
  public final boolean hasSeenAt;
  public final long seenAt;
  
  SeenReceipt(Urn paramUrn, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    eventUrn = paramUrn;
    seenAt = paramLong;
    hasEventUrn = paramBoolean1;
    hasSeenAt = paramBoolean2;
    _cachedId = null;
  }
  
  public final SeenReceipt accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEventUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("eventUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(eventUrn));
    }
    if (hasSeenAt)
    {
      paramDataProcessor.startRecordField$505cff1c("seenAt");
      paramDataProcessor.processLong(seenAt);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEventUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceipt", "eventUrn");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasSeenAt) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceipt", "seenAt");
      }
      return new SeenReceipt(eventUrn, seenAt, hasEventUrn, hasSeenAt);
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
      paramObject = (SeenReceipt)paramObject;
      if (eventUrn != null)
      {
        if (eventUrn.equals(eventUrn)) {}
      }
      else {
        while (eventUrn != null) {
          return false;
        }
      }
    } while (seenAt == seenAt);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEventUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(eventUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSeenAt) {
      i = j + 8;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (eventUrn != null) {}
    for (int i = eventUrn.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + (int)(seenAt ^ seenAt >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SeenReceipt");
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
    label211:
    label219:
    label221:
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
        localByteBuffer.putInt(714444453);
        if (hasEventUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(eventUrn));
          if (!hasSeenAt) {
            break label211;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(seenAt);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label219;
          }
          if (str != null) {
            break label221;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceipt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */