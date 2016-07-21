package com.linkedin.android.growth.newtovoyager.organic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

public final class NewToVoyagerIntroWelcomeFragmentViewModel
  extends NewToVoyagerIntroBaseFragmentViewModel<NewToVoyagerIntroWelcomeFragmentViewHolder>
{
  public View.OnClickListener skipOnClickListener;
  public String title;
  
  public final ViewHolderCreator<NewToVoyagerIntroWelcomeFragmentViewHolder> getCreator()
  {
    return NewToVoyagerIntroWelcomeFragmentViewHolder.CREATOR;
  }
  
  protected final void populateAnimatorSet(AnimatorSet paramAnimatorSet)
  {
    paramAnimatorSet = paramAnimatorSet.play(fadeIn(viewHolder).directionLayout)).with(fadeIn(viewHolder).skipButton)).with(fadeIn(viewHolder).introSubtitle)).after(moveVertically(viewHolder).introTitle));
    Object localObject = PropertyValuesHolder.ofFloat("translationX", new float[] { 0.0F, -30.0F, 0.0F, -30.0F, 0.0F });
    localObject = ObjectAnimator.ofPropertyValuesHolder(viewHolder).leftArrow, new PropertyValuesHolder[] { localObject }).setDuration(800L);
    ((ObjectAnimator)localObject).addListener(new DefaultAnimatorListener()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator.setStartDelay(val$startDelayInMs);
        paramAnonymousAnimator.start();
      }
    });
    paramAnimatorSet.before((Animator)localObject);
  }
  
  protected final void resetViews()
  {
    viewHolder).introTitle.setTranslationY(-100.0F);
    viewHolder).skipButton.setAlpha(0.0F);
    viewHolder).introSubtitle.setAlpha(0.0F);
    viewHolder).directionLayout.setAlpha(0.0F);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroWelcomeFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */