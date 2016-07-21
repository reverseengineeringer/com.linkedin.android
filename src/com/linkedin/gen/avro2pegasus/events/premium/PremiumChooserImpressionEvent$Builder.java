package com.linkedin.gen.avro2pegasus.events.premium;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;
import java.util.Iterator;
import java.util.List;

public final class PremiumChooserImpressionEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */