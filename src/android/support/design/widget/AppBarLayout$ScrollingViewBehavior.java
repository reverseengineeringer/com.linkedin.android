package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R.styleable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior
  extends HeaderScrollingViewBehavior
{
  public AppBarLayout$ScrollingViewBehavior() {}
  
  public AppBarLayout$ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrollingViewBehavior_Params);
    setOverlayTop(paramContext.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
    paramContext.recycle();
  }
  
  private static int getAppBarLayoutOffset(AppBarLayout paramAppBarLayout)
  {
    paramAppBarLayout = ((CoordinatorLayout.LayoutParams)paramAppBarLayout.getLayoutParams()).getBehavior();
    if ((paramAppBarLayout instanceof AppBarLayout.Behavior)) {
      return ((AppBarLayout.Behavior)paramAppBarLayout).getTopBottomOffsetForScrollingSibling();
    }
    return 0;
  }
  
  private void offsetChildAsNeeded(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = ((CoordinatorLayout.LayoutParams)paramView2.getLayoutParams()).getBehavior();
    if ((paramCoordinatorLayout instanceof AppBarLayout.Behavior))
    {
      paramCoordinatorLayout = (AppBarLayout.Behavior)paramCoordinatorLayout;
      paramCoordinatorLayout.getTopBottomOffsetForScrollingSibling();
      ViewCompat.offsetTopAndBottom(paramView1, paramView2.getBottom() - paramView1.getTop() + AppBarLayout.Behavior.access$1000(paramCoordinatorLayout) + getVerticalLayoutGap() - getOverlapPixelsForOffset(paramView2));
    }
  }
  
  View findFirstDependency(List<View> paramList)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      View localView = (View)paramList.get(i);
      if ((localView instanceof AppBarLayout)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  float getOverlapRatioForOffset(View paramView)
  {
    int j;
    int k;
    int i;
    if ((paramView instanceof AppBarLayout))
    {
      paramView = (AppBarLayout)paramView;
      j = paramView.getTotalScrollRange();
      k = AppBarLayout.access$200(paramView);
      i = getAppBarLayoutOffset(paramView);
      if ((k == 0) || (j + i > k)) {
        break label43;
      }
    }
    label43:
    do
    {
      return 0.0F;
      j -= k;
    } while (j == 0);
    return 1.0F + i / j;
  }
  
  int getScrollRange(View paramView)
  {
    if ((paramView instanceof AppBarLayout)) {
      return ((AppBarLayout)paramView).getTotalScrollRange();
    }
    return super.getScrollRange(paramView);
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof AppBarLayout;
  }
  
  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    offsetChildAsNeeded(paramCoordinatorLayout, paramView1, paramView2);
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.AppBarLayout.ScrollingViewBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */