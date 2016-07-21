package com.linkedin.android.feed.endor.ui.component.divider;

import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;

public final class FeedDividerLayout
  extends FeedComponentLayout<FeedDividerViewHolder>
{
  private int dividerLength;
  private boolean invertColors;
  private boolean showBorder;
  private int startMargin;
  
  public FeedDividerLayout()
  {
    showBorder = false;
    startMargin = 0;
    dividerLength = 0;
    invertColors = true;
  }
  
  public FeedDividerLayout(int paramInt)
  {
    showBorder = false;
    startMargin = paramInt;
    dividerLength = 0;
    invertColors = false;
  }
  
  public FeedDividerLayout(int paramInt1, int paramInt2)
  {
    showBorder = true;
    startMargin = paramInt1;
    dividerLength = paramInt2;
    invertColors = false;
  }
  
  public final FeedComponentLayout.Borders getBorders()
  {
    if (showBorder) {
      return SMALL_INNER_BORDERS;
    }
    return super.getBorders();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.divider.FeedDividerLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */