package com.linkedin.android.feed.endor.ui.component.nativevideo;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class FeedNativeVideoViewModel$1
  extends TrackingOnClickListener
{
  FeedNativeVideoViewModel$1(FeedNativeVideoViewModel paramFeedNativeVideoViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FeedNativeVideoViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.playVideo(val$holder, paramView.getContext());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */