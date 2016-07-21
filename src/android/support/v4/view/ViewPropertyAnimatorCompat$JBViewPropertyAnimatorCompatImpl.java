package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl
  extends ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl
{
  public final void setListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (paramViewPropertyAnimatorListener != null)
    {
      paramView.animate().setListener(new ViewPropertyAnimatorCompatJB.1(paramViewPropertyAnimatorListener, paramView));
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public final void withLayer(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    paramView.animate().withLayer();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */