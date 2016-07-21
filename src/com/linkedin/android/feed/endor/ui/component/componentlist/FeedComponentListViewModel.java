package com.linkedin.android.feed.endor.ui.component.componentlist;

import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.tracking.NestedTrackableViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FeedComponentListViewModel
  extends FeedComponentViewModel<FeedComponentListViewHolder, FeedComponentListLayout>
{
  public List<FeedComponentViewModel> components;
  public FeedComponentsViewPool viewPool;
  
  public FeedComponentListViewModel(FeedComponentsViewPool paramFeedComponentsViewPool, List<FeedComponentViewModel> paramList)
  {
    super(new FeedComponentListLayout());
    viewPool = paramFeedComponentsViewPool;
    components = paramList;
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedComponentListViewHolder paramFeedComponentListViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedComponentListViewHolder);
    componentsView.renderComponents(components, viewPool, paramMediaCenter);
  }
  
  private void onRecycleViewHolder(FeedComponentListViewHolder paramFeedComponentListViewHolder)
  {
    componentsView.clearComponents(viewPool);
  }
  
  public final List<List<FeedComponentViewModel>> getComponentSegmentsForBorders()
  {
    return Collections.singletonList(components);
  }
  
  public final ViewHolderCreator<FeedComponentListViewHolder> getCreator()
  {
    return FeedComponentListViewHolder.CREATOR;
  }
  
  public Mapper onBindTrackableViews(Mapper paramMapper, FeedComponentListViewHolder paramFeedComponentListViewHolder, int paramInt)
  {
    Iterator localIterator = components.iterator();
    while (localIterator.hasNext())
    {
      FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)localIterator.next();
      BaseFeedViewHolder localBaseFeedViewHolder = componentsView.getViewHolder(localFeedComponentViewModel);
      if (localBaseFeedViewHolder != null) {
        localFeedComponentViewModel.onBindTrackableViews(paramMapper, localBaseFeedViewHolder, paramInt);
      }
    }
    return paramMapper;
  }
  
  public final void onEnterViewPort(int paramInt, View paramView)
  {
    super.onEnterViewPort(paramInt, paramView);
    Iterator localIterator = components.iterator();
    while (localIterator.hasNext()) {
      ((FeedComponentViewModel)localIterator.next()).onEnterViewPort(paramInt, paramView);
    }
  }
  
  public final void onLeaveViewPort(int paramInt1, int paramInt2)
  {
    super.onLeaveViewPort(paramInt1, paramInt2);
    Iterator localIterator = components.iterator();
    while (localIterator.hasNext()) {
      ((FeedComponentViewModel)localIterator.next()).onLeaveViewPort(paramInt1, paramInt2);
    }
  }
  
  public final void onRestoreUpdateViewState(ViewState paramViewState)
  {
    super.onRestoreUpdateViewState(paramViewState);
    Iterator localIterator = components.iterator();
    while (localIterator.hasNext()) {
      ((FeedComponentViewModel)localIterator.next()).onRestoreUpdateViewState(paramViewState);
    }
  }
  
  public final void onSaveUpdateViewState(ViewState paramViewState)
  {
    super.onSaveUpdateViewState(paramViewState);
    Iterator localIterator = components.iterator();
    while (localIterator.hasNext()) {
      ((FeedComponentViewModel)localIterator.next()).onSaveUpdateViewState(paramViewState);
    }
  }
  
  public TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    int i = viewId;
    Iterator localIterator = components.iterator();
    while (localIterator.hasNext())
    {
      FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)localIterator.next();
      if (((localFeedComponentViewModel instanceof NestedTrackableViewModel)) && (Util.contains(((NestedTrackableViewModel)localFeedComponentViewModel).getTrackableViewIds(), i))) {
        localFeedComponentViewModel.onTrackImpression(paramImpressionData);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */