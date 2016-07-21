package android.support.v7.widget;

import android.view.View;

final class LinearLayoutManager$AnchorInfo
{
  int mCoordinate;
  boolean mLayoutFromEnd;
  int mPosition;
  
  LinearLayoutManager$AnchorInfo(LinearLayoutManager paramLinearLayoutManager) {}
  
  final void assignCoordinateFromPadding()
  {
    if (mLayoutFromEnd) {}
    for (int i = this$0.mOrientationHelper.getEndAfterPadding();; i = this$0.mOrientationHelper.getStartAfterPadding())
    {
      mCoordinate = i;
      return;
    }
  }
  
  public final void assignFromView(View paramView)
  {
    if (mLayoutFromEnd) {}
    for (mCoordinate = (this$0.mOrientationHelper.getDecoratedEnd(paramView) + this$0.mOrientationHelper.getTotalSpaceChange());; mCoordinate = this$0.mOrientationHelper.getDecoratedStart(paramView))
    {
      mPosition = LinearLayoutManager.getPosition(paramView);
      return;
    }
  }
  
  public final String toString()
  {
    return "AnchorInfo{mPosition=" + mPosition + ", mCoordinate=" + mCoordinate + ", mLayoutFromEnd=" + mLayoutFromEnd + '}';
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.AnchorInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */