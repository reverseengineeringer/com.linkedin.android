package android.support.design.widget;

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
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements NestedScrollingParent
{
  static final Class<?>[] CONSTRUCTOR_PARAMS;
  static final CoordinatorLayoutInsetsHelper INSETS_HELPER;
  static final String TAG = "CoordinatorLayout";
  static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
  private static final int TYPE_ON_INTERCEPT = 0;
  private static final int TYPE_ON_TOUCH = 1;
  static final String WIDGET_PACKAGE_NAME;
  static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
  private View mBehaviorTouchView;
  private final List<View> mDependencySortedChildren = new ArrayList();
  private boolean mDisallowInterceptReset;
  private boolean mDrawStatusBarBackground;
  private boolean mIsAttachedToWindow;
  private int[] mKeylines;
  private WindowInsetsCompat mLastInsets;
  final Comparator<View> mLayoutDependencyComparator = new Comparator()
  {
    public int compare(View paramAnonymousView1, View paramAnonymousView2)
    {
      if (paramAnonymousView1 == paramAnonymousView2) {
        return 0;
      }
      if (((CoordinatorLayout.LayoutParams)paramAnonymousView1.getLayoutParams()).dependsOn(CoordinatorLayout.this, paramAnonymousView1, paramAnonymousView2)) {
        return 1;
      }
      if (((CoordinatorLayout.LayoutParams)paramAnonymousView2.getLayoutParams()).dependsOn(CoordinatorLayout.this, paramAnonymousView2, paramAnonymousView1)) {
        return -1;
      }
      return 0;
    }
  };
  private boolean mNeedsPreDrawListener;
  private View mNestedScrollingDirectChild;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
  private View mNestedScrollingTarget;
  private ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
  private OnPreDrawListener mOnPreDrawListener;
  private Paint mScrimPaint;
  private Drawable mStatusBarBackground;
  private final List<View> mTempDependenciesList = new ArrayList();
  private final int[] mTempIntPair = new int[2];
  private final List<View> mTempList1 = new ArrayList();
  private final Rect mTempRect1 = new Rect();
  private final Rect mTempRect2 = new Rect();
  private final Rect mTempRect3 = new Rect();
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      WIDGET_PACKAGE_NAME = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label80;
      }
      TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
    }
    for (INSETS_HELPER = new CoordinatorLayoutInsetsHelperLollipop();; INSETS_HELPER = null)
    {
      CONSTRUCTOR_PARAMS = new Class[] { Context.class, AttributeSet.class };
      sConstructors = new ThreadLocal();
      return;
      localObject = null;
      break;
      label80:
      TOP_SORTED_CHILDREN_COMPARATOR = null;
    }
  }
  
  public CoordinatorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, paramInt, R.style.Widget_Design_CoordinatorLayout);
    paramInt = paramAttributeSet.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      mKeylines = paramContext.getIntArray(paramInt);
      float f = getDisplayMetricsdensity;
      int i = mKeylines.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramContext = mKeylines;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    mStatusBarBackground = paramAttributeSet.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
    paramAttributeSet.recycle();
    if (INSETS_HELPER != null) {
      INSETS_HELPER.setupForWindowInsets(this, new ApplyInsetsListener(null));
    }
    super.setOnHierarchyChangeListener(new HierarchyChangeListener(null));
  }
  
  private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat.isConsumed()) {
      return paramWindowInsetsCompat;
    }
    int i = 0;
    int j = getChildCount();
    WindowInsetsCompat localWindowInsetsCompat;
    for (;;)
    {
      localWindowInsetsCompat = paramWindowInsetsCompat;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      localWindowInsetsCompat = paramWindowInsetsCompat;
      if (ViewCompat.getFitsSystemWindows(localView))
      {
        Behavior localBehavior = ((LayoutParams)localView.getLayoutParams()).getBehavior();
        localWindowInsetsCompat = paramWindowInsetsCompat;
        if (localBehavior != null)
        {
          paramWindowInsetsCompat = localBehavior.onApplyWindowInsets(this, localView, paramWindowInsetsCompat);
          localWindowInsetsCompat = paramWindowInsetsCompat;
          if (paramWindowInsetsCompat.isConsumed()) {
            break;
          }
          localWindowInsetsCompat = paramWindowInsetsCompat;
        }
      }
      i += 1;
      paramWindowInsetsCompat = localWindowInsetsCompat;
    }
    return localWindowInsetsCompat;
  }
  
  private int getKeyline(int paramInt)
  {
    if (mKeylines == null)
    {
      Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= mKeylines.length))
    {
      Log.e("CoordinatorLayout", "Keyline index " + paramInt + " out of range for " + this);
      return 0;
    }
    return mKeylines[paramInt];
  }
  
  private void getTopSortedChildren(List<View> paramList)
  {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int k = getChildCount();
    int i = k - 1;
    if (i >= 0)
    {
      if (bool) {}
      for (int j = getChildDrawingOrder(k, i);; j = i)
      {
        paramList.add(getChildAt(j));
        i -= 1;
        break;
      }
    }
    if (TOP_SORTED_CHILDREN_COMPARATOR != null) {
      Collections.sort(paramList, TOP_SORTED_CHILDREN_COMPARATOR);
    }
  }
  
  private void layoutChild(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect1 = mTempRect1;
    localRect1.set(getPaddingLeft() + leftMargin, getPaddingTop() + topMargin, getWidth() - getPaddingRight() - rightMargin, getHeight() - getPaddingBottom() - bottomMargin);
    if ((mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this)) && (!ViewCompat.getFitsSystemWindows(paramView)))
    {
      left += mLastInsets.getSystemWindowInsetLeft();
      top += mLastInsets.getSystemWindowInsetTop();
      right -= mLastInsets.getSystemWindowInsetRight();
      bottom -= mLastInsets.getSystemWindowInsetBottom();
    }
    Rect localRect2 = mTempRect2;
    GravityCompat.apply(resolveGravity(gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(left, top, right, bottom);
  }
  
  private void layoutChildWithAnchor(View paramView1, View paramView2, int paramInt)
  {
    paramView1.getLayoutParams();
    Rect localRect1 = mTempRect1;
    Rect localRect2 = mTempRect2;
    getDescendantRect(paramView2, localRect1);
    getDesiredAnchoredChildRect(paramView1, paramInt, localRect1, localRect2);
    paramView1.layout(left, top, right, bottom);
  }
  
  private void layoutChildWithKeyline(View paramView, int paramInt1, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i1 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(gravity), paramInt2);
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    int i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = getKeyline(i) - j;
    paramInt2 = 0;
    switch (i1 & 0x7)
    {
    default: 
      switch (i1 & 0x70)
      {
      }
      break;
    }
    for (;;)
    {
      paramInt1 = Math.max(getPaddingLeft() + leftMargin, Math.min(paramInt1, n - getPaddingRight() - j - rightMargin));
      paramInt2 = Math.max(getPaddingTop() + topMargin, Math.min(paramInt2, m - getPaddingBottom() - k - bottomMargin));
      paramView.layout(paramInt1, paramInt2, paramInt1 + j, paramInt2 + k);
      return;
      paramInt1 += j;
      break;
      paramInt1 += j / 2;
      break;
      paramInt2 = k + 0;
      continue;
      paramInt2 = k / 2 + 0;
    }
  }
  
  static Behavior parseBehavior(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith(".")) {
      paramString = paramContext.getPackageName() + paramString;
    }
    do
    {
      try
      {
        Object localObject2 = (Map)sConstructors.get();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new HashMap();
          sConstructors.set(localObject1);
        }
        Constructor localConstructor = (Constructor)((Map)localObject1).get(paramString);
        localObject2 = localConstructor;
        if (localConstructor == null)
        {
          localObject2 = Class.forName(paramString, true, paramContext.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
          ((Constructor)localObject2).setAccessible(true);
          ((Map)localObject1).put(paramString, localObject2);
        }
        paramContext = (Behavior)((Constructor)localObject2).newInstance(new Object[] { paramContext, paramAttributeSet });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Could not inflate Behavior subclass " + paramString, paramContext);
      }
    } while (paramString.indexOf('.') >= 0);
    if (!TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
      paramString = WIDGET_PACKAGE_NAME + '.' + paramString;
    }
    for (;;)
    {
      break;
    }
  }
  
  private boolean performIntercept(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = false;
    int i = 0;
    Object localObject1 = null;
    int m = MotionEventCompat.getActionMasked(paramMotionEvent);
    List localList = mTempList1;
    getTopSortedChildren(localList);
    int n = localList.size();
    int j = 0;
    boolean bool2 = bool1;
    View localView;
    Object localObject2;
    Behavior localBehavior;
    boolean bool3;
    int k;
    if (j < n)
    {
      localView = (View)localList.get(j);
      localObject2 = (LayoutParams)localView.getLayoutParams();
      localBehavior = ((LayoutParams)localObject2).getBehavior();
      if (((bool1) || (i != 0)) && (m != 0))
      {
        localObject2 = localObject1;
        bool3 = bool1;
        k = i;
        if (localBehavior != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            long l = SystemClock.uptimeMillis();
            localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          }
          switch (paramInt)
          {
          default: 
            k = i;
            bool3 = bool1;
          }
        }
        for (;;)
        {
          j += 1;
          localObject1 = localObject2;
          bool1 = bool3;
          i = k;
          break;
          localBehavior.onInterceptTouchEvent(this, localView, (MotionEvent)localObject2);
          bool3 = bool1;
          k = i;
          continue;
          localBehavior.onTouchEvent(this, localView, (MotionEvent)localObject2);
          bool3 = bool1;
          k = i;
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (localBehavior == null) {}
      }
      switch (paramInt)
      {
      default: 
        label272:
        bool2 = bool1;
        if (bool1)
        {
          mBehaviorTouchView = localView;
          bool2 = bool1;
        }
        bool3 = ((LayoutParams)localObject2).didBlockInteraction();
        bool1 = ((LayoutParams)localObject2).isBlockingInteractionBelow(this, localView);
        if ((!bool1) || (bool3)) {
          break;
        }
      }
    }
    for (i = 1;; i = 0)
    {
      localObject2 = localObject1;
      bool3 = bool2;
      k = i;
      if (!bool1) {
        break;
      }
      localObject2 = localObject1;
      bool3 = bool2;
      k = i;
      if (i != 0) {
        break;
      }
      localList.clear();
      return bool2;
      bool1 = localBehavior.onInterceptTouchEvent(this, localView, paramMotionEvent);
      break label272;
      bool1 = localBehavior.onTouchEvent(this, localView, paramMotionEvent);
      break label272;
    }
  }
  
  private void prepareChildren()
  {
    mDependencySortedChildren.clear();
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      getResolvedLayoutParams(localView).findAnchorView(this, localView);
      mDependencySortedChildren.add(localView);
      i += 1;
    }
    selectionSort(mDependencySortedChildren, mLayoutDependencyComparator);
  }
  
  private void resetTouchBehaviors()
  {
    if (mBehaviorTouchView != null)
    {
      Behavior localBehavior = ((LayoutParams)mBehaviorTouchView.getLayoutParams()).getBehavior();
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        localBehavior.onTouchEvent(this, mBehaviorTouchView, localMotionEvent);
        localMotionEvent.recycle();
      }
      mBehaviorTouchView = null;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((LayoutParams)getChildAt(i).getLayoutParams()).resetTouchBehaviorTracking();
      i += 1;
    }
    mDisallowInterceptReset = false;
  }
  
  private static int resolveAnchoredChildGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 17;
    }
    return i;
  }
  
  private static int resolveGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388659;
    }
    return i;
  }
  
  private static int resolveKeylineGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  private static void selectionSort(List<View> paramList, Comparator<View> paramComparator)
  {
    if ((paramList == null) || (paramList.size() < 2)) {}
    for (;;)
    {
      return;
      View[] arrayOfView = new View[paramList.size()];
      paramList.toArray(arrayOfView);
      int n = arrayOfView.length;
      int i = 0;
      while (i < n)
      {
        int k = i;
        int j = i + 1;
        while (j < n)
        {
          int m = k;
          if (paramComparator.compare(arrayOfView[j], arrayOfView[k]) < 0) {
            m = j;
          }
          j += 1;
          k = m;
        }
        if (i != k)
        {
          View localView = arrayOfView[k];
          arrayOfView[k] = arrayOfView[i];
          arrayOfView[i] = localView;
        }
        i += 1;
      }
      paramList.clear();
      i = 0;
      while (i < n)
      {
        paramList.add(arrayOfView[i]);
        i += 1;
      }
    }
  }
  
  private WindowInsetsCompat setWindowInsets(WindowInsetsCompat paramWindowInsetsCompat)
  {
    boolean bool2 = true;
    WindowInsetsCompat localWindowInsetsCompat = paramWindowInsetsCompat;
    if (mLastInsets != paramWindowInsetsCompat)
    {
      mLastInsets = paramWindowInsetsCompat;
      if ((paramWindowInsetsCompat == null) || (paramWindowInsetsCompat.getSystemWindowInsetTop() <= 0)) {
        break label71;
      }
      bool1 = true;
      mDrawStatusBarBackground = bool1;
      if ((mDrawStatusBarBackground) || (getBackground() != null)) {
        break label76;
      }
    }
    label71:
    label76:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      setWillNotDraw(bool1);
      localWindowInsetsCompat = dispatchApplyWindowInsetsToBehaviors(paramWindowInsetsCompat);
      requestLayout();
      return localWindowInsetsCompat;
      bool1 = false;
      break;
    }
  }
  
  void addPreDrawListener()
  {
    if (mIsAttachedToWindow)
    {
      if (mOnPreDrawListener == null) {
        mOnPreDrawListener = new OnPreDrawListener();
      }
      getViewTreeObserver().addOnPreDrawListener(mOnPreDrawListener);
    }
    mNeedsPreDrawListener = true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  void dispatchDependentViewRemoved(View paramView)
  {
    int m = mDependencySortedChildren.size();
    int j = 0;
    int i = 0;
    if (i < m)
    {
      View localView = (View)mDependencySortedChildren.get(i);
      int k;
      if (localView == paramView) {
        k = 1;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j;
        if (j != 0)
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          Behavior localBehavior = localLayoutParams.getBehavior();
          k = j;
          if (localBehavior != null)
          {
            k = j;
            if (localLayoutParams.dependsOn(this, localView, paramView))
            {
              localBehavior.onDependentViewRemoved(this, localView, paramView);
              k = j;
            }
          }
        }
      }
    }
  }
  
  public void dispatchDependentViewsChanged(View paramView)
  {
    int m = mDependencySortedChildren.size();
    int j = 0;
    int i = 0;
    if (i < m)
    {
      View localView = (View)mDependencySortedChildren.get(i);
      int k;
      if (localView == paramView) {
        k = 1;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j;
        if (j != 0)
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          Behavior localBehavior = localLayoutParams.getBehavior();
          k = j;
          if (localBehavior != null)
          {
            k = j;
            if (localLayoutParams.dependsOn(this, localView, paramView))
            {
              localBehavior.onDependentViewChanged(this, localView, paramView);
              k = j;
            }
          }
        }
      }
    }
  }
  
  void dispatchOnDependentViewChanged(boolean paramBoolean)
  {
    int k = ViewCompat.getLayoutDirection(this);
    int m = mDependencySortedChildren.size();
    int i = 0;
    while (i < m)
    {
      View localView = (View)mDependencySortedChildren.get(i);
      Object localObject1 = (LayoutParams)localView.getLayoutParams();
      int j = 0;
      while (j < i)
      {
        localObject2 = (View)mDependencySortedChildren.get(j);
        if (mAnchorDirectChild == localObject2) {
          offsetChildToAnchor(localView, k);
        }
        j += 1;
      }
      localObject1 = mTempRect1;
      Object localObject2 = mTempRect2;
      getLastChildRect(localView, (Rect)localObject1);
      getChildRect(localView, true, (Rect)localObject2);
      if (!((Rect)localObject1).equals(localObject2))
      {
        recordLastChildRect(localView, (Rect)localObject2);
        j = i + 1;
        if (j < m)
        {
          localObject1 = (View)mDependencySortedChildren.get(j);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          Behavior localBehavior = ((LayoutParams)localObject2).getBehavior();
          if ((localBehavior != null) && (localBehavior.layoutDependsOn(this, (View)localObject1, localView)))
          {
            if ((paramBoolean) || (!((LayoutParams)localObject2).getChangedAfterNestedScroll())) {
              break label228;
            }
            ((LayoutParams)localObject2).resetChangedAfterNestedScroll();
          }
          for (;;)
          {
            j += 1;
            break;
            label228:
            boolean bool = localBehavior.onDependentViewChanged(this, (View)localObject1, localView);
            if (paramBoolean) {
              ((LayoutParams)localObject2).setChangedAfterNestedScroll(bool);
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public boolean doViewsOverlap(View paramView1, View paramView2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Rect localRect;
    if (paramView1.getVisibility() == 0)
    {
      bool1 = bool2;
      if (paramView2.getVisibility() == 0)
      {
        localRect = mTempRect1;
        if (paramView1.getParent() == this) {
          break label133;
        }
        bool1 = true;
        getChildRect(paramView1, bool1, localRect);
        paramView1 = mTempRect2;
        if (paramView2.getParent() == this) {
          break label138;
        }
      }
    }
    label133:
    label138:
    for (bool1 = true;; bool1 = false)
    {
      getChildRect(paramView2, bool1, paramView1);
      bool1 = bool2;
      if (left <= right)
      {
        bool1 = bool2;
        if (top <= bottom)
        {
          bool1 = bool2;
          if (right >= left)
          {
            bool1 = bool2;
            if (bottom >= top) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((mBehavior != null) && (mBehavior.getScrimOpacity(this, paramView) > 0.0F))
    {
      if (mScrimPaint == null) {
        mScrimPaint = new Paint();
      }
      mScrimPaint.setColor(mBehavior.getScrimColor(this, paramView));
      paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), mScrimPaint);
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = mStatusBarBackground;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  void ensurePreDrawListener()
  {
    int m = 0;
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      int k = m;
      if (i < j)
      {
        if (hasDependencies(getChildAt(i))) {
          k = 1;
        }
      }
      else
      {
        if (k != mNeedsPreDrawListener)
        {
          if (k == 0) {
            break;
          }
          addPreDrawListener();
        }
        return;
      }
      i += 1;
    }
    removePreDrawListener();
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  void getChildRect(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (paramBoolean)
    {
      getDescendantRect(paramView, paramRect);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  public List<View> getDependencies(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    List localList = mTempDependenciesList;
    localList.clear();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != paramView) && (localLayoutParams.dependsOn(this, paramView, localView))) {
        localList.add(localView);
      }
      i += 1;
    }
    return localList;
  }
  
  void getDescendantRect(View paramView, Rect paramRect)
  {
    ViewGroupUtils.getDescendantRect(this, paramView, paramRect);
  }
  
  void getDesiredAnchoredChildRect(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int n = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(gravity), paramInt);
    int i = GravityCompat.getAbsoluteGravity(resolveGravity(anchorGravity), paramInt);
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    label122:
    int j;
    switch (i & 0x7)
    {
    default: 
      paramInt = left;
      switch (i & 0x70)
      {
      default: 
        i = top;
        j = paramInt;
        switch (n & 0x7)
        {
        default: 
          j = paramInt - k;
        case 5: 
          label162:
          paramInt = i;
          switch (n & 0x70)
          {
          }
          break;
        }
        break;
      }
      break;
    }
    for (paramInt = i - m;; paramInt = i - m / 2)
    {
      n = getWidth();
      i = getHeight();
      j = Math.max(getPaddingLeft() + leftMargin, Math.min(j, n - getPaddingRight() - k - rightMargin));
      paramInt = Math.max(getPaddingTop() + topMargin, Math.min(paramInt, i - getPaddingBottom() - m - bottomMargin));
      paramRect2.set(j, paramInt, j + k, paramInt + m);
      return;
      paramInt = right;
      break;
      paramInt = left + paramRect1.width() / 2;
      break;
      i = bottom;
      break label122;
      i = top + paramRect1.height() / 2;
      break label122;
      j = paramInt - k / 2;
      break label162;
    }
  }
  
  void getLastChildRect(View paramView, Rect paramRect)
  {
    paramRect.set(((LayoutParams)paramView.getLayoutParams()).getLastChildRect());
  }
  
  public int getNestedScrollAxes()
  {
    return mNestedScrollingParentHelper.mNestedScrollAxes;
  }
  
  LayoutParams getResolvedLayoutParams(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    View localView;
    if (!mBehaviorResolved)
    {
      Class localClass = paramView.getClass();
      paramView = null;
      for (;;)
      {
        localView = paramView;
        if (localClass == null) {
          break;
        }
        paramView = (DefaultBehavior)localClass.getAnnotation(DefaultBehavior.class);
        localView = paramView;
        if (paramView != null) {
          break;
        }
        localClass = localClass.getSuperclass();
      }
      if (localView == null) {}
    }
    try
    {
      localLayoutParams.setBehavior((Behavior)localView.value().newInstance());
      mBehaviorResolved = true;
      return localLayoutParams;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.e("CoordinatorLayout", "Default behavior class " + localView.value().getName() + " could not be instantiated. Did you forget a default constructor?", paramView);
      }
    }
  }
  
  public Drawable getStatusBarBackground()
  {
    return mStatusBarBackground;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  boolean hasDependencies(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (mAnchorView != null) {
      return true;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label63;
      }
      View localView = getChildAt(i);
      if ((localView != paramView) && (localLayoutParams.dependsOn(this, paramView, localView))) {
        break;
      }
      i += 1;
    }
    label63:
    return false;
  }
  
  public boolean isPointInChildBounds(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = mTempRect1;
    getDescendantRect(paramView, localRect);
    return localRect.contains(paramInt1, paramInt2);
  }
  
  void offsetChildToAnchor(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (mAnchorView != null)
    {
      Object localObject = mTempRect1;
      Rect localRect1 = mTempRect2;
      Rect localRect2 = mTempRect3;
      getDescendantRect(mAnchorView, (Rect)localObject);
      getChildRect(paramView, false, localRect1);
      getDesiredAnchoredChildRect(paramView, paramInt, (Rect)localObject, localRect2);
      paramInt = left - left;
      int i = top - top;
      if (paramInt != 0) {
        paramView.offsetLeftAndRight(paramInt);
      }
      if (i != 0) {
        paramView.offsetTopAndBottom(i);
      }
      if ((paramInt != 0) || (i != 0))
      {
        localObject = localLayoutParams.getBehavior();
        if (localObject != null) {
          ((Behavior)localObject).onDependentViewChanged(this, paramView, mAnchorView);
        }
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    resetTouchBehaviors();
    if (mNeedsPreDrawListener)
    {
      if (mOnPreDrawListener == null) {
        mOnPreDrawListener = new OnPreDrawListener();
      }
      getViewTreeObserver().addOnPreDrawListener(mOnPreDrawListener);
    }
    if ((mLastInsets == null) && (ViewCompat.getFitsSystemWindows(this))) {
      ViewCompat.requestApplyInsets(this);
    }
    mIsAttachedToWindow = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    resetTouchBehaviors();
    if ((mNeedsPreDrawListener) && (mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(mOnPreDrawListener);
    }
    if (mNestedScrollingTarget != null) {
      onStopNestedScroll(mNestedScrollingTarget);
    }
    mIsAttachedToWindow = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((mDrawStatusBarBackground) && (mStatusBarBackground != null)) {
      if (mLastInsets == null) {
        break label61;
      }
    }
    label61:
    for (int i = mLastInsets.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        mStatusBarBackground.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0) {
      resetTouchBehaviors();
    }
    boolean bool = performIntercept(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      resetTouchBehaviors();
    }
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = ViewCompat.getLayoutDirection(this);
    paramInt3 = mDependencySortedChildren.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)mDependencySortedChildren.get(paramInt1);
      Behavior localBehavior = ((LayoutParams)localView.getLayoutParams()).getBehavior();
      if ((localBehavior == null) || (!localBehavior.onLayoutChild(this, localView, paramInt2))) {
        onLayoutChild(localView, paramInt2);
      }
      paramInt1 += 1;
    }
  }
  
  public void onLayoutChild(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.checkAnchorChanged()) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    if (mAnchorView != null)
    {
      layoutChildWithAnchor(paramView, mAnchorView, paramInt);
      return;
    }
    if (keyline >= 0)
    {
      layoutChildWithKeyline(paramView, keyline, paramInt);
      return;
    }
    layoutChild(paramView, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    prepareChildren();
    ensurePreDrawListener();
    int i7 = getPaddingLeft();
    int i8 = getPaddingTop();
    int i9 = getPaddingRight();
    int i10 = getPaddingBottom();
    int i11 = ViewCompat.getLayoutDirection(this);
    int j;
    int i12;
    int i13;
    int i14;
    int i15;
    int i2;
    int i1;
    int n;
    int k;
    label103:
    int m;
    label117:
    View localView;
    LayoutParams localLayoutParams;
    int i3;
    int i;
    int i4;
    int i5;
    if (i11 == 1)
    {
      j = 1;
      i12 = View.MeasureSpec.getMode(paramInt1);
      i13 = View.MeasureSpec.getSize(paramInt1);
      i14 = View.MeasureSpec.getMode(paramInt2);
      i15 = View.MeasureSpec.getSize(paramInt2);
      i2 = getSuggestedMinimumWidth();
      i1 = getSuggestedMinimumHeight();
      n = 0;
      if ((mLastInsets == null) || (!ViewCompat.getFitsSystemWindows(this))) {
        break label465;
      }
      k = 1;
      int i16 = mDependencySortedChildren.size();
      m = 0;
      if (m >= i16) {
        break label512;
      }
      localView = (View)mDependencySortedChildren.get(m);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i3 = 0;
      i = i3;
      if (keyline >= 0)
      {
        i = i3;
        if (i12 != 0)
        {
          i4 = getKeyline(keyline);
          i5 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(gravity), i11) & 0x7;
          if (((i5 != 3) || (j != 0)) && ((i5 != 5) || (j == 0))) {
            break label471;
          }
          i = Math.max(0, i13 - i9 - i4);
        }
      }
    }
    for (;;)
    {
      i4 = paramInt1;
      i5 = paramInt2;
      int i6 = i4;
      i3 = i5;
      if (k != 0)
      {
        i6 = i4;
        i3 = i5;
        if (!ViewCompat.getFitsSystemWindows(localView))
        {
          i5 = mLastInsets.getSystemWindowInsetLeft();
          i6 = mLastInsets.getSystemWindowInsetRight();
          i3 = mLastInsets.getSystemWindowInsetTop();
          i4 = mLastInsets.getSystemWindowInsetBottom();
          i6 = View.MeasureSpec.makeMeasureSpec(i13 - (i5 + i6), i12);
          i3 = View.MeasureSpec.makeMeasureSpec(i15 - (i3 + i4), i14);
        }
      }
      Behavior localBehavior = localLayoutParams.getBehavior();
      if ((localBehavior == null) || (!localBehavior.onMeasureChild(this, localView, i6, i, i3, 0))) {
        onMeasureChild(localView, i6, i, i3, 0);
      }
      i2 = Math.max(i2, localView.getMeasuredWidth() + (i7 + i9) + leftMargin + rightMargin);
      i1 = Math.max(i1, localView.getMeasuredHeight() + (i8 + i10) + topMargin + bottomMargin);
      n = ViewCompat.combineMeasuredStates(n, ViewCompat.getMeasuredState(localView));
      m += 1;
      break label117;
      j = 0;
      break;
      label465:
      k = 0;
      break label103;
      label471:
      if ((i5 != 5) || (j != 0))
      {
        i = i3;
        if (i5 == 3)
        {
          i = i3;
          if (j == 0) {}
        }
      }
      else
      {
        i = Math.max(0, i4 - i7);
      }
    }
    label512:
    setMeasuredDimension(ViewCompat.resolveSizeAndState(i2, paramInt1, 0xFF000000 & n), ViewCompat.resolveSizeAndState(i1, paramInt2, n << 16));
  }
  
  public void onMeasureChild(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool1 = false;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      boolean bool2 = bool1;
      if (((LayoutParams)localObject).isNestedScrollAccepted())
      {
        localObject = ((LayoutParams)localObject).getBehavior();
        bool2 = bool1;
        if (localObject != null) {
          bool2 = bool1 | ((Behavior)localObject).onNestedFling(this, localView, paramView, paramFloat1, paramFloat2, paramBoolean);
        }
      }
      i += 1;
      bool1 = bool2;
    }
    if (bool1) {
      dispatchOnDependentViewChanged(true);
    }
    return bool1;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      boolean bool2 = bool1;
      if (((LayoutParams)localObject).isNestedScrollAccepted())
      {
        localObject = ((LayoutParams)localObject).getBehavior();
        bool2 = bool1;
        if (localObject != null) {
          bool2 = bool1 | ((Behavior)localObject).onNestedPreFling(this, localView, paramView, paramFloat1, paramFloat2);
        }
      }
      i += 1;
      bool1 = bool2;
    }
    return bool1;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    int i1 = 0;
    int i3 = getChildCount();
    int k = 0;
    if (k < i3)
    {
      View localView = getChildAt(k);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      int i2 = i1;
      int n = i;
      int m = j;
      if (((LayoutParams)localObject).isNestedScrollAccepted())
      {
        localObject = ((LayoutParams)localObject).getBehavior();
        i2 = i1;
        n = i;
        m = j;
        if (localObject != null)
        {
          int[] arrayOfInt = mTempIntPair;
          mTempIntPair[1] = 0;
          arrayOfInt[0] = 0;
          ((Behavior)localObject).onNestedPreScroll(this, localView, paramView, paramInt1, paramInt2, mTempIntPair);
          if (paramInt1 <= 0) {
            break label186;
          }
          i = Math.max(i, mTempIntPair[0]);
          label137:
          if (paramInt2 <= 0) {
            break label202;
          }
        }
      }
      label186:
      label202:
      for (j = Math.max(j, mTempIntPair[1]);; j = Math.min(j, mTempIntPair[1]))
      {
        i2 = 1;
        m = j;
        n = i;
        k += 1;
        i1 = i2;
        i = n;
        j = m;
        break;
        i = Math.min(i, mTempIntPair[0]);
        break label137;
      }
    }
    paramArrayOfInt[0] = i;
    paramArrayOfInt[1] = j;
    if (i1 != 0) {
      dispatchOnDependentViewChanged(true);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = getChildCount();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      int k = j;
      if (((LayoutParams)localObject).isNestedScrollAccepted())
      {
        localObject = ((LayoutParams)localObject).getBehavior();
        k = j;
        if (localObject != null)
        {
          ((Behavior)localObject).onNestedScroll(this, localView, paramView, paramInt1, paramInt2, paramInt3, paramInt4);
          k = 1;
        }
      }
      i += 1;
      j = k;
    }
    if (j != 0) {
      dispatchOnDependentViewChanged(true);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    mNestedScrollingParentHelper.mNestedScrollAxes = paramInt;
    mNestedScrollingDirectChild = paramView1;
    mNestedScrollingTarget = paramView2;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      if (((LayoutParams)localObject).isNestedScrollAccepted())
      {
        localObject = ((LayoutParams)localObject).getBehavior();
        if (localObject != null) {
          ((Behavior)localObject).onNestedScrollAccepted(this, localView, paramView1, paramView2, paramInt);
        }
      }
      i += 1;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      paramParcelable = behaviorStates;
      int i = 0;
      int j = getChildCount();
      while (i < j)
      {
        View localView = getChildAt(i);
        int k = localView.getId();
        Behavior localBehavior = getResolvedLayoutParams(localView).getBehavior();
        if ((k != -1) && (localBehavior != null))
        {
          Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
          if (localParcelable != null) {
            localBehavior.onRestoreInstanceState(this, localView, localParcelable);
          }
        }
        i += 1;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      Behavior localBehavior = ((LayoutParams)((View)localObject).getLayoutParams()).getBehavior();
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.onSaveInstanceState(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    behaviorStates = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    boolean bool1 = false;
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      Behavior localBehavior = localLayoutParams.getBehavior();
      if (localBehavior != null)
      {
        boolean bool2 = localBehavior.onStartNestedScroll(this, localView, paramView1, paramView2, paramInt);
        bool1 |= bool2;
        localLayoutParams.acceptNestedScroll(bool2);
      }
      for (;;)
      {
        i += 1;
        break;
        localLayoutParams.acceptNestedScroll(false);
      }
    }
    return bool1;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    mNestedScrollingParentHelper.mNestedScrollAxes = 0;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.isNestedScrollAccepted())
      {
        Behavior localBehavior = localLayoutParams.getBehavior();
        if (localBehavior != null) {
          localBehavior.onStopNestedScroll(this, localView, paramView);
        }
        localLayoutParams.resetNestedScroll();
        localLayoutParams.resetChangedAfterNestedScroll();
      }
      i += 1;
    }
    mNestedScrollingDirectChild = null;
    mNestedScrollingTarget = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool4 = false;
    boolean bool2 = false;
    Object localObject = null;
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool3;
    boolean bool1;
    if (mBehaviorTouchView == null)
    {
      bool2 = performIntercept(paramMotionEvent, 1);
      bool3 = bool2;
      bool1 = bool4;
      if (!bool2) {}
    }
    else
    {
      Behavior localBehavior = ((LayoutParams)mBehaviorTouchView.getLayoutParams()).getBehavior();
      bool3 = bool2;
      bool1 = bool4;
      if (localBehavior != null)
      {
        bool1 = localBehavior.onTouchEvent(this, mBehaviorTouchView, paramMotionEvent);
        bool3 = bool2;
      }
    }
    if (mBehaviorTouchView == null)
    {
      bool2 = bool1 | super.onTouchEvent(paramMotionEvent);
      paramMotionEvent = (MotionEvent)localObject;
    }
    for (;;)
    {
      if (paramMotionEvent != null) {
        paramMotionEvent.recycle();
      }
      if ((i == 1) || (i == 3)) {
        resetTouchBehaviors();
      }
      return bool2;
      paramMotionEvent = (MotionEvent)localObject;
      bool2 = bool1;
      if (bool3)
      {
        long l = SystemClock.uptimeMillis();
        paramMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        super.onTouchEvent(paramMotionEvent);
        bool2 = bool1;
      }
    }
  }
  
  void recordLastChildRect(View paramView, Rect paramRect)
  {
    ((LayoutParams)paramView.getLayoutParams()).setLastChildRect(paramRect);
  }
  
  void removePreDrawListener()
  {
    if ((mIsAttachedToWindow) && (mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(mOnPreDrawListener);
    }
    mNeedsPreDrawListener = false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!mDisallowInterceptReset))
    {
      resetTouchBehaviors();
      mDisallowInterceptReset = true;
    }
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    mOnHierarchyChangeListener = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (mStatusBarBackground != paramDrawable)
    {
      if (mStatusBarBackground != null) {
        mStatusBarBackground.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      mStatusBarBackground = localDrawable;
      if (mStatusBarBackground != null)
      {
        if (mStatusBarBackground.isStateful()) {
          mStatusBarBackground.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        paramDrawable = mStatusBarBackground;
        if (getVisibility() != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      mStatusBarBackground.setCallback(this);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = ContextCompat.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      setStatusBarBackground(localDrawable);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((mStatusBarBackground != null) && (mStatusBarBackground.isVisible() != bool)) {
        mStatusBarBackground.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mStatusBarBackground);
  }
  
  private class ApplyInsetsListener
    implements OnApplyWindowInsetsListener
  {
    private ApplyInsetsListener() {}
    
    public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      return CoordinatorLayout.this.setWindowInsets(paramWindowInsetsCompat);
    }
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public static Object getTag(View paramView)
    {
      return getLayoutParamsmBehaviorTag;
    }
    
    public static void setTag(View paramView, Object paramObject)
    {
      getLayoutParamsmBehaviorTag = paramObject;
    }
    
    public boolean blocksInteractionBelow(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return getScrimOpacity(paramCoordinatorLayout, paramV) > 0.0F;
    }
    
    public int getScrimColor(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return -16777216;
    }
    
    public float getScrimOpacity(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return 0.0F;
    }
    
    public boolean isDirty(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return false;
    }
    
    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
    {
      return false;
    }
    
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout paramCoordinatorLayout, V paramV, WindowInsetsCompat paramWindowInsetsCompat)
    {
      return paramWindowInsetsCompat;
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
    {
      return false;
    }
    
    public void onDependentViewRemoved(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView) {}
    
    public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
    {
      return false;
    }
    
    public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return false;
    }
    
    public boolean onNestedFling(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean onNestedPreFling(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onNestedScrollAccepted(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt) {}
    
    public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return View.BaseSavedState.EMPTY_STATE;
    }
    
    public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt)
    {
      return false;
    }
    
    public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView) {}
    
    public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface DefaultBehavior
  {
    Class<? extends CoordinatorLayout.Behavior> value();
  }
  
  private class HierarchyChangeListener
    implements ViewGroup.OnHierarchyChangeListener
  {
    private HierarchyChangeListener() {}
    
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      if (mOnHierarchyChangeListener != null) {
        mOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      dispatchDependentViewRemoved(paramView2);
      if (mOnHierarchyChangeListener != null) {
        mOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int anchorGravity = 0;
    public int gravity = 0;
    public int keyline = -1;
    View mAnchorDirectChild;
    int mAnchorId = -1;
    View mAnchorView;
    CoordinatorLayout.Behavior mBehavior;
    boolean mBehaviorResolved = false;
    Object mBehaviorTag;
    private boolean mDidAcceptNestedScroll;
    private boolean mDidBlockInteraction;
    private boolean mDidChangeAfterNestedScroll;
    final Rect mLastChildRect = new Rect();
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout_LayoutParams);
      gravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
      mAnchorId = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_LayoutParams_layout_anchor, -1);
      anchorGravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
      keyline = localTypedArray.getInteger(R.styleable.CoordinatorLayout_LayoutParams_layout_keyline, -1);
      mBehaviorResolved = localTypedArray.hasValue(R.styleable.CoordinatorLayout_LayoutParams_layout_behavior);
      if (mBehaviorResolved) {
        mBehavior = CoordinatorLayout.parseBehavior(paramContext, paramAttributeSet, localTypedArray.getString(R.styleable.CoordinatorLayout_LayoutParams_layout_behavior));
      }
      localTypedArray.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    private void resolveAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
    {
      mAnchorView = paramCoordinatorLayout.findViewById(mAnchorId);
      if (mAnchorView != null)
      {
        if (mAnchorView == paramCoordinatorLayout)
        {
          if (paramCoordinatorLayout.isInEditMode())
          {
            mAnchorDirectChild = null;
            mAnchorView = null;
            return;
          }
          throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        }
        View localView = mAnchorView;
        for (ViewParent localViewParent = mAnchorView.getParent(); (localViewParent != paramCoordinatorLayout) && (localViewParent != null); localViewParent = localViewParent.getParent())
        {
          if (localViewParent == paramView)
          {
            if (paramCoordinatorLayout.isInEditMode())
            {
              mAnchorDirectChild = null;
              mAnchorView = null;
              return;
            }
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
          }
          if ((localViewParent instanceof View)) {
            localView = (View)localViewParent;
          }
        }
        mAnchorDirectChild = localView;
        return;
      }
      if (paramCoordinatorLayout.isInEditMode())
      {
        mAnchorDirectChild = null;
        mAnchorView = null;
        return;
      }
      throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + paramCoordinatorLayout.getResources().getResourceName(mAnchorId) + " to anchor view " + paramView);
    }
    
    private boolean verifyAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
    {
      if (mAnchorView.getId() != mAnchorId) {
        return false;
      }
      View localView = mAnchorView;
      for (ViewParent localViewParent = mAnchorView.getParent(); localViewParent != paramCoordinatorLayout; localViewParent = localViewParent.getParent())
      {
        if ((localViewParent == null) || (localViewParent == paramView))
        {
          mAnchorDirectChild = null;
          mAnchorView = null;
          return false;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
      }
      mAnchorDirectChild = localView;
      return true;
    }
    
    void acceptNestedScroll(boolean paramBoolean)
    {
      mDidAcceptNestedScroll = paramBoolean;
    }
    
    boolean checkAnchorChanged()
    {
      return (mAnchorView == null) && (mAnchorId != -1);
    }
    
    boolean dependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return (paramView2 == mAnchorDirectChild) || ((mBehavior != null) && (mBehavior.layoutDependsOn(paramCoordinatorLayout, paramView1, paramView2)));
    }
    
    boolean didBlockInteraction()
    {
      if (mBehavior == null) {
        mDidBlockInteraction = false;
      }
      return mDidBlockInteraction;
    }
    
    View findAnchorView(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      if (mAnchorId == -1)
      {
        mAnchorDirectChild = null;
        mAnchorView = null;
        return null;
      }
      if ((mAnchorView == null) || (!verifyAnchorView(paramView, paramCoordinatorLayout))) {
        resolveAnchorView(paramView, paramCoordinatorLayout);
      }
      return mAnchorView;
    }
    
    public int getAnchorId()
    {
      return mAnchorId;
    }
    
    public CoordinatorLayout.Behavior getBehavior()
    {
      return mBehavior;
    }
    
    boolean getChangedAfterNestedScroll()
    {
      return mDidChangeAfterNestedScroll;
    }
    
    Rect getLastChildRect()
    {
      return mLastChildRect;
    }
    
    void invalidateAnchor()
    {
      mAnchorDirectChild = null;
      mAnchorView = null;
    }
    
    boolean isBlockingInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      if (mDidBlockInteraction) {
        return true;
      }
      boolean bool2 = mDidBlockInteraction;
      if (mBehavior != null) {}
      for (boolean bool1 = mBehavior.blocksInteractionBelow(paramCoordinatorLayout, paramView);; bool1 = false)
      {
        bool1 |= bool2;
        mDidBlockInteraction = bool1;
        return bool1;
      }
    }
    
    boolean isDirty(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      return (mBehavior != null) && (mBehavior.isDirty(paramCoordinatorLayout, paramView));
    }
    
    boolean isNestedScrollAccepted()
    {
      return mDidAcceptNestedScroll;
    }
    
    void resetChangedAfterNestedScroll()
    {
      mDidChangeAfterNestedScroll = false;
    }
    
    void resetNestedScroll()
    {
      mDidAcceptNestedScroll = false;
    }
    
    void resetTouchBehaviorTracking()
    {
      mDidBlockInteraction = false;
    }
    
    public void setAnchorId(int paramInt)
    {
      invalidateAnchor();
      mAnchorId = paramInt;
    }
    
    public void setBehavior(CoordinatorLayout.Behavior paramBehavior)
    {
      if (mBehavior != paramBehavior)
      {
        mBehavior = paramBehavior;
        mBehaviorTag = null;
        mBehaviorResolved = true;
      }
    }
    
    void setChangedAfterNestedScroll(boolean paramBoolean)
    {
      mDidChangeAfterNestedScroll = paramBoolean;
    }
    
    void setLastChildRect(Rect paramRect)
    {
      mLastChildRect.set(paramRect);
    }
  }
  
  class OnPreDrawListener
    implements ViewTreeObserver.OnPreDrawListener
  {
    OnPreDrawListener() {}
    
    public boolean onPreDraw()
    {
      dispatchOnDependentViewChanged(false);
      return true;
    }
  }
  
  protected static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public final CoordinatorLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new CoordinatorLayout.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public final CoordinatorLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new CoordinatorLayout.SavedState[paramAnonymousInt];
      }
    });
    SparseArray<Parcelable> behaviorStates;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      behaviorStates = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        behaviorStates.append(arrayOfInt[i], paramParcel[i]);
        i += 1;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (behaviorStates != null) {}
      int[] arrayOfInt;
      Parcelable[] arrayOfParcelable;
      for (int i = behaviorStates.size();; i = 0)
      {
        paramParcel.writeInt(i);
        arrayOfInt = new int[i];
        arrayOfParcelable = new Parcelable[i];
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = behaviorStates.keyAt(j);
          arrayOfParcelable[j] = ((Parcelable)behaviorStates.valueAt(j));
          j += 1;
        }
      }
      paramParcel.writeIntArray(arrayOfInt);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
    }
  }
  
  static class ViewElevationComparator
    implements Comparator<View>
  {
    public int compare(View paramView1, View paramView2)
    {
      float f1 = ViewCompat.getZ(paramView1);
      float f2 = ViewCompat.getZ(paramView2);
      if (f1 > f2) {
        return -1;
      }
      if (f1 < f2) {
        return 1;
      }
      return 0;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CoordinatorLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */