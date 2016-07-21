package android.support.v4.animation;

import android.view.View;
import java.util.List;

final class DonutAnimatorCompatProvider$DonutFloatValueAnimator$1
  implements Runnable
{
  DonutAnimatorCompatProvider$DonutFloatValueAnimator$1(DonutAnimatorCompatProvider.DonutFloatValueAnimator paramDonutFloatValueAnimator) {}
  
  public final void run()
  {
    float f = (float)(this$0.mTarget.getDrawingTime() - this$0.mStartTime) * 1.0F / (float)this$0.mDuration;
    if ((f > 1.0F) || (this$0.mTarget.getParent() == null)) {
      f = 1.0F;
    }
    this$0.mFraction = f;
    DonutAnimatorCompatProvider.DonutFloatValueAnimator localDonutFloatValueAnimator = this$0;
    int i = mUpdateListeners.size() - 1;
    while (i >= 0)
    {
      ((AnimatorUpdateListenerCompat)mUpdateListeners.get(i)).onAnimationUpdate(localDonutFloatValueAnimator);
      i -= 1;
    }
    if (this$0.mFraction >= 1.0F)
    {
      this$0.dispatchEnd();
      return;
    }
    this$0.mTarget.postDelayed(this$0.mLoopRunnable, 16L);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.animation.DonutAnimatorCompatProvider.DonutFloatValueAnimator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */