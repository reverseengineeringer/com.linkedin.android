package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewCompat$JBViewCompatImpl
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

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.JBViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */