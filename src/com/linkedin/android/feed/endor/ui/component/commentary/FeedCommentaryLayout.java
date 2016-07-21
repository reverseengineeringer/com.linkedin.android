package com.linkedin.android.feed.endor.ui.component.commentary;

import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;

public final class FeedCommentaryLayout
  extends FeedComponentLayout<FeedCommentaryViewHolder>
{
  boolean invertColors;
  int linesBeforeTruncation;
  boolean showInnerBorders;
  
  public FeedCommentaryLayout(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    showInnerBorders = paramBoolean1;
    invertColors = paramBoolean2;
    linesBeforeTruncation = paramInt;
  }
  
  public final FeedComponentLayout.Borders getBorders()
  {
    if (showInnerBorders) {
      return SMALL_INNER_BORDERS_WITH_DIVIDERS;
    }
    return super.getBorders();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentary.FeedCommentaryLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */