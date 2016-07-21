package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Address
  implements FissileDataModel<Address>, RecordTemplate<Address>
{
  public static final AddressBuilder BUILDER = AddressBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String address1;
  public final String address2;
  public final String city;
  public final String country;
  public final boolean hasAddress1;
  public final boolean hasAddress2;
  public final boolean hasCity;
  public final boolean hasCountry;
  public final boolean hasPostalCode;
  public final boolean hasPrimary;
  public final boolean hasRawAddress;
  public final boolean hasState;
  public final boolean hasType;
  public final String postalCode;
  public final boolean primary;
  public final String rawAddress;
  public final String state;
  public final String type;
  
  Address(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    type = paramString1;
    rawAddress = paramString2;
    address1 = paramString3;
    address2 = paramString4;
    city = paramString5;
    state = paramString6;
    postalCode = paramString7;
    country = paramString8;
    primary = paramBoolean1;
    hasType = paramBoolean2;
    hasRawAddress = paramBoolean3;
    hasAddress1 = paramBoolean4;
    hasAddress2 = paramBoolean5;
    hasCity = paramBoolean6;
    hasState = paramBoolean7;
    hasPostalCode = paramBoolean8;
    hasCountry = paramBoolean9;
    hasPrimary = paramBoolean10;
    _cachedId = null;
  }
  
  public final Address accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processString(type);
    }
    if (hasRawAddress)
    {
      paramDataProcessor.startRecordField$505cff1c("rawAddress");
      paramDataProcessor.processString(rawAddress);
    }
    if (hasAddress1)
    {
      paramDataProcessor.startRecordField$505cff1c("address1");
      paramDataProcessor.processString(address1);
    }
    if (hasAddress2)
    {
      paramDataProcessor.startRecordField$505cff1c("address2");
      paramDataProcessor.processString(address2);
    }
    if (hasCity)
    {
      paramDataProcessor.startRecordField$505cff1c("city");
      paramDataProcessor.processString(city);
    }
    if (hasState)
    {
      paramDataProcessor.startRecordField$505cff1c("state");
      paramDataProcessor.processString(state);
    }
    if (hasPostalCode)
    {
      paramDataProcessor.startRecordField$505cff1c("postalCode");
      paramDataProcessor.processString(postalCode);
    }
    if (hasCountry)
    {
      paramDataProcessor.startRecordField$505cff1c("country");
      paramDataProcessor.processString(country);
    }
    if (hasPrimary)
    {
      paramDataProcessor.startRecordField$505cff1c("primary");
      paramDataProcessor.processBoolean(primary);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new Address(type, rawAddress, address1, address2, city, state, postalCode, country, primary, hasType, hasRawAddress, hasAddress1, hasAddress2, hasCity, hasState, hasPostalCode, hasCountry, hasPrimary);
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
      paramObject = (Address)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (rawAddress != null)
      {
        if (rawAddress.equals(rawAddress)) {}
      }
      else {
        while (rawAddress != null) {
          return false;
        }
      }
      if (address1 != null)
      {
        if (address1.equals(address1)) {}
      }
      else {
        while (address1 != null) {
          return false;
        }
      }
      if (address2 != null)
      {
        if (address2.equals(address2)) {}
      }
      else {
        while (address2 != null) {
          return false;
        }
      }
      if (city != null)
      {
        if (city.equals(city)) {}
      }
      else {
        while (city != null) {
          return false;
        }
      }
      if (state != null)
      {
        if (state.equals(state)) {}
      }
      else {
        while (state != null) {
          return false;
        }
      }
      if (postalCode != null)
      {
        if (postalCode.equals(postalCode)) {}
      }
      else {
        while (postalCode != null) {
          return false;
        }
      }
      if (country != null)
      {
        if (country.equals(country)) {}
      }
      else {
        while (country != null) {
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
    if (hasType) {
      i = PegasusBinaryUtils.getEncodedLength(type) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasRawAddress) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(rawAddress);
    }
    j = i + 1;
    i = j;
    if (hasAddress1) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(address1);
    }
    j = i + 1;
    i = j;
    if (hasAddress2) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(address2);
    }
    j = i + 1;
    i = j;
    if (hasCity) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(city);
    }
    j = i + 1;
    i = j;
    if (hasState) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(state);
    }
    j = i + 1;
    i = j;
    if (hasPostalCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(postalCode);
    }
    j = i + 1;
    i = j;
    if (hasCountry) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(country);
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
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label92:
    int i1;
    label108:
    int i2;
    if (type != null)
    {
      i = type.hashCode();
      if (rawAddress == null) {
        break label214;
      }
      j = rawAddress.hashCode();
      if (address1 == null) {
        break label219;
      }
      k = address1.hashCode();
      if (address2 == null) {
        break label224;
      }
      m = address2.hashCode();
      if (city == null) {
        break label230;
      }
      n = city.hashCode();
      if (state == null) {
        break label236;
      }
      i1 = state.hashCode();
      if (postalCode == null) {
        break label242;
      }
      i2 = postalCode.hashCode();
      label124:
      if (country == null) {
        break label248;
      }
    }
    label214:
    label219:
    label224:
    label230:
    label236:
    label242:
    label248:
    for (int i3 = country.hashCode();; i3 = 0)
    {
      if (primary) {
        i4 = 1;
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Address");
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
    label217:
    label243:
    label269:
    label295:
    label321:
    label342:
    label394:
    label404:
    label414:
    label424:
    label434:
    label444:
    label454:
    label464:
    label470:
    label478:
    label480:
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
        localByteBuffer.putInt(-1923397846);
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, type);
          if (!hasRawAddress) {
            break label394;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, rawAddress);
          if (!hasAddress1) {
            break label404;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, address1);
          if (!hasAddress2) {
            break label414;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, address2);
          if (!hasCity) {
            break label424;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, city);
          if (!hasState) {
            break label434;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, state);
          if (!hasPostalCode) {
            break label444;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, postalCode);
          if (!hasCountry) {
            break label454;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, country);
          if (!hasPrimary) {
            break label470;
          }
          localByteBuffer.put((byte)1);
          if (!primary) {
            break label464;
          }
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label478;
          }
          if (str != null) {
            break label480;
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
          localByteBuffer.put((byte)0);
          break label217;
          localByteBuffer.put((byte)0);
          break label243;
          localByteBuffer.put((byte)0);
          break label269;
          localByteBuffer.put((byte)0);
          break label295;
          localByteBuffer.put((byte)0);
          break label321;
          i = 0;
          break label342;
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
    implements RecordTemplateBuilder<Address>
  {
    private String address1 = null;
    private String address2 = null;
    public String city = null;
    public String country = null;
    private boolean hasAddress1 = false;
    private boolean hasAddress2 = false;
    public boolean hasCity = false;
    public boolean hasCountry = false;
    public boolean hasPostalCode = false;
    public boolean hasPrimary = false;
    public boolean hasRawAddress = false;
    public boolean hasState = false;
    public boolean hasType = false;
    public String postalCode = null;
    public boolean primary = false;
    public String rawAddress = null;
    public String state = null;
    public String type = null;
    
    public final Address build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Address.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      for (;;)
      {
        return new Address(type, rawAddress, address1, address2, city, state, postalCode, country, primary, hasType, hasRawAddress, hasAddress1, hasAddress2, hasCity, hasState, hasPostalCode, hasCountry, hasPrimary);
        if (!hasPrimary) {
          primary = false;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */