package com.linkedin.android.feed.endor.ui.component.header;

import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;

public final class FeedHeaderLayout
  extends FeedComponentLayout<FeedHeaderViewHolder>
{
  private final boolean showBorder;
  private final int textAppearance;
  
  public FeedHeaderLayout()
  {
    this((byte)0);
  }
  
  private FeedHeaderLayout(byte paramByte)
  {
    this(2131361796, false);
  }
  
  public FeedHeaderLayout(int paramInt, boolean paramBoolean)
  {
    textAppearance = paramInt;
    showBorder = paramBoolean;
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
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.header.FeedHeaderLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */