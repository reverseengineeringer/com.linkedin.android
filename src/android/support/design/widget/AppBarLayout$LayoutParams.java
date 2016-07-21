package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R.styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AppBarLayout$LayoutParams
  extends LinearLayout.LayoutParams
{
  static final int FLAG_QUICK_RETURN = 5;
  static final int FLAG_SNAP = 17;
  public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
  public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
  public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
  public static final int SCROLL_FLAG_SCROLL = 1;
  public static final int SCROLL_FLAG_SNAP = 16;
  int mScrollFlags = 1;
  Interpolator mScrollInterpolator;
  
  public AppBarLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public AppBarLayout$LayoutParams(int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramInt1, paramInt2, paramFloat);
  }
  
  public AppBarLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppBarLayout_LayoutParams);
    mScrollFlags = paramAttributeSet.getInt(R.styleable.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
    if (paramAttributeSet.hasValue(R.styleable.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
      mScrollInterpolator = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(R.styleable.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
    }
    paramAttributeSet.recycle();
  }
  
  public AppBarLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    mScrollFlags = mScrollFlags;
    mScrollInterpolator = mScrollInterpolator;
  }
  
  public AppBarLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public AppBarLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public AppBarLayout$LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public int getScrollFlags()
  {
    return mScrollFlags;
  }
  
  public Interpolator getScrollInterpolator()
  {
    return mScrollInterpolator;
  }
  
  public void setScrollFlags(int paramInt)
  {
    mScrollFlags = paramInt;
  }
  
  public void setScrollInterpolator(Interpolator paramInterpolator)
  {
    mScrollInterpolator = paramInterpolator;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScrollFlags {}
}

/* Location:
 * Qualified Name:     android.support.design.widget.AppBarLayout.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */