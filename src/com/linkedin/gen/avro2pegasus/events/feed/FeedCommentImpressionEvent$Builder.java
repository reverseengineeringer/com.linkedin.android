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
import java.util.Iterator;
import java.util.List;

public final class FeedCommentImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FeedCommentImpressionEvent>
{
  public List<Comment> comments = null;
  public boolean hasComments = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private FeedCommentImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FeedCommentImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (comments != null)
    {
      paramFlavor = comments.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Comment)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentImpressionEvent", "comments");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentImpressionEvent", "requestHeader");
            }
            if (hasComments) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentImpressionEvent", "comments");
          }
        }
      }
    }
    return new FeedCommentImpressionEvent(header, requestHeader, mobileHeader, comments, hasHeader, hasRequestHeader, hasMobileHeader, hasComments);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedCommentImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */