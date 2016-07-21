package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

public class SwipeRefreshLayout
  extends ViewGroup
  implements NestedScrollingChild, NestedScrollingParent
{
  private static final int[] LAYOUT_ATTRS = { 16842766 };
  private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
  private int mActivePointerId = -1;
  private Animation mAlphaMaxAnimation;
  private Animation mAlphaStartAnimation;
  private final Animation mAnimateToCorrectPosition = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      if (!mUsingCustomStart) {}
      for (int i = (int)(mSpinnerFinalOffset - Math.abs(mOriginalOffsetTop));; i = (int)mSpinnerFinalOffset)
      {
        int j = mFrom;
        i = (int)((i - mFrom) * paramAnonymousFloat);
        int k = mCircleView.getTop();
        SwipeRefreshLayout.access$1200$1c3468b0(SwipeRefreshLayout.this, j + i - k);
        mProgress.setArrowScale(1.0F - paramAnonymousFloat);
        return;
      }
    }
  };
  private final Animation mAnimateToStartPosition = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(paramAnonymousFloat);
    }
  };
  private int mCircleHeight;
  private CircleImageView mCircleView;
  private int mCircleViewIndex = -1;
  private int mCircleWidth;
  private int mCurrentTargetOffsetTop;
  private final DecelerateInterpolator mDecelerateInterpolator;
  protected int mFrom;
  private float mInitialDownY;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private OnRefreshListener mListener;
  private int mMediumAnimationDuration;
  private boolean mNestedScrollInProgress;
  private final NestedScrollingChildHelper mNestedScrollingChildHelper;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper;
  private boolean mNotify;
  private boolean mOriginalOffsetCalculated = false;
  protected int mOriginalOffsetTop;
  private final int[] mParentOffsetInWindow = new int[2];
  private final int[] mParentScrollConsumed = new int[2];
  private MaterialProgressDrawable mProgress;
  private Animation.AnimationListener mRefreshListener = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (mRefreshing)
      {
        mProgress.setAlpha(255);
        mProgress.start();
        if ((mNotify) && (mListener != null)) {
          mListener.onRefresh();
        }
        SwipeRefreshLayout.access$402(SwipeRefreshLayout.this, mCircleView.getTop());
        return;
      }
      SwipeRefreshLayout.this.reset();
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public final void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  public boolean mRefreshing = false;
  private boolean mReturningToStart;
  private boolean mScale;
  private Animation mScaleAnimation;
  private Animation mScaleDownAnimation;
  private Animation mScaleDownToStartAnimation;
  private float mSpinnerFinalOffset;
  private float mStartingScale;
  private View mTarget;
  private float mTotalDragDistance = -1.0F;
  private float mTotalUnconsumed;
  private int mTouchSlop;
  private boolean mUsingCustomStart;
  
  public SwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
    paramContext = getResources().getDisplayMetrics();
    mCircleWidth = ((int)(density * 40.0F));
    mCircleHeight = ((int)(density * 40.0F));
    mCircleView = new CircleImageView(getContext());
    mProgress = new MaterialProgressDrawable(getContext(), this);
    mProgress.setBackgroundColor(-328966);
    mCircleView.setImageDrawable(mProgress);
    mCircleView.setVisibility(8);
    addView(mCircleView);
    ViewCompat.setChildrenDrawingOrderEnabled$4d3af60(this);
    mSpinnerFinalOffset = (64.0F * density);
    mTotalDragDistance = mSpinnerFinalOffset;
    mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
  }
  
  private boolean canChildScrollUp()
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      if ((mTarget instanceof AbsListView))
      {
        localAbsListView = (AbsListView)mTarget;
        if ((localAbsListView.getChildCount() <= 0) || ((localAbsListView.getFirstVisiblePosition() <= 0) && (localAbsListView.getChildAt(0).getTop() >= localAbsListView.getPaddingTop()))) {}
      }
      while ((ViewCompat.canScrollVertically(mTarget, -1)) || (mTarget.getScrollY() > 0))
      {
        AbsListView localAbsListView;
        return true;
        return false;
      }
      return false;
    }
    return ViewCompat.canScrollVertically(mTarget, -1);
  }
  
  private void ensureTarget()
  {
    int i;
    if (mTarget == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(mCircleView)) {
          mTarget = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void finishSpinner(float paramFloat)
  {
    if (paramFloat > mTotalDragDistance)
    {
      setRefreshing(true, true);
      return;
    }
    mRefreshing = false;
    mProgress.setStartEndTrim$2548a35(0.0F);
    Animation.AnimationListener local5 = null;
    if (!mScale) {
      local5 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!mScale) {
            SwipeRefreshLayout.access$900$63412af5(SwipeRefreshLayout.this);
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    int i = mCurrentTargetOffsetTop;
    if (mScale)
    {
      mFrom = i;
      if (isAlphaUsedForScale())
      {
        mStartingScale = mProgress.getAlpha();
        mScaleDownToStartAnimation = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            float f1 = mStartingScale;
            float f2 = -mStartingScale;
            SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramAnonymousFloat);
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(paramAnonymousFloat);
          }
        };
        mScaleDownToStartAnimation.setDuration(150L);
        if (local5 != null) {
          mCircleView.mListener = local5;
        }
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mScaleDownToStartAnimation);
      }
    }
    for (;;)
    {
      mProgress.showArrow(false);
      return;
      mStartingScale = ViewCompat.getScaleX(mCircleView);
      break;
      mFrom = i;
      mAnimateToStartPosition.reset();
      mAnimateToStartPosition.setDuration(200L);
      mAnimateToStartPosition.setInterpolator(mDecelerateInterpolator);
      if (local5 != null) {
        mCircleView.mListener = local5;
      }
      mCircleView.clearAnimation();
      mCircleView.startAnimation(mAnimateToStartPosition);
    }
  }
  
  private static float getMotionEventY(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getY(paramMotionEvent, paramInt);
  }
  
  private static boolean isAlphaUsedForScale()
  {
    return Build.VERSION.SDK_INT < 11;
  }
  
  private static boolean isAnimationRunning(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void moveSpinner(float paramFloat)
  {
    mProgress.showArrow(true);
    float f2 = Math.min(1.0F, Math.abs(paramFloat / mTotalDragDistance));
    float f3 = (float)Math.max(f2 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = mTotalDragDistance;
    float f1;
    int i;
    int j;
    if (mUsingCustomStart)
    {
      f1 = mSpinnerFinalOffset - mOriginalOffsetTop;
      f4 = Math.max(0.0F, Math.min(f4 - f5, 2.0F * f1) / f1);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = mOriginalOffsetTop;
      j = (int)(f1 * f2 + f1 * f4 * 2.0F);
      if (mCircleView.getVisibility() != 0) {
        mCircleView.setVisibility(0);
      }
      if (!mScale)
      {
        ViewCompat.setScaleX(mCircleView, 1.0F);
        ViewCompat.setScaleY(mCircleView, 1.0F);
      }
      if (mScale) {
        setAnimationProgress(Math.min(1.0F, paramFloat / mTotalDragDistance));
      }
      if (paramFloat >= mTotalDragDistance) {
        break label332;
      }
      if ((mProgress.getAlpha() > 76) && (!isAnimationRunning(mAlphaStartAnimation))) {
        mAlphaStartAnimation = startAlphaAnimation(mProgress.getAlpha(), 76);
      }
    }
    for (;;)
    {
      mProgress.setStartEndTrim$2548a35(Math.min(0.8F, f3 * 0.8F));
      mProgress.setArrowScale(Math.min(1.0F, f3));
      mProgress.mRing.setRotation((-0.25F + 0.4F * f3 + 2.0F * f4) * 0.5F);
      setTargetOffsetTopAndBottom(i + j - mCurrentTargetOffsetTop, true);
      return;
      f1 = mSpinnerFinalOffset;
      break;
      label332:
      if ((mProgress.getAlpha() < 255) && (!isAnimationRunning(mAlphaMaxAnimation))) {
        mAlphaMaxAnimation = startAlphaAnimation(mProgress.getAlpha(), 255);
      }
    }
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == mActivePointerId) {
      if (i != 0) {
        break label33;
      }
    }
    label33:
    for (i = 1;; i = 0)
    {
      mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      return;
    }
  }
  
  private void reset()
  {
    mCircleView.clearAnimation();
    mProgress.stop();
    mCircleView.setVisibility(8);
    setColorViewAlpha(255);
    if (mScale) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      mCurrentTargetOffsetTop = mCircleView.getTop();
      return;
      setTargetOffsetTopAndBottom(mOriginalOffsetTop - mCurrentTargetOffsetTop, true);
    }
  }
  
  private void setAnimationProgress(float paramFloat)
  {
    if (isAlphaUsedForScale())
    {
      setColorViewAlpha((int)(255.0F * paramFloat));
      return;
    }
    ViewCompat.setScaleX(mCircleView, paramFloat);
    ViewCompat.setScaleY(mCircleView, paramFloat);
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    mCircleView.getBackground().setAlpha(paramInt);
    mProgress.setAlpha(paramInt);
  }
  
  private void setRefreshing(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mRefreshing != paramBoolean1)
    {
      mNotify = paramBoolean2;
      ensureTarget();
      mRefreshing = paramBoolean1;
      if (mRefreshing)
      {
        int i = mCurrentTargetOffsetTop;
        Animation.AnimationListener localAnimationListener = mRefreshListener;
        mFrom = i;
        mAnimateToCorrectPosition.reset();
        mAnimateToCorrectPosition.setDuration(200L);
        mAnimateToCorrectPosition.setInterpolator(mDecelerateInterpolator);
        if (localAnimationListener != null) {
          mCircleView.mListener = localAnimationListener;
        }
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mAnimateToCorrectPosition);
      }
    }
    else
    {
      return;
    }
    startScaleDownAnimation(mRefreshListener);
  }
  
  private void setTargetOffsetTopAndBottom(int paramInt, boolean paramBoolean)
  {
    mCircleView.bringToFront();
    mCircleView.offsetTopAndBottom(paramInt);
    mCurrentTargetOffsetTop = mCircleView.getTop();
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 11)) {
      invalidate();
    }
  }
  
  private Animation startAlphaAnimation(final int paramInt1, final int paramInt2)
  {
    if ((mScale) && (isAlphaUsedForScale())) {
      return null;
    }
    Animation local4 = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        mProgress.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
      }
    };
    local4.setDuration(300L);
    mCircleView.mListener = null;
    mCircleView.clearAnimation();
    mCircleView.startAnimation(local4);
    return local4;
  }
  
  private void startScaleDownAnimation(Animation.AnimationListener paramAnimationListener)
  {
    mScaleDownAnimation = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
      }
    };
    mScaleDownAnimation.setDuration(150L);
    mCircleView.mListener = paramAnimationListener;
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mScaleDownAnimation);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return mNestedScrollingChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return mNestedScrollingChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return mNestedScrollingChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return mNestedScrollingChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (mCircleViewIndex < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return mCircleViewIndex;
      }
    } while (paramInt2 < mCircleViewIndex);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return mNestedScrollingParentHelper.mNestedScrollAxes;
  }
  
  public int getProgressCircleDiameter()
  {
    if (mCircleView != null) {
      return mCircleView.getMeasuredHeight();
    }
    return 0;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return mNestedScrollingChildHelper.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return mNestedScrollingChildHelper.mIsNestedScrollingEnabled;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ensureTarget();
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((mReturningToStart) && (i == 0)) {
      mReturningToStart = false;
    }
    if ((!isEnabled()) || (mReturningToStart) || (canChildScrollUp()) || (mRefreshing) || (mNestedScrollInProgress)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return mIsBeingDragged;
      setTargetOffsetTopAndBottom(mOriginalOffsetTop - mCircleView.getTop(), true);
      mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      mIsBeingDragged = false;
      float f = getMotionEventY(paramMotionEvent, mActivePointerId);
      if (f == -1.0F) {
        break;
      }
      mInitialDownY = f;
      continue;
      if (mActivePointerId == -1)
      {
        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
      }
      f = getMotionEventY(paramMotionEvent, mActivePointerId);
      if (f == -1.0F) {
        break;
      }
      if ((f - mInitialDownY > mTouchSlop) && (!mIsBeingDragged))
      {
        mInitialMotionY = (mInitialDownY + mTouchSlop);
        mIsBeingDragged = true;
        mProgress.setAlpha(76);
        continue;
        onSecondaryPointerUp(paramMotionEvent);
        continue;
        mIsBeingDragged = false;
        mActivePointerId = -1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {}
    do
    {
      return;
      if (mTarget == null) {
        ensureTarget();
      }
    } while (mTarget == null);
    View localView = mTarget;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt3 + (paramInt1 - getPaddingLeft() - getPaddingRight()), paramInt4 + (paramInt2 - getPaddingTop() - getPaddingBottom()));
    paramInt2 = mCircleView.getMeasuredWidth();
    paramInt3 = mCircleView.getMeasuredHeight();
    mCircleView.layout(paramInt1 / 2 - paramInt2 / 2, mCurrentTargetOffsetTop, paramInt1 / 2 + paramInt2 / 2, mCurrentTargetOffsetTop + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (mTarget == null) {
      ensureTarget();
    }
    if (mTarget == null) {}
    for (;;)
    {
      return;
      mTarget.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      mCircleView.measure(View.MeasureSpec.makeMeasureSpec(mCircleWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(mCircleHeight, 1073741824));
      if ((!mUsingCustomStart) && (!mOriginalOffsetCalculated))
      {
        mOriginalOffsetCalculated = true;
        paramInt1 = -mCircleView.getMeasuredHeight();
        mOriginalOffsetTop = paramInt1;
        mCurrentTargetOffsetTop = paramInt1;
      }
      mCircleViewIndex = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == mCircleView)
        {
          mCircleViewIndex = paramInt1;
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramInt2 > 0) && (mTotalUnconsumed > 0.0F))
    {
      if (paramInt2 <= mTotalUnconsumed) {
        break label139;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)mTotalUnconsumed);
      mTotalUnconsumed = 0.0F;
    }
    for (;;)
    {
      moveSpinner(mTotalUnconsumed);
      if ((mUsingCustomStart) && (paramInt2 > 0) && (mTotalUnconsumed == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        mCircleView.setVisibility(8);
      }
      paramView = mParentScrollConsumed;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramArrayOfInt[1] += paramView[1];
      }
      return;
      label139:
      mTotalUnconsumed -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, mParentOffsetInWindow);
    paramInt1 = paramInt4 + mParentOffsetInWindow[1];
    if ((paramInt1 < 0) && (!canChildScrollUp()))
    {
      mTotalUnconsumed += Math.abs(paramInt1);
      moveSpinner(mTotalUnconsumed);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    mNestedScrollingParentHelper.mNestedScrollAxes = paramInt;
    startNestedScroll(paramInt & 0x2);
    mTotalUnconsumed = 0.0F;
    mNestedScrollInProgress = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!mReturningToStart) && (!mRefreshing) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    mNestedScrollingParentHelper.mNestedScrollAxes = 0;
    mNestedScrollInProgress = false;
    if (mTotalUnconsumed > 0.0F)
    {
      finishSpinner(mTotalUnconsumed);
      mTotalUnconsumed = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((mReturningToStart) && (i == 0)) {
      mReturningToStart = false;
    }
    if ((!isEnabled()) || (mReturningToStart) || (canChildScrollUp()) || (mNestedScrollInProgress)) {
      return false;
    }
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      for (;;)
      {
        return true;
        mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        mIsBeingDragged = false;
        continue;
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId);
        if (i < 0)
        {
          Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
          return false;
        }
        f1 = (MotionEventCompat.getY(paramMotionEvent, i) - mInitialMotionY) * 0.5F;
        if (mIsBeingDragged)
        {
          if (f1 <= 0.0F) {
            break;
          }
          moveSpinner(f1);
          continue;
          i = MotionEventCompat.getActionIndex(paramMotionEvent);
          if (i < 0)
          {
            Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
            return false;
          }
          mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
    i = MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId);
    if (i < 0)
    {
      Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
      return false;
    }
    float f1 = MotionEventCompat.getY(paramMotionEvent, i);
    float f2 = mInitialMotionY;
    mIsBeingDragged = false;
    finishSpinner((f1 - f2) * 0.5F);
    mActivePointerId = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (((Build.VERSION.SDK_INT >= 21) || (!(mTarget instanceof AbsListView))) && ((mTarget == null) || (ViewCompat.isNestedScrollingEnabled(mTarget)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    ensureTarget();
    MaterialProgressDrawable localMaterialProgressDrawable = mProgress;
    mRing.setColors(paramVarArgs);
    mRing.setColorIndex(0);
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Resources localResources = getResources();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = localResources.getColor(paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    mTotalDragDistance = paramInt;
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    mNestedScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    mListener = paramOnRefreshListener;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    mCircleView.setBackgroundColor(paramInt);
    mProgress.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(getResources().getColor(paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (mRefreshing != paramBoolean))
    {
      mRefreshing = paramBoolean;
      if (!mUsingCustomStart) {}
      for (int i = (int)(mSpinnerFinalOffset + mOriginalOffsetTop);; i = (int)mSpinnerFinalOffset)
      {
        setTargetOffsetTopAndBottom(i - mCurrentTargetOffsetTop, true);
        mNotify = false;
        Animation.AnimationListener localAnimationListener = mRefreshListener;
        mCircleView.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
          mProgress.setAlpha(255);
        }
        mScaleAnimation = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            SwipeRefreshLayout.this.setAnimationProgress(paramAnonymousFloat);
          }
        };
        mScaleAnimation.setDuration(mMediumAnimationDuration);
        if (localAnimationListener != null) {
          mCircleView.mListener = localAnimationListener;
        }
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mScaleAnimation);
        return;
      }
    }
    setRefreshing(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i;
    if (paramInt == 0)
    {
      i = (int)(56.0F * density);
      mCircleWidth = i;
    }
    for (mCircleHeight = i;; mCircleHeight = i)
    {
      mCircleView.setImageDrawable(null);
      mProgress.updateSizes(paramInt);
      mCircleView.setImageDrawable(mProgress);
      return;
      i = (int)(40.0F * density);
      mCircleWidth = i;
    }
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return mNestedScrollingChildHelper.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    mNestedScrollingChildHelper.stopNestedScroll();
  }
  
  public static abstract interface OnRefreshListener
  {
    public abstract void onRefresh();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */