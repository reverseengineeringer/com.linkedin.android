package com.linkedin.android.axle.rta;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

final class RateTheApp$7$1
  implements Runnable
{
  RateTheApp$7$1(RateTheApp.7 param7) {}
  
  public final void run()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this$1.val$context, 2131034149);
    this$1.this$0.dislikeConfirmView.startAnimation(localAnimation);
    this$1.this$0.dislikeConfirmView.setVisibility(8);
    this$1.this$0.container = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp.7.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */