package com.linkedin.android.growth.login.prereg.jobs;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.Button;
import android.widget.ImageView;
import com.linkedin.android.growth.login.prereg.PreRegBaseFragmentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

public final class PreRegJobsFragmentViewModel
  extends PreRegBaseFragmentViewModel<PreRegJobsFragmentViewHolder>
{
  private PropertyValuesHolder collapseX = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 0.0F });
  private PropertyValuesHolder collapseY = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 0.0F });
  private PropertyValuesHolder expandX = PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.0F, 1.0F });
  private PropertyValuesHolder expandY = PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.0F, 1.0F });
  public int topCardPhotoResId;
  
  public final ViewHolderCreator<PreRegJobsFragmentViewHolder> getCreator()
  {
    return PreRegJobsFragmentViewHolder.CREATOR;
  }
  
  protected final void populateAnimatorSet(AnimatorSet paramAnimatorSet)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).connectBackground, new PropertyValuesHolder[] { expandX }).setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).connectButton, new PropertyValuesHolder[] { collapseX, collapseY }).setDuration(1L);
    localObjectAnimator2.addListener(new DefaultAnimatorListener()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        viewHolder).connectButton.setText(2131231605);
      }
    });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).connectIcon, new PropertyValuesHolder[] { collapseX, collapseY }).setDuration(1L);
    localObjectAnimator3.addListener(new DefaultAnimatorListener()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        viewHolder).connectIcon.setImageResource(2130837935);
      }
    });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).connectBackground, new PropertyValuesHolder[] { collapseX }).setDuration(500L);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).connectButton, new PropertyValuesHolder[] { expandX, expandY }).setDuration(1L);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).connectIcon, new PropertyValuesHolder[] { expandX, expandY }).setDuration(1L);
    paramAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    paramAnimatorSet.play(localObjectAnimator2).before(localObjectAnimator5);
    paramAnimatorSet.play(localObjectAnimator3).before(localObjectAnimator6);
  }
  
  protected final void resetViews()
  {
    viewHolder).connectButton.setText(2131231602);
    viewHolder).connectIcon.setImageResource(2130838246);
    viewHolder).connectBackground.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.jobs.PreRegJobsFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */