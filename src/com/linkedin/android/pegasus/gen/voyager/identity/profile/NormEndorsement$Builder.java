package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormEndorsement$Builder
  implements RecordTemplateBuilder<NormEndorsement>
{
  private Urn endorseeUrn = null;
  private Urn endorserUrn = null;
  private boolean hasEndorseeUrn = false;
  private boolean hasEndorserUrn = false;
  private boolean hasSkill = false;
  private boolean hasStatus = false;
  private Skill skill = null;
  private NormEndorsementStatusType status = null;
  
  public final NormEndorsement build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormEndorsement.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NormEndorsement(skill, endorserUrn, endorseeUrn, status, hasSkill, hasEndorserUrn, hasEndorseeUrn, hasStatus);
      if (!hasStatus) {
        status = NormEndorsementStatusType.ACCEPTED;
      }
    } while (hasSkill);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement", "skill");
  }
  
  public final Builder setEndorseeUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEndorseeUrn = false;
      endorseeUrn = null;
      return this;
    }
    hasEndorseeUrn = true;
    endorseeUrn = paramUrn;
    return this;
  }
  
  public final Builder setEndorserUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEndorserUrn = false;
      endorserUrn = null;
      return this;
    }
    hasEndorserUrn = true;
    endorserUrn = paramUrn;
    return this;
  }
  
  public final Builder setSkill(Skill paramSkill)
  {
    if (paramSkill == null)
    {
      hasSkill = false;
      skill = null;
      return this;
    }
    hasSkill = true;
    skill = paramSkill;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */