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

public final class NormPublication$Builder
  implements RecordTemplateBuilder<NormPublication>
{
  private List<NormContributor> authors = null;
  private Date date = null;
  private String description = null;
  private Urn entityUrn = null;
  private boolean hasAuthors = false;
  private boolean hasDate = false;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasName = false;
  private boolean hasPublisher = false;
  private boolean hasUrl = false;
  private String name = null;
  private String publisher = null;
  private String url = null;
  
  public NormPublication$Builder() {}
  
  public NormPublication$Builder(NormPublication paramNormPublication)
  {
    entityUrn = entityUrn;
    name = name;
    publisher = publisher;
    date = date;
    url = url;
    description = description;
    authors = authors;
    hasEntityUrn = hasEntityUrn;
    hasName = hasName;
    hasPublisher = hasPublisher;
    hasDate = hasDate;
    hasUrl = hasUrl;
    hasDescription = hasDescription;
    hasAuthors = hasAuthors;
  }
  
  public final NormPublication build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final NormPublication build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormPublication.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (authors != null)
    {
      paramFlavor = authors.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((NormContributor)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "authors");
            if (!hasName) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "name");
            }
            if (hasAuthors) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "authors");
          }
        }
      }
    }
    return new NormPublication(entityUrn, name, publisher, date, url, description, authors, hasEntityUrn, hasName, hasPublisher, hasDate, hasUrl, hasDescription, hasAuthors);
  }
  
  public final Builder setAuthors(List<NormContributor> paramList)
  {
    hasAuthors = true;
    authors = paramList;
    return this;
  }
  
  public final Builder setDate(Date paramDate)
  {
    if (paramDate == null)
    {
      hasDate = false;
      date = null;
      return this;
    }
    hasDate = true;
    date = paramDate;
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
  
  public final Builder setPublisher(String paramString)
  {
    if (paramString == null)
    {
      hasPublisher = false;
      publisher = null;
      return this;
    }
    hasPublisher = true;
    publisher = paramString;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */