package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class NormPatent$Builder
  implements RecordTemplateBuilder<NormPatent>
{
  private String applicationNumber = null;
  private String description = null;
  private Urn entityUrn = null;
  private Date filingDate = null;
  private boolean hasApplicationNumber = false;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasFilingDate = false;
  private boolean hasInventors = false;
  private boolean hasIssueDate = false;
  private boolean hasIssuer = false;
  private boolean hasLocalizedIssuerCountryName = false;
  private boolean hasNumber = false;
  private boolean hasPending = false;
  private boolean hasTitle = false;
  private boolean hasUrl = false;
  private List<NormContributor> inventors = null;
  private Date issueDate = null;
  private String issuer = null;
  private String localizedIssuerCountryName = null;
  private String number = null;
  private boolean pending = false;
  private String title = null;
  private String url = null;
  
  public NormPatent$Builder() {}
  
  public NormPatent$Builder(NormPatent paramNormPatent)
  {
    entityUrn = entityUrn;
    number = number;
    applicationNumber = applicationNumber;
    title = title;
    issuer = issuer;
    url = url;
    pending = pending;
    filingDate = filingDate;
    issueDate = issueDate;
    description = description;
    localizedIssuerCountryName = localizedIssuerCountryName;
    inventors = inventors;
    hasEntityUrn = hasEntityUrn;
    hasNumber = hasNumber;
    hasApplicationNumber = hasApplicationNumber;
    hasTitle = hasTitle;
    hasIssuer = hasIssuer;
    hasUrl = hasUrl;
    hasPending = hasPending;
    hasFilingDate = hasFilingDate;
    hasIssueDate = hasIssueDate;
    hasDescription = hasDescription;
    hasLocalizedIssuerCountryName = hasLocalizedIssuerCountryName;
    hasInventors = hasInventors;
  }
  
  public final NormPatent build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final NormPatent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormPatent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (inventors != null)
    {
      paramFlavor = inventors.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((NormContributor)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatent", "inventors");
            if (!hasTitle) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatent", "title");
            }
            if (!hasIssuer) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatent", "issuer");
            }
            if (!hasPending) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatent", "pending");
            }
            if (hasInventors) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatent", "inventors");
          }
        }
      }
    }
    return new NormPatent(entityUrn, number, applicationNumber, title, issuer, url, pending, filingDate, issueDate, description, localizedIssuerCountryName, inventors, hasEntityUrn, hasNumber, hasApplicationNumber, hasTitle, hasIssuer, hasUrl, hasPending, hasFilingDate, hasIssueDate, hasDescription, hasLocalizedIssuerCountryName, hasInventors);
  }
  
  public final Builder setApplicationNumber(String paramString)
  {
    if (paramString == null)
    {
      hasApplicationNumber = false;
      applicationNumber = null;
      return this;
    }
    hasApplicationNumber = true;
    applicationNumber = paramString;
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
  
  public final Builder setFilingDate(Date paramDate)
  {
    if (paramDate == null)
    {
      hasFilingDate = false;
      filingDate = null;
      return this;
    }
    hasFilingDate = true;
    filingDate = paramDate;
    return this;
  }
  
  public final Builder setInventors(List<NormContributor> paramList)
  {
    if (paramList == null)
    {
      hasInventors = false;
      inventors = null;
      return this;
    }
    hasInventors = true;
    inventors = paramList;
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
  
  public final Builder setNumber(String paramString)
  {
    if (paramString == null)
    {
      hasNumber = false;
      number = null;
      return this;
    }
    hasNumber = true;
    number = paramString;
    return this;
  }
  
  public final Builder setPending(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      hasPending = false;
      pending = false;
      return this;
    }
    hasPending = true;
    pending = paramBoolean.booleanValue();
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */