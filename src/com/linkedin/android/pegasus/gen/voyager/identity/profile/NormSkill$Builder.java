package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormSkill$Builder
  implements RecordTemplateBuilder<NormSkill>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasName = false;
  public boolean hasStandardizedSkillUrn = false;
  private String name = null;
  public Urn standardizedSkillUrn = null;
  
  public final NormSkill build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormSkill.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NormSkill(standardizedSkillUrn, name, entityUrn, hasStandardizedSkillUrn, hasName, hasEntityUrn);
    } while (hasName);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormSkill", "name");
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
  
  public final Builder setName(String paramString)
  {
    if (paramString == null)
    {
      hasName = false;
      name = null;
      return this;
    }
    hasName = true;
    name = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormSkill.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */