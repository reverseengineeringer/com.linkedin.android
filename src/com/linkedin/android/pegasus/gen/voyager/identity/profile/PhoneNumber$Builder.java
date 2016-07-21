package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PhoneNumber$Builder
  implements RecordTemplateBuilder<PhoneNumber>
{
  private String extension = null;
  private boolean hasExtension = false;
  private boolean hasNumber = false;
  private boolean hasType = false;
  private String number = null;
  private PhoneNumberType type = null;
  
  public final PhoneNumber build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PhoneNumber.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PhoneNumber(number, extension, type, hasNumber, hasExtension, hasType);
    } while (hasNumber);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumber", "number");
  }
  
  public final Builder setNumber(String paramString)
  {
    if (paramString == null)
    {
      hasNumber = false;
      number = null;
      return this;
    }
    hasNumber = true;
    number = paramString;
    return this;
  }
  
  public final Builder setType(PhoneNumberType paramPhoneNumberType)
  {
    if (paramPhoneNumberType == null)
    {
      hasType = false;
      type = null;
      return this;
    }
    hasType = true;
    type = paramPhoneNumberType;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumber.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */