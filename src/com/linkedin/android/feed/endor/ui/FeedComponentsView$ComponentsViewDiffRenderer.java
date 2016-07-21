package com.linkedin.android.feed.endor.ui;

import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.view.LayoutInflater;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.viewmodel.ViewModelDiffUtils.ViewModelDiffRenderer;
import java.lang.ref.WeakReference;
import java.util.List;

final class FeedComponentsView$ComponentsViewDiffRenderer
  implements ViewModelDiffUtils.ViewModelDiffRenderer<FeedComponentViewModel>
{
  private final WeakReference<LayoutInflater> layoutInflater;
  private final MediaCenter mediaCenter;
  private final WeakReference<FeedComponentsViewPool> viewPool;
  
  private FeedComponentsView$ComponentsViewDiffRenderer(FeedComponentsView paramFeedComponentsView, LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedComponentsViewPool paramFeedComponentsViewPool)
  {
    mediaCenter = paramMediaCenter;
    layoutInflater = new WeakReference(paramLayoutInflater);
    viewPool = new WeakReference(paramFeedComponentsViewPool);
  }
  
  public final int getCurrentItemCount()
  {
    return FeedComponentsView.access$100(this$0).size();
  }
  
  public final List<FeedComponentViewModel> getCurrentViewModels()
  {
    return FeedComponentsView.access$100(this$0);
  }
  
  public final void remove(int paramInt)
  {
    RecyclerView.RecycledViewPool localRecycledViewPool = (RecyclerView.RecycledViewPool)viewPool.get();
    if (localRecycledViewPool != null)
    {
      FeedComponentsView.access$400(this$0, paramInt, localRecycledViewPool);
      FeedComponentsView.access$100(this$0).remove(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedComponentsView.ComponentsViewDiffRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */