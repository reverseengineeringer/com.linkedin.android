package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.search.SearchHeader;

public final class MentionSuggestionStartEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MentionSuggestionStartEvent>
{
  public String associatedEntityUrn = null;
  public String associatedInputControlUrn = null;
  public boolean hasAssociatedEntityUrn = false;
  public boolean hasAssociatedInputControlUrn = false;
  private boolean hasHeader = false;
  public boolean hasMentionStartOperator = false;
  public boolean hasMentionType = false;
  public boolean hasMentionWorkflowId = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasRootObject = false;
  public boolean hasSearchHeader = false;
  private EventHeader header = null;
  public String mentionStartOperator = null;
  public MentionType mentionType = null;
  public String mentionWorkflowId = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public TrackingObject rootObject = null;
  public SearchHeader searchHeader = null;
  
  private MentionSuggestionStartEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MentionSuggestionStartEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MentionSuggestionStartEvent(header, requestHeader, mobileHeader, searchHeader, mentionWorkflowId, associatedInputControlUrn, associatedEntityUrn, rootObject, mentionType, mentionStartOperator, hasHeader, hasRequestHeader, hasMobileHeader, hasSearchHeader, hasMentionWorkflowId, hasAssociatedInputControlUrn, hasAssociatedEntityUrn, hasRootObject, hasMentionType, hasMentionStartOperator);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "requestHeader");
      }
      if (!hasSearchHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "searchHeader");
      }
      if (!hasMentionWorkflowId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "mentionWorkflowId");
      }
      if (!hasAssociatedInputControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "associatedInputControlUrn");
      }
    } while (hasMentionType);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent", "mentionType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionStartEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */