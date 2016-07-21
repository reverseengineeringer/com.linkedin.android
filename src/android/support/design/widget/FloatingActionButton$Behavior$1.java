package android.support.design.widget;

import android.support.v4.view.ViewCompat;

class FloatingActionButton$Behavior$1
  implements ValueAnimatorCompat.AnimatorUpdateListener
{
  FloatingActionButton$Behavior$1(FloatingActionButton.Behavior paramBehavior, FloatingActionButton paramFloatingActionButton) {}
  
  public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    ViewCompat.setTranslationY(val$fab, paramValueAnimatorCompat.getAnimatedFloatValue());
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButton.Behavior.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */