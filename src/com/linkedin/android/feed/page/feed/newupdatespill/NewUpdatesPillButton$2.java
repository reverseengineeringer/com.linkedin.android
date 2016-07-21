package com.linkedin.android.feed.page.feed.newupdatespill;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class NewUpdatesPillButton$2
  extends AnimatorListenerAdapter
{
  NewUpdatesPillButton$2(NewUpdatesPillButton paramNewUpdatesPillButton, int paramInt) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this$0.setVisibility(4);
    this$0.setTranslationY(val$yLocation);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillButton.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */