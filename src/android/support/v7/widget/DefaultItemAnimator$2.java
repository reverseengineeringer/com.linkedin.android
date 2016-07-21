package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

final class DefaultItemAnimator$2
  implements Runnable
{
  DefaultItemAnimator$2(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = val$changes.iterator();
    if (localIterator.hasNext())
    {
      DefaultItemAnimator.ChangeInfo localChangeInfo = (DefaultItemAnimator.ChangeInfo)localIterator.next();
      DefaultItemAnimator localDefaultItemAnimator = this$0;
      Object localObject1 = oldHolder;
      if (localObject1 == null)
      {
        localObject1 = null;
        label46:
        localObject2 = newHolder;
        if (localObject2 == null) {
          break label223;
        }
      }
      label223:
      for (Object localObject2 = itemView;; localObject2 = null)
      {
        if (localObject1 != null)
        {
          localObject1 = ViewCompat.animate((View)localObject1).setDuration(mChangeDuration);
          mChangeAnimations.add(oldHolder);
          ((ViewPropertyAnimatorCompat)localObject1).translationX(toX - fromX);
          ((ViewPropertyAnimatorCompat)localObject1).translationY(toY - fromY);
          ((ViewPropertyAnimatorCompat)localObject1).alpha(0.0F).setListener(new DefaultItemAnimator.7(localDefaultItemAnimator, localChangeInfo, (ViewPropertyAnimatorCompat)localObject1)).start();
        }
        if (localObject2 == null) {
          break;
        }
        localObject1 = ViewCompat.animate((View)localObject2);
        mChangeAnimations.add(newHolder);
        ((ViewPropertyAnimatorCompat)localObject1).translationX(0.0F).translationY(0.0F).setDuration(mChangeDuration).alpha(1.0F).setListener(new DefaultItemAnimator.8(localDefaultItemAnimator, localChangeInfo, (ViewPropertyAnimatorCompat)localObject1, (View)localObject2)).start();
        break;
        localObject1 = itemView;
        break label46;
      }
    }
    val$changes.clear();
    this$0.mChangesList.remove(val$changes);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */