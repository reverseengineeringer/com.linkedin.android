package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

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
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class WvmpCard
  implements FissileDataModel<WvmpCard>, RecordTemplate<WvmpCard>
{
  public static final WvmpCardBuilder BUILDER = WvmpCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasTrackingId;
  public final boolean hasValue;
  public final String trackingId;
  public final Value value;
  
  WvmpCard(Value paramValue, String paramString, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    value = paramValue;
    trackingId = paramString;
    entityUrn = paramUrn;
    hasValue = paramBoolean1;
    hasTrackingId = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    paramValue = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private WvmpCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Value localValue = null;
    boolean bool = false;
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label151;
      }
      localValue = value.accept(paramDataProcessor);
      if (localValue == null) {
        break label168;
      }
    }
    label151:
    label168:
    for (bool = true;; bool = false)
    {
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      if (hasEntityUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("entityUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label237;
      }
      try
      {
        if (hasValue) {
          break label173;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCard", "value");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localValue = (Value)paramDataProcessor.processDataTemplate(value);
      break;
    }
    label173:
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCard", "trackingId");
    }
    if (!hasEntityUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCard", "entityUrn");
    }
    return new WvmpCard(localValue, trackingId, entityUrn, bool, hasTrackingId, hasEntityUrn);
    label237:
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
      paramObject = (WvmpCard)paramObject;
      if (value != null)
      {
        if (value.equals(value)) {}
      }
      else {
        while (value != null) {
          return false;
        }
      }
      if (entityUrn == null) {
        break;
      }
    } while (entityUrn.equals(entityUrn));
    for (;;)
    {
      return false;
      if (entityUrn == null) {
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
        break label115;
      }
    }
    label115:
    for (i = PegasusBinaryUtils.getEncodedLength(value._cachedId) + 9;; i = value.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      j = i + 1;
      i = j;
      if (hasEntityUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (value != null) {}
    for (int i = value.hashCode();; i = 0)
    {
      if (entityUrn != null) {
        j = entityUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpCard");
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
    label196:
    label298:
    label308:
    label316:
    label318:
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
        localByteBuffer.putInt(-2001760536);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          if (value._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, value._cachedId);
            value.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTrackingId) {
              break label298;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, trackingId);
            if (!hasEntityUrn) {
              break label308;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label316;
          }
          if (str != null) {
            break label318;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          value.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label196;
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
  
  public static final class Value
    implements FissileDataModel<Value>, UnionTemplate<Value>
  {
    public static final WvmpCardBuilder.ValueBuilder BUILDER = WvmpCardBuilder.ValueBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasWvmpViewersCardValue;
    public final WvmpViewersCard wvmpViewersCardValue;
    
    Value(WvmpViewersCard paramWvmpViewersCard, boolean paramBoolean)
    {
      wvmpViewersCardValue = paramWvmpViewersCard;
      hasWvmpViewersCardValue = paramBoolean;
      _cachedId = null;
    }
    
    public final Value accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      WvmpViewersCard localWvmpViewersCard = null;
      boolean bool = false;
      if (hasWvmpViewersCardValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.wvmpOverview.WvmpViewersCard");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label74;
        }
        localWvmpViewersCard = wvmpViewersCardValue.accept(paramDataProcessor);
        if (localWvmpViewersCard == null) {
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
        return new Value(localWvmpViewersCard, bool);
        localWvmpViewersCard = (WvmpViewersCard)paramDataProcessor.processDataTemplate(wvmpViewersCardValue);
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
        paramObject = (Value)paramObject;
        if (wvmpViewersCardValue == null) {
          break;
        }
      } while (wvmpViewersCardValue.equals(wvmpViewersCardValue));
      for (;;)
      {
        return false;
        if (wvmpViewersCardValue == null) {
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
      if (hasWvmpViewersCardValue) {
        if (wvmpViewersCardValue._cachedId == null) {
          break label58;
        }
      }
      label58:
      for (i = PegasusBinaryUtils.getEncodedLength(wvmpViewersCardValue._cachedId) + 9;; i = wvmpViewersCardValue.getSerializedSize() + 7)
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
      if (wvmpViewersCardValue != null) {}
      for (int i = wvmpViewersCardValue.hashCode();; i = 0)
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
          localByteBuffer.putInt(118827950);
          if (hasWvmpViewersCardValue)
          {
            localByteBuffer.put((byte)1);
            if (wvmpViewersCardValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, wvmpViewersCardValue._cachedId);
              wvmpViewersCardValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            wvmpViewersCardValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */