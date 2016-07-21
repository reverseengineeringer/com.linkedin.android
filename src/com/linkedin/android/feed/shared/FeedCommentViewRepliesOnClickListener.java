package com.linkedin.android.feed.shared;

import android.view.View;
import com.linkedin.android.feed.events.FeedCommentViewRepliesClickEvent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;

public final class FeedCommentViewRepliesOnClickListener
  extends TrackingOnClickListener
{
  private final WeakReference<FragmentComponent> fragmentComponent;
  
  public FeedCommentViewRepliesOnClickListener(FragmentComponent paramFragmentComponent, String paramString)
  {
    super(paramFragmentComponent.tracker(), paramString, new TrackingEventBuilder[0]);
    fragmentComponent = new WeakReference(paramFragmentComponent);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = (FragmentComponent)fragmentComponent.get();
    if (paramView != null)
    {
      paramView.eventBus();
      Bus.publish(new FeedCommentViewRepliesClickEvent());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedCommentViewRepliesOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */