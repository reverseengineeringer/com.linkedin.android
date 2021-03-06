package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class Comments$Builder
  implements RecordTemplateBuilder<Comments>
{
  private List<Comment> elements = null;
  private boolean hasElements = false;
  private boolean hasMetadata = false;
  private boolean hasPaging = false;
  private Metadata metadata = null;
  private CollectionMetadata paging = null;
  
  public Comments$Builder() {}
  
  public Comments$Builder(Comments paramComments)
  {
    elements = elements;
    paging = paging;
    metadata = metadata;
    hasElements = hasElements;
    hasPaging = hasPaging;
    hasMetadata = hasMetadata;
  }
  
  public final Comments build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Comments build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Comments.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (elements != null)
    {
      paramFlavor = elements.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Comment)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "elements");
            if (!hasElements) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "elements");
            }
            if (hasPaging) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comments", "paging");
          }
        }
      }
    }
    return new Comments(elements, paging, metadata, hasElements, hasPaging, hasMetadata);
  }
  
  public final Builder setElements(List<Comment> paramList)
  {
    if (paramList == null)
    {
      hasElements = false;
      elements = null;
      return this;
    }
    hasElements = true;
    elements = paramList;
    return this;
  }
  
  public final Builder setMetadata(Metadata paramMetadata)
  {
    if (paramMetadata == null)
    {
      hasMetadata = false;
      metadata = null;
      return this;
    }
    hasMetadata = true;
    metadata = paramMetadata;
    return this;
  }
  
  public final Builder setPaging(CollectionMetadata paramCollectionMetadata)
  {
    if (paramCollectionMetadata == null)
    {
      hasPaging = false;
      paging = null;
      return this;
    }
    hasPaging = true;
    paging = paramCollectionMetadata;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Comments.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */