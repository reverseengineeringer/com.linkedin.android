package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormCertification$Builder
  implements RecordTemplateBuilder<NormCertification>
{
  private String authority = null;
  private Urn companyUrn = null;
  private String displaySource = null;
  private Urn entityUrn = null;
  private boolean hasAuthority = false;
  private boolean hasCompanyUrn = false;
  private boolean hasDisplaySource = false;
  private boolean hasEntityUrn = false;
  private boolean hasLicenseNumber = false;
  private boolean hasName = false;
  private boolean hasTimePeriod = false;
  private boolean hasUrl = false;
  private String licenseNumber = null;
  private String name = null;
  private DateRange timePeriod = null;
  private String url = null;
  
  public NormCertification$Builder() {}
  
  public NormCertification$Builder(NormCertification paramNormCertification)
  {
    entityUrn = entityUrn;
    name = name;
    licenseNumber = licenseNumber;
    url = url;
    displaySource = displaySource;
    timePeriod = timePeriod;
    authority = authority;
    companyUrn = companyUrn;
    hasEntityUrn = hasEntityUrn;
    hasName = hasName;
    hasLicenseNumber = hasLicenseNumber;
    hasUrl = hasUrl;
    hasDisplaySource = hasDisplaySource;
    hasTimePeriod = hasTimePeriod;
    hasAuthority = hasAuthority;
    hasCompanyUrn = hasCompanyUrn;
  }
  
  public final NormCertification build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormCertification.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NormCertification(entityUrn, name, licenseNumber, url, displaySource, timePeriod, authority, companyUrn, hasEntityUrn, hasName, hasLicenseNumber, hasUrl, hasDisplaySource, hasTimePeriod, hasAuthority, hasCompanyUrn);
    } while (hasName);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCertification", "name");
  }
  
  public final Builder setAuthority(String paramString)
  {
    if (paramString == null)
    {
      hasAuthority = false;
      authority = null;
      return this;
    }
    hasAuthority = true;
    authority = paramString;
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
  
  public final Builder setLicenseNumber(String paramString)
  {
    if (paramString == null)
    {
      hasLicenseNumber = false;
      licenseNumber = null;
      return this;
    }
    hasLicenseNumber = true;
    licenseNumber = paramString;
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
  
  public final Builder setUrl(String paramString)
  {
    if (paramString == null)
    {
      hasUrl = false;
      url = null;
      return this;
    }
    hasUrl = true;
    url = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCertification.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */