package com.linkedin.android.growth.login.prereg.people;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.linkedin.android.growth.login.prereg.PreRegBaseFragmentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;

public final class PreRegPeopleFragmentViewModel
  extends PreRegBaseFragmentViewModel<PreRegPeopleFragmentViewHolder>
{
  public final ViewHolderCreator<PreRegPeopleFragmentViewHolder> getCreator()
  {
    return PreRegPeopleFragmentViewHolder.CREATOR;
  }
  
  protected final void populateAnimatorSet(final AnimatorSet paramAnimatorSet)
  {
    viewHolder).referralContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        viewHolder).referralContainer.removeOnLayoutChangeListener(this);
        paramAnonymousView = ObjectAnimator.ofFloat(paramAnonymousView, "translationY", new float[] { -paramAnonymousView.getHeight(), 0.0F }).setDuration(1000L);
        paramAnonymousView.addListener(createSetVisibleOnStartListener(viewHolder).referralContainer));
        paramAnimatorSet.play(paramAnonymousView);
      }
    });
  }
  
  protected final void resetViews()
  {
    viewHolder).referralContainer.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.people.PreRegPeopleFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */