package android.support.design.widget;

import android.view.MotionEvent;
import android.view.View;

final class Snackbar$Behavior
  extends SwipeDismissBehavior<Snackbar.SnackbarLayout>
{
  Snackbar$Behavior(Snackbar paramSnackbar) {}
  
  public final boolean canSwipeDismissView(View paramView)
  {
    return paramView instanceof Snackbar.SnackbarLayout;
  }
  
  public final boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, Snackbar.SnackbarLayout paramSnackbarLayout, MotionEvent paramMotionEvent)
  {
    if (paramCoordinatorLayout.isPointInChildBounds(paramSnackbarLayout, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramCoordinatorLayout, paramSnackbarLayout, paramMotionEvent);
      SnackbarManager.getInstance().cancelTimeout(Snackbar.access$200(this$0));
      continue;
      SnackbarManager.getInstance().restoreTimeout(Snackbar.access$200(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.Behavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */