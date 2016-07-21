package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl
  extends ViewPropertyAnimatorCompat.JBMr2ViewPropertyAnimatorCompatImpl
{
  public final void setUpdateListener$587f161e(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    ViewPropertyAnimatorCompatKK.1 local1 = null;
    if (paramViewPropertyAnimatorUpdateListener != null) {
      local1 = new ViewPropertyAnimatorCompatKK.1(paramViewPropertyAnimatorUpdateListener, paramView);
    }
    paramView.animate().setUpdateListener(local1);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.KitKatViewPropertyAnimatorCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */