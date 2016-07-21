package com.linkedin.android.pegasus.gen.voyager.growth.invitation;

import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InviteePhone$Builder
  implements RecordTemplateBuilder<InviteePhone>
{
  public String firstName = null;
  public boolean hasFirstName = false;
  public boolean hasLastName = false;
  private boolean hasPhoneNumber = false;
  public String lastName = null;
  private PhoneNumber phoneNumber = null;
  
  public final InviteePhone build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (InviteePhone.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new InviteePhone(phoneNumber, firstName, lastName, hasPhoneNumber, hasFirstName, hasLastName);
    } while (hasPhoneNumber);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteePhone", "phoneNumber");
  }
  
  public final Builder setPhoneNumber(PhoneNumber paramPhoneNumber)
  {
    if (paramPhoneNumber == null)
    {
      hasPhoneNumber = false;
      phoneNumber = null;
      return this;
    }
    hasPhoneNumber = true;
    phoneNumber = paramPhoneNumber;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteePhone.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */