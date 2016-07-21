package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchResultHitInfo$Builder
  implements RecordTemplateBuilder<SearchResultHitInfo>
{
  public EntityAwareSuggestionInfo entityAwareSuggestionInfo = null;
  public boolean hasEntityAwareSuggestionInfo = false;
  public boolean hasSecondarySearchResultInfo = false;
  public SecondarySearchResultInfo secondarySearchResultInfo = null;
  
  public final SearchResultHitInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = SearchResultHitInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new SearchResultHitInfo(secondarySearchResultInfo, entityAwareSuggestionInfo, hasSecondarySearchResultInfo, hasEntityAwareSuggestionInfo);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultHitInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */