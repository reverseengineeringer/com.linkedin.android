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

public final class PromotionActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PromotionActionEvent>
{
  private String controlUrn = null;
  private boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasPhoneNumberInfo = false;
  private boolean hasProductUrns = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private PhoneNumberInfo phoneNumberInfo = null;
  private List<String> productUrns = null;
  private UserRequestHeader requestHeader = null;
  
  private PromotionActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PromotionActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent", "productUrns");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent", "requestHeader");
            }
            if (!hasControlUrn) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent", "controlUrn");
            }
            if (hasProductUrns) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent", "productUrns");
          }
        }
      }
    }
    return new PromotionActionEvent(header, requestHeader, mobileHeader, controlUrn, phoneNumberInfo, productUrns, hasHeader, hasRequestHeader, hasMobileHeader, hasControlUrn, hasPhoneNumberInfo, hasProductUrns);
  }
  
  public final Builder setControlUrn(String paramString)
  {
    if (paramString == null)
    {
      hasControlUrn = false;
      controlUrn = null;
      return this;
    }
    hasControlUrn = true;
    controlUrn = paramString;
    return this;
  }
  
  public final Builder setPhoneNumberInfo(PhoneNumberInfo paramPhoneNumberInfo)
  {
    if (paramPhoneNumberInfo == null)
    {
      hasPhoneNumberInfo = false;
      phoneNumberInfo = null;
      return this;
    }
    hasPhoneNumberInfo = true;
    phoneNumberInfo = paramPhoneNumberInfo;
    return this;
  }
  
  public final Builder setProductUrns(List<String> paramList)
  {
    if (paramList == null)
    {
      hasProductUrns = false;
      productUrns = null;
      return this;
    }
    hasProductUrns = true;
    productUrns = paramList;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */