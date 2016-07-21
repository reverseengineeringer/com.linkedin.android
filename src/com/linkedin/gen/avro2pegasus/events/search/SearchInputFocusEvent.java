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

public final class SearchInputFocusEvent
  implements RecordTemplate<SearchInputFocusEvent>
{
  public static final SearchInputFocusEventBuilder BUILDER = SearchInputFocusEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String controlUrn;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasTagValue;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final String tagValue;
  
  SearchInputFocusEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    controlUrn = paramString1;
    tagValue = paramString2;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasControlUrn = paramBoolean4;
    hasTagValue = paramBoolean5;
    _cachedId = null;
  }
  
  private SearchInputFocusEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label266;
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
          break label275;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label293;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label302;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label320;
        }
      }
    }
    label266:
    label275:
    label293:
    label302:
    label320:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("controlUrn");
        paramDataProcessor.processString(controlUrn);
      }
      if (hasTagValue)
      {
        paramDataProcessor.startRecordField$505cff1c("tagValue");
        paramDataProcessor.processString(tagValue);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label398;
      }
      try
      {
        if (hasHeader) {
          break label326;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "header");
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
    }
    label326:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "requestHeader");
    }
    if (!hasControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "controlUrn");
    }
    return new SearchInputFocusEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, controlUrn, tagValue, bool1, bool2, bool3, hasControlUrn, hasTagValue);
    label398:
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
      paramObject = (SearchInputFocusEvent)paramObject;
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
      if (controlUrn != null)
      {
        if (controlUrn.equals(controlUrn)) {}
      }
      else {
        while (controlUrn != null) {
          return false;
        }
      }
      if (tagValue == null) {
        break;
      }
    } while (tagValue.equals(tagValue));
    for (;;)
    {
      return false;
      if (tagValue == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label132;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label137;
      }
      k = mobileHeader.hashCode();
      label60:
      if (controlUrn == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = controlUrn.hashCode();; m = 0)
    {
      if (tagValue != null) {
        n = tagValue.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<SearchInputFocusEvent>
  {
    public String controlUrn = null;
    public boolean hasControlUrn = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasTagValue = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public String tagValue = null;
    
    private SearchInputFocusEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SearchInputFocusEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SearchInputFocusEvent(header, requestHeader, mobileHeader, controlUrn, tagValue, hasHeader, hasRequestHeader, hasMobileHeader, hasControlUrn, hasTagValue);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "requestHeader");
        }
      } while (hasControlUrn);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent", "controlUrn");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */