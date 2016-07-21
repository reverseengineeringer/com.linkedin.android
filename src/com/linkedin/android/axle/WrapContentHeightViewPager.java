package com.linkedin.android.axle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.linkedin.android.infra.ui.ViewPager;

public class WrapContentHeightViewPager
  extends ViewPager
{
  public WrapContentHeightViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public WrapContentHeightViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    paramInt2 = 0;
    while (paramInt2 < getChildCount())
    {
      View localView = getChildAt(paramInt2);
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      int k = localView.getMeasuredHeight();
      int j = i;
      if (k > i) {
        j = k;
      }
      paramInt2 += 1;
      i = j;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.WrapContentHeightViewPager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */