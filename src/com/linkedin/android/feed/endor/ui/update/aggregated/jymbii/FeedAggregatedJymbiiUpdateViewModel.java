package com.linkedin.android.feed.endor.ui.update.aggregated.jymbii;

import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedJymbiiUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.feed.Entity;
import java.util.Collections;
import java.util.List;

public final class FeedAggregatedJymbiiUpdateViewModel
  extends FeedSingleUpdateViewModel
{
  public FeedAggregatedJymbiiUpdateViewModel(Update paramUpdate, FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List<FeedComponentViewModel> paramList, TrackingOnClickListener paramTrackingOnClickListener)
  {
    super(paramUpdate, paramFragmentComponent, paramFeedComponentsViewPool, paramList, paramTrackingOnClickListener);
  }
  
  protected final List<Entity> createTrackingEntities(ImpressionData paramImpressionData, int paramInt)
  {
    if (update != null)
    {
      if (update.value.aggregatedJymbiiUpdateValue != null) {
        return FeedTracking.createTrackingEntitiesForUpdates(lixManager, update.value.aggregatedJymbiiUpdateValue.jymbiiUpdates, paramImpressionData, paramInt);
      }
      if (update.value.jymbiiUpdateValue != null) {
        return Collections.singletonList(FeedTracking.createTrackingEntityForUpdate(lixManager, update, paramImpressionData, paramInt));
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.jymbii.FeedAggregatedJymbiiUpdateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */