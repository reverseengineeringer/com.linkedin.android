package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

class ViewCompat$LollipopViewCompatImpl
  extends ViewCompat.KitKatViewCompatImpl
{
  public final WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if ((paramWindowInsetsCompat instanceof WindowInsetsCompatApi21))
    {
      WindowInsets localWindowInsets = mSource;
      paramView = paramView.dispatchApplyWindowInsets(localWindowInsets);
      localObject = paramWindowInsetsCompat;
      if (paramView != localWindowInsets) {
        localObject = new WindowInsetsCompatApi21(paramView);
      }
    }
    return (WindowInsetsCompat)localObject;
  }
  
  public final ColorStateList getBackgroundTintList(View paramView)
  {
    return paramView.getBackgroundTintList();
  }
  
  public final PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    return paramView.getBackgroundTintMode();
  }
  
  public final float getElevation(View paramView)
  {
    return paramView.getElevation();
  }
  
  public final float getTranslationZ(View paramView)
  {
    return paramView.getTranslationZ();
  }
  
  public final float getZ(View paramView)
  {
    return paramView.getZ();
  }
  
  public final boolean isNestedScrollingEnabled(View paramView)
  {
    return paramView.isNestedScrollingEnabled();
  }
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    Rect localRect = ViewCompatLollipop.getEmptyTempRect();
    ViewParent localViewParent = paramView.getParent();
    int i;
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      ViewCompatHC.offsetLeftAndRight(paramView, paramInt);
      if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    Rect localRect = ViewCompatLollipop.getEmptyTempRect();
    ViewParent localViewParent = paramView.getParent();
    int i;
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      ViewCompatHC.offsetTopAndBottom(paramView, paramInt);
      if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if ((paramWindowInsetsCompat instanceof WindowInsetsCompatApi21))
    {
      WindowInsets localWindowInsets = mSource;
      paramView = paramView.onApplyWindowInsets(localWindowInsets);
      localObject = paramWindowInsetsCompat;
      if (paramView != localWindowInsets) {
        localObject = new WindowInsetsCompatApi21(paramView);
      }
    }
    return (WindowInsetsCompat)localObject;
  }
  
  public final void requestApplyInsets(View paramView)
  {
    paramView.requestApplyInsets();
  }
  
  public final void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    paramView.setBackgroundTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramColorStateList = paramView.getBackground();
      if ((paramView.getBackgroundTintList() == null) || (paramView.getBackgroundTintMode() == null)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((paramColorStateList != null) && (i != 0))
      {
        if (paramColorStateList.isStateful()) {
          paramColorStateList.setState(paramView.getDrawableState());
        }
        paramView.setBackground(paramColorStateList);
      }
      return;
    }
  }
  
  public final void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    paramView.setBackgroundTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramMode = paramView.getBackground();
      if ((paramView.getBackgroundTintList() == null) || (paramView.getBackgroundTintMode() == null)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((paramMode != null) && (i != 0))
      {
        if (paramMode.isStateful()) {
          paramMode.setState(paramView.getDrawableState());
        }
        paramView.setBackground(paramMode);
      }
      return;
    }
  }
  
  public final void setElevation(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }
  
  public final void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (paramOnApplyWindowInsetsListener == null)
    {
      paramView.setOnApplyWindowInsetsListener(null);
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new ViewCompatLollipop.1(paramOnApplyWindowInsetsListener));
  }
  
  public final void setTransitionName(View paramView, String paramString)
  {
    paramView.setTransitionName(paramString);
  }
  
  public final void stopNestedScroll(View paramView)
  {
    paramView.stopNestedScroll();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.LollipopViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */