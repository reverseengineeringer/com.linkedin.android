package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.View;

final class FeedEasterEggFragment$4
  implements ValueAnimator.AnimatorUpdateListener
{
  float[] point = new float[2];
  
  FeedEasterEggFragment$4(FeedEasterEggFragment paramFeedEasterEggFragment, Path paramPath, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = new PathMeasure(val$path, false);
    paramValueAnimator.getPosTan(paramValueAnimator.getLength() * f, point, null);
    val$creditsBubble.setX(point[0]);
    val$creditsBubble.setY(point[1]);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */