package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class SuggestedEditImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedEditImpressionEvent>
{
  public String flowTrackingId = null;
  public boolean hasFlowTrackingId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasRawProfileElementUrns = false;
  private boolean hasRequestHeader = false;
  public boolean hasSuggestionSource = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public List<String> rawProfileElementUrns = null;
  private UserRequestHeader requestHeader = null;
  public SuggestionSource suggestionSource = null;
  
  private SuggestedEditImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SuggestedEditImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (rawProfileElementUrns != null)
    {
      paramFlavor = rawProfileElementUrns.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "rawProfileElementUrns");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "requestHeader");
            }
            if (!hasRawProfileElementUrns) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "rawProfileElementUrns");
            }
            if (hasFlowTrackingId) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "flowTrackingId");
          }
        }
      }
    }
    return new SuggestedEditImpressionEvent(header, requestHeader, mobileHeader, rawProfileElementUrns, flowTrackingId, suggestionSource, hasHeader, hasRequestHeader, hasMobileHeader, hasRawProfileElementUrns, hasFlowTrackingId, hasSuggestionSource);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */