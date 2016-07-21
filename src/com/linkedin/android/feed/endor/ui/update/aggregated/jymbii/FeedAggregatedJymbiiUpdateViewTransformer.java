package com.linkedin.android.feed.endor.ui.update.aggregated.jymbii;

import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.AggregatedJymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.JymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailTransformer;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewTransformer;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer;
import com.linkedin.android.feed.endor.ui.component.insight.FeedInsightTransformer;
import com.linkedin.android.feed.endor.ui.component.seeall.FeedSeeAllTransformer;
import com.linkedin.android.feed.endor.ui.transformer.FeedTransformerUtils;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.List;

public final class FeedAggregatedJymbiiUpdateViewTransformer
  extends FeedTransformerUtils
{
  public static FeedSingleUpdateViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, AggregatedJymbiiUpdateDataModel paramAggregatedJymbiiUpdateDataModel)
  {
    ArrayList localArrayList = new ArrayList();
    safeAdd(localArrayList, FeedHeaderViewTransformer.toViewModel(paramFragmentComponent, paramAggregatedJymbiiUpdateDataModel));
    int i = 0;
    while (i < updates.size())
    {
      Object localObject2 = (JymbiiUpdateDataModel)updates.get(i);
      localObject1 = FeedContentDetailTransformer.toViewModel((UpdateDataModel)localObject2, paramFragmentComponent, 4, false);
      localObject2 = FeedInsightTransformer.toViewModel((UpdateDataModel)localObject2, paramFragmentComponent);
      safeAdd(localArrayList, localObject1);
      safeAdd(localArrayList, localObject2);
      if (i != updates.size() - 1) {
        safeAdd(localArrayList, FeedDividerViewTransformer.toViewModel(paramAggregatedJymbiiUpdateDataModel, paramFragmentComponent));
      }
      i += 1;
    }
    safeAdd(localArrayList, FeedSeeAllTransformer.toViewModel(paramAggregatedJymbiiUpdateDataModel, paramFragmentComponent));
    Object localObject1 = null;
    if (!actions.isEmpty()) {
      localObject1 = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
    }
    return new FeedAggregatedJymbiiUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, localArrayList, (TrackingOnClickListener)localObject1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.jymbii.FeedAggregatedJymbiiUpdateViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */