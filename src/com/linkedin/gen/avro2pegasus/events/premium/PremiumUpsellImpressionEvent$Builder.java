package com.linkedin.gen.avro2pegasus.events.premium;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class PremiumUpsellImpressionEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */