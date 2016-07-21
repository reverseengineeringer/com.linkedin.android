package android.support.v4.view;

import android.view.View;

class ViewCompat$KitKatViewCompatImpl
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

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.KitKatViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */