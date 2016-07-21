package com.linkedin.android.feed.endor.ui.component.carousel;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import java.util.List;
import java.util.Set;

public final class FeedCarouselViewModel
  extends FeedComponentViewModel<FeedCarouselViewHolder, FeedCarouselLayout>
{
  final FeedCarouselAdapter adapter;
  public final List<FeedCarouselComponentViewModel> viewModels;
  private final FeedComponentsViewPool viewPool;
  
  public FeedCarouselViewModel(FragmentComponent paramFragmentComponent, FeedCarouselLayout paramFeedCarouselLayout, FeedComponentsViewPool paramFeedComponentsViewPool, List<FeedCarouselComponentViewModel> paramList)
  {
    super(paramFeedCarouselLayout);
    viewPool = paramFeedComponentsViewPool;
    viewModels = paramList;
    adapter = new FeedCarouselAdapter(paramFragmentComponent, "update_card", "update_carousel");
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedCarouselViewHolder paramFeedCarouselViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedCarouselViewHolder);
    carousel.setRecycledViewPool(viewPool);
    paramLayoutInflater = adapter;
    initiallyVisibleViewPositions.clear();
    isInInitialLayout = true;
    paramLayoutInflater = adapter;
    paramMediaCenter = carousel;
    viewPortManager.container = paramMediaCenter;
    paramMediaCenter.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
    adapter.renderViewModelChanges(viewModels);
    carousel.setAdapter(adapter);
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        adapter.isInInitialLayout = false;
      }
    });
  }
  
  private void onRecycleViewHolder(FeedCarouselViewHolder paramFeedCarouselViewHolder)
  {
    super.onRecycleViewHolder(paramFeedCarouselViewHolder);
    carousel.setRecycledViewPool(null);
  }
  
  public final ViewHolderCreator<FeedCarouselViewHolder> getCreator()
  {
    return FeedCarouselViewHolder.CREATOR;
  }
  
  public final void onEnterViewPort(int paramInt, View paramView)
  {
    super.onEnterViewPort(paramInt, paramView);
    paramView = adapter;
    verticalPos = paramInt;
    viewPortManager.trackAll(tracker);
  }
  
  public final void onLeaveViewPort(int paramInt1, int paramInt2)
  {
    super.onLeaveViewPort(paramInt1, paramInt2);
    adapter.viewPortManager.untrackAll();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */