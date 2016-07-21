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

public final class Publication$Builder
  implements RecordTemplateBuilder<Publication>
{
  public List<Contributor> authors = null;
  private Date date = null;
  private String description = null;
  private Urn entityUrn = null;
  public boolean hasAuthors = false;
  private boolean hasDate = false;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasName = false;
  private boolean hasPublisher = false;
  private boolean hasUrl = false;
  private String name = null;
  private String publisher = null;
  private String url = null;
  
  public Publication$Builder() {}
  
  public Publication$Builder(Publication paramPublication)
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
  
  public final Publication build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Publication.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (authors != null)
    {
      paramFlavor = authors.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Contributor)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication", "authors");
            if (!hasName) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication", "name");
            }
            if (hasAuthors) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication", "authors");
          }
        }
      }
    }
    return new Publication(entityUrn, name, publisher, date, url, description, authors, hasEntityUrn, hasName, hasPublisher, hasDate, hasUrl, hasDescription, hasAuthors);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */