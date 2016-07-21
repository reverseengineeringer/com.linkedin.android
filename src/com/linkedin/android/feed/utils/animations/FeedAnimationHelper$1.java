package com.linkedin.android.feed.utils.animations;

import android.os.Handler;

final class FeedAnimationHelper$1
  implements Runnable
{
  FeedAnimationHelper$1(FeedAnimationHelper paramFeedAnimationHelper) {}
  
  public final void run()
  {
    this$0.hideLoadingViewIfPossible();
    this$0.animationHandler.removeCallbacks(this$0.waitForFeedAnimationRunnable);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.animations.FeedAnimationHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */