package com.linkedin.android.feed.endor.ui.component.unsupported;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class FeedUnsupportedViewModel
  extends FeedUpdateViewModel<FeedUnsupportedViewHolder>
{
  private View.OnClickListener clickListener;
  private String reason;
  
  public FeedUnsupportedViewModel(Update paramUpdate, FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, String paramString, View.OnClickListener paramOnClickListener)
  {
    super(paramUpdate, paramFragmentComponent.context(), paramFeedComponentsViewPool, paramFragmentComponent.sponsoredUpdateTracker(), paramFragmentComponent.lixManager());
    reason = paramString;
    clickListener = paramOnClickListener;
  }
  
  private static void updateViewHolder(FeedUnsupportedViewHolder paramFeedUnsupportedViewHolder)
  {
    itemView.setVisibility(8);
  }
  
  public final ViewHolderCreator<FeedUnsupportedViewHolder> getCreator()
  {
    return FeedUnsupportedViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.unsupported.FeedUnsupportedViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */