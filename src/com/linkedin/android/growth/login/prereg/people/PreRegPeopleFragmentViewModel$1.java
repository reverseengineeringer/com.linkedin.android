package com.linkedin.android.growth.login.prereg.people;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;

final class PreRegPeopleFragmentViewModel$1
  implements View.OnLayoutChangeListener
{
  PreRegPeopleFragmentViewModel$1(PreRegPeopleFragmentViewModel paramPreRegPeopleFragmentViewModel, AnimatorSet paramAnimatorSet) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this$0.viewHolder).referralContainer.removeOnLayoutChangeListener(this);
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { -paramView.getHeight(), 0.0F }).setDuration(1000L);
    paramView.addListener(this$0.createSetVisibleOnStartListener(this$0.viewHolder).referralContainer));
    val$animatorSet.play(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.people.PreRegPeopleFragmentViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */