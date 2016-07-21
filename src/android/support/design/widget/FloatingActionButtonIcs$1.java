package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FloatingActionButtonIcs$1
  extends AnimatorListenerAdapter
{
  private boolean mCancelled;
  
  FloatingActionButtonIcs$1(FloatingActionButtonIcs paramFloatingActionButtonIcs, boolean paramBoolean, FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    FloatingActionButtonIcs.access$002(this$0, false);
    mCancelled = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingActionButtonIcs.access$002(this$0, false);
    if (!mCancelled)
    {
      this$0.mView.internalSetVisibility(8, val$fromUser);
      if (val$listener != null) {
        val$listener.onHidden();
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FloatingActionButtonIcs.access$002(this$0, true);
    mCancelled = false;
    this$0.mView.internalSetVisibility(0, val$fromUser);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonIcs.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */