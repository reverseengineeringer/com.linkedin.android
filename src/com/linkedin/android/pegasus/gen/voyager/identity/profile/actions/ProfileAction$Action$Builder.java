package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class ProfileAction$Action$Builder
{
  private Accept acceptValue = null;
  private Block blockValue = null;
  private Connect connectValue = null;
  private Disconnect disconnectValue = null;
  private Follow followValue = null;
  private boolean hasAcceptValue = false;
  private boolean hasBlockValue = false;
  private boolean hasConnectValue = false;
  private boolean hasDisconnectValue = false;
  private boolean hasFollowValue = false;
  private boolean hasInvitationPendingValue = false;
  private boolean hasMessageValue = false;
  private boolean hasPersonalizedConnectValue = false;
  private boolean hasReportValue = false;
  private boolean hasRequestRecommendationValue = false;
  private boolean hasSendInMailValue = false;
  private boolean hasSignupValue = false;
  private boolean hasUnfollowValue = false;
  private InvitationPending invitationPendingValue = null;
  private Message messageValue = null;
  private PersonalizedConnect personalizedConnectValue = null;
  private Report reportValue = null;
  private RequestRecommendation requestRecommendationValue = null;
  private SendInMail sendInMailValue = null;
  private Signup signupValue = null;
  private Unfollow unfollowValue = null;
  
  public ProfileAction$Action$Builder() {}
  
  public ProfileAction$Action$Builder(ProfileAction.Action paramAction)
  {
    connectValue = connectValue;
    personalizedConnectValue = personalizedConnectValue;
    invitationPendingValue = invitationPendingValue;
    acceptValue = acceptValue;
    messageValue = messageValue;
    followValue = followValue;
    sendInMailValue = sendInMailValue;
    disconnectValue = disconnectValue;
    unfollowValue = unfollowValue;
    blockValue = blockValue;
    reportValue = reportValue;
    signupValue = signupValue;
    requestRecommendationValue = requestRecommendationValue;
    hasConnectValue = hasConnectValue;
    hasPersonalizedConnectValue = hasPersonalizedConnectValue;
    hasInvitationPendingValue = hasInvitationPendingValue;
    hasAcceptValue = hasAcceptValue;
    hasMessageValue = hasMessageValue;
    hasFollowValue = hasFollowValue;
    hasSendInMailValue = hasSendInMailValue;
    hasDisconnectValue = hasDisconnectValue;
    hasUnfollowValue = hasUnfollowValue;
    hasBlockValue = hasBlockValue;
    hasReportValue = hasReportValue;
    hasSignupValue = hasSignupValue;
    hasRequestRecommendationValue = hasRequestRecommendationValue;
  }
  
  public final ProfileAction.Action build()
    throws BuilderException
  {
    int j = 0;
    if (hasConnectValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasPersonalizedConnectValue) {
      i = j + 1;
    }
    j = i;
    if (hasInvitationPendingValue) {
      j = i + 1;
    }
    i = j;
    if (hasAcceptValue) {
      i = j + 1;
    }
    j = i;
    if (hasMessageValue) {
      j = i + 1;
    }
    i = j;
    if (hasFollowValue) {
      i = j + 1;
    }
    j = i;
    if (hasSendInMailValue) {
      j = i + 1;
    }
    i = j;
    if (hasDisconnectValue) {
      i = j + 1;
    }
    j = i;
    if (hasUnfollowValue) {
      j = i + 1;
    }
    i = j;
    if (hasBlockValue) {
      i = j + 1;
    }
    j = i;
    if (hasReportValue) {
      j = i + 1;
    }
    i = j;
    if (hasSignupValue) {
      i = j + 1;
    }
    j = i;
    if (hasRequestRecommendationValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("Action", j);
    }
    return new ProfileAction.Action(connectValue, personalizedConnectValue, invitationPendingValue, acceptValue, messageValue, followValue, sendInMailValue, disconnectValue, unfollowValue, blockValue, reportValue, signupValue, requestRecommendationValue, hasConnectValue, hasPersonalizedConnectValue, hasInvitationPendingValue, hasAcceptValue, hasMessageValue, hasFollowValue, hasSendInMailValue, hasDisconnectValue, hasUnfollowValue, hasBlockValue, hasReportValue, hasSignupValue, hasRequestRecommendationValue);
  }
  
  public final Builder setAcceptValue$76e4df49()
  {
    hasAcceptValue = false;
    acceptValue = null;
    return this;
  }
  
  public final Builder setConnectValue$e34ab()
  {
    hasConnectValue = false;
    connectValue = null;
    return this;
  }
  
  public final Builder setInvitationPendingValue(InvitationPending paramInvitationPending)
  {
    if (paramInvitationPending == null)
    {
      hasInvitationPendingValue = false;
      invitationPendingValue = null;
      return this;
    }
    hasInvitationPendingValue = true;
    invitationPendingValue = paramInvitationPending;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction.Action.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */