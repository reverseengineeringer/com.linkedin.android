package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.search.SearchHeader;
import java.util.Iterator;
import java.util.List;

public final class MentionSuggestionImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MentionSuggestionImpressionEvent>
{
  private boolean hasHeader = false;
  public boolean hasMentionWorkflowId = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasResults = false;
  public boolean hasSearchHeader = false;
  private EventHeader header = null;
  public String mentionWorkflowId = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public List<MentionResultHit> results = null;
  public SearchHeader searchHeader = null;
  
  private MentionSuggestionImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MentionSuggestionImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (results != null)
    {
      paramFlavor = results.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((MentionResultHit)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "results");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "requestHeader");
            }
            if (!hasSearchHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "searchHeader");
            }
            if (!hasMentionWorkflowId) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "mentionWorkflowId");
            }
            if (hasResults) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent", "results");
          }
        }
      }
    }
    return new MentionSuggestionImpressionEvent(header, requestHeader, mobileHeader, searchHeader, mentionWorkflowId, results, hasHeader, hasRequestHeader, hasMobileHeader, hasSearchHeader, hasMentionWorkflowId, hasResults);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */