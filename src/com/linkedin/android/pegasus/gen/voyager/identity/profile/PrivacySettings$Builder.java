package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PrivacySettings$Builder
  implements RecordTemplateBuilder<PrivacySettings>
{
  public boolean allowOpenProfile = false;
  private boolean allowProfileEditBroadcasts = false;
  private Urn entityUrn = null;
  public boolean hasAllowOpenProfile = false;
  private boolean hasAllowProfileEditBroadcasts = false;
  private boolean hasEntityUrn = false;
  public boolean hasProfilePictureVisibilitySetting = false;
  public boolean hasShowPremiumSubscriberBadge = false;
  public NetworkVisibilitySetting profilePictureVisibilitySetting = null;
  public boolean showPremiumSubscriberBadge = false;
  
  public PrivacySettings$Builder() {}
  
  public PrivacySettings$Builder(PrivacySettings paramPrivacySettings)
  {
    entityUrn = entityUrn;
    showPremiumSubscriberBadge = showPremiumSubscriberBadge;
    allowOpenProfile = allowOpenProfile;
    profilePictureVisibilitySetting = profilePictureVisibilitySetting;
    allowProfileEditBroadcasts = allowProfileEditBroadcasts;
    hasEntityUrn = hasEntityUrn;
    hasShowPremiumSubscriberBadge = hasShowPremiumSubscriberBadge;
    hasAllowOpenProfile = hasAllowOpenProfile;
    hasProfilePictureVisibilitySetting = hasProfilePictureVisibilitySetting;
    hasAllowProfileEditBroadcasts = hasAllowProfileEditBroadcasts;
  }
  
  public final PrivacySettings build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PrivacySettings.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PrivacySettings(entityUrn, showPremiumSubscriberBadge, allowOpenProfile, profilePictureVisibilitySetting, allowProfileEditBroadcasts, hasEntityUrn, hasShowPremiumSubscriberBadge, hasAllowOpenProfile, hasProfilePictureVisibilitySetting, hasAllowProfileEditBroadcasts);
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "entityUrn");
      }
      if (!hasShowPremiumSubscriberBadge) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "showPremiumSubscriberBadge");
      }
      if (!hasAllowOpenProfile) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "allowOpenProfile");
      }
      if (!hasProfilePictureVisibilitySetting) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "profilePictureVisibilitySetting");
      }
    } while (hasAllowProfileEditBroadcasts);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "allowProfileEditBroadcasts");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */