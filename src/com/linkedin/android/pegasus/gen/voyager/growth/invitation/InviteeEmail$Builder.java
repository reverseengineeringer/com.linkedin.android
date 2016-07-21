package com.linkedin.android.pegasus.gen.voyager.growth.invitation;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InviteeEmail$Builder
  implements RecordTemplateBuilder<InviteeEmail>
{
  private String email = null;
  private boolean hasEmail = false;
  
  public final InviteeEmail build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (InviteeEmail.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new InviteeEmail(email, hasEmail);
    } while (hasEmail);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeEmail", "email");
  }
  
  public final Builder setEmail(String paramString)
  {
    if (paramString == null)
    {
      hasEmail = false;
      email = null;
      return this;
    }
    hasEmail = true;
    email = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeEmail.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */