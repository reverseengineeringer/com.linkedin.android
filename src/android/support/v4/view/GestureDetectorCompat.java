package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat
{
  private final GestureDetectorCompatImpl mImpl;
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, (byte)0);
  }
  
  private GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, byte paramByte)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      mImpl = new GestureDetectorCompatImplJellybeanMr2(paramContext, paramOnGestureListener);
      return;
    }
    mImpl = new GestureDetectorCompatImplBase(paramContext, paramOnGestureListener);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return mImpl.onTouchEvent(paramMotionEvent);
  }
  
  static abstract interface GestureDetectorCompatImpl
  {
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  }
  
  static final class GestureDetectorCompatImplBase
    implements GestureDetectorCompat.GestureDetectorCompatImpl
  {
    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    private static final int LONGPRESS_TIMEOUT = ;
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    private MotionEvent mCurrentDownEvent;
    private boolean mDeferConfirmSingleTap;
    private GestureDetector.OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler = new GestureHandler();
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    private final GestureDetector.OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    private boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;
    
    public GestureDetectorCompatImplBase(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      mListener = paramOnGestureListener;
      if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
        mDoubleTapListener = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("Context must not be null");
      }
      if (mListener == null) {
        throw new IllegalArgumentException("OnGestureListener must not be null");
      }
      mIsLongpressEnabled = true;
      paramContext = ViewConfiguration.get(paramContext);
      int i = paramContext.getScaledTouchSlop();
      int j = paramContext.getScaledDoubleTapSlop();
      mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
      mMaximumFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
      mTouchSlopSquare = (i * i);
      mDoubleTapSlopSquare = (j * j);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i1 = paramMotionEvent.getAction();
      if (mVelocityTracker == null) {
        mVelocityTracker = VelocityTracker.obtain();
      }
      mVelocityTracker.addMovement(paramMotionEvent);
      int i;
      if ((i1 & 0xFF) == 6)
      {
        i = 1;
        if (i == 0) {
          break label128;
        }
      }
      float f3;
      float f1;
      int n;
      int m;
      float f4;
      float f2;
      label128:
      for (int k = MotionEventCompat.getActionIndex(paramMotionEvent);; k = -1)
      {
        f3 = 0.0F;
        f1 = 0.0F;
        n = MotionEventCompat.getPointerCount(paramMotionEvent);
        m = 0;
        while (m < n)
        {
          f4 = f3;
          f2 = f1;
          if (k != m)
          {
            f4 = f3 + MotionEventCompat.getX(paramMotionEvent, m);
            f2 = f1 + MotionEventCompat.getY(paramMotionEvent, m);
          }
          m += 1;
          f3 = f4;
          f1 = f2;
        }
        i = 0;
        break;
      }
      boolean bool4;
      boolean bool5;
      boolean bool2;
      boolean bool3;
      if (i != 0)
      {
        i = n - 1;
        f2 = f3 / i;
        f1 /= i;
        k = 0;
        bool4 = false;
        bool5 = false;
        bool2 = false;
        bool3 = bool2;
        switch (i1 & 0xFF)
        {
        default: 
          bool3 = bool2;
        }
      }
      label784:
      label790:
      label988:
      label1012:
      do
      {
        Object localObject;
        int j;
        do
        {
          do
          {
            do
            {
              do
              {
                return bool3;
                i = n;
                break;
                mLastFocusX = f2;
                mDownFocusX = f2;
                mLastFocusY = f1;
                mDownFocusY = f1;
                mHandler.removeMessages(1);
                mHandler.removeMessages(2);
                mHandler.removeMessages(3);
                mIsDoubleTapping = false;
                mAlwaysInTapRegion = false;
                mAlwaysInBiggerTapRegion = false;
                mDeferConfirmSingleTap = false;
                bool3 = bool2;
              } while (!mInLongPress);
              mInLongPress = false;
              return false;
              mLastFocusX = f2;
              mDownFocusX = f2;
              mLastFocusY = f1;
              mDownFocusY = f1;
              mVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
              k = MotionEventCompat.getActionIndex(paramMotionEvent);
              i = MotionEventCompat.getPointerId(paramMotionEvent, k);
              f1 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, i);
              f2 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, i);
              i = 0;
              for (;;)
              {
                bool3 = bool2;
                if (i >= n) {
                  break;
                }
                if (i != k)
                {
                  m = MotionEventCompat.getPointerId(paramMotionEvent, i);
                  if (f1 * VelocityTrackerCompat.getXVelocity(mVelocityTracker, m) + f2 * VelocityTrackerCompat.getYVelocity(mVelocityTracker, m) < 0.0F)
                  {
                    mVelocityTracker.clear();
                    return false;
                  }
                }
                i += 1;
              }
              i = k;
              if (mDoubleTapListener != null)
              {
                bool2 = mHandler.hasMessages(3);
                if (bool2) {
                  mHandler.removeMessages(3);
                }
                if ((mCurrentDownEvent == null) || (mPreviousUpEvent == null) || (!bool2)) {
                  break label790;
                }
                localMotionEvent = mCurrentDownEvent;
                localObject = mPreviousUpEvent;
                if ((!mAlwaysInBiggerTapRegion) || (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() > DOUBLE_TAP_TIMEOUT)) {
                  break label784;
                }
                i = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
                m = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
                if (m * m + i * i >= mDoubleTapSlopSquare) {
                  break label784;
                }
                i = 1;
                if (i == 0) {
                  break label790;
                }
                mIsDoubleTapping = true;
              }
              for (boolean bool1 = mDoubleTapListener.onDoubleTap(mCurrentDownEvent) | false | mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);; bool1 = k)
              {
                mLastFocusX = f2;
                mDownFocusX = f2;
                mLastFocusY = f1;
                mDownFocusY = f1;
                if (mCurrentDownEvent != null) {
                  mCurrentDownEvent.recycle();
                }
                mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
                mAlwaysInTapRegion = true;
                mAlwaysInBiggerTapRegion = true;
                mStillDown = true;
                mInLongPress = false;
                mDeferConfirmSingleTap = false;
                if (mIsLongpressEnabled)
                {
                  mHandler.removeMessages(2);
                  mHandler.sendEmptyMessageAtTime(2, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
                }
                mHandler.sendEmptyMessageAtTime(1, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                return bool1 | mListener.onDown(paramMotionEvent);
                bool1 = false;
                break;
                mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
              }
              bool3 = bool2;
            } while (mInLongPress);
            f3 = mLastFocusX - f2;
            f4 = mLastFocusY - f1;
            if (mIsDoubleTapping) {
              return mDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
            }
            if (!mAlwaysInTapRegion) {
              break label988;
            }
            j = (int)(f2 - mDownFocusX);
            k = (int)(f1 - mDownFocusY);
            j = j * j + k * k;
            bool2 = bool4;
            if (j > mTouchSlopSquare)
            {
              bool2 = mListener.onScroll(mCurrentDownEvent, paramMotionEvent, f3, f4);
              mLastFocusX = f2;
              mLastFocusY = f1;
              mAlwaysInTapRegion = false;
              mHandler.removeMessages(3);
              mHandler.removeMessages(1);
              mHandler.removeMessages(2);
            }
            bool3 = bool2;
          } while (j <= mTouchSlopSquare);
          mAlwaysInBiggerTapRegion = false;
          return bool2;
          if (Math.abs(f3) >= 1.0F) {
            break label1012;
          }
          bool3 = bool2;
        } while (Math.abs(f4) < 1.0F);
        bool2 = mListener.onScroll(mCurrentDownEvent, paramMotionEvent, f3, f4);
        mLastFocusX = f2;
        mLastFocusY = f1;
        return bool2;
        mStillDown = false;
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (mIsDoubleTapping) {
          bool2 = mDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
        }
        for (;;)
        {
          if (mPreviousUpEvent != null) {
            mPreviousUpEvent.recycle();
          }
          mPreviousUpEvent = localMotionEvent;
          if (mVelocityTracker != null)
          {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
          }
          mIsDoubleTapping = false;
          mDeferConfirmSingleTap = false;
          mHandler.removeMessages(1);
          mHandler.removeMessages(2);
          return bool2;
          if (mInLongPress)
          {
            mHandler.removeMessages(3);
            mInLongPress = false;
            bool2 = bool5;
          }
          else if (mAlwaysInTapRegion)
          {
            bool3 = mListener.onSingleTapUp(paramMotionEvent);
            bool2 = bool3;
            if (mDeferConfirmSingleTap)
            {
              bool2 = bool3;
              if (mDoubleTapListener != null)
              {
                mDoubleTapListener.onSingleTapConfirmed(paramMotionEvent);
                bool2 = bool3;
              }
            }
          }
          else
          {
            localObject = mVelocityTracker;
            j = MotionEventCompat.getPointerId(paramMotionEvent, 0);
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, mMaximumFlingVelocity);
            f1 = VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, j);
            f2 = VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, j);
            if (Math.abs(f1) <= mMinimumFlingVelocity)
            {
              bool2 = bool5;
              if (Math.abs(f2) <= mMinimumFlingVelocity) {}
            }
            else
            {
              bool2 = mListener.onFling(mCurrentDownEvent, paramMotionEvent, f2, f1);
            }
          }
        }
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        mHandler.removeMessages(3);
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mIsDoubleTapping = false;
        mStillDown = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        mDeferConfirmSingleTap = false;
        bool3 = bool2;
      } while (!mInLongPress);
      mInLongPress = false;
      return false;
    }
    
    private final class GestureHandler
      extends Handler
    {
      GestureHandler() {}
      
      public final void handleMessage(Message paramMessage)
      {
        switch (what)
        {
        default: 
          throw new RuntimeException("Unknown message " + paramMessage);
        case 1: 
          mListener.onShowPress(mCurrentDownEvent);
        }
        do
        {
          return;
          GestureDetectorCompat.GestureDetectorCompatImplBase.access$200(GestureDetectorCompat.GestureDetectorCompatImplBase.this);
          return;
        } while (mDoubleTapListener == null);
        if (!mStillDown)
        {
          mDoubleTapListener.onSingleTapConfirmed(mCurrentDownEvent);
          return;
        }
        GestureDetectorCompat.GestureDetectorCompatImplBase.access$502$5abea42(GestureDetectorCompat.GestureDetectorCompatImplBase.this);
      }
    }
  }
  
  static final class GestureDetectorCompatImplJellybeanMr2
    implements GestureDetectorCompat.GestureDetectorCompatImpl
  {
    private final GestureDetector mDetector;
    
    public GestureDetectorCompatImplJellybeanMr2(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      mDetector = new GestureDetector(paramContext, paramOnGestureListener, null);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return mDetector.onTouchEvent(paramMotionEvent);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.GestureDetectorCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */