package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class NormProject$Builder
  implements RecordTemplateBuilder<NormProject>
{
  private String description = null;
  private Urn entityUrn = null;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasMembers = false;
  private boolean hasOccupation = false;
  private boolean hasTimePeriod = false;
  private boolean hasTitle = false;
  private boolean hasUrl = false;
  private List<NormContributor> members = null;
  private Urn occupation = null;
  private DateRange timePeriod = null;
  private String title = null;
  private String url = null;
  
  public NormProject$Builder() {}
  
  public NormProject$Builder(NormProject paramNormProject)
  {
    entityUrn = entityUrn;
    title = title;
    url = url;
    description = description;
    occupation = occupation;
    timePeriod = timePeriod;
    members = members;
    hasEntityUrn = hasEntityUrn;
    hasTitle = hasTitle;
    hasUrl = hasUrl;
    hasDescription = hasDescription;
    hasOccupation = hasOccupation;
    hasTimePeriod = hasTimePeriod;
    hasMembers = hasMembers;
  }
  
  public final NormProject build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormProject.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (members != null)
    {
      paramFlavor = members.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((NormContributor)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "members");
            if (!hasTitle) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "title");
            }
            if (hasMembers) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "members");
          }
        }
      }
    }
    return new NormProject(entityUrn, title, url, description, occupation, timePeriod, members, hasEntityUrn, hasTitle, hasUrl, hasDescription, hasOccupation, hasTimePeriod, hasMembers);
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
  
  public final Builder setMembers(List<NormContributor> paramList)
  {
    hasMembers = true;
    members = paramList;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */