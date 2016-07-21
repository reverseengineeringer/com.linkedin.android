package com.linkedin.android.feed.endor.ui.component.wrapper.border;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class FeedUpdateInnerBorderViewModel
  extends FeedComponentViewModel<FeedUpdateInnerBorderViewHolder, FeedUpdateInnerBorderLayout>
{
  private BaseViewHolder renderedChildViewHolder;
  public FeedComponentsViewPool viewPool;
  public FeedComponentViewModel wrappedView;
  
  public FeedUpdateInnerBorderViewModel(FeedUpdateInnerBorderLayout paramFeedUpdateInnerBorderLayout, FeedComponentsViewPool paramFeedComponentsViewPool, FeedComponentViewModel paramFeedComponentViewModel)
  {
    super(paramFeedUpdateInnerBorderLayout);
    viewPool = paramFeedComponentsViewPool;
    wrappedView = paramFeedComponentViewModel;
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedUpdateInnerBorderViewHolder paramFeedUpdateInnerBorderViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedUpdateInnerBorderViewHolder);
    ViewHolderCreator localViewHolderCreator = wrappedView.getCreator();
    renderedChildViewHolder = ((BaseViewHolder)viewPool.getRecycledView(localViewHolderCreator.getLayoutId()));
    if (renderedChildViewHolder == null)
    {
      renderedChildViewHolder = localViewHolderCreator.createViewHolder(paramLayoutInflater.inflate(localViewHolderCreator.getLayoutId(), wrapperArea, false));
      renderedChildViewHolder.mItemViewType = localViewHolderCreator.getLayoutId();
    }
    if ((renderedChildViewHolder instanceof BaseFeedViewHolder))
    {
      wrapperArea.addView(renderedChildViewHolder.itemView);
      wrappedView.onBindViewHolder(paramLayoutInflater, paramMediaCenter, (BaseFeedViewHolder)renderedChildViewHolder);
      return;
    }
    itemView.getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Tried to render a non-Feed view holder with a border"));
  }
  
  private void onRecycleViewHolder(FeedUpdateInnerBorderViewHolder paramFeedUpdateInnerBorderViewHolder)
  {
    wrapperArea.removeAllViews();
    super.onRecycleViewHolder(paramFeedUpdateInnerBorderViewHolder);
    if ((renderedChildViewHolder != null) && ((renderedChildViewHolder instanceof BaseFeedViewHolder)))
    {
      wrappedView.onRecycleViewHolder((BaseFeedViewHolder)renderedChildViewHolder);
      viewPool.putRecycledView(renderedChildViewHolder);
      renderedChildViewHolder = null;
    }
  }
  
  public final ViewHolderCreator<FeedUpdateInnerBorderViewHolder> getCreator()
  {
    return FeedUpdateInnerBorderViewHolder.CREATOR;
  }
  
  public final boolean isChangeableTo(ViewModel paramViewModel)
  {
    if (!(paramViewModel instanceof FeedUpdateInnerBorderViewModel)) {}
    FeedUpdateInnerBorderViewModel localFeedUpdateInnerBorderViewModel;
    do
    {
      return false;
      localFeedUpdateInnerBorderViewModel = (FeedUpdateInnerBorderViewModel)paramViewModel;
    } while ((!super.isChangeableTo(paramViewModel)) || (!wrappedView.isChangeableTo(wrappedView)));
    return true;
  }
  
  public final String toString()
  {
    return String.format("FeedUpdateInnerBorderViewModel [%s]\nViewPool [%s]\nWrappedView [%s]\nRenderedViewHolder [%s]", new Object[] { super.toString(), viewPool.toString(), wrappedView.toString(), Util.safeToString(renderedChildViewHolder) });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.wrapper.border.FeedUpdateInnerBorderViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */