package com.linkedin.gen.avro2pegasus.events.promotions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class UpgradeConfirmationViewEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<UpgradeConfirmationViewEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasPhoneNumberInfo = false;
  public boolean hasProductUrn = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public PhoneNumberInfo phoneNumberInfo = null;
  public String productUrn = null;
  private UserRequestHeader requestHeader = null;
  
  private UpgradeConfirmationViewEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (UpgradeConfirmationViewEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new UpgradeConfirmationViewEvent(header, requestHeader, mobileHeader, phoneNumberInfo, productUrn, hasHeader, hasRequestHeader, hasMobileHeader, hasPhoneNumberInfo, hasProductUrn);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "requestHeader");
      }
    } while (hasProductUrn);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "productUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */