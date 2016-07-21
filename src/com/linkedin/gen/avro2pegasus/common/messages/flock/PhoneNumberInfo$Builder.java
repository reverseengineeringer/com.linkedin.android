package com.linkedin.gen.avro2pegasus.common.messages.flock;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PhoneNumberInfo$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */