package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Skill$Builder
  implements RecordTemplateBuilder<Skill>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasName = false;
  private boolean hasStandardizedSkill = false;
  private boolean hasStandardizedSkillUrn = false;
  private String name = null;
  private MiniSkill standardizedSkill = null;
  private Urn standardizedSkillUrn = null;
  
  public final Skill build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Skill.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Skill(standardizedSkillUrn, name, entityUrn, standardizedSkill, hasStandardizedSkillUrn, hasName, hasEntityUrn, hasStandardizedSkill);
    } while (hasName);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill", "name");
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
  
  public final Builder setStandardizedSkillUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasStandardizedSkillUrn = false;
      standardizedSkillUrn = null;
      return this;
    }
    hasStandardizedSkillUrn = true;
    standardizedSkillUrn = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */