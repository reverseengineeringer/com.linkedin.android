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

public final class PremiumCheckoutImpressionEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumCheckoutImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */