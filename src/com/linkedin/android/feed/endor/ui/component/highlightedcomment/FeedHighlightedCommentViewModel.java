package com.linkedin.android.feed.endor.ui.component.highlightedcomment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.linkedin.android.artdeco.ArtDeco;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.tracking.NestedTrackableViewModel;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.ExpandableTextView.OnHeightChangeListener;
import com.linkedin.android.infra.ui.TintableImageView;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.feed.Comment.Builder;

public final class FeedHighlightedCommentViewModel
  extends FeedComponentViewModel<FeedHighlightedCommentViewHolder, FeedHighlightedCommentLayout>
  implements NestedTrackableViewModel
{
  public TrackingOnClickListener commentLikeClickListener;
  public TrackingOnClickListener commentReplyClickListener;
  public ImageModel commenterImageModel;
  public boolean disableExpandOnEllipsisClick;
  public TrackingOnClickListener feedUpdateOnClickListener;
  public ExpandableTextView.OnHeightChangeListener heightChangeListener = new ExpandableTextView.OnHeightChangeListener()
  {
    public final void onHeightChanged$2231e745(ExpandableTextView paramAnonymousExpandableTextView)
    {
      isHighlightedCommentaryExpanded = paramAnonymousExpandableTextView.isExpanded();
    }
  };
  public boolean hideCommentActionIcons;
  public Spanned highlightedActorAndCommentText;
  public View.OnClickListener highlightedSectionEllipsisTextClickListener;
  public boolean isHighlightedCommentaryExpanded;
  public boolean isLiked;
  public CharSequence likeContentDescription;
  public long likeCount;
  public TrackingOnClickListener likeCountClickListener;
  public CharSequence likeCountText;
  public CharSequence replyContentDescription;
  public long replyCount;
  public TrackingOnClickListener replyCountClickListener;
  public CharSequence replyCountText;
  private Tracker tracker;
  public Comment.Builder trackingBuilder;
  
  public FeedHighlightedCommentViewModel(FeedHighlightedCommentLayout paramFeedHighlightedCommentLayout, boolean paramBoolean)
  {
    super(paramFeedHighlightedCommentLayout);
    hideCommentActionIcons = paramBoolean;
  }
  
  private Mapper onBindTrackableViews$444e68ad(Mapper paramMapper, FeedHighlightedCommentViewHolder paramFeedHighlightedCommentViewHolder)
  {
    if (trackingBuilder != null) {}
    try
    {
      paramMapper.bindTrackableViews(new View[] { itemView });
      return paramMapper;
    }
    catch (TrackingException localTrackingException)
    {
      itemView.getContext();
      Util.safeThrow$7a8b4789(new RuntimeException(localTrackingException));
    }
    return paramMapper;
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedHighlightedCommentViewHolder paramFeedHighlightedCommentViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedHighlightedCommentViewHolder);
    tracker = Util.getAppComponent(itemView.getContext()).tracker();
    setupTextViews(paramFeedHighlightedCommentViewHolder);
    setupLikeButton(paramFeedHighlightedCommentViewHolder, false);
    setupReplyButton(paramFeedHighlightedCommentViewHolder);
    if (commenterImageModel != null) {
      commenterImageModel.setImageView(paramMediaCenter, commenterImage);
    }
    setListeners(paramFeedHighlightedCommentViewHolder);
  }
  
  private void setListeners(FeedHighlightedCommentViewHolder paramFeedHighlightedCommentViewHolder)
  {
    itemView.setOnClickListener(feedUpdateOnClickListener);
    actorAndCommentText.setOnHeightChangedListener(heightChangeListener);
    actorAndCommentText.setOnEllipsisTextClickListener(highlightedSectionEllipsisTextClickListener);
    ExpandableTextView localExpandableTextView = actorAndCommentText;
    if (!disableExpandOnEllipsisClick) {}
    for (boolean bool = true;; bool = false)
    {
      localExpandableTextView.setIsExpandable(bool);
      commenterImage.setOnClickListener(feedUpdateOnClickListener);
      commentLikeLayout.setOnClickListener(commentLikeClickListener);
      commentLikeCount.setOnClickListener(likeCountClickListener);
      commentReplyLayout.setOnClickListener(commentReplyClickListener);
      commentReplyCount.setOnClickListener(replyCountClickListener);
      return;
    }
  }
  
  private void setupLikeButton(FeedHighlightedCommentViewHolder paramFeedHighlightedCommentViewHolder, boolean paramBoolean)
  {
    int i = 8;
    if (commentLikeClickListener != null)
    {
      commentLikeLayout.setVisibility(0);
      commentLikeLayout.setContentDescription(likeContentDescription);
      Object localObject = commentLike;
      if (hideCommentActionIcons)
      {
        ((LikeButton)localObject).setVisibility(i);
        j = 0;
        if (!hideCommentActionIcons) {
          break label153;
        }
        localObject = commentLikeText;
        if (!isLiked) {
          break label147;
        }
      }
      label147:
      for (i = 2131231095;; i = 2131231093)
      {
        ((TextView)localObject).setText(i);
        ArtDeco.setTextViewAppearance(commentLikeText, 2131361852, itemView.getContext());
        commentLikeText.setTextColor(ContextCompat.getColor(itemView.getContext(), 2131624336));
        i = j;
        ViewUtils.setMargins(commentLikeText, i, i, 0, 0);
        commentLike.setLikeState(isLiked, paramBoolean);
        return;
        i = 0;
        break;
      }
      label153:
      int j = itemView.getContext().getResources().getDimensionPixelSize(2131492987);
      commentLikeText.setText(2131231093);
      localObject = itemView.getContext();
      if (isLiked) {}
      for (i = 2131624191;; i = 2131624336)
      {
        i = ContextCompat.getColor((Context)localObject, i);
        commentLikeText.setTextColor(i);
        i = j;
        break;
      }
    }
    commentLikeLayout.setVisibility(8);
  }
  
  private void setupReplyButton(FeedHighlightedCommentViewHolder paramFeedHighlightedCommentViewHolder)
  {
    if (commentReplyClickListener != null)
    {
      commentReplyLayout.setVisibility(0);
      commentReplyLayout.setContentDescription(replyContentDescription);
      int i = 0;
      if (hideCommentActionIcons)
      {
        ArtDeco.setTextViewAppearance(commentReplyText, 2131361852, itemView.getContext());
        commentReplyText.setTextColor(ContextCompat.getColor(itemView.getContext(), 2131623957));
        commentReply.setVisibility(8);
      }
      for (;;)
      {
        ViewUtils.setStartMargin(commentReplyText, i);
        return;
        i = itemView.getContext().getResources().getDimensionPixelSize(2131492987);
        ArtDeco.setTextViewAppearance(commentReplyText, 2131361851, itemView.getContext());
        commentReply.setVisibility(0);
      }
    }
    commentReplyLayout.setVisibility(8);
  }
  
  private void setupTextViews(FeedHighlightedCommentViewHolder paramFeedHighlightedCommentViewHolder)
  {
    actorAndCommentText.setText(highlightedActorAndCommentText);
    FeedTextUtils.setTextIsSelectable$352fc170(Util.getAppComponent(itemView.getContext()), actorAndCommentText);
    if (isHighlightedCommentaryExpanded)
    {
      actorAndCommentText.expand(false);
      actorAndCommentText.setClickable(false);
      if (likeCount <= 0L) {
        break label171;
      }
      commentLikeCount.setText(likeCountText);
      commentLikeCount.setVisibility(0);
      label79:
      if (replyCount <= 0L) {
        break label183;
      }
      commentReplyCount.setText(replyCountText);
      commentReplyCount.setVisibility(0);
      label107:
      if ((likeCount <= 0L) && (replyCount <= 0L)) {
        break label195;
      }
      divider.setVisibility(0);
    }
    for (;;)
    {
      if ((likeCount <= 0L) || (replyCount <= 0L)) {
        break label207;
      }
      bullet.setVisibility(0);
      return;
      actorAndCommentText.collapse(false);
      break;
      label171:
      commentLikeCount.setVisibility(8);
      break label79;
      label183:
      commentReplyCount.setVisibility(8);
      break label107;
      label195:
      divider.setVisibility(8);
    }
    label207:
    bullet.setVisibility(8);
  }
  
  public final ViewHolderCreator<FeedHighlightedCommentViewHolder> getCreator()
  {
    return FeedHighlightedCommentViewHolder.CREATOR;
  }
  
  public final int[] getTrackableViewIds()
  {
    return new int[] { 2131755672 };
  }
  
  public final void onRestoreUpdateViewState(ViewState paramViewState)
  {
    super.onRestoreUpdateViewState(paramViewState);
    isHighlightedCommentaryExpanded = bundle.getBoolean("isFeedHighlightedCommentaryExpanded", false);
  }
  
  public final void onSaveUpdateViewState(ViewState paramViewState)
  {
    super.onSaveUpdateViewState(paramViewState);
    bundle.putBoolean("isFeedHighlightedCommentaryExpanded", isHighlightedCommentaryExpanded);
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    paramImpressionData = FeedTracking.createTrackingComments(trackingBuilder, paramImpressionData, true, isHighlightedCommentaryExpanded);
    if ((tracker != null) && (paramImpressionData != null)) {
      tracker.send(paramImpressionData);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.highlightedcomment.FeedHighlightedCommentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */