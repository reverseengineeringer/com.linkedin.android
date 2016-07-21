package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GuestContact$Handle
  implements FissileDataModel<Handle>, UnionTemplate<Handle>
{
  public static final GuestContactBuilder.HandleBuilder BUILDER = GuestContactBuilder.HandleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasPhoneNumberValue;
  public final boolean hasStringValue;
  public final PhoneNumber phoneNumberValue;
  public final String stringValue;
  
  GuestContact$Handle(String paramString, PhoneNumber paramPhoneNumber, boolean paramBoolean1, boolean paramBoolean2)
  {
    stringValue = paramString;
    phoneNumberValue = paramPhoneNumber;
    hasStringValue = paramBoolean1;
    hasPhoneNumberValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final Handle accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    if (hasStringValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("string");
      paramDataProcessor.processString(stringValue);
    }
    PhoneNumber localPhoneNumber = null;
    boolean bool = false;
    if (hasPhoneNumberValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.common.PhoneNumber");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label107;
      }
      localPhoneNumber = phoneNumberValue.accept(paramDataProcessor);
      if (localPhoneNumber == null) {
        break label124;
      }
    }
    label107:
    label124:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label129;
      }
      return new Handle(stringValue, localPhoneNumber, hasStringValue, bool);
      localPhoneNumber = (PhoneNumber)paramDataProcessor.processDataTemplate(phoneNumberValue);
      break;
    }
    label129:
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
      paramObject = (Handle)paramObject;
      if (stringValue != null)
      {
        if (stringValue.equals(stringValue)) {}
      }
      else {
        while (stringValue != null) {
          return false;
        }
      }
      if (phoneNumberValue == null) {
        break;
      }
    } while (phoneNumberValue.equals(phoneNumberValue));
    for (;;)
    {
      return false;
      if (phoneNumberValue == null) {
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
    if (hasStringValue) {
      i = PegasusBinaryUtils.getEncodedLength(stringValue) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasPhoneNumberValue)
    {
      i = j + 1;
      if (phoneNumberValue._cachedId == null) {
        break label87;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(phoneNumberValue._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label87:
      i += phoneNumberValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (stringValue != null) {}
    for (int i = stringValue.hashCode();; i = 0)
    {
      if (phoneNumberValue != null) {
        j = phoneNumberValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Handle");
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
    label239:
    label264:
    label272:
    label274:
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
        localByteBuffer.putInt(216059969);
        if (hasStringValue)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, stringValue);
          if (!hasPhoneNumberValue) {
            break label264;
          }
          localByteBuffer.put((byte)1);
          if (phoneNumberValue._cachedId == null) {
            break label239;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, phoneNumberValue._cachedId);
          phoneNumberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label272;
          }
          if (str != null) {
            break label274;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          phoneNumberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact.Handle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */