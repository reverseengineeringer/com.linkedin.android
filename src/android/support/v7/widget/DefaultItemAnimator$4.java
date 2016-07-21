package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

final class DefaultItemAnimator$4
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$4(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super((byte)0);
  }
  
  public final void onAnimationEnd(View paramView)
  {
    val$animation.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    this$0.dispatchAnimationFinished(val$holder);
    this$0.mRemoveAnimations.remove(val$holder);
    this$0.dispatchFinishedWhenDone();
  }
  
  public final void onAnimationStart(View paramView) {}
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */