package com.linkedin.gen.avro2pegasus.events.premium;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;

public final class PremiumOnboardingImpressionEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */