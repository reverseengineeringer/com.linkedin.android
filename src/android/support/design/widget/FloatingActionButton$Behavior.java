package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.List;

public class FloatingActionButton$Behavior
  extends CoordinatorLayout.Behavior<FloatingActionButton>
{
  private static final boolean SNACKBAR_BEHAVIOR_ENABLED;
  private float mFabTranslationY;
  private ValueAnimatorCompat mFabTranslationYAnimator;
  private Rect mTmpRect;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      SNACKBAR_BEHAVIOR_ENABLED = bool;
      return;
    }
  }
  
  private float getFabTranslationYForSnackbar(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
  {
    float f1 = 0.0F;
    List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
    int i = 0;
    int j = localList.size();
    while (i < j)
    {
      View localView = (View)localList.get(i);
      float f2 = f1;
      if ((localView instanceof Snackbar.SnackbarLayout))
      {
        f2 = f1;
        if (paramCoordinatorLayout.doViewsOverlap(paramFloatingActionButton, localView)) {
          f2 = Math.min(f1, ViewCompat.getTranslationY(localView) - localView.getHeight());
        }
      }
      i += 1;
      f1 = f2;
    }
    return f1;
  }
  
  private void offsetIfNeeded(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
  {
    Rect localRect = FloatingActionButton.access$200(paramFloatingActionButton);
    CoordinatorLayout.LayoutParams localLayoutParams;
    int j;
    int i;
    if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
    {
      localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
      j = 0;
      i = 0;
      if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - rightMargin) {
        break label100;
      }
      i = right;
      if (paramFloatingActionButton.getBottom() < paramCoordinatorLayout.getBottom() - bottomMargin) {
        break label122;
      }
      j = bottom;
    }
    for (;;)
    {
      paramFloatingActionButton.offsetTopAndBottom(j);
      paramFloatingActionButton.offsetLeftAndRight(i);
      return;
      label100:
      if (paramFloatingActionButton.getLeft() > leftMargin) {
        break;
      }
      i = -left;
      break;
      label122:
      if (paramFloatingActionButton.getTop() <= topMargin) {
        j = -top;
      }
    }
  }
  
  private void updateFabTranslationForSnackbar(CoordinatorLayout paramCoordinatorLayout, final FloatingActionButton paramFloatingActionButton, View paramView)
  {
    float f1 = getFabTranslationYForSnackbar(paramCoordinatorLayout, paramFloatingActionButton);
    if (mFabTranslationY == f1) {
      return;
    }
    float f2 = ViewCompat.getTranslationY(paramFloatingActionButton);
    if ((mFabTranslationYAnimator != null) && (mFabTranslationYAnimator.isRunning())) {
      mFabTranslationYAnimator.cancel();
    }
    if ((paramFloatingActionButton.isShown()) && (Math.abs(f2 - f1) > paramFloatingActionButton.getHeight() * 0.667F))
    {
      if (mFabTranslationYAnimator == null)
      {
        mFabTranslationYAnimator = ViewUtils.createAnimator();
        mFabTranslationYAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        mFabTranslationYAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
          {
            ViewCompat.setTranslationY(paramFloatingActionButton, paramAnonymousValueAnimatorCompat.getAnimatedFloatValue());
          }
        });
      }
      mFabTranslationYAnimator.setFloatValues(f2, f1);
      mFabTranslationYAnimator.start();
    }
    for (;;)
    {
      mFabTranslationY = f1;
      return;
      ViewCompat.setTranslationY(paramFloatingActionButton, f1);
    }
  }
  
  private boolean updateFabVisibility(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
  {
    if (((CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams()).getAnchorId() != paramAppBarLayout.getId()) {
      return false;
    }
    if (paramFloatingActionButton.getUserSetVisibility() != 0) {
      return false;
    }
    if (mTmpRect == null) {
      mTmpRect = new Rect();
    }
    Rect localRect = mTmpRect;
    ViewGroupUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
    if (bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
      FloatingActionButton.access$000(paramFloatingActionButton, null, false);
    }
    for (;;)
    {
      return true;
      FloatingActionButton.access$100(paramFloatingActionButton, null, false);
    }
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
  {
    return (SNACKBAR_BEHAVIOR_ENABLED) && ((paramView instanceof Snackbar.SnackbarLayout));
  }
  
  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
  {
    if ((paramView instanceof Snackbar.SnackbarLayout)) {
      updateFabTranslationForSnackbar(paramCoordinatorLayout, paramFloatingActionButton, paramView);
    }
    for (;;)
    {
      return false;
      if ((paramView instanceof AppBarLayout)) {
        updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      }
    }
  }
  
  public void onDependentViewRemoved(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
  {
    if ((paramView instanceof Snackbar.SnackbarLayout)) {
      updateFabTranslationForSnackbar(paramCoordinatorLayout, paramFloatingActionButton, paramView);
    }
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
  {
    List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
    int i = 0;
    int j = localList.size();
    while (i < j)
    {
      View localView = (View)localList.get(i);
      if (((localView instanceof AppBarLayout)) && (updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton))) {
        break;
      }
      i += 1;
    }
    paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
    offsetIfNeeded(paramCoordinatorLayout, paramFloatingActionButton);
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButton.Behavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */