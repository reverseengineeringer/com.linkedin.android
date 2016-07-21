package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class StateListAnimator$1
  implements Animation.AnimationListener
{
  StateListAnimator$1(StateListAnimator paramStateListAnimator) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (StateListAnimator.access$000(this$0) == paramAnimation) {
      StateListAnimator.access$002(this$0, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     android.support.design.widget.StateListAnimator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */