package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

final class DefaultItemAnimator$7
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$7(DefaultItemAnimator paramDefaultItemAnimator, DefaultItemAnimator.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super((byte)0);
  }
  
  public final void onAnimationEnd(View paramView)
  {
    val$oldViewAnim.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
    this$0.dispatchAnimationFinished(val$changeInfo.oldHolder);
    this$0.mChangeAnimations.remove(val$changeInfo.oldHolder);
    this$0.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(View paramView) {}
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */