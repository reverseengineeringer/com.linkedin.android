package com.linkedin.android.feed.endor.ui.component.collapse;

import android.view.LayoutInflater;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedCollapseViewModel
  extends FeedComponentViewModel<FeedCollapseViewHolder, FeedCollapseLayout>
{
  public TrackingOnClickListener improveMyFeedListener;
  public CharSequence subtitle;
  public CharSequence title;
  public TrackingOnClickListener undoListener;
  
  public FeedCollapseViewModel(FeedCollapseLayout paramFeedCollapseLayout, CharSequence paramCharSequence1, CharSequence paramCharSequence2, TrackingOnClickListener paramTrackingOnClickListener1, TrackingOnClickListener paramTrackingOnClickListener2)
  {
    super(paramFeedCollapseLayout);
    title = paramCharSequence1;
    subtitle = paramCharSequence2;
    undoListener = paramTrackingOnClickListener1;
    improveMyFeedListener = paramTrackingOnClickListener2;
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedCollapseViewHolder paramFeedCollapseViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedCollapseViewHolder);
    ViewUtils.setTextAndUpdateVisibility(title, title);
    ViewUtils.setTextAndUpdateVisibility(subtitle, subtitle);
    ViewUtils.setOnClickListenerAndUpdateVisibility(undo, undoListener, false);
    ViewUtils.setOnClickListenerAndUpdateVisibility(improveMyFeed, improveMyFeedListener, false);
  }
  
  public final ViewHolderCreator<FeedCollapseViewHolder> getCreator()
  {
    return FeedCollapseViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.collapse.FeedCollapseViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */