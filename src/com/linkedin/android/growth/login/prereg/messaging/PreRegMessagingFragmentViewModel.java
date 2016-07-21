package com.linkedin.android.growth.login.prereg.messaging;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.linkedin.android.growth.login.prereg.PreRegBaseFragmentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;

public final class PreRegMessagingFragmentViewModel
  extends PreRegBaseFragmentViewModel<PreRegMessagingFragmentViewHolder>
{
  private PropertyValuesHolder popDialogCollapseX = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.5F, 1.0F });
  private PropertyValuesHolder popDialogCollapseY = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.5F, 1.0F });
  private PropertyValuesHolder popDialogExpandX = PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.0F, 1.5F });
  private PropertyValuesHolder popDialogExpandY = PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.0F, 1.5F });
  
  public final ViewHolderCreator<PreRegMessagingFragmentViewHolder> getCreator()
  {
    return PreRegMessagingFragmentViewHolder.CREATOR;
  }
  
  protected final void populateAnimatorSet(AnimatorSet paramAnimatorSet)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).dialogBox2, new PropertyValuesHolder[] { popDialogExpandX, popDialogExpandY }).setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).dialogBox2, new PropertyValuesHolder[] { popDialogCollapseX, popDialogCollapseY }).setDuration(250L);
    localObjectAnimator1.addListener(createSetVisibleOnStartListener(viewHolder).dialogBox2));
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).dialogBox3, new PropertyValuesHolder[] { popDialogExpandX, popDialogExpandY }).setDuration(500L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).dialogBox3, new PropertyValuesHolder[] { popDialogCollapseX, popDialogCollapseY }).setDuration(250L);
    localObjectAnimator3.addListener(createSetVisibleOnStartListener(viewHolder).dialogBox3));
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).dialogBox4, new PropertyValuesHolder[] { popDialogExpandX, popDialogExpandY }).setDuration(500L);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofPropertyValuesHolder(viewHolder).dialogBox4, new PropertyValuesHolder[] { popDialogCollapseX, popDialogCollapseY }).setDuration(250L);
    localObjectAnimator5.addListener(createSetVisibleOnStartListener(viewHolder).dialogBox4));
    paramAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5, localObjectAnimator6 });
  }
  
  protected final void resetViews()
  {
    viewHolder).dialogBox2.setVisibility(4);
    viewHolder).dialogBox3.setVisibility(4);
    viewHolder).dialogBox4.setVisibility(4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.messaging.PreRegMessagingFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */