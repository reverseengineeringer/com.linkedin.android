package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Endorsement$Builder
  implements RecordTemplateBuilder<Endorsement>
{
  private EndorserMiniProfile endorser = null;
  private Urn entityUrn = null;
  private boolean hasEndorser = false;
  private boolean hasEntityUrn = false;
  private boolean hasStatus = false;
  private EndorsementStatusType status = null;
  
  public Endorsement$Builder() {}
  
  public Endorsement$Builder(Endorsement paramEndorsement)
  {
    entityUrn = entityUrn;
    endorser = endorser;
    status = status;
    hasEntityUrn = hasEntityUrn;
    hasEndorser = hasEndorser;
    hasStatus = hasStatus;
  }
  
  public final Endorsement build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Endorsement.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Endorsement(entityUrn, endorser, status, hasEntityUrn, hasEndorser, hasStatus);
      if (!hasEndorser) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement", "endorser");
      }
    } while (hasStatus);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement", "status");
  }
  
  public final Builder setEndorser(EndorserMiniProfile paramEndorserMiniProfile)
  {
    if (paramEndorserMiniProfile == null)
    {
      hasEndorser = false;
      endorser = null;
      return this;
    }
    hasEndorser = true;
    endorser = paramEndorserMiniProfile;
    return this;
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
  }
  
  public final Builder setStatus(EndorsementStatusType paramEndorsementStatusType)
  {
    if (paramEndorsementStatusType == null)
    {
      hasStatus = false;
      status = null;
      return this;
    }
    hasStatus = true;
    status = paramEndorsementStatusType;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */