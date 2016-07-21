package com.linkedin.android.feed.endor.ui.update.aggregated.pymk;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ActorUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedPymkUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.actorcard.FeedActorCardTransformer;
import com.linkedin.android.feed.endor.ui.component.actorcard.FeedActorCardViewModel;
import com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselViewTransformer;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer;
import com.linkedin.android.feed.endor.ui.component.seeallcard.FeedSeeAllCardTransformer;
import com.linkedin.android.feed.endor.ui.transformer.FeedTransformerUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.List;

public final class FeedAggregatedPymkUpdateViewTransformer
  extends FeedTransformerUtils
{
  public static FeedAggregatedPymkUpdateViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, AggregatedPymkUpdateDataModel paramAggregatedPymkUpdateDataModel)
  {
    ArrayList localArrayList1 = new ArrayList();
    safeAdd(localArrayList1, FeedHeaderViewTransformer.toViewModel(paramFragmentComponent, paramAggregatedPymkUpdateDataModel));
    int i = updates.size();
    if (i > 6) {
      i = 5;
    }
    ArrayList localArrayList2;
    for (;;)
    {
      localObject = new ArrayList(i);
      localArrayList2 = new ArrayList(i);
      int j = 0;
      while (j < i)
      {
        ActorUpdateDataModel localActorUpdateDataModel = (ActorUpdateDataModel)updates.get(j);
        FeedActorCardViewModel localFeedActorCardViewModel = FeedActorCardTransformer.toViewModel(localActorUpdateDataModel, paramFragmentComponent);
        if (localFeedActorCardViewModel != null)
        {
          ((List)localObject).add(localFeedActorCardViewModel);
          localArrayList2.add(primaryActor.id);
        }
        j += 1;
      }
    }
    safeAdd((List)localObject, FeedSeeAllCardTransformer.toViewModel(paramFragmentComponent, paramAggregatedPymkUpdateDataModel));
    safeAdd(localArrayList1, FeedCarouselViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (List)localObject));
    Object localObject = null;
    if (!actions.isEmpty()) {
      localObject = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
    }
    return new FeedAggregatedPymkUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, localArrayList1, (TrackingOnClickListener)localObject, localArrayList2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.pymk.FeedAggregatedPymkUpdateViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */