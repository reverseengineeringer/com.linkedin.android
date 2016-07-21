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

public final class FlagshipGroupItemImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipGroupItemImpressionEvent>
{
  private TrackingObject group = null;
  private boolean hasGroup = false;
  private boolean hasHeader = false;
  private boolean hasItems = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private List<FlagshipGroupImpressionItem> items = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private FlagshipGroupItemImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipGroupItemImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (items != null)
    {
      paramFlavor = items.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((FlagshipGroupImpressionItem)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupItemImpressionEvent", "items");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupItemImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupItemImpressionEvent", "requestHeader");
            }
            if (!hasGroup) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupItemImpressionEvent", "group");
            }
            if (hasItems) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupItemImpressionEvent", "items");
          }
        }
      }
    }
    return new FlagshipGroupItemImpressionEvent(header, requestHeader, mobileHeader, group, items, hasHeader, hasRequestHeader, hasMobileHeader, hasGroup, hasItems);
  }
  
  public final Builder setGroup(TrackingObject paramTrackingObject)
  {
    if (paramTrackingObject == null)
    {
      hasGroup = false;
      group = null;
      return this;
    }
    hasGroup = true;
    group = paramTrackingObject;
    return this;
  }
  
  public final Builder setItems(List<FlagshipGroupImpressionItem> paramList)
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
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupItemImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */