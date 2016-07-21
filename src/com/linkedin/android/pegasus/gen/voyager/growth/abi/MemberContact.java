package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MemberContact
  implements FissileDataModel<MemberContact>, RecordTemplate<MemberContact>
{
  public static final MemberContactBuilder BUILDER = MemberContactBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Handle handle;
  public final boolean hasHandle;
  public final boolean hasMiniProfile;
  public final boolean hasTrackingId;
  public final MiniProfile miniProfile;
  public final String trackingId;
  
  MemberContact(MiniProfile paramMiniProfile, Handle paramHandle, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    miniProfile = paramMiniProfile;
    handle = paramHandle;
    trackingId = paramString;
    hasMiniProfile = paramBoolean1;
    hasHandle = paramBoolean2;
    hasTrackingId = paramBoolean3;
    _cachedId = null;
  }
  
  public final MemberContact accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label189;
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
      if (hasHandle)
      {
        paramDataProcessor.startRecordField$505cff1c("handle");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label198;
        }
        localObject1 = handle.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label216;
        }
      }
    }
    label189:
    label198:
    label216:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label243;
      }
      try
      {
        if (hasMiniProfile) {
          break label221;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (Handle)paramDataProcessor.processDataTemplate(handle);
      break label95;
    }
    label221:
    return new MemberContact((MiniProfile)localObject2, (Handle)localObject1, trackingId, bool1, bool2, hasTrackingId);
    label243:
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
      paramObject = (MemberContact)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
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
    int j;
    if (hasMiniProfile)
    {
      if (miniProfile._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasHandle)
      {
        i = j + 1;
        if (handle._cachedId == null) {
          break label139;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(handle._cachedId);
      }
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
      i = miniProfile.getSerializedSize() + 7;
      break;
      label139:
      i += handle.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (handle == null) {
        break label87;
      }
    }
    label87:
    for (int j = handle.hashCode();; j = 0)
    {
      if (trackingId != null) {
        k = trackingId.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MemberContact");
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
    label324:
    label349:
    label359:
    label367:
    label369:
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
        localByteBuffer.putInt(-852983735);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHandle) {
              break label349;
            }
            localByteBuffer.put((byte)1);
            if (handle._cachedId == null) {
              break label324;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, handle._cachedId);
            handle.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTrackingId) {
              break label359;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, trackingId);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label367;
          }
          if (str != null) {
            break label369;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          handle.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
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
    public static final MemberContactBuilder.HandleBuilder BUILDER = MemberContactBuilder.HandleBuilder.INSTANCE;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */