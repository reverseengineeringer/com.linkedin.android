package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormHonor$Builder
  implements RecordTemplateBuilder<NormHonor>
{
  private String description = null;
  private Urn entityUrn = null;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasIssueDate = false;
  private boolean hasIssuer = false;
  private boolean hasOccupation = false;
  private boolean hasTitle = false;
  private Date issueDate = null;
  private String issuer = null;
  private Urn occupation = null;
  private String title = null;
  
  public NormHonor$Builder() {}
  
  public NormHonor$Builder(NormHonor paramNormHonor)
  {
    entityUrn = entityUrn;
    title = title;
    issueDate = issueDate;
    issuer = issuer;
    occupation = occupation;
    description = description;
    hasEntityUrn = hasEntityUrn;
    hasTitle = hasTitle;
    hasIssueDate = hasIssueDate;
    hasIssuer = hasIssuer;
    hasOccupation = hasOccupation;
    hasDescription = hasDescription;
  }
  
  public final NormHonor build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormHonor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NormHonor(entityUrn, title, issueDate, issuer, occupation, description, hasEntityUrn, hasTitle, hasIssueDate, hasIssuer, hasOccupation, hasDescription);
    } while (hasTitle);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormHonor", "title");
  }
  
  public final Builder setDescription(String paramString)
  {
    if (paramString == null)
    {
      hasDescription = false;
      description = null;
      return this;
    }
    hasDescription = true;
    description = paramString;
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
  
  public final Builder setIssueDate(Date paramDate)
  {
    if (paramDate == null)
    {
      hasIssueDate = false;
      issueDate = null;
      return this;
    }
    hasIssueDate = true;
    issueDate = paramDate;
    return this;
  }
  
  public final Builder setIssuer(String paramString)
  {
    if (paramString == null)
    {
      hasIssuer = false;
      issuer = null;
      return this;
    }
    hasIssuer = true;
    issuer = paramString;
    return this;
  }
  
  public final Builder setOccupation(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasOccupation = false;
      occupation = null;
      return this;
    }
    hasOccupation = true;
    occupation = paramUrn;
    return this;
  }
  
  public final Builder setTitle(String paramString)
  {
    if (paramString == null)
    {
      hasTitle = false;
      title = null;
      return this;
    }
    hasTitle = true;
    title = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormHonor.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */