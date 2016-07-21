package com.linkedin.gen.avro2pegasus.events.guidededit;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditCategoryName;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditContextType;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;

public final class GuidedEditEntryImpressionEvent
  implements RecordTemplate<GuidedEditEntryImpressionEvent>
{
  public static final GuidedEditEntryImpressionEventBuilder BUILDER = GuidedEditEntryImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final GuidedEditContextType contextType;
  public final String flowTrackingId;
  public final GridPosition gridPosition;
  public final GuidedEditCategoryName guidedEditCategoryName;
  public final boolean hasContextType;
  public final boolean hasFlowTrackingId;
  public final boolean hasGridPosition;
  public final boolean hasGuidedEditCategoryName;
  public final boolean hasHeader;
  public final boolean hasListPosition;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final ListPosition listPosition;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  GuidedEditEntryImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, GuidedEditContextType paramGuidedEditContextType, GuidedEditCategoryName paramGuidedEditCategoryName, GridPosition paramGridPosition, ListPosition paramListPosition, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    contextType = paramGuidedEditContextType;
    guidedEditCategoryName = paramGuidedEditCategoryName;
    gridPosition = paramGridPosition;
    listPosition = paramListPosition;
    flowTrackingId = paramString;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasContextType = paramBoolean4;
    hasGuidedEditCategoryName = paramBoolean5;
    hasGridPosition = paramBoolean6;
    hasListPosition = paramBoolean7;
    hasFlowTrackingId = paramBoolean8;
    _cachedId = null;
  }
  
  private GuidedEditEntryImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label403;
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
          break label412;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label430;
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
          break label439;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label457;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasContextType)
      {
        paramDataProcessor.startRecordField$505cff1c("contextType");
        paramDataProcessor.processEnum(contextType);
      }
      if (hasGuidedEditCategoryName)
      {
        paramDataProcessor.startRecordField$505cff1c("guidedEditCategoryName");
        paramDataProcessor.processEnum(guidedEditCategoryName);
      }
      localObject5 = null;
      bool4 = false;
      if (hasGridPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("gridPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label467;
        }
        localObject1 = gridPosition.accept(paramDataProcessor);
        label248:
        if (localObject1 == null) {
          break label485;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label260:
      localObject1 = null;
      bool5 = false;
      if (hasListPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("listPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label495;
        }
        localObject1 = listPosition.accept(paramDataProcessor);
        label300:
        if (localObject1 == null) {
          break label513;
        }
      }
    }
    label403:
    label412:
    label430:
    label439:
    label457:
    label467:
    label485:
    label495:
    label513:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (hasFlowTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("flowTrackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(flowTrackingId));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label645;
      }
      try
      {
        if (hasHeader) {
          break label519;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "header");
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
      localObject1 = (GridPosition)paramDataProcessor.processDataTemplate(gridPosition);
      break label248;
      bool4 = false;
      localObject5 = localObject1;
      break label260;
      localObject1 = (ListPosition)paramDataProcessor.processDataTemplate(listPosition);
      break label300;
    }
    label519:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "requestHeader");
    }
    if (!hasContextType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "contextType");
    }
    if (!hasGuidedEditCategoryName) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "guidedEditCategoryName");
    }
    if (!hasFlowTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "flowTrackingId");
    }
    return new GuidedEditEntryImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, contextType, guidedEditCategoryName, (GridPosition)localObject5, (ListPosition)localObject1, flowTrackingId, bool1, bool2, bool3, hasContextType, hasGuidedEditCategoryName, bool4, bool5, hasFlowTrackingId);
    label645:
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
      paramObject = (GuidedEditEntryImpressionEvent)paramObject;
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
      if (contextType != null)
      {
        if (contextType.equals(contextType)) {}
      }
      else {
        while (contextType != null) {
          return false;
        }
      }
      if (guidedEditCategoryName != null)
      {
        if (guidedEditCategoryName.equals(guidedEditCategoryName)) {}
      }
      else {
        while (guidedEditCategoryName != null) {
          return false;
        }
      }
      if (gridPosition != null)
      {
        if (gridPosition.equals(gridPosition)) {}
      }
      else {
        while (gridPosition != null) {
          return false;
        }
      }
      if (listPosition != null)
      {
        if (listPosition.equals(listPosition)) {}
      }
      else {
        while (listPosition != null) {
          return false;
        }
      }
      if (flowTrackingId == null) {
        break;
      }
    } while (flowTrackingId.equals(flowTrackingId));
    for (;;)
    {
      return false;
      if (flowTrackingId == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
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
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label198;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label203;
      }
      k = mobileHeader.hashCode();
      if (contextType == null) {
        break label208;
      }
      m = contextType.hashCode();
      if (guidedEditCategoryName == null) {
        break label214;
      }
      n = guidedEditCategoryName.hashCode();
      if (gridPosition == null) {
        break label220;
      }
      i1 = gridPosition.hashCode();
      label108:
      if (listPosition == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = listPosition.hashCode();; i2 = 0)
    {
      if (flowTrackingId != null) {
        i3 = flowTrackingId.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
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
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<GuidedEditEntryImpressionEvent>
  {
    private GuidedEditContextType contextType = null;
    private String flowTrackingId = null;
    private GridPosition gridPosition = null;
    private GuidedEditCategoryName guidedEditCategoryName = null;
    private boolean hasContextType = false;
    private boolean hasFlowTrackingId = false;
    private boolean hasGridPosition = false;
    private boolean hasGuidedEditCategoryName = false;
    private boolean hasHeader = false;
    public boolean hasListPosition = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    public ListPosition listPosition = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    
    private GuidedEditEntryImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (GuidedEditEntryImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new GuidedEditEntryImpressionEvent(header, requestHeader, mobileHeader, contextType, guidedEditCategoryName, gridPosition, listPosition, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasContextType, hasGuidedEditCategoryName, hasGridPosition, hasListPosition, hasFlowTrackingId);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "requestHeader");
        }
        if (!hasContextType) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "contextType");
        }
        if (!hasGuidedEditCategoryName) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "guidedEditCategoryName");
        }
      } while (hasFlowTrackingId);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "flowTrackingId");
    }
    
    public final Builder setContextType(GuidedEditContextType paramGuidedEditContextType)
    {
      if (paramGuidedEditContextType == null)
      {
        hasContextType = false;
        contextType = null;
        return this;
      }
      hasContextType = true;
      contextType = paramGuidedEditContextType;
      return this;
    }
    
    public final Builder setFlowTrackingId(String paramString)
    {
      if (paramString == null)
      {
        hasFlowTrackingId = false;
        flowTrackingId = null;
        return this;
      }
      hasFlowTrackingId = true;
      flowTrackingId = paramString;
      return this;
    }
    
    public final Builder setGuidedEditCategoryName(GuidedEditCategoryName paramGuidedEditCategoryName)
    {
      if (paramGuidedEditCategoryName == null)
      {
        hasGuidedEditCategoryName = false;
        guidedEditCategoryName = null;
        return this;
      }
      hasGuidedEditCategoryName = true;
      guidedEditCategoryName = paramGuidedEditCategoryName;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */