package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class SocialActor$Builder
{
  private AppActor appActorValue = null;
  private CompanyActor companyActorValue = null;
  private boolean hasAppActorValue = false;
  private boolean hasCompanyActorValue = false;
  private boolean hasInfluencerActorValue = false;
  private boolean hasMemberActorValue = false;
  private boolean hasSchoolActorValue = false;
  private InfluencerActor influencerActorValue = null;
  private MemberActor memberActorValue = null;
  private SchoolActor schoolActorValue = null;
  
  public final SocialActor build()
    throws BuilderException
  {
    int j = 0;
    if (hasMemberActorValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasCompanyActorValue) {
      i = j + 1;
    }
    j = i;
    if (hasSchoolActorValue) {
      j = i + 1;
    }
    i = j;
    if (hasInfluencerActorValue) {
      i = j + 1;
    }
    j = i;
    if (hasAppActorValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("com.linkedin.android.pegasus.gen.voyager.feed.SocialActor", j);
    }
    return new SocialActor(memberActorValue, companyActorValue, schoolActorValue, influencerActorValue, appActorValue, hasMemberActorValue, hasCompanyActorValue, hasSchoolActorValue, hasInfluencerActorValue, hasAppActorValue);
  }
  
  public final Builder setMemberActorValue(MemberActor paramMemberActor)
  {
    if (paramMemberActor == null)
    {
      hasMemberActorValue = false;
      memberActorValue = null;
      return this;
    }
    hasMemberActorValue = true;
    memberActorValue = paramMemberActor;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SocialActor.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */