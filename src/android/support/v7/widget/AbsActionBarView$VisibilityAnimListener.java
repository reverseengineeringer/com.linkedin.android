package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

public final class AbsActionBarView$VisibilityAnimListener
  implements ViewPropertyAnimatorListener
{
  private boolean mCanceled = false;
  int mFinalVisibility;
  
  protected AbsActionBarView$VisibilityAnimListener(AbsActionBarView paramAbsActionBarView) {}
  
  public final void onAnimationCancel(View paramView)
  {
    mCanceled = true;
  }
  
  public final void onAnimationEnd(View paramView)
  {
    if (mCanceled) {
      return;
    }
    this$0.mVisibilityAnim = null;
    AbsActionBarView.access$101(this$0, mFinalVisibility);
  }
  
  public final void onAnimationStart(View paramView)
  {
    AbsActionBarView.access$001$670ef754(this$0);
    mCanceled = false;
  }
  
  public final VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, int paramInt)
  {
    this$0.mVisibilityAnim = paramViewPropertyAnimatorCompat;
    mFinalVisibility = paramInt;
    return this;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AbsActionBarView.VisibilityAnimListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */