package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.identity.VolunteerCause;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormVolunteerExperience$Builder
  implements RecordTemplateBuilder<NormVolunteerExperience>
{
  private VolunteerCause cause = null;
  private String companyName = null;
  private Urn companyUrn = null;
  private String description = null;
  private Urn entityUrn = null;
  private boolean hasCause = false;
  private boolean hasCompanyName = false;
  private boolean hasCompanyUrn = false;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasRole = false;
  private boolean hasTimePeriod = false;
  private String role = null;
  private DateRange timePeriod = null;
  
  public NormVolunteerExperience$Builder() {}
  
  public NormVolunteerExperience$Builder(NormVolunteerExperience paramNormVolunteerExperience)
  {
    entityUrn = entityUrn;
    companyName = companyName;
    companyUrn = companyUrn;
    role = role;
    cause = cause;
    timePeriod = timePeriod;
    description = description;
    hasEntityUrn = hasEntityUrn;
    hasCompanyName = hasCompanyName;
    hasCompanyUrn = hasCompanyUrn;
    hasRole = hasRole;
    hasCause = hasCause;
    hasTimePeriod = hasTimePeriod;
    hasDescription = hasDescription;
  }
  
  public final NormVolunteerExperience build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormVolunteerExperience.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NormVolunteerExperience(entityUrn, companyName, companyUrn, role, cause, timePeriod, description, hasEntityUrn, hasCompanyName, hasCompanyUrn, hasRole, hasCause, hasTimePeriod, hasDescription);
      if (!hasCompanyName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience", "companyName");
      }
    } while (hasRole);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience", "role");
  }
  
  public final Builder setCause(VolunteerCause paramVolunteerCause)
  {
    if (paramVolunteerCause == null)
    {
      hasCause = false;
      cause = null;
      return this;
    }
    hasCause = true;
    cause = paramVolunteerCause;
    return this;
  }
  
  public final Builder setCompanyName(String paramString)
  {
    if (paramString == null)
    {
      hasCompanyName = false;
      companyName = null;
      return this;
    }
    hasCompanyName = true;
    companyName = paramString;
    return this;
  }
  
  public final Builder setCompanyUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasCompanyUrn = false;
      companyUrn = null;
      return this;
    }
    hasCompanyUrn = true;
    companyUrn = paramUrn;
    return this;
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
  
  public final Builder setRole(String paramString)
  {
    if (paramString == null)
    {
      hasRole = false;
      role = null;
      return this;
    }
    hasRole = true;
    role = paramString;
    return this;
  }
  
  public final Builder setTimePeriod(DateRange paramDateRange)
  {
    if (paramDateRange == null)
    {
      hasTimePeriod = false;
      timePeriod = null;
      return this;
    }
    hasTimePeriod = true;
    timePeriod = paramDateRange;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */