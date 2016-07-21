package com.linkedin.android.feed.endor.ui.component.detailheader;

import android.view.LayoutInflater;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedDetailSectionHeaderViewModel
  extends FeedComponentViewModel<FeedDetailSectionHeaderViewHolder, FeedDetailSectionHeaderLayout>
{
  public SortOrder order = SortOrder.$UNKNOWN;
  public CharSequence titleText;
  public TrackingOnClickListener toggleOnClickListener;
  public CharSequence toggleText;
  public int type;
  
  public FeedDetailSectionHeaderViewModel()
  {
    super(new FeedDetailSectionHeaderLayout());
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedDetailSectionHeaderViewHolder paramFeedDetailSectionHeaderViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedDetailSectionHeaderViewHolder);
    setupTextViewsAndOnClickListeners(paramFeedDetailSectionHeaderViewHolder);
  }
  
  private void setupTextViewsAndOnClickListeners(FeedDetailSectionHeaderViewHolder paramFeedDetailSectionHeaderViewHolder)
  {
    ViewUtils.setTextAndUpdateVisibility(title, titleText);
    ViewUtils.setTextAndUpdateVisibility(toggle, toggleText);
    ViewUtils.setOnClickListenerAndUpdateClickable(toggle, toggleOnClickListener);
  }
  
  public final ViewHolderCreator<FeedDetailSectionHeaderViewHolder> getCreator()
  {
    return FeedDetailSectionHeaderViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.detailheader.FeedDetailSectionHeaderViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */