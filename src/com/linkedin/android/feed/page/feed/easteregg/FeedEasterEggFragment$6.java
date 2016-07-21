package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.View;

final class FeedEasterEggFragment$6
  implements ValueAnimator.AnimatorUpdateListener
{
  float[] point = new float[2];
  
  FeedEasterEggFragment$6(FeedEasterEggFragment paramFeedEasterEggFragment, Path paramPath, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = new PathMeasure(val$path, false);
    paramValueAnimator.getPosTan(paramValueAnimator.getLength() * f, point, null);
    val$head.setX(point[0]);
    val$head.setY(point[1]);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */