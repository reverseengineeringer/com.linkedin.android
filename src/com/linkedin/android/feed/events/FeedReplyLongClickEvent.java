package com.linkedin.android.feed.events;

import com.linkedin.android.feed.viewmodels.models.CommentActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import java.util.List;

public final class FeedReplyLongClickEvent
{
  public List<CommentActionModel> actions;
  public Comment comment;
  public Comment reply;
  
  public FeedReplyLongClickEvent(Comment paramComment1, Comment paramComment2, List<CommentActionModel> paramList)
  {
    comment = paramComment1;
    reply = paramComment2;
    actions = paramList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.FeedReplyLongClickEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */