package android.support.design.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

class CoordinatorLayout$OnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  CoordinatorLayout$OnPreDrawListener(CoordinatorLayout paramCoordinatorLayout) {}
  
  public boolean onPreDraw()
  {
    this$0.dispatchOnDependentViewChanged(false);
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.OnPreDrawListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */