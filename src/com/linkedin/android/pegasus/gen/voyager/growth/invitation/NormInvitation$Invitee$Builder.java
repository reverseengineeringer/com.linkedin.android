package com.linkedin.android.pegasus.gen.voyager.growth.invitation;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class NormInvitation$Invitee$Builder
{
  private boolean hasInviteeEmailValue = false;
  private boolean hasInviteePhoneValue = false;
  private boolean hasInviteeProfileValue = false;
  private InviteeEmail inviteeEmailValue = null;
  private InviteePhone inviteePhoneValue = null;
  private InviteeProfile inviteeProfileValue = null;
  
  public final NormInvitation.Invitee build()
    throws BuilderException
  {
    int j = 0;
    if (hasInviteeProfileValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasInviteeEmailValue) {
      i = j + 1;
    }
    j = i;
    if (hasInviteePhoneValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("Invitee", j);
    }
    return new NormInvitation.Invitee(inviteeProfileValue, inviteeEmailValue, inviteePhoneValue, hasInviteeProfileValue, hasInviteeEmailValue, hasInviteePhoneValue);
  }
  
  public final Builder setInviteeEmailValue(InviteeEmail paramInviteeEmail)
  {
    if (paramInviteeEmail == null)
    {
      hasInviteeEmailValue = false;
      inviteeEmailValue = null;
      return this;
    }
    hasInviteeEmailValue = true;
    inviteeEmailValue = paramInviteeEmail;
    return this;
  }
  
  public final Builder setInviteePhoneValue(InviteePhone paramInviteePhone)
  {
    if (paramInviteePhone == null)
    {
      hasInviteePhoneValue = false;
      inviteePhoneValue = null;
      return this;
    }
    hasInviteePhoneValue = true;
    inviteePhoneValue = paramInviteePhone;
    return this;
  }
  
  public final Builder setInviteeProfileValue(InviteeProfile paramInviteeProfile)
  {
    if (paramInviteeProfile == null)
    {
      hasInviteeProfileValue = false;
      inviteeProfileValue = null;
      return this;
    }
    hasInviteeProfileValue = true;
    inviteeProfileValue = paramInviteeProfile;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */