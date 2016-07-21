package com.linkedin.android.feed.endor.ui.component;

public final class FeedComponentLayout$BordersWithMergeDividers
  extends FeedComponentLayout.Borders
{
  public FeedComponentLayout$BordersWithMergeDividers(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final FeedComponentLayout.Borders mergeAbove$6a24a921()
  {
    return new BordersWithMergeDividers(left, right, top, FeedComponentLayout.getBorderSize(bottom));
  }
  
  public final FeedComponentLayout.Borders mergeBelow(FeedComponentLayout.Borders paramBorders)
  {
    if ((paramBorders instanceof BordersWithMergeDividers)) {}
    for (int i = 0;; i = FeedComponentLayout.getBorderSize(top)) {
      return new BordersWithMergeDividers(left, right, i, bottom);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.BordersWithMergeDividers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */