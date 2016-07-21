package com.linkedin.android.feed.endor.ui.component.socialbar;

import android.view.LayoutInflater;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public abstract class FeedBaseSocialBarViewModel<VIEW_HOLDER extends BaseFeedViewHolder, LAYOUT extends FeedComponentLayout<VIEW_HOLDER>>
  extends FeedComponentViewModel<VIEW_HOLDER, LAYOUT>
{
  public boolean isLiked;
  public TrackingOnClickListener likeClickListener;
  public TrackingOnClickListener replyClickListener;
  public TrackingOnClickListener reshareClickListener;
  
  public FeedBaseSocialBarViewModel(LAYOUT paramLAYOUT)
  {
    super(paramLAYOUT);
  }
  
  public abstract void bindViewHolder(VIEW_HOLDER paramVIEW_HOLDER);
  
  public final void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, VIEW_HOLDER paramVIEW_HOLDER)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramVIEW_HOLDER);
    bindViewHolder(paramVIEW_HOLDER);
  }
  
  public void onViewModelChange$2d46306d(VIEW_HOLDER paramVIEW_HOLDER)
  {
    bindViewHolder(paramVIEW_HOLDER);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.socialbar.FeedBaseSocialBarViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */