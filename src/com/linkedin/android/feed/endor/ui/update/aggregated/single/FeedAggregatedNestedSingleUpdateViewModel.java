package com.linkedin.android.feed.endor.ui.update.aggregated.single;

import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.view.LayoutInflater;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewHolder;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.network.MediaCenter;
import java.util.Collections;
import java.util.List;

public final class FeedAggregatedNestedSingleUpdateViewModel
  extends FeedComponentViewModel<FeedSingleUpdateViewHolder, FeedComponentLayout<FeedSingleUpdateViewHolder>>
{
  protected final RecyclerView.RecycledViewPool viewPool;
  public final FeedSingleUpdateViewModel wrappedUpdate;
  
  public FeedAggregatedNestedSingleUpdateViewModel(FeedSingleUpdateViewModel paramFeedSingleUpdateViewModel, RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    super(new FeedComponentLayout());
    wrappedUpdate = paramFeedSingleUpdateViewModel;
    viewPool = paramRecycledViewPool;
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedSingleUpdateViewHolder paramFeedSingleUpdateViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedSingleUpdateViewHolder);
    wrappedUpdate.onBindViewHolder$311a52fe(paramMediaCenter, paramFeedSingleUpdateViewHolder);
  }
  
  private void onRecycleViewHolder(FeedSingleUpdateViewHolder paramFeedSingleUpdateViewHolder)
  {
    componentsView.clearComponents(viewPool);
  }
  
  public final List<List<FeedComponentViewModel>> getComponentSegmentsForBorders()
  {
    return Collections.singletonList(wrappedUpdate.components);
  }
  
  public final ViewHolderCreator<FeedSingleUpdateViewHolder> getCreator()
  {
    return FeedSingleUpdateViewHolder.CREATOR;
  }
  
  public final void onRestoreUpdateViewState(ViewState paramViewState)
  {
    super.onRestoreUpdateViewState(paramViewState);
    wrappedUpdate.onRestoreUpdateViewState(paramViewState);
  }
  
  public final void onSaveUpdateViewState(ViewState paramViewState)
  {
    super.onSaveUpdateViewState(paramViewState);
    wrappedUpdate.onSaveUpdateViewState(paramViewState);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedNestedSingleUpdateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */