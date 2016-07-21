package com.linkedin.android.feed.endor.ui.component.primaryactor.layouts;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorViewHolder;
import com.linkedin.android.infra.shared.ViewUtils;

public final class FeedPropPrimaryActorLayout
  extends FeedPrimaryActorLayout
{
  public FeedPropPrimaryActorLayout(int paramInt)
  {
    super(paramInt, true, false, true, false);
  }
  
  public final void apply(FeedPrimaryActorViewHolder paramFeedPrimaryActorViewHolder)
  {
    super.apply(paramFeedPrimaryActorViewHolder);
    int i = itemView.getContext().getResources().getDimensionPixelSize(2131492991);
    ViewUtils.setMargins(actorInfoContainer, 0, i, i, i);
    setLines(actorHeadline, 2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.primaryactor.layouts.FeedPropPrimaryActorLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */