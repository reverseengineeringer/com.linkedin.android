package com.linkedin.android.feed.events;

import com.linkedin.android.pegasus.gen.voyager.feed.Comment;

public final class FeedOpenCommentDetailEvent
{
  public int anchor;
  public Comment comment;
  public Comment parentComment;
  public boolean populateMention;
  public int previousPage;
  
  public FeedOpenCommentDetailEvent(Comment paramComment1, Comment paramComment2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    comment = paramComment1;
    parentComment = paramComment2;
    anchor = paramInt1;
    previousPage = paramInt2;
    populateMention = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.FeedOpenCommentDetailEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */