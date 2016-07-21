package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R.styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout$LayoutParams
  extends FrameLayout.LayoutParams
{
  public static final int COLLAPSE_MODE_OFF = 0;
  public static final int COLLAPSE_MODE_PARALLAX = 2;
  public static final int COLLAPSE_MODE_PIN = 1;
  private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5F;
  int mCollapseMode = 0;
  float mParallaxMult = 0.5F;
  
  public CollapsingToolbarLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public CollapsingToolbarLayout$LayoutParams(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public CollapsingToolbarLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CollapsingAppBarLayout_LayoutParams);
    mCollapseMode = paramContext.getInt(R.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
    setParallaxMultiplier(paramContext.getFloat(R.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseParallaxMultiplier, 0.5F));
    paramContext.recycle();
  }
  
  public CollapsingToolbarLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public CollapsingToolbarLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public CollapsingToolbarLayout$LayoutParams(FrameLayout.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public int getCollapseMode()
  {
    return mCollapseMode;
  }
  
  public float getParallaxMultiplier()
  {
    return mParallaxMult;
  }
  
  public void setCollapseMode(int paramInt)
  {
    mCollapseMode = paramInt;
  }
  
  public void setParallaxMultiplier(float paramFloat)
  {
    mParallaxMult = paramFloat;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */