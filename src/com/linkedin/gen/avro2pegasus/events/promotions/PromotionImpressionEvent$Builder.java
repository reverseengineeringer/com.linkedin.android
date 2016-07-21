package com.linkedin.gen.avro2pegasus.events.promotions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class PromotionImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PromotionImpressionEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasPhoneNumberInfo = false;
  public boolean hasProductUrns = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public PhoneNumberInfo phoneNumberInfo = null;
  public List<String> productUrns = null;
  private UserRequestHeader requestHeader = null;
  
  private PromotionImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PromotionImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (productUrns != null)
    {
      paramFlavor = productUrns.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "productUrns");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "requestHeader");
            }
            if (hasProductUrns) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "productUrns");
          }
        }
      }
    }
    return new PromotionImpressionEvent(header, requestHeader, mobileHeader, phoneNumberInfo, productUrns, hasHeader, hasRequestHeader, hasMobileHeader, hasPhoneNumberInfo, hasProductUrns);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */