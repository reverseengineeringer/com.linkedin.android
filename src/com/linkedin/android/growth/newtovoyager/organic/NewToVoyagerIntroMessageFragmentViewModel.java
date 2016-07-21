package com.linkedin.android.growth.newtovoyager.organic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.linkedin.android.infra.ViewHolderCreator;

public final class NewToVoyagerIntroMessageFragmentViewModel
  extends NewToVoyagerIntroBaseFragmentViewModel<NewToVoyagerIntroMessageFragmentViewHolder>
{
  public final ViewHolderCreator<NewToVoyagerIntroMessageFragmentViewHolder> getCreator()
  {
    return NewToVoyagerIntroMessageFragmentViewHolder.CREATOR;
  }
  
  protected final void populateAnimatorSet(AnimatorSet paramAnimatorSet)
  {
    View localView = viewHolder).messageContainer;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(localView, new PropertyValuesHolder[] { NewToVoyagerIntroBaseFragmentViewModel.EXPAND_HALF_Y }).setDuration(1000L);
    localObjectAnimator.addListener(new NewToVoyagerIntroBaseFragmentViewModel.1(this, localView));
    paramAnimatorSet.playSequentially(new Animator[] { localObjectAnimator, fadeIn(viewHolder).today), expandElastically(viewHolder).senderFirstMessage), expandElastically(viewHolder).senderSecondMessage), expandElastically(viewHolder).recipientIcon), expandElastically(viewHolder).recipientFirstMessage), expandElastically(viewHolder).recipientSecondMessage) });
  }
  
  protected final void resetViews()
  {
    viewHolder).today.setAlpha(0.0F);
    viewHolder).senderFirstMessage.setVisibility(4);
    viewHolder).senderSecondMessage.setVisibility(4);
    viewHolder).recipientIcon.setVisibility(4);
    viewHolder).recipientFirstMessage.setVisibility(4);
    viewHolder).recipientSecondMessage.setVisibility(4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroMessageFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */