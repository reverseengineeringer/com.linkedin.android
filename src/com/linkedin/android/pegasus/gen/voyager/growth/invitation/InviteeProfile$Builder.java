package com.linkedin.android.pegasus.gen.voyager.growth.invitation;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InviteeProfile$Builder
  implements RecordTemplateBuilder<InviteeProfile>
{
  private boolean hasProfileId = false;
  private String profileId = null;
  
  public final InviteeProfile build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (InviteeProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new InviteeProfile(profileId, hasProfileId);
    } while (hasProfileId);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile", "profileId");
  }
  
  public final Builder setProfileId(String paramString)
  {
    if (paramString == null)
    {
      hasProfileId = false;
      profileId = null;
      return this;
    }
    hasProfileId = true;
    profileId = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */