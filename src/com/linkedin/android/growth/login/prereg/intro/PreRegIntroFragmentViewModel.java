package com.linkedin.android.growth.login.prereg.intro;

import android.animation.AnimatorSet;
import com.linkedin.android.growth.login.prereg.PreRegBaseFragmentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;

public final class PreRegIntroFragmentViewModel
  extends PreRegBaseFragmentViewModel<PreRegIntroFragmentViewHolder>
{
  public final ViewHolderCreator<PreRegIntroFragmentViewHolder> getCreator()
  {
    return PreRegIntroFragmentViewHolder.CREATOR;
  }
  
  protected final void populateAnimatorSet(AnimatorSet paramAnimatorSet) {}
  
  protected final void resetViews() {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */