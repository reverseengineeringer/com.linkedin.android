package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

final class ToolbarWidgetWrapper$2
  extends ViewPropertyAnimatorListenerAdapter
{
  private boolean mCanceled = false;
  
  ToolbarWidgetWrapper$2(ToolbarWidgetWrapper paramToolbarWidgetWrapper, int paramInt) {}
  
  public final void onAnimationCancel(View paramView)
  {
    mCanceled = true;
  }
  
  public final void onAnimationEnd(View paramView)
  {
    if (!mCanceled) {
      this$0.mToolbar.setVisibility(val$visibility);
    }
  }
  
  public final void onAnimationStart(View paramView)
  {
    this$0.mToolbar.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ToolbarWidgetWrapper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */