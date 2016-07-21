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
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.search.SearchHeader;

public final class MentionSuggestionStartEvent
  implements RecordTemplate<MentionSuggestionStartEvent>
{
  public static final MentionSuggestionStartEventBuilder BUILDER = MentionSuggestionStartEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String associatedEntityUrn;
  public final String associatedInputControlUrn;
  public final boolean hasAssociatedEntityUrn;
  public final boolean hasAssociatedInputControlUrn;
  public final boolean hasHeader;
  public final boolean hasMentionStartOperator;
  public final boolean hasMentionType;
  public final boolean hasMentionWorkflowId;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasRootObject;
  public final boolean hasSearchHeader;
  public final EventHeader header;
  public final String mentionStartOperator;
  public final MentionType mentionType;
  public final String mentionWorkflowId;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final TrackingObject rootObject;
  public final SearchHeader searchHeader;
  
  MentionSuggestionStartEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, SearchHeader paramSearchHeader, String paramString1, String paramString2, String paramString3, TrackingObject paramTrackingObject, MentionType paramMentionType, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    searchHeader = paramSearchHeader;
    mentionWorkflowId = paramString1;
    associatedInputControlUrn = paramString2;
    associatedEntityUrn = paramString3;
    rootObject = paramTrackingObject;
    mentionType = paramMentionType;
    mentionStartOperator = paramString4;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasSearchHeader = paramBoolean4;
    hasMentionWorkflowId = paramBoolean5;
    hasAssociatedInputControlUrn = paramBoolean6;
    hasAssociatedEntityUrn = paramBoolean7;
    hasRootObject = paramBoolean8;
    hasMentionType = paramBoolean9;
    hasMentionStartOperator = paramBoolean10;
    _cachedId = null;
  }
  
  private MentionSuggestionStartEvent accept(DataProcessor paramDataProcessor)
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
          break label453;
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
          break label462;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label480;
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
          break label489;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label507;
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
          break label517;
        }
        localObject1 = searchHeader.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label535;
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
      if (hasAssociatedInputControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("associatedInputControlUrn");
        paramDataProcessor.processString(associatedInputControlUrn);
      }
      if (hasAssociatedEntityUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("associatedEntityUrn");
        paramDataProcessor.processString(associatedEntityUrn);
      }
      localObject1 = null;
      bool5 = false;
      if (hasRootObject)
      {
        paramDataProcessor.startRecordField$505cff1c("rootObject");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label545;
        }
        localObject1 = rootObject.accept(paramDataProcessor);
        label333:
        if (localObject1 == null) {
          break label563;
        }
      }
    }
    label453:
    label462:
    label480:
    label489:
    label507:
    label517:
    label535:
    label545:
    label563:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (hasMentionType)
      {
        paramDataProcessor.startRecordField$505cff1c("mentionType");
        paramDataProcessor.processEnum(mentionType);
      }
      if (hasMentionStartOperator)
      {
        paramDataProcessor.startRecordField$505cff1c("mentionStartOperator");
        paramDataProcessor.processString(mentionStartOperator);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label730;
      }
      try
      {
        if (hasHeader) {
          break label569;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "header");
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
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(rootObject);
      break label333;
    }
    label569:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "requestHeader");
    }
    if (!hasSearchHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "searchHeader");
    }
    if (!hasMentionWorkflowId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "mentionWorkflowId");
    }
    if (!hasAssociatedInputControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "associatedInputControlUrn");
    }
    if (!hasMentionType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "mentionType");
    }
    return new MentionSuggestionStartEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (SearchHeader)localObject5, mentionWorkflowId, associatedInputControlUrn, associatedEntityUrn, (TrackingObject)localObject1, mentionType, mentionStartOperator, bool1, bool2, bool3, bool4, hasMentionWorkflowId, hasAssociatedInputControlUrn, hasAssociatedEntityUrn, bool5, hasMentionType, hasMentionStartOperator);
    label730:
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
      paramObject = (MentionSuggestionStartEvent)paramObject;
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
      if (associatedInputControlUrn != null)
      {
        if (associatedInputControlUrn.equals(associatedInputControlUrn)) {}
      }
      else {
        while (associatedInputControlUrn != null) {
          return false;
        }
      }
      if (associatedEntityUrn != null)
      {
        if (associatedEntityUrn.equals(associatedEntityUrn)) {}
      }
      else {
        while (associatedEntityUrn != null) {
          return false;
        }
      }
      if (rootObject != null)
      {
        if (rootObject.equals(rootObject)) {}
      }
      else {
        while (rootObject != null) {
          return false;
        }
      }
      if (mentionType != null)
      {
        if (mentionType.equals(mentionType)) {}
      }
      else {
        while (mentionType != null) {
          return false;
        }
      }
      if (mentionStartOperator == null) {
        break;
      }
    } while (mentionStartOperator.equals(mentionStartOperator));
    for (;;)
    {
      return false;
      if (mentionStartOperator == null) {
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
    int n;
    label92:
    int i1;
    label108:
    int i2;
    label124:
    int i3;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label242;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label247;
      }
      k = mobileHeader.hashCode();
      if (searchHeader == null) {
        break label252;
      }
      m = searchHeader.hashCode();
      if (mentionWorkflowId == null) {
        break label258;
      }
      n = mentionWorkflowId.hashCode();
      if (associatedInputControlUrn == null) {
        break label264;
      }
      i1 = associatedInputControlUrn.hashCode();
      if (associatedEntityUrn == null) {
        break label270;
      }
      i2 = associatedEntityUrn.hashCode();
      if (rootObject == null) {
        break label276;
      }
      i3 = rootObject.hashCode();
      label140:
      if (mentionType == null) {
        break label282;
      }
    }
    label242:
    label247:
    label252:
    label258:
    label264:
    label270:
    label276:
    label282:
    for (int i4 = mentionType.hashCode();; i4 = 0)
    {
      if (mentionStartOperator != null) {
        i5 = mentionStartOperator.hashCode();
      }
      i = (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i5;
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
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
      i3 = 0;
      break label140;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<MentionSuggestionStartEvent>
  {
    public String associatedEntityUrn = null;
    public String associatedInputControlUrn = null;
    public boolean hasAssociatedEntityUrn = false;
    public boolean hasAssociatedInputControlUrn = false;
    private boolean hasHeader = false;
    public boolean hasMentionStartOperator = false;
    public boolean hasMentionType = false;
    public boolean hasMentionWorkflowId = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasRootObject = false;
    public boolean hasSearchHeader = false;
    private EventHeader header = null;
    public String mentionStartOperator = null;
    public MentionType mentionType = null;
    public String mentionWorkflowId = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public TrackingObject rootObject = null;
    public SearchHeader searchHeader = null;
    
    private MentionSuggestionStartEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MentionSuggestionStartEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new MentionSuggestionStartEvent(header, requestHeader, mobileHeader, searchHeader, mentionWorkflowId, associatedInputControlUrn, associatedEntityUrn, rootObject, mentionType, mentionStartOperator, hasHeader, hasRequestHeader, hasMobileHeader, hasSearchHeader, hasMentionWorkflowId, hasAssociatedInputControlUrn, hasAssociatedEntityUrn, hasRootObject, hasMentionType, hasMentionStartOperator);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "requestHeader");
        }
        if (!hasSearchHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "searchHeader");
        }
        if (!hasMentionWorkflowId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "mentionWorkflowId");
        }
        if (!hasAssociatedInputControlUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "associatedInputControlUrn");
        }
      } while (hasMentionType);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "mentionType");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */