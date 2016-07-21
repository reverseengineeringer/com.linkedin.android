package android.support.v7.widget;

import android.view.View;

final class OrientationHelper$1
  extends OrientationHelper
{
  OrientationHelper$1(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, (byte)0);
  }
  
  public final int getDecoratedEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedRight(paramView) + rightMargin;
  }
  
  public final int getDecoratedMeasurement(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedMeasuredWidth(paramView) + leftMargin + rightMargin;
  }
  
  public final int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedMeasuredHeight(paramView) + topMargin + bottomMargin;
  }
  
  public final int getDecoratedStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedLeft(paramView) - leftMargin;
  }
  
  public final int getEnd()
  {
    return mLayoutManager.mWidth;
  }
  
  public final int getEndAfterPadding()
  {
    return mLayoutManager.mWidth - mLayoutManager.getPaddingRight();
  }
  
  public final int getEndPadding()
  {
    return mLayoutManager.getPaddingRight();
  }
  
  public final int getMode()
  {
    return mLayoutManager.mWidthMode;
  }
  
  public final int getModeInOther()
  {
    return mLayoutManager.mHeightMode;
  }
  
  public final int getStartAfterPadding()
  {
    return mLayoutManager.getPaddingLeft();
  }
  
  public final int getTotalSpace()
  {
    return mLayoutManager.mWidth - mLayoutManager.getPaddingLeft() - mLayoutManager.getPaddingRight();
  }
  
  public final void offsetChildren(int paramInt)
  {
    mLayoutManager.offsetChildrenHorizontal(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.OrientationHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */