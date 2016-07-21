package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

final class DefaultItemAnimator$6
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$6(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super((byte)0);
  }
  
  public final void onAnimationCancel(View paramView)
  {
    if (val$deltaX != 0) {
      ViewCompat.setTranslationX(paramView, 0.0F);
    }
    if (val$deltaY != 0) {
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
  }
  
  public final void onAnimationEnd(View paramView)
  {
    val$animation.setListener(null);
    this$0.dispatchAnimationFinished(val$holder);
    this$0.mMoveAnimations.remove(val$holder);
    this$0.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(View paramView) {}
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */