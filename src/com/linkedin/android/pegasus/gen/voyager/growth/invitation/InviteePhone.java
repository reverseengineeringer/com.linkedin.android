package com.linkedin.android.pegasus.gen.voyager.growth.invitation;

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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InviteePhone
  implements FissileDataModel<InviteePhone>, RecordTemplate<InviteePhone>
{
  public static final InviteePhoneBuilder BUILDER = InviteePhoneBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String firstName;
  public final boolean hasFirstName;
  public final boolean hasLastName;
  public final boolean hasPhoneNumber;
  public final String lastName;
  public final PhoneNumber phoneNumber;
  
  InviteePhone(PhoneNumber paramPhoneNumber, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    phoneNumber = paramPhoneNumber;
    firstName = paramString1;
    lastName = paramString2;
    hasPhoneNumber = paramBoolean1;
    hasFirstName = paramBoolean2;
    hasLastName = paramBoolean3;
    _cachedId = null;
  }
  
  public final InviteePhone accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    PhoneNumber localPhoneNumber = null;
    boolean bool = false;
    if (hasPhoneNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("phoneNumber");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localPhoneNumber = phoneNumber.accept(paramDataProcessor);
      if (localPhoneNumber == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
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
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label191;
      }
      try
      {
        if (hasPhoneNumber) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteePhone", "phoneNumber");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localPhoneNumber = (PhoneNumber)paramDataProcessor.processDataTemplate(phoneNumber);
      break;
    }
    label165:
    return new InviteePhone(localPhoneNumber, firstName, lastName, bool, hasFirstName, hasLastName);
    label191:
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
      paramObject = (InviteePhone)paramObject;
      if (phoneNumber != null)
      {
        if (phoneNumber.equals(phoneNumber)) {}
      }
      else {
        while (phoneNumber != null) {
          return false;
        }
      }
      if (firstName != null)
      {
        if (firstName.equals(firstName)) {}
      }
      else {
        while (firstName != null) {
          return false;
        }
      }
      if (lastName == null) {
        break;
      }
    } while (lastName.equals(lastName));
    for (;;)
    {
      return false;
      if (lastName == null) {
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
    if (hasPhoneNumber) {
      if (phoneNumber._cachedId == null) {
        break label108;
      }
    }
    label108:
    for (i = PegasusBinaryUtils.getEncodedLength(phoneNumber._cachedId) + 9;; i = phoneNumber.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasFirstName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(firstName);
      }
      j = i + 1;
      i = j;
      if (hasLastName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(lastName);
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (phoneNumber != null)
    {
      i = phoneNumber.hashCode();
      if (firstName == null) {
        break label87;
      }
    }
    label87:
    for (int j = firstName.hashCode();; j = 0)
    {
      if (lastName != null) {
        k = lastName.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InviteePhone");
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
    label290:
    label300:
    label308:
    label310:
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
        localByteBuffer.putInt(608041450);
        if (hasPhoneNumber)
        {
          localByteBuffer.put((byte)1);
          if (phoneNumber._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, phoneNumber._cachedId);
            phoneNumber.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasFirstName) {
              break label290;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, firstName);
            if (!hasLastName) {
              break label300;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, lastName);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label308;
          }
          if (str != null) {
            break label310;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          phoneNumber.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<InviteePhone>
  {
    public String firstName = null;
    public boolean hasFirstName = false;
    public boolean hasLastName = false;
    private boolean hasPhoneNumber = false;
    public String lastName = null;
    private PhoneNumber phoneNumber = null;
    
    public final InviteePhone build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (InviteePhone.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new InviteePhone(phoneNumber, firstName, lastName, hasPhoneNumber, hasFirstName, hasLastName);
      } while (hasPhoneNumber);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteePhone", "phoneNumber");
    }
    
    public final Builder setPhoneNumber(PhoneNumber paramPhoneNumber)
    {
      if (paramPhoneNumber == null)
      {
        hasPhoneNumber = false;
        phoneNumber = null;
        return this;
      }
      hasPhoneNumber = true;
      phoneNumber = paramPhoneNumber;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteePhone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */