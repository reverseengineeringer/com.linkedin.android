package com.linkedin.android.feed.utils.animations;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.linkedin.android.feed.FeedLoadingViewHolder;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import java.util.concurrent.CountDownLatch;

public abstract class FeedAnimationHelper
{
  public final Handler animationHandler = new Handler();
  public CountDownLatch animationLatch;
  FeedAnimationListener feedAnimationListener;
  public FeedLoadingViewHolder loadingViewHolder;
  public RecyclerView recyclerView;
  public int screenHeight;
  public final Runnable waitForFeedAnimationRunnable = new Runnable()
  {
    public final void run()
    {
      hideLoadingViewIfPossible();
      animationHandler.removeCallbacks(waitForFeedAnimationRunnable);
    }
  };
  
  public FeedAnimationHelper(RecyclerView paramRecyclerView, FeedLoadingViewHolder paramFeedLoadingViewHolder, FeedAnimationListener paramFeedAnimationListener, int paramInt)
  {
    recyclerView = paramRecyclerView;
    loadingViewHolder = paramFeedLoadingViewHolder;
    feedAnimationListener = paramFeedAnimationListener;
    screenHeight = paramInt;
    animationLatch = new CountDownLatch(2);
  }
  
  public final void hideLoadingViewIfPossible()
  {
    if (animationLatch != null)
    {
      animationLatch.countDown();
      if (animationLatch.getCount() == 0L)
      {
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(loadingViewHolder.progressBar, View.ALPHA, new float[] { 1.0F, 0.0F });
        localObjectAnimator1.setDuration(500L);
        localObjectAnimator1.addListener(new DefaultAnimatorListener()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramAnonymousAnimator = FeedAnimationHelper.this;
            ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(recyclerView, View.TRANSLATION_Y, new float[] { screenHeight, 0.0F });
            localObjectAnimator.setDuration(500L);
            localObjectAnimator.setInterpolator(new DecelerateInterpolator());
            localObjectAnimator.addListener(new FeedAnimationHelper.3(paramAnonymousAnimator));
            localObjectAnimator.start();
            feedAnimationListener.onDismissLoadingViewDone();
          }
        });
        float f = -screenHeight * 0.25F;
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(loadingViewHolder.progressBar, View.TRANSLATION_Y, new float[] { 0.0F, f });
        localObjectAnimator2.setDuration(500L);
        localObjectAnimator2.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(loadingViewHolder.text, View.ALPHA, new float[] { 1.0F, 0.0F });
        localObjectAnimator3.setDuration(500L);
        ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(loadingViewHolder.text, View.TRANSLATION_Y, new float[] { 0.0F, f });
        localObjectAnimator4.setDuration(500L);
        localObjectAnimator4.setInterpolator(new AccelerateInterpolator());
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator4, localObjectAnimator3, localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.start();
        animationLatch = null;
      }
    }
  }
  
  public static abstract interface FeedAnimationListener
  {
    public abstract void onAnimateRecyclerViewUpDone();
    
    public abstract void onDismissLoadingViewDone();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.animations.FeedAnimationHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */