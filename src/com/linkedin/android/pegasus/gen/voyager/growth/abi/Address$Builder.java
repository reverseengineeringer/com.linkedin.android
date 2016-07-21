package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Address$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.Address.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */