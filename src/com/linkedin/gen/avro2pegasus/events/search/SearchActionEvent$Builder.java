package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SearchActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SearchActionEvent>
{
  public SearchActionType entityActionType = null;
  public boolean hasEntityActionType = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasSearchHeader = false;
  public boolean hasSearchResult = false;
  public boolean hasSearchResultComponent = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public SearchHeader searchHeader = null;
  public SearchResultHit searchResult = null;
  public SearchResultComponent searchResultComponent = null;
  
  private SearchActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchActionEvent(header, requestHeader, mobileHeader, searchHeader, entityActionType, searchResult, searchResultComponent, hasHeader, hasRequestHeader, hasMobileHeader, hasSearchHeader, hasEntityActionType, hasSearchResult, hasSearchResultComponent);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent", "requestHeader");
      }
      if (!hasSearchHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent", "searchHeader");
      }
    } while (hasSearchResult);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent", "searchResult");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */