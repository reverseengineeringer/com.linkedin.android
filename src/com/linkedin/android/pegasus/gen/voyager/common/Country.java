package com.linkedin.android.pegasus.gen.voyager.common;

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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Country
  implements FissileDataModel<Country>, RecordTemplate<Country>
{
  public static final CountryBuilder BUILDER = CountryBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String countryCode;
  public final String countryName;
  public final Urn entityUrn;
  public final boolean hasCountryCode;
  public final boolean hasCountryName;
  public final boolean hasEntityUrn;
  
  Country(Urn paramUrn, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entityUrn = paramUrn;
    countryCode = paramString1;
    countryName = paramString2;
    hasEntityUrn = paramBoolean1;
    hasCountryCode = paramBoolean2;
    hasCountryName = paramBoolean3;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private Country accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasCountryCode)
    {
      paramDataProcessor.startRecordField$505cff1c("countryCode");
      paramDataProcessor.processString(countryCode);
    }
    if (hasCountryName)
    {
      paramDataProcessor.startRecordField$505cff1c("countryName");
      paramDataProcessor.processString(countryName);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasCountryCode) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Country", "countryCode");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCountryName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Country", "countryName");
      }
      return new Country(entityUrn, countryCode, countryName, hasEntityUrn, hasCountryCode, hasCountryName);
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
      paramObject = (Country)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (countryCode != null)
      {
        if (countryCode.equals(countryCode)) {}
      }
      else {
        while (countryCode != null) {
          return false;
        }
      }
      if (countryName == null) {
        break;
      }
    } while (countryName.equals(countryName));
    for (;;)
    {
      return false;
      if (countryName == null) {
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
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCountryCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(countryCode);
    }
    j = i + 1;
    i = j;
    if (hasCountryName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(countryName);
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (countryCode == null) {
        break label87;
      }
    }
    label87:
    for (int j = countryCode.hashCode();; j = 0)
    {
      if (countryName != null) {
        k = countryName.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Country");
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
    label170:
    label239:
    label249:
    label257:
    label259:
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
        localByteBuffer.putInt(616804885);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasCountryCode) {
            break label239;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, countryCode);
          if (!hasCountryName) {
            break label249;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, countryName);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label257;
          }
          if (str != null) {
            break label259;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
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
    implements RecordTemplateBuilder<Country>
  {
    private String countryCode = null;
    private String countryName = null;
    private Urn entityUrn = null;
    private boolean hasCountryCode = false;
    private boolean hasCountryName = false;
    private boolean hasEntityUrn = false;
    
    public final Country build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Country.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Country(entityUrn, countryCode, countryName, hasEntityUrn, hasCountryCode, hasCountryName);
        if (!hasCountryCode) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Country", "countryCode");
        }
      } while (hasCountryName);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Country", "countryName");
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
    
    public final Builder setCountryName(String paramString)
    {
      if (paramString == null)
      {
        hasCountryName = false;
        countryName = null;
        return this;
      }
      hasCountryName = true;
      countryName = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Country
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */