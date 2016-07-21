package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MemberBadges$Builder
  implements RecordTemplateBuilder<MemberBadges>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasInfluencer = false;
  private boolean hasJobSeeker = false;
  private boolean hasOpenLink = false;
  public boolean hasPremium = false;
  private boolean influencer = false;
  private boolean jobSeeker = false;
  private boolean openLink = false;
  public boolean premium = false;
  
  public MemberBadges$Builder() {}
  
  public MemberBadges$Builder(MemberBadges paramMemberBadges)
  {
    entityUrn = entityUrn;
    influencer = influencer;
    jobSeeker = jobSeeker;
    premium = premium;
    openLink = openLink;
    hasEntityUrn = hasEntityUrn;
    hasInfluencer = hasInfluencer;
    hasJobSeeker = hasJobSeeker;
    hasPremium = hasPremium;
    hasOpenLink = hasOpenLink;
  }
  
  public final MemberBadges build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MemberBadges.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MemberBadges(entityUrn, influencer, jobSeeker, premium, openLink, hasEntityUrn, hasInfluencer, hasJobSeeker, hasPremium, hasOpenLink);
      if (!hasInfluencer) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "influencer");
      }
      if (!hasJobSeeker) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "jobSeeker");
      }
      if (!hasPremium) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "premium");
      }
    } while (hasOpenLink);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges", "openLink");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */