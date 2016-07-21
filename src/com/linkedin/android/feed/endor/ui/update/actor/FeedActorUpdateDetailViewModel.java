package com.linkedin.android.feed.endor.ui.update.actor;

import android.view.View;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel.PymkRecommendationBuilder;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewHolder;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.Page;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation.Builder;
import java.util.Collections;
import java.util.List;

public final class FeedActorUpdateDetailViewModel
  extends FeedComponentListViewModel
{
  private final LixManager lixManager;
  private final PymkUpdateDataModel.PymkRecommendationBuilder pymkRecommendationBuilder;
  private final Tracker tracker;
  public TrackingData trackingData;
  public String updateUrn;
  private final String usageContext;
  
  public FeedActorUpdateDetailViewModel(Update paramUpdate, FeedComponentsViewPool paramFeedComponentsViewPool, FragmentComponent paramFragmentComponent, FeedComponentViewModel paramFeedComponentViewModel, PymkUpdateDataModel.PymkRecommendationBuilder paramPymkRecommendationBuilder)
  {
    this(paramUpdate, paramFeedComponentsViewPool, paramFragmentComponent, Collections.singletonList(paramFeedComponentViewModel), paramPymkRecommendationBuilder);
  }
  
  public FeedActorUpdateDetailViewModel(Update paramUpdate, FeedComponentsViewPool paramFeedComponentsViewPool, FragmentComponent paramFragmentComponent, List<FeedComponentViewModel> paramList, PymkUpdateDataModel.PymkRecommendationBuilder paramPymkRecommendationBuilder)
  {
    super(paramFeedComponentsViewPool, paramList);
    if (urn != null) {
      updateUrn = urn.toString();
    }
    trackingData = tracking;
    tracker = paramFragmentComponent.tracker();
    lixManager = paramFragmentComponent.lixManager();
    paramUpdate = paramFragmentComponent.fragment();
    if ((paramUpdate instanceof Page)) {}
    for (paramUpdate = TrackingUtils.getTrackKey(((Page)paramUpdate).pageKey());; paramUpdate = null)
    {
      usageContext = paramUpdate;
      pymkRecommendationBuilder = paramPymkRecommendationBuilder;
      return;
    }
  }
  
  private PymkClientImpressionEvent.Builder getPymkClientImpressionEvent(PymkUpdateDataModel.PymkRecommendationBuilder paramPymkRecommendationBuilder, int paramInt)
  {
    try
    {
      paramPymkRecommendationBuilder = new PymkClientImpressionEvent.Builder().setUsageContext(usageContext).setRecommendations(Collections.singletonList(new PymkRecommendation.Builder().setRecommendationUrn(pymkUpdateUrn.toString()).setTrackingId(trackingId).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(paramInt)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD)));
      return paramPymkRecommendationBuilder;
    }
    catch (BuilderException paramPymkRecommendationBuilder)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to build PymkClientImpressionEvent on Pymk detail list"));
    }
    return null;
  }
  
  public final Mapper onBindTrackableViews(Mapper paramMapper, FeedComponentListViewHolder paramFeedComponentListViewHolder, int paramInt)
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
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    int i = position + 1;
    if (pymkRecommendationBuilder != null)
    {
      PymkClientImpressionEvent.Builder localBuilder = getPymkClientImpressionEvent(pymkRecommendationBuilder, i);
      if (localBuilder != null) {
        tracker.send(localBuilder);
      }
    }
    paramImpressionData = Collections.singletonList(FeedTracking.createTrackingEntityForUpdate(lixManager, updateUrn, trackingData, paramImpressionData, i));
    if ((paramImpressionData != null) && (!paramImpressionData.isEmpty())) {
      return new FeedImpressionEvent.Builder().setEntities(paramImpressionData);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.actor.FeedActorUpdateDetailViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */