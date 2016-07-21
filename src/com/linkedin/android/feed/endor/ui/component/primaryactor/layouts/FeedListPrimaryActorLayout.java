package com.linkedin.android.feed.endor.ui.component.primaryactor.layouts;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorViewHolder;
import com.linkedin.android.infra.shared.ViewUtils;

public final class FeedListPrimaryActorLayout
  extends FeedPrimaryActorLayout
{
  boolean isLastElement;
  
  public FeedListPrimaryActorLayout(int paramInt, boolean paramBoolean)
  {
    super(paramInt, true, false, false, true);
    isLastElement = paramBoolean;
  }
  
  public final void apply(FeedPrimaryActorViewHolder paramFeedPrimaryActorViewHolder)
  {
    super.apply(paramFeedPrimaryActorViewHolder);
    Resources localResources = itemView.getContext().getResources();
    int j = localResources.getDimensionPixelSize(2131492989);
    int k = localResources.getDimensionPixelSize(2131492991);
    if (isLastElement) {}
    for (int i = j + k;; i = j)
    {
      ViewUtils.setMargins(actorInfoContainer, 0, j, k, i);
      ViewUtils.setMargins(actionButton, 0, j, 0, 0);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.primaryactor.layouts.FeedListPrimaryActorLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */