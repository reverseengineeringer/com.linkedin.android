package com.linkedin.android.growth.newtovoyager.organic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.text.Spanned;
import android.view.View;
import com.linkedin.android.infra.ViewHolderCreator;

public final class NewToVoyagerIntroSearchFragmentViewModel
  extends NewToVoyagerIntroBaseFragmentViewModel<NewToVoyagerIntroSearchFragmentViewHolder>
{
  public Spanned groupsText;
  public String heading;
  public Spanned jobsText;
  public Spanned peopleText;
  
  public final ViewHolderCreator<NewToVoyagerIntroSearchFragmentViewHolder> getCreator()
  {
    return NewToVoyagerIntroSearchFragmentViewHolder.CREATOR;
  }
  
  protected final void populateAnimatorSet(AnimatorSet paramAnimatorSet)
  {
    paramAnimatorSet.playSequentially(new Animator[] { fadeIn(viewHolder).jobs), fadeIn(viewHolder).people), fadeIn(viewHolder).group) });
  }
  
  protected final void resetViews()
  {
    viewHolder).jobs.setAlpha(0.0F);
    viewHolder).people.setAlpha(0.0F);
    viewHolder).group.setAlpha(0.0F);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroSearchFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */