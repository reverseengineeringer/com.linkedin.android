package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class CollapsingToolbarLayout$OffsetUpdateListener
  implements AppBarLayout.OnOffsetChangedListener
{
  private CollapsingToolbarLayout$OffsetUpdateListener(CollapsingToolbarLayout paramCollapsingToolbarLayout) {}
  
  public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
  {
    boolean bool = false;
    CollapsingToolbarLayout.access$302(this$0, paramInt);
    int i;
    int k;
    label51:
    Object localObject;
    CollapsingToolbarLayout.LayoutParams localLayoutParams;
    ViewOffsetHelper localViewOffsetHelper;
    if (CollapsingToolbarLayout.access$400(this$0) != null)
    {
      i = CollapsingToolbarLayout.access$400(this$0).getSystemWindowInsetTop();
      k = paramAppBarLayout.getTotalScrollRange();
      j = 0;
      m = this$0.getChildCount();
      if (j >= m) {
        break label177;
      }
      localObject = this$0.getChildAt(j);
      localLayoutParams = (CollapsingToolbarLayout.LayoutParams)((View)localObject).getLayoutParams();
      localViewOffsetHelper = CollapsingToolbarLayout.access$500((View)localObject);
      switch (mCollapseMode)
      {
      }
    }
    for (;;)
    {
      j += 1;
      break label51;
      i = 0;
      break;
      if (this$0.getHeight() - i + paramInt >= ((View)localObject).getHeight())
      {
        localViewOffsetHelper.setTopAndBottomOffset(-paramInt);
        continue;
        localViewOffsetHelper.setTopAndBottomOffset(Math.round(-paramInt * mParallaxMult));
      }
    }
    label177:
    if ((CollapsingToolbarLayout.access$600(this$0) != null) || (CollapsingToolbarLayout.access$700(this$0) != null))
    {
      localObject = this$0;
      if (this$0.getHeight() + paramInt < this$0.getScrimTriggerOffset() + i) {
        bool = true;
      }
      ((CollapsingToolbarLayout)localObject).setScrimsShown(bool);
    }
    if ((CollapsingToolbarLayout.access$700(this$0) != null) && (i > 0)) {
      ViewCompat.postInvalidateOnAnimation(this$0);
    }
    int j = this$0.getHeight();
    int m = ViewCompat.getMinimumHeight(this$0);
    CollapsingToolbarLayout.access$800(this$0).setExpansionFraction(Math.abs(paramInt) / (j - m - i));
    if (Math.abs(paramInt) == k)
    {
      ViewCompat.setElevation(paramAppBarLayout, paramAppBarLayout.getTargetElevation());
      return;
    }
    ViewCompat.setElevation(paramAppBarLayout, 0.0F);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout.OffsetUpdateListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */