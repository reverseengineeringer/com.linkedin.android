package com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar;

import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;

public final class FeedSocialActionsBarLayout
  extends FeedComponentLayout<FeedSocialActionsBarViewHolder>
{
  public final boolean invertColors;
  public final boolean showDivider;
  
  public FeedSocialActionsBarLayout(boolean paramBoolean1, boolean paramBoolean2)
  {
    showDivider = paramBoolean2;
    invertColors = paramBoolean1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar.FeedSocialActionsBarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */