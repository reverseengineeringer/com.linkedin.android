package com.linkedin.gen.avro2pegasus.events.feed;

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
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

public final class FeedActionEvent
  implements RecordTemplate<FeedActionEvent>
{
  public static final FeedActionEventBuilder BUILDER = FeedActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ActionCategory actionCategory;
  public final String actionType;
  public final String controlUrn;
  public final boolean hasActionCategory;
  public final boolean hasActionType;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasModuleKey;
  public final boolean hasRequestHeader;
  public final boolean hasRequestId;
  public final boolean hasSearchId;
  public final boolean hasTrackingId;
  public final boolean hasUpdateUrn;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final String moduleKey;
  public final UserRequestHeader requestHeader;
  public final String requestId;
  public final String searchId;
  public final String trackingId;
  public final String updateUrn;
  
  FeedActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, String paramString3, String paramString4, ActionCategory paramActionCategory, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    moduleKey = paramString1;
    requestId = paramString2;
    trackingId = paramString3;
    updateUrn = paramString4;
    actionCategory = paramActionCategory;
    controlUrn = paramString5;
    actionType = paramString6;
    searchId = paramString7;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasModuleKey = paramBoolean4;
    hasRequestId = paramBoolean5;
    hasTrackingId = paramBoolean6;
    hasUpdateUrn = paramBoolean7;
    hasActionCategory = paramBoolean8;
    hasControlUrn = paramBoolean9;
    hasActionType = paramBoolean10;
    hasSearchId = paramBoolean11;
    _cachedId = null;
  }
  
  private FeedActionEvent accept(DataProcessor paramDataProcessor)
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
          break label424;
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
          break label433;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label451;
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
          break label460;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label478;
        }
      }
    }
    label424:
    label433:
    label451:
    label460:
    label478:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasModuleKey)
      {
        paramDataProcessor.startRecordField$505cff1c("moduleKey");
        paramDataProcessor.processString(moduleKey);
      }
      if (hasRequestId)
      {
        paramDataProcessor.startRecordField$505cff1c("requestId");
        paramDataProcessor.processString(requestId);
      }
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(trackingId));
      }
      if (hasUpdateUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("updateUrn");
        paramDataProcessor.processString(updateUrn);
      }
      if (hasActionCategory)
      {
        paramDataProcessor.startRecordField$505cff1c("actionCategory");
        paramDataProcessor.processEnum(actionCategory);
      }
      if (hasControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("controlUrn");
        paramDataProcessor.processString(controlUrn);
      }
      if (hasActionType)
      {
        paramDataProcessor.startRecordField$505cff1c("actionType");
        paramDataProcessor.processString(actionType);
      }
      if (hasSearchId)
      {
        paramDataProcessor.startRecordField$505cff1c("searchId");
        paramDataProcessor.processString(searchId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label680;
      }
      try
      {
        if (hasHeader) {
          break label484;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "header");
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
    label484:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "requestHeader");
    }
    if (!hasModuleKey) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "moduleKey");
    }
    if (!hasRequestId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "requestId");
    }
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "trackingId");
    }
    if (!hasUpdateUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "updateUrn");
    }
    if (!hasActionCategory) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "actionCategory");
    }
    return new FeedActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, moduleKey, requestId, trackingId, updateUrn, actionCategory, controlUrn, actionType, searchId, bool1, bool2, bool3, hasModuleKey, hasRequestId, hasTrackingId, hasUpdateUrn, hasActionCategory, hasControlUrn, hasActionType, hasSearchId);
    label680:
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
      paramObject = (FeedActionEvent)paramObject;
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
      if (moduleKey != null)
      {
        if (moduleKey.equals(moduleKey)) {}
      }
      else {
        while (moduleKey != null) {
          return false;
        }
      }
      if (requestId != null)
      {
        if (requestId.equals(requestId)) {}
      }
      else {
        while (requestId != null) {
          return false;
        }
      }
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
          return false;
        }
      }
      if (updateUrn != null)
      {
        if (updateUrn.equals(updateUrn)) {}
      }
      else {
        while (updateUrn != null) {
          return false;
        }
      }
      if (actionCategory != null)
      {
        if (actionCategory.equals(actionCategory)) {}
      }
      else {
        while (actionCategory != null) {
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
      if (actionType != null)
      {
        if (actionType.equals(actionType)) {}
      }
      else {
        while (actionType != null) {
          return false;
        }
      }
      if (searchId == null) {
        break;
      }
    } while (searchId.equals(searchId));
    for (;;)
    {
      return false;
      if (searchId == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i6 = 0;
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
    label140:
    int i4;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label264;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label269;
      }
      k = mobileHeader.hashCode();
      if (moduleKey == null) {
        break label274;
      }
      m = moduleKey.hashCode();
      if (requestId == null) {
        break label280;
      }
      n = requestId.hashCode();
      if (trackingId == null) {
        break label286;
      }
      i1 = trackingId.hashCode();
      if (updateUrn == null) {
        break label292;
      }
      i2 = updateUrn.hashCode();
      if (actionCategory == null) {
        break label298;
      }
      i3 = actionCategory.hashCode();
      if (controlUrn == null) {
        break label304;
      }
      i4 = controlUrn.hashCode();
      label156:
      if (actionType == null) {
        break label310;
      }
    }
    label264:
    label269:
    label274:
    label280:
    label286:
    label292:
    label298:
    label304:
    label310:
    for (int i5 = actionType.hashCode();; i5 = 0)
    {
      if (searchId != null) {
        i6 = searchId.hashCode();
      }
      i = (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6;
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
      i4 = 0;
      break label156;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<FeedActionEvent>
  {
    private ActionCategory actionCategory = null;
    private String actionType = null;
    public String controlUrn = null;
    private boolean hasActionCategory = false;
    private boolean hasActionType = false;
    public boolean hasControlUrn = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasModuleKey = false;
    private boolean hasRequestHeader = false;
    private boolean hasRequestId = false;
    private boolean hasSearchId = false;
    private boolean hasTrackingId = false;
    private boolean hasUpdateUrn = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private String moduleKey = null;
    private UserRequestHeader requestHeader = null;
    private String requestId = null;
    private String searchId = null;
    private String trackingId = null;
    private String updateUrn = null;
    
    private FeedActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (FeedActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new FeedActionEvent(header, requestHeader, mobileHeader, moduleKey, requestId, trackingId, updateUrn, actionCategory, controlUrn, actionType, searchId, hasHeader, hasRequestHeader, hasMobileHeader, hasModuleKey, hasRequestId, hasTrackingId, hasUpdateUrn, hasActionCategory, hasControlUrn, hasActionType, hasSearchId);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "requestHeader");
        }
        if (!hasModuleKey) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "moduleKey");
        }
        if (!hasRequestId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "requestId");
        }
        if (!hasTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "trackingId");
        }
        if (!hasUpdateUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "updateUrn");
        }
      } while (hasActionCategory);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "actionCategory");
    }
    
    public FeedActionEvent build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final Builder setActionCategory(ActionCategory paramActionCategory)
    {
      if (paramActionCategory == null)
      {
        hasActionCategory = false;
        actionCategory = null;
        return this;
      }
      hasActionCategory = true;
      actionCategory = paramActionCategory;
      return this;
    }
    
    public final Builder setActionType(String paramString)
    {
      if (paramString == null)
      {
        hasActionType = false;
        actionType = null;
        return this;
      }
      hasActionType = true;
      actionType = paramString;
      return this;
    }
    
    public final Builder setModuleKey(String paramString)
    {
      if (paramString == null)
      {
        hasModuleKey = false;
        moduleKey = null;
        return this;
      }
      hasModuleKey = true;
      moduleKey = paramString;
      return this;
    }
    
    public final Builder setRequestId(String paramString)
    {
      if (paramString == null)
      {
        hasRequestId = false;
        requestId = null;
        return this;
      }
      hasRequestId = true;
      requestId = paramString;
      return this;
    }
    
    public final Builder setTrackingId(String paramString)
    {
      if (paramString == null)
      {
        hasTrackingId = false;
        trackingId = null;
        return this;
      }
      hasTrackingId = true;
      trackingId = paramString;
      return this;
    }
    
    public final Builder setUpdateUrn(String paramString)
    {
      if (paramString == null)
      {
        hasUpdateUrn = false;
        updateUrn = null;
        return this;
      }
      hasUpdateUrn = true;
      updateUrn = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */