package com.linkedin.android.feed.events;

import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;

public final class FeedToggleCommentOrderingEvent
{
  public final SortOrder order;
  
  public FeedToggleCommentOrderingEvent(SortOrder paramSortOrder)
  {
    order = paramSortOrder;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.FeedToggleCommentOrderingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */