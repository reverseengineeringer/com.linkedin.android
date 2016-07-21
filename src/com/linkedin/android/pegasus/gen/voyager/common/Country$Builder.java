package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Country$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Country.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */