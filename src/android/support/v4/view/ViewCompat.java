package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public final class ViewCompat
{
  static final ViewCompatImpl IMPL = new BaseViewCompatImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      IMPL = new MarshmallowViewCompatImpl();
      return;
    }
    if (i >= 21)
    {
      IMPL = new LollipopViewCompatImpl();
      return;
    }
    if (i >= 19)
    {
      IMPL = new KitKatViewCompatImpl();
      return;
    }
    if (i >= 17)
    {
      IMPL = new JbMr1ViewCompatImpl();
      return;
    }
    if (i >= 16)
    {
      IMPL = new JBViewCompatImpl();
      return;
    }
    if (i >= 15)
    {
      IMPL = new ICSMr1ViewCompatImpl();
      return;
    }
    if (i >= 14)
    {
      IMPL = new ICSViewCompatImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new HCViewCompatImpl();
      return;
    }
    if (i >= 9)
    {
      IMPL = new GBViewCompatImpl();
      return;
    }
    if (i >= 7)
    {
      IMPL = new EclairMr1ViewCompatImpl();
      return;
    }
  }
  
  public static ViewPropertyAnimatorCompat animate(View paramView)
  {
    return IMPL.animate(paramView);
  }
  
  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return IMPL.canScrollHorizontally(paramView, paramInt);
  }
  
  public static boolean canScrollVertically(View paramView, int paramInt)
  {
    return IMPL.canScrollVertically(paramView, paramInt);
  }
  
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return IMPL.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public static WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return IMPL.dispatchApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public static float getAlpha(View paramView)
  {
    return IMPL.getAlpha(paramView);
  }
  
  public static ColorStateList getBackgroundTintList(View paramView)
  {
    return IMPL.getBackgroundTintList(paramView);
  }
  
  public static PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    return IMPL.getBackgroundTintMode(paramView);
  }
  
  public static float getElevation(View paramView)
  {
    return IMPL.getElevation(paramView);
  }
  
  public static boolean getFitsSystemWindows(View paramView)
  {
    return IMPL.getFitsSystemWindows(paramView);
  }
  
  public static int getImportantForAccessibility(View paramView)
  {
    return IMPL.getImportantForAccessibility(paramView);
  }
  
  public static int getLayerType(View paramView)
  {
    return IMPL.getLayerType(paramView);
  }
  
  public static int getLayoutDirection(View paramView)
  {
    return IMPL.getLayoutDirection(paramView);
  }
  
  public static int getMeasuredState(View paramView)
  {
    return IMPL.getMeasuredState(paramView);
  }
  
  public static int getMeasuredWidthAndState(View paramView)
  {
    return IMPL.getMeasuredWidthAndState(paramView);
  }
  
  public static int getMinimumHeight(View paramView)
  {
    return IMPL.getMinimumHeight(paramView);
  }
  
  public static int getMinimumWidth(View paramView)
  {
    return IMPL.getMinimumWidth(paramView);
  }
  
  public static int getOverScrollMode(View paramView)
  {
    return IMPL.getOverScrollMode(paramView);
  }
  
  public static int getPaddingEnd(View paramView)
  {
    return IMPL.getPaddingEnd(paramView);
  }
  
  public static int getPaddingStart(View paramView)
  {
    return IMPL.getPaddingStart(paramView);
  }
  
  public static ViewParent getParentForAccessibility(View paramView)
  {
    return IMPL.getParentForAccessibility(paramView);
  }
  
  public static float getScaleX(View paramView)
  {
    return IMPL.getScaleX(paramView);
  }
  
  public static float getTranslationX(View paramView)
  {
    return IMPL.getTranslationX(paramView);
  }
  
  public static float getTranslationY(View paramView)
  {
    return IMPL.getTranslationY(paramView);
  }
  
  public static int getWindowSystemUiVisibility(View paramView)
  {
    return IMPL.getWindowSystemUiVisibility(paramView);
  }
  
  public static float getZ(View paramView)
  {
    return IMPL.getZ(paramView);
  }
  
  public static boolean hasAccessibilityDelegate(View paramView)
  {
    return IMPL.hasAccessibilityDelegate(paramView);
  }
  
  public static boolean hasOnClickListeners(View paramView)
  {
    return IMPL.hasOnClickListeners(paramView);
  }
  
  public static boolean hasOverlappingRendering(View paramView)
  {
    return IMPL.hasOverlappingRendering(paramView);
  }
  
  public static boolean hasTransientState(View paramView)
  {
    return IMPL.hasTransientState(paramView);
  }
  
  public static boolean isAttachedToWindow(View paramView)
  {
    return IMPL.isAttachedToWindow(paramView);
  }
  
  public static boolean isLaidOut(View paramView)
  {
    return IMPL.isLaidOut(paramView);
  }
  
  public static boolean isNestedScrollingEnabled(View paramView)
  {
    return IMPL.isNestedScrollingEnabled(paramView);
  }
  
  public static boolean isPaddingRelative(View paramView)
  {
    return IMPL.isPaddingRelative(paramView);
  }
  
  public static void jumpDrawablesToCurrentState(View paramView)
  {
    IMPL.jumpDrawablesToCurrentState(paramView);
  }
  
  public static void offsetLeftAndRight(View paramView, int paramInt)
  {
    IMPL.offsetLeftAndRight(paramView, paramInt);
  }
  
  public static void offsetTopAndBottom(View paramView, int paramInt)
  {
    IMPL.offsetTopAndBottom(paramView, paramInt);
  }
  
  public static WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return IMPL.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public static void postInvalidateOnAnimation(View paramView)
  {
    IMPL.postInvalidateOnAnimation(paramView);
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    IMPL.postOnAnimation(paramView, paramRunnable);
  }
  
  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    IMPL.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
  }
  
  public static void requestApplyInsets(View paramView)
  {
    IMPL.requestApplyInsets(paramView);
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return IMPL.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    IMPL.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat);
  }
  
  public static void setAccessibilityLiveRegion$5359dc9a(View paramView)
  {
    IMPL.setAccessibilityLiveRegion$5359dc9a(paramView);
  }
  
  public static void setActivated(View paramView, boolean paramBoolean)
  {
    IMPL.setActivated(paramView, paramBoolean);
  }
  
  public static void setAlpha(View paramView, float paramFloat)
  {
    IMPL.setAlpha(paramView, paramFloat);
  }
  
  public static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    IMPL.setBackgroundTintList(paramView, paramColorStateList);
  }
  
  public static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    IMPL.setBackgroundTintMode(paramView, paramMode);
  }
  
  public static void setChildrenDrawingOrderEnabled$4d3af60(ViewGroup paramViewGroup)
  {
    IMPL.setChildrenDrawingOrderEnabled$4d3af60(paramViewGroup);
  }
  
  public static void setElevation(View paramView, float paramFloat)
  {
    IMPL.setElevation(paramView, paramFloat);
  }
  
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    IMPL.setFitsSystemWindows(paramView, paramBoolean);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    IMPL.setImportantForAccessibility(paramView, paramInt);
  }
  
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    IMPL.setLayerType(paramView, paramInt, paramPaint);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    IMPL.setOnApplyWindowInsetsListener(paramView, paramOnApplyWindowInsetsListener);
  }
  
  public static void setOverScrollMode(View paramView, int paramInt)
  {
    IMPL.setOverScrollMode(paramView, paramInt);
  }
  
  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setPaddingRelative(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setSaveFromParentEnabled$53599cc9(View paramView)
  {
    IMPL.setSaveFromParentEnabled$53599cc9(paramView);
  }
  
  public static void setScaleX(View paramView, float paramFloat)
  {
    IMPL.setScaleX(paramView, paramFloat);
  }
  
  public static void setScaleY(View paramView, float paramFloat)
  {
    IMPL.setScaleY(paramView, paramFloat);
  }
  
  public static void setScrollIndicators$17e143a3(View paramView, int paramInt)
  {
    IMPL.setScrollIndicators$17e143a3(paramView, paramInt);
  }
  
  public static void setTransitionName(View paramView, String paramString)
  {
    IMPL.setTransitionName(paramView, paramString);
  }
  
  public static void setTranslationX(View paramView, float paramFloat)
  {
    IMPL.setTranslationX(paramView, paramFloat);
  }
  
  public static void setTranslationY(View paramView, float paramFloat)
  {
    IMPL.setTranslationY(paramView, paramFloat);
  }
  
  public static void stopNestedScroll(View paramView)
  {
    IMPL.stopNestedScroll(paramView);
  }
  
  static class BaseViewCompatImpl
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
  
  static class EclairMr1ViewCompatImpl
    extends ViewCompat.BaseViewCompatImpl
  {
    public final void setChildrenDrawingOrderEnabled$4d3af60(ViewGroup paramViewGroup)
    {
      if (ViewCompatEclairMr1.sChildrenDrawingOrderMethod == null) {}
      try
      {
        ViewCompatEclairMr1.sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
        ViewCompatEclairMr1.sChildrenDrawingOrderMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          try
          {
            ViewCompatEclairMr1.sChildrenDrawingOrderMethod.invoke(paramViewGroup, new Object[] { Boolean.valueOf(true) });
            return;
          }
          catch (IllegalAccessException paramViewGroup)
          {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
            return;
          }
          catch (IllegalArgumentException paramViewGroup)
          {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
            return;
          }
          catch (InvocationTargetException paramViewGroup)
          {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
          }
          localNoSuchMethodException = localNoSuchMethodException;
          Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", localNoSuchMethodException);
        }
      }
    }
  }
  
  static class GBViewCompatImpl
    extends ViewCompat.EclairMr1ViewCompatImpl
  {
    public final int getOverScrollMode(View paramView)
    {
      return paramView.getOverScrollMode();
    }
    
    public final void setOverScrollMode(View paramView, int paramInt)
    {
      paramView.setOverScrollMode(paramInt);
    }
  }
  
  static class HCViewCompatImpl
    extends ViewCompat.GBViewCompatImpl
  {
    public final int combineMeasuredStates(int paramInt1, int paramInt2)
    {
      return View.combineMeasuredStates(paramInt1, paramInt2);
    }
    
    public final float getAlpha(View paramView)
    {
      return paramView.getAlpha();
    }
    
    final long getFrameTime()
    {
      return ValueAnimator.getFrameDelay();
    }
    
    public final int getLayerType(View paramView)
    {
      return paramView.getLayerType();
    }
    
    public final int getMeasuredState(View paramView)
    {
      return paramView.getMeasuredState();
    }
    
    public final int getMeasuredWidthAndState(View paramView)
    {
      return paramView.getMeasuredWidthAndState();
    }
    
    public final float getScaleX(View paramView)
    {
      return paramView.getScaleX();
    }
    
    public final float getTranslationX(View paramView)
    {
      return paramView.getTranslationX();
    }
    
    public final float getTranslationY(View paramView)
    {
      return paramView.getTranslationY();
    }
    
    public final void jumpDrawablesToCurrentState(View paramView)
    {
      paramView.jumpDrawablesToCurrentState();
    }
    
    public void offsetLeftAndRight(View paramView, int paramInt)
    {
      ViewCompatHC.offsetLeftAndRight(paramView, paramInt);
    }
    
    public void offsetTopAndBottom(View paramView, int paramInt)
    {
      ViewCompatHC.offsetTopAndBottom(paramView, paramInt);
    }
    
    public final int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
    {
      return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
    }
    
    public final void setActivated(View paramView, boolean paramBoolean)
    {
      paramView.setActivated(paramBoolean);
    }
    
    public final void setAlpha(View paramView, float paramFloat)
    {
      paramView.setAlpha(paramFloat);
    }
    
    public final void setLayerType(View paramView, int paramInt, Paint paramPaint)
    {
      paramView.setLayerType(paramInt, paramPaint);
    }
    
    public final void setSaveFromParentEnabled$53599cc9(View paramView)
    {
      paramView.setSaveFromParentEnabled(false);
    }
    
    public final void setScaleX(View paramView, float paramFloat)
    {
      paramView.setScaleX(paramFloat);
    }
    
    public final void setScaleY(View paramView, float paramFloat)
    {
      paramView.setScaleY(paramFloat);
    }
    
    public final void setTranslationX(View paramView, float paramFloat)
    {
      paramView.setTranslationX(paramFloat);
    }
    
    public final void setTranslationY(View paramView, float paramFloat)
    {
      paramView.setTranslationY(paramFloat);
    }
  }
  
  static class ICSMr1ViewCompatImpl
    extends ViewCompat.ICSViewCompatImpl
  {
    public final boolean hasOnClickListeners(View paramView)
    {
      return paramView.hasOnClickListeners();
    }
  }
  
  static class ICSViewCompatImpl
    extends ViewCompat.HCViewCompatImpl
  {
    static boolean accessibilityDelegateCheckFailed = false;
    static Field mAccessibilityDelegateField;
    
    public final ViewPropertyAnimatorCompat animate(View paramView)
    {
      if (mViewPropertyAnimatorCompatMap == null) {
        mViewPropertyAnimatorCompatMap = new WeakHashMap();
      }
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = (ViewPropertyAnimatorCompat)mViewPropertyAnimatorCompatMap.get(paramView);
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = localViewPropertyAnimatorCompat2;
      if (localViewPropertyAnimatorCompat2 == null)
      {
        localViewPropertyAnimatorCompat1 = new ViewPropertyAnimatorCompat(paramView);
        mViewPropertyAnimatorCompatMap.put(paramView, localViewPropertyAnimatorCompat1);
      }
      return localViewPropertyAnimatorCompat1;
    }
    
    public final boolean canScrollHorizontally(View paramView, int paramInt)
    {
      return paramView.canScrollHorizontally(paramInt);
    }
    
    public final boolean canScrollVertically(View paramView, int paramInt)
    {
      return paramView.canScrollVertically(paramInt);
    }
    
    public final boolean hasAccessibilityDelegate(View paramView)
    {
      if (accessibilityDelegateCheckFailed) {}
      for (;;)
      {
        return false;
        if (mAccessibilityDelegateField == null) {}
        try
        {
          Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
          mAccessibilityDelegateField = localField;
          localField.setAccessible(true);
        }
        catch (Throwable paramView)
        {
          try
          {
            paramView = mAccessibilityDelegateField.get(paramView);
            if (paramView == null) {
              continue;
            }
            return true;
          }
          catch (Throwable paramView)
          {
            accessibilityDelegateCheckFailed = true;
          }
          paramView = paramView;
          accessibilityDelegateCheckFailed = true;
          return false;
        }
      }
      return false;
    }
    
    public final void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
    {
      if (paramAccessibilityDelegateCompat == null) {}
      for (paramAccessibilityDelegateCompat = null;; paramAccessibilityDelegateCompat = paramAccessibilityDelegateCompat.getBridge())
      {
        paramView.setAccessibilityDelegate((View.AccessibilityDelegate)paramAccessibilityDelegateCompat);
        return;
      }
    }
    
    public final void setFitsSystemWindows(View paramView, boolean paramBoolean)
    {
      paramView.setFitsSystemWindows(paramBoolean);
    }
  }
  
  static class JBViewCompatImpl
    extends ViewCompat.ICSMr1ViewCompatImpl
  {
    public final boolean getFitsSystemWindows(View paramView)
    {
      return paramView.getFitsSystemWindows();
    }
    
    public final int getImportantForAccessibility(View paramView)
    {
      return paramView.getImportantForAccessibility();
    }
    
    public final int getMinimumHeight(View paramView)
    {
      return paramView.getMinimumHeight();
    }
    
    public final int getMinimumWidth(View paramView)
    {
      return paramView.getMinimumWidth();
    }
    
    public final ViewParent getParentForAccessibility(View paramView)
    {
      return paramView.getParentForAccessibility();
    }
    
    public final boolean hasOverlappingRendering(View paramView)
    {
      return paramView.hasOverlappingRendering();
    }
    
    public final boolean hasTransientState(View paramView)
    {
      return paramView.hasTransientState();
    }
    
    public final void postInvalidateOnAnimation(View paramView)
    {
      paramView.postInvalidateOnAnimation();
    }
    
    public final void postOnAnimation(View paramView, Runnable paramRunnable)
    {
      paramView.postOnAnimation(paramRunnable);
    }
    
    public final void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
    }
    
    public void requestApplyInsets(View paramView)
    {
      paramView.requestFitSystemWindows();
    }
    
    public void setImportantForAccessibility(View paramView, int paramInt)
    {
      int i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
      paramView.setImportantForAccessibility(i);
    }
  }
  
  static class JbMr1ViewCompatImpl
    extends ViewCompat.JBViewCompatImpl
  {
    public final int getLayoutDirection(View paramView)
    {
      return paramView.getLayoutDirection();
    }
    
    public final int getPaddingEnd(View paramView)
    {
      return paramView.getPaddingEnd();
    }
    
    public final int getPaddingStart(View paramView)
    {
      return paramView.getPaddingStart();
    }
    
    public final int getWindowSystemUiVisibility(View paramView)
    {
      return paramView.getWindowSystemUiVisibility();
    }
    
    public final boolean isPaddingRelative(View paramView)
    {
      return paramView.isPaddingRelative();
    }
    
    public final void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  static class JbMr2ViewCompatImpl
    extends ViewCompat.JbMr1ViewCompatImpl
  {}
  
  static class KitKatViewCompatImpl
    extends ViewCompat.JbMr2ViewCompatImpl
  {
    public final boolean isAttachedToWindow(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
    
    public final boolean isLaidOut(View paramView)
    {
      return paramView.isLaidOut();
    }
    
    public final void setAccessibilityLiveRegion$5359dc9a(View paramView)
    {
      paramView.setAccessibilityLiveRegion(1);
    }
    
    public final void setImportantForAccessibility(View paramView, int paramInt)
    {
      paramView.setImportantForAccessibility(paramInt);
    }
  }
  
  static class LollipopViewCompatImpl
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
  
  static final class MarshmallowViewCompatImpl
    extends ViewCompat.LollipopViewCompatImpl
  {
    public final void offsetLeftAndRight(View paramView, int paramInt)
    {
      paramView.offsetLeftAndRight(paramInt);
    }
    
    public final void offsetTopAndBottom(View paramView, int paramInt)
    {
      paramView.offsetTopAndBottom(paramInt);
    }
    
    public final void setScrollIndicators$17e143a3(View paramView, int paramInt)
    {
      paramView.setScrollIndicators(paramInt, 3);
    }
  }
  
  static abstract interface ViewCompatImpl
  {
    public abstract ViewPropertyAnimatorCompat animate(View paramView);
    
    public abstract boolean canScrollHorizontally(View paramView, int paramInt);
    
    public abstract boolean canScrollVertically(View paramView, int paramInt);
    
    public abstract int combineMeasuredStates(int paramInt1, int paramInt2);
    
    public abstract WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat);
    
    public abstract float getAlpha(View paramView);
    
    public abstract ColorStateList getBackgroundTintList(View paramView);
    
    public abstract PorterDuff.Mode getBackgroundTintMode(View paramView);
    
    public abstract float getElevation(View paramView);
    
    public abstract boolean getFitsSystemWindows(View paramView);
    
    public abstract int getImportantForAccessibility(View paramView);
    
    public abstract int getLayerType(View paramView);
    
    public abstract int getLayoutDirection(View paramView);
    
    public abstract int getMeasuredState(View paramView);
    
    public abstract int getMeasuredWidthAndState(View paramView);
    
    public abstract int getMinimumHeight(View paramView);
    
    public abstract int getMinimumWidth(View paramView);
    
    public abstract int getOverScrollMode(View paramView);
    
    public abstract int getPaddingEnd(View paramView);
    
    public abstract int getPaddingStart(View paramView);
    
    public abstract ViewParent getParentForAccessibility(View paramView);
    
    public abstract float getScaleX(View paramView);
    
    public abstract float getTranslationX(View paramView);
    
    public abstract float getTranslationY(View paramView);
    
    public abstract int getWindowSystemUiVisibility(View paramView);
    
    public abstract float getZ(View paramView);
    
    public abstract boolean hasAccessibilityDelegate(View paramView);
    
    public abstract boolean hasOnClickListeners(View paramView);
    
    public abstract boolean hasOverlappingRendering(View paramView);
    
    public abstract boolean hasTransientState(View paramView);
    
    public abstract boolean isAttachedToWindow(View paramView);
    
    public abstract boolean isLaidOut(View paramView);
    
    public abstract boolean isNestedScrollingEnabled(View paramView);
    
    public abstract boolean isPaddingRelative(View paramView);
    
    public abstract void jumpDrawablesToCurrentState(View paramView);
    
    public abstract void offsetLeftAndRight(View paramView, int paramInt);
    
    public abstract void offsetTopAndBottom(View paramView, int paramInt);
    
    public abstract WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat);
    
    public abstract void postInvalidateOnAnimation(View paramView);
    
    public abstract void postOnAnimation(View paramView, Runnable paramRunnable);
    
    public abstract void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong);
    
    public abstract void requestApplyInsets(View paramView);
    
    public abstract int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat);
    
    public abstract void setAccessibilityLiveRegion$5359dc9a(View paramView);
    
    public abstract void setActivated(View paramView, boolean paramBoolean);
    
    public abstract void setAlpha(View paramView, float paramFloat);
    
    public abstract void setBackgroundTintList(View paramView, ColorStateList paramColorStateList);
    
    public abstract void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode);
    
    public abstract void setChildrenDrawingOrderEnabled$4d3af60(ViewGroup paramViewGroup);
    
    public abstract void setElevation(View paramView, float paramFloat);
    
    public abstract void setFitsSystemWindows(View paramView, boolean paramBoolean);
    
    public abstract void setImportantForAccessibility(View paramView, int paramInt);
    
    public abstract void setLayerType(View paramView, int paramInt, Paint paramPaint);
    
    public abstract void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener);
    
    public abstract void setOverScrollMode(View paramView, int paramInt);
    
    public abstract void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void setSaveFromParentEnabled$53599cc9(View paramView);
    
    public abstract void setScaleX(View paramView, float paramFloat);
    
    public abstract void setScaleY(View paramView, float paramFloat);
    
    public abstract void setScrollIndicators$17e143a3(View paramView, int paramInt);
    
    public abstract void setTransitionName(View paramView, String paramString);
    
    public abstract void setTranslationX(View paramView, float paramFloat);
    
    public abstract void setTranslationY(View paramView, float paramFloat);
    
    public abstract void stopNestedScroll(View paramView);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */