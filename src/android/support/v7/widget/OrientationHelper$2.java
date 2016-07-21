package android.support.v7.widget;

import android.view.View;

final class OrientationHelper$2
  extends OrientationHelper
{
  OrientationHelper$2(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, (byte)0);
  }
  
  public final int getDecoratedEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedBottom(paramView) + bottomMargin;
  }
  
  public final int getDecoratedMeasurement(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedMeasuredHeight(paramView) + topMargin + bottomMargin;
  }
  
  public final int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedMeasuredWidth(paramView) + leftMargin + rightMargin;
  }
  
  public final int getDecoratedStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return mLayoutManager.getDecoratedTop(paramView) - topMargin;
  }
  
  public final int getEnd()
  {
    return mLayoutManager.mHeight;
  }
  
  public final int getEndAfterPadding()
  {
    return mLayoutManager.mHeight - mLayoutManager.getPaddingBottom();
  }
  
  public final int getEndPadding()
  {
    return mLayoutManager.getPaddingBottom();
  }
  
  public final int getMode()
  {
    return mLayoutManager.mHeightMode;
  }
  
  public final int getModeInOther()
  {
    return mLayoutManager.mWidthMode;
  }
  
  public final int getStartAfterPadding()
  {
    return mLayoutManager.getPaddingTop();
  }
  
  public final int getTotalSpace()
  {
    return mLayoutManager.mHeight - mLayoutManager.getPaddingTop() - mLayoutManager.getPaddingBottom();
  }
  
  public final void offsetChildren(int paramInt)
  {
    mLayoutManager.offsetChildrenVertical(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.OrientationHelper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */