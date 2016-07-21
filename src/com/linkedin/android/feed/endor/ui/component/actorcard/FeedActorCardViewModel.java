package com.linkedin.android.feed.endor.ui.component.actorcard;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel.PymkRecommendationBuilder;
import com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselComponentViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent.Builder;
import java.util.Collections;
import java.util.List;

public final class FeedActorCardViewModel
  extends FeedCarouselComponentViewModel<FeedActorCardViewHolder, FeedActorCardLayout>
{
  public TrackingOnClickListener actionButtonOnClickListener;
  public TrackingOnClickListener actorClickListener;
  public CharSequence actorHeadline;
  public String actorId;
  public ImageModel actorImage;
  public CharSequence actorName;
  public TrackingOnClickListener actorPictureClickListener;
  public int buttonType = 0;
  public boolean isInfluencer;
  private LixManager lixManager;
  List<PymkUpdateDataModel.PymkRecommendationBuilder> pymkRecommendationBuilders;
  String pymkUsage;
  public CharSequence secondaryHeadline;
  private Tracker tracker;
  private TrackingData trackingData;
  private String updateUrn;
  
  public FeedActorCardViewModel(FragmentComponent paramFragmentComponent, FeedActorCardLayout paramFeedActorCardLayout, Update paramUpdate)
  {
    super(paramFeedActorCardLayout);
    if ((paramUpdate != null) && (urn != null))
    {
      updateUrn = urn.toString();
      trackingData = tracking;
    }
    lixManager = paramFragmentComponent.lixManager();
    tracker = paramFragmentComponent.tracker();
  }
  
  private static Mapper onBindTrackableViews$24f89483(Mapper paramMapper, FeedActorCardViewHolder paramFeedActorCardViewHolder)
  {
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
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedActorCardViewHolder paramFeedActorCardViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedActorCardViewHolder);
    updateViewHolder(paramFeedActorCardViewHolder, paramMediaCenter, true, true, false);
  }
  
  private void updateViewHolder(FeedActorCardViewHolder paramFeedActorCardViewHolder, MediaCenter paramMediaCenter, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ViewUtils.setTextAndUpdateVisibility(actorName, actorName);
    if (isInfluencer) {
      ViewUtils.appendImageSpanToText$71405874(actorName);
    }
    ViewUtils.setTextAndUpdateVisibility(actorHeadline, actorHeadline);
    ViewUtils.setTextAndUpdateVisibility(secondaryHeadline, secondaryHeadline);
    if ((paramBoolean2) && (actorImage != null)) {
      actorImage.setImageView(paramMediaCenter, actorImage);
    }
    if (paramBoolean1) {
      switch (buttonType)
      {
      }
    }
    for (;;)
    {
      actorImage.setOnClickListener(actorPictureClickListener);
      itemView.setOnClickListener(actorClickListener);
      return;
      actionButton.setVisibility(8);
      continue;
      actionButton.setText(2131231271);
      ViewUtils.setOnClickListenerAndUpdateVisibility(actionButton, actionButtonOnClickListener);
      actionButton.setTextColor(ContextCompat.getColorStateList(itemView.getContext(), 2130837641));
      continue;
      actionButton.setText(2131231272);
      actionButton.setTextColor(ContextCompat.getColor(actionButton.getContext(), 2131623957));
      ViewUtils.setOnClickListenerAndUpdateClickable(actionButton, null, true);
      actionButton.setVisibility(0);
      if (paramBoolean3)
      {
        ViewCompat.setAlpha(actionButton, 0.0F);
        ViewCompat.animate(actionButton).alpha(1.0F).setDuration(500L).start();
        continue;
        actionButton.setText(2131231162);
        ViewUtils.setOnClickListenerAndUpdateVisibility(actionButton, actionButtonOnClickListener);
        actionButton.setTextColor(ContextCompat.getColorStateList(itemView.getContext(), 2130837641));
        continue;
        actionButton.setText(2131231164);
        actionButton.setTextColor(ContextCompat.getColor(actionButton.getContext(), 2131623957));
        ViewUtils.setOnClickListenerAndUpdateClickable(actionButton, null, true);
        actionButton.setVisibility(0);
        if (paramBoolean3)
        {
          ViewCompat.setAlpha(actionButton, 0.0F);
          ViewCompat.animate(actionButton).alpha(1.0F).setDuration(500L).start();
          continue;
          actionButton.setText(2131231167);
          ViewUtils.setOnClickListenerAndUpdateVisibility(actionButton, actionButtonOnClickListener);
          continue;
          actionButton.setText(2131231205);
          actionButton.setVisibility(0);
          actionButton.setOnClickListener(actorClickListener);
        }
      }
    }
  }
  
  public final ViewHolderCreator<FeedActorCardViewHolder> getCreator()
  {
    return FeedActorCardViewHolder.CREATOR;
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    int i = position + 1;
    int j = verticalPos + 1;
    if ((pymkRecommendationBuilders != null) && (pymkUsage != null)) {
      tracker.send(FeedTracking.createPymkClientImpressionEvent(pymkRecommendationBuilders, pymkUsage, j, i));
    }
    paramImpressionData = FeedTracking.createTrackingEntityForUpdate(lixManager, updateUrn, trackingData, paramImpressionData, j, i);
    return new FeedImpressionEvent.Builder().setEntities(Collections.singletonList(paramImpressionData));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.actorcard.FeedActorCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */