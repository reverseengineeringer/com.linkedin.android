package android.support.v7.widget.helper;

import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;

final class ItemTouchHelper$RecoverAnimation$1
  implements AnimatorUpdateListenerCompat
{
  ItemTouchHelper$RecoverAnimation$1(ItemTouchHelper.RecoverAnimation paramRecoverAnimation, ItemTouchHelper paramItemTouchHelper) {}
  
  public final void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    this$1.mFraction = paramValueAnimatorCompat.getAnimatedFraction();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.RecoverAnimation.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */