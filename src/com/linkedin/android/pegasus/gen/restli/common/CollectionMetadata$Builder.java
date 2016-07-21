package com.linkedin.android.pegasus.gen.restli.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class CollectionMetadata$Builder
  implements RecordTemplateBuilder<CollectionMetadata>
{
  private int count = 0;
  private boolean hasCount = false;
  private boolean hasLinks = false;
  private boolean hasStart = false;
  private boolean hasTotal = false;
  private List<Link> links = null;
  private int start = 0;
  private int total = 0;
  
  public CollectionMetadata$Builder() {}
  
  public CollectionMetadata$Builder(CollectionMetadata paramCollectionMetadata)
  {
    start = start;
    count = count;
    total = total;
    links = links;
    hasStart = hasStart;
    hasCount = hasCount;
    hasTotal = hasTotal;
    hasLinks = hasLinks;
  }
  
  public final CollectionMetadata build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final CollectionMetadata build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (CollectionMetadata.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (links != null)
    {
      paramFlavor = links.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Link)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "links");
            if (!hasTotal) {
              total = 0;
            }
            if (!hasStart) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "start");
            }
            if (!hasCount) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "count");
            }
            if (hasLinks) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata", "links");
          }
        }
      }
    }
    return new CollectionMetadata(start, count, total, links, hasStart, hasCount, hasTotal, hasLinks);
  }
  
  public final Builder setCount(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasCount = false;
      count = 0;
      return this;
    }
    hasCount = true;
    count = paramInteger.intValue();
    return this;
  }
  
  public final Builder setLinks(List<Link> paramList)
  {
    if (paramList == null)
    {
      hasLinks = false;
      links = null;
      return this;
    }
    hasLinks = true;
    links = paramList;
    return this;
  }
  
  public final Builder setStart(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasStart = false;
      start = 0;
      return this;
    }
    hasStart = true;
    start = paramInteger.intValue();
    return this;
  }
  
  public final Builder setTotal(Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger.intValue() == 0))
    {
      hasTotal = false;
      total = 0;
      return this;
    }
    hasTotal = true;
    total = paramInteger.intValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */