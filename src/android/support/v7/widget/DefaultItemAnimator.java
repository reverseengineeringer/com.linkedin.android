package android.support.v7.widget;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class DefaultItemAnimator
  extends SimpleItemAnimator
{
  ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList();
  ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList();
  ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList();
  ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList();
  private ArrayList<ChangeInfo> mPendingChanges = new ArrayList();
  private ArrayList<MoveInfo> mPendingMoves = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList();
  
  private static void cancelAll(List<RecyclerView.ViewHolder> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ViewCompat.animate(getitemView).cancel();
      i -= 1;
    }
  }
  
  private void endChangeAnimation(List<ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ChangeInfo localChangeInfo = (ChangeInfo)paramList.get(i);
      if ((endChangeAnimationIfNecessary(localChangeInfo, paramViewHolder)) && (oldHolder == null) && (newHolder == null)) {
        paramList.remove(localChangeInfo);
      }
      i -= 1;
    }
  }
  
  private void endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo)
  {
    if (oldHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, oldHolder);
    }
    if (newHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, newHolder);
    }
  }
  
  private boolean endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder)
  {
    if (newHolder == paramViewHolder) {
      newHolder = null;
    }
    for (;;)
    {
      ViewCompat.setAlpha(itemView, 1.0F);
      ViewCompat.setTranslationX(itemView, 0.0F);
      ViewCompat.setTranslationY(itemView, 0.0F);
      dispatchAnimationFinished(paramViewHolder);
      return true;
      if (oldHolder != paramViewHolder) {
        break;
      }
      oldHolder = null;
    }
    return false;
  }
  
  private void resetAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    AnimatorCompatHelper.clearInterpolator(itemView);
    endAnimation(paramViewHolder);
  }
  
  public final boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    resetAnimation(paramViewHolder);
    ViewCompat.setAlpha(itemView, 0.0F);
    mPendingAdditions.add(paramViewHolder);
    return true;
  }
  
  public final boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramViewHolder1 == paramViewHolder2) {
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = ViewCompat.getTranslationX(itemView);
    float f2 = ViewCompat.getTranslationY(itemView);
    float f3 = ViewCompat.getAlpha(itemView);
    resetAnimation(paramViewHolder1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    ViewCompat.setTranslationX(itemView, f1);
    ViewCompat.setTranslationY(itemView, f2);
    ViewCompat.setAlpha(itemView, f3);
    if (paramViewHolder2 != null)
    {
      resetAnimation(paramViewHolder2);
      ViewCompat.setTranslationX(itemView, -i);
      ViewCompat.setTranslationY(itemView, -j);
      ViewCompat.setAlpha(itemView, 0.0F);
    }
    mPendingChanges.add(new ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = itemView;
    paramInt1 = (int)(paramInt1 + ViewCompat.getTranslationX(itemView));
    paramInt2 = (int)(paramInt2 + ViewCompat.getTranslationY(itemView));
    resetAnimation(paramViewHolder);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      dispatchAnimationFinished(paramViewHolder);
      return false;
    }
    if (i != 0) {
      ViewCompat.setTranslationX(localView, -i);
    }
    if (j != 0) {
      ViewCompat.setTranslationY(localView, -j);
    }
    mPendingMoves.add(new MoveInfo(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    resetAnimation(paramViewHolder);
    mPendingRemovals.add(paramViewHolder);
    return true;
  }
  
  public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.canReuseUpdatedViewHolder(paramViewHolder, paramList));
  }
  
  final void dispatchFinishedWhenDone()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  public final void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = itemView;
    ViewCompat.animate(localView).cancel();
    int i = mPendingMoves.size() - 1;
    while (i >= 0)
    {
      if (mPendingMoves.get(i)).holder == paramViewHolder)
      {
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchAnimationFinished(paramViewHolder);
        mPendingMoves.remove(i);
      }
      i -= 1;
    }
    endChangeAnimation(mPendingChanges, paramViewHolder);
    if (mPendingRemovals.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAnimationFinished(paramViewHolder);
    }
    if (mPendingAdditions.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAnimationFinished(paramViewHolder);
    }
    i = mChangesList.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)mChangesList.get(i);
      endChangeAnimation(localArrayList, paramViewHolder);
      if (localArrayList.isEmpty()) {
        mChangesList.remove(i);
      }
      i -= 1;
    }
    i = mMovesList.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)mMovesList.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (getholder != paramViewHolder) {
            break label293;
          }
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchAnimationFinished(paramViewHolder);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            mMovesList.remove(i);
          }
        }
        i -= 1;
        break;
        label293:
        j -= 1;
      }
    }
    i = mAdditionsList.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)mAdditionsList.get(i);
      if (localArrayList.remove(paramViewHolder))
      {
        ViewCompat.setAlpha(localView, 1.0F);
        dispatchAnimationFinished(paramViewHolder);
        if (localArrayList.isEmpty()) {
          mAdditionsList.remove(i);
        }
      }
      i -= 1;
    }
    mRemoveAnimations.remove(paramViewHolder);
    mAddAnimations.remove(paramViewHolder);
    mChangeAnimations.remove(paramViewHolder);
    mMoveAnimations.remove(paramViewHolder);
    dispatchFinishedWhenDone();
  }
  
  public final void endAnimations()
  {
    int i = mPendingMoves.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (MoveInfo)mPendingMoves.get(i);
      localObject2 = holder.itemView;
      ViewCompat.setTranslationY((View)localObject2, 0.0F);
      ViewCompat.setTranslationX((View)localObject2, 0.0F);
      dispatchAnimationFinished(holder);
      mPendingMoves.remove(i);
      i -= 1;
    }
    i = mPendingRemovals.size() - 1;
    while (i >= 0)
    {
      dispatchAnimationFinished((RecyclerView.ViewHolder)mPendingRemovals.get(i));
      mPendingRemovals.remove(i);
      i -= 1;
    }
    i = mPendingAdditions.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.ViewHolder)mPendingAdditions.get(i);
      ViewCompat.setAlpha(itemView, 1.0F);
      dispatchAnimationFinished((RecyclerView.ViewHolder)localObject1);
      mPendingAdditions.remove(i);
      i -= 1;
    }
    i = mPendingChanges.size() - 1;
    while (i >= 0)
    {
      endChangeAnimationIfNecessary((ChangeInfo)mPendingChanges.get(i));
      i -= 1;
    }
    mPendingChanges.clear();
    if (!isRunning()) {
      return;
    }
    i = mMovesList.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)mMovesList.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (MoveInfo)((ArrayList)localObject1).get(j);
        View localView = holder.itemView;
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchAnimationFinished(holder);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          mMovesList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = mAdditionsList.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)mAdditionsList.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.ViewHolder)((ArrayList)localObject1).get(j);
        ViewCompat.setAlpha(itemView, 1.0F);
        dispatchAnimationFinished((RecyclerView.ViewHolder)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          mAdditionsList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = mChangesList.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)mChangesList.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        endChangeAnimationIfNecessary((ChangeInfo)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          mChangesList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    cancelAll(mRemoveAnimations);
    cancelAll(mMoveAnimations);
    cancelAll(mAddAnimations);
    cancelAll(mChangeAnimations);
    dispatchAnimationsFinished();
  }
  
  public final boolean isRunning()
  {
    return (!mPendingAdditions.isEmpty()) || (!mPendingChanges.isEmpty()) || (!mPendingMoves.isEmpty()) || (!mPendingRemovals.isEmpty()) || (!mMoveAnimations.isEmpty()) || (!mRemoveAnimations.isEmpty()) || (!mAddAnimations.isEmpty()) || (!mChangeAnimations.isEmpty()) || (!mMovesList.isEmpty()) || (!mAdditionsList.isEmpty()) || (!mChangesList.isEmpty());
  }
  
  public final void runPendingAnimations()
  {
    int i;
    int j;
    label24:
    int k;
    if (!mPendingRemovals.isEmpty())
    {
      i = 1;
      if (mPendingMoves.isEmpty()) {
        break label72;
      }
      j = 1;
      if (mPendingChanges.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (mPendingAdditions.isEmpty()) {
        break label82;
      }
    }
    label72:
    label77:
    label82:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label88;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label24;
      k = 0;
      break label36;
    }
    label88:
    final Object localObject1 = mPendingRemovals.iterator();
    final Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.ViewHolder)((Iterator)localObject1).next();
      final ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(itemView);
      mRemoveAnimations.add(localObject2);
      localViewPropertyAnimatorCompat.setDuration(mRemoveDuration).alpha(0.0F).setListener(new VpaListenerAdapter((RecyclerView.ViewHolder)localObject2)
      {
        public final void onAnimationEnd(View paramAnonymousView)
        {
          localViewPropertyAnimatorCompat.setListener(null);
          ViewCompat.setAlpha(paramAnonymousView, 1.0F);
          dispatchAnimationFinished(localObject2);
          mRemoveAnimations.remove(localObject2);
          dispatchFinishedWhenDone();
        }
        
        public final void onAnimationStart(View paramAnonymousView) {}
      }).start();
    }
    mPendingRemovals.clear();
    label260:
    label340:
    long l1;
    label415:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(mPendingMoves);
      mMovesList.add(localObject1);
      mPendingMoves.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (DefaultItemAnimator.MoveInfo)localIterator.next();
            DefaultItemAnimator localDefaultItemAnimator = DefaultItemAnimator.this;
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
          localObject1.clear();
          mMovesList.remove(localObject1);
        }
      };
      if (i != 0) {
        ViewCompat.postOnAnimationDelayed(get0holder.itemView, (Runnable)localObject2, mRemoveDuration);
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(mPendingChanges);
        mChangesList.add(localObject1);
        mPendingChanges.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            Iterator localIterator = localObject1.iterator();
            if (localIterator.hasNext())
            {
              DefaultItemAnimator.ChangeInfo localChangeInfo = (DefaultItemAnimator.ChangeInfo)localIterator.next();
              DefaultItemAnimator localDefaultItemAnimator = DefaultItemAnimator.this;
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
            localObject1.clear();
            mChangesList.remove(localObject1);
          }
        };
        if (i == 0) {
          break label477;
        }
        ViewCompat.postOnAnimationDelayed(get0oldHolder.itemView, (Runnable)localObject2, mRemoveDuration);
      }
      if (m == 0) {
        break label485;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(mPendingAdditions);
      mAdditionsList.add(localObject1);
      mPendingAdditions.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
            DefaultItemAnimator localDefaultItemAnimator = DefaultItemAnimator.this;
            ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(itemView);
            mAddAnimations.add(localViewHolder);
            localViewPropertyAnimatorCompat.alpha(1.0F).setDuration(mAddDuration).setListener(new DefaultItemAnimator.5(localDefaultItemAnimator, localViewHolder, localViewPropertyAnimatorCompat)).start();
          }
          localObject1.clear();
          mAdditionsList.remove(localObject1);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label505;
      }
      if (i == 0) {
        break label487;
      }
      l1 = mRemoveDuration;
      if (j == 0) {
        break label493;
      }
      l2 = mMoveDuration;
      label425:
      if (k == 0) {
        break label499;
      }
    }
    label477:
    label485:
    label487:
    label493:
    label499:
    for (long l3 = mChangeDuration;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      ViewCompat.postOnAnimationDelayed(get0itemView, (Runnable)localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label260;
      ((Runnable)localObject2).run();
      break label340;
      break;
      l1 = 0L;
      break label415;
      l2 = 0L;
      break label425;
    }
    label505:
    ((Runnable)localObject2).run();
  }
  
  private static final class ChangeInfo
  {
    public int fromX;
    public int fromY;
    public RecyclerView.ViewHolder newHolder;
    public RecyclerView.ViewHolder oldHolder;
    public int toX;
    public int toY;
    
    private ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
    {
      oldHolder = paramViewHolder1;
      newHolder = paramViewHolder2;
    }
    
    private ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramViewHolder1, paramViewHolder2);
      fromX = paramInt1;
      fromY = paramInt2;
      toX = paramInt3;
      toY = paramInt4;
    }
    
    public final String toString()
    {
      return "ChangeInfo{oldHolder=" + oldHolder + ", newHolder=" + newHolder + ", fromX=" + fromX + ", fromY=" + fromY + ", toX=" + toX + ", toY=" + toY + '}';
    }
  }
  
  private static final class MoveInfo
  {
    public int fromX;
    public int fromY;
    public RecyclerView.ViewHolder holder;
    public int toX;
    public int toY;
    
    private MoveInfo(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      holder = paramViewHolder;
      fromX = paramInt1;
      fromY = paramInt2;
      toX = paramInt3;
      toY = paramInt4;
    }
  }
  
  private static class VpaListenerAdapter
    implements ViewPropertyAnimatorListener
  {
    public void onAnimationCancel(View paramView) {}
    
    public void onAnimationEnd(View paramView) {}
    
    public void onAnimationStart(View paramView) {}
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */