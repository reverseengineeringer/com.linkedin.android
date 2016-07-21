package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R.dimen;
import android.support.v7.widget.ChildHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public final class ItemTouchHelper
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  int mActionState = 0;
  int mActivePointerId = -1;
  public Callback mCallback;
  private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
  private List<Integer> mDistances;
  long mDragScrollStartTimeInMs;
  public float mDx;
  public float mDy;
  public GestureDetectorCompat mGestureDetector;
  float mInitialTouchX;
  float mInitialTouchY;
  public float mMaxSwipeVelocity;
  public final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener()
  {
    public final boolean onInterceptTouchEvent(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      ItemTouchHelper localItemTouchHelper1 = null;
      mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      int i = MotionEventCompat.getActionMasked(paramAnonymousMotionEvent);
      if (i == 0)
      {
        mActivePointerId = MotionEventCompat.getPointerId(paramAnonymousMotionEvent, 0);
        mInitialTouchX = paramAnonymousMotionEvent.getX();
        mInitialTouchY = paramAnonymousMotionEvent.getY();
        obtainVelocityTracker();
        if (mSelected == null)
        {
          ItemTouchHelper localItemTouchHelper2 = ItemTouchHelper.this;
          paramAnonymousRecyclerView = localItemTouchHelper1;
          if (!mRecoverAnimations.isEmpty())
          {
            View localView = localItemTouchHelper2.findChildView(paramAnonymousMotionEvent);
            i = mRecoverAnimations.size() - 1;
            paramAnonymousRecyclerView = localItemTouchHelper1;
            if (i >= 0)
            {
              paramAnonymousRecyclerView = (ItemTouchHelper.RecoverAnimation)mRecoverAnimations.get(i);
              if (mViewHolder.itemView != localView) {
                break label304;
              }
            }
          }
          if (paramAnonymousRecyclerView != null)
          {
            localItemTouchHelper1 = ItemTouchHelper.this;
            mInitialTouchX -= mX;
            localItemTouchHelper1 = ItemTouchHelper.this;
            mInitialTouchY -= mY;
            endRecoverAnimation(mViewHolder, true);
            if (mPendingCleanup.remove(mViewHolder.itemView)) {
              ItemTouchHelper.Callback.clearView$448413f6(mViewHolder);
            }
            select(mViewHolder, mActionState);
            ItemTouchHelper.access$900(ItemTouchHelper.this, paramAnonymousMotionEvent, mSelectedFlags, 0);
          }
        }
      }
      for (;;)
      {
        if (mVelocityTracker != null) {
          mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        }
        if (mSelected == null) {
          break label385;
        }
        return true;
        label304:
        i -= 1;
        break;
        if ((i == 3) || (i == 1))
        {
          mActivePointerId = -1;
          select(null, 0);
        }
        else if (mActivePointerId != -1)
        {
          int j = MotionEventCompat.findPointerIndex(paramAnonymousMotionEvent, mActivePointerId);
          if (j >= 0) {
            ItemTouchHelper.access$1000(ItemTouchHelper.this, i, paramAnonymousMotionEvent, j);
          }
        }
      }
      label385:
      return false;
    }
    
    public final void onRequestDisallowInterceptTouchEvent(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      select(null, 0);
    }
    
    public final void onTouchEvent$606727f8(MotionEvent paramAnonymousMotionEvent)
    {
      int i = 0;
      mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      if (mVelocityTracker != null) {
        mVelocityTracker.addMovement(paramAnonymousMotionEvent);
      }
      if (mActivePointerId == -1) {}
      int j;
      do
      {
        int k;
        RecyclerView.ViewHolder localViewHolder;
        do
        {
          return;
          j = MotionEventCompat.getActionMasked(paramAnonymousMotionEvent);
          k = MotionEventCompat.findPointerIndex(paramAnonymousMotionEvent, mActivePointerId);
          if (k >= 0) {
            ItemTouchHelper.access$1000(ItemTouchHelper.this, j, paramAnonymousMotionEvent, k);
          }
          localViewHolder = mSelected;
        } while (localViewHolder == null);
        switch (j)
        {
        case 4: 
        case 5: 
        default: 
          return;
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            select(null, 0);
            mActivePointerId = -1;
            return;
            if (k < 0) {
              break;
            }
            ItemTouchHelper.access$900(ItemTouchHelper.this, paramAnonymousMotionEvent, mSelectedFlags, k);
            ItemTouchHelper.access$100(ItemTouchHelper.this, localViewHolder);
            mRecyclerView.removeCallbacks(mScrollRunnable);
            mScrollRunnable.run();
            mRecyclerView.invalidate();
            return;
            if (mVelocityTracker != null) {
              mVelocityTracker.clear();
            }
          }
        }
        j = MotionEventCompat.getActionIndex(paramAnonymousMotionEvent);
      } while (MotionEventCompat.getPointerId(paramAnonymousMotionEvent, j) != mActivePointerId);
      if (j == 0) {
        i = 1;
      }
      mActivePointerId = MotionEventCompat.getPointerId(paramAnonymousMotionEvent, i);
      ItemTouchHelper.access$900(ItemTouchHelper.this, paramAnonymousMotionEvent, mSelectedFlags, j);
    }
  };
  public View mOverdrawChild = null;
  public int mOverdrawChildPosition = -1;
  final List<View> mPendingCleanup = new ArrayList();
  public List<RecoverAnimation> mRecoverAnimations = new ArrayList();
  public RecyclerView mRecyclerView;
  final Runnable mScrollRunnable = new Runnable()
  {
    public final void run()
    {
      int k = 0;
      ItemTouchHelper localItemTouchHelper;
      long l2;
      long l1;
      Object localObject;
      int j;
      int i;
      label149:
      int m;
      label206:
      RecyclerView localRecyclerView;
      if (mSelected != null)
      {
        localItemTouchHelper = ItemTouchHelper.this;
        if (mSelected == null) {
          break label550;
        }
        l2 = System.currentTimeMillis();
        if (mDragScrollStartTimeInMs != Long.MIN_VALUE) {
          break label409;
        }
        l1 = 0L;
        localObject = mRecyclerView.getLayoutManager();
        if (mTmpRect == null) {
          mTmpRect = new Rect();
        }
        ((RecyclerView.LayoutManager)localObject).calculateItemDecorationsForChild(mSelected.itemView, mTmpRect);
        if (!((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {
          break label479;
        }
        j = (int)(mSelectedStartX + mDx);
        i = j - mTmpRect.left - mRecyclerView.getPaddingLeft();
        if ((mDx >= 0.0F) || (i >= 0)) {
          break label422;
        }
        if (!((RecyclerView.LayoutManager)localObject).canScrollVertically()) {
          break label545;
        }
        m = (int)(mSelectedStartY + mDy);
        j = m - mTmpRect.top - mRecyclerView.getPaddingTop();
        if ((mDy >= 0.0F) || (j >= 0)) {
          break label484;
        }
        if (i == 0) {
          break label566;
        }
        localObject = mCallback;
        localRecyclerView = mRecyclerView;
        m = mSelected.itemView.getWidth();
        mRecyclerView.getWidth();
        i = ((ItemTouchHelper.Callback)localObject).interpolateOutOfBoundsScroll$519e9969(localRecyclerView, m, i, l1);
      }
      label409:
      label422:
      label479:
      label484:
      label545:
      label550:
      label566:
      for (;;)
      {
        if (j != 0)
        {
          localObject = mCallback;
          localRecyclerView = mRecyclerView;
          m = mSelected.itemView.getHeight();
          mRecyclerView.getHeight();
          j = ((ItemTouchHelper.Callback)localObject).interpolateOutOfBoundsScroll$519e9969(localRecyclerView, m, j, l1);
        }
        for (;;)
        {
          if ((i != 0) || (j != 0))
          {
            if (mDragScrollStartTimeInMs == Long.MIN_VALUE) {
              mDragScrollStartTimeInMs = l2;
            }
            mRecyclerView.scrollBy(i, j);
          }
          for (i = 1;; i = k)
          {
            if (i != 0)
            {
              if (mSelected != null) {
                ItemTouchHelper.access$100(ItemTouchHelper.this, mSelected);
              }
              mRecyclerView.removeCallbacks(mScrollRunnable);
              ViewCompat.postOnAnimation(mRecyclerView, this);
            }
            return;
            l1 = l2 - mDragScrollStartTimeInMs;
            break;
            if (mDx > 0.0F)
            {
              j = j + mSelected.itemView.getWidth() + mTmpRect.right - (mRecyclerView.getWidth() - mRecyclerView.getPaddingRight());
              i = j;
              if (j > 0) {
                break label149;
              }
            }
            i = 0;
            break label149;
            if (mDy > 0.0F)
            {
              m = m + mSelected.itemView.getHeight() + mTmpRect.bottom - (mRecyclerView.getHeight() - mRecyclerView.getPaddingBottom());
              j = m;
              if (m > 0) {
                break label206;
              }
            }
            j = 0;
            break label206;
            mDragScrollStartTimeInMs = Long.MIN_VALUE;
          }
        }
      }
    }
  };
  RecyclerView.ViewHolder mSelected = null;
  int mSelectedFlags;
  float mSelectedStartX;
  float mSelectedStartY;
  public int mSlop;
  private List<RecyclerView.ViewHolder> mSwapTargets;
  public float mSwipeEscapeVelocity;
  private final float[] mTmpPosition = new float[2];
  Rect mTmpRect;
  VelocityTracker mVelocityTracker;
  
  public ItemTouchHelper(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  private int checkHorizontalSwipe$763efafe(int paramInt)
  {
    if ((paramInt & 0xC) != 0)
    {
      int i;
      if (mDx > 0.0F)
      {
        i = 8;
        if ((mVelocityTracker == null) || (mActivePointerId < 0)) {
          break label140;
        }
        mVelocityTracker.computeCurrentVelocity(1000, Callback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
        f2 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId);
        f1 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
        if (f2 <= 0.0F) {
          break label134;
        }
      }
      label134:
      for (int j = 8;; j = 4)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < Callback.getSwipeEscapeVelocity(mSwipeEscapeVelocity)) || (f2 <= Math.abs(f1))) {
          break label140;
        }
        return j;
        i = 4;
        break;
      }
      label140:
      float f1 = mRecyclerView.getWidth();
      float f2 = Callback.getSwipeThreshold$cb3a918();
      if (((paramInt & i) != 0) && (Math.abs(mDx) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private int checkVerticalSwipe$763efafe(int paramInt)
  {
    if ((paramInt & 0x3) != 0)
    {
      int i;
      if (mDy > 0.0F)
      {
        i = 2;
        if ((mVelocityTracker == null) || (mActivePointerId < 0)) {
          break label137;
        }
        mVelocityTracker.computeCurrentVelocity(1000, Callback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
        f1 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId);
        f2 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
        if (f2 <= 0.0F) {
          break label131;
        }
      }
      label131:
      for (int j = 2;; j = 1)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < Callback.getSwipeEscapeVelocity(mSwipeEscapeVelocity)) || (f2 <= Math.abs(f1))) {
          break label137;
        }
        return j;
        i = 1;
        break;
      }
      label137:
      float f1 = mRecyclerView.getHeight();
      float f2 = Callback.getSwipeThreshold$cb3a918();
      if (((paramInt & i) != 0) && (Math.abs(mDy) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private void getSelectedDxDy(float[] paramArrayOfFloat)
  {
    if ((mSelectedFlags & 0xC) != 0) {
      paramArrayOfFloat[0] = (mSelectedStartX + mDx - mSelected.itemView.getLeft());
    }
    while ((mSelectedFlags & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (mSelectedStartY + mDy - mSelected.itemView.getTop());
      return;
      paramArrayOfFloat[0] = ViewCompat.getTranslationX(mSelected.itemView);
    }
    paramArrayOfFloat[1] = ViewCompat.getTranslationY(mSelected.itemView);
  }
  
  private static boolean hitTest(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  final int endRecoverAnimation(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
      if (mViewHolder == paramViewHolder)
      {
        mOverridden |= paramBoolean;
        if (!mEnded) {
          mValueAnimator.cancel();
        }
        mRecoverAnimations.remove(i);
        return mAnimationType;
      }
      i -= 1;
    }
    return 0;
  }
  
  final View findChildView(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (mSelected != null)
    {
      paramMotionEvent = mSelected.itemView;
      if (hitTest(paramMotionEvent, f1, f2, mSelectedStartX + mDx, mSelectedStartY + mDy)) {
        return paramMotionEvent;
      }
    }
    int i = mRecoverAnimations.size() - 1;
    View localView;
    while (i >= 0)
    {
      paramMotionEvent = (RecoverAnimation)mRecoverAnimations.get(i);
      localView = mViewHolder.itemView;
      if (hitTest(localView, f1, f2, mX, mY)) {
        return localView;
      }
      i -= 1;
    }
    RecyclerView localRecyclerView = mRecyclerView;
    i = mChildHelper.getChildCount() - 1;
    for (;;)
    {
      if (i < 0) {
        break label243;
      }
      localView = mChildHelper.getChildAt(i);
      float f3 = ViewCompat.getTranslationX(localView);
      float f4 = ViewCompat.getTranslationY(localView);
      if ((f1 >= localView.getLeft() + f3) && (f1 <= f3 + localView.getRight()) && (f2 >= localView.getTop() + f4))
      {
        paramMotionEvent = localView;
        if (f2 <= localView.getBottom() + f4) {
          break;
        }
      }
      i -= 1;
    }
    label243:
    return null;
  }
  
  public final void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.setEmpty();
  }
  
  public final void obtainVelocityTracker()
  {
    if (mVelocityTracker != null) {
      mVelocityTracker.recycle();
    }
    mVelocityTracker = VelocityTracker.obtain();
  }
  
  public final void onChildViewAttachedToWindow(View paramView) {}
  
  public final void onChildViewDetachedFromWindow(View paramView)
  {
    removeChildDrawingOrderCallbackIfNecessary(paramView);
    paramView = mRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((mSelected != null) && (paramView == mSelected))
      {
        select(null, 0);
        return;
      }
      endRecoverAnimation(paramView, false);
    } while (!mPendingCleanup.remove(itemView));
    Callback.clearView$448413f6(paramView);
  }
  
  public final void onDraw$13fcd2ff(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    mOverdrawChildPosition = -1;
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (mSelected != null)
    {
      getSelectedDxDy(mTmpPosition);
      f1 = mTmpPosition[0];
      f2 = mTmpPosition[1];
    }
    Callback.access$1400$164475c1(paramCanvas, paramRecyclerView, mSelected, mRecoverAnimations, mActionState, f1, f2);
  }
  
  public final void onDrawOver$13fcd2ff(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (mSelected != null)
    {
      getSelectedDxDy(mTmpPosition);
      f1 = mTmpPosition[0];
      f2 = mTmpPosition[1];
    }
    Callback.access$1300$164475c1(paramCanvas, paramRecyclerView, mSelected, mRecoverAnimations, mActionState, f1, f2);
  }
  
  public final void releaseVelocityTracker()
  {
    if (mVelocityTracker != null)
    {
      mVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  final void removeChildDrawingOrderCallbackIfNecessary(View paramView)
  {
    if (paramView == mOverdrawChild)
    {
      mOverdrawChild = null;
      if (mChildDrawingOrderCallback != null) {
        mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  public final void select(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == mSelected) && (paramInt == mActionState)) {
      return;
    }
    mDragScrollStartTimeInMs = Long.MIN_VALUE;
    int k = mActionState;
    endRecoverAnimation(paramViewHolder, true);
    mActionState = paramInt;
    if (paramInt == 2)
    {
      mOverdrawChild = itemView;
      if (Build.VERSION.SDK_INT < 21)
      {
        if (mChildDrawingOrderCallback == null) {
          mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback()
          {
            public final int onGetChildDrawingOrder(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              if (mOverdrawChild == null) {}
              int i;
              do
              {
                return paramAnonymousInt2;
                int j = mOverdrawChildPosition;
                i = j;
                if (j == -1)
                {
                  i = mRecyclerView.indexOfChild(mOverdrawChild);
                  mOverdrawChildPosition = i;
                }
                if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
                  return i;
                }
              } while (paramAnonymousInt2 < i);
              return paramAnonymousInt2 + 1;
            }
          };
        }
        mRecyclerView.setChildDrawingOrderCallback(mChildDrawingOrderCallback);
      }
    }
    final int i = 0;
    int j = 0;
    final Object localObject;
    int m;
    int n;
    float f1;
    float f2;
    if (mSelected != null)
    {
      localObject = mSelected;
      if (itemView.getParent() == null) {
        break label724;
      }
      if ((k == 2) || (mActionState == 2)) {
        break label596;
      }
      i = mCallback.getMovementFlags(mRecyclerView, (RecyclerView.ViewHolder)localObject);
      m = (Callback.convertToAbsoluteDirection(i, ViewCompat.getLayoutDirection(mRecyclerView)) & 0xFF00) >> 8;
      if (m == 0) {
        break label596;
      }
      n = (i & 0xFF00) >> 8;
      if (Math.abs(mDx) <= Math.abs(mDy)) {
        break label602;
      }
      j = checkHorizontalSwipe$763efafe(m);
      if (j > 0)
      {
        i = j;
        if ((n & j) == 0) {
          i = Callback.convertToRelativeDirection(j, ViewCompat.getLayoutDirection(mRecyclerView));
        }
        releaseVelocityTracker();
      }
    }
    else
    {
      switch (i)
      {
      default: 
        f1 = 0.0F;
        f2 = 0.0F;
        label317:
        if (k == 2)
        {
          j = 8;
          label327:
          getSelectedDxDy(mTmpPosition);
          localObject = new RecoverAnimation((RecyclerView.ViewHolder)localObject, j, k, mTmpPosition[0], mTmpPosition[1], f1, f2, i)
          {
            public final void onAnimationEnd(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
            {
              super.onAnimationEnd(paramAnonymousValueAnimatorCompat);
              if (mOverridden) {}
              for (;;)
              {
                return;
                if (i <= 0) {
                  ItemTouchHelper.Callback.clearView$448413f6(localObject);
                }
                while (mOverdrawChild == localObjectitemView)
                {
                  removeChildDrawingOrderCallbackIfNecessary(localObjectitemView);
                  return;
                  mPendingCleanup.add(localObjectitemView);
                  mIsPendingCleanup = true;
                  if (i > 0)
                  {
                    paramAnonymousValueAnimatorCompat = ItemTouchHelper.this;
                    int i = i;
                    mRecyclerView.post(new ItemTouchHelper.4(paramAnonymousValueAnimatorCompat, this, i));
                  }
                }
              }
            }
          };
          long l = Callback.getAnimationDuration$342fd44c(mRecyclerView, j);
          mValueAnimator.setDuration(l);
          mRecoverAnimations.add(localObject);
          mViewHolder.setIsRecyclable(false);
          mValueAnimator.start();
          i = 1;
          label427:
          mSelected = null;
          if (paramViewHolder != null)
          {
            mSelectedFlags = ((mCallback.getAbsoluteMovementFlags(mRecyclerView, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> mActionState * 8);
            mSelectedStartX = itemView.getLeft();
            mSelectedStartY = itemView.getTop();
            mSelected = paramViewHolder;
            if (paramInt == 2) {
              mSelected.itemView.performHapticFeedback(0);
            }
          }
          paramViewHolder = mRecyclerView.getParent();
          if (paramViewHolder != null) {
            if (mSelected == null) {
              break label745;
            }
          }
        }
        break;
      }
    }
    label596:
    label602:
    label724:
    label745:
    for (boolean bool = true;; bool = false)
    {
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        mRecyclerView.getLayoutManager().mRequestedSimpleAnimations = true;
      }
      Callback.onSelectedChanged$763efb0b(mSelected);
      mRecyclerView.invalidate();
      return;
      j = checkVerticalSwipe$763efafe(m);
      i = j;
      if (j > 0) {
        break;
      }
      do
      {
        i = 0;
        break;
        j = checkVerticalSwipe$763efafe(m);
        i = j;
        if (j > 0) {
          break;
        }
        j = checkHorizontalSwipe$763efafe(m);
      } while (j <= 0);
      i = j;
      if ((n & j) != 0) {
        break;
      }
      i = Callback.convertToRelativeDirection(j, ViewCompat.getLayoutDirection(mRecyclerView));
      break;
      f2 = 0.0F;
      f1 = Math.signum(mDx) * mRecyclerView.getWidth();
      break label317;
      f1 = 0.0F;
      f2 = Math.signum(mDy) * mRecyclerView.getHeight();
      break label317;
      if (i > 0)
      {
        j = 2;
        break label327;
      }
      j = 4;
      break label327;
      removeChildDrawingOrderCallbackIfNecessary(itemView);
      Callback.clearView$448413f6((RecyclerView.ViewHolder)localObject);
      i = j;
      break label427;
    }
  }
  
  public static abstract class Callback
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
  
  private final class ItemTouchHelperGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private ItemTouchHelperGestureListener() {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      Object localObject = findChildView(paramMotionEvent);
      if (localObject != null)
      {
        localObject = mRecyclerView.getChildViewHolder((View)localObject);
        if ((localObject != null) && (ItemTouchHelper.Callback.access$2100(mCallback, mRecyclerView, (RecyclerView.ViewHolder)localObject))) {
          break label57;
        }
      }
      label57:
      while (MotionEventCompat.getPointerId(paramMotionEvent, 0) != mActivePointerId) {
        return;
      }
      int i = MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId);
      float f1 = MotionEventCompat.getX(paramMotionEvent, i);
      float f2 = MotionEventCompat.getY(paramMotionEvent, i);
      mInitialTouchX = f1;
      mInitialTouchY = f2;
      paramMotionEvent = ItemTouchHelper.this;
      mDy = 0.0F;
      mDx = 0.0F;
      ItemTouchHelper.Callback.isLongPressDragEnabled();
      select((RecyclerView.ViewHolder)localObject, 2);
    }
  }
  
  private class RecoverAnimation
    implements AnimatorListenerCompat
  {
    final int mActionState;
    final int mAnimationType;
    boolean mEnded = false;
    float mFraction;
    public boolean mIsPendingCleanup;
    boolean mOverridden = false;
    final float mStartDx;
    final float mStartDy;
    final float mTargetX;
    final float mTargetY;
    final ValueAnimatorCompat mValueAnimator;
    public final RecyclerView.ViewHolder mViewHolder;
    float mX;
    float mY;
    
    public RecoverAnimation(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      mActionState = paramInt2;
      mAnimationType = paramInt1;
      mViewHolder = paramViewHolder;
      mStartDx = paramFloat1;
      mStartDy = paramFloat2;
      mTargetX = paramFloat3;
      mTargetY = paramFloat4;
      mValueAnimator = AnimatorCompatHelper.emptyValueAnimator();
      mValueAnimator.addUpdateListener(new AnimatorUpdateListenerCompat()
      {
        public final void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
        {
          mFraction = paramAnonymousValueAnimatorCompat.getAnimatedFraction();
        }
      });
      mValueAnimator.setTarget(itemView);
      mValueAnimator.addListener(this);
      mFraction = 0.0F;
    }
    
    public final void onAnimationCancel$2feb5e66()
    {
      mFraction = 1.0F;
    }
    
    public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat)
    {
      if (!mEnded) {
        mViewHolder.setIsRecyclable(true);
      }
      mEnded = true;
    }
  }
  
  public static abstract class SimpleCallback
    extends ItemTouchHelper.Callback
  {
    private int mDefaultDragDirs;
    private int mDefaultSwipeDirs = 12;
    
    public SimpleCallback(int paramInt)
    {
      mDefaultDragDirs = paramInt;
    }
    
    public final int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      int i = mDefaultDragDirs;
      int j = getSwipeDirs(paramRecyclerView, paramViewHolder);
      return i << 16 | j << 8 | (j | i) << 0;
    }
    
    public int getSwipeDirs(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return mDefaultSwipeDirs;
    }
  }
  
  public static abstract interface ViewDropHandler
  {
    public abstract void prepareForDrop$6516cd95(View paramView1, View paramView2);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */