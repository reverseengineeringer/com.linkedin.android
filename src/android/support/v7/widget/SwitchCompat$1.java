package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class SwitchCompat$1
  implements Animation.AnimationListener
{
  SwitchCompat$1(SwitchCompat paramSwitchCompat, boolean paramBoolean) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (SwitchCompat.access$100(this$0) == paramAnimation)
    {
      paramAnimation = this$0;
      if (!val$newCheckedState) {
        break label39;
      }
    }
    label39:
    for (float f = 1.0F;; f = 0.0F)
    {
      SwitchCompat.access$200(paramAnimation, f);
      SwitchCompat.access$102$3684b1bd(this$0);
      return;
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     android.support.v7.widget.SwitchCompat.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */