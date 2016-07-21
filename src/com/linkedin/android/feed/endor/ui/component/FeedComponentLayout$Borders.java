package com.linkedin.android.feed.endor.ui.component;

public class FeedComponentLayout$Borders
{
  public final int bottom;
  private int cachedHashCode;
  public final int left;
  public final int right;
  public final int top;
  
  public FeedComponentLayout$Borders(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    left = paramInt1;
    right = paramInt2;
    top = paramInt3;
    bottom = paramInt4;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!getClass().equals(paramObject.getClass()))) {}
    do
    {
      return false;
      paramObject = (Borders)paramObject;
    } while ((this != paramObject) && ((left != left) || (right != right) || (top != top) || (bottom != bottom)));
    return true;
  }
  
  public int hashCode()
  {
    if (cachedHashCode > 0) {
      return cachedHashCode;
    }
    int i = (((left + 527) * 31 + right) * 31 + top) * 31 + bottom;
    cachedHashCode = i;
    return i;
  }
  
  protected Borders mergeAbove$6a24a921()
  {
    return new Borders(left, right, top, 0);
  }
  
  protected Borders mergeBelow(Borders paramBorders)
  {
    return new Borders(left, right, 0, bottom);
  }
  
  public final Borders mergeWith(Borders paramBorders1, Borders paramBorders2)
  {
    Borders localBorders2 = this;
    Borders localBorders1 = localBorders2;
    if (paramBorders1 != null)
    {
      localBorders1 = localBorders2;
      if (paramBorders1.mergesWith(this)) {
        localBorders1 = localBorders2.mergeBelow(paramBorders1);
      }
    }
    paramBorders1 = localBorders1;
    if (paramBorders2 != null)
    {
      paramBorders1 = localBorders1;
      if (paramBorders2.mergesWith(this)) {
        paramBorders1 = localBorders1.mergeAbove$6a24a921();
      }
    }
    return paramBorders1;
  }
  
  protected boolean mergesWith(Borders paramBorders)
  {
    return (paramBorders == FeedComponentLayout.MERGE_BORDERS) || ((left == left) && (right == right) && (top == top) && (bottom == bottom));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */