package android.support.design.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.util.AttributeSet;
import android.view.View;

public class EfficientCoordinatorLayout
  extends CoordinatorLayout
  implements NestedScrollingChild
{
  private final int[] mParentScrollConsumed = new int[2];
  private final NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
  
  public EfficientCoordinatorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EfficientCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EfficientCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @SuppressLint({"NewApi"})
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return nestedScrollingChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  @SuppressLint({"NewApi"})
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return nestedScrollingChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  @SuppressLint({"NewApi"})
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return nestedScrollingChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  @SuppressLint({"NewApi"})
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return nestedScrollingChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean hasNestedScrollingParent()
  {
    return nestedScrollingChildHelper.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return nestedScrollingChildHelper.mIsNestedScrollingEnabled;
  }
  
  void offsetChildToAnchor(View paramView, int paramInt)
  {
    if (paramView.getVisibility() != 8) {
      super.offsetChildToAnchor(paramView, paramInt);
    }
  }
  
  @SuppressLint({"NewApi"})
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    return paramBoolean;
  }
  
  @SuppressLint({"NewApi"})
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    dispatchNestedPreFling(paramFloat1, paramFloat2);
    return super.onNestedPreFling(paramView, paramFloat1, paramFloat2);
  }
  
  @SuppressLint({"NewApi"})
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    super.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    paramView = mParentScrollConsumed;
    if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
    {
      paramArrayOfInt[0] += paramView[0];
      paramArrayOfInt[1] += paramView[1];
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  @SuppressLint({"NewApi"})
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    startNestedScroll(paramInt);
    return super.onStartNestedScroll(paramView1, paramView2, paramInt);
  }
  
  @SuppressLint({"NewApi"})
  public void onStopNestedScroll(View paramView)
  {
    stopNestedScroll();
    super.onStopNestedScroll(paramView);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    nestedScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setShouldConsumeAndForwardScrollEvents(boolean paramBoolean)
  {
    nestedScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return nestedScrollingChildHelper.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    nestedScrollingChildHelper.stopNestedScroll();
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.EfficientCoordinatorLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */