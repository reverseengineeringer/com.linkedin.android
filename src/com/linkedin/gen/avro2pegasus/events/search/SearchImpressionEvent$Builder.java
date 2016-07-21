package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SearchImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SearchImpressionEvent>
{
  public List<SearchResultComponent> components = null;
  private List<SearchFacet> facetGuides = null;
  public List<SearchFilter> filterGuides = null;
  public boolean hasComponents = false;
  private boolean hasFacetGuides = false;
  public boolean hasFilterGuides = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasPageNum = false;
  private boolean hasRequestHeader = false;
  public boolean hasResults = false;
  public boolean hasSearchHeader = false;
  public boolean hasSuggestedSecondaryVerticals = false;
  private boolean hasVerticalGuides = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public int pageNum = 0;
  private UserRequestHeader requestHeader = null;
  public List<SearchResultHit> results = null;
  public SearchHeader searchHeader = null;
  public List<SearchVertical> suggestedSecondaryVerticals = null;
  private List<SearchFilter> verticalGuides = null;
  
  private SearchImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (results != null)
    {
      paramFlavor = results.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((SearchResultHit)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "results");
            if (!hasComponents) {
              components = Collections.emptyList();
            }
            if (!hasVerticalGuides) {
              verticalGuides = Collections.emptyList();
            }
            if (!hasFilterGuides) {
              filterGuides = Collections.emptyList();
            }
            if (!hasFacetGuides) {
              facetGuides = Collections.emptyList();
            }
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "requestHeader");
            }
            if (!hasSearchHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "searchHeader");
            }
            if (!hasPageNum) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "pageNum");
            }
            if (hasResults) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "results");
          }
        }
      }
    }
    if (suggestedSecondaryVerticals != null)
    {
      paramFlavor = suggestedSecondaryVerticals.iterator();
      while (paramFlavor.hasNext()) {
        if ((SearchVertical)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "suggestedSecondaryVerticals");
        }
      }
    }
    if (components != null)
    {
      paramFlavor = components.iterator();
      while (paramFlavor.hasNext()) {
        if ((SearchResultComponent)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "components");
        }
      }
    }
    if (verticalGuides != null)
    {
      paramFlavor = verticalGuides.iterator();
      while (paramFlavor.hasNext()) {
        if ((SearchFilter)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "verticalGuides");
        }
      }
    }
    if (filterGuides != null)
    {
      paramFlavor = filterGuides.iterator();
      while (paramFlavor.hasNext()) {
        if ((SearchFilter)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "filterGuides");
        }
      }
    }
    if (facetGuides != null)
    {
      paramFlavor = facetGuides.iterator();
      while (paramFlavor.hasNext()) {
        if ((SearchFacet)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "facetGuides");
        }
      }
    }
    return new SearchImpressionEvent(header, requestHeader, mobileHeader, searchHeader, pageNum, results, suggestedSecondaryVerticals, components, verticalGuides, filterGuides, facetGuides, hasHeader, hasRequestHeader, hasMobileHeader, hasSearchHeader, hasPageNum, hasResults, hasSuggestedSecondaryVerticals, hasComponents, hasVerticalGuides, hasFilterGuides, hasFacetGuides);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */