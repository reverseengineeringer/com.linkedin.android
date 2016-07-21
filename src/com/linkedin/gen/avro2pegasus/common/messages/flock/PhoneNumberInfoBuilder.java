package com.linkedin.gen.avro2pegasus.common.messages.flock;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PhoneNumberInfoBuilder
  implements DataTemplateBuilder<PhoneNumberInfo>
{
  public static final PhoneNumberInfoBuilder INSTANCE = new PhoneNumberInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("countryDialingCode");
    JSON_KEY_STORE.put("serviceProviderName");
    JSON_KEY_STORE.put("mobileCountryCode");
    JSON_KEY_STORE.put("mobileNetworkCode");
    JSON_KEY_STORE.put("source");
    JSON_KEY_STORE.put("phoneNumberType");
  }
  
  public static PhoneNumberInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i = 0;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    CarrierLookupProvider localCarrierLookupProvider = null;
    PhoneNumberType localPhoneNumberType = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("countryDialingCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("serviceProviderName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mobileCountryCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mobileNetworkCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("source", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localCarrierLookupProvider = (CarrierLookupProvider)paramDataReader.readEnum(CarrierLookupProvider.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("phoneNumberType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPhoneNumberType = (PhoneNumberType)paramDataReader.readEnum(PhoneNumberType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new PhoneNumberInfo(i, str3, str2, str1, localCarrierLookupProvider, localPhoneNumberType, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */