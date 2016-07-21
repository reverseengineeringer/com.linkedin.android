package com.linkedin.android.growth.login.prereg;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.viewmodel.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PreRegBaseFragmentViewModel<VIEW_HOLDER extends BaseViewHolder>
  extends ViewModel<VIEW_HOLDER>
{
  protected AnimatorSet animators = new AnimatorSet();
  public Context context;
  public VIEW_HOLDER viewHolder;
  
  protected final void cancelAnimations()
  {
    animators.cancel();
  }
  
  public final Animator.AnimatorListener createSetVisibleOnStartListener(final View paramView)
  {
    new DefaultAnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(4);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(0);
      }
    };
  }
  
  public void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, VIEW_HOLDER paramVIEW_HOLDER)
  {
    context = paramLayoutInflater.getContext();
    viewHolder = paramVIEW_HOLDER;
    populateAnimatorSet(animators);
  }
  
  public final void performAnimations()
  {
    animators.start();
  }
  
  public abstract void populateAnimatorSet(AnimatorSet paramAnimatorSet);
  
  protected final void removeAllListeners()
  {
    Iterator localIterator = animators.getChildAnimations().iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).removeAllListeners();
    }
  }
  
  public abstract void resetViews();
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegBaseFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */