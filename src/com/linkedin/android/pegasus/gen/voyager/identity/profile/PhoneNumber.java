package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PhoneNumber
  implements FissileDataModel<PhoneNumber>, RecordTemplate<PhoneNumber>
{
  public static final PhoneNumberBuilder BUILDER = PhoneNumberBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String extension;
  public final boolean hasExtension;
  public final boolean hasNumber;
  public final boolean hasType;
  public final String number;
  public final PhoneNumberType type;
  
  PhoneNumber(String paramString1, String paramString2, PhoneNumberType paramPhoneNumberType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    number = paramString1;
    extension = paramString2;
    type = paramPhoneNumberType;
    hasNumber = paramBoolean1;
    hasExtension = paramBoolean2;
    hasType = paramBoolean3;
    _cachedId = null;
  }
  
  public final PhoneNumber accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("number");
      paramDataProcessor.processString(number);
    }
    if (hasExtension)
    {
      paramDataProcessor.startRecordField$505cff1c("extension");
      paramDataProcessor.processString(extension);
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumber) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumber", "number");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new PhoneNumber(number, extension, type, hasNumber, hasExtension, hasType);
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
      paramObject = (PhoneNumber)paramObject;
      if (number != null)
      {
        if (number.equals(number)) {}
      }
      else {
        while (number != null) {
          return false;
        }
      }
      if (extension != null)
      {
        if (extension.equals(extension)) {}
      }
      else {
        while (extension != null) {
          return false;
        }
      }
      if (type == null) {
        break;
      }
    } while (type.equals(type));
    for (;;)
    {
      return false;
      if (type == null) {
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
    if (hasNumber) {
      i = PegasusBinaryUtils.getEncodedLength(number) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasExtension) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(extension);
    }
    j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2;
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
    if (number != null)
    {
      i = number.hashCode();
      if (extension == null) {
        break label87;
      }
    }
    label87:
    for (int j = extension.hashCode();; j = 0)
    {
      if (type != null) {
        k = type.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PhoneNumber");
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
    label234:
    label244:
    label252:
    label254:
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
        localByteBuffer.putInt(1290985275);
        if (hasNumber)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, number);
          if (!hasExtension) {
            break label234;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, extension);
          if (!hasType) {
            break label244;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label252;
          }
          if (str != null) {
            break label254;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
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
    implements RecordTemplateBuilder<PhoneNumber>
  {
    private String extension = null;
    private boolean hasExtension = false;
    private boolean hasNumber = false;
    private boolean hasType = false;
    private String number = null;
    private PhoneNumberType type = null;
    
    public final PhoneNumber build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PhoneNumber.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PhoneNumber(number, extension, type, hasNumber, hasExtension, hasType);
      } while (hasNumber);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumber", "number");
    }
    
    public final Builder setNumber(String paramString)
    {
      if (paramString == null)
      {
        hasNumber = false;
        number = null;
        return this;
      }
      hasNumber = true;
      number = paramString;
      return this;
    }
    
    public final Builder setType(PhoneNumberType paramPhoneNumberType)
    {
      if (paramPhoneNumberType == null)
      {
        hasType = false;
        type = null;
        return this;
      }
      hasType = true;
      type = paramPhoneNumberType;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */