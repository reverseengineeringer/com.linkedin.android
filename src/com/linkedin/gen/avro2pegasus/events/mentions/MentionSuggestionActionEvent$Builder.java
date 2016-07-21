package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.search.SearchHeader;

public final class MentionSuggestionActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MentionSuggestionActionEvent>
{
  public MentionActionType actionType = null;
  public boolean hasActionType = false;
  private boolean hasHeader = false;
  public boolean hasMentionWorkflowId = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasResult = false;
  public boolean hasSearchHeader = false;
  private EventHeader header = null;
  public String mentionWorkflowId = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public MentionResultHit result = null;
  public SearchHeader searchHeader = null;
  
  private MentionSuggestionActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MentionSuggestionActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MentionSuggestionActionEvent(header, requestHeader, mobileHeader, searchHeader, mentionWorkflowId, actionType, result, hasHeader, hasRequestHeader, hasMobileHeader, hasSearchHeader, hasMentionWorkflowId, hasActionType, hasResult);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "requestHeader");
      }
      if (!hasSearchHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "searchHeader");
      }
      if (!hasMentionWorkflowId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "mentionWorkflowId");
      }
    } while (hasActionType);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent", "actionType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */