package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class ViewDragHelper
{
  private static final Interpolator sInterpolator = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  private int mActivePointerId = -1;
  private final Callback mCallback;
  View mCapturedView;
  public int mDragState;
  private int[] mEdgeDragsInProgress;
  private int[] mEdgeDragsLocked;
  int mEdgeSize;
  private int[] mInitialEdgesTouched;
  float[] mInitialMotionX;
  float[] mInitialMotionY;
  float[] mLastMotionX;
  float[] mLastMotionY;
  private float mMaxVelocity;
  float mMinVelocity;
  private final ViewGroup mParentView;
  private int mPointersDown;
  private boolean mReleaseInProgress;
  private ScrollerCompat mScroller;
  private final Runnable mSetIdleRunnable = new Runnable()
  {
    public final void run()
    {
      setDragState(0);
    }
  };
  public int mTouchSlop;
  int mTrackingEdges;
  private VelocityTracker mVelocityTracker;
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (paramCallback == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    mParentView = paramViewGroup;
    mCallback = paramCallback;
    paramViewGroup = ViewConfiguration.get(paramContext);
    mEdgeSize = ((int)(20.0F * getResourcesgetDisplayMetricsdensity + 0.5F));
    mTouchSlop = paramViewGroup.getScaledTouchSlop();
    mMaxVelocity = paramViewGroup.getScaledMaximumFlingVelocity();
    mMinVelocity = paramViewGroup.getScaledMinimumFlingVelocity();
    mScroller = ScrollerCompat.create(paramContext, sInterpolator);
  }
  
  private boolean checkNewEdgeDrag(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((mInitialEdgesTouched[paramInt1] & paramInt2) != paramInt2) || ((mTrackingEdges & paramInt2) == 0) || ((mEdgeDragsLocked[paramInt1] & paramInt2) == paramInt2) || ((mEdgeDragsInProgress[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= mTouchSlop) && (paramFloat2 <= mTouchSlop))) {}
    do
    {
      return false;
      if ((paramFloat1 < 0.5F * paramFloat2) && (mCallback.onEdgeLock(paramInt2)))
      {
        int[] arrayOfInt = mEdgeDragsLocked;
        arrayOfInt[paramInt1] |= paramInt2;
        return false;
      }
    } while (((mEdgeDragsInProgress[paramInt1] & paramInt2) != 0) || (paramFloat1 <= mTouchSlop));
    return true;
  }
  
  private boolean checkTouchSlop(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    label20:
    int j;
    label73:
    label79:
    do
    {
      do
      {
        return false;
        int i;
        if (mCallback.getViewHorizontalDragRange(paramView) > 0)
        {
          i = 1;
          if (mCallback.getViewVerticalDragRange(paramView) <= 0) {
            break label73;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label79;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= mTouchSlop * mTouchSlop) {
            break;
          }
          return true;
          i = 0;
          break label20;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) <= mTouchSlop);
      return true;
    } while ((j == 0) || (Math.abs(paramFloat2) <= mTouchSlop));
    return true;
  }
  
  private static float clampMag(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  private static int clampMag(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  private void clearMotionHistory(int paramInt)
  {
    if (mInitialMotionX == null) {
      return;
    }
    mInitialMotionX[paramInt] = 0.0F;
    mInitialMotionY[paramInt] = 0.0F;
    mLastMotionX[paramInt] = 0.0F;
    mLastMotionY[paramInt] = 0.0F;
    mInitialEdgesTouched[paramInt] = 0;
    mEdgeDragsInProgress[paramInt] = 0;
    mEdgeDragsLocked[paramInt] = 0;
    mPointersDown &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private int computeAxisDuration(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = mParentView.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f1 + f2 * f3) / paramInt2)) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback)
  {
    paramViewGroup = create(paramViewGroup, paramCallback);
    mTouchSlop = ((int)(mTouchSlop * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private void dispatchViewReleased(float paramFloat1, float paramFloat2)
  {
    mReleaseInProgress = true;
    mCallback.onViewReleased(mCapturedView, paramFloat1, paramFloat2);
    mReleaseInProgress = false;
    if (mDragState == 1) {
      setDragState(0);
    }
  }
  
  private boolean forceSettleCapturedViewAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = mCapturedView.getLeft();
    int j = mCapturedView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      mScroller.abortAnimation();
      setDragState(0);
      return false;
    }
    View localView = mCapturedView;
    paramInt3 = clampMag(paramInt3, (int)mMinVelocity, (int)mMaxVelocity);
    paramInt4 = clampMag(paramInt4, (int)mMinVelocity, (int)mMaxVelocity);
    int k = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int n = Math.abs(paramInt3);
    int i1 = Math.abs(paramInt4);
    int i2 = n + i1;
    int i3 = k + m;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = n / i2;
      if (paramInt4 == 0) {
        break label239;
      }
    }
    label239:
    for (float f2 = i1 / i2;; f2 = m / i3)
    {
      paramInt3 = computeAxisDuration(paramInt1, paramInt3, mCallback.getViewHorizontalDragRange(localView));
      paramInt4 = computeAxisDuration(paramInt2, paramInt4, mCallback.getViewVerticalDragRange(localView));
      float f3 = paramInt3;
      paramInt3 = (int)(f2 * paramInt4 + f1 * f3);
      mScroller.startScroll(i, j, paramInt1, paramInt2, paramInt3);
      setDragState(2);
      return true;
      f1 = k / i3;
      break;
    }
  }
  
  private boolean isValidPointerForActionMove(int paramInt)
  {
    if (!isPointerDown(paramInt))
    {
      Log.e("ViewDragHelper", "Ignoring pointerId=" + paramInt + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
  }
  
  private void releaseViewForPointerUp()
  {
    mVelocityTracker.computeCurrentVelocity(1000, mMaxVelocity);
    dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId), mMinVelocity, mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId), mMinVelocity, mMaxVelocity));
  }
  
  private void reportNewEdgeDrags(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 1)) {
      j = 1;
    }
    int i = j;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 4)) {
      i = j | 0x4;
    }
    j = i;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 2)) {
      j = i | 0x2;
    }
    i = j;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 8)) {
      i = j | 0x8;
    }
    if (i != 0)
    {
      int[] arrayOfInt = mEdgeDragsInProgress;
      arrayOfInt[paramInt] |= i;
      mCallback.onEdgeDragStarted(i, paramInt);
    }
  }
  
  private void saveInitialMotion(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    if ((mInitialMotionX == null) || (mInitialMotionX.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (mInitialMotionX != null)
      {
        System.arraycopy(mInitialMotionX, 0, localObject, 0, mInitialMotionX.length);
        System.arraycopy(mInitialMotionY, 0, arrayOfFloat1, 0, mInitialMotionY.length);
        System.arraycopy(mLastMotionX, 0, arrayOfFloat2, 0, mLastMotionX.length);
        System.arraycopy(mLastMotionY, 0, arrayOfFloat3, 0, mLastMotionY.length);
        System.arraycopy(mInitialEdgesTouched, 0, arrayOfInt1, 0, mInitialEdgesTouched.length);
        System.arraycopy(mEdgeDragsInProgress, 0, arrayOfInt2, 0, mEdgeDragsInProgress.length);
        System.arraycopy(mEdgeDragsLocked, 0, arrayOfInt3, 0, mEdgeDragsLocked.length);
      }
      mInitialMotionX = ((float[])localObject);
      mInitialMotionY = arrayOfFloat1;
      mLastMotionX = arrayOfFloat2;
      mLastMotionY = arrayOfFloat3;
      mInitialEdgesTouched = arrayOfInt1;
      mEdgeDragsInProgress = arrayOfInt2;
      mEdgeDragsLocked = arrayOfInt3;
    }
    Object localObject = mInitialMotionX;
    mLastMotionX[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = mInitialMotionY;
    mLastMotionY[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = mInitialEdgesTouched;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < mParentView.getLeft() + mEdgeSize) {
      j = 1;
    }
    int i = j;
    if (k < mParentView.getTop() + mEdgeSize) {
      i = j | 0x4;
    }
    j = i;
    if (m > mParentView.getRight() - mEdgeSize) {
      j = i | 0x2;
    }
    i = j;
    if (k > mParentView.getBottom() - mEdgeSize) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    mPointersDown |= 1 << paramInt;
  }
  
  private void saveLastMotion(MotionEvent paramMotionEvent)
  {
    int j = MotionEventCompat.getPointerCount(paramMotionEvent);
    int i = 0;
    while (i < j)
    {
      int k = MotionEventCompat.getPointerId(paramMotionEvent, i);
      float f1 = MotionEventCompat.getX(paramMotionEvent, i);
      float f2 = MotionEventCompat.getY(paramMotionEvent, i);
      mLastMotionX[k] = f1;
      mLastMotionY[k] = f2;
      i += 1;
    }
  }
  
  private boolean tryCaptureViewForDrag(View paramView, int paramInt)
  {
    if ((paramView == mCapturedView) && (mActivePointerId == paramInt)) {
      return true;
    }
    if ((paramView != null) && (mCallback.tryCaptureView(paramView, paramInt)))
    {
      mActivePointerId = paramInt;
      captureChildView(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public final void cancel()
  {
    mActivePointerId = -1;
    if (mInitialMotionX != null)
    {
      Arrays.fill(mInitialMotionX, 0.0F);
      Arrays.fill(mInitialMotionY, 0.0F);
      Arrays.fill(mLastMotionX, 0.0F);
      Arrays.fill(mLastMotionY, 0.0F);
      Arrays.fill(mInitialEdgesTouched, 0);
      Arrays.fill(mEdgeDragsInProgress, 0);
      Arrays.fill(mEdgeDragsLocked, 0);
      mPointersDown = 0;
    }
    if (mVelocityTracker != null)
    {
      mVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  public final void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() != mParentView) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + mParentView + ")");
    }
    mCapturedView = paramView;
    mActivePointerId = paramInt;
    mCallback.onViewCaptured(paramView, paramInt);
    setDragState(1);
  }
  
  public final boolean continueSettling$138603()
  {
    if (mDragState == 2)
    {
      boolean bool2 = mScroller.computeScrollOffset();
      int i = mScroller.getCurrX();
      int j = mScroller.getCurrY();
      int k = i - mCapturedView.getLeft();
      int m = j - mCapturedView.getTop();
      if (k != 0) {
        ViewCompat.offsetLeftAndRight(mCapturedView, k);
      }
      if (m != 0) {
        ViewCompat.offsetTopAndBottom(mCapturedView, m);
      }
      if ((k != 0) || (m != 0)) {
        mCallback.onViewPositionChanged(mCapturedView, i, j, k, m);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == mScroller.getFinalX())
        {
          bool1 = bool2;
          if (j == mScroller.getFinalY())
          {
            mScroller.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        mParentView.post(mSetIdleRunnable);
      }
    }
    return mDragState == 2;
  }
  
  public final View findTopChildUnder(int paramInt1, int paramInt2)
  {
    int i = mParentView.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = mParentView.getChildAt(mCallback.getOrderedChildIndex(i));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public final boolean isPointerDown(int paramInt)
  {
    return (mPointersDown & 1 << paramInt) != 0;
  }
  
  public final void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (j == 0) {
      cancel();
    }
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    float f2;
    int k;
    int m;
    int n;
    switch (j)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
      do
      {
        for (;;)
        {
          return;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
          saveInitialMotion(f1, f2, i);
          tryCaptureViewForDrag(paramMotionEvent, i);
          j = mInitialEdgesTouched[i];
          if ((mTrackingEdges & j) != 0)
          {
            mCallback.onEdgeTouched(mTrackingEdges & j, i);
            return;
            j = MotionEventCompat.getPointerId(paramMotionEvent, i);
            f1 = MotionEventCompat.getX(paramMotionEvent, i);
            f2 = MotionEventCompat.getY(paramMotionEvent, i);
            saveInitialMotion(f1, f2, j);
            if (mDragState == 0)
            {
              tryCaptureViewForDrag(findTopChildUnder((int)f1, (int)f2), j);
              i = mInitialEdgesTouched[j];
              if ((mTrackingEdges & i) != 0) {
                mCallback.onEdgeTouched(mTrackingEdges & i, j);
              }
            }
            else
            {
              i = (int)f1;
              k = (int)f2;
              paramMotionEvent = mCapturedView;
              if ((paramMotionEvent != null) && (i >= paramMotionEvent.getLeft()) && (i < paramMotionEvent.getRight()) && (k >= paramMotionEvent.getTop()) && (k < paramMotionEvent.getBottom())) {}
              for (i = 1; i != 0; i = 0)
              {
                tryCaptureViewForDrag(mCapturedView, j);
                return;
              }
            }
          }
        }
        if (mDragState != 1) {
          break;
        }
      } while (!isValidPointerForActionMove(mActivePointerId));
      i = MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId);
      f1 = MotionEventCompat.getX(paramMotionEvent, i);
      f2 = MotionEventCompat.getY(paramMotionEvent, i);
      m = (int)(f1 - mLastMotionX[mActivePointerId]);
      n = (int)(f2 - mLastMotionY[mActivePointerId]);
      j = mCapturedView.getLeft() + m;
      k = mCapturedView.getTop() + n;
      int i1 = mCapturedView.getLeft();
      int i2 = mCapturedView.getTop();
      i = j;
      if (m != 0)
      {
        i = mCallback.clampViewPositionHorizontal(mCapturedView, j, m);
        ViewCompat.offsetLeftAndRight(mCapturedView, i - i1);
      }
      j = k;
      if (n != 0)
      {
        j = mCallback.clampViewPositionVertical(mCapturedView, k, n);
        ViewCompat.offsetTopAndBottom(mCapturedView, j - i2);
      }
      if ((m != 0) || (n != 0)) {
        mCallback.onViewPositionChanged(mCapturedView, i, j, i - i1, j - i2);
      }
      saveLastMotion(paramMotionEvent);
      return;
      j = MotionEventCompat.getPointerCount(paramMotionEvent);
      i = 0;
      while (i < j)
      {
        k = MotionEventCompat.getPointerId(paramMotionEvent, i);
        if (isValidPointerForActionMove(k))
        {
          f1 = MotionEventCompat.getX(paramMotionEvent, i);
          f2 = MotionEventCompat.getY(paramMotionEvent, i);
          float f3 = f1 - mInitialMotionX[k];
          float f4 = f2 - mInitialMotionY[k];
          reportNewEdgeDrags(f3, f4, k);
          if (mDragState == 1) {
            break;
          }
          View localView = findTopChildUnder((int)f1, (int)f2);
          if ((checkTouchSlop(localView, f3, f4)) && (tryCaptureViewForDrag(localView, k))) {
            break;
          }
        }
        i += 1;
      }
      saveLastMotion(paramMotionEvent);
      return;
    case 6: 
      m = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if ((mDragState == 1) && (m == mActivePointerId))
      {
        k = -1;
        n = MotionEventCompat.getPointerCount(paramMotionEvent);
        i = 0;
      }
      for (;;)
      {
        j = k;
        if (i < n)
        {
          j = MotionEventCompat.getPointerId(paramMotionEvent, i);
          if (j != mActivePointerId)
          {
            f1 = MotionEventCompat.getX(paramMotionEvent, i);
            f2 = MotionEventCompat.getY(paramMotionEvent, i);
            if ((findTopChildUnder((int)f1, (int)f2) == mCapturedView) && (tryCaptureViewForDrag(mCapturedView, j))) {
              j = mActivePointerId;
            }
          }
        }
        else
        {
          if (j == -1) {
            releaseViewForPointerUp();
          }
          clearMotionHistory(m);
          return;
        }
        i += 1;
      }
    case 1: 
      if (mDragState == 1) {
        releaseViewForPointerUp();
      }
      cancel();
      return;
    }
    if (mDragState == 1) {
      dispatchViewReleased(0.0F, 0.0F);
    }
    cancel();
  }
  
  final void setDragState(int paramInt)
  {
    mParentView.removeCallbacks(mSetIdleRunnable);
    if (mDragState != paramInt)
    {
      mDragState = paramInt;
      mCallback.onViewDragStateChanged(paramInt);
      if (mDragState == 0) {
        mCapturedView = null;
      }
    }
  }
  
  public final boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (!mReleaseInProgress) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return forceSettleCapturedViewAt(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId));
  }
  
  public final boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (j == 0) {
      cancel();
    }
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    switch (j)
    {
    }
    while (mDragState == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      saveInitialMotion(f1, f2, i);
      paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
      if ((paramMotionEvent == mCapturedView) && (mDragState == 2)) {
        tryCaptureViewForDrag(paramMotionEvent, i);
      }
      j = mInitialEdgesTouched[i];
      if ((mTrackingEdges & j) != 0)
      {
        mCallback.onEdgeTouched(mTrackingEdges & j, i);
        continue;
        j = MotionEventCompat.getPointerId(paramMotionEvent, i);
        f1 = MotionEventCompat.getX(paramMotionEvent, i);
        f2 = MotionEventCompat.getY(paramMotionEvent, i);
        saveInitialMotion(f1, f2, j);
        if (mDragState == 0)
        {
          i = mInitialEdgesTouched[j];
          if ((mTrackingEdges & i) != 0) {
            mCallback.onEdgeTouched(mTrackingEdges & i, j);
          }
        }
        else if (mDragState == 2)
        {
          paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
          if (paramMotionEvent == mCapturedView)
          {
            tryCaptureViewForDrag(paramMotionEvent, j);
            continue;
            if ((mInitialMotionX != null) && (mInitialMotionY != null))
            {
              int k = MotionEventCompat.getPointerCount(paramMotionEvent);
              i = 0;
              if (i < k)
              {
                int m = MotionEventCompat.getPointerId(paramMotionEvent, i);
                float f3;
                float f4;
                View localView;
                if (isValidPointerForActionMove(m))
                {
                  f1 = MotionEventCompat.getX(paramMotionEvent, i);
                  f2 = MotionEventCompat.getY(paramMotionEvent, i);
                  f3 = f1 - mInitialMotionX[m];
                  f4 = f2 - mInitialMotionY[m];
                  localView = findTopChildUnder((int)f1, (int)f2);
                  if ((localView == null) || (!checkTouchSlop(localView, f3, f4))) {
                    break label585;
                  }
                }
                label585:
                for (j = 1;; j = 0)
                {
                  if (j != 0)
                  {
                    int n = localView.getLeft();
                    int i1 = (int)f3;
                    i1 = mCallback.clampViewPositionHorizontal(localView, n + i1, (int)f3);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = mCallback.clampViewPositionVertical(localView, i2 + i3, (int)f4);
                    int i4 = mCallback.getViewHorizontalDragRange(localView);
                    int i5 = mCallback.getViewVerticalDragRange(localView);
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label591;
                    }
                  }
                  reportNewEdgeDrags(f3, f4, m);
                  if ((mDragState == 1) || ((j != 0) && (tryCaptureViewForDrag(localView, m)))) {
                    break label591;
                  }
                  i += 1;
                  break;
                }
              }
              label591:
              saveLastMotion(paramMotionEvent);
              continue;
              clearMotionHistory(MotionEventCompat.getPointerId(paramMotionEvent, i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    mCapturedView = paramView;
    mActivePointerId = -1;
    boolean bool = forceSettleCapturedViewAt(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (mDragState == 0) && (mCapturedView != null)) {
      mCapturedView = null;
    }
    return bool;
  }
  
  public static abstract class Callback
  {
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int getOrderedChildIndex(int paramInt)
    {
      return paramInt;
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return 0;
    }
    
    public int getViewVerticalDragRange(View paramView)
    {
      return 0;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2) {}
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2) {}
    
    public void onViewCaptured(View paramView, int paramInt) {}
    
    public void onViewDragStateChanged(int paramInt) {}
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean tryCaptureView(View paramView, int paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.ViewDragHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */