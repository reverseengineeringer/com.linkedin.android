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

public final class FlagshipSchoolItemImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipSchoolItemImpressionEvent>
{
  private boolean hasHeader = false;
  public boolean hasItems = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasSchool = false;
  private EventHeader header = null;
  public List<FlagshipSchoolImpressionItem> items = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public TrackingObject school = null;
  
  private FlagshipSchoolItemImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipSchoolItemImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (items != null)
    {
      paramFlavor = items.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((FlagshipSchoolImpressionItem)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolItemImpressionEvent", "items");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolItemImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolItemImpressionEvent", "requestHeader");
            }
            if (!hasSchool) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolItemImpressionEvent", "school");
            }
            if (hasItems) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolItemImpressionEvent", "items");
          }
        }
      }
    }
    return new FlagshipSchoolItemImpressionEvent(header, requestHeader, mobileHeader, school, items, hasHeader, hasRequestHeader, hasMobileHeader, hasSchool, hasItems);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolItemImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */