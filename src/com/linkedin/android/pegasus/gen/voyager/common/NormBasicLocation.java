package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class NormBasicLocation
  implements FissileDataModel<NormBasicLocation>, RecordTemplate<NormBasicLocation>
{
  public static final NormBasicLocationBuilder BUILDER = NormBasicLocationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String countryCode;
  public final boolean hasCountryCode;
  public final boolean hasPostalCode;
  public final String postalCode;
  
  NormBasicLocation(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    countryCode = paramString1;
    postalCode = paramString2;
    hasCountryCode = paramBoolean1;
    hasPostalCode = paramBoolean2;
    _cachedId = null;
  }
  
  public final NormBasicLocation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCountryCode)
    {
      paramDataProcessor.startRecordField$505cff1c("countryCode");
      paramDataProcessor.processString(countryCode);
    }
    if (hasPostalCode)
    {
      paramDataProcessor.startRecordField$505cff1c("postalCode");
      paramDataProcessor.processString(postalCode);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasCountryCode) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.NormBasicLocation", "countryCode");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new NormBasicLocation(countryCode, postalCode, hasCountryCode, hasPostalCode);
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
      paramObject = (NormBasicLocation)paramObject;
      if (countryCode != null)
      {
        if (countryCode.equals(countryCode)) {}
      }
      else {
        while (countryCode != null) {
          return false;
        }
      }
      if (postalCode == null) {
        break;
      }
    } while (postalCode.equals(postalCode));
    for (;;)
    {
      return false;
      if (postalCode == null) {
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
    if (hasCountryCode) {
      i = PegasusBinaryUtils.getEncodedLength(countryCode) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasPostalCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(postalCode);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (countryCode != null) {}
    for (int i = countryCode.hashCode();; i = 0)
    {
      if (postalCode != null) {
        j = postalCode.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormBasicLocation");
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
    label205:
    label213:
    label215:
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
        localByteBuffer.putInt(-1609927665);
        if (hasCountryCode)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, countryCode);
          if (!hasPostalCode) {
            break label205;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, postalCode);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label213;
          }
          if (str != null) {
            break label215;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
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
    implements RecordTemplateBuilder<NormBasicLocation>
  {
    private String countryCode = null;
    private boolean hasCountryCode = false;
    private boolean hasPostalCode = false;
    private String postalCode = null;
    
    public final NormBasicLocation build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormBasicLocation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NormBasicLocation(countryCode, postalCode, hasCountryCode, hasPostalCode);
      } while (hasCountryCode);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.NormBasicLocation", "countryCode");
    }
    
    public final Builder setCountryCode(String paramString)
    {
      if (paramString == null)
      {
        hasCountryCode = false;
        countryCode = null;
        return this;
      }
      hasCountryCode = true;
      countryCode = paramString;
      return this;
    }
    
    public final Builder setPostalCode(String paramString)
    {
      if (paramString == null)
      {
        hasPostalCode = false;
        postalCode = null;
        return this;
      }
      hasPostalCode = true;
      postalCode = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.NormBasicLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */