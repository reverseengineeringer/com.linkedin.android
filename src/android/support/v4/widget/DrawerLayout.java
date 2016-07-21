package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
  implements DrawerLayoutImpl
{
  private static final boolean CAN_HIDE_DESCENDANTS;
  static final DrawerLayoutCompatImpl IMPL;
  private static final int[] LAYOUT_ATTRS;
  private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
  private final ChildAccessibilityDelegate mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
  boolean mChildrenCanceledTouch;
  private boolean mDisallowInterceptRequested;
  private boolean mDrawStatusBarBackground;
  private float mDrawerElevation;
  int mDrawerState;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private Object mLastInsets;
  private final ViewDragCallback mLeftCallback;
  final ViewDragHelper mLeftDragger;
  @Deprecated
  private DrawerListener mListener;
  List<DrawerListener> mListeners;
  private int mLockModeEnd = 3;
  private int mLockModeLeft = 3;
  private int mLockModeRight = 3;
  private int mLockModeStart = 3;
  private int mMinDrawerMargin;
  private final ArrayList<View> mNonDrawerViews;
  private final ViewDragCallback mRightCallback;
  final ViewDragHelper mRightDragger;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private Paint mScrimPaint = new Paint();
  private Drawable mShadowEnd = null;
  private Drawable mShadowLeft = null;
  private Drawable mShadowLeftResolved;
  private Drawable mShadowRight = null;
  private Drawable mShadowRightResolved;
  private Drawable mShadowStart = null;
  private Drawable mStatusBarBackground;
  CharSequence mTitleLeft;
  CharSequence mTitleRight;
  
  static
  {
    boolean bool2 = true;
    LAYOUT_ATTRS = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      CAN_HIDE_DESCENDANTS = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label65;
      }
    }
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      SET_DRAWER_SHADOW_FROM_ELEVATION = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label70;
      }
      IMPL = new DrawerLayoutCompatImplApi21();
      return;
      bool1 = false;
      break;
    }
    label70:
    IMPL = new DrawerLayoutCompatImplBase();
  }
  
  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResourcesgetDisplayMetricsdensity;
    mMinDrawerMargin = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    mLeftCallback = new ViewDragCallback(3);
    mRightCallback = new ViewDragCallback(5);
    mLeftDragger = ViewDragHelper.create(this, 1.0F, mLeftCallback);
    mLeftDragger.mTrackingEdges = 1;
    mLeftDragger.mMinVelocity = f2;
    mLeftCallback.mDragger = mLeftDragger;
    mRightDragger = ViewDragHelper.create(this, 1.0F, mRightCallback);
    mRightDragger.mTrackingEdges = 2;
    mRightDragger.mMinVelocity = f2;
    mRightCallback.mDragger = mRightDragger;
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility(this, 1);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
    ViewGroupCompat.setMotionEventSplittingEnabled$4d3af60(this);
    if (ViewCompat.getFitsSystemWindows(this))
    {
      IMPL.configureApplyInsets(this);
      mStatusBarBackground = IMPL.getDefaultStatusBarBackground(paramContext);
    }
    mDrawerElevation = (10.0F * f1);
    mNonDrawerViews = new ArrayList();
  }
  
  private void closeDrawers(boolean paramBoolean)
  {
    int i = 0;
    int m = getChildCount();
    int j = 0;
    if (j < m)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      boolean bool = i;
      int k;
      if (isDrawerView(localView)) {
        if (paramBoolean)
        {
          bool = i;
          if (!isPeeking) {}
        }
        else
        {
          k = localView.getWidth();
          if (!checkDrawerViewAbsoluteGravity(localView, 3)) {
            break label116;
          }
          i |= mLeftDragger.smoothSlideViewTo(localView, -k, localView.getTop());
        }
      }
      for (;;)
      {
        LayoutParams.access$202(localLayoutParams, false);
        k = i;
        j += 1;
        i = k;
        break;
        label116:
        i |= mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
      }
    }
    mLeftCallback.removeCallbacks();
    mRightCallback.removeCallbacks();
    if (i != 0) {
      invalidate();
    }
  }
  
  private View findOpenDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((getLayoutParamsopenState & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private View findVisibleDrawer()
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView = getChildAt(i);
      if (isDrawerView(localView))
      {
        if (!isDrawerView(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if (getLayoutParamsonScreen > 0.0F) {}
        for (int j = 1; j != 0; j = 0) {
          return localView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  static float getDrawerViewOffset(View paramView)
  {
    return getLayoutParamsonScreen;
  }
  
  public static String gravityToString(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  private static boolean isContentView(View paramView)
  {
    return getLayoutParamsgravity == 0;
  }
  
  private static boolean isDrawerOpen(View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return (getLayoutParamsopenState & 0x1) == 1;
  }
  
  static boolean isDrawerView(View paramView)
  {
    int i = GravityCompat.getAbsoluteGravity(getLayoutParamsgravity, ViewCompat.getLayoutDirection(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  private static boolean mirror(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (!DrawableCompat.isAutoMirrored(paramDrawable))) {
      return false;
    }
    DrawableCompat.setLayoutDirection(paramDrawable, paramInt);
    return true;
  }
  
  private void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = mLeftDragger;
          label67:
          ((ViewDragHelper)localObject).cancel();
        }
      }
      else {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        mLockModeLeft = paramInt1;
        break;
        mLockModeRight = paramInt1;
        break;
        mLockModeStart = paramInt1;
        break;
        mLockModeEnd = paramInt1;
        break;
        localObject = mRightDragger;
        break label67;
        localObject = findDrawerWithGravity(i);
      } while (localObject == null);
      openDrawer((View)localObject);
      return;
      localObject = findDrawerWithGravity(i);
    } while (localObject == null);
    closeDrawer((View)localObject);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    View localView;
    if (i < k)
    {
      localView = getChildAt(i);
      if (isDrawerView(localView)) {
        if (isDrawerOpen(localView))
        {
          j = 1;
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        mNonDrawerViews.add(localView);
      }
    }
    if (j == 0)
    {
      j = mNonDrawerViews.size();
      i = 0;
      while (i < j)
      {
        localView = (View)mNonDrawerViews.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    mNonDrawerViews.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((findOpenDrawer() != null) || (isDrawerView(paramView))) {
      ViewCompat.setImportantForAccessibility(paramView, 4);
    }
    for (;;)
    {
      if (!CAN_HIDE_DESCENDANTS) {
        ViewCompat.setAccessibilityDelegate(paramView, mChildAccessibilityDelegate);
      }
      return;
      ViewCompat.setImportantForAccessibility(paramView, 1);
    }
  }
  
  final boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt)
  {
    return (getDrawerViewAbsoluteGravity(paramView) & paramInt) == paramInt;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public final void closeDrawer(View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (mFirstLayout)
    {
      LayoutParams.access$002(localLayoutParams, 0.0F);
      LayoutParams.access$102(localLayoutParams, 0);
    }
    for (;;)
    {
      invalidate();
      return;
      LayoutParams.access$176(localLayoutParams, 4);
      if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
        mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  public final void closeDrawer$13462e()
  {
    View localView = findDrawerWithGravity(8388613);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(8388613));
    }
    closeDrawer(localView);
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, getChildAtgetLayoutParamsonScreen);
      i += 1;
    }
    mScrimOpacity = f;
    if ((mLeftDragger.continueSettling$138603() | mRightDragger.continueSettling$138603())) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i2 = getHeight();
    boolean bool1 = isContentView(paramView);
    int i = 0;
    int n = 0;
    int j = getWidth();
    int i3 = paramCanvas.save();
    int k = j;
    if (bool1)
    {
      int i4 = getChildCount();
      m = 0;
      i = n;
      if (m < i4)
      {
        View localView = getChildAt(m);
        n = i;
        int i1 = j;
        if (localView != paramView)
        {
          n = i;
          i1 = j;
          if (localView.getVisibility() == 0)
          {
            Drawable localDrawable = localView.getBackground();
            if (localDrawable == null) {
              break label231;
            }
            if (localDrawable.getOpacity() != -1) {
              break label225;
            }
            k = 1;
            label121:
            n = i;
            i1 = j;
            if (k != 0)
            {
              n = i;
              i1 = j;
              if (isDrawerView(localView))
              {
                n = i;
                i1 = j;
                if (localView.getHeight() >= i2)
                {
                  if (!checkDrawerViewAbsoluteGravity(localView, 3)) {
                    break label237;
                  }
                  k = localView.getRight();
                  n = i;
                  i1 = j;
                  if (k > i)
                  {
                    n = k;
                    i1 = j;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          m += 1;
          i = n;
          j = i1;
          break;
          label225:
          k = 0;
          break label121;
          label231:
          k = 0;
          break label121;
          label237:
          k = localView.getLeft();
          n = i;
          i1 = j;
          if (k < j)
          {
            i1 = k;
            n = i;
          }
        }
      }
      paramCanvas.clipRect(i, 0, j, getHeight());
      k = j;
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i3);
    if ((mScrimOpacity > 0.0F) && (bool1))
    {
      j = (int)(((mScrimColor & 0xFF000000) >>> 24) * mScrimOpacity);
      m = mScrimColor;
      mScrimPaint.setColor(j << 24 | m & 0xFFFFFF);
      paramCanvas.drawRect(i, 0.0F, k, getHeight(), mScrimPaint);
    }
    do
    {
      return bool2;
      if ((mShadowLeftResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 3)))
      {
        i = mShadowLeftResolved.getIntrinsicWidth();
        j = paramView.getRight();
        k = mLeftDragger.mEdgeSize;
        f = Math.max(0.0F, Math.min(j / k, 1.0F));
        mShadowLeftResolved.setBounds(j, paramView.getTop(), j + i, paramView.getBottom());
        mShadowLeftResolved.setAlpha((int)(255.0F * f));
        mShadowLeftResolved.draw(paramCanvas);
        return bool2;
      }
    } while ((mShadowRightResolved == null) || (!checkDrawerViewAbsoluteGravity(paramView, 5)));
    i = mShadowRightResolved.getIntrinsicWidth();
    j = paramView.getLeft();
    k = getWidth();
    int m = mRightDragger.mEdgeSize;
    float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
    mShadowRightResolved.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
    mShadowRightResolved.setAlpha((int)(255.0F * f));
    mShadowRightResolved.draw(paramCanvas);
    return bool2;
  }
  
  public final View findDrawerWithGravity(int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((getDrawerViewAbsoluteGravity(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public float getDrawerElevation()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return mDrawerElevation;
    }
    return 0.0F;
  }
  
  public final int getDrawerLockMode(View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    int i = getLayoutParamsgravity;
    int j = ViewCompat.getLayoutDirection(this);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      if (mLockModeLeft != 3) {
        return mLockModeLeft;
      }
      if (j == 0) {}
      for (i = mLockModeStart; i != 3; i = mLockModeEnd) {
        return i;
      }
      if (mLockModeRight != 3) {
        return mLockModeRight;
      }
      if (j == 0) {}
      for (i = mLockModeEnd; i != 3; i = mLockModeStart) {
        return i;
      }
      if (mLockModeStart != 3) {
        return mLockModeStart;
      }
      if (j == 0) {}
      for (i = mLockModeLeft; i != 3; i = mLockModeRight) {
        return i;
      }
      if (mLockModeEnd != 3) {
        return mLockModeEnd;
      }
      if (j == 0) {}
      for (i = mLockModeRight; i != 3; i = mLockModeLeft) {
        return i;
      }
    }
  }
  
  final int getDrawerViewAbsoluteGravity(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(getLayoutParamsgravity, ViewCompat.getLayoutDirection(this));
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return mStatusBarBackground;
  }
  
  public final boolean isDrawerOpen$134632()
  {
    View localView = findDrawerWithGravity(8388613);
    if (localView != null) {
      return isDrawerOpen(localView);
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    mFirstLayout = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((mDrawStatusBarBackground) && (mStatusBarBackground != null))
    {
      int i = IMPL.getTopInset(mLastInsets);
      if (i > 0)
      {
        mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        mStatusBarBackground.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool1 = mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool2 = mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
    int j = 0;
    int k = 0;
    switch (i)
    {
    default: 
      i = k;
      if ((!(bool1 | bool2)) && (i == 0))
      {
        j = getChildCount();
        i = 0;
        label90:
        if (i >= j) {
          break label395;
        }
        if (!getChildAtgetLayoutParamsisPeeking) {
          break label386;
        }
      }
      break;
    }
    label227:
    label299:
    label349:
    label386:
    label395:
    for (i = 1;; i = 0)
    {
      if ((i == 0) && (!mChildrenCanceledTouch)) {
        break label401;
      }
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      mInitialMotionX = f1;
      mInitialMotionY = f2;
      i = j;
      if (mScrimOpacity > 0.0F)
      {
        paramMotionEvent = mLeftDragger.findTopChildUnder((int)f1, (int)f2);
        i = j;
        if (paramMotionEvent != null)
        {
          i = j;
          if (isContentView(paramMotionEvent)) {
            i = 1;
          }
        }
      }
      mDisallowInterceptRequested = false;
      mChildrenCanceledTouch = false;
      break;
      paramMotionEvent = mLeftDragger;
      int m = mInitialMotionX.length;
      j = 0;
      if (j < m) {
        if (paramMotionEvent.isPointerDown(j))
        {
          f1 = mLastMotionX[j] - mInitialMotionX[j];
          f2 = mLastMotionY[j] - mInitialMotionY[j];
          if (f1 * f1 + f2 * f2 > mTouchSlop * mTouchSlop)
          {
            i = 1;
            if (i == 0) {
              break label349;
            }
          }
        }
      }
      for (j = 1;; j = 0)
      {
        i = k;
        if (j == 0) {
          break;
        }
        mLeftCallback.removeCallbacks();
        mRightCallback.removeCallbacks();
        i = k;
        break;
        i = 0;
        break label299;
        i = 0;
        break label299;
        j += 1;
        break label227;
      }
      closeDrawers(true);
      mDisallowInterceptRequested = false;
      mChildrenCanceledTouch = false;
      i = k;
      break;
      i += 1;
      break label90;
    }
    label401:
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (findVisibleDrawer() != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        KeyEventCompat.startTracking(paramKeyEvent);
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      paramKeyEvent = findVisibleDrawer();
      if ((paramKeyEvent != null) && (getDrawerLockMode(paramKeyEvent) == 0)) {
        closeDrawers(false);
      }
      if (paramKeyEvent != null) {
        bool = true;
      }
      return bool;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mInLayout = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      LayoutParams localLayoutParams;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (isContentView(localView)) {
          localView.layout(leftMargin, topMargin, leftMargin + localView.getMeasuredWidth(), topMargin + localView.getMeasuredHeight());
        }
      }
      else
      {
        paramInt3 += 1;
        continue;
      }
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      int i;
      float f;
      label161:
      int j;
      if (checkDrawerViewAbsoluteGravity(localView, 3))
      {
        i = -i1 + (int)(i1 * onScreen);
        f = (i1 + i) / i1;
        if (f == onScreen) {
          break label306;
        }
        j = 1;
        label175:
        switch (gravity & 0x70)
        {
        default: 
          localView.layout(i, topMargin, i + i1, topMargin + i2);
          label233:
          if (j != 0) {
            setDrawerViewOffset(localView, f);
          }
          if (onScreen <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * onScreen);
        f = (m - i) / i1;
        break label161;
        label306:
        j = 0;
        break label175;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i, paramInt1 - bottomMargin - localView.getMeasuredHeight(), i + i1, paramInt1 - bottomMargin);
        break label233;
        int i3 = paramInt4 - paramInt2;
        int k = (i3 - i2) / 2;
        if (k < topMargin) {
          paramInt1 = topMargin;
        }
        for (;;)
        {
          localView.layout(i, paramInt1, i + i1, paramInt1 + i2);
          break;
          paramInt1 = k;
          if (k + i2 > i3 - bottomMargin) {
            paramInt1 = i3 - bottomMargin - i2;
          }
        }
      }
    }
    mInLayout = false;
    mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    int m;
    int k;
    int i;
    if (i2 == 1073741824)
    {
      m = n;
      k = j;
      if (i1 == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label317;
      }
      i = j;
      if (i2 != Integer.MIN_VALUE)
      {
        i = j;
        if (i2 == 0) {
          i = 300;
        }
      }
      m = n;
      k = i;
      if (i1 != Integer.MIN_VALUE)
      {
        m = n;
        k = i;
        if (i1 == 0)
        {
          m = 300;
          k = i;
        }
      }
    }
    setMeasuredDimension(k, m);
    label158:
    View localView;
    int i3;
    LayoutParams localLayoutParams;
    if ((mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this)))
    {
      n = 1;
      int i4 = ViewCompat.getLayoutDirection(this);
      j = 0;
      i = 0;
      int i5 = getChildCount();
      i1 = 0;
      if (i1 >= i5) {
        return;
      }
      localView = getChildAt(i1);
      i2 = j;
      i3 = i;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (n != 0)
        {
          i2 = GravityCompat.getAbsoluteGravity(gravity, i4);
          if (!ViewCompat.getFitsSystemWindows(localView)) {
            break label334;
          }
          IMPL.dispatchChildInsets(localView, mLastInsets, i2);
        }
      }
    }
    for (;;)
    {
      if (!isContentView(localView)) {
        break label353;
      }
      localView.measure(View.MeasureSpec.makeMeasureSpec(k - leftMargin - rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(m - topMargin - bottomMargin, 1073741824));
      i3 = i;
      i2 = j;
      i1 += 1;
      j = i2;
      i = i3;
      break label158;
      label317:
      throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
      n = 0;
      break;
      label334:
      IMPL.applyMarginInsets(localLayoutParams, mLastInsets, i2);
    }
    label353:
    if (isDrawerView(localView))
    {
      if ((SET_DRAWER_SHADOW_FROM_ELEVATION) && (ViewCompat.getElevation(localView) != mDrawerElevation)) {
        ViewCompat.setElevation(localView, mDrawerElevation);
      }
      i3 = getDrawerViewAbsoluteGravity(localView) & 0x7;
      if (i3 == 3) {}
      for (i2 = 1; ((i2 != 0) && (j != 0)) || ((i2 == 0) && (i != 0)); i2 = 0) {
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(i3) + " but this DrawerLayout already has a drawer view along that edge");
      }
      if (i2 != 0) {
        j = 1;
      }
      for (;;)
      {
        localView.measure(getChildMeasureSpec(paramInt1, mMinDrawerMargin + leftMargin + rightMargin, width), getChildMeasureSpec(paramInt2, topMargin + bottomMargin, height));
        i2 = j;
        i3 = i;
        break;
        i = 1;
      }
    }
    throw new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      if (openDrawerGravity != 0)
      {
        View localView = findDrawerWithGravity(openDrawerGravity);
        if (localView != null) {
          openDrawer(localView);
        }
      }
      if (lockModeLeft != 3) {
        setDrawerLockMode(lockModeLeft, 3);
      }
      if (lockModeRight != 3) {
        setDrawerLockMode(lockModeRight, 5);
      }
      if (lockModeStart != 3) {
        setDrawerLockMode(lockModeStart, 8388611);
      }
    } while (lockModeEnd == 3);
    setDrawerLockMode(lockModeEnd, 8388613);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    Drawable localDrawable;
    if (!SET_DRAWER_SHADOW_FROM_ELEVATION)
    {
      paramInt = ViewCompat.getLayoutDirection(this);
      if (paramInt != 0) {
        break label77;
      }
      if (mShadowStart == null) {
        break label101;
      }
      mirror(mShadowStart, paramInt);
      localDrawable = mShadowStart;
      mShadowLeftResolved = localDrawable;
      paramInt = ViewCompat.getLayoutDirection(this);
      if (paramInt != 0) {
        break label109;
      }
      if (mShadowEnd == null) {
        break label133;
      }
      mirror(mShadowEnd, paramInt);
      localDrawable = mShadowEnd;
    }
    for (;;)
    {
      mShadowRightResolved = localDrawable;
      return;
      label77:
      if (mShadowEnd != null)
      {
        mirror(mShadowEnd, paramInt);
        localDrawable = mShadowEnd;
        break;
      }
      label101:
      localDrawable = mShadowLeft;
      break;
      label109:
      if (mShadowStart != null)
      {
        mirror(mShadowStart, paramInt);
        localDrawable = mShadowStart;
      }
      else
      {
        label133:
        localDrawable = mShadowRight;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int m = getChildCount();
    int i = 0;
    for (;;)
    {
      LayoutParams localLayoutParams;
      int j;
      if (i < m)
      {
        localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        if (openState != 1) {
          break label119;
        }
        j = 1;
        if (openState != 2) {
          break label124;
        }
      }
      label119:
      label124:
      for (int k = 1;; k = 0)
      {
        if ((j == 0) && (k == 0)) {
          break label129;
        }
        openDrawerGravity = gravity;
        lockModeLeft = mLockModeLeft;
        lockModeRight = mLockModeRight;
        lockModeStart = mLockModeStart;
        lockModeEnd = mLockModeEnd;
        return localSavedState;
        j = 0;
        break;
      }
      label129:
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    mLeftDragger.processTouchEvent(paramMotionEvent);
    mRightDragger.processTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return true;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      mInitialMotionX = f1;
      mInitialMotionY = f2;
      mDisallowInterceptRequested = false;
      mChildrenCanceledTouch = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      boolean bool2 = true;
      paramMotionEvent = mLeftDragger.findTopChildUnder((int)f2, (int)f1);
      boolean bool1 = bool2;
      if (paramMotionEvent != null)
      {
        bool1 = bool2;
        if (isContentView(paramMotionEvent))
        {
          f2 -= mInitialMotionX;
          f1 -= mInitialMotionY;
          int i = mLeftDragger.mTouchSlop;
          bool1 = bool2;
          if (f2 * f2 + f1 * f1 < i * i)
          {
            paramMotionEvent = findOpenDrawer();
            bool1 = bool2;
            if (paramMotionEvent != null) {
              if (getDrawerLockMode(paramMotionEvent) != 2) {
                break label216;
              }
            }
          }
        }
      }
      label216:
      for (bool1 = true;; bool1 = false)
      {
        closeDrawers(bool1);
        mDisallowInterceptRequested = false;
        return true;
      }
    }
    closeDrawers(true);
    mDisallowInterceptRequested = false;
    mChildrenCanceledTouch = false;
    return true;
  }
  
  public final void openDrawer(View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (mFirstLayout)
    {
      LayoutParams.access$002(localLayoutParams, 1.0F);
      LayoutParams.access$102(localLayoutParams, 1);
      updateChildrenImportantForAccessibility(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      LayoutParams.access$176(localLayoutParams, 2);
      if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
        mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
      } else {
        mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    mDisallowInterceptRequested = paramBoolean;
    if (paramBoolean) {
      closeDrawers(true);
    }
  }
  
  public void requestLayout()
  {
    if (!mInLayout) {
      super.requestLayout();
    }
  }
  
  public final void setChildInsets(Object paramObject, boolean paramBoolean)
  {
    mLastInsets = paramObject;
    mDrawStatusBarBackground = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setWillNotDraw(paramBoolean);
      requestLayout();
      return;
    }
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    mDrawerElevation = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (isDrawerView(localView)) {
        ViewCompat.setElevation(localView, mDrawerElevation);
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void setDrawerListener(DrawerListener paramDrawerListener)
  {
    if (mListener != null)
    {
      DrawerListener localDrawerListener = mListener;
      if ((localDrawerListener != null) && (mListeners != null)) {
        mListeners.remove(localDrawerListener);
      }
    }
    if ((paramDrawerListener != null) && (paramDrawerListener != null))
    {
      if (mListeners == null) {
        mListeners = new ArrayList();
      }
      mListeners.add(paramDrawerListener);
    }
    mListener = paramDrawerListener;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  final void setDrawerViewOffset(View paramView, float paramFloat)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == onScreen) {}
    for (;;)
    {
      return;
      LayoutParams.access$002(paramView, paramFloat);
      if (mListeners != null)
      {
        int i = mListeners.size() - 1;
        while (i >= 0)
        {
          ((DrawerListener)mListeners.get(i)).onDrawerSlide$5359e7dd(paramFloat);
          i -= 1;
        }
      }
    }
  }
  
  public void setScrimColor(int paramInt)
  {
    mScrimColor = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = ContextCompat.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      mStatusBarBackground = localDrawable;
      invalidate();
      return;
    }
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    mStatusBarBackground = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    mStatusBarBackground = new ColorDrawable(paramInt);
    invalidate();
  }
  
  final void updateChildrenImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!isDrawerView(localView))) || ((paramBoolean) && (localView == paramView))) {
        ViewCompat.setImportantForAccessibility(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        ViewCompat.setImportantForAccessibility(localView, 4);
      }
    }
  }
  
  final class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private final Rect mTmpRect = new Rect();
    
    AccessibilityDelegate() {}
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getText();
        paramView = DrawerLayout.this.findVisibleDrawer();
        int i;
        if (paramView != null)
        {
          i = getDrawerViewAbsoluteGravity(paramView);
          paramView = DrawerLayout.this;
          i = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(paramView));
          if (i != 3) {
            break label73;
          }
          paramView = mTitleLeft;
        }
        for (;;)
        {
          if (paramView != null) {
            paramAccessibilityEvent.add(paramView);
          }
          return true;
          label73:
          if (i == 5) {
            paramView = mTitleRight;
          } else {
            paramView = null;
          }
        }
      }
      return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      }
      for (;;)
      {
        paramAccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
        paramAccessibilityNodeInfoCompat.setFocusable(false);
        paramAccessibilityNodeInfoCompat.setFocused(false);
        paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
        paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        return;
        Object localObject1 = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(paramView, (AccessibilityNodeInfoCompat)localObject1);
        AccessibilityNodeInfoCompat.IMPL.setSource(mInfo, paramView);
        Object localObject2 = ViewCompat.getParentForAccessibility(paramView);
        if ((localObject2 instanceof View)) {
          paramAccessibilityNodeInfoCompat.setParent((View)localObject2);
        }
        localObject2 = mTmpRect;
        ((AccessibilityNodeInfoCompat)localObject1).getBoundsInParent((Rect)localObject2);
        AccessibilityNodeInfoCompat.IMPL.setBoundsInParent(mInfo, (Rect)localObject2);
        ((AccessibilityNodeInfoCompat)localObject1).getBoundsInScreen((Rect)localObject2);
        AccessibilityNodeInfoCompat.IMPL.setBoundsInScreen(mInfo, (Rect)localObject2);
        boolean bool = AccessibilityNodeInfoCompat.IMPL.isVisibleToUser(mInfo);
        AccessibilityNodeInfoCompat.IMPL.setVisibleToUser(mInfo, bool);
        localObject2 = ((AccessibilityNodeInfoCompat)localObject1).getPackageName();
        AccessibilityNodeInfoCompat.IMPL.setPackageName(mInfo, (CharSequence)localObject2);
        paramAccessibilityNodeInfoCompat.setClassName(((AccessibilityNodeInfoCompat)localObject1).getClassName());
        localObject2 = ((AccessibilityNodeInfoCompat)localObject1).getContentDescription();
        AccessibilityNodeInfoCompat.IMPL.setContentDescription(mInfo, (CharSequence)localObject2);
        bool = ((AccessibilityNodeInfoCompat)localObject1).isEnabled();
        AccessibilityNodeInfoCompat.IMPL.setEnabled(mInfo, bool);
        bool = ((AccessibilityNodeInfoCompat)localObject1).isClickable();
        AccessibilityNodeInfoCompat.IMPL.setClickable(mInfo, bool);
        paramAccessibilityNodeInfoCompat.setFocusable(((AccessibilityNodeInfoCompat)localObject1).isFocusable());
        paramAccessibilityNodeInfoCompat.setFocused(((AccessibilityNodeInfoCompat)localObject1).isFocused());
        bool = AccessibilityNodeInfoCompat.IMPL.isAccessibilityFocused(mInfo);
        AccessibilityNodeInfoCompat.IMPL.setAccessibilityFocused(mInfo, bool);
        bool = ((AccessibilityNodeInfoCompat)localObject1).isSelected();
        AccessibilityNodeInfoCompat.IMPL.setSelected(mInfo, bool);
        bool = ((AccessibilityNodeInfoCompat)localObject1).isLongClickable();
        AccessibilityNodeInfoCompat.IMPL.setLongClickable(mInfo, bool);
        paramAccessibilityNodeInfoCompat.addAction(((AccessibilityNodeInfoCompat)localObject1).getActions());
        AccessibilityNodeInfoCompat.IMPL.recycle(mInfo);
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject1 = paramView.getChildAt(i);
          if (DrawerLayout.access$700((View)localObject1)) {
            AccessibilityNodeInfoCompat.IMPL.addChild(mInfo, (View)localObject1);
          }
          i += 1;
        }
      }
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((DrawerLayout.CAN_HIDE_DESCENDANTS) || (DrawerLayout.access$700(paramView))) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  final class ChildAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    ChildAccessibilityDelegate() {}
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      if (!DrawerLayout.access$700(paramView)) {
        paramAccessibilityNodeInfoCompat.setParent(null);
      }
    }
  }
  
  static abstract interface DrawerLayoutCompatImpl
  {
    public abstract void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt);
    
    public abstract void configureApplyInsets(View paramView);
    
    public abstract void dispatchChildInsets(View paramView, Object paramObject, int paramInt);
    
    public abstract Drawable getDefaultStatusBarBackground(Context paramContext);
    
    public abstract int getTopInset(Object paramObject);
  }
  
  static final class DrawerLayoutCompatImplApi21
    implements DrawerLayout.DrawerLayoutCompatImpl
  {
    public final void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
    {
      DrawerLayoutCompatApi21.applyMarginInsets(paramMarginLayoutParams, paramObject, paramInt);
    }
    
    public final void configureApplyInsets(View paramView)
    {
      DrawerLayoutCompatApi21.configureApplyInsets(paramView);
    }
    
    public final void dispatchChildInsets(View paramView, Object paramObject, int paramInt)
    {
      DrawerLayoutCompatApi21.dispatchChildInsets(paramView, paramObject, paramInt);
    }
    
    public final Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(paramContext);
    }
    
    public final int getTopInset(Object paramObject)
    {
      return DrawerLayoutCompatApi21.getTopInset(paramObject);
    }
  }
  
  static final class DrawerLayoutCompatImplBase
    implements DrawerLayout.DrawerLayoutCompatImpl
  {
    public final void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt) {}
    
    public final void configureApplyInsets(View paramView) {}
    
    public final void dispatchChildInsets(View paramView, Object paramObject, int paramInt) {}
    
    public final Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      return null;
    }
    
    public final int getTopInset(Object paramObject)
    {
      return 0;
    }
  }
  
  public static abstract interface DrawerListener
  {
    public abstract void onDrawerClosed$3c7ec8c3();
    
    public abstract void onDrawerOpened$3c7ec8c3();
    
    public abstract void onDrawerSlide$5359e7dd(float paramFloat);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;
    private boolean isPeeking;
    private float onScreen;
    private int openState;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
      gravity = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      gravity = gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  protected static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int lockModeEnd;
    int lockModeLeft;
    int lockModeRight;
    int lockModeStart;
    int openDrawerGravity = 0;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      openDrawerGravity = paramParcel.readInt();
      lockModeLeft = paramParcel.readInt();
      lockModeRight = paramParcel.readInt();
      lockModeStart = paramParcel.readInt();
      lockModeEnd = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(openDrawerGravity);
      paramParcel.writeInt(lockModeLeft);
      paramParcel.writeInt(lockModeRight);
      paramParcel.writeInt(lockModeStart);
      paramParcel.writeInt(lockModeEnd);
    }
  }
  
  private final class ViewDragCallback
    extends ViewDragHelper.Callback
  {
    final int mAbsGravity;
    ViewDragHelper mDragger;
    private final Runnable mPeekRunnable = new Runnable()
    {
      public final void run()
      {
        int k = 0;
        Object localObject2 = DrawerLayout.ViewDragCallback.this;
        int m = mDragger.mEdgeSize;
        int i;
        Object localObject1;
        int j;
        if (mAbsGravity == 3)
        {
          i = 1;
          if (i == 0) {
            break label227;
          }
          localObject1 = this$0.findDrawerWithGravity(3);
          if (localObject1 == null) {
            break label222;
          }
          j = -((View)localObject1).getWidth();
          label56:
          j += m;
        }
        for (;;)
        {
          label61:
          if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (this$0.getDrawerLockMode((View)localObject1) == 0))))
          {
            DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
            mDragger.smoothSlideViewTo((View)localObject1, j, ((View)localObject1).getTop());
            DrawerLayout.LayoutParams.access$202(localLayoutParams, true);
            this$0.invalidate();
            ((DrawerLayout.ViewDragCallback)localObject2).closeOtherDrawer();
            localObject1 = this$0;
            if (!mChildrenCanceledTouch)
            {
              long l = SystemClock.uptimeMillis();
              localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
              j = ((DrawerLayout)localObject1).getChildCount();
              i = k;
              for (;;)
              {
                if (i < j)
                {
                  ((DrawerLayout)localObject1).getChildAt(i).dispatchTouchEvent((MotionEvent)localObject2);
                  i += 1;
                  continue;
                  i = 0;
                  break;
                  label222:
                  j = 0;
                  break label56;
                  label227:
                  localObject1 = this$0.findDrawerWithGravity(5);
                  j = this$0.getWidth();
                  j -= m;
                  break label61;
                }
              }
              ((MotionEvent)localObject2).recycle();
              mChildrenCanceledTouch = true;
            }
          }
        }
      }
    };
    
    public ViewDragCallback(int paramInt)
    {
      mAbsGravity = paramInt;
    }
    
    public final int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
      }
      paramInt2 = getWidth();
      return Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2));
    }
    
    public final int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    final void closeOtherDrawer()
    {
      int i = 3;
      if (mAbsGravity == 3) {
        i = 5;
      }
      View localView = findDrawerWithGravity(i);
      if (localView != null) {
        closeDrawer(localView);
      }
    }
    
    public final int getViewHorizontalDragRange(View paramView)
    {
      if (DrawerLayout.isDrawerView(paramView)) {
        return paramView.getWidth();
      }
      return 0;
    }
    
    public final void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = findDrawerWithGravity(3);; localView = findDrawerWithGravity(5))
      {
        if ((localView != null) && (getDrawerLockMode(localView) == 0)) {
          mDragger.captureChildView(localView, paramInt2);
        }
        return;
      }
    }
    
    public final boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public final void onEdgeTouched(int paramInt1, int paramInt2)
    {
      postDelayed(mPeekRunnable, 160L);
    }
    
    public final void onViewCaptured(View paramView, int paramInt)
    {
      DrawerLayout.LayoutParams.access$202((DrawerLayout.LayoutParams)paramView.getLayoutParams(), false);
      closeOtherDrawer();
    }
    
    public final void onViewDragStateChanged(int paramInt)
    {
      DrawerLayout localDrawerLayout = DrawerLayout.this;
      View localView = mDragger.mCapturedView;
      int i = mLeftDragger.mDragState;
      int j = mRightDragger.mDragState;
      if ((i == 1) || (j == 1)) {
        i = 1;
      }
      DrawerLayout.LayoutParams localLayoutParams;
      while ((localView != null) && (paramInt == 0))
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (onScreen != 0.0F) {
          break label267;
        }
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if ((openState & 0x1) == 1)
        {
          DrawerLayout.LayoutParams.access$102(localLayoutParams, 0);
          if (mListeners != null)
          {
            paramInt = mListeners.size() - 1;
            for (;;)
            {
              if (paramInt >= 0)
              {
                ((DrawerLayout.DrawerListener)mListeners.get(paramInt)).onDrawerClosed$3c7ec8c3();
                paramInt -= 1;
                continue;
                if ((i == 2) || (j == 2))
                {
                  i = 2;
                  break;
                }
                i = 0;
                break;
              }
            }
          }
          localDrawerLayout.updateChildrenImportantForAccessibility(localView, false);
          if (localDrawerLayout.hasWindowFocus())
          {
            localView = localDrawerLayout.getRootView();
            if (localView != null) {
              localView.sendAccessibilityEvent(32);
            }
          }
        }
      }
      while (i != mDrawerState)
      {
        mDrawerState = i;
        if (mListeners == null) {
          break;
        }
        paramInt = mListeners.size() - 1;
        while (paramInt >= 0)
        {
          mListeners.get(paramInt);
          paramInt -= 1;
        }
        label267:
        if (onScreen == 1.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((openState & 0x1) == 0)
          {
            DrawerLayout.LayoutParams.access$102(localLayoutParams, 1);
            if (mListeners != null)
            {
              paramInt = mListeners.size() - 1;
              while (paramInt >= 0)
              {
                ((DrawerLayout.DrawerListener)mListeners.get(paramInt)).onDrawerOpened$3c7ec8c3();
                paramInt -= 1;
              }
            }
            localDrawerLayout.updateChildrenImportantForAccessibility(localView, true);
            if (localDrawerLayout.hasWindowFocus()) {
              localDrawerLayout.sendAccessibilityEvent(32);
            }
            localView.requestFocus();
          }
        }
      }
    }
    
    public final void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        setDrawerViewOffset(paramView, f);
        if (f != 0.0F) {
          break label76;
        }
      }
      label76:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        paramView.setVisibility(paramInt1);
        invalidate();
        return;
        f = (getWidth() - paramInt1) / paramInt2;
        break;
      }
    }
    
    public final void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.getDrawerViewOffset(paramView);
      int j = paramView.getWidth();
      if (checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {}
        for (i = 0;; i = -j)
        {
          mDragger.settleCapturedViewAt(i, paramView.getTop());
          invalidate();
          return;
        }
      }
      int i = getWidth();
      if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
        i -= j;
      }
      for (;;)
      {
        break;
      }
    }
    
    public final void removeCallbacks()
    {
      removeCallbacks(mPeekRunnable);
    }
    
    public final boolean tryCaptureView(View paramView, int paramInt)
    {
      return (DrawerLayout.isDrawerView(paramView)) && (checkDrawerViewAbsoluteGravity(paramView, mAbsGravity)) && (getDrawerLockMode(paramView) == 0);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */