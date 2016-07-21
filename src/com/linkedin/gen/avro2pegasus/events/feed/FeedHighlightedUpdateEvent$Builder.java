package com.linkedin.gen.avro2pegasus.events.feed;

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
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import java.util.Iterator;
import java.util.List;

public final class FeedHighlightedUpdateEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FeedHighlightedUpdateEvent>
{
  private boolean hasHeader = false;
  public boolean hasHighlightedUpdateSource = false;
  public boolean hasHighlightedUpdates = false;
  private boolean hasMobileHeader = false;
  public boolean hasModuleKey = false;
  private boolean hasRequestHeader = false;
  public boolean hasSourceTrackingId = false;
  private EventHeader header = null;
  public highlightedUpdateSource highlightedUpdateSource = null;
  public List<TrackingObject> highlightedUpdates = null;
  private MobileHeader mobileHeader = null;
  public String moduleKey = null;
  private UserRequestHeader requestHeader = null;
  public MessageId sourceTrackingId = null;
  
  private FeedHighlightedUpdateEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FeedHighlightedUpdateEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (highlightedUpdates != null)
    {
      paramFlavor = highlightedUpdates.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((TrackingObject)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdates");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "requestHeader");
            }
            if (!hasHighlightedUpdateSource) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdateSource");
            }
            if (hasHighlightedUpdates) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdates");
          }
        }
      }
    }
    return new FeedHighlightedUpdateEvent(header, requestHeader, mobileHeader, moduleKey, sourceTrackingId, highlightedUpdateSource, highlightedUpdates, hasHeader, hasRequestHeader, hasMobileHeader, hasModuleKey, hasSourceTrackingId, hasHighlightedUpdateSource, hasHighlightedUpdates);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */