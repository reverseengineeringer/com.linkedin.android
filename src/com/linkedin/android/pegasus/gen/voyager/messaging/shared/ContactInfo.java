package com.linkedin.android.pegasus.gen.voyager.messaging.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ContactInfo
  implements FissileDataModel<ContactInfo>, RecordTemplate<ContactInfo>
{
  public static final ContactInfoBuilder BUILDER = ContactInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String email;
  public final boolean hasEmail;
  public final boolean hasPhoneNumber;
  public final PhoneNumber phoneNumber;
  
  ContactInfo(String paramString, PhoneNumber paramPhoneNumber, boolean paramBoolean1, boolean paramBoolean2)
  {
    email = paramString;
    phoneNumber = paramPhoneNumber;
    hasEmail = paramBoolean1;
    hasPhoneNumber = paramBoolean2;
    _cachedId = null;
  }
  
  public final ContactInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEmail)
    {
      paramDataProcessor.startRecordField$505cff1c("email");
      paramDataProcessor.processString(email);
    }
    PhoneNumber localPhoneNumber = null;
    boolean bool = false;
    if (hasPhoneNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("phoneNumber");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label107;
      }
      localPhoneNumber = phoneNumber.accept(paramDataProcessor);
      if (localPhoneNumber == null) {
        break label124;
      }
    }
    label107:
    label124:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label129;
      }
      return new ContactInfo(email, localPhoneNumber, hasEmail, bool);
      localPhoneNumber = (PhoneNumber)paramDataProcessor.processDataTemplate(phoneNumber);
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
      paramObject = (ContactInfo)paramObject;
      if (email != null)
      {
        if (email.equals(email)) {}
      }
      else {
        while (email != null) {
          return false;
        }
      }
      if (phoneNumber == null) {
        break;
      }
    } while (phoneNumber.equals(phoneNumber));
    for (;;)
    {
      return false;
      if (phoneNumber == null) {
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
    if (hasEmail) {
      i = PegasusBinaryUtils.getEncodedLength(email) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasPhoneNumber)
    {
      i = j + 1;
      if (phoneNumber._cachedId == null) {
        break label87;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(phoneNumber._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label87:
      i += phoneNumber.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (email != null) {}
    for (int i = email.hashCode();; i = 0)
    {
      if (phoneNumber != null) {
        j = phoneNumber.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ContactInfo");
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
        localByteBuffer.putInt(870452741);
        if (hasEmail)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, email);
          if (!hasPhoneNumber) {
            break label264;
          }
          localByteBuffer.put((byte)1);
          if (phoneNumber._cachedId == null) {
            break label239;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, phoneNumber._cachedId);
          phoneNumber.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          phoneNumber.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */