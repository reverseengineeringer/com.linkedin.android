package com.linkedin.android.growth.newtovoyager.banner;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;

public final class NewToVoyagerPropCardViewListener
  implements NewToVoyagerPropCardView.Listener
{
  private AnimatorSet animators;
  NewToVoyagerPropCardViewHolder viewHolder;
  
  public final void onCardHide()
  {
    if (animators != null)
    {
      animators.removeAllListeners();
      animators.cancel();
    }
  }
  
  public final void onCardShow()
  {
    float f2 = 0.0F;
    Object localObject1;
    if (viewHolder != null) {
      if (viewHolder != null)
      {
        viewHolder.swipeArrow.setAlpha(0.0F);
        localObject1 = viewHolder.swipeArrow;
        if (JellyBeanMr1Utils.getLayoutDirection(viewHolder.itemView.getContext()) != 0) {
          break label266;
        }
      }
    }
    label266:
    for (float f1 = 0.0F;; f1 = viewHolder.swipeInstructionView.getRight() - viewHolder.swipeArrow.getWidth() * 1.51F)
    {
      ((View)localObject1).setX(f1);
      animators = new AnimatorSet();
      localObject1 = animators;
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(viewHolder.swipeArrow, "alpha", new float[] { 0.0F, 1.0F }).setDuration(250L);
      Object localObject2 = viewHolder.swipeArrow;
      f1 = f2;
      if (JellyBeanMr1Utils.getLayoutDirection(viewHolder.itemView.getContext()) == 0) {
        f1 = viewHolder.swipeInstructionView.getRight() - viewHolder.swipeArrow.getWidth() * 1.51F;
      }
      localObject2 = ObjectAnimator.ofFloat(localObject2, "x", new float[] { f1 }).setDuration(1800L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(viewHolder.swipeArrow, "alpha", new float[] { 1.0F, 0.0F }).setDuration(250L);
      localObjectAnimator2.setStartDelay(1550L);
      ((AnimatorSet)localObject1).playTogether(new Animator[] { localObjectAnimator1, localObject2, localObjectAnimator2 });
      animators.addListener(new DefaultAnimatorListener()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramAnonymousAnimator.setStartDelay(val$startDelayInMs);
          paramAnonymousAnimator.start();
        }
      });
      animators.start();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerPropCardViewListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */