package com.linkedin.android.feed.endor.ui.update.aggregated.single;

import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonViewModel;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.gen.avro2pegasus.events.feed.Entity;
import java.util.ArrayList;
import java.util.List;

public final class FeedAggregatedSingleUpdateViewModel
  extends FeedUpdateViewModel<FeedAggregatedSingleUpdateViewHolder>
{
  public FeedBasicButtonViewModel seeAllViewModel;
  public FeedComponentListViewModel topComponentsViewModel;
  public final List<FeedAggregatedNestedSingleUpdateViewModel> updateViewModels = new ArrayList();
  
  public FeedAggregatedSingleUpdateViewModel(Update paramUpdate, FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, FeedComponentListViewModel paramFeedComponentListViewModel)
  {
    super(paramUpdate, paramFragmentComponent.context(), paramFeedComponentsViewPool, paramFragmentComponent.sponsoredUpdateTracker(), paramFragmentComponent.lixManager());
    topComponentsViewModel = paramFeedComponentListViewModel;
  }
  
  protected final List<Entity> createTrackingEntities(ImpressionData paramImpressionData, int paramInt)
  {
    if ((update != null) && (update.value.aggregatedShareContentUpdateValue != null)) {
      return FeedTracking.createTrackingEntitiesForUpdates(lixManager, update.value.aggregatedShareContentUpdateValue.rollup, paramImpressionData, paramInt, 2);
    }
    return null;
  }
  
  public final List<List<FeedComponentViewModel>> getComponentSegmentsForBorders()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(topComponentsViewModel.components);
    int i = 0;
    while (i < updateViewModels.size())
    {
      localArrayList.add(updateViewModels.get(i)).wrappedUpdate.components);
      i += 1;
    }
    return localArrayList;
  }
  
  public final List<FeedComponentViewModel> getComponents()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(topComponentsViewModel.components);
    localArrayList.addAll(updateViewModels);
    if (seeAllViewModel != null) {
      localArrayList.add(seeAllViewModel);
    }
    return localArrayList;
  }
  
  public final ViewHolderCreator<FeedAggregatedSingleUpdateViewHolder> getCreator()
  {
    return FeedAggregatedSingleUpdateViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedSingleUpdateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */