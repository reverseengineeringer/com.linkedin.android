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

public final class PremiumCheckoutImpressionEvent
  implements RecordTemplate<PremiumCheckoutImpressionEvent>
{
  public static final PremiumCheckoutImpressionEventBuilder BUILDER = PremiumCheckoutImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final PageInstance chooserSessionStartPageInstance;
  public final boolean hasChooserSessionStartPageInstance;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasOrderUrn;
  public final boolean hasPriceUrn;
  public final boolean hasProductUrn;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final String orderUrn;
  public final String priceUrn;
  public final String productUrn;
  public final UserRequestHeader requestHeader;
  
  PremiumCheckoutImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, PageInstance paramPageInstance, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    productUrn = paramString1;
    priceUrn = paramString2;
    chooserSessionStartPageInstance = paramPageInstance;
    orderUrn = paramString3;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasProductUrn = paramBoolean4;
    hasPriceUrn = paramBoolean5;
    hasChooserSessionStartPageInstance = paramBoolean6;
    hasOrderUrn = paramBoolean7;
    _cachedId = null;
  }
  
  private PremiumCheckoutImpressionEvent accept(DataProcessor paramDataProcessor)
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
      if (hasProductUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("productUrn");
        paramDataProcessor.processString(productUrn);
      }
      if (hasPriceUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("priceUrn");
        paramDataProcessor.processString(priceUrn);
      }
      localObject1 = null;
      bool4 = false;
      if (hasChooserSessionStartPageInstance)
      {
        paramDataProcessor.startRecordField$505cff1c("chooserSessionStartPageInstance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label407;
        }
        localObject1 = chooserSessionStartPageInstance.accept(paramDataProcessor);
        label248:
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
      if (hasOrderUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("orderUrn");
        paramDataProcessor.processString(orderUrn);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label553;
      }
      try
      {
        if (hasHeader) {
          break label431;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "header");
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
      break label248;
    }
    label431:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "requestHeader");
    }
    if (!hasProductUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "productUrn");
    }
    if (!hasPriceUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "priceUrn");
    }
    if (!hasChooserSessionStartPageInstance) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "chooserSessionStartPageInstance");
    }
    return new PremiumCheckoutImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, productUrn, priceUrn, (PageInstance)localObject1, orderUrn, bool1, bool2, bool3, hasProductUrn, hasPriceUrn, bool4, hasOrderUrn);
    label553:
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
      paramObject = (PremiumCheckoutImpressionEvent)paramObject;
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
      if (productUrn != null)
      {
        if (productUrn.equals(productUrn)) {}
      }
      else {
        while (productUrn != null) {
          return false;
        }
      }
      if (priceUrn != null)
      {
        if (priceUrn.equals(priceUrn)) {}
      }
      else {
        while (priceUrn != null) {
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
      if (orderUrn == null) {
        break;
      }
    } while (orderUrn.equals(orderUrn));
    for (;;)
    {
      return false;
      if (orderUrn == null) {
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
      if (productUrn == null) {
        break label186;
      }
      m = productUrn.hashCode();
      if (priceUrn == null) {
        break label192;
      }
      n = priceUrn.hashCode();
      label92:
      if (chooserSessionStartPageInstance == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = chooserSessionStartPageInstance.hashCode();; i1 = 0)
    {
      if (orderUrn != null) {
        i2 = orderUrn.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<PremiumCheckoutImpressionEvent>
  {
    public PageInstance chooserSessionStartPageInstance = null;
    public boolean hasChooserSessionStartPageInstance = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasOrderUrn = false;
    public boolean hasPriceUrn = false;
    public boolean hasProductUrn = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public String orderUrn = null;
    public String priceUrn = null;
    public String productUrn = null;
    private UserRequestHeader requestHeader = null;
    
    private PremiumCheckoutImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PremiumCheckoutImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PremiumCheckoutImpressionEvent(header, requestHeader, mobileHeader, productUrn, priceUrn, chooserSessionStartPageInstance, orderUrn, hasHeader, hasRequestHeader, hasMobileHeader, hasProductUrn, hasPriceUrn, hasChooserSessionStartPageInstance, hasOrderUrn);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "requestHeader");
        }
        if (!hasProductUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "productUrn");
        }
        if (!hasPriceUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "priceUrn");
        }
      } while (hasChooserSessionStartPageInstance);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent", "chooserSessionStartPageInstance");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */