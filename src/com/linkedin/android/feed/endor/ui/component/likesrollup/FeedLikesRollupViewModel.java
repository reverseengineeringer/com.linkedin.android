package com.linkedin.android.feed.endor.ui.component.likesrollup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.shared.rollup.RollupView;
import com.linkedin.android.feed.shared.rollup.RollupViewModelUtils;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;
import java.util.List;

public final class FeedLikesRollupViewModel
  extends FeedComponentViewModel<FeedLikesRollupViewHolder, FeedLikesRollupLayout>
{
  public List<FeedComponentViewModel> likeItemViewModels;
  public TrackingOnClickListener likesRollupOnClickListener;
  public int rollupTotalCount;
  
  public FeedLikesRollupViewModel()
  {
    super(new FeedLikesRollupLayout());
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedLikesRollupViewHolder paramFeedLikesRollupViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedLikesRollupViewHolder);
    if (CollectionUtils.isEmpty(likeItemViewModels)) {
      paramFeedLikesRollupViewHolder.hide();
    }
    do
    {
      return;
      paramFeedLikesRollupViewHolder.show();
      itemView.setOnClickListener(likesRollupOnClickListener);
      if (likesRollupView.getWidth() > 0)
      {
        onWidthMeasured(paramFeedLikesRollupViewHolder);
        return;
      }
      paramLayoutInflater = likesRollupView.getViewTreeObserver();
    } while (!paramLayoutInflater.isAlive());
    paramLayoutInflater.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        FeedLikesRollupViewHolder localFeedLikesRollupViewHolder = (FeedLikesRollupViewHolder)val$holderRef.get();
        if ((localFeedLikesRollupViewHolder != null) && (likesRollupView.getMeasuredWidth() > 0))
        {
          itemView.getViewTreeObserver().removeOnPreDrawListener(this);
          onWidthMeasured(localFeedLikesRollupViewHolder);
        }
        return true;
      }
    });
  }
  
  public final ViewHolderCreator<FeedLikesRollupViewHolder> getCreator()
  {
    return FeedLikesRollupViewHolder.CREATOR;
  }
  
  final void onWidthMeasured(FeedLikesRollupViewHolder paramFeedLikesRollupViewHolder)
  {
    paramFeedLikesRollupViewHolder = likesRollupView;
    List localList = likeItemViewModels;
    int i = rollupTotalCount;
    rollupTotalCount = i;
    unellipsizedViewModels.clear();
    unellipsizedViewModels.addAll(localList);
    localList = RollupViewModelUtils.ellipsize(unellipsizedViewModels, maxNumColumns, i);
    if (adapter != null) {
      adapter.renderViewModelChanges(localList);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likesrollup.FeedLikesRollupViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */