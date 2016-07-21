package com.linkedin.android.feed.endor.ui.component.comment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.content.ContextCompat;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.linkedin.android.artdeco.ArtDeco;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.shared.LikeButton;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.tracking.NestedTrackableViewModel;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.infra.ui.ExpandableTextView.OnHeightChangeListener;
import com.linkedin.android.infra.ui.TintableImageView;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.feed.Comment.Builder;
import com.makeramen.roundedimageview.RoundedImageView;

public final class FeedCommentViewModel
  extends FeedComponentViewModel<FeedCommentViewHolder, FeedCommentLayout>
  implements NestedTrackableViewModel
{
  public float backgroundAlpha;
  public TrackingOnClickListener commentLikeClickListener;
  public View.OnLongClickListener commentLongClickListener;
  public TrackingOnClickListener commentReplyClickListener;
  public Spanned commentText;
  public TrackingOnClickListener commentTextClickListener;
  public CharSequence commentTime;
  public CharSequence commentTimeContentDescription;
  public String commentUrn;
  public TrackingOnClickListener commenterClickListener;
  public CharSequence commenterHeadline;
  public ImageModel commenterImage;
  public CharSequence commenterName;
  public String containerContentDescription;
  public long firstBoundTimestamp;
  public boolean hasActions;
  private final ExpandableTextView.OnHeightChangeListener heightChangeListener = new ExpandableTextView.OnHeightChangeListener()
  {
    public final void onHeightChanged$2231e745(ExpandableTextView paramAnonymousExpandableTextView)
    {
      isCommentExpanded = paramAnonymousExpandableTextView.isExpanded();
    }
  };
  public boolean hideCommentActionIcons;
  public long highlightFadeAnimationDuration;
  boolean isCommentExpanded;
  public boolean isHidden;
  public boolean isHighlighted;
  public boolean isLiked;
  private boolean isReply;
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
  
  public FeedCommentViewModel(ApplicationComponent paramApplicationComponent, FeedCommentLayout paramFeedCommentLayout, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramFeedCommentLayout);
    tracker = paramApplicationComponent.tracker();
    isReply = paramBoolean1;
    hideCommentActionIcons = paramBoolean2;
  }
  
  private Mapper onBindTrackableViews$737b2c6f(Mapper paramMapper, FeedCommentViewHolder paramFeedCommentViewHolder)
  {
    if (trackingBuilder != null) {
      try
      {
        if (!isReply)
        {
          paramMapper.bindTrackableViews(new View[] { commentContainer });
          return paramMapper;
        }
        paramMapper.bindTrackableViews(new View[] { replyTrackableView });
        return paramMapper;
      }
      catch (TrackingException localTrackingException)
      {
        itemView.getContext();
        Util.safeThrow$7a8b4789(new RuntimeException(localTrackingException));
      }
    }
    return paramMapper;
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedCommentViewHolder paramFeedCommentViewHolder)
  {
    int i = 2130837797;
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedCommentViewHolder);
    if (firstBoundTimestamp == 0L)
    {
      Util.getAppComponent(itemView.getContext()).timeWrapper();
      firstBoundTimestamp = System.currentTimeMillis();
    }
    if (isHidden)
    {
      paramFeedCommentViewHolder.hide();
      return;
    }
    paramFeedCommentViewHolder.show();
    setupTextViews(paramFeedCommentViewHolder);
    if (commenterImage != null)
    {
      commenterImage.setImageView(paramMediaCenter, commenterImage);
      commenterImage.setVisibility(0);
    }
    if (isCommentExpanded)
    {
      commentText.expand(false);
      itemView.setAlpha(backgroundAlpha);
      commentContainer.setContentDescription(containerContentDescription);
      if (!isHighlighted) {
        break label321;
      }
      if (highlightFadeAnimationDuration <= 0L) {
        break label289;
      }
      Util.getAppComponent(itemView.getContext()).timeWrapper();
      if (System.currentTimeMillis() - firstBoundTimestamp >= 1000L) {
        break label261;
      }
      paramLayoutInflater = itemView.getContext();
      if (!hasActions) {
        break label254;
      }
    }
    label254:
    for (i = 2130837819;; i = 2130837818)
    {
      paramLayoutInflater = (TransitionDrawable)ContextCompat.getDrawable(paramLayoutInflater, i);
      JellyBeanUtils.setBackground(itemView, paramLayoutInflater);
      paramLayoutInflater.setCrossFadeEnabled(true);
      paramLayoutInflater.startTransition((int)highlightFadeAnimationDuration);
      setupLikeButton(paramFeedCommentViewHolder, false);
      setupReplyButton(paramFeedCommentViewHolder);
      updateListeners(paramFeedCommentViewHolder);
      return;
      commentText.collapse(false);
      break;
    }
    label261:
    paramLayoutInflater = itemView;
    if (hasActions) {}
    for (;;)
    {
      paramLayoutInflater.setBackgroundResource(i);
      break;
      i = 2131624051;
    }
    label289:
    paramLayoutInflater = itemView;
    if (hasActions) {}
    for (i = 2130837795;; i = 2131624156)
    {
      paramLayoutInflater.setBackgroundResource(i);
      break;
    }
    label321:
    paramLayoutInflater = itemView;
    if (hasActions) {}
    for (;;)
    {
      paramLayoutInflater.setBackgroundResource(i);
      break;
      i = 2131624051;
    }
  }
  
  private void setupLikeButton(FeedCommentViewHolder paramFeedCommentViewHolder, boolean paramBoolean)
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
          break label157;
        }
        localObject = commentLikeText;
        if (!isLiked) {
          break label150;
        }
      }
      label150:
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
      label157:
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
  
  private void setupReplyButton(FeedCommentViewHolder paramFeedCommentViewHolder)
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
  
  private void setupTextViews(FeedCommentViewHolder paramFeedCommentViewHolder)
  {
    ViewUtils.setTextAndUpdateVisibility(commenterName, commenterName);
    ViewUtils.setTextAndUpdateVisibility(commenterHeadline, commenterHeadline);
    ViewUtils.setTextAndUpdateVisibility(commentTime, commentTime, commentTimeContentDescription);
    ViewUtils.setTextAndUpdateVisibility(commentText, commentText);
    FeedTextUtils.setTextIsSelectable$352fc170(Util.getAppComponent(itemView.getContext()), commentText);
    if (likeCount > 0L)
    {
      likeCount.setText(likeCountText);
      likeCount.setVisibility(0);
      if (replyCount <= 0L) {
        break label186;
      }
      replyCount.setText(replyCountText);
      replyCount.setVisibility(0);
      label121:
      if ((likeCount <= 0L) && (replyCount <= 0L)) {
        break label198;
      }
      divider.setVisibility(0);
    }
    for (;;)
    {
      if ((likeCount <= 0L) || (replyCount <= 0L)) {
        break label210;
      }
      bullet.setVisibility(0);
      return;
      likeCount.setVisibility(8);
      break;
      label186:
      replyCount.setVisibility(8);
      break label121;
      label198:
      divider.setVisibility(8);
    }
    label210:
    bullet.setVisibility(8);
  }
  
  private void updateListeners(FeedCommentViewHolder paramFeedCommentViewHolder)
  {
    commenterImage.setOnClickListener(commenterClickListener);
    commenterName.setOnClickListener(commenterClickListener);
    commenterHeadline.setOnClickListener(commenterClickListener);
    commentText.setOnClickListener(commentTextClickListener);
    commentLikeLayout.setOnClickListener(commentLikeClickListener);
    commentReplyLayout.setOnClickListener(commentReplyClickListener);
    likeCount.setOnClickListener(likeCountClickListener);
    replyCount.setOnClickListener(replyCountClickListener);
    ApplicationComponent localApplicationComponent = Util.getAppComponent(itemView.getContext());
    localApplicationComponent.longClickUtil();
    commentContainer.setOnLongClickListener(commentLongClickListener);
    if (!FeedLixHelper.isEnabled(localApplicationComponent.lixManager(), Lix.FEED_SELECTABLE_TEXT)) {
      commentText.setOnLongClickListener(commentLongClickListener);
    }
    commentText.setOnHeightChangedListener(heightChangeListener);
    commenterImage.setOnLongClickListener(commentLongClickListener);
    commenterName.setOnLongClickListener(commentLongClickListener);
    commenterHeadline.setOnLongClickListener(commentLongClickListener);
  }
  
  public final ViewHolderCreator<FeedCommentViewHolder> getCreator()
  {
    return FeedCommentViewHolder.CREATOR;
  }
  
  public final int[] getTrackableViewIds()
  {
    if (!isReply) {
      return new int[] { 2131755620 };
    }
    return new int[] { 2131755619 };
  }
  
  public final boolean handlesViewModelChanges()
  {
    return true;
  }
  
  public final boolean isChangeableTo(ViewModel paramViewModel)
  {
    return (super.isChangeableTo(paramViewModel)) && ((paramViewModel instanceof FeedCommentViewModel)) && (commentUrn != null) && (commentUrn.equals(commentUrn));
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    paramImpressionData = FeedTracking.createTrackingComments(trackingBuilder, paramImpressionData, false, false);
    if (paramImpressionData != null) {
      tracker.send(paramImpressionData);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */