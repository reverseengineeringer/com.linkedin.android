package com.linkedin.android.feed.shared;

import android.view.View;
import com.linkedin.android.feed.events.FeedReplyButtonClickEvent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedReplyButtonOnClickListener
  extends TrackingOnClickListener
{
  private final Comment comment;
  private final FragmentComponent fragmentComponent;
  
  public FeedReplyButtonOnClickListener(FragmentComponent paramFragmentComponent, String paramString, Comment paramComment)
  {
    super(paramFragmentComponent.tracker(), paramString, new TrackingEventBuilder[0]);
    fragmentComponent = paramFragmentComponent;
    comment = paramComment;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    fragmentComponent.eventBus();
    Bus.publish(new FeedReplyButtonClickEvent(comment));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedReplyButtonOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */