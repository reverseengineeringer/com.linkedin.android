package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.search.SearchHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MentionSuggestionImpressionEvent
  implements RecordTemplate<MentionSuggestionImpressionEvent>
{
  public static final MentionSuggestionImpressionEventBuilder BUILDER = MentionSuggestionImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMentionWorkflowId;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasResults;
  public final boolean hasSearchHeader;
  public final EventHeader header;
  public final String mentionWorkflowId;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final List<MentionResultHit> results;
  public final SearchHeader searchHeader;
  
  MentionSuggestionImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, SearchHeader paramSearchHeader, String paramString, List<MentionResultHit> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    searchHeader = paramSearchHeader;
    mentionWorkflowId = paramString;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      results = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasSearchHeader = paramBoolean4;
      hasMentionWorkflowId = paramBoolean5;
      hasResults = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  private MentionSuggestionImpressionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    Object localObject4;
    boolean bool3;
    label148:
    label160:
    Object localObject5;
    boolean bool4;
    label200:
    label212:
    int i;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label411;
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
          break label420;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label438;
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
          break label448;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label466;
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
          break label476;
        }
        localObject1 = searchHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label494;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      if (hasMentionWorkflowId)
      {
        paramDataProcessor.startRecordField$505cff1c("mentionWorkflowId");
        localObject1 = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(mentionWorkflowId));
      }
      localObject1 = null;
      localMentionResultHit = null;
      bool5 = false;
      if (!hasResults) {
        break label534;
      }
      paramDataProcessor.startRecordField$505cff1c("results");
      results.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localMentionResultHit;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = results.iterator();
      label320:
      if (!localIterator.hasNext()) {
        break label520;
      }
      localMentionResultHit = (MentionResultHit)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label504;
      }
    }
    label411:
    label420:
    label438:
    label448:
    label466:
    label476:
    label494:
    label504:
    for (MentionResultHit localMentionResultHit = localMentionResultHit.accept(paramDataProcessor);; localMentionResultHit = (MentionResultHit)paramDataProcessor.processDataTemplate(localMentionResultHit))
    {
      if ((localObject1 != null) && (localMentionResultHit != null)) {
        ((List)localObject1).add(localMentionResultHit);
      }
      i += 1;
      break label320;
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      bool3 = false;
      localObject4 = localObject1;
      break label160;
      localObject1 = (SearchHeader)paramDataProcessor.processDataTemplate(searchHeader);
      break label200;
      bool4 = false;
      localObject5 = localObject1;
      break label212;
    }
    label520:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label534:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label745;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "requestHeader");
    }
    if (!hasSearchHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "searchHeader");
    }
    if (!hasMentionWorkflowId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "mentionWorkflowId");
    }
    if (!hasResults) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "results");
    }
    if (results != null)
    {
      paramDataProcessor = results.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MentionResultHit)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "results");
        }
      }
    }
    return new MentionSuggestionImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (SearchHeader)localObject5, mentionWorkflowId, (List)localObject1, bool1, bool2, bool3, bool4, hasMentionWorkflowId, bool5);
    label745:
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
      paramObject = (MentionSuggestionImpressionEvent)paramObject;
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
      if (mentionWorkflowId != null)
      {
        if (mentionWorkflowId.equals(mentionWorkflowId)) {}
      }
      else {
        while (mentionWorkflowId != null) {
          return false;
        }
      }
      if (results == null) {
        break;
      }
    } while (results.equals(results));
    for (;;)
    {
      return false;
      if (results == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label156;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label161;
      }
      k = mobileHeader.hashCode();
      if (searchHeader == null) {
        break label166;
      }
      m = searchHeader.hashCode();
      label76:
      if (mentionWorkflowId == null) {
        break label172;
      }
    }
    label156:
    label161:
    label166:
    label172:
    for (int n = mentionWorkflowId.hashCode();; n = 0)
    {
      if (results != null) {
        i1 = results.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
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
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<MentionSuggestionImpressionEvent>
  {
    private boolean hasHeader = false;
    public boolean hasMentionWorkflowId = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasResults = false;
    public boolean hasSearchHeader = false;
    private EventHeader header = null;
    public String mentionWorkflowId = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public List<MentionResultHit> results = null;
    public SearchHeader searchHeader = null;
    
    private MentionSuggestionImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MentionSuggestionImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (results != null)
      {
        paramFlavor = results.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((MentionResultHit)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "results");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "requestHeader");
              }
              if (!hasSearchHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "searchHeader");
              }
              if (!hasMentionWorkflowId) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "mentionWorkflowId");
              }
              if (hasResults) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "results");
            }
          }
        }
      }
      return new MentionSuggestionImpressionEvent(header, requestHeader, mobileHeader, searchHeader, mentionWorkflowId, results, hasHeader, hasRequestHeader, hasMobileHeader, hasSearchHeader, hasMentionWorkflowId, hasResults);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */