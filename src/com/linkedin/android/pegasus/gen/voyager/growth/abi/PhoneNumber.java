package com.linkedin.android.pegasus.gen.voyager.growth.abi;

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
  public final boolean hasPrimary;
  public final boolean hasType;
  public final String number;
  public final boolean primary;
  public final String type;
  
  PhoneNumber(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    number = paramString1;
    extension = paramString2;
    type = paramString3;
    primary = paramBoolean1;
    hasNumber = paramBoolean2;
    hasExtension = paramBoolean3;
    hasType = paramBoolean4;
    hasPrimary = paramBoolean5;
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
      paramDataProcessor.processString(type);
    }
    if (hasPrimary)
    {
      paramDataProcessor.startRecordField$505cff1c("primary");
      paramDataProcessor.processBoolean(primary);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumber) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber", "number");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new PhoneNumber(number, extension, type, primary, hasNumber, hasExtension, hasType, hasPrimary);
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
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
    } while (primary == primary);
    return false;
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
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(type);
    }
    j = i + 1;
    i = j;
    if (hasPrimary) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (number != null)
    {
      i = number.hashCode();
      if (extension == null) {
        break label104;
      }
      j = extension.hashCode();
      label45:
      if (type == null) {
        break label109;
      }
    }
    label104:
    label109:
    for (int k = type.hashCode();; k = 0)
    {
      if (primary) {
        m = 1;
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
    int i = 1;
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
    label165:
    label191:
    label212:
    label264:
    label274:
    label284:
    label290:
    label298:
    label300:
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
        localByteBuffer.putInt(1652141165);
        if (hasNumber)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, number);
          if (!hasExtension) {
            break label264;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, extension);
          if (!hasType) {
            break label274;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, type);
          if (!hasPrimary) {
            break label290;
          }
          localByteBuffer.put((byte)1);
          if (!primary) {
            break label284;
          }
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label298;
          }
          if (str != null) {
            break label300;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
          localByteBuffer.put((byte)0);
          break label191;
          i = 0;
          break label212;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    i = PegasusBinaryUtils.getEncodedLength(str) + 3;
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
    public boolean hasNumber = false;
    public boolean hasPrimary = false;
    public boolean hasType = false;
    public String number = null;
    public boolean primary = false;
    public String type = null;
    
    public final PhoneNumber build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PhoneNumber.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PhoneNumber(number, extension, type, primary, hasNumber, hasExtension, hasType, hasPrimary);
        if (!hasPrimary) {
          primary = false;
        }
      } while (hasNumber);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber", "number");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */