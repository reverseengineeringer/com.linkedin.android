package com.linkedin.gen.avro2pegasus.events.entities;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.Iterator;
import java.util.List;

public final class FlagshipCompanyItemImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipCompanyItemImpressionEvent>
{
  private TrackingObject company = null;
  private boolean hasCompany = false;
  private boolean hasHeader = false;
  private boolean hasItems = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private List<FlagshipCompanyImpressionItem> items = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private FlagshipCompanyItemImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipCompanyItemImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (items != null)
    {
      paramFlavor = items.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((FlagshipCompanyImpressionItem)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyItemImpressionEvent", "items");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyItemImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyItemImpressionEvent", "requestHeader");
            }
            if (!hasCompany) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyItemImpressionEvent", "company");
            }
            if (hasItems) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyItemImpressionEvent", "items");
          }
        }
      }
    }
    return new FlagshipCompanyItemImpressionEvent(header, requestHeader, mobileHeader, company, items, hasHeader, hasRequestHeader, hasMobileHeader, hasCompany, hasItems);
  }
  
  public final Builder setCompany(TrackingObject paramTrackingObject)
  {
    if (paramTrackingObject == null)
    {
      hasCompany = false;
      company = null;
      return this;
    }
    hasCompany = true;
    company = paramTrackingObject;
    return this;
  }
  
  public final Builder setItems(List<FlagshipCompanyImpressionItem> paramList)
  {
    if (paramList == null)
    {
      hasItems = false;
      items = null;
      return this;
    }
    hasItems = true;
    items = paramList;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyItemImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */