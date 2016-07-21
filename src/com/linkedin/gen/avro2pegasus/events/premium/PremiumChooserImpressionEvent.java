package com.linkedin.gen.avro2pegasus.events.premium;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PremiumChooserImpressionEvent
  implements RecordTemplate<PremiumChooserImpressionEvent>
{
  public static final PremiumChooserImpressionEventBuilder BUILDER = PremiumChooserImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String campaignUrn;
  public final PremiumUpsellChannel channel;
  public final PageInstance chooserSessionStartPageInstance;
  public final String contextUrn;
  public final boolean hasCampaignUrn;
  public final boolean hasChannel;
  public final boolean hasChooserSessionStartPageInstance;
  public final boolean hasContextUrn;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasPriceUrns;
  public final boolean hasProductCount;
  public final boolean hasProductPosition;
  public final boolean hasProductUrn;
  public final boolean hasRequestHeader;
  public final boolean hasSubsFamily;
  public final boolean hasUpsellControlUrn;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final List<String> priceUrns;
  public final int productCount;
  public final ListPosition productPosition;
  public final String productUrn;
  public final UserRequestHeader requestHeader;
  public final ProductSubsFamily subsFamily;
  public final String upsellControlUrn;
  
  PremiumChooserImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, List<String> paramList, PremiumUpsellChannel paramPremiumUpsellChannel, ProductSubsFamily paramProductSubsFamily, ListPosition paramListPosition, int paramInt, PageInstance paramPageInstance, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    productUrn = paramString1;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      priceUrns = paramEventHeader;
      channel = paramPremiumUpsellChannel;
      subsFamily = paramProductSubsFamily;
      productPosition = paramListPosition;
      productCount = paramInt;
      chooserSessionStartPageInstance = paramPageInstance;
      upsellControlUrn = paramString2;
      campaignUrn = paramString3;
      contextUrn = paramString4;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasProductUrn = paramBoolean4;
      hasPriceUrns = paramBoolean5;
      hasChannel = paramBoolean6;
      hasSubsFamily = paramBoolean7;
      hasProductPosition = paramBoolean8;
      hasProductCount = paramBoolean9;
      hasChooserSessionStartPageInstance = paramBoolean10;
      hasUpsellControlUrn = paramBoolean11;
      hasCampaignUrn = paramBoolean12;
      hasContextUrn = paramBoolean13;
      _cachedId = null;
      return;
    }
  }
  
  private PremiumChooserImpressionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    boolean bool3;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label333;
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
          break label342;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label360;
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
          break label370;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label148:
        if (localObject1 == null) {
          break label388;
        }
        bool3 = true;
      }
    }
    Object localObject5;
    boolean bool4;
    Object localObject6;
    for (Object localObject4 = localObject1;; localObject4 = localObject1)
    {
      if (hasProductUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("productUrn");
        paramDataProcessor.processString(productUrn);
      }
      localObject5 = null;
      localObject1 = null;
      bool4 = false;
      if (!hasPriceUrns) {
        break label416;
      }
      paramDataProcessor.startRecordField$505cff1c("priceUrns");
      priceUrns.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject5 = priceUrns.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject6);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject6);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label333:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label342:
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      label360:
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      label370:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      label388:
      bool3 = false;
    }
    paramDataProcessor.endArray();
    label416:
    boolean bool5;
    if (localObject1 != null)
    {
      bool4 = true;
      localObject5 = localObject1;
      if (hasChannel)
      {
        paramDataProcessor.startRecordField$505cff1c("channel");
        paramDataProcessor.processEnum(channel);
      }
      if (hasSubsFamily)
      {
        paramDataProcessor.startRecordField$505cff1c("subsFamily");
        paramDataProcessor.processEnum(subsFamily);
      }
      localObject6 = null;
      bool5 = false;
      if (hasProductPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("productPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label720;
        }
        localObject1 = productPosition.accept(paramDataProcessor);
        label506:
        if (localObject1 == null) {
          break label738;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      label518:
      if (hasProductCount)
      {
        paramDataProcessor.startRecordField$505cff1c("productCount");
        paramDataProcessor.processInt(productCount);
      }
      localObject1 = null;
      bool6 = false;
      if (hasChooserSessionStartPageInstance)
      {
        paramDataProcessor.startRecordField$505cff1c("chooserSessionStartPageInstance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label748;
        }
        localObject1 = chooserSessionStartPageInstance.accept(paramDataProcessor);
        label583:
        if (localObject1 == null) {
          break label766;
        }
      }
    }
    label720:
    label738:
    label748:
    label766:
    for (boolean bool6 = true;; bool6 = false)
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
        break label1080;
      }
      try
      {
        if (hasHeader) {
          break label772;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool4 = false;
      localObject5 = localObject1;
      break;
      localObject1 = (ListPosition)paramDataProcessor.processDataTemplate(productPosition);
      break label506;
      bool5 = false;
      localObject6 = localObject1;
      break label518;
      localObject1 = (PageInstance)paramDataProcessor.processDataTemplate(chooserSessionStartPageInstance);
      break label583;
    }
    label772:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "requestHeader");
    }
    if (!hasProductUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "productUrn");
    }
    if (!hasPriceUrns) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "priceUrns");
    }
    if (!hasChannel) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "channel");
    }
    if (!hasSubsFamily) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "subsFamily");
    }
    if (!hasProductPosition) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "productPosition");
    }
    if (!hasProductCount) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "productCount");
    }
    if (!hasChooserSessionStartPageInstance) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "chooserSessionStartPageInstance");
    }
    if (!hasUpsellControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "upsellControlUrn");
    }
    if (priceUrns != null)
    {
      paramDataProcessor = priceUrns.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "priceUrns");
        }
      }
    }
    return new PremiumChooserImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, productUrn, (List)localObject5, channel, subsFamily, (ListPosition)localObject6, productCount, (PageInstance)localObject1, upsellControlUrn, campaignUrn, contextUrn, bool1, bool2, bool3, hasProductUrn, bool4, hasChannel, hasSubsFamily, bool5, hasProductCount, bool6, hasUpsellControlUrn, hasCampaignUrn, hasContextUrn);
    label1080:
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
      paramObject = (PremiumChooserImpressionEvent)paramObject;
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
      if (priceUrns != null)
      {
        if (priceUrns.equals(priceUrns)) {}
      }
      else {
        while (priceUrns != null) {
          return false;
        }
      }
      if (channel != null)
      {
        if (channel.equals(channel)) {}
      }
      else {
        while (channel != null) {
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
      if (productPosition != null)
      {
        if (productPosition.equals(productPosition)) {}
      }
      else {
        while (productPosition != null) {
          return false;
        }
      }
      if (productCount != productCount) {
        return false;
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
    int i7 = 0;
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
    label94:
    int i1;
    label110:
    int i2;
    label126:
    int i3;
    label142:
    int i8;
    int i4;
    label164:
    int i5;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label300;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label305;
      }
      k = mobileHeader.hashCode();
      if (productUrn == null) {
        break label310;
      }
      m = productUrn.hashCode();
      if (priceUrns == null) {
        break label316;
      }
      n = priceUrns.hashCode();
      if (channel == null) {
        break label322;
      }
      i1 = channel.hashCode();
      if (subsFamily == null) {
        break label328;
      }
      i2 = subsFamily.hashCode();
      if (productPosition == null) {
        break label334;
      }
      i3 = productPosition.hashCode();
      i8 = productCount;
      if (chooserSessionStartPageInstance == null) {
        break label340;
      }
      i4 = chooserSessionStartPageInstance.hashCode();
      if (upsellControlUrn == null) {
        break label346;
      }
      i5 = upsellControlUrn.hashCode();
      label180:
      if (campaignUrn == null) {
        break label352;
      }
    }
    label300:
    label305:
    label310:
    label316:
    label322:
    label328:
    label334:
    label340:
    label346:
    label352:
    for (int i6 = campaignUrn.hashCode();; i6 = 0)
    {
      if (contextUrn != null) {
        i7 = contextUrn.hashCode();
      }
      i = (i6 + (i5 + (i4 + ((i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i8) * 31) * 31) * 31) * 31 + i7;
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
      break label94;
      i1 = 0;
      break label110;
      i2 = 0;
      break label126;
      i3 = 0;
      break label142;
      i4 = 0;
      break label164;
      i5 = 0;
      break label180;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<PremiumChooserImpressionEvent>
  {
    public String campaignUrn = null;
    public PremiumUpsellChannel channel = null;
    public PageInstance chooserSessionStartPageInstance = null;
    private String contextUrn = null;
    public boolean hasCampaignUrn = false;
    public boolean hasChannel = false;
    public boolean hasChooserSessionStartPageInstance = false;
    private boolean hasContextUrn = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasPriceUrns = false;
    public boolean hasProductCount = false;
    public boolean hasProductPosition = false;
    public boolean hasProductUrn = false;
    private boolean hasRequestHeader = false;
    public boolean hasSubsFamily = false;
    public boolean hasUpsellControlUrn = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public List<String> priceUrns = null;
    public int productCount = 0;
    public ListPosition productPosition = null;
    public String productUrn = null;
    private UserRequestHeader requestHeader = null;
    public ProductSubsFamily subsFamily = null;
    public String upsellControlUrn = null;
    
    private PremiumChooserImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PremiumChooserImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (priceUrns != null)
      {
        paramFlavor = priceUrns.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "priceUrns");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "requestHeader");
              }
              if (!hasProductUrn) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "productUrn");
              }
              if (!hasPriceUrns) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "priceUrns");
              }
              if (!hasChannel) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "channel");
              }
              if (!hasSubsFamily) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "subsFamily");
              }
              if (!hasProductPosition) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "productPosition");
              }
              if (!hasProductCount) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "productCount");
              }
              if (!hasChooserSessionStartPageInstance) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "chooserSessionStartPageInstance");
              }
              if (hasUpsellControlUrn) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent", "upsellControlUrn");
            }
          }
        }
      }
      return new PremiumChooserImpressionEvent(header, requestHeader, mobileHeader, productUrn, priceUrns, channel, subsFamily, productPosition, productCount, chooserSessionStartPageInstance, upsellControlUrn, campaignUrn, contextUrn, hasHeader, hasRequestHeader, hasMobileHeader, hasProductUrn, hasPriceUrns, hasChannel, hasSubsFamily, hasProductPosition, hasProductCount, hasChooserSessionStartPageInstance, hasUpsellControlUrn, hasCampaignUrn, hasContextUrn);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */