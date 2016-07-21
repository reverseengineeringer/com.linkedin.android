package com.linkedin.gen.avro2pegasus.events.mobilesdk;

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
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class ThirdPartyMobileSdkProfileViewEvent
  implements RecordTemplate<ThirdPartyMobileSdkProfileViewEvent>
{
  public static final ThirdPartyMobileSdkProfileViewEventBuilder BUILDER = ThirdPartyMobileSdkProfileViewEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasThirdPartyApplicationIdentifier;
  public final boolean hasViewee;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final String thirdPartyApplicationIdentifier;
  public final TrackingObject viewee;
  
  ThirdPartyMobileSdkProfileViewEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, TrackingObject paramTrackingObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    thirdPartyApplicationIdentifier = paramString;
    viewee = paramTrackingObject;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasThirdPartyApplicationIdentifier = paramBoolean4;
    hasViewee = paramBoolean5;
    _cachedId = null;
  }
  
  private ThirdPartyMobileSdkProfileViewEvent accept(DataProcessor paramDataProcessor)
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
          break label293;
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
          break label302;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label320;
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
          break label329;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label347;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      if (hasThirdPartyApplicationIdentifier)
      {
        paramDataProcessor.startRecordField$505cff1c("thirdPartyApplicationIdentifier");
        paramDataProcessor.processString(thirdPartyApplicationIdentifier);
      }
      localObject1 = null;
      bool4 = false;
      if (hasViewee)
      {
        paramDataProcessor.startRecordField$505cff1c("viewee");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label357;
        }
        localObject1 = viewee.accept(paramDataProcessor);
        label223:
        if (localObject1 == null) {
          break label375;
        }
      }
    }
    label293:
    label302:
    label320:
    label329:
    label347:
    label357:
    label375:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label487;
      }
      try
      {
        if (hasHeader) {
          break label381;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "header");
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
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(viewee);
      break label223;
    }
    label381:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "requestHeader");
    }
    if (!hasMobileHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "mobileHeader");
    }
    if (!hasThirdPartyApplicationIdentifier) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "thirdPartyApplicationIdentifier");
    }
    if (!hasViewee) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "viewee");
    }
    return new ThirdPartyMobileSdkProfileViewEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, thirdPartyApplicationIdentifier, (TrackingObject)localObject1, bool1, bool2, bool3, hasThirdPartyApplicationIdentifier, bool4);
    label487:
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
      paramObject = (ThirdPartyMobileSdkProfileViewEvent)paramObject;
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
      if (thirdPartyApplicationIdentifier != null)
      {
        if (thirdPartyApplicationIdentifier.equals(thirdPartyApplicationIdentifier)) {}
      }
      else {
        while (thirdPartyApplicationIdentifier != null) {
          return false;
        }
      }
      if (viewee == null) {
        break;
      }
    } while (viewee.equals(viewee));
    for (;;)
    {
      return false;
      if (viewee == null) {
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
      if (thirdPartyApplicationIdentifier == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = thirdPartyApplicationIdentifier.hashCode();; m = 0)
    {
      if (viewee != null) {
        n = viewee.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<ThirdPartyMobileSdkProfileViewEvent>
  {
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasThirdPartyApplicationIdentifier = false;
    public boolean hasViewee = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public String thirdPartyApplicationIdentifier = null;
    public TrackingObject viewee = null;
    
    private ThirdPartyMobileSdkProfileViewEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ThirdPartyMobileSdkProfileViewEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ThirdPartyMobileSdkProfileViewEvent(header, requestHeader, mobileHeader, thirdPartyApplicationIdentifier, viewee, hasHeader, hasRequestHeader, hasMobileHeader, hasThirdPartyApplicationIdentifier, hasViewee);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "requestHeader");
        }
        if (!hasMobileHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "mobileHeader");
        }
        if (!hasThirdPartyApplicationIdentifier) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "thirdPartyApplicationIdentifier");
        }
      } while (hasViewee);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "viewee");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */