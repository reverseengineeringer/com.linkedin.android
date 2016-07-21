package com.linkedin.android.feed.endor.ui.component.commentary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.ExpandableTextView.OnHeightChangeListener;

public final class FeedCommentaryViewModel
  extends FeedComponentViewModel<FeedCommentaryViewHolder, FeedCommentaryLayout>
{
  CharSequence commentary;
  View.OnClickListener commentaryEllipsisTextClickListener;
  boolean disableExpandOnEllipsisClick;
  final ExpandableTextView.OnHeightChangeListener heightChangeListener = new ExpandableTextView.OnHeightChangeListener()
  {
    public final void onHeightChanged$2231e745(ExpandableTextView paramAnonymousExpandableTextView)
    {
      isCommentaryExpanded = paramAnonymousExpandableTextView.isExpanded();
    }
  };
  boolean isCommentaryExpanded;
  View.OnClickListener updateClickListener;
  
  public FeedCommentaryViewModel(FeedCommentaryLayout paramFeedCommentaryLayout)
  {
    super(paramFeedCommentaryLayout);
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedCommentaryViewHolder paramFeedCommentaryViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedCommentaryViewHolder);
    updateViewHolder(paramFeedCommentaryViewHolder);
  }
  
  private void updateViewHolder(FeedCommentaryViewHolder paramFeedCommentaryViewHolder)
  {
    boolean bool = false;
    ViewUtils.setTextAndUpdateVisibility(commentary, commentary);
    FeedTextUtils.setTextIsSelectable$352fc170(Util.getAppComponent(itemView.getContext()), commentary);
    if (isCommentaryExpanded) {
      commentary.expand(false);
    }
    for (;;)
    {
      commentary.setOnEllipsisTextClickListener(commentaryEllipsisTextClickListener);
      ExpandableTextView localExpandableTextView = commentary;
      if (!disableExpandOnEllipsisClick) {
        bool = true;
      }
      localExpandableTextView.setIsExpandable(bool);
      commentary.setOnHeightChangedListener(heightChangeListener);
      ViewUtils.setOnClickListenerAndUpdateClickable(commentary, updateClickListener, true);
      return;
      commentary.collapse(false);
    }
  }
  
  public final ViewHolderCreator<FeedCommentaryViewHolder> getCreator()
  {
    return FeedCommentaryViewHolder.CREATOR;
  }
  
  public final void onRestoreUpdateViewState(ViewState paramViewState)
  {
    super.onRestoreUpdateViewState(paramViewState);
    isCommentaryExpanded = bundle.getBoolean("isFeedShareCommentaryExpanded", false);
  }
  
  public final void onSaveUpdateViewState(ViewState paramViewState)
  {
    super.onSaveUpdateViewState(paramViewState);
    bundle.putBoolean("isFeedShareCommentaryExpanded", isCommentaryExpanded);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentary.FeedCommentaryViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */