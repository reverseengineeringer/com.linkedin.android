package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FloatingActionButtonIcs$2
  extends AnimatorListenerAdapter
{
  FloatingActionButtonIcs$2(FloatingActionButtonIcs paramFloatingActionButtonIcs, boolean paramBoolean, FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (val$listener != null) {
      val$listener.onShown();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this$0.mView.internalSetVisibility(0, val$fromUser);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonIcs.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */