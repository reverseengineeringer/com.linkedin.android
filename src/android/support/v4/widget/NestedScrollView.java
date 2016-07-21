package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat.AccessibilityRecordImpl;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements NestedScrollingChild, NestedScrollingParent, ScrollingView
{
  private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
  private static final int[] SCROLLVIEW_STYLEABLE = { 16843130 };
  private int mActivePointerId = -1;
  private final NestedScrollingChildHelper mChildHelper;
  private View mChildToScrollTo = null;
  private EdgeEffectCompat mEdgeGlowBottom;
  private EdgeEffectCompat mEdgeGlowTop;
  private boolean mFillViewport;
  private boolean mIsBeingDragged = false;
  private boolean mIsLaidOut = false;
  private boolean mIsLayoutDirty = true;
  private int mLastMotionY;
  private long mLastScroll;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private int mNestedYOffset;
  private OnScrollChangeListener mOnScrollChangeListener;
  private final NestedScrollingParentHelper mParentHelper;
  private SavedState mSavedState;
  private final int[] mScrollConsumed = new int[2];
  private final int[] mScrollOffset = new int[2];
  private ScrollerCompat mScroller = ScrollerCompat.create(getContext(), null);
  private boolean mSmoothScrollingEnabled = true;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private float mVerticalScrollFactor;
  
  public NestedScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, SCROLLVIEW_STYLEABLE, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    mParentHelper = new NestedScrollingParentHelper(this);
    mChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
  }
  
  private boolean arrowScroll(int paramInt)
  {
    boolean bool = false;
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int k = getMaxScrollAmount();
    if ((localView2 != null) && (isWithinDeltaOfScreen(localView2, k, getHeight())))
    {
      localView2.getDrawingRect(mTempRect);
      offsetDescendantRectToMyCoords(localView2, mTempRect);
      doScrollY(computeScrollDeltaToGetChildRectOnScreen(mTempRect));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (isOffScreen(localView1)))
      {
        paramInt = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(paramInt);
      }
      bool = true;
      label144:
      return bool;
    }
    int j = k;
    int i;
    if ((paramInt == 33) && (getScrollY() < j))
    {
      i = getScrollY();
      label169:
      if (i == 0) {
        break label251;
      }
      if (paramInt != 130) {
        break label253;
      }
    }
    for (;;)
    {
      doScrollY(i);
      break;
      i = j;
      if (paramInt != 130) {
        break label169;
      }
      i = j;
      if (getChildCount() <= 0) {
        break label169;
      }
      int m = getChildAt(0).getBottom();
      int n = getScrollY() + getHeight() - getPaddingBottom();
      i = j;
      if (m - n >= k) {
        break label169;
      }
      i = m - n;
      break label169;
      label251:
      break label144;
      label253:
      i = -i;
    }
  }
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }
  
  private int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0) {}
    int m;
    int j;
    do
    {
      return 0;
      m = getHeight();
      i = getScrollY();
      int k = i + m;
      int n = getVerticalFadingEdgeLength();
      j = i;
      if (top > 0) {
        j = i + n;
      }
      i = k;
      if (bottom < getChildAt(0).getHeight()) {
        i = k - n;
      }
      if ((bottom > i) && (top > j))
      {
        if (paramRect.height() > m) {}
        for (j = top - j + 0;; j = bottom - i + 0) {
          return Math.min(j, getChildAt(0).getBottom() - i);
        }
      }
    } while ((top >= j) || (bottom >= i));
    if (paramRect.height() > m) {}
    for (int i = 0 - (i - bottom);; i = 0 - (j - top)) {
      return Math.max(i, -getScrollY());
    }
  }
  
  private void doScrollY(int paramInt)
  {
    if (paramInt != 0)
    {
      if (mSmoothScrollingEnabled) {
        smoothScrollBy(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private void endDrag()
  {
    mIsBeingDragged = false;
    recycleVelocityTracker();
    stopNestedScroll();
    if (mEdgeGlowTop != null)
    {
      mEdgeGlowTop.onRelease();
      mEdgeGlowBottom.onRelease();
    }
  }
  
  private void ensureGlows()
  {
    if (ViewCompat.getOverScrollMode(this) != 2)
    {
      if (mEdgeGlowTop == null)
      {
        Context localContext = getContext();
        mEdgeGlowTop = new EdgeEffectCompat(localContext);
        mEdgeGlowBottom = new EdgeEffectCompat(localContext);
      }
      return;
    }
    mEdgeGlowTop = null;
    mEdgeGlowBottom = null;
  }
  
  private void flingWithNestedDispatch(int paramInt)
  {
    int i = getScrollY();
    if (((i > 0) || (paramInt > 0)) && ((i < getScrollRange()) || (paramInt < 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!dispatchNestedPreFling(0.0F, paramInt))
      {
        dispatchNestedFling(0.0F, paramInt, bool);
        if ((bool) && (getChildCount() > 0))
        {
          int k = getHeight() - getPaddingBottom() - getPaddingTop();
          int m = getChildAt(0).getHeight();
          ScrollerCompat localScrollerCompat = mScroller;
          i = getScrollX();
          int j = getScrollY();
          m = Math.max(0, m - k);
          k /= 2;
          mImpl.fling$26e48b1(mScroller, i, j, paramInt, m, k);
          ViewCompat.postInvalidateOnAnimation(this);
        }
      }
      return;
    }
  }
  
  private boolean fullScroll(int paramInt)
  {
    if (paramInt == 130) {}
    for (int i = 1;; i = 0)
    {
      int j = getHeight();
      mTempRect.top = 0;
      mTempRect.bottom = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          View localView = getChildAt(i - 1);
          mTempRect.bottom = (localView.getBottom() + getPaddingBottom());
          mTempRect.top = (mTempRect.bottom - j);
        }
      }
      return scrollAndFocus(paramInt, mTempRect.top, mTempRect.bottom);
    }
  }
  
  private int getScrollRange()
  {
    int i = 0;
    if (getChildCount() > 0) {
      i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    return i;
  }
  
  private float getVerticalScrollFactorCompat()
  {
    if (mVerticalScrollFactor == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      Context localContext = getContext();
      if (!localContext.getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
      mVerticalScrollFactor = localTypedValue.getDimension(localContext.getResources().getDisplayMetrics());
    }
    return mVerticalScrollFactor;
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private boolean isOffScreen(View paramView)
  {
    boolean bool = false;
    if (!isWithinDeltaOfScreen(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isViewDescendantOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {}
    do
    {
      return true;
      paramView1 = paramView1.getParent();
    } while (((paramView1 instanceof ViewGroup)) && (isViewDescendantOf((View)paramView1, paramView2)));
    return false;
  }
  
  private boolean isWithinDeltaOfScreen(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(mTempRect);
    offsetDescendantRectToMyCoords(paramView, mTempRect);
    return (mTempRect.bottom + paramInt1 >= getScrollY()) && (mTempRect.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == mActivePointerId) {
      if (i != 0) {
        break label64;
      }
    }
    label64:
    for (i = 1;; i = 0)
    {
      mLastMotionY = ((int)MotionEventCompat.getY(paramMotionEvent, i));
      mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if (mVelocityTracker != null) {
        mVelocityTracker.clear();
      }
      return;
    }
  }
  
  private boolean overScrollByCompat$30fc967d$69c647f9(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewCompat.getOverScrollMode(this);
    computeHorizontalScrollRange();
    computeHorizontalScrollExtent();
    computeVerticalScrollRange();
    computeVerticalScrollExtent();
    int i = paramInt3 + paramInt1;
    paramInt3 = paramInt4 + paramInt2;
    paramInt2 = paramInt5 + 0;
    boolean bool1 = false;
    boolean bool2;
    if (i > 0)
    {
      paramInt1 = 0;
      bool1 = true;
      bool2 = false;
      if (paramInt3 <= paramInt2) {
        break label121;
      }
      bool2 = true;
    }
    for (;;)
    {
      if (bool2) {
        mScroller.springBack$6046c8d9(paramInt1, paramInt2, getScrollRange());
      }
      onOverScrolled(paramInt1, paramInt2, bool1, bool2);
      if ((!bool1) && (!bool2)) {
        break label135;
      }
      return true;
      paramInt1 = i;
      if (i >= 0) {
        break;
      }
      paramInt1 = 0;
      bool1 = true;
      break;
      label121:
      paramInt2 = paramInt3;
      if (paramInt3 < 0)
      {
        paramInt2 = 0;
        bool2 = true;
      }
    }
    label135:
    return false;
  }
  
  private void recycleVelocityTracker()
  {
    if (mVelocityTracker != null)
    {
      mVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  private boolean scrollAndFocus(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    int i = getHeight();
    int i1 = getScrollY();
    int i2 = i1 + i;
    int k;
    Object localObject2;
    int m;
    label56:
    Object localObject1;
    int n;
    int i4;
    int j;
    if (paramInt1 == 33)
    {
      k = 1;
      ArrayList localArrayList = getFocusables(2);
      localObject2 = null;
      i = 0;
      int i3 = localArrayList.size();
      m = 0;
      if (m >= i3) {
        break label228;
      }
      localObject1 = (View)localArrayList.get(m);
      n = ((View)localObject1).getTop();
      i4 = ((View)localObject1).getBottom();
      if ((paramInt2 >= i4) || (n >= paramInt3)) {
        break label300;
      }
      if ((paramInt2 >= n) || (i4 >= paramInt3)) {
        break label146;
      }
      j = 1;
      label118:
      if (localObject2 != null) {
        break label152;
      }
      i = j;
    }
    for (;;)
    {
      m += 1;
      localObject2 = localObject1;
      break label56;
      k = 0;
      break;
      label146:
      j = 0;
      break label118;
      label152:
      if (((k != 0) && (n < ((View)localObject2).getTop())) || ((k == 0) && (i4 > ((View)localObject2).getBottom()))) {}
      for (n = 1;; n = 0)
      {
        if (i == 0) {
          break label209;
        }
        if ((j == 0) || (n == 0)) {
          break label300;
        }
        break;
      }
      label209:
      if (j != 0)
      {
        i = 1;
      }
      else if (n != 0)
      {
        continue;
        label228:
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this;
        }
        if ((paramInt2 >= i1) && (paramInt3 <= i2))
        {
          bool = false;
          if (localObject1 != findFocus()) {
            ((View)localObject1).requestFocus(paramInt1);
          }
          return bool;
        }
        if (k != 0) {
          paramInt2 -= i1;
        }
        for (;;)
        {
          doScrollY(paramInt2);
          break;
          paramInt2 = paramInt3 - i2;
        }
      }
      else
      {
        label300:
        localObject1 = localObject2;
      }
    }
  }
  
  private void scrollToChild(View paramView)
  {
    paramView.getDrawingRect(mTempRect);
    offsetDescendantRectToMyCoords(paramView, mTempRect);
    int i = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - mLastScroll > 250L)
    {
      paramInt1 = getHeight();
      int i = getPaddingBottom();
      int j = getPaddingTop();
      i = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i - j));
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, i));
      ScrollerCompat localScrollerCompat = mScroller;
      i = getScrollX();
      mImpl.startScroll$364c3051(mScroller, i, paramInt1, paramInt2 - paramInt1);
      ViewCompat.postInvalidateOnAnimation(this);
    }
    for (;;)
    {
      mLastScroll = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!mScroller.isFinished()) {
        mScroller.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    int j = 1;
    int m;
    int i1;
    int i2;
    int i;
    if (mScroller.computeScrollOffset())
    {
      int k = getScrollX();
      m = getScrollY();
      int n = mScroller.getCurrX();
      i1 = mScroller.getCurrY();
      if ((k != n) || (m != i1))
      {
        i2 = getScrollRange();
        int i3 = ViewCompat.getOverScrollMode(this);
        i = j;
        if (i3 != 0)
        {
          if ((i3 != 1) || (i2 <= 0)) {
            break label140;
          }
          i = j;
        }
        overScrollByCompat$30fc967d$69c647f9(n - k, i1 - m, k, m, i2);
        if (i != 0)
        {
          ensureGlows();
          if ((i1 > 0) || (m <= 0)) {
            break label145;
          }
          mEdgeGlowTop.onAbsorb((int)mScroller.getCurrVelocity());
        }
      }
    }
    label140:
    label145:
    while ((i1 < i2) || (m >= i2))
    {
      return;
      i = 0;
      break;
    }
    mEdgeGlowBottom.onAbsorb((int)mScroller.getCurrVelocity());
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0) {
      return i;
    }
    j = getChildAt(0).getBottom();
    int k = getScrollY();
    int m = Math.max(0, j - i);
    if (k < 0) {
      i = j - k;
    }
    for (;;)
    {
      return i;
      i = j;
      if (k > m) {
        i = j + (k - m);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return mChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return mChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return mChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return mChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (mEdgeGlowTop != null)
    {
      int i = getScrollY();
      int j;
      int k;
      int m;
      if (!mEdgeGlowTop.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth();
        m = getPaddingLeft();
        int n = getPaddingRight();
        paramCanvas.translate(getPaddingLeft(), Math.min(0, i));
        mEdgeGlowTop.setSize(k - m - n, getHeight());
        if (mEdgeGlowTop.draw(paramCanvas)) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        paramCanvas.restoreToCount(j);
      }
      if (!mEdgeGlowBottom.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth() - getPaddingLeft() - getPaddingRight();
        m = getHeight();
        paramCanvas.translate(-k + getPaddingLeft(), Math.max(getScrollRange(), i) + m);
        paramCanvas.rotate(180.0F, k, 0.0F);
        mEdgeGlowBottom.setSize(k, m);
        if (mEdgeGlowBottom.draw(paramCanvas)) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  public final boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    int k = 33;
    int j = 1;
    boolean bool2 = false;
    mTempRect.setEmpty();
    View localView = getChildAt(0);
    int i;
    if (localView != null)
    {
      i = localView.getHeight();
      if (getHeight() < i + getPaddingTop() + getPaddingBottom()) {
        i = 1;
      }
    }
    while (i == 0)
    {
      bool1 = bool2;
      if (isFocused())
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 4)
        {
          localView = findFocus();
          paramKeyEvent = localView;
          if (localView == this) {
            paramKeyEvent = null;
          }
          paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            bool1 = bool2;
            if (paramKeyEvent != this)
            {
              bool1 = bool2;
              if (paramKeyEvent.requestFocus(130)) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
      i = 0;
      continue;
      i = 0;
    }
    bool2 = false;
    boolean bool1 = bool2;
    if (paramKeyEvent.getAction() == 0) {}
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      bool1 = bool2;
    case 19: 
    case 20: 
      for (;;)
      {
        return bool1;
        if (!paramKeyEvent.isAltPressed())
        {
          bool1 = arrowScroll(33);
        }
        else
        {
          bool1 = fullScroll(33);
          continue;
          if (!paramKeyEvent.isAltPressed()) {
            bool1 = arrowScroll(130);
          } else {
            bool1 = fullScroll(130);
          }
        }
      }
    }
    if (paramKeyEvent.isShiftPressed())
    {
      i = k;
      label285:
      if (i != 130) {
        break label415;
      }
      label292:
      k = getHeight();
      if (j == 0) {
        break label420;
      }
      mTempRect.top = (getScrollY() + k);
      j = getChildCount();
      if (j > 0)
      {
        paramKeyEvent = getChildAt(j - 1);
        if (mTempRect.top + k > paramKeyEvent.getBottom()) {
          mTempRect.top = (paramKeyEvent.getBottom() - k);
        }
      }
    }
    for (;;)
    {
      mTempRect.bottom = (mTempRect.top + k);
      scrollAndFocus(i, mTempRect.top, mTempRect.bottom);
      bool1 = bool2;
      break;
      i = 130;
      break label285;
      label415:
      j = 0;
      break label292;
      label420:
      mTempRect.top = (getScrollY() - k);
      if (mTempRect.top < 0) {
        mTempRect.top = 0;
      }
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = getChildAt(0).getBottom() - getScrollY() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(0.5F * getHeight());
  }
  
  public int getNestedScrollAxes()
  {
    return mParentHelper.mNestedScrollAxes;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return mChildHelper.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return mChildHelper.mIsNestedScrollingEnabled;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin + paramInt2, width), View.MeasureSpec.makeMeasureSpec(topMargin + bottomMargin, 0));
  }
  
  public void onAttachedToWindow()
  {
    mIsLaidOut = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((MotionEventCompat.getSource(paramMotionEvent) & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      if (!mIsBeingDragged)
      {
        float f = MotionEventCompat.getAxisValue(paramMotionEvent, 9);
        if (f != 0.0F)
        {
          int i = (int)(getVerticalScrollFactorCompat() * f);
          int j = getScrollRange();
          int m = getScrollY();
          int k = m - i;
          if (k < 0) {
            i = 0;
          }
          while (i != m)
          {
            super.scrollTo(getScrollX(), i);
            return true;
            i = k;
            if (k > j) {
              i = j;
            }
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (mIsBeingDragged)) {
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return mIsBeingDragged;
      i = mActivePointerId;
      if (i != -1)
      {
        int j = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        if (j == -1)
        {
          Log.e("NestedScrollView", "Invalid pointerId=" + i + " in onInterceptTouchEvent");
        }
        else
        {
          i = (int)MotionEventCompat.getY(paramMotionEvent, j);
          if ((Math.abs(i - mLastMotionY) > mTouchSlop) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            mIsBeingDragged = true;
            mLastMotionY = i;
            initVelocityTrackerIfNotExists();
            mVelocityTracker.addMovement(paramMotionEvent);
            mNestedYOffset = 0;
            paramMotionEvent = getParent();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              continue;
              j = (int)paramMotionEvent.getY();
              i = (int)paramMotionEvent.getX();
              if (getChildCount() > 0)
              {
                int k = getScrollY();
                View localView = getChildAt(0);
                if ((j >= localView.getTop() - k) && (j < localView.getBottom() - k) && (i >= localView.getLeft()) && (i < localView.getRight())) {
                  i = 1;
                }
              }
              for (;;)
              {
                if (i != 0) {
                  break label307;
                }
                mIsBeingDragged = false;
                recycleVelocityTracker();
                break;
                i = 0;
                continue;
                i = 0;
              }
              label307:
              mLastMotionY = j;
              mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
              if (mVelocityTracker == null)
              {
                mVelocityTracker = VelocityTracker.obtain();
                label335:
                mVelocityTracker.addMovement(paramMotionEvent);
                mScroller.computeScrollOffset();
                if (mScroller.isFinished()) {
                  break label386;
                }
              }
              for (;;)
              {
                mIsBeingDragged = bool;
                startNestedScroll(2);
                break;
                mVelocityTracker.clear();
                break label335;
                label386:
                bool = false;
              }
              mIsBeingDragged = false;
              mActivePointerId = -1;
              recycleVelocityTracker();
              if (mScroller.springBack$6046c8d9(getScrollX(), getScrollY(), getScrollRange())) {
                ViewCompat.postInvalidateOnAnimation(this);
              }
              stopNestedScroll();
              continue;
              onSecondaryPointerUp(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    mIsLayoutDirty = false;
    if ((mChildToScrollTo != null) && (isViewDescendantOf(mChildToScrollTo, this))) {
      scrollToChild(mChildToScrollTo);
    }
    mChildToScrollTo = null;
    if (!mIsLaidOut)
    {
      if (mSavedState != null)
      {
        scrollTo(getScrollX(), mSavedState.scrollPosition);
        mSavedState = null;
      }
      if (getChildCount() <= 0) {
        break label153;
      }
      paramInt1 = getChildAt(0).getMeasuredHeight();
      paramInt1 = Math.max(0, paramInt1 - (paramInt4 - paramInt2 - getPaddingBottom() - getPaddingTop()));
      if (getScrollY() <= paramInt1) {
        break label158;
      }
      scrollTo(getScrollX(), paramInt1);
    }
    for (;;)
    {
      scrollTo(getScrollX(), getScrollY());
      mIsLaidOut = true;
      return;
      label153:
      paramInt1 = 0;
      break;
      label158:
      if (getScrollY() < 0) {
        scrollTo(getScrollX(), 0);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!mFillViewport) {}
    View localView;
    do
    {
      do
      {
        return;
      } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    } while (localView.getMeasuredHeight() >= paramInt2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      flingWithNestedDispatch((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt, null);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getScrollY();
    scrollBy(0, paramInt4);
    paramInt1 = getScrollY() - paramInt1;
    dispatchNestedScroll(0, paramInt1, 0, paramInt4 - paramInt1, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    mParentHelper.mNestedScrollAxes = paramInt;
    startNestedScroll(2);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    View localView;
    if (paramInt == 2)
    {
      i = 130;
      if (paramRect != null) {
        break label44;
      }
      localView = FocusFinder.getInstance().findNextFocus(this, null, i);
      label24:
      if (localView != null) {
        break label58;
      }
    }
    label44:
    label58:
    while (isOffScreen(localView))
    {
      return false;
      i = paramInt;
      if (paramInt != 1) {
        break;
      }
      i = 33;
      break;
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
      break label24;
    }
    return localView.requestFocus(i, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    mSavedState = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    scrollPosition = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (mOnScrollChangeListener != null) {
      mOnScrollChangeListener.onScrollChange$227623bf(this);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {}
    while (!isWithinDeltaOfScreen(localView, 0, paramInt4)) {
      return;
    }
    localView.getDrawingRect(mTempRect);
    offsetDescendantRectToMyCoords(localView, mTempRect);
    doScrollY(computeScrollDeltaToGetChildRectOnScreen(mTempRect));
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    mParentHelper.mNestedScrollAxes = 0;
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    initVelocityTrackerIfNotExists();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0) {
      mNestedYOffset = 0;
    }
    localMotionEvent.offsetLocation(0.0F, mNestedYOffset);
    switch (i)
    {
    }
    for (;;)
    {
      if (mVelocityTracker != null) {
        mVelocityTracker.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      return true;
      if (getChildCount() == 0) {
        return false;
      }
      if (!mScroller.isFinished()) {}
      ViewParent localViewParent;
      for (boolean bool = true;; bool = false)
      {
        mIsBeingDragged = bool;
        if (bool)
        {
          localViewParent = getParent();
          if (localViewParent != null) {
            localViewParent.requestDisallowInterceptTouchEvent(true);
          }
        }
        if (!mScroller.isFinished()) {
          mScroller.abortAnimation();
        }
        mLastMotionY = ((int)paramMotionEvent.getY());
        mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        startNestedScroll(2);
        break;
      }
      int k = MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId);
      if (k == -1)
      {
        Log.e("NestedScrollView", "Invalid pointerId=" + mActivePointerId + " in onTouchEvent");
      }
      else
      {
        int m = (int)MotionEventCompat.getY(paramMotionEvent, k);
        i = mLastMotionY - m;
        int j = i;
        if (dispatchNestedPreScroll(0, i, mScrollConsumed, mScrollOffset))
        {
          j = i - mScrollConsumed[1];
          localMotionEvent.offsetLocation(0.0F, mScrollOffset[1]);
          mNestedYOffset += mScrollOffset[1];
        }
        i = j;
        if (!mIsBeingDragged)
        {
          i = j;
          if (Math.abs(j) > mTouchSlop)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
            mIsBeingDragged = true;
            if (j <= 0) {
              break label544;
            }
            i = j - mTouchSlop;
          }
        }
        label387:
        if (mIsBeingDragged)
        {
          mLastMotionY = (m - mScrollOffset[1]);
          int n = getScrollY();
          m = getScrollRange();
          j = ViewCompat.getOverScrollMode(this);
          if ((j == 0) || ((j == 1) && (m > 0))) {}
          for (j = 1;; j = 0)
          {
            if ((overScrollByCompat$30fc967d$69c647f9(0, i, 0, getScrollY(), m)) && (!hasNestedScrollingParent())) {
              mVelocityTracker.clear();
            }
            int i1 = getScrollY() - n;
            if (!dispatchNestedScroll(0, i1, 0, i - i1, mScrollOffset)) {
              break label559;
            }
            mLastMotionY -= mScrollOffset[1];
            localMotionEvent.offsetLocation(0.0F, mScrollOffset[1]);
            mNestedYOffset += mScrollOffset[1];
            break;
            label544:
            i = j + mTouchSlop;
            break label387;
          }
          label559:
          if (j != 0)
          {
            ensureGlows();
            j = n + i;
            if (j < 0)
            {
              mEdgeGlowTop.onPull(i / getHeight(), MotionEventCompat.getX(paramMotionEvent, k) / getWidth());
              if (!mEdgeGlowBottom.isFinished()) {
                mEdgeGlowBottom.onRelease();
              }
            }
            while ((mEdgeGlowTop != null) && ((!mEdgeGlowTop.isFinished()) || (!mEdgeGlowBottom.isFinished())))
            {
              ViewCompat.postInvalidateOnAnimation(this);
              break;
              if (j > m)
              {
                mEdgeGlowBottom.onPull(i / getHeight(), 1.0F - MotionEventCompat.getX(paramMotionEvent, k) / getWidth());
                if (!mEdgeGlowTop.isFinished()) {
                  mEdgeGlowTop.onRelease();
                }
              }
            }
            if (mIsBeingDragged)
            {
              paramMotionEvent = mVelocityTracker;
              paramMotionEvent.computeCurrentVelocity(1000, mMaximumVelocity);
              i = (int)VelocityTrackerCompat.getYVelocity(paramMotionEvent, mActivePointerId);
              if (Math.abs(i) <= mMinimumVelocity) {
                break label776;
              }
              flingWithNestedDispatch(-i);
            }
            for (;;)
            {
              mActivePointerId = -1;
              endDrag();
              break;
              label776:
              if (mScroller.springBack$6046c8d9(getScrollX(), getScrollY(), getScrollRange())) {
                ViewCompat.postInvalidateOnAnimation(this);
              }
            }
            if ((mIsBeingDragged) && (getChildCount() > 0) && (mScroller.springBack$6046c8d9(getScrollX(), getScrollY(), getScrollRange()))) {
              ViewCompat.postInvalidateOnAnimation(this);
            }
            mActivePointerId = -1;
            endDrag();
            continue;
            i = MotionEventCompat.getActionIndex(paramMotionEvent);
            mLastMotionY = ((int)MotionEventCompat.getY(paramMotionEvent, i));
            mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
            continue;
            onSecondaryPointerUp(paramMotionEvent);
            mLastMotionY = ((int)MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId)));
          }
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!mIsLayoutDirty) {
      scrollToChild(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      mChildToScrollTo = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          break;
        }
        scrollBy(0, i);
      }
      return bool;
    }
    smoothScrollBy(0, i);
    return bool;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycleVelocityTracker();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    mIsLayoutDirty = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = clamp(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      paramInt2 = clamp(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != mFillViewport)
    {
      mFillViewport = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    mChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnScrollChangeListener(OnScrollChangeListener paramOnScrollChangeListener)
  {
    mOnScrollChangeListener = paramOnScrollChangeListener;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    mSmoothScrollingEnabled = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public final void smoothScrollTo$255f295(int paramInt)
  {
    smoothScrollBy(0 - getScrollX(), paramInt - getScrollY());
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return mChildHelper.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    mChildHelper.stopNestedScroll();
  }
  
  static final class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = (NestedScrollView)paramView;
      paramAccessibilityEvent.setClassName(ScrollView.class.getName());
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      if (paramView.getScrollRange() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramAccessibilityEvent.setScrollable(bool);
        int i = paramView.getScrollX();
        AccessibilityRecordCompat.IMPL.setScrollX(mRecord, i);
        i = paramView.getScrollY();
        AccessibilityRecordCompat.IMPL.setScrollY(mRecord, i);
        i = paramView.getScrollX();
        AccessibilityRecordCompat.IMPL.setMaxScrollX(mRecord, i);
        i = paramView.getScrollRange();
        AccessibilityRecordCompat.IMPL.setMaxScrollY(mRecord, i);
        return;
      }
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramView = (NestedScrollView)paramView;
      paramAccessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = paramView.getScrollRange();
        if (i > 0)
        {
          paramAccessibilityNodeInfoCompat.setScrollable(true);
          if (paramView.getScrollY() > 0) {
            paramAccessibilityNodeInfoCompat.addAction(8192);
          }
          if (paramView.getScrollY() < i) {
            paramAccessibilityNodeInfoCompat.addAction(4096);
          }
        }
      }
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled()) {
        return false;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        paramInt = paramView.getHeight();
        i = paramView.getPaddingBottom();
        j = paramView.getPaddingTop();
        paramInt = Math.min(paramView.getScrollY() + (paramInt - i - j), paramView.getScrollRange());
        if (paramInt != paramView.getScrollY())
        {
          paramView.smoothScrollTo$255f295(paramInt);
          return true;
        }
        return false;
      }
      paramInt = paramView.getHeight();
      int i = paramView.getPaddingBottom();
      int j = paramView.getPaddingTop();
      paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
      if (paramInt != paramView.getScrollY())
      {
        paramView.smoothScrollTo$255f295(paramInt);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface OnScrollChangeListener
  {
    public abstract void onScrollChange$227623bf(NestedScrollView paramNestedScrollView);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int scrollPosition;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      scrollPosition = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + scrollPosition + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(scrollPosition);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.NestedScrollView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */