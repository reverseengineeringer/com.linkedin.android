package com.linkedin.android.feed.endor.ui.update.aggregated.followrecommendation;

import android.content.Context;
import android.content.res.Resources;
import com.linkedin.android.feed.endor.datamodel.actor.recommended.RecommendedCompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.recommended.RecommendedMemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ActorUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.FollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedActorUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedFollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.actorcard.FeedActorCardTransformer;
import com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselViewTransformer;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerLayout;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewModel;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer;
import com.linkedin.android.feed.endor.ui.component.improvemyfeedcard.FeedImproveMyFeedCardLayout;
import com.linkedin.android.feed.endor.ui.component.improvemyfeedcard.FeedImproveMyFeedCardViewModel;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorTransformer;
import com.linkedin.android.feed.endor.ui.component.seeall.FeedSeeAllTransformer;
import com.linkedin.android.feed.endor.ui.transformer.FeedTransformerUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.List;

public final class FeedAggregatedFollowRecommendationUpdateViewTransformer
  extends FeedTransformerUtils
{
  public static FeedAggregatedFollowRecommendationUpdateViewModel toHorizontalViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, AggregatedFollowRecommendationUpdateDataModel paramAggregatedFollowRecommendationUpdateDataModel)
  {
    ArrayList localArrayList1 = new ArrayList();
    safeAdd(localArrayList1, FeedHeaderViewTransformer.toViewModel(paramFragmentComponent, paramAggregatedFollowRecommendationUpdateDataModel));
    int i = updates.size();
    if (i > 6) {
      i = 5;
    }
    ArrayList localArrayList2;
    Object localObject;
    for (;;)
    {
      localArrayList2 = new ArrayList(i);
      int j = 0;
      while (j < i)
      {
        localObject = FeedActorCardTransformer.toViewModel((ActorUpdateDataModel)updates.get(j), paramFragmentComponent);
        if (localObject != null) {
          localArrayList2.add(localObject);
        }
        j += 1;
      }
    }
    if ((paramAggregatedFollowRecommendationUpdateDataModel instanceof AggregatedFollowRecommendationUpdateDataModel))
    {
      AggregatedActorUpdateDataModel localAggregatedActorUpdateDataModel = (AggregatedActorUpdateDataModel)paramAggregatedFollowRecommendationUpdateDataModel;
      localObject = new FeedImproveMyFeedCardViewModel(new FeedImproveMyFeedCardLayout());
      if (pegasusUpdate.value.aggregatedFollowRecommendationUpdateValue != null) {
        improveMyFeedOnClickListener = FeedTracking.newSeeMoreFollowRecommendationClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, false);
      }
    }
    for (;;)
    {
      safeAdd(localArrayList2, localObject);
      safeAdd(localArrayList1, FeedCarouselViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, localArrayList2));
      localObject = null;
      if (!actions.isEmpty()) {
        localObject = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
      }
      return new FeedAggregatedFollowRecommendationUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, localArrayList1, (TrackingOnClickListener)localObject);
      localObject = null;
    }
  }
  
  public static FeedAggregatedFollowRecommendationUpdateViewModel toVerticalViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, AggregatedFollowRecommendationUpdateDataModel paramAggregatedFollowRecommendationUpdateDataModel)
  {
    ArrayList localArrayList = new ArrayList();
    safeAdd(localArrayList, FeedHeaderViewTransformer.toViewModel(paramFragmentComponent, paramAggregatedFollowRecommendationUpdateDataModel));
    int j = paramFragmentComponent.context().getResources().getDimensionPixelSize(2131492963);
    int k = paramFragmentComponent.context().getResources().getDimensionPixelSize(2131492989);
    int m = paramFragmentComponent.context().getResources().getDimensionPixelSize(2131492991);
    int i = 0;
    while (i < updates.size())
    {
      localObject = (FollowRecommendationUpdateDataModel)updates.get(i);
      if (((recommendedActor instanceof RecommendedMemberActorDataModel)) || ((recommendedActor instanceof RecommendedCompanyActorDataModel)))
      {
        safeAdd(localArrayList, FeedPrimaryActorTransformer.toViewModel((UpdateDataModel)localObject, paramFragmentComponent, false));
        if (i != updates.size() - 1) {
          safeAdd(localArrayList, new FeedDividerViewModel(new FeedDividerLayout(j + m + k)));
        }
      }
      i += 1;
    }
    if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_FOLLOW_RECOMMENDATION_SEE_MORE)) {
      safeAdd(localArrayList, FeedSeeAllTransformer.toViewModel(paramAggregatedFollowRecommendationUpdateDataModel, paramFragmentComponent));
    }
    Object localObject = null;
    if (!actions.isEmpty()) {
      localObject = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
    }
    return new FeedAggregatedFollowRecommendationUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, localArrayList, (TrackingOnClickListener)localObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.followrecommendation.FeedAggregatedFollowRecommendationUpdateViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */