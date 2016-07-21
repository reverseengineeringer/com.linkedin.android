package com.linkedin.gen.avro2pegasus.events.companies;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class FlagshipCareersViewEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipCareersViewEvent>
{
  public TrackingObject company = null;
  public boolean hasCompany = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private FlagshipCareersViewEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipCareersViewEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FlagshipCareersViewEvent(header, requestHeader, mobileHeader, company, hasHeader, hasRequestHeader, hasMobileHeader, hasCompany);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.companies.FlagshipCareersViewEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.companies.FlagshipCareersViewEvent", "requestHeader");
      }
      if (!hasMobileHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.companies.FlagshipCareersViewEvent", "mobileHeader");
      }
    } while (hasCompany);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.companies.FlagshipCareersViewEvent", "company");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.companies.FlagshipCareersViewEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */