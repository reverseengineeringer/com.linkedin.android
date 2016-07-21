package com.linkedin.android.feed.shared;

import android.view.View;
import com.linkedin.android.feed.events.FeedCommentButtonClickEvent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedCommentButtonOnClickListener
  extends TrackingOnClickListener
{
  private final FragmentComponent fragmentComponent;
  
  public FeedCommentButtonOnClickListener(FragmentComponent paramFragmentComponent, String paramString)
  {
    super(paramFragmentComponent.tracker(), paramString, new TrackingEventBuilder[0]);
    fragmentComponent = paramFragmentComponent;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    fragmentComponent.eventBus();
    Bus.publish(new FeedCommentButtonClickEvent());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedCommentButtonOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */