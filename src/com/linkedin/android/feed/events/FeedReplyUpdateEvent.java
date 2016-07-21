package com.linkedin.android.feed.events;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;

public final class FeedReplyUpdateEvent
{
  public Comment changedReply;
  public String fakeId;
  public boolean hide;
  public Comment newComment;
  public String realId;
  public int updateEventType;
  
  public static FeedReplyUpdateEvent confirmDeleteReplyEvent(Comment paramComment1, Comment paramComment2)
  {
    FeedReplyUpdateEvent localFeedReplyUpdateEvent = new FeedReplyUpdateEvent();
    updateEventType = 9;
    newComment = paramComment1;
    changedReply = paramComment2;
    realId = urn.toString();
    hide = true;
    return localFeedReplyUpdateEvent;
  }
  
  public static FeedReplyUpdateEvent deleteReplyEvent(Comment paramComment1, Comment paramComment2)
  {
    FeedReplyUpdateEvent localFeedReplyUpdateEvent = new FeedReplyUpdateEvent();
    updateEventType = 8;
    newComment = paramComment1;
    changedReply = paramComment2;
    realId = urn.toString();
    hide = true;
    return localFeedReplyUpdateEvent;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.FeedReplyUpdateEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */