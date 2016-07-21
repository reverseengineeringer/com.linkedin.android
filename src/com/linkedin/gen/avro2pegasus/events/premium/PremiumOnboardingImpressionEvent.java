package com.linkedin.gen.avro2pegasus.events.premium;

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
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;

public final class PremiumOnboardingImpressionEvent
  implements RecordTemplate<PremiumOnboardingImpressionEvent>
{
  public static final PremiumOnboardingImpressionEventBuilder BUILDER = PremiumOnboardingImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final PageInstance chooserSessionStartPageInstance;
  public final boolean hasChooserSessionStartPageInstance;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasOrderUrn;
  public final boolean hasReceiptUrn;
  public final boolean hasRequestHeader;
  public final boolean hasSubsFamily;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final String orderUrn;
  public final String receiptUrn;
  public final UserRequestHeader requestHeader;
  public final ProductSubsFamily subsFamily;
  
  PremiumOnboardingImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, PageInstance paramPageInstance, ProductSubsFamily paramProductSubsFamily, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    chooserSessionStartPageInstance = paramPageInstance;
    subsFamily = paramProductSubsFamily;
    orderUrn = paramString1;
    receiptUrn = paramString2;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasChooserSessionStartPageInstance = paramBoolean4;
    hasSubsFamily = paramBoolean5;
    hasOrderUrn = paramBoolean6;
    hasReceiptUrn = paramBoolean7;
    _cachedId = null;
  }
  
  private PremiumOnboardingImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label343;
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
          break label352;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label370;
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
          break label379;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label397;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasChooserSessionStartPageInstance)
      {
        paramDataProcessor.startRecordField$505cff1c("chooserSessionStartPageInstance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label407;
        }
        localObject1 = chooserSessionStartPageInstance.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label425;
        }
      }
    }
    label343:
    label352:
    label370:
    label379:
    label397:
    label407:
    label425:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasSubsFamily)
      {
        paramDataProcessor.startRecordField$505cff1c("subsFamily");
        paramDataProcessor.processEnum(subsFamily);
      }
      if (hasOrderUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("orderUrn");
        paramDataProcessor.processString(orderUrn);
      }
      if (hasReceiptUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("receiptUrn");
        paramDataProcessor.processString(receiptUrn);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label534;
      }
      try
      {
        if (hasHeader) {
          break label431;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent", "header");
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
      localObject1 = (PageInstance)paramDataProcessor.processDataTemplate(chooserSessionStartPageInstance);
      break label198;
    }
    label431:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent", "requestHeader");
    }
    if (!hasChooserSessionStartPageInstance) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent", "chooserSessionStartPageInstance");
    }
    if (!hasSubsFamily) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent", "subsFamily");
    }
    return new PremiumOnboardingImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (PageInstance)localObject1, subsFamily, orderUrn, receiptUrn, bool1, bool2, bool3, bool4, hasSubsFamily, hasOrderUrn, hasReceiptUrn);
    label534:
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
      paramObject = (PremiumOnboardingImpressionEvent)paramObject;
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
      if (chooserSessionStartPageInstance != null)
      {
        if (chooserSessionStartPageInstance.equals(chooserSessionStartPageInstance)) {}
      }
      else {
        while (chooserSessionStartPageInstance != null) {
          return false;
        }
      }
      if (subsFamily != null)
      {
        if (subsFamily.equals(subsFamily)) {}
      }
      else {
        while (subsFamily != null) {
          return false;
        }
      }
      if (orderUrn != null)
      {
        if (orderUrn.equals(orderUrn)) {}
      }
      else {
        while (orderUrn != null) {
          return false;
        }
      }
      if (receiptUrn == null) {
        break;
      }
    } while (receiptUrn.equals(receiptUrn));
    for (;;)
    {
      return false;
      if (receiptUrn == null) {
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
      if (chooserSessionStartPageInstance == null) {
        break label186;
      }
      m = chooserSessionStartPageInstance.hashCode();
      if (subsFamily == null) {
        break label192;
      }
      n = subsFamily.hashCode();
      label92:
      if (orderUrn == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = orderUrn.hashCode();; i1 = 0)
    {
      if (receiptUrn != null) {
        i2 = receiptUrn.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<PremiumOnboardingImpressionEvent>
  {
    public PageInstance chooserSessionStartPageInstance = null;
    public boolean hasChooserSessionStartPageInstance = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasOrderUrn = false;
    private boolean hasReceiptUrn = false;
    private boolean hasRequestHeader = false;
    public boolean hasSubsFamily = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public String orderUrn = null;
    private String receiptUrn = null;
    private UserRequestHeader requestHeader = null;
    public ProductSubsFamily subsFamily = null;
    
    private PremiumOnboardingImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PremiumOnboardingImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PremiumOnboardingImpressionEvent(header, requestHeader, mobileHeader, chooserSessionStartPageInstance, subsFamily, orderUrn, receiptUrn, hasHeader, hasRequestHeader, hasMobileHeader, hasChooserSessionStartPageInstance, hasSubsFamily, hasOrderUrn, hasReceiptUrn);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent", "requestHeader");
        }
        if (!hasChooserSessionStartPageInstance) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent", "chooserSessionStartPageInstance");
        }
      } while (hasSubsFamily);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent", "subsFamily");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */