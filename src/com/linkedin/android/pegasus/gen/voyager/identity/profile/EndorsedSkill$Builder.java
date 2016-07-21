package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class EndorsedSkill$Builder
  implements RecordTemplateBuilder<EndorsedSkill>
{
  private boolean endorsedByViewer = false;
  private int endorsementCount = 0;
  private List<Endorsement> endorsements = null;
  private Urn entityUrn = null;
  private boolean hasEndorsedByViewer = false;
  private boolean hasEndorsementCount = false;
  private boolean hasEndorsements = false;
  private boolean hasEntityUrn = false;
  private boolean hasHighlights = false;
  private boolean hasSkill = false;
  private List<EndorsedSkillHighlight> highlights = null;
  private Skill skill = null;
  
  private EndorsedSkill build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (EndorsedSkill.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (endorsements != null)
    {
      paramFlavor = endorsements.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Endorsement)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "endorsements");
            if (!hasEndorsementCount) {
              endorsementCount = 0;
            }
            if (!hasEndorsements) {
              endorsements = Collections.emptyList();
            }
            if (!hasHighlights) {
              highlights = Collections.emptyList();
            }
            if (!hasSkill) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "skill");
            }
            if (hasEndorsedByViewer) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "endorsedByViewer");
          }
        }
      }
    }
    if (highlights != null)
    {
      paramFlavor = highlights.iterator();
      while (paramFlavor.hasNext()) {
        if ((EndorsedSkillHighlight)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "highlights");
        }
      }
    }
    return new EndorsedSkill(entityUrn, skill, endorsementCount, endorsedByViewer, endorsements, highlights, hasEntityUrn, hasSkill, hasEndorsementCount, hasEndorsedByViewer, hasEndorsements, hasHighlights);
  }
  
  public final EndorsedSkill build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Builder setEndorsedByViewer(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      hasEndorsedByViewer = false;
      endorsedByViewer = false;
      return this;
    }
    hasEndorsedByViewer = true;
    endorsedByViewer = paramBoolean.booleanValue();
    return this;
  }
  
  public final Builder setEndorsementCount(Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger.intValue() == 0))
    {
      hasEndorsementCount = false;
      endorsementCount = 0;
      return this;
    }
    hasEndorsementCount = true;
    endorsementCount = paramInteger.intValue();
    return this;
  }
  
  public final Builder setEndorsements(List<Endorsement> paramList)
  {
    if (paramList.equals(Collections.emptyList()))
    {
      hasEndorsements = false;
      endorsements = Collections.emptyList();
      return this;
    }
    hasEndorsements = true;
    endorsements = paramList;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */