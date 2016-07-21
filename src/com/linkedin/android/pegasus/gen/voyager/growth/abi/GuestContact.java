package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GuestContact
  implements FissileDataModel<GuestContact>, RecordTemplate<GuestContact>
{
  public static final GuestContactBuilder BUILDER = GuestContactBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String firstName;
  public final Handle handle;
  public final boolean hasFirstName;
  public final boolean hasHandle;
  public final boolean hasLastName;
  public final boolean hasTrackingId;
  public final String lastName;
  public final String trackingId;
  
  GuestContact(String paramString1, String paramString2, Handle paramHandle, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    firstName = paramString1;
    lastName = paramString2;
    handle = paramHandle;
    trackingId = paramString3;
    hasFirstName = paramBoolean1;
    hasLastName = paramBoolean2;
    hasHandle = paramBoolean3;
    hasTrackingId = paramBoolean4;
    _cachedId = null;
  }
  
  public final GuestContact accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFirstName)
    {
      paramDataProcessor.startRecordField$505cff1c("firstName");
      paramDataProcessor.processString(firstName);
    }
    if (hasLastName)
    {
      paramDataProcessor.startRecordField$505cff1c("lastName");
      paramDataProcessor.processString(lastName);
    }
    Handle localHandle = null;
    boolean bool = false;
    if (hasHandle)
    {
      paramDataProcessor.startRecordField$505cff1c("handle");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label168;
      }
      localHandle = handle.accept(paramDataProcessor);
      if (localHandle == null) {
        break label185;
      }
    }
    label168:
    label185:
    for (bool = true;; bool = false)
    {
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label224;
      }
      try
      {
        if (hasHandle) {
          break label190;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact", "handle");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localHandle = (Handle)paramDataProcessor.processDataTemplate(handle);
      break;
    }
    label190:
    return new GuestContact(firstName, lastName, localHandle, trackingId, hasFirstName, hasLastName, bool, hasTrackingId);
    label224:
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
      paramObject = (GuestContact)paramObject;
      if (firstName != null)
      {
        if (firstName.equals(firstName)) {}
      }
      else {
        while (firstName != null) {
          return false;
        }
      }
      if (lastName != null)
      {
        if (lastName.equals(lastName)) {}
      }
      else {
        while (lastName != null) {
          return false;
        }
      }
      if (handle != null)
      {
        if (handle.equals(handle)) {}
      }
      else {
        while (handle != null) {
          return false;
        }
      }
      if (trackingId == null) {
        break;
      }
    } while (trackingId.equals(trackingId));
    for (;;)
    {
      return false;
      if (trackingId == null) {
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
    if (hasFirstName) {
      i = PegasusBinaryUtils.getEncodedLength(firstName) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasLastName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(lastName);
    }
    j = i + 1;
    i = j;
    if (hasHandle)
    {
      i = j + 1;
      if (handle._cachedId == null) {
        break label137;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(handle._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      __sizeOfObject = i;
      return i;
      label137:
      i += handle.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (firstName != null)
    {
      i = firstName.hashCode();
      if (lastName == null) {
        break label110;
      }
      j = lastName.hashCode();
      label45:
      if (handle == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = handle.hashCode();; k = 0)
    {
      if (trackingId != null) {
        m = trackingId.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building GuestContact");
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
    label162:
    label222:
    label291:
    label301:
    label326:
    label336:
    label344:
    label346:
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
        localByteBuffer.putInt(375858800);
        if (hasFirstName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, firstName);
          if (!hasLastName) {
            break label291;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, lastName);
          if (!hasHandle) {
            break label326;
          }
          localByteBuffer.put((byte)1);
          if (handle._cachedId == null) {
            break label301;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, handle._cachedId);
          handle.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTrackingId) {
            break label336;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label344;
          }
          if (str != null) {
            break label346;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)1);
          handle.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label222;
          localByteBuffer.put((byte)0);
          break label222;
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
  
  public static final class Handle
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
    
    Handle(String paramString, PhoneNumber paramPhoneNumber, boolean paramBoolean1, boolean paramBoolean2)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */