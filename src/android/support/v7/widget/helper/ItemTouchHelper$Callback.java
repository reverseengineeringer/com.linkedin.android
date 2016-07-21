package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R.dimen;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.List;

public abstract class ItemTouchHelper$Callback
{
  private static final Interpolator sDragScrollInterpolator = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat;
    }
  };
  private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  private static final ItemTouchUIUtil sUICallback = new ItemTouchUIUtilImpl.Gingerbread();
  private int mCachedMaxScrollSpeed = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      sUICallback = new ItemTouchUIUtilImpl.Lollipop();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      sUICallback = new ItemTouchUIUtilImpl.Honeycomb();
      return;
    }
  }
  
  public static boolean canDropOver$1cbf1fb9()
  {
    return true;
  }
  
  public static RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder paramViewHolder, List<RecyclerView.ViewHolder> paramList, int paramInt1, int paramInt2)
  {
    int n = itemView.getWidth();
    int i1 = itemView.getHeight();
    Object localObject2 = null;
    int j = -1;
    int i2 = paramInt1 - itemView.getLeft();
    int i3 = paramInt2 - itemView.getTop();
    int i4 = paramList.size();
    int k = 0;
    while (k < i4)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)paramList.get(k);
      Object localObject1 = localObject2;
      int i = j;
      int m;
      if (i2 > 0)
      {
        m = itemView.getRight() - (paramInt1 + n);
        localObject1 = localObject2;
        i = j;
        if (m < 0)
        {
          localObject1 = localObject2;
          i = j;
          if (itemView.getRight() > itemView.getRight())
          {
            m = Math.abs(m);
            localObject1 = localObject2;
            i = j;
            if (m > j)
            {
              i = m;
              localObject1 = localViewHolder;
            }
          }
        }
      }
      localObject2 = localObject1;
      j = i;
      if (i2 < 0)
      {
        m = itemView.getLeft() - paramInt1;
        localObject2 = localObject1;
        j = i;
        if (m > 0)
        {
          localObject2 = localObject1;
          j = i;
          if (itemView.getLeft() < itemView.getLeft())
          {
            m = Math.abs(m);
            localObject2 = localObject1;
            j = i;
            if (m > i)
            {
              j = m;
              localObject2 = localViewHolder;
            }
          }
        }
      }
      localObject1 = localObject2;
      i = j;
      if (i3 < 0)
      {
        m = itemView.getTop() - paramInt2;
        localObject1 = localObject2;
        i = j;
        if (m > 0)
        {
          localObject1 = localObject2;
          i = j;
          if (itemView.getTop() < itemView.getTop())
          {
            m = Math.abs(m);
            localObject1 = localObject2;
            i = j;
            if (m > j)
            {
              i = m;
              localObject1 = localViewHolder;
            }
          }
        }
      }
      localObject2 = localObject1;
      j = i;
      if (i3 > 0)
      {
        m = itemView.getBottom() - (paramInt2 + i1);
        localObject2 = localObject1;
        j = i;
        if (m < 0)
        {
          localObject2 = localObject1;
          j = i;
          if (itemView.getBottom() > itemView.getBottom())
          {
            m = Math.abs(m);
            localObject2 = localObject1;
            j = i;
            if (m > i)
            {
              j = m;
              localObject2 = localViewHolder;
            }
          }
        }
      }
      k += 1;
    }
    return (RecyclerView.ViewHolder)localObject2;
  }
  
  public static void clearView$448413f6(RecyclerView.ViewHolder paramViewHolder)
  {
    sUICallback.clearView(itemView);
  }
  
  public static int convertToAbsoluteDirection(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0x303030;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 &= (i ^ 0xFFFFFFFF);
    if (paramInt2 == 0) {
      return paramInt1 | i >> 2;
    }
    return i >> 1 & 0xFFCFCFCF | paramInt1 | (i >> 1 & 0x303030) >> 2;
  }
  
  public static int convertToRelativeDirection(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0xC0C0C;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 &= (i ^ 0xFFFFFFFF);
    if (paramInt2 == 0) {
      return paramInt1 | i << 2;
    }
    return i << 1 & 0xFFF3F3F3 | paramInt1 | (i << 1 & 0xC0C0C) << 2;
  }
  
  public static long getAnimationDuration$342fd44c(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = paramRecyclerView.getItemAnimator();
    if (paramRecyclerView == null)
    {
      if (paramInt == 8) {
        return 200L;
      }
      return 250L;
    }
    if (paramInt == 8) {
      return mMoveDuration;
    }
    return mRemoveDuration;
  }
  
  public static int getBoundingBoxMargin()
  {
    return 0;
  }
  
  public static float getMoveThreshold$cb3a918()
  {
    return 0.5F;
  }
  
  public static float getSwipeEscapeVelocity(float paramFloat)
  {
    return paramFloat;
  }
  
  public static float getSwipeThreshold$cb3a918()
  {
    return 0.5F;
  }
  
  public static float getSwipeVelocityThreshold(float paramFloat)
  {
    return paramFloat;
  }
  
  public static boolean isItemViewSwipeEnabled()
  {
    return true;
  }
  
  public static boolean isLongPressDragEnabled()
  {
    return true;
  }
  
  private static void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    sUICallback.onDraw(paramCanvas, paramRecyclerView, itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  private static void onChildDrawOver$29e65c40(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt)
  {
    sUICallback.onDrawOver$3d9af585(paramCanvas, paramRecyclerView, itemView, paramFloat1, paramFloat2, paramInt);
  }
  
  public static void onMoved$2444766f$43904c80(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler)) {
      ((ItemTouchHelper.ViewDropHandler)localLayoutManager).prepareForDrop$6516cd95(itemView, itemView);
    }
    do
    {
      do
      {
        return;
        if (localLayoutManager.canScrollHorizontally())
        {
          if (localLayoutManager.getDecoratedLeft(itemView) <= paramRecyclerView.getPaddingLeft()) {
            paramRecyclerView.scrollToPosition(paramInt);
          }
          if (localLayoutManager.getDecoratedRight(itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
            paramRecyclerView.scrollToPosition(paramInt);
          }
        }
      } while (!localLayoutManager.canScrollVertically());
      if (localLayoutManager.getDecoratedTop(itemView) <= paramRecyclerView.getPaddingTop()) {
        paramRecyclerView.scrollToPosition(paramInt);
      }
    } while (localLayoutManager.getDecoratedBottom(itemView) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    paramRecyclerView.scrollToPosition(paramInt);
  }
  
  public static void onSelectedChanged$763efb0b(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null) {
      sUICallback.onSelected(itemView);
    }
  }
  
  final int getAbsoluteMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return convertToAbsoluteDirection(getMovementFlags(paramRecyclerView, paramViewHolder), ViewCompat.getLayoutDirection(paramRecyclerView));
  }
  
  public abstract int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder);
  
  public final int interpolateOutOfBoundsScroll$519e9969(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, long paramLong)
  {
    if (mCachedMaxScrollSpeed == -1) {
      mCachedMaxScrollSpeed = paramRecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
    }
    int i = mCachedMaxScrollSpeed;
    int j = Math.abs(paramInt2);
    int k = (int)Math.signum(paramInt2);
    float f = Math.min(1.0F, 1.0F * j / paramInt1);
    paramInt1 = (int)(k * i * sDragViewScrollCapInterpolator.getInterpolation(f));
    if (paramLong > 2000L) {}
    for (f = 1.0F;; f = (float)paramLong / 2000.0F)
    {
      i = (int)(paramInt1 * sDragScrollInterpolator.getInterpolation(f));
      paramInt1 = i;
      if (i == 0)
      {
        if (paramInt2 <= 0) {
          break;
        }
        paramInt1 = 1;
      }
      return paramInt1;
    }
    return -1;
  }
  
  public abstract boolean onMove$1cbf1fb9(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2);
  
  public abstract void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt);
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */