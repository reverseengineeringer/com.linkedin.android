package com.linkedin.android.feed.endor.ui.update.aggregated.connection;

import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewTransformer;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer;
import com.linkedin.android.feed.endor.ui.component.miniheader.FeedMiniHeaderTransformer;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorTransformer;
import com.linkedin.android.feed.endor.ui.component.seeall.FeedSeeAllTransformer;
import com.linkedin.android.feed.endor.ui.transformer.FeedTransformerUtils;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.List;

public final class FeedAggregatedConnectionUpdateViewTransformer
  extends FeedTransformerUtils
{
  public static FeedSingleUpdateViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, AggregatedConnectionUpdateDataModel paramAggregatedConnectionUpdateDataModel)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    safeAdd(localArrayList1, FeedHeaderViewTransformer.toViewModel(paramFragmentComponent, paramAggregatedConnectionUpdateDataModel));
    int j = Math.min(updates.size(), 2);
    int i = 0;
    if (i < j)
    {
      localObject = (ConnectionUpdateDataModel)updates.get(i);
      localArrayList2.add(newConnection.id);
      safeAdd(localArrayList1, FeedMiniHeaderTransformer.toViewModel(paramFragmentComponent, (UpdateDataModel)localObject));
      if (i == j - 1) {}
      for (boolean bool = true;; bool = false)
      {
        safeAdd(localArrayList1, FeedPrimaryActorTransformer.toViewModel((UpdateDataModel)localObject, paramFragmentComponent, bool));
        if (!bool) {
          safeAdd(localArrayList1, FeedDividerViewTransformer.toViewModel((UpdateDataModel)localObject, paramFragmentComponent));
        }
        i += 1;
        break;
      }
    }
    if (updates.size() > 2) {
      safeAdd(localArrayList1, FeedSeeAllTransformer.toViewModel(paramAggregatedConnectionUpdateDataModel, paramFragmentComponent));
    }
    Object localObject = null;
    if (!actions.isEmpty()) {
      localObject = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
    }
    return new FeedAggregatedConnectionUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, localArrayList1, (TrackingOnClickListener)localObject, localArrayList2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.connection.FeedAggregatedConnectionUpdateViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */