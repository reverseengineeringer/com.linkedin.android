package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SearchImpressionEvent
  implements RecordTemplate<SearchImpressionEvent>
{
  public static final SearchImpressionEventBuilder BUILDER = SearchImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<SearchResultComponent> components;
  public final List<SearchFacet> facetGuides;
  public final List<SearchFilter> filterGuides;
  public final boolean hasComponents;
  public final boolean hasFacetGuides;
  public final boolean hasFilterGuides;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasPageNum;
  public final boolean hasRequestHeader;
  public final boolean hasResults;
  public final boolean hasSearchHeader;
  public final boolean hasSuggestedSecondaryVerticals;
  public final boolean hasVerticalGuides;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final int pageNum;
  public final UserRequestHeader requestHeader;
  public final List<SearchResultHit> results;
  public final SearchHeader searchHeader;
  public final List<SearchVertical> suggestedSecondaryVerticals;
  public final List<SearchFilter> verticalGuides;
  
  SearchImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, SearchHeader paramSearchHeader, int paramInt, List<SearchResultHit> paramList, List<SearchVertical> paramList1, List<SearchResultComponent> paramList2, List<SearchFilter> paramList3, List<SearchFilter> paramList4, List<SearchFacet> paramList5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    searchHeader = paramSearchHeader;
    pageNum = paramInt;
    if (paramList == null)
    {
      paramEventHeader = null;
      results = paramEventHeader;
      if (paramList1 != null) {
        break label189;
      }
      paramEventHeader = null;
      label55:
      suggestedSecondaryVerticals = paramEventHeader;
      if (paramList2 != null) {
        break label198;
      }
      paramEventHeader = null;
      label67:
      components = paramEventHeader;
      if (paramList3 != null) {
        break label207;
      }
      paramEventHeader = null;
      label79:
      verticalGuides = paramEventHeader;
      if (paramList4 != null) {
        break label216;
      }
      paramEventHeader = null;
      label91:
      filterGuides = paramEventHeader;
      if (paramList5 != null) {
        break label225;
      }
    }
    label189:
    label198:
    label207:
    label216:
    label225:
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList5))
    {
      facetGuides = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasSearchHeader = paramBoolean4;
      hasPageNum = paramBoolean5;
      hasResults = paramBoolean6;
      hasSuggestedSecondaryVerticals = paramBoolean7;
      hasComponents = paramBoolean8;
      hasVerticalGuides = paramBoolean9;
      hasFilterGuides = paramBoolean10;
      hasFacetGuides = paramBoolean11;
      _cachedId = null;
      return;
      paramEventHeader = Collections.unmodifiableList(paramList);
      break;
      paramEventHeader = Collections.unmodifiableList(paramList1);
      break label55;
      paramEventHeader = Collections.unmodifiableList(paramList2);
      break label67;
      paramEventHeader = Collections.unmodifiableList(paramList3);
      break label79;
      paramEventHeader = Collections.unmodifiableList(paramList4);
      break label91;
    }
  }
  
  private SearchImpressionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject5 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject6;
    boolean bool2;
    label96:
    label108:
    Object localObject7;
    boolean bool3;
    label148:
    label160:
    Object localObject8;
    boolean bool4;
    label200:
    label212:
    boolean bool5;
    int i;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label399;
        }
        bool1 = true;
        localObject5 = localObject1;
      }
    }
    else
    {
      localObject6 = null;
      bool2 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label408;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label426;
        }
        bool2 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label436;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label454;
        }
        bool3 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool4 = false;
      if (hasSearchHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("searchHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label464;
        }
        localObject1 = searchHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label482;
        }
        bool4 = true;
        localObject8 = localObject1;
      }
      if (hasPageNum)
      {
        paramDataProcessor.startRecordField$505cff1c("pageNum");
        paramDataProcessor.processInt(pageNum);
      }
      localObject9 = null;
      localObject1 = null;
      bool5 = false;
      if (!hasResults) {
        break label526;
      }
      paramDataProcessor.startRecordField$505cff1c("results");
      results.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = results.iterator();
      label308:
      if (!((Iterator)localObject3).hasNext()) {
        break label508;
      }
      localObject2 = (SearchResultHit)((Iterator)localObject3).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label492;
      }
    }
    label399:
    label408:
    label426:
    label436:
    label454:
    label464:
    label482:
    label492:
    for (Object localObject2 = ((SearchResultHit)localObject2).accept(paramDataProcessor);; localObject2 = (SearchResultHit)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label308;
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject5 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      bool2 = false;
      localObject6 = localObject1;
      break label108;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      bool3 = false;
      localObject7 = localObject1;
      break label160;
      localObject1 = (SearchHeader)paramDataProcessor.processDataTemplate(searchHeader);
      break label200;
      bool4 = false;
      localObject8 = localObject1;
      break label212;
    }
    label508:
    paramDataProcessor.endArray();
    if (localObject1 != null) {
      bool5 = true;
    }
    label526:
    Object localObject10;
    boolean bool6;
    for (Object localObject9 = localObject1;; localObject9 = localObject1)
    {
      localObject10 = null;
      localObject1 = null;
      bool6 = false;
      if (!hasSuggestedSecondaryVerticals) {
        break label684;
      }
      paramDataProcessor.startRecordField$505cff1c("suggestedSecondaryVerticals");
      suggestedSecondaryVerticals.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = suggestedSecondaryVerticals.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SearchVertical)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processEnum((Enum)localObject3);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      bool5 = false;
    }
    paramDataProcessor.endArray();
    label684:
    boolean bool7;
    if (localObject1 != null)
    {
      bool6 = true;
      localObject10 = localObject1;
      localObject1 = null;
      localObject2 = null;
      bool7 = false;
      if (!hasComponents) {
        break label872;
      }
      paramDataProcessor.startRecordField$505cff1c("components");
      components.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = components.iterator();
      label759:
      if (!((Iterator)localObject3).hasNext()) {
        break label858;
      }
      localObject2 = (SearchResultComponent)((Iterator)localObject3).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label842;
      }
    }
    label842:
    for (localObject2 = ((SearchResultComponent)localObject2).accept(paramDataProcessor);; localObject2 = (SearchResultComponent)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label759;
      bool6 = false;
      localObject10 = localObject1;
      break;
    }
    label858:
    paramDataProcessor.endArray();
    label872:
    boolean bool8;
    if (localObject1 != null)
    {
      bool7 = true;
      localObject2 = null;
      localObject3 = null;
      bool8 = false;
      if (!hasVerticalGuides) {
        break label1056;
      }
      paramDataProcessor.startRecordField$505cff1c("verticalGuides");
      verticalGuides.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject4 = verticalGuides.iterator();
      label947:
      if (!((Iterator)localObject4).hasNext()) {
        break label1042;
      }
      localObject3 = (SearchFilter)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label1026;
      }
    }
    label1026:
    for (Object localObject3 = ((SearchFilter)localObject3).accept(paramDataProcessor);; localObject3 = (SearchFilter)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label947;
      bool7 = false;
      break;
    }
    label1042:
    paramDataProcessor.endArray();
    label1056:
    boolean bool9;
    if (localObject2 != null)
    {
      bool8 = true;
      localObject3 = null;
      localObject4 = null;
      bool9 = false;
      if (!hasFilterGuides) {
        break label1240;
      }
      paramDataProcessor.startRecordField$505cff1c("filterGuides");
      filterGuides.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      localObject11 = filterGuides.iterator();
      label1131:
      if (!((Iterator)localObject11).hasNext()) {
        break label1226;
      }
      localObject4 = (SearchFilter)((Iterator)localObject11).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label1210;
      }
    }
    label1210:
    for (Object localObject4 = ((SearchFilter)localObject4).accept(paramDataProcessor);; localObject4 = (SearchFilter)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject3 != null) && (localObject4 != null)) {
        ((List)localObject3).add(localObject4);
      }
      i += 1;
      break label1131;
      bool8 = false;
      break;
    }
    label1226:
    paramDataProcessor.endArray();
    if (localObject3 != null)
    {
      bool9 = true;
      label1240:
      localObject4 = null;
      localObject11 = null;
      bool10 = false;
      if (!hasFacetGuides) {
        break label1424;
      }
      paramDataProcessor.startRecordField$505cff1c("facetGuides");
      facetGuides.size();
      paramDataProcessor.startArray$13462e();
      localObject4 = localObject11;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject4 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = facetGuides.iterator();
      label1315:
      if (!localIterator.hasNext()) {
        break label1410;
      }
      localObject11 = (SearchFacet)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label1394;
      }
    }
    label1394:
    for (Object localObject11 = ((SearchFacet)localObject11).accept(paramDataProcessor);; localObject11 = (SearchFacet)paramDataProcessor.processDataTemplate((DataTemplate)localObject11))
    {
      if ((localObject4 != null) && (localObject11 != null)) {
        ((List)localObject4).add(localObject11);
      }
      i += 1;
      break label1315;
      bool9 = false;
      break;
    }
    label1410:
    paramDataProcessor.endArray();
    if (localObject4 != null) {}
    for (boolean bool10 = true;; bool10 = false)
    {
      label1424:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1953;
      }
      if (!hasComponents) {
        localObject1 = Collections.emptyList();
      }
      if (!hasVerticalGuides) {
        localObject2 = Collections.emptyList();
      }
      if (!hasFilterGuides) {
        localObject3 = Collections.emptyList();
      }
      if (!hasFacetGuides) {
        localObject4 = Collections.emptyList();
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
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
    if (!hasResults) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "results");
    }
    if (results != null)
    {
      paramDataProcessor = results.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchResultHit)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "results");
        }
      }
    }
    if (suggestedSecondaryVerticals != null)
    {
      paramDataProcessor = suggestedSecondaryVerticals.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchVertical)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "suggestedSecondaryVerticals");
        }
      }
    }
    if (components != null)
    {
      paramDataProcessor = components.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchResultComponent)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "components");
        }
      }
    }
    if (verticalGuides != null)
    {
      paramDataProcessor = verticalGuides.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchFilter)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "verticalGuides");
        }
      }
    }
    if (filterGuides != null)
    {
      paramDataProcessor = filterGuides.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchFilter)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "filterGuides");
        }
      }
    }
    if (facetGuides != null)
    {
      paramDataProcessor = facetGuides.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchFacet)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent", "facetGuides");
        }
      }
    }
    return new SearchImpressionEvent((EventHeader)localObject5, (UserRequestHeader)localObject6, (MobileHeader)localObject7, (SearchHeader)localObject8, pageNum, (List)localObject9, (List)localObject10, (List)localObject1, (List)localObject2, (List)localObject3, (List)localObject4, bool1, bool2, bool3, bool4, hasPageNum, bool5, bool6, bool7, bool8, bool9, bool10);
    label1953:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (SearchImpressionEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (searchHeader != null)
      {
        if (searchHeader.equals(searchHeader)) {}
      }
      else {
        while (searchHeader != null) {
          return false;
        }
      }
      if (pageNum != pageNum) {
        return false;
      }
      if (results != null)
      {
        if (results.equals(results)) {}
      }
      else {
        while (results != null) {
          return false;
        }
      }
      if (suggestedSecondaryVerticals != null)
      {
        if (suggestedSecondaryVerticals.equals(suggestedSecondaryVerticals)) {}
      }
      else {
        while (suggestedSecondaryVerticals != null) {
          return false;
        }
      }
      if (components != null)
      {
        if (components.equals(components)) {}
      }
      else {
        while (components != null) {
          return false;
        }
      }
      if (verticalGuides != null)
      {
        if (verticalGuides.equals(verticalGuides)) {}
      }
      else {
        while (verticalGuides != null) {
          return false;
        }
      }
      if (filterGuides != null)
      {
        if (filterGuides.equals(filterGuides)) {}
      }
      else {
        while (filterGuides != null) {
          return false;
        }
      }
      if (facetGuides == null) {
        break;
      }
    } while (facetGuides.equals(facetGuides));
    for (;;)
    {
      return false;
      if (facetGuides == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i5 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int i6;
    int n;
    label100:
    int i1;
    label118:
    int i2;
    label136:
    int i3;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label266;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label271;
      }
      k = mobileHeader.hashCode();
      if (searchHeader == null) {
        break label276;
      }
      m = searchHeader.hashCode();
      i6 = pageNum;
      if (results == null) {
        break label282;
      }
      n = results.hashCode();
      if (suggestedSecondaryVerticals == null) {
        break label288;
      }
      i1 = suggestedSecondaryVerticals.hashCode();
      if (components == null) {
        break label294;
      }
      i2 = components.hashCode();
      if (verticalGuides == null) {
        break label300;
      }
      i3 = verticalGuides.hashCode();
      label154:
      if (filterGuides == null) {
        break label306;
      }
    }
    label266:
    label271:
    label276:
    label282:
    label288:
    label294:
    label300:
    label306:
    for (int i4 = filterGuides.hashCode();; i4 = 0)
    {
      if (facetGuides != null) {
        i5 = facetGuides.hashCode();
      }
      i = (i4 + (i3 + (i2 + (i1 + (n + ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i6) * 31) * 31) * 31) * 31) * 31) * 31 + i5;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label100;
      i1 = 0;
      break label118;
      i2 = 0;
      break label136;
      i3 = 0;
      break label154;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */