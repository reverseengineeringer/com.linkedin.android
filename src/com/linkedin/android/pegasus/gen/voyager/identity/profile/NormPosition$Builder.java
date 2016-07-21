package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormPosition$Builder
  implements RecordTemplateBuilder<NormPosition>
{
  private String companyName = null;
  private Urn companyUrn = null;
  private String description = null;
  private Urn entityUrn = null;
  private boolean hasCompanyName = false;
  private boolean hasCompanyUrn = false;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasLocationName = false;
  private boolean hasRegion = false;
  private boolean hasTimePeriod = false;
  private boolean hasTitle = false;
  private String locationName = null;
  private Urn region = null;
  private DateRange timePeriod = null;
  private String title = null;
  
  public NormPosition$Builder() {}
  
  public NormPosition$Builder(NormPosition paramNormPosition)
  {
    entityUrn = entityUrn;
    title = title;
    description = description;
    timePeriod = timePeriod;
    region = region;
    locationName = locationName;
    companyName = companyName;
    companyUrn = companyUrn;
    hasEntityUrn = hasEntityUrn;
    hasTitle = hasTitle;
    hasDescription = hasDescription;
    hasTimePeriod = hasTimePeriod;
    hasRegion = hasRegion;
    hasLocationName = hasLocationName;
    hasCompanyName = hasCompanyName;
    hasCompanyUrn = hasCompanyUrn;
  }
  
  public final NormPosition build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = NormPosition.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new NormPosition(entityUrn, title, description, timePeriod, region, locationName, companyName, companyUrn, hasEntityUrn, hasTitle, hasDescription, hasTimePeriod, hasRegion, hasLocationName, hasCompanyName, hasCompanyUrn);
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
  
  public final Builder setLocationName(String paramString)
  {
    if (paramString == null)
    {
      hasLocationName = false;
      locationName = null;
      return this;
    }
    hasLocationName = true;
    locationName = paramString;
    return this;
  }
  
  public final Builder setRegion(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasRegion = false;
      region = null;
      return this;
    }
    hasRegion = true;
    region = paramUrn;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */