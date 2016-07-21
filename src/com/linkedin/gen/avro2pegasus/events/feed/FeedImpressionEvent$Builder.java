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

public final class FeedImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FeedImpressionEvent>
{
  private List<Entity> entities = null;
  private boolean hasEntities = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasSearchId = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public String searchId = null;
  
  public FeedImpressionEvent$Builder() {}
  
  public FeedImpressionEvent$Builder(FeedImpressionEvent paramFeedImpressionEvent)
  {
    header = header;
    requestHeader = requestHeader;
    mobileHeader = mobileHeader;
    entities = entities;
    searchId = searchId;
    hasHeader = hasHeader;
    hasRequestHeader = hasRequestHeader;
    hasMobileHeader = hasMobileHeader;
    hasEntities = hasEntities;
    hasSearchId = hasSearchId;
  }
  
  public final FeedImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FeedImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (entities != null)
    {
      paramFlavor = entities.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Entity)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent", "entities");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent", "requestHeader");
            }
            if (hasEntities) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent", "entities");
          }
        }
      }
    }
    return new FeedImpressionEvent(header, requestHeader, mobileHeader, entities, searchId, hasHeader, hasRequestHeader, hasMobileHeader, hasEntities, hasSearchId);
  }
  
  public final Builder setEntities(List<Entity> paramList)
  {
    if (paramList == null)
    {
      hasEntities = false;
      entities = null;
      return this;
    }
    hasEntities = true;
    entities = paramList;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */