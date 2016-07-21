package com.linkedin.android.feed.events;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class FeedCommentUpdateEvent
{
  public Comment changedComment;
  public String fakeId;
  public boolean hide;
  public Update newUpdate;
  public String realId;
  public int updateEventType;
  
  public static FeedCommentUpdateEvent confirmDeleteCommentEvent(Update paramUpdate, Comment paramComment)
  {
    FeedCommentUpdateEvent localFeedCommentUpdateEvent = new FeedCommentUpdateEvent();
    updateEventType = 9;
    newUpdate = paramUpdate;
    changedComment = paramComment;
    realId = urn.toString();
    hide = true;
    return localFeedCommentUpdateEvent;
  }
  
  public static FeedCommentUpdateEvent deleteCommentEvent(Update paramUpdate, Comment paramComment)
  {
    FeedCommentUpdateEvent localFeedCommentUpdateEvent = new FeedCommentUpdateEvent();
    updateEventType = 8;
    newUpdate = paramUpdate;
    changedComment = paramComment;
    realId = urn.toString();
    hide = true;
    return localFeedCommentUpdateEvent;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.FeedCommentUpdateEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */