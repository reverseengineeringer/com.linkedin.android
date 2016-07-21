package com.linkedin.gen.avro2pegasus.common.messages.flock;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PhoneNumberInfo
  implements RecordTemplate<PhoneNumberInfo>
{
  public static final PhoneNumberInfoBuilder BUILDER = PhoneNumberInfoBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int countryDialingCode;
  public final boolean hasCountryDialingCode;
  public final boolean hasMobileCountryCode;
  public final boolean hasMobileNetworkCode;
  public final boolean hasPhoneNumberType;
  public final boolean hasServiceProviderName;
  public final boolean hasSource;
  public final String mobileCountryCode;
  public final String mobileNetworkCode;
  public final PhoneNumberType phoneNumberType;
  public final String serviceProviderName;
  public final CarrierLookupProvider source;
  
  PhoneNumberInfo(int paramInt, String paramString1, String paramString2, String paramString3, CarrierLookupProvider paramCarrierLookupProvider, PhoneNumberType paramPhoneNumberType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    countryDialingCode = paramInt;
    serviceProviderName = paramString1;
    mobileCountryCode = paramString2;
    mobileNetworkCode = paramString3;
    source = paramCarrierLookupProvider;
    phoneNumberType = paramPhoneNumberType;
    hasCountryDialingCode = paramBoolean1;
    hasServiceProviderName = paramBoolean2;
    hasMobileCountryCode = paramBoolean3;
    hasMobileNetworkCode = paramBoolean4;
    hasSource = paramBoolean5;
    hasPhoneNumberType = paramBoolean6;
    _cachedId = null;
  }
  
  public final PhoneNumberInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCountryDialingCode)
    {
      paramDataProcessor.startRecordField$505cff1c("countryDialingCode");
      paramDataProcessor.processInt(countryDialingCode);
    }
    if (hasServiceProviderName)
    {
      paramDataProcessor.startRecordField$505cff1c("serviceProviderName");
      paramDataProcessor.processString(serviceProviderName);
    }
    if (hasMobileCountryCode)
    {
      paramDataProcessor.startRecordField$505cff1c("mobileCountryCode");
      paramDataProcessor.processString(mobileCountryCode);
    }
    if (hasMobileNetworkCode)
    {
      paramDataProcessor.startRecordField$505cff1c("mobileNetworkCode");
      paramDataProcessor.processString(mobileNetworkCode);
    }
    if (hasSource)
    {
      paramDataProcessor.startRecordField$505cff1c("source");
      paramDataProcessor.processEnum(source);
    }
    if (hasPhoneNumberType)
    {
      paramDataProcessor.startRecordField$505cff1c("phoneNumberType");
      paramDataProcessor.processEnum(phoneNumberType);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new PhoneNumberInfo(countryDialingCode, serviceProviderName, mobileCountryCode, mobileNetworkCode, source, phoneNumberType, hasCountryDialingCode, hasServiceProviderName, hasMobileCountryCode, hasMobileNetworkCode, hasSource, hasPhoneNumberType);
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
      paramObject = (PhoneNumberInfo)paramObject;
      if (countryDialingCode != countryDialingCode) {
        return false;
      }
      if (serviceProviderName != null)
      {
        if (serviceProviderName.equals(serviceProviderName)) {}
      }
      else {
        while (serviceProviderName != null) {
          return false;
        }
      }
      if (mobileCountryCode != null)
      {
        if (mobileCountryCode.equals(mobileCountryCode)) {}
      }
      else {
        while (mobileCountryCode != null) {
          return false;
        }
      }
      if (mobileNetworkCode != null)
      {
        if (mobileNetworkCode.equals(mobileNetworkCode)) {}
      }
      else {
        while (mobileNetworkCode != null) {
          return false;
        }
      }
      if (source != null)
      {
        if (source.equals(source)) {}
      }
      else {
        while (source != null) {
          return false;
        }
      }
      if (phoneNumberType == null) {
        break;
      }
    } while (phoneNumberType.equals(phoneNumberType));
    for (;;)
    {
      return false;
      if (phoneNumberType == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = countryDialingCode;
    int i;
    int j;
    label51:
    int k;
    if (serviceProviderName != null)
    {
      i = serviceProviderName.hashCode();
      if (mobileCountryCode == null) {
        break label144;
      }
      j = mobileCountryCode.hashCode();
      if (mobileNetworkCode == null) {
        break label149;
      }
      k = mobileNetworkCode.hashCode();
      label66:
      if (source == null) {
        break label154;
      }
    }
    label144:
    label149:
    label154:
    for (int m = source.hashCode();; m = 0)
    {
      if (phoneNumberType != null) {
        n = phoneNumberType.hashCode();
      }
      i = (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label66;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<PhoneNumberInfo>
  {
    private int countryDialingCode = 0;
    private boolean hasCountryDialingCode = false;
    public boolean hasMobileCountryCode = false;
    public boolean hasMobileNetworkCode = false;
    private boolean hasPhoneNumberType = false;
    private boolean hasServiceProviderName = false;
    private boolean hasSource = false;
    public String mobileCountryCode = null;
    public String mobileNetworkCode = null;
    private PhoneNumberType phoneNumberType = null;
    private String serviceProviderName = null;
    private CarrierLookupProvider source = null;
    
    public final PhoneNumberInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = PhoneNumberInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new PhoneNumberInfo(countryDialingCode, serviceProviderName, mobileCountryCode, mobileNetworkCode, source, phoneNumberType, hasCountryDialingCode, hasServiceProviderName, hasMobileCountryCode, hasMobileNetworkCode, hasSource, hasPhoneNumberType);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */