package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SearchActionEvent
  implements RecordTemplate<SearchActionEvent>
{
  public static final SearchActionEventBuilder BUILDER = SearchActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final SearchActionType entityActionType;
  public final boolean hasEntityActionType;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasSearchHeader;
  public final boolean hasSearchResult;
  public final boolean hasSearchResultComponent;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final SearchHeader searchHeader;
  public final SearchResultHit searchResult;
  public final SearchResultComponent searchResultComponent;
  
  SearchActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, SearchHeader paramSearchHeader, SearchActionType paramSearchActionType, SearchResultHit paramSearchResultHit, SearchResultComponent paramSearchResultComponent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    searchHeader = paramSearchHeader;
    entityActionType = paramSearchActionType;
    searchResult = paramSearchResultHit;
    searchResultComponent = paramSearchResultComponent;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasSearchHeader = paramBoolean4;
    hasEntityActionType = paramBoolean5;
    hasSearchResult = paramBoolean6;
    hasSearchResultComponent = paramBoolean7;
    _cachedId = null;
  }
  
  private SearchActionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    label146:
    label158:
    Object localObject5;
    boolean bool4;
    label198:
    label210:
    Object localObject6;
    boolean bool5;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label397;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label406;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label424;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label433;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label451;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasSearchHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("searchHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label461;
        }
        localObject1 = searchHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label479;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      if (hasEntityActionType)
      {
        paramDataProcessor.startRecordField$505cff1c("entityActionType");
        paramDataProcessor.processEnum(entityActionType);
      }
      localObject6 = null;
      bool5 = false;
      if (hasSearchResult)
      {
        paramDataProcessor.startRecordField$505cff1c("searchResult");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label489;
        }
        localObject1 = searchResult.accept(paramDataProcessor);
        label275:
        if (localObject1 == null) {
          break label507;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      label287:
      localObject1 = null;
      bool6 = false;
      if (hasSearchResultComponent)
      {
        paramDataProcessor.startRecordField$505cff1c("searchResultComponent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label517;
        }
        localObject1 = searchResultComponent.accept(paramDataProcessor);
        label327:
        if (localObject1 == null) {
          break label535;
        }
      }
    }
    label397:
    label406:
    label424:
    label433:
    label451:
    label461:
    label479:
    label489:
    label507:
    label517:
    label535:
    for (boolean bool6 = true;; bool6 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label636;
      }
      try
      {
        if (hasHeader) {
          break label541;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (SearchHeader)paramDataProcessor.processDataTemplate(searchHeader);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (SearchResultHit)paramDataProcessor.processDataTemplate(searchResult);
      break label275;
      bool5 = false;
      localObject6 = localObject1;
      break label287;
      localObject1 = (SearchResultComponent)paramDataProcessor.processDataTemplate(searchResultComponent);
      break label327;
    }
    label541:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent", "requestHeader");
    }
    if (!hasSearchHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent", "searchHeader");
    }
    if (!hasSearchResult) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent", "searchResult");
    }
    return new SearchActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (SearchHeader)localObject5, entityActionType, (SearchResultHit)localObject6, (SearchResultComponent)localObject1, bool1, bool2, bool3, bool4, hasEntityActionType, bool5, bool6);
    label636:
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
      paramObject = (SearchActionEvent)paramObject;
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
      if (entityActionType != null)
      {
        if (entityActionType.equals(entityActionType)) {}
      }
      else {
        while (entityActionType != null) {
          return false;
        }
      }
      if (searchResult != null)
      {
        if (searchResult.equals(searchResult)) {}
      }
      else {
        while (searchResult != null) {
          return false;
        }
      }
      if (searchResultComponent == null) {
        break;
      }
    } while (searchResultComponent.equals(searchResultComponent));
    for (;;)
    {
      return false;
      if (searchResultComponent == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
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
    int n;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label176;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label181;
      }
      k = mobileHeader.hashCode();
      if (searchHeader == null) {
        break label186;
      }
      m = searchHeader.hashCode();
      if (entityActionType == null) {
        break label192;
      }
      n = entityActionType.hashCode();
      label92:
      if (searchResult == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = searchResult.hashCode();; i1 = 0)
    {
      if (searchResultComponent != null) {
        i2 = searchResultComponent.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
      break label92;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */