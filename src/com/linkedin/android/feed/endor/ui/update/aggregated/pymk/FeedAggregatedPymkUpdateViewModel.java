package com.linkedin.android.feed.endor.ui.update.aggregated.pymk;

import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.feed.Entity;
import java.util.List;

public final class FeedAggregatedPymkUpdateViewModel
  extends FeedSingleUpdateViewModel
{
  public final List<String> actorIds;
  
  public FeedAggregatedPymkUpdateViewModel(Update paramUpdate, FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List<FeedComponentViewModel> paramList, TrackingOnClickListener paramTrackingOnClickListener, List<String> paramList1)
  {
    super(paramUpdate, paramFragmentComponent, paramFeedComponentsViewPool, paramList, paramTrackingOnClickListener);
    actorIds = paramList1;
  }
  
  protected final List<Entity> createTrackingEntities(ImpressionData paramImpressionData, int paramInt)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.pymk.FeedAggregatedPymkUpdateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */