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

public final class FlagshipJobItemImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipJobItemImpressionEvent>
{
  private boolean hasHeader = false;
  public boolean hasItems = false;
  public boolean hasJob = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public List<FlagshipJobImpressionItem> items = null;
  public TrackingObject job = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private FlagshipJobItemImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipJobItemImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (items != null)
    {
      paramFlavor = items.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((FlagshipJobImpressionItem)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "items");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "requestHeader");
            }
            if (!hasJob) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "job");
            }
            if (hasItems) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "items");
          }
        }
      }
    }
    return new FlagshipJobItemImpressionEvent(header, requestHeader, mobileHeader, job, items, hasHeader, hasRequestHeader, hasMobileHeader, hasJob, hasItems);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */