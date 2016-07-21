package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Metadata$Builder
  implements RecordTemplateBuilder<Metadata>
{
  private boolean hasId = false;
  private boolean hasNewRelevanceFeed = false;
  private boolean hasPaginationToken = false;
  private boolean hasQueryAfterTime = false;
  private boolean hasSort = false;
  private boolean hasType = false;
  private String id = null;
  private boolean newRelevanceFeed = false;
  private String paginationToken = null;
  private long queryAfterTime = 0L;
  private SortOrder sort = null;
  private String type = null;
  
  public Metadata$Builder() {}
  
  public Metadata$Builder(Metadata paramMetadata)
  {
    id = id;
    type = type;
    queryAfterTime = queryAfterTime;
    paginationToken = paginationToken;
    sort = sort;
    newRelevanceFeed = newRelevanceFeed;
    hasId = hasId;
    hasType = hasType;
    hasQueryAfterTime = hasQueryAfterTime;
    hasPaginationToken = hasPaginationToken;
    hasSort = hasSort;
    hasNewRelevanceFeed = hasNewRelevanceFeed;
  }
  
  public final Metadata build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = Metadata.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new Metadata(id, type, queryAfterTime, paginationToken, sort, newRelevanceFeed, hasId, hasType, hasQueryAfterTime, hasPaginationToken, hasSort, hasNewRelevanceFeed);
  }
  
  public final Builder setSort(SortOrder paramSortOrder)
  {
    if (paramSortOrder == null)
    {
      hasSort = false;
      sort = null;
      return this;
    }
    hasSort = true;
    sort = paramSortOrder;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Metadata.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */