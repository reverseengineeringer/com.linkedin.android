package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormBasicLocation$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.NormBasicLocation.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */