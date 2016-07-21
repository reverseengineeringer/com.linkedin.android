package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import java.util.ArrayList;
import java.util.Iterator;

final class DefaultItemAnimator$3
  implements Runnable
{
  DefaultItemAnimator$3(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = val$additions.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      DefaultItemAnimator localDefaultItemAnimator = this$0;
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(itemView);
      mAddAnimations.add(localViewHolder);
      localViewPropertyAnimatorCompat.alpha(1.0F).setDuration(mAddDuration).setListener(new DefaultItemAnimator.5(localDefaultItemAnimator, localViewHolder, localViewPropertyAnimatorCompat)).start();
    }
    val$additions.clear();
    this$0.mAdditionsList.remove(val$additions);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */