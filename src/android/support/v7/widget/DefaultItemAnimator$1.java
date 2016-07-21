package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

final class DefaultItemAnimator$1
  implements Runnable
{
  DefaultItemAnimator$1(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = val$moves.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (DefaultItemAnimator.MoveInfo)localIterator.next();
      DefaultItemAnimator localDefaultItemAnimator = this$0;
      RecyclerView.ViewHolder localViewHolder = holder;
      int k = fromX;
      int i = fromY;
      int m = toX;
      int j = toY;
      localObject = itemView;
      k = m - k;
      i = j - i;
      if (k != 0) {
        ViewCompat.animate((View)localObject).translationX(0.0F);
      }
      if (i != 0) {
        ViewCompat.animate((View)localObject).translationY(0.0F);
      }
      localObject = ViewCompat.animate((View)localObject);
      mMoveAnimations.add(localViewHolder);
      ((ViewPropertyAnimatorCompat)localObject).setDuration(mMoveDuration).setListener(new DefaultItemAnimator.6(localDefaultItemAnimator, localViewHolder, k, i, (ViewPropertyAnimatorCompat)localObject)).start();
    }
    val$moves.clear();
    this$0.mMovesList.remove(val$moves);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */