package com.linkedin.android.feed.endor.ui.update.single;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FeedSingleUpdateViewModel
  extends FeedUpdateViewModel<FeedSingleUpdateViewHolder>
{
  public List<FeedComponentViewModel> components;
  public boolean invertColors;
  public boolean isLastUpdate;
  public boolean isNested;
  
  public FeedSingleUpdateViewModel(Update paramUpdate, FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List<FeedComponentViewModel> paramList, TrackingOnClickListener paramTrackingOnClickListener)
  {
    super(paramUpdate, paramFragmentComponent.context(), paramFeedComponentsViewPool, paramFragmentComponent.sponsoredUpdateTracker(), paramFragmentComponent.lixManager());
    components = paramList;
    controlMenuClickListener = paramTrackingOnClickListener;
    invertColors = false;
  }
  
  public final List<List<FeedComponentViewModel>> getComponentSegmentsForBorders()
  {
    return Collections.singletonList(components);
  }
  
  public final List<FeedComponentViewModel> getComponents()
  {
    return components;
  }
  
  public final ViewHolderCreator<FeedSingleUpdateViewHolder> getCreator()
  {
    return FeedSingleUpdateViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$311a52fe(MediaCenter paramMediaCenter, FeedSingleUpdateViewHolder paramFeedSingleUpdateViewHolder)
  {
    Context localContext = itemView.getContext();
    Resources localResources = localContext.getResources();
    int i = localResources.getDimensionPixelSize(2131492987);
    int j = localResources.getDimensionPixelSize(2131492989);
    int m = localResources.getDimensionPixelSize(2131492991);
    int k;
    if (isNested)
    {
      k = 0;
      if (!isNested) {
        break label145;
      }
      if (!isLastUpdate) {
        break label139;
      }
      i = m;
      label69:
      if (!invertColors) {
        break label148;
      }
      j = 0;
      label79:
      ViewUtils.setMargins(itemView, j, j, k, i);
      componentsView.renderComponents(components, viewPool, paramMediaCenter);
      if (!invertColors) {
        break label165;
      }
    }
    label139:
    label145:
    label148:
    label165:
    for (i = 2131623960;; i = 2131624058)
    {
      cardView.setCardBackgroundColor(ContextCompat.getColor(localContext, i));
      return;
      k = i;
      break;
      i = j;
      break label69;
      break label69;
      if (isNested)
      {
        j = m;
        break label79;
      }
      break label79;
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
  
  public final void onViewModelChange$6bb90dbc(FeedSingleUpdateViewHolder paramFeedSingleUpdateViewHolder, LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter)
  {
    components = componentsView.renderComponentChanges(components, paramLayoutInflater, paramMediaCenter, viewPool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */