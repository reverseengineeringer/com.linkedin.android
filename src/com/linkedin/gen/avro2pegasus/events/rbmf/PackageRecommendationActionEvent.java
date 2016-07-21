package com.linkedin.gen.avro2pegasus.events.rbmf;

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

public final class PackageRecommendationActionEvent
  implements RecordTemplate<PackageRecommendationActionEvent>
{
  public static final PackageRecommendationActionEventBuilder BUILDER = PackageRecommendationActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final PackageRecommendationUserAction actionName;
  public final String controlUrn;
  public final boolean hasActionName;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasPackageFlowPosition;
  public final boolean hasPackageId;
  public final boolean hasRecommendedEntity;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final int packageFlowPosition;
  public final int packageId;
  public final RecommendedEntity recommendedEntity;
  public final UserRequestHeader requestHeader;
  
  PackageRecommendationActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, int paramInt1, int paramInt2, String paramString, RecommendedEntity paramRecommendedEntity, PackageRecommendationUserAction paramPackageRecommendationUserAction, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    packageId = paramInt1;
    packageFlowPosition = paramInt2;
    controlUrn = paramString;
    recommendedEntity = paramRecommendedEntity;
    actionName = paramPackageRecommendationUserAction;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasPackageId = paramBoolean4;
    hasPackageFlowPosition = paramBoolean5;
    hasControlUrn = paramBoolean6;
    hasRecommendedEntity = paramBoolean7;
    hasActionName = paramBoolean8;
    _cachedId = null;
  }
  
  private PackageRecommendationActionEvent accept(DataProcessor paramDataProcessor)
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
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label368;
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
          break label377;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label395;
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
          break label404;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label422;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      if (hasPackageId)
      {
        paramDataProcessor.startRecordField$505cff1c("packageId");
        paramDataProcessor.processInt(packageId);
      }
      if (hasPackageFlowPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("packageFlowPosition");
        paramDataProcessor.processInt(packageFlowPosition);
      }
      if (hasControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("controlUrn");
        paramDataProcessor.processString(controlUrn);
      }
      localObject1 = null;
      bool4 = false;
      if (hasRecommendedEntity)
      {
        paramDataProcessor.startRecordField$505cff1c("recommendedEntity");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label432;
        }
        localObject1 = recommendedEntity.accept(paramDataProcessor);
        label273:
        if (localObject1 == null) {
          break label450;
        }
      }
    }
    label368:
    label377:
    label395:
    label404:
    label422:
    label432:
    label450:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasActionName)
      {
        paramDataProcessor.startRecordField$505cff1c("actionName");
        paramDataProcessor.processEnum(actionName);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label605;
      }
      try
      {
        if (hasHeader) {
          break label456;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "header");
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
      localObject1 = (RecommendedEntity)paramDataProcessor.processDataTemplate(recommendedEntity);
      break label273;
    }
    label456:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "requestHeader");
    }
    if (!hasPackageFlowPosition) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "packageFlowPosition");
    }
    if (!hasControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "controlUrn");
    }
    if (!hasRecommendedEntity) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "recommendedEntity");
    }
    if (!hasActionName) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "actionName");
    }
    return new PackageRecommendationActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, packageId, packageFlowPosition, controlUrn, (RecommendedEntity)localObject1, actionName, bool1, bool2, bool3, hasPackageId, hasPackageFlowPosition, hasControlUrn, bool4, hasActionName);
    label605:
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
      paramObject = (PackageRecommendationActionEvent)paramObject;
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
      if (packageId != packageId) {
        return false;
      }
      if (packageFlowPosition != packageFlowPosition) {
        return false;
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
      if (recommendedEntity != null)
      {
        if (recommendedEntity.equals(recommendedEntity)) {}
      }
      else {
        while (recommendedEntity != null) {
          return false;
        }
      }
      if (actionName == null) {
        break;
      }
    } while (actionName.equals(actionName));
    for (;;)
    {
      return false;
      if (actionName == null) {
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
    int i2;
    int i3;
    int m;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label178;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label183;
      }
      k = mobileHeader.hashCode();
      i2 = packageId;
      i3 = packageFlowPosition;
      if (controlUrn == null) {
        break label188;
      }
      m = controlUrn.hashCode();
      label88:
      if (recommendedEntity == null) {
        break label194;
      }
    }
    label178:
    label183:
    label188:
    label194:
    for (int n = recommendedEntity.hashCode();; n = 0)
    {
      if (actionName != null) {
        i1 = actionName.hashCode();
      }
      i = (n + (m + (((k + (j + (i + 527) * 31) * 31) * 31 + i2) * 31 + i3) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label88;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<PackageRecommendationActionEvent>
  {
    public PackageRecommendationUserAction actionName = null;
    public String controlUrn = null;
    public boolean hasActionName = false;
    public boolean hasControlUrn = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasPackageFlowPosition = false;
    public boolean hasPackageId = false;
    public boolean hasRecommendedEntity = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public int packageFlowPosition = 0;
    public int packageId = 0;
    public RecommendedEntity recommendedEntity = null;
    private UserRequestHeader requestHeader = null;
    
    private PackageRecommendationActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PackageRecommendationActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PackageRecommendationActionEvent(header, requestHeader, mobileHeader, packageId, packageFlowPosition, controlUrn, recommendedEntity, actionName, hasHeader, hasRequestHeader, hasMobileHeader, hasPackageId, hasPackageFlowPosition, hasControlUrn, hasRecommendedEntity, hasActionName);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "requestHeader");
        }
        if (!hasPackageFlowPosition) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "packageFlowPosition");
        }
        if (!hasControlUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "controlUrn");
        }
        if (!hasRecommendedEntity) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "recommendedEntity");
        }
      } while (hasActionName);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "actionName");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */