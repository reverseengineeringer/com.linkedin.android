package com.linkedin.android.pegasus.gen.voyager.typeahead;

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

public final class SuggestedEntity
  implements FissileDataModel<SuggestedEntity>, RecordTemplate<SuggestedEntity>
{
  public static final SuggestedEntityBuilder BUILDER = SuggestedEntityBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn backendUrn;
  public final boolean hasBackendUrn;
  public final boolean hasType;
  public final boolean hasValue;
  public final SuggestedEntityType type;
  public final String value;
  
  SuggestedEntity(SuggestedEntityType paramSuggestedEntityType, String paramString, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    type = paramSuggestedEntityType;
    value = paramString;
    backendUrn = paramUrn;
    hasType = paramBoolean1;
    hasValue = paramBoolean2;
    hasBackendUrn = paramBoolean3;
    _cachedId = null;
  }
  
  public final SuggestedEntity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      paramDataProcessor.processString(value);
    }
    if (hasBackendUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("backendUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasType) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.SuggestedEntity", "type");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new SuggestedEntity(type, value, backendUrn, hasType, hasValue, hasBackendUrn);
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
      paramObject = (SuggestedEntity)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (value != null)
      {
        if (value.equals(value)) {}
      }
      else {
        while (value != null) {
          return false;
        }
      }
      if (backendUrn == null) {
        break;
      }
    } while (backendUrn.equals(backendUrn));
    for (;;)
    {
      return false;
      if (backendUrn == null) {
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
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasValue) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(value);
    }
    j = i + 1;
    i = j;
    if (hasBackendUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (type != null)
    {
      i = type.hashCode();
      if (value == null) {
        break label87;
      }
    }
    label87:
    for (int j = value.hashCode();; j = 0)
    {
      if (backendUrn != null) {
        k = backendUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedEntity");
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
    label165:
    label242:
    label252:
    label260:
    label262:
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
        localByteBuffer.putInt(833821686);
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasValue) {
            break label242;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, value);
          if (!hasBackendUrn) {
            break label252;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label260;
          }
          if (str != null) {
            break label262;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.SuggestedEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */