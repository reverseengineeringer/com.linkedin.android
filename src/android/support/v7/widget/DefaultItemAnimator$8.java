package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

final class DefaultItemAnimator$8
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$8(DefaultItemAnimator paramDefaultItemAnimator, DefaultItemAnimator.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    super((byte)0);
  }
  
  public final void onAnimationEnd(View paramView)
  {
    val$newViewAnimation.setListener(null);
    ViewCompat.setAlpha(val$newView, 1.0F);
    ViewCompat.setTranslationX(val$newView, 0.0F);
    ViewCompat.setTranslationY(val$newView, 0.0F);
    this$0.dispatchAnimationFinished(val$changeInfo.newHolder);
    this$0.mChangeAnimations.remove(val$changeInfo.newHolder);
    this$0.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(View paramView) {}
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */