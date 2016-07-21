package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

class ViewCompat$BaseViewCompatImpl
  implements ViewCompat.ViewCompatImpl
{
  WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;
  
  public ViewPropertyAnimatorCompat animate(View paramView)
  {
    return new ViewPropertyAnimatorCompat(paramView);
  }
  
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    if ((paramView instanceof ScrollingView))
    {
      paramView = (ScrollingView)paramView;
      int i = paramView.computeHorizontalScrollOffset();
      int j = paramView.computeHorizontalScrollRange() - paramView.computeHorizontalScrollExtent();
      if (j != 0) {
        if (paramInt < 0) {
          if (i > 0) {
            paramInt = 1;
          }
        }
      }
      while (paramInt != 0)
      {
        return true;
        paramInt = 0;
        continue;
        if (i < j - 1) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
    return false;
  }
  
  public boolean canScrollVertically(View paramView, int paramInt)
  {
    if ((paramView instanceof ScrollingView))
    {
      paramView = (ScrollingView)paramView;
      int i = paramView.computeVerticalScrollOffset();
      int j = paramView.computeVerticalScrollRange() - paramView.computeVerticalScrollExtent();
      if (j != 0) {
        if (paramInt < 0) {
          if (i > 0) {
            paramInt = 1;
          }
        }
      }
      while (paramInt != 0)
      {
        return true;
        paramInt = 0;
        continue;
        if (i < j - 1) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
    return false;
  }
  
  public int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return paramWindowInsetsCompat;
  }
  
  public float getAlpha(View paramView)
  {
    return 1.0F;
  }
  
  public ColorStateList getBackgroundTintList(View paramView)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public float getElevation(View paramView)
  {
    return 0.0F;
  }
  
  public boolean getFitsSystemWindows(View paramView)
  {
    return false;
  }
  
  long getFrameTime()
  {
    return 10L;
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return 0;
  }
  
  public int getLayerType(View paramView)
  {
    return 0;
  }
  
  public int getLayoutDirection(View paramView)
  {
    return 0;
  }
  
  public int getMeasuredState(View paramView)
  {
    return 0;
  }
  
  public int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int getMinimumHeight(View paramView)
  {
    return ViewCompatBase.getMinimumHeight(paramView);
  }
  
  public int getMinimumWidth(View paramView)
  {
    return ViewCompatBase.getMinimumWidth(paramView);
  }
  
  public int getOverScrollMode(View paramView)
  {
    return 2;
  }
  
  public int getPaddingEnd(View paramView)
  {
    return paramView.getPaddingRight();
  }
  
  public int getPaddingStart(View paramView)
  {
    return paramView.getPaddingLeft();
  }
  
  public ViewParent getParentForAccessibility(View paramView)
  {
    return paramView.getParent();
  }
  
  public float getScaleX(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationX(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationY(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationZ(View paramView)
  {
    return 0.0F;
  }
  
  public int getWindowSystemUiVisibility(View paramView)
  {
    return 0;
  }
  
  public float getZ(View paramView)
  {
    return getTranslationZ(paramView) + getElevation(paramView);
  }
  
  public boolean hasAccessibilityDelegate(View paramView)
  {
    return false;
  }
  
  public boolean hasOnClickListeners(View paramView)
  {
    return false;
  }
  
  public boolean hasOverlappingRendering(View paramView)
  {
    return true;
  }
  
  public boolean hasTransientState(View paramView)
  {
    return false;
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return paramView.getWindowToken() != null;
  }
  
  public boolean isLaidOut(View paramView)
  {
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public boolean isNestedScrollingEnabled(View paramView)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public boolean isPaddingRelative(View paramView)
  {
    return false;
  }
  
  public void jumpDrawablesToCurrentState(View paramView) {}
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    int i = paramView.getLeft();
    paramView.offsetLeftAndRight(paramInt);
    if (paramInt != 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        paramInt = Math.abs(paramInt);
        ((View)localViewParent).invalidate(i - paramInt, paramView.getTop(), i + paramView.getWidth() + paramInt, paramView.getBottom());
      }
    }
    else
    {
      return;
    }
    paramView.invalidate();
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    int i = paramView.getTop();
    paramView.offsetTopAndBottom(paramInt);
    if (paramInt != 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        paramInt = Math.abs(paramInt);
        ((View)localViewParent).invalidate(paramView.getLeft(), i - paramInt, paramView.getRight(), i + paramView.getHeight() + paramInt);
      }
    }
    else
    {
      return;
    }
    paramView.invalidate();
  }
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return paramWindowInsetsCompat;
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    paramView.invalidate();
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, getFrameTime());
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postDelayed(paramRunnable, getFrameTime() + paramLong);
  }
  
  public void requestApplyInsets(View paramView) {}
  
  public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSize(paramInt1, paramInt2);
  }
  
  public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
  
  public void setAccessibilityLiveRegion$5359dc9a(View paramView) {}
  
  public void setActivated(View paramView, boolean paramBoolean) {}
  
  public void setAlpha(View paramView, float paramFloat) {}
  
  public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setChildrenDrawingOrderEnabled$4d3af60(ViewGroup paramViewGroup) {}
  
  public void setElevation(View paramView, float paramFloat) {}
  
  public void setFitsSystemWindows(View paramView, boolean paramBoolean) {}
  
  public void setImportantForAccessibility(View paramView, int paramInt) {}
  
  public void setLayerType(View paramView, int paramInt, Paint paramPaint) {}
  
  public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  public void setOverScrollMode(View paramView, int paramInt) {}
  
  public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setSaveFromParentEnabled$53599cc9(View paramView) {}
  
  public void setScaleX(View paramView, float paramFloat) {}
  
  public void setScaleY(View paramView, float paramFloat) {}
  
  public void setScrollIndicators$17e143a3(View paramView, int paramInt) {}
  
  public void setTransitionName(View paramView, String paramString) {}
  
  public void setTranslationX(View paramView, float paramFloat) {}
  
  public void setTranslationY(View paramView, float paramFloat) {}
  
  public void stopNestedScroll(View paramView)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      ((NestedScrollingChild)paramView).stopNestedScroll();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.BaseViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */