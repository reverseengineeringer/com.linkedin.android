package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.search.SearchHeader;

public final class MentionSuggestionActionEvent
  implements RecordTemplate<MentionSuggestionActionEvent>
{
  public static final MentionSuggestionActionEventBuilder BUILDER = MentionSuggestionActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final MentionActionType actionType;
  public final boolean hasActionType;
  public final boolean hasHeader;
  public final boolean hasMentionWorkflowId;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasResult;
  public final boolean hasSearchHeader;
  public final EventHeader header;
  public final String mentionWorkflowId;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final MentionResultHit result;
  public final SearchHeader searchHeader;
  
  MentionSuggestionActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, SearchHeader paramSearchHeader, String paramString, MentionActionType paramMentionActionType, MentionResultHit paramMentionResultHit, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    searchHeader = paramSearchHeader;
    mentionWorkflowId = paramString;
    actionType = paramMentionActionType;
    result = paramMentionResultHit;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasSearchHeader = paramBoolean4;
    hasMentionWorkflowId = paramBoolean5;
    hasActionType = paramBoolean6;
    hasResult = paramBoolean7;
    _cachedId = null;
  }
  
  private MentionSuggestionActionEvent accept(DataProcessor paramDataProcessor)
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
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label378;
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
          break label387;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label405;
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
          break label414;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label432;
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
          break label442;
        }
        localObject1 = searchHeader.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label460;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label210:
      if (hasMentionWorkflowId)
      {
        paramDataProcessor.startRecordField$505cff1c("mentionWorkflowId");
        localObject1 = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(mentionWorkflowId));
      }
      if (hasActionType)
      {
        paramDataProcessor.startRecordField$505cff1c("actionType");
        paramDataProcessor.processEnum(actionType);
      }
      localObject1 = null;
      bool5 = false;
      if (hasResult)
      {
        paramDataProcessor.startRecordField$505cff1c("result");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label470;
        }
        localObject1 = result.accept(paramDataProcessor);
        label308:
        if (localObject1 == null) {
          break label488;
        }
      }
    }
    label378:
    label387:
    label405:
    label414:
    label432:
    label442:
    label460:
    label470:
    label488:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label612;
      }
      try
      {
        if (hasHeader) {
          break label494;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "header");
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
      localObject1 = (MentionResultHit)paramDataProcessor.processDataTemplate(result);
      break label308;
    }
    label494:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "requestHeader");
    }
    if (!hasSearchHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "searchHeader");
    }
    if (!hasMentionWorkflowId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "mentionWorkflowId");
    }
    if (!hasActionType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "actionType");
    }
    return new MentionSuggestionActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (SearchHeader)localObject5, mentionWorkflowId, actionType, (MentionResultHit)localObject1, bool1, bool2, bool3, bool4, hasMentionWorkflowId, hasActionType, bool5);
    label612:
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
      paramObject = (MentionSuggestionActionEvent)paramObject;
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
      if (actionType != null)
      {
        if (actionType.equals(actionType)) {}
      }
      else {
        while (actionType != null) {
          return false;
        }
      }
      if (result == null) {
        break;
      }
    } while (result.equals(result));
    for (;;)
    {
      return false;
      if (result == null) {
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
      if (mentionWorkflowId == null) {
        break label192;
      }
      n = mentionWorkflowId.hashCode();
      label92:
      if (actionType == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = actionType.hashCode();; i1 = 0)
    {
      if (result != null) {
        i2 = result.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<MentionSuggestionActionEvent>
  {
    public MentionActionType actionType = null;
    public boolean hasActionType = false;
    private boolean hasHeader = false;
    public boolean hasMentionWorkflowId = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasResult = false;
    public boolean hasSearchHeader = false;
    private EventHeader header = null;
    public String mentionWorkflowId = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public MentionResultHit result = null;
    public SearchHeader searchHeader = null;
    
    private MentionSuggestionActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MentionSuggestionActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new MentionSuggestionActionEvent(header, requestHeader, mobileHeader, searchHeader, mentionWorkflowId, actionType, result, hasHeader, hasRequestHeader, hasMobileHeader, hasSearchHeader, hasMentionWorkflowId, hasActionType, hasResult);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "requestHeader");
        }
        if (!hasSearchHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "searchHeader");
        }
        if (!hasMentionWorkflowId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "mentionWorkflowId");
        }
      } while (hasActionType);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "actionType");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */