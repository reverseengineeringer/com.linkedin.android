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

public final class Patent$Builder
  implements RecordTemplateBuilder<Patent>
{
  private String applicationNumber = null;
  private String description = null;
  private Urn entityUrn = null;
  private Date filingDate = null;
  private boolean hasApplicationNumber = false;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasFilingDate = false;
  public boolean hasInventors = false;
  private boolean hasIssueDate = false;
  private boolean hasIssuer = false;
  private boolean hasLocalizedIssuerCountryName = false;
  private boolean hasNumber = false;
  private boolean hasPending = false;
  private boolean hasTitle = false;
  private boolean hasUrl = false;
  public List<Contributor> inventors = null;
  private Date issueDate = null;
  private String issuer = null;
  private String localizedIssuerCountryName = null;
  private String number = null;
  private boolean pending = false;
  private String title = null;
  private String url = null;
  
  public Patent$Builder() {}
  
  public Patent$Builder(Patent paramPatent)
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
  
  public final Patent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Patent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (inventors != null)
    {
      paramFlavor = inventors.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Contributor)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "inventors");
            if (!hasTitle) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "title");
            }
            if (!hasIssuer) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "issuer");
            }
            if (!hasPending) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "pending");
            }
            if (hasInventors) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "inventors");
          }
        }
      }
    }
    return new Patent(entityUrn, number, applicationNumber, title, issuer, url, pending, filingDate, issueDate, description, localizedIssuerCountryName, inventors, hasEntityUrn, hasNumber, hasApplicationNumber, hasTitle, hasIssuer, hasUrl, hasPending, hasFilingDate, hasIssueDate, hasDescription, hasLocalizedIssuerCountryName, hasInventors);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */