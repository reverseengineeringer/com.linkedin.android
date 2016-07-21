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

public final class Email
  implements FissileDataModel<Email>, RecordTemplate<Email>
{
  public static final EmailBuilder BUILDER = EmailBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String emailAddress;
  public final boolean hasEmailAddress;
  public final boolean hasPrimary;
  public final boolean hasType;
  public final boolean primary;
  public final String type;
  
  Email(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    emailAddress = paramString1;
    primary = paramBoolean1;
    type = paramString2;
    hasEmailAddress = paramBoolean2;
    hasPrimary = paramBoolean3;
    hasType = paramBoolean4;
    _cachedId = null;
  }
  
  public final Email accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEmailAddress)
    {
      paramDataProcessor.startRecordField$505cff1c("emailAddress");
      paramDataProcessor.processString(emailAddress);
    }
    if (hasPrimary)
    {
      paramDataProcessor.startRecordField$505cff1c("primary");
      paramDataProcessor.processBoolean(primary);
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processString(type);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEmailAddress) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.Email", "emailAddress");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new Email(emailAddress, primary, type, hasEmailAddress, hasPrimary, hasType);
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
      paramObject = (Email)paramObject;
      if (emailAddress != null)
      {
        if (emailAddress.equals(emailAddress)) {}
      }
      else {
        while (emailAddress != null) {
          return false;
        }
      }
      if (primary != primary) {
        return false;
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
    if (hasEmailAddress) {
      i = PegasusBinaryUtils.getEncodedLength(emailAddress) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasPrimary) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(type);
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
    if (emailAddress != null)
    {
      i = emailAddress.hashCode();
      if (!primary) {
        break label81;
      }
    }
    label81:
    for (int j = 1;; j = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Email");
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
    label160:
    label169:
    label238:
    label244:
    label254:
    label262:
    label264:
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
        localByteBuffer.putInt(-122837850);
        if (hasEmailAddress)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, emailAddress);
          if (!hasPrimary) {
            break label244;
          }
          localByteBuffer.put((byte)1);
          if (!primary) {
            break label238;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasType) {
            break label254;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, type);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label262;
          }
          if (str != null) {
            break label264;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label160;
          localByteBuffer.put((byte)0);
          break label169;
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
    implements RecordTemplateBuilder<Email>
  {
    public String emailAddress = null;
    public boolean hasEmailAddress = false;
    public boolean hasPrimary = false;
    public boolean hasType = false;
    public boolean primary = false;
    public String type = null;
    
    public final Email build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Email.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Email(emailAddress, primary, type, hasEmailAddress, hasPrimary, hasType);
        if (!hasPrimary) {
          primary = false;
        }
      } while (hasEmailAddress);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.Email", "emailAddress");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.Email
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */