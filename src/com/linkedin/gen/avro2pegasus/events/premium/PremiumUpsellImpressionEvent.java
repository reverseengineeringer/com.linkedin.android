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

public final class PremiumUpsellImpressionEvent
  implements RecordTemplate<PremiumUpsellImpressionEvent>
{
  public static final PremiumUpsellImpressionEventBuilder BUILDER = PremiumUpsellImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String campaignUrn;
  public final String contextUrn;
  public final boolean hasCampaignUrn;
  public final boolean hasContextUrn;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasUpsellControlUrn;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final String upsellControlUrn;
  
  PremiumUpsellImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    upsellControlUrn = paramString1;
    campaignUrn = paramString2;
    contextUrn = paramString3;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasUpsellControlUrn = paramBoolean4;
    hasCampaignUrn = paramBoolean5;
    hasContextUrn = paramBoolean6;
    _cachedId = null;
  }
  
  private PremiumUpsellImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label291;
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
          break label300;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label318;
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
          break label327;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label345;
        }
      }
    }
    label291:
    label300:
    label318:
    label327:
    label345:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasUpsellControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("upsellControlUrn");
        paramDataProcessor.processString(upsellControlUrn);
      }
      if (hasCampaignUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("campaignUrn");
        paramDataProcessor.processString(campaignUrn);
      }
      if (hasContextUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("contextUrn");
        paramDataProcessor.processString(contextUrn);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label431;
      }
      try
      {
        if (hasHeader) {
          break label351;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent", "header");
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
    label351:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent", "requestHeader");
    }
    if (!hasUpsellControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent", "upsellControlUrn");
    }
    return new PremiumUpsellImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, upsellControlUrn, campaignUrn, contextUrn, bool1, bool2, bool3, hasUpsellControlUrn, hasCampaignUrn, hasContextUrn);
    label431:
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
      paramObject = (PremiumUpsellImpressionEvent)paramObject;
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
      if (upsellControlUrn != null)
      {
        if (upsellControlUrn.equals(upsellControlUrn)) {}
      }
      else {
        while (upsellControlUrn != null) {
          return false;
        }
      }
      if (campaignUrn != null)
      {
        if (campaignUrn.equals(campaignUrn)) {}
      }
      else {
        while (campaignUrn != null) {
          return false;
        }
      }
      if (contextUrn == null) {
        break;
      }
    } while (contextUrn.equals(contextUrn));
    for (;;)
    {
      return false;
      if (contextUrn == null) {
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
        break label154;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label159;
      }
      k = mobileHeader.hashCode();
      if (upsellControlUrn == null) {
        break label164;
      }
      m = upsellControlUrn.hashCode();
      label76:
      if (campaignUrn == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = campaignUrn.hashCode();; n = 0)
    {
      if (contextUrn != null) {
        i1 = contextUrn.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<PremiumUpsellImpressionEvent>
  {
    public String campaignUrn = null;
    private String contextUrn = null;
    public boolean hasCampaignUrn = false;
    private boolean hasContextUrn = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    private boolean hasUpsellControlUrn = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    private String upsellControlUrn = null;
    
    private PremiumUpsellImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PremiumUpsellImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PremiumUpsellImpressionEvent(header, requestHeader, mobileHeader, upsellControlUrn, campaignUrn, contextUrn, hasHeader, hasRequestHeader, hasMobileHeader, hasUpsellControlUrn, hasCampaignUrn, hasContextUrn);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent", "requestHeader");
        }
      } while (hasUpsellControlUrn);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent", "upsellControlUrn");
    }
    
    public final Builder setUpsellControlUrn(String paramString)
    {
      if (paramString == null)
      {
        hasUpsellControlUrn = false;
        upsellControlUrn = null;
        return this;
      }
      hasUpsellControlUrn = true;
      upsellControlUrn = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */