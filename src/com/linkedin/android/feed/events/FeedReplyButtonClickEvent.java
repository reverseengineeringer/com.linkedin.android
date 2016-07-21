package com.linkedin.android.feed.events;

import com.linkedin.android.pegasus.gen.voyager.feed.Comment;

public final class FeedReplyButtonClickEvent
{
  public final Comment comment;
  
  public FeedReplyButtonClickEvent(Comment paramComment)
  {
    comment = paramComment;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.FeedReplyButtonClickEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */