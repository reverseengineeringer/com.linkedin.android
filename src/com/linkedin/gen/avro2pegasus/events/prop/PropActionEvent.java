package com.linkedin.gen.avro2pegasus.events.prop;

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

public final class PropActionEvent
  implements RecordTemplate<PropActionEvent>
{
  public static final PropActionEventBuilder BUILDER = PropActionEventBuilder.INSTANCE;
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
  public final boolean hasPropUrn;
  public final boolean hasRequestHeader;
  public final boolean hasTrackingId;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final String moduleKey;
  public final String propUrn;
  public final UserRequestHeader requestHeader;
  public final String trackingId;
  
  PropActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, String paramString3, ActionCategory paramActionCategory, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    moduleKey = paramString1;
    trackingId = paramString2;
    propUrn = paramString3;
    actionCategory = paramActionCategory;
    controlUrn = paramString4;
    actionType = paramString5;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasModuleKey = paramBoolean4;
    hasTrackingId = paramBoolean5;
    hasPropUrn = paramBoolean6;
    hasActionCategory = paramBoolean7;
    hasControlUrn = paramBoolean8;
    hasActionType = paramBoolean9;
    _cachedId = null;
  }
  
  private PropActionEvent accept(DataProcessor paramDataProcessor)
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
          break label374;
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
          break label383;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label401;
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
          break label410;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label428;
        }
      }
    }
    label374:
    label383:
    label401:
    label410:
    label428:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasModuleKey)
      {
        paramDataProcessor.startRecordField$505cff1c("moduleKey");
        paramDataProcessor.processString(moduleKey);
      }
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(trackingId));
      }
      if (hasPropUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("propUrn");
        paramDataProcessor.processString(propUrn);
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
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label595;
      }
      try
      {
        if (hasHeader) {
          break label434;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "header");
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
    label434:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "requestHeader");
    }
    if (!hasModuleKey) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "moduleKey");
    }
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "trackingId");
    }
    if (!hasPropUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "propUrn");
    }
    if (!hasActionCategory) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "actionCategory");
    }
    return new PropActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, moduleKey, trackingId, propUrn, actionCategory, controlUrn, actionType, bool1, bool2, bool3, hasModuleKey, hasTrackingId, hasPropUrn, hasActionCategory, hasControlUrn, hasActionType);
    label595:
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
      paramObject = (PropActionEvent)paramObject;
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
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
          return false;
        }
      }
      if (propUrn != null)
      {
        if (propUrn.equals(propUrn)) {}
      }
      else {
        while (propUrn != null) {
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
      if (actionType == null) {
        break;
      }
    } while (actionType.equals(actionType));
    for (;;)
    {
      return false;
      if (actionType == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
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
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label220;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label225;
      }
      k = mobileHeader.hashCode();
      if (moduleKey == null) {
        break label230;
      }
      m = moduleKey.hashCode();
      if (trackingId == null) {
        break label236;
      }
      n = trackingId.hashCode();
      if (propUrn == null) {
        break label242;
      }
      i1 = propUrn.hashCode();
      if (actionCategory == null) {
        break label248;
      }
      i2 = actionCategory.hashCode();
      label124:
      if (controlUrn == null) {
        break label254;
      }
    }
    label220:
    label225:
    label230:
    label236:
    label242:
    label248:
    label254:
    for (int i3 = controlUrn.hashCode();; i3 = 0)
    {
      if (actionType != null) {
        i4 = actionType.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
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
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<PropActionEvent>
  {
    private ActionCategory actionCategory = null;
    private String actionType = null;
    private String controlUrn = null;
    private boolean hasActionCategory = false;
    private boolean hasActionType = false;
    private boolean hasControlUrn = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasModuleKey = false;
    private boolean hasPropUrn = false;
    private boolean hasRequestHeader = false;
    private boolean hasTrackingId = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private String moduleKey = null;
    private String propUrn = null;
    private UserRequestHeader requestHeader = null;
    private String trackingId = null;
    
    private PropActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PropActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PropActionEvent(header, requestHeader, mobileHeader, moduleKey, trackingId, propUrn, actionCategory, controlUrn, actionType, hasHeader, hasRequestHeader, hasMobileHeader, hasModuleKey, hasTrackingId, hasPropUrn, hasActionCategory, hasControlUrn, hasActionType);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "requestHeader");
        }
        if (!hasModuleKey) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "moduleKey");
        }
        if (!hasTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "trackingId");
        }
        if (!hasPropUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "propUrn");
        }
      } while (hasActionCategory);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "actionCategory");
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
    
    public final Builder setControlUrn(String paramString)
    {
      if (paramString == null)
      {
        hasControlUrn = false;
        controlUrn = null;
        return this;
      }
      hasControlUrn = true;
      controlUrn = paramString;
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
    
    public final Builder setPropUrn(String paramString)
    {
      if (paramString == null)
      {
        hasPropUrn = false;
        propUrn = null;
        return this;
      }
      hasPropUrn = true;
      propUrn = paramString;
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
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */