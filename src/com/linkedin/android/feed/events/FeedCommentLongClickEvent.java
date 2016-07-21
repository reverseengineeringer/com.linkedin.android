package com.linkedin.android.feed.events;

import com.linkedin.android.feed.viewmodels.models.CommentActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class FeedCommentLongClickEvent
{
  public List<CommentActionModel> actions;
  public Comment comment;
  public Update update;
  
  public FeedCommentLongClickEvent(Update paramUpdate, Comment paramComment, List<CommentActionModel> paramList)
  {
    update = paramUpdate;
    comment = paramComment;
    actions = paramList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.FeedCommentLongClickEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */