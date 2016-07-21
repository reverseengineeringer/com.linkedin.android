package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Email$Builder
  implements RecordTemplateBuilder<Email>
{
  public String emailAddress = null;
  public boolean hasEmailAddress = false;
  public boolean hasPrimary = false;
  public boolean hasType = false;
  public boolean primary = false;
  public String type = null;
  
  public final Email build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Email.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Email(emailAddress, primary, type, hasEmailAddress, hasPrimary, hasType);
      if (!hasPrimary) {
        primary = false;
      }
    } while (hasEmailAddress);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.Email", "emailAddress");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.Email.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */