package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  private static final Comparator<ItemInfo> COMPARATOR = new Comparator() {};
  private static final int[] LAYOUT_ATTRS = { 16842931 };
  private static final Interpolator sInterpolator = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
  private int mActivePointerId = -1;
  private PagerAdapter mAdapter;
  private OnAdapterChangeListener mAdapterChangeListener;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  private int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable = new Runnable()
  {
    public final void run()
    {
      ViewPager.access$000$b020504(ViewPager.this);
      populate();
    }
  };
  private int mExpectedAdapterCount;
  private boolean mFakeDragging;
  private boolean mFirstLayout = true;
  private float mFirstOffset = -3.4028235E38F;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private OnPageChangeListener mInternalPageChangeListener;
  private boolean mIsBeingDragged;
  private boolean mIsScrollStarted;
  private boolean mIsUnableToDrag;
  private final ArrayList<ItemInfo> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset = Float.MAX_VALUE;
  private EdgeEffectCompat mLeftEdge;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets = false;
  private PagerObserver mObserver;
  private int mOffscreenPageLimit = 1;
  private OnPageChangeListener mOnPageChangeListener;
  private List<OnPageChangeListener> mOnPageChangeListeners;
  private int mPageMargin;
  private PageTransformer mPageTransformer;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState = null;
  private ClassLoader mRestoredClassLoader = null;
  private int mRestoredCurItem = -1;
  private EdgeEffectCompat mRightEdge;
  private int mScrollState = 0;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private Method mSetChildrenDrawingOrderEnabled;
  private final ItemInfo mTempItem = new ItemInfo();
  private final Rect mTempRect = new Rect();
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    ItemInfo localItemInfo = new ItemInfo();
    position = paramInt1;
    object = mAdapter.instantiateItem(this, paramInt1);
    widthFactor = 1.0F;
    if ((paramInt2 < 0) || (paramInt2 >= mItems.size()))
    {
      mItems.add(localItemInfo);
      return localItemInfo;
    }
    mItems.add(paramInt2, localItemInfo);
    return localItemInfo;
  }
  
  private boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    boolean bool;
    int i;
    int j;
    if (localView == this)
    {
      localObject = null;
      bool = false;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label332;
      }
      if (paramInt != 17) {
        break label278;
      }
      i = getChildRectInPagerCoordinatesmTempRect, localView).left;
      j = getChildRectInPagerCoordinatesmTempRect, (View)localObject).left;
      if ((localObject == null) || (i < j)) {
        break label268;
      }
      bool = pageLeft();
    }
    for (;;)
    {
      if (bool) {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      }
      return bool;
      localObject = localView;
      if (localView == null) {
        break;
      }
      j = 0;
      StringBuilder localStringBuilder;
      for (localObject = localView.getParent();; localObject = ((ViewParent)localObject).getParent())
      {
        i = j;
        if ((localObject instanceof ViewGroup))
        {
          if (localObject == this) {
            i = 1;
          }
        }
        else
        {
          localObject = localView;
          if (i != 0) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localView.getClass().getSimpleName());
          for (localObject = localView.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent()) {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
          }
        }
      }
      Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
      localObject = null;
      break;
      label268:
      bool = localView.requestFocus();
      continue;
      label278:
      if (paramInt == 66)
      {
        i = getChildRectInPagerCoordinatesmTempRect, localView).left;
        j = getChildRectInPagerCoordinatesmTempRect, (View)localObject).left;
        if ((localObject == null) || (i > j))
        {
          bool = localView.requestFocus();
          continue;
          label332:
          if ((paramInt == 17) || (paramInt == 1)) {
            bool = pageLeft();
          } else if ((paramInt != 66) && (paramInt != 2)) {}
        }
        else if ((mAdapter != null) && (mCurItem < mAdapter.getCount() - 1))
        {
          setCurrentItem(mCurItem + 1, true);
          bool = true;
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  private void calculatePageOffsets(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2)
  {
    int m = mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0)
    {
      f2 = mPageMargin / i;
      if (paramItemInfo2 == null) {
        break label393;
      }
      i = position;
      if (i < position)
      {
        j = 0;
        f1 = offset + widthFactor + f2;
        i += 1;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > position) || (j >= mItems.size())) {
          break label393;
        }
        for (paramItemInfo2 = (ItemInfo)mItems.get(j);; paramItemInfo2 = (ItemInfo)mItems.get(j))
        {
          f3 = f1;
          k = i;
          if (i <= position) {
            break;
          }
          f3 = f1;
          k = i;
          if (j >= mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < position)
        {
          f3 += 1.0F + f2;
          k += 1;
        }
        offset = f3;
        f1 = f3 + (widthFactor + f2);
        i = k + 1;
      }
    }
    if (i > position)
    {
      j = mItems.size() - 1;
      f1 = offset;
      i -= 1;
      while ((i >= position) && (j >= 0))
      {
        for (paramItemInfo2 = (ItemInfo)mItems.get(j);; paramItemInfo2 = (ItemInfo)mItems.get(j))
        {
          f3 = f1;
          k = i;
          if (i >= position) {
            break;
          }
          f3 = f1;
          k = i;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > position)
        {
          f3 -= 1.0F + f2;
          k -= 1;
        }
        f1 = f3 - (widthFactor + f2);
        offset = f1;
        i = k - 1;
      }
    }
    label393:
    int k = mItems.size();
    float f3 = offset;
    i = position - 1;
    if (position == 0)
    {
      f1 = offset;
      mFirstOffset = f1;
      if (position != m - 1) {
        break label526;
      }
      f1 = offset + widthFactor - 1.0F;
      label459:
      mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label579;
      }
      paramItemInfo2 = (ItemInfo)mItems.get(j);
      for (;;)
      {
        if (i > position)
        {
          i -= 1;
          f1 -= 1.0F + f2;
          continue;
          f1 = -3.4028235E38F;
          break;
          label526:
          f1 = Float.MAX_VALUE;
          break label459;
        }
      }
      f1 -= widthFactor + f2;
      offset = f1;
      if (position == 0) {
        mFirstOffset = f1;
      }
      j -= 1;
      i -= 1;
    }
    label579:
    float f1 = offset + widthFactor + f2;
    i = position + 1;
    int j = paramInt + 1;
    paramInt = i;
    i = j;
    while (i < k)
    {
      paramItemInfo1 = (ItemInfo)mItems.get(i);
      while (paramInt < position)
      {
        paramInt += 1;
        f1 += 1.0F + f2;
      }
      if (position == m - 1) {
        mLastOffset = (widthFactor + f1 - 1.0F);
      }
      offset = f1;
      f1 += widthFactor + f2;
      i += 1;
      paramInt += 1;
    }
    mNeedCalculatePageOffsets = false;
  }
  
  private boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i -= 1;
      break;
    }
    return false;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (mScrollState == 2)
    {
      i = 1;
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        if (mScroller.isFinished()) {
          break label170;
        }
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        mScroller.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = mScroller.getCurrX();
        int n = mScroller.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            pageScrolled(m);
          }
        }
      }
      mPopulatePending = false;
      int k = 0;
      j = i;
      i = k;
      while (i < mItems.size())
      {
        ItemInfo localItemInfo = (ItemInfo)mItems.get(i);
        if (scrolling)
        {
          j = 1;
          scrolling = false;
        }
        i += 1;
      }
      i = 0;
      break;
      label170:
      j = 0;
    }
    if (j != 0)
    {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, mEndScrollRunnable);
      }
    }
    else {
      return;
    }
    mEndScrollRunnable.run();
  }
  
  private void dispatchOnPageSelected(int paramInt)
  {
    if (mOnPageChangeListener != null) {
      mOnPageChangeListener.onPageSelected(paramInt);
    }
    if (mOnPageChangeListeners != null)
    {
      int i = 0;
      int j = mOnPageChangeListeners.size();
      while (i < j)
      {
        OnPageChangeListener localOnPageChangeListener = (OnPageChangeListener)mOnPageChangeListeners.get(i);
        if (localOnPageChangeListener != null) {
          localOnPageChangeListener.onPageSelected(paramInt);
        }
        i += 1;
      }
    }
    if (mInternalPageChangeListener != null) {
      mInternalPageChangeListener.onPageSelected(paramInt);
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null) {
      localRect.set(0, 0, 0, 0);
    }
    for (;;)
    {
      return localRect;
      left = paramView.getLeft();
      right = paramView.getRight();
      top = paramView.getTop();
      bottom = paramView.getBottom();
      for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
      {
        paramRect = (ViewGroup)paramRect;
        left += paramRect.getLeft();
        right += paramRect.getRight();
        top += paramRect.getTop();
        bottom += paramRect.getBottom();
      }
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private ItemInfo infoForAnyChild(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return infoForChild(paramView);
  }
  
  private ItemInfo infoForChild(View paramView)
  {
    int i = 0;
    while (i < mItems.size())
    {
      ItemInfo localItemInfo = (ItemInfo)mItems.get(i);
      if (mAdapter.isViewFromObject(paramView, object)) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  private ItemInfo infoForCurrentScrollPosition()
  {
    float f2 = 0.0F;
    int i = getClientWidth();
    float f1;
    int k;
    float f3;
    float f4;
    int j;
    Object localObject2;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i > 0) {
        f2 = mPageMargin / i;
      }
      k = -1;
      f3 = 0.0F;
      f4 = 0.0F;
      j = 1;
      localObject2 = null;
      i = 0;
    }
    for (;;)
    {
      Object localObject3 = localObject2;
      int m;
      Object localObject1;
      if (i < mItems.size())
      {
        localObject3 = (ItemInfo)mItems.get(i);
        m = i;
        localObject1 = localObject3;
        if (j == 0)
        {
          m = i;
          localObject1 = localObject3;
          if (position != k + 1)
          {
            localObject1 = mTempItem;
            offset = (f3 + f4 + f2);
            position = (k + 1);
            widthFactor = 1.0F;
            m = i - 1;
          }
        }
        f3 = offset;
        f4 = widthFactor;
        if (j == 0)
        {
          localObject3 = localObject2;
          if (f1 < f3) {}
        }
        else
        {
          if ((f1 >= f4 + f3 + f2) && (m != mItems.size() - 1)) {
            break label221;
          }
          localObject3 = localObject1;
        }
      }
      return (ItemInfo)localObject3;
      f1 = 0.0F;
      break;
      label221:
      j = 0;
      k = position;
      f4 = widthFactor;
      i = m + 1;
      localObject2 = localObject1;
    }
  }
  
  private ItemInfo infoForPosition(int paramInt)
  {
    int i = 0;
    while (i < mItems.size())
    {
      ItemInfo localItemInfo = (ItemInfo)mItems.get(i);
      if (position == paramInt) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  private void initViewPager()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = getResourcesgetDisplayMetricsdensity;
    mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    mMinimumVelocity = ((int)(400.0F * f));
    mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    mLeftEdge = new EdgeEffectCompat(localContext);
    mRightEdge = new EdgeEffectCompat(localContext);
    mFlingDistance = ((int)(25.0F * f));
    mCloseEnough = ((int)(2.0F * f));
    mDefaultGutterSize = ((int)(16.0F * f));
    ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      private final Rect mTempRect = new Rect();
      
      public final WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        paramAnonymousView = ViewCompat.onApplyWindowInsets(paramAnonymousView, paramAnonymousWindowInsetsCompat);
        if (paramAnonymousView.isConsumed()) {
          return paramAnonymousView;
        }
        paramAnonymousWindowInsetsCompat = mTempRect;
        left = paramAnonymousView.getSystemWindowInsetLeft();
        top = paramAnonymousView.getSystemWindowInsetTop();
        right = paramAnonymousView.getSystemWindowInsetRight();
        bottom = paramAnonymousView.getSystemWindowInsetBottom();
        int i = 0;
        int j = getChildCount();
        while (i < j)
        {
          WindowInsetsCompat localWindowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(getChildAt(i), paramAnonymousView);
          left = Math.min(localWindowInsetsCompat.getSystemWindowInsetLeft(), left);
          top = Math.min(localWindowInsetsCompat.getSystemWindowInsetTop(), top);
          right = Math.min(localWindowInsetsCompat.getSystemWindowInsetRight(), right);
          bottom = Math.min(localWindowInsetsCompat.getSystemWindowInsetBottom(), bottom);
          i += 1;
        }
        return paramAnonymousView.replaceSystemWindowInsets(left, top, right, bottom);
      }
    });
  }
  
  private void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    Object localObject;
    int j;
    if (mDecorChildCount > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      int k = getPaddingRight();
      int i2 = getWidth();
      int i3 = getChildCount();
      int m = 0;
      if (m < i3)
      {
        localObject = getChildAt(m);
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        j = i;
        int n = k;
        if (isDecor) {
          switch (gravity & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            j = i;
          }
        }
        for (;;)
        {
          int i4 = j + i1 - ((View)localObject).getLeft();
          j = i;
          n = k;
          if (i4 != 0)
          {
            ((View)localObject).offsetLeftAndRight(i4);
            n = k;
            j = i;
          }
          m += 1;
          i = j;
          k = n;
          break;
          j = i;
          i += ((View)localObject).getWidth();
          continue;
          j = Math.max((i2 - ((View)localObject).getMeasuredWidth()) / 2, i);
          continue;
          j = i2 - k - ((View)localObject).getMeasuredWidth();
          k += ((View)localObject).getMeasuredWidth();
        }
      }
    }
    if (mOnPageChangeListener != null) {
      mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (mOnPageChangeListeners != null)
    {
      j = mOnPageChangeListeners.size();
      i = 0;
      while (i < j)
      {
        localObject = (OnPageChangeListener)mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((OnPageChangeListener)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i += 1;
      }
    }
    if (mInternalPageChangeListener != null) {
      mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (mPageTransformer != null)
    {
      paramInt2 = getScrollX();
      i = getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject = getChildAt(paramInt1);
        if (!getLayoutParamsisDecor)
        {
          paramFloat = (((View)localObject).getLeft() - paramInt2) / getClientWidth();
          mPageTransformer.transformPage((View)localObject, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    mCalledSuper = true;
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == mActivePointerId) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
      mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if (mVelocityTracker != null) {
        mVelocityTracker.clear();
      }
      return;
    }
  }
  
  private boolean pageLeft()
  {
    if (mCurItem > 0)
    {
      setCurrentItem(mCurItem - 1, true);
      return true;
    }
    return false;
  }
  
  private boolean pageScrolled(int paramInt)
  {
    if (mItems.size() == 0)
    {
      if (mFirstLayout) {}
      do
      {
        return false;
        mCalledSuper = false;
        onPageScrolled(0, 0.0F, 0);
      } while (mCalledSuper);
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    ItemInfo localItemInfo = infoForCurrentScrollPosition();
    int j = getClientWidth();
    int k = mPageMargin;
    float f = mPageMargin / j;
    int i = position;
    f = (paramInt / j - offset) / (widthFactor + f);
    paramInt = (int)((j + k) * f);
    mCalledSuper = false;
    onPageScrolled(i, f, paramInt);
    if (!mCalledSuper) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    return true;
  }
  
  private boolean performDrag(float paramFloat)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = mLastMotionX;
    mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * mFirstOffset;
    f1 = k * mLastOffset;
    int i = 1;
    int j = 1;
    ItemInfo localItemInfo1 = (ItemInfo)mItems.get(0);
    ItemInfo localItemInfo2 = (ItemInfo)mItems.get(mItems.size() - 1);
    if (position != 0)
    {
      i = 0;
      paramFloat = offset * k;
    }
    if (position != mAdapter.getCount() - 1)
    {
      j = 0;
      f1 = offset * k;
    }
    if (f2 < paramFloat) {
      if (i != 0) {
        bool1 = mLeftEdge.onPull(Math.abs(paramFloat - f2) / k);
      }
    }
    for (;;)
    {
      mLastMotionX += paramFloat - (int)paramFloat;
      scrollTo((int)paramFloat, getScrollY());
      pageScrolled((int)paramFloat);
      return bool1;
      bool1 = bool3;
      paramFloat = f2;
      if (f2 > f1)
      {
        bool1 = bool2;
        if (j != 0) {
          bool1 = mRightEdge.onPull(Math.abs(f2 - f1) / k);
        }
        paramFloat = f1;
      }
    }
  }
  
  private void populate(int paramInt)
  {
    Object localObject2 = null;
    if (mCurItem != paramInt)
    {
      localObject2 = infoForPosition(mCurItem);
      mCurItem = paramInt;
    }
    if (mAdapter == null) {
      sortChildDrawingOrder();
    }
    label339:
    label352:
    label367:
    label518:
    label531:
    label552:
    label561:
    label676:
    label729:
    label741:
    label887:
    label902:
    label914:
    label1033:
    label1287:
    label1293:
    for (;;)
    {
      return;
      if (mPopulatePending)
      {
        sortChildDrawingOrder();
        return;
      }
      if (getWindowToken() != null)
      {
        paramInt = mOffscreenPageLimit;
        int i2 = Math.max(0, mCurItem - paramInt);
        int n = mAdapter.getCount();
        int i1 = Math.min(n - 1, mCurItem + paramInt);
        if (n != mExpectedAdapterCount) {
          try
          {
            String str = getResources().getResourceName(getId());
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + mExpectedAdapterCount + ", found: " + n + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + mAdapter.getClass());
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            for (;;)
            {
              localObject1 = Integer.toHexString(getId());
            }
          }
        }
        Object localObject3 = null;
        paramInt = 0;
        Object localObject1 = localObject3;
        Object localObject4;
        if (paramInt < mItems.size())
        {
          localObject4 = (ItemInfo)mItems.get(paramInt);
          if (position < mCurItem) {
            break label518;
          }
          localObject1 = localObject3;
          if (position == mCurItem) {
            localObject1 = localObject4;
          }
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = localObject1;
          if (n > 0) {
            localObject3 = addNewItem(mCurItem, paramInt);
          }
        }
        int i;
        if (localObject3 != null)
        {
          float f3 = 0.0F;
          int m = paramInt - 1;
          int i3;
          float f2;
          int j;
          if (m >= 0)
          {
            localObject1 = (ItemInfo)mItems.get(m);
            i3 = getClientWidth();
            if (i3 > 0) {
              break label531;
            }
            f2 = 0.0F;
            k = mCurItem - 1;
            localObject4 = localObject1;
            j = paramInt;
            if (k < 0) {
              break label676;
            }
            if ((f3 < f2) || (k >= i2)) {
              break label561;
            }
            if (localObject4 == null) {
              break label676;
            }
            paramInt = j;
            f1 = f3;
            localObject1 = localObject4;
            i = m;
            if (k == position)
            {
              paramInt = j;
              f1 = f3;
              localObject1 = localObject4;
              i = m;
              if (!scrolling)
              {
                mItems.remove(m);
                mAdapter.destroyItem(this, k, object);
                i = m - 1;
                paramInt = j - 1;
                if (i < 0) {
                  break label552;
                }
                localObject1 = (ItemInfo)mItems.get(i);
              }
            }
          }
          for (float f1 = f3;; f1 = f3)
          {
            k -= 1;
            j = paramInt;
            f3 = f1;
            localObject4 = localObject1;
            m = i;
            break label367;
            paramInt += 1;
            break;
            localObject1 = null;
            break label339;
            f2 = 2.0F - widthFactor + getPaddingLeft() / i3;
            break label352;
            localObject1 = null;
          }
          if ((localObject4 != null) && (k == position))
          {
            f1 = f3 + widthFactor;
            i = m - 1;
            if (i >= 0) {}
            for (localObject1 = (ItemInfo)mItems.get(i);; localObject1 = null)
            {
              paramInt = j;
              break;
            }
          }
          f1 = f3 + addNewItem1widthFactor;
          paramInt = j + 1;
          if (m >= 0) {}
          for (localObject1 = (ItemInfo)mItems.get(m);; localObject1 = null)
          {
            i = m;
            break;
          }
          f3 = widthFactor;
          int k = j + 1;
          if (f3 < 2.0F)
          {
            if (k < mItems.size())
            {
              localObject1 = (ItemInfo)mItems.get(k);
              if (i3 > 0) {
                break label887;
              }
              f2 = 0.0F;
              i = mCurItem + 1;
              localObject4 = localObject1;
              if (i >= n) {
                break label1033;
              }
              if ((f3 < f2) || (i <= i1)) {
                break label914;
              }
              if (localObject4 == null) {
                break label1033;
              }
              f1 = f3;
              localObject1 = localObject4;
              paramInt = k;
              if (i == position)
              {
                f1 = f3;
                localObject1 = localObject4;
                paramInt = k;
                if (!scrolling)
                {
                  mItems.remove(k);
                  mAdapter.destroyItem(this, i, object);
                  if (k >= mItems.size()) {
                    break label902;
                  }
                  localObject1 = (ItemInfo)mItems.get(k);
                  paramInt = k;
                  f1 = f3;
                }
              }
            }
            for (;;)
            {
              i += 1;
              f3 = f1;
              localObject4 = localObject1;
              k = paramInt;
              break label741;
              localObject1 = null;
              break;
              f2 = getPaddingRight() / i3 + 2.0F;
              break label729;
              localObject1 = null;
              f1 = f3;
              paramInt = k;
            }
            if ((localObject4 != null) && (i == position))
            {
              f1 = f3 + widthFactor;
              paramInt = k + 1;
              if (paramInt < mItems.size()) {}
              for (localObject1 = (ItemInfo)mItems.get(paramInt);; localObject1 = null) {
                break;
              }
            }
            localObject1 = addNewItem(i, k);
            paramInt = k + 1;
            f1 = f3 + widthFactor;
            if (paramInt < mItems.size()) {}
            for (localObject1 = (ItemInfo)mItems.get(paramInt);; localObject1 = null) {
              break;
            }
          }
          calculatePageOffsets((ItemInfo)localObject3, j, (ItemInfo)localObject2);
        }
        localObject2 = mAdapter;
        paramInt = mCurItem;
        if (localObject3 != null) {}
        for (localObject1 = object;; localObject1 = null)
        {
          ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
          mAdapter.finishUpdate(this);
          i = getChildCount();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = getChildAt(paramInt);
            localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
            childIndex = paramInt;
            if ((!isDecor) && (widthFactor == 0.0F))
            {
              localObject2 = infoForChild((View)localObject2);
              if (localObject2 != null)
              {
                widthFactor = widthFactor;
                position = position;
              }
            }
            paramInt += 1;
          }
        }
        sortChildDrawingOrder();
        if (hasFocus())
        {
          localObject1 = findFocus();
          if (localObject1 != null) {}
          for (localObject1 = infoForAnyChild((View)localObject1);; localObject1 = null)
          {
            if ((localObject1 != null) && (position == mCurItem)) {
              break label1293;
            }
            paramInt = 0;
            for (;;)
            {
              if (paramInt >= getChildCount()) {
                break label1287;
              }
              localObject1 = getChildAt(paramInt);
              localObject2 = infoForChild((View)localObject1);
              if ((localObject2 != null) && (position == mCurItem) && (((View)localObject1).requestFocus(2))) {
                break;
              }
              paramInt += 1;
            }
            break;
          }
        }
      }
    }
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!mItems.isEmpty()))
    {
      if (!mScroller.isFinished())
      {
        mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
      }
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      scrollTo((int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3)), getScrollY());
      return;
    }
    ItemInfo localItemInfo = infoForPosition(mCurItem);
    if (localItemInfo != null) {}
    for (float f = Math.min(offset, mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      completeScroll(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void requestParentDisallowInterceptTouchEvent$1385ff()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private boolean resetTouch()
  {
    mActivePointerId = -1;
    mIsBeingDragged = false;
    mIsUnableToDrag = false;
    if (mVelocityTracker != null)
    {
      mVelocityTracker.recycle();
      mVelocityTracker = null;
    }
    return mLeftEdge.onRelease() | mRightEdge.onRelease();
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ItemInfo localItemInfo = infoForPosition(paramInt1);
    int j = 0;
    if (localItemInfo != null) {
      j = (int)(getClientWidth() * Math.max(mFirstOffset, Math.min(offset, mLastOffset)));
    }
    if (paramBoolean1)
    {
      if (getChildCount() == 0)
      {
        setScrollingCacheEnabled(false);
        if (paramBoolean2) {
          dispatchOnPageSelected(paramInt1);
        }
        return;
      }
      int i;
      if ((mScroller != null) && (!mScroller.isFinished()))
      {
        i = 1;
        label90:
        if (i == 0) {
          break label187;
        }
        if (!mIsScrollStarted) {
          break label175;
        }
        i = mScroller.getCurrX();
        label111:
        mScroller.abortAnimation();
        setScrollingCacheEnabled(false);
      }
      int k;
      int m;
      for (;;)
      {
        k = getScrollY();
        j -= i;
        m = 0 - k;
        if ((j != 0) || (m != 0)) {
          break label196;
        }
        completeScroll(false);
        populate();
        setScrollState(0);
        break;
        i = 0;
        break label90;
        label175:
        i = mScroller.getStartX();
        break label111;
        label187:
        i = getScrollX();
      }
      label196:
      setScrollingCacheEnabled(true);
      setScrollState(2);
      int n = getClientWidth();
      int i1 = n / 2;
      float f3 = Math.min(1.0F, 1.0F * Math.abs(j) / n);
      float f1 = i1;
      float f2 = i1;
      f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
      paramInt2 = Math.abs(paramInt2);
      if (paramInt2 > 0) {}
      for (paramInt2 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt2 = (int)((Math.abs(j) / (f1 * 1.0F + mPageMargin) + 1.0F) * 100.0F))
      {
        paramInt2 = Math.min(paramInt2, 600);
        mIsScrollStarted = false;
        mScroller.startScroll(i, k, j, m, paramInt2);
        ViewCompat.postInvalidateOnAnimation(this);
        break;
        f1 = n;
      }
    }
    if (paramBoolean2) {
      dispatchOnPageSelected(paramInt1);
    }
    completeScroll(false);
    scrollTo(j, 0);
    pageScrolled(j);
  }
  
  private void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  private void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = true;
    if ((mAdapter == null) || (mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (mCurItem == paramInt1) && (mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = mOffscreenPageLimit;
      if ((i <= mCurItem + paramInt1) && (i >= mCurItem - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < mItems.size())
      {
        mItems.get(paramInt1)).scrolling = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= mAdapter.getCount()) {
        i = mAdapter.getCount() - 1;
      }
    }
    if (mCurItem != i) {}
    for (paramBoolean2 = bool; mFirstLayout; paramBoolean2 = false)
    {
      mCurItem = i;
      if (paramBoolean2) {
        dispatchOnPageSelected(i);
      }
      requestLayout();
      return;
    }
    populate(i);
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  private void setScrollState(int paramInt)
  {
    int m = 0;
    if (mScrollState == paramInt) {}
    label38:
    label74:
    label80:
    do
    {
      return;
      mScrollState = paramInt;
      int i;
      int j;
      if (mPageTransformer != null)
      {
        if (paramInt != 0)
        {
          i = 1;
          int n = getChildCount();
          j = 0;
          if (j >= n) {
            break label80;
          }
          if (i == 0) {
            break label74;
          }
        }
        for (int k = 2;; k = 0)
        {
          ViewCompat.setLayerType(getChildAt(j), k, null);
          j += 1;
          break label38;
          i = 0;
          break;
        }
      }
      if (mOnPageChangeListener != null) {
        mOnPageChangeListener.onPageScrollStateChanged(paramInt);
      }
      if (mOnPageChangeListeners != null)
      {
        j = mOnPageChangeListeners.size();
        i = m;
        while (i < j)
        {
          OnPageChangeListener localOnPageChangeListener = (OnPageChangeListener)mOnPageChangeListeners.get(i);
          if (localOnPageChangeListener != null) {
            localOnPageChangeListener.onPageScrollStateChanged(paramInt);
          }
          i += 1;
        }
      }
    } while (mInternalPageChangeListener == null);
    mInternalPageChangeListener.onPageScrollStateChanged(paramInt);
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (mScrollingCacheEnabled != paramBoolean) {
      mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    if (mDrawingOrder != 0)
    {
      if (mDrawingOrderedChildren == null) {
        mDrawingOrderedChildren = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          mDrawingOrderedChildren.add(localView);
          i += 1;
        }
        mDrawingOrderedChildren.clear();
      }
      Collections.sort(mDrawingOrderedChildren, sPositionComparator);
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (position == mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    if (mOnPageChangeListeners == null) {
      mOnPageChangeListeners = new ArrayList();
    }
    mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (position == mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (LayoutParams)localLayoutParams;
    isDecor |= paramView instanceof Decor;
    if (mInLayout)
    {
      if ((paramLayoutParams != null) && (isDecor)) {
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      needsMeasure = true;
      addViewInLayout(paramView, paramInt, localLayoutParams);
      return;
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (mAdapter == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
        i = getClientWidth();
        j = getScrollX();
        if (paramInt >= 0) {
          break;
        }
      } while (j <= (int)(i * mFirstOffset));
      return true;
    } while ((paramInt <= 0) || (j >= (int)(i * mLastOffset)));
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    mIsScrollStarted = true;
    if ((!mScroller.isFinished()) && (mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = mScroller.getCurrX();
      int m = mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!pageScrolled(k))
        {
          mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    completeScroll(true);
  }
  
  final void dataSetChanged()
  {
    int i5 = mAdapter.getCount();
    mExpectedAdapterCount = i5;
    int i;
    int j;
    int k;
    int n;
    int i3;
    label60:
    Object localObject;
    int i4;
    int i2;
    int i1;
    int m;
    if ((mItems.size() < mOffscreenPageLimit * 2 + 1) && (mItems.size() < i5))
    {
      i = 1;
      j = mCurItem;
      k = 0;
      n = 0;
      i3 = i;
      if (n >= mItems.size()) {
        break label305;
      }
      localObject = (ItemInfo)mItems.get(n);
      i4 = mAdapter.getItemPosition(object);
      i2 = n;
      i1 = k;
      i = i3;
      m = j;
      if (i4 != -1)
      {
        if (i4 != -2) {
          break label245;
        }
        mItems.remove(n);
        i3 = n - 1;
        n = k;
        if (k == 0) {
          n = 1;
        }
        mAdapter.destroyItem(this, position, object);
        i = 1;
        i2 = i3;
        i1 = n;
        m = j;
        if (mCurItem == position)
        {
          m = Math.max(0, Math.min(mCurItem, i5 - 1));
          i = 1;
          i1 = n;
          i2 = i3;
        }
      }
    }
    for (;;)
    {
      n = i2 + 1;
      k = i1;
      i3 = i;
      j = m;
      break label60;
      i = 0;
      break;
      label245:
      i2 = n;
      i1 = k;
      i = i3;
      m = j;
      if (position != i4)
      {
        if (position == mCurItem) {
          j = i4;
        }
        position = i4;
        i = 1;
        i2 = n;
        i1 = k;
        m = j;
      }
    }
    label305:
    if (k != 0) {
      mAdapter.finishUpdate(this);
    }
    Collections.sort(mItems, COMPARATOR);
    if (i3 != 0)
    {
      k = getChildCount();
      i = 0;
      while (i < k)
      {
        localObject = (LayoutParams)getChildAt(i).getLayoutParams();
        if (!isDecor) {
          widthFactor = 0.0F;
        }
        i += 1;
      }
      setCurrentItemInternal(j, false, true);
      requestLayout();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      if (paramKeyEvent.getAction() == 0) {}
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      if (bool1) {
        bool2 = true;
      }
      return bool2;
      bool1 = arrowScroll(17);
      continue;
      bool1 = arrowScroll(66);
      continue;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
      {
        bool1 = arrowScroll(2);
      }
      else
      {
        if (!KeyEventCompat.hasModifiers(paramKeyEvent, 1)) {
          break;
        }
        bool1 = arrowScroll(1);
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (position == mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (mAdapter != null) && (mAdapter.getCount() > 1)))
    {
      int j;
      if (!mLeftEdge.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), mFirstOffset * m);
        mLeftEdge.setSize(i, m);
        j = mLeftEdge.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!mRightEdge.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(mLastOffset + 1.0F) * k);
        mRightEdge.setSize(n - i1 - i2, k);
        bool = j | mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      mLeftEdge.finish();
      mRightEdge.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
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
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (mDrawingOrder == 2) {}
    for (paramInt1 = paramInt1 - 1 - paramInt2;; paramInt1 = paramInt2) {
      return mDrawingOrderedChildren.get(paramInt1)).getLayoutParams()).childIndex;
    }
  }
  
  public int getCurrentItem()
  {
    return mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return mPageMargin;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(mEndScrollRunnable);
    if ((mScroller != null) && (!mScroller.isFinished())) {
      mScroller.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((mPageMargin > 0) && (mMarginDrawable != null) && (mItems.size() > 0) && (mAdapter != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = mPageMargin / m;
      int j = 0;
      Object localObject = (ItemInfo)mItems.get(0);
      float f1 = offset;
      int n = mItems.size();
      int i = position;
      int i1 = mItems.get(n - 1)).position;
      if (i < i1)
      {
        while ((i > position) && (j < n))
        {
          localObject = mItems;
          j += 1;
          localObject = (ItemInfo)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == position) {
          f2 = (offset + widthFactor) * m;
        }
        for (f1 = offset + widthFactor + f3;; f1 += 1.0F + f3)
        {
          if (mPageMargin + f2 > k)
          {
            mMarginDrawable.setBounds(Math.round(f2), mTopPageBounds, Math.round(mPageMargin + f2), mBottomPageBounds);
            mMarginDrawable.draw(paramCanvas);
          }
          if (f2 > k + m) {
            return;
          }
          i += 1;
          break;
          f2 = (1.0F + f1) * m;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      resetTouch();
      return false;
    }
    if (i != 0)
    {
      if (mIsBeingDragged) {
        return true;
      }
      if (mIsUnableToDrag) {
        return false;
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (mVelocityTracker == null) {
        mVelocityTracker = VelocityTracker.obtain();
      }
      mVelocityTracker.addMovement(paramMotionEvent);
      return mIsBeingDragged;
      i = mActivePointerId;
      if (i != -1)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        float f2 = MotionEventCompat.getX(paramMotionEvent, i);
        float f1 = f2 - mLastMotionX;
        float f4 = Math.abs(f1);
        float f3 = MotionEventCompat.getY(paramMotionEvent, i);
        float f5 = Math.abs(f3 - mInitialMotionY);
        if (f1 != 0.0F)
        {
          float f6 = mLastMotionX;
          if (((f6 < mGutterSize) && (f1 > 0.0F)) || ((f6 > getWidth() - mGutterSize) && (f1 < 0.0F))) {}
          for (i = 1; (i == 0) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)); i = 0)
          {
            mLastMotionX = f2;
            mLastMotionY = f3;
            mIsUnableToDrag = true;
            return false;
          }
        }
        if ((f4 > mTouchSlop) && (0.5F * f4 > f5))
        {
          mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent$1385ff();
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = mInitialMotionX + mTouchSlop;
            label328:
            mLastMotionX = f1;
            mLastMotionY = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((mIsBeingDragged) && (performDrag(f2)))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          f1 = mInitialMotionX - mTouchSlop;
          break label328;
          if (f5 > mTouchSlop) {
            mIsUnableToDrag = true;
          }
        }
        f1 = paramMotionEvent.getX();
        mInitialMotionX = f1;
        mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        mInitialMotionY = f1;
        mLastMotionY = f1;
        mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        mIsUnableToDrag = false;
        mIsScrollStarted = true;
        mScroller.computeScrollOffset();
        if ((mScrollState == 2) && (Math.abs(mScroller.getFinalX() - mScroller.getCurrX()) > mCloseEnough))
        {
          mScroller.abortAnimation();
          mPopulatePending = false;
          populate();
          mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent$1385ff();
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          mIsBeingDragged = false;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getChildCount();
    int i5 = paramInt3 - paramInt1;
    int i4 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i6 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    int j;
    LayoutParams localLayoutParams;
    if (m < i3)
    {
      localView = getChildAt(m);
      int i2 = k;
      int i1 = paramInt4;
      j = paramInt2;
      int n = i;
      paramInt3 = paramInt1;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = k;
        i1 = paramInt4;
        j = paramInt2;
        n = i;
        paramInt3 = paramInt1;
        if (isDecor)
        {
          paramInt3 = gravity;
          n = gravity;
          switch (paramInt3 & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            paramInt3 = paramInt2;
            j = paramInt2;
            label190:
            switch (n & 0x70)
            {
            default: 
              paramInt2 = paramInt1;
            }
            break;
          }
        }
      }
      for (;;)
      {
        paramInt3 += i6;
        localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, localView.getMeasuredHeight() + paramInt2);
        i2 = k + 1;
        paramInt3 = paramInt1;
        n = i;
        i1 = paramInt4;
        m += 1;
        k = i2;
        paramInt4 = i1;
        paramInt2 = j;
        i = n;
        paramInt1 = paramInt3;
        break;
        paramInt3 = paramInt2;
        j = paramInt2 + localView.getMeasuredWidth();
        break label190;
        paramInt3 = Math.max((i5 - localView.getMeasuredWidth()) / 2, paramInt2);
        j = paramInt2;
        break label190;
        paramInt3 = i5 - i - localView.getMeasuredWidth();
        i += localView.getMeasuredWidth();
        j = paramInt2;
        break label190;
        paramInt2 = paramInt1;
        paramInt1 += localView.getMeasuredHeight();
        continue;
        paramInt2 = Math.max((i4 - localView.getMeasuredHeight()) / 2, paramInt1);
        continue;
        paramInt2 = i4 - paramInt4 - localView.getMeasuredHeight();
        paramInt4 += localView.getMeasuredHeight();
      }
    }
    i = i5 - paramInt2 - i;
    paramInt3 = 0;
    while (paramInt3 < i3)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!isDecor)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if (localItemInfo != null)
          {
            j = paramInt2 + (int)(i * offset);
            if (needsMeasure)
            {
              needsMeasure = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(i * widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(j, paramInt1, localView.getMeasuredWidth() + j, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    mTopPageBounds = paramInt1;
    mBottomPageBounds = (i4 - paramInt4);
    mDecorChildCount = k;
    if (mFirstLayout) {
      scrollToItem(mCurItem, false, 0, false);
    }
    mFirstLayout = false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    mGutterSize = Math.min(paramInt1 / 10, mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i5 = getChildCount();
    int k = 0;
    View localView;
    LayoutParams localLayoutParams;
    if (k < i5)
    {
      localView = getChildAt(k);
      i = paramInt2;
      int j = paramInt1;
      int m;
      int i1;
      label179:
      int n;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt2;
        j = paramInt1;
        if (localLayoutParams != null)
        {
          i = paramInt2;
          j = paramInt1;
          if (isDecor)
          {
            j = gravity & 0x7;
            m = gravity & 0x70;
            i1 = Integer.MIN_VALUE;
            i = Integer.MIN_VALUE;
            if ((m != 48) && (m != 80)) {
              break label350;
            }
            m = 1;
            if ((j != 3) && (j != 5)) {
              break label356;
            }
            n = 1;
            label194:
            if (m == 0) {
              break label362;
            }
            j = 1073741824;
            label204:
            int i3 = paramInt1;
            i1 = paramInt2;
            int i2 = i3;
            int i4;
            if (width != -2)
            {
              i4 = 1073741824;
              j = i4;
              i2 = i3;
              if (width != -1)
              {
                i2 = width;
                j = i4;
              }
            }
            i3 = i1;
            if (height != -2)
            {
              i4 = 1073741824;
              i = i4;
              i3 = i1;
              if (height != -1)
              {
                i3 = height;
                i = i4;
              }
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, j), View.MeasureSpec.makeMeasureSpec(i3, i));
            if (m == 0) {
              break label382;
            }
            i = paramInt2 - localView.getMeasuredHeight();
            j = paramInt1;
          }
        }
      }
      for (;;)
      {
        k += 1;
        paramInt2 = i;
        paramInt1 = j;
        break;
        label350:
        m = 0;
        break label179;
        label356:
        n = 0;
        break label194;
        label362:
        j = i1;
        if (n == 0) {
          break label204;
        }
        i = 1073741824;
        j = i1;
        break label204;
        label382:
        i = paramInt2;
        j = paramInt1;
        if (n != 0)
        {
          j = paramInt1 - localView.getMeasuredWidth();
          i = paramInt2;
        }
      }
    }
    mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    mInLayout = true;
    populate();
    mInLayout = false;
    int i = getChildCount();
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!isDecor)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * widthFactor), 1073741824), mChildHeightMeasureSpec);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int j = getChildCount();
    int i;
    int k;
    if ((paramInt & 0x2) != 0)
    {
      i = 0;
      k = 1;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (position == mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          k = -1;
          j = -1;
          continue;
        }
      }
      i += k;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (mAdapter != null)
    {
      mAdapter.restoreState(adapterState, loader);
      setCurrentItemInternal(position, false, true);
      return;
    }
    mRestoredCurItem = position;
    mRestoredAdapterState = adapterState;
    mRestoredClassLoader = loader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    position = mCurItem;
    if (mAdapter != null) {
      adapterState = mAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      recomputeScrollPosition(paramInt1, paramInt3, mPageMargin, mPageMargin);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mFakeDragging) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((mAdapter == null) || (mAdapter.getCount() == 0)) {
      return false;
    }
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    boolean bool2 = false;
    boolean bool1 = bool2;
    float f1;
    float f2;
    label362:
    label396:
    int j;
    switch (i & 0xFF)
    {
    default: 
      bool1 = bool2;
    case 4: 
    case 0: 
    case 2: 
    case 1: 
      do
      {
        for (;;)
        {
          if (bool1) {
            ViewCompat.postInvalidateOnAnimation(this);
          }
          return true;
          mScroller.abortAnimation();
          mPopulatePending = false;
          populate();
          f1 = paramMotionEvent.getX();
          mInitialMotionX = f1;
          mLastMotionX = f1;
          f1 = paramMotionEvent.getY();
          mInitialMotionY = f1;
          mLastMotionY = f1;
          mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          bool1 = bool2;
          continue;
          if (mIsBeingDragged) {
            break label362;
          }
          i = MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId);
          if (i != -1) {
            break;
          }
          bool1 = resetTouch();
        }
        f1 = MotionEventCompat.getX(paramMotionEvent, i);
        float f3 = Math.abs(f1 - mLastMotionX);
        f2 = MotionEventCompat.getY(paramMotionEvent, i);
        float f4 = Math.abs(f2 - mLastMotionY);
        if ((f3 > mTouchSlop) && (f3 > f4))
        {
          mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent$1385ff();
          if (f1 - mInitialMotionX <= 0.0F) {
            break label396;
          }
        }
        for (f1 = mInitialMotionX + mTouchSlop;; f1 = mInitialMotionX - mTouchSlop)
        {
          mLastMotionX = f1;
          mLastMotionY = f2;
          setScrollState(1);
          setScrollingCacheEnabled(true);
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
          bool1 = bool2;
          if (!mIsBeingDragged) {
            break;
          }
          bool1 = performDrag(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId))) | false;
          break;
        }
        bool1 = bool2;
      } while (!mIsBeingDragged);
      Object localObject = mVelocityTracker;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, mMaximumVelocity);
      j = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, mActivePointerId);
      mPopulatePending = true;
      int k = getClientWidth();
      int m = getScrollX();
      localObject = infoForCurrentScrollPosition();
      f1 = mPageMargin / k;
      i = position;
      f2 = (m / k - offset) / (widthFactor + f1);
      if ((Math.abs((int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId)) - mInitialMotionX)) > mFlingDistance) && (Math.abs(j) > mMinimumVelocity)) {
        if (j > 0)
        {
          label559:
          if (mItems.size() <= 0) {
            break label774;
          }
          paramMotionEvent = (ItemInfo)mItems.get(0);
          localObject = (ItemInfo)mItems.get(mItems.size() - 1);
          i = Math.max(position, Math.min(i, position));
        }
      }
      break;
    }
    label774:
    for (;;)
    {
      setCurrentItemInternal(i, true, true, j);
      bool1 = resetTouch();
      break;
      i += 1;
      break label559;
      if (i >= mCurItem) {}
      for (f1 = 0.4F;; f1 = 0.6F)
      {
        i = (int)(f1 + (i + f2));
        break;
      }
      bool1 = bool2;
      if (!mIsBeingDragged) {
        break;
      }
      scrollToItem(mCurItem, true, 0, false);
      bool1 = resetTouch();
      break;
      i = MotionEventCompat.getActionIndex(paramMotionEvent);
      mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
      mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      bool1 = bool2;
      break;
      onSecondaryPointerUp(paramMotionEvent);
      mLastMotionX = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, mActivePointerId));
      bool1 = bool2;
      break;
    }
  }
  
  final void populate()
  {
    populate(mCurItem);
  }
  
  public void removeOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    if (mOnPageChangeListeners != null) {
      mOnPageChangeListeners.remove(paramOnPageChangeListener);
    }
  }
  
  public void removeView(View paramView)
  {
    if (mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (mAdapter != null)
    {
      mAdapter.setViewPagerObserver(null);
      int i = 0;
      while (i < mItems.size())
      {
        ItemInfo localItemInfo = (ItemInfo)mItems.get(i);
        mAdapter.destroyItem(this, position, object);
        i += 1;
      }
      mAdapter.finishUpdate(this);
      mItems.clear();
      int j;
      for (i = 0; i < getChildCount(); i = j + 1)
      {
        j = i;
        if (!getChildAtgetLayoutParamsisDecor)
        {
          removeViewAt(i);
          j = i - 1;
        }
      }
      mCurItem = 0;
      scrollTo(0, 0);
    }
    mAdapter = paramPagerAdapter;
    mExpectedAdapterCount = 0;
    boolean bool;
    if (mAdapter != null)
    {
      if (mObserver == null) {
        mObserver = new PagerObserver((byte)0);
      }
      mAdapter.setViewPagerObserver(mObserver);
      mPopulatePending = false;
      bool = mFirstLayout;
      mFirstLayout = true;
      mExpectedAdapterCount = mAdapter.getCount();
      if (mRestoredCurItem >= 0)
      {
        mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
        setCurrentItemInternal(mRestoredCurItem, false, true);
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
      }
    }
    else
    {
      return;
    }
    if (!bool)
    {
      populate();
      return;
    }
    requestLayout();
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (mSetChildrenDrawingOrderEnabled == null)) {}
    try
    {
      mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          Log.e("ViewPager", "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    mPopulatePending = false;
    if (!mFirstLayout) {}
    for (boolean bool = true;; bool = false)
    {
      setCurrentItemInternal(paramInt, bool, false);
      return;
    }
  }
  
  public final void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to 1");
      i = 1;
    }
    if (i != mOffscreenPageLimit)
    {
      mOffscreenPageLimit = i;
      populate();
    }
  }
  
  void setOnAdapterChangeListener(OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    mAdapterChangeListener = paramOnAdapterChangeListener;
  }
  
  @Deprecated
  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = mPageMargin;
    mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  public final void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer)
  {
    int i = 0;
    int k = 1;
    if (Build.VERSION.SDK_INT >= 11) {
      if (mPageTransformer == null) {
        break label67;
      }
    }
    label67:
    for (int j = 1;; j = 0)
    {
      if (1 != j) {
        i = 1;
      }
      mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(true);
      j = k;
      if (paramBoolean) {
        j = 2;
      }
      mDrawingOrder = j;
      if (i != 0) {
        populate();
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mMarginDrawable);
  }
  
  static abstract interface Decor {}
  
  static final class ItemInfo
  {
    Object object;
    float offset;
    int position;
    boolean scrolling;
    float widthFactor;
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.LAYOUT_ATTRS);
      gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  final class MyAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    MyAccessibilityDelegate() {}
    
    private boolean canScroll()
    {
      return (mAdapter != null) && (mAdapter.getCount() > 1);
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramView = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      paramView.setScrollable(canScroll());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (mAdapter != null))
      {
        paramView.setItemCount(mAdapter.getCount());
        paramView.setFromIndex(mCurItem);
        paramView.setToIndex(mCurItem);
      }
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (canScrollHorizontally(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (canScrollHorizontally(-1)) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        if (canScrollHorizontally(1))
        {
          setCurrentItem(mCurItem + 1);
          return true;
        }
        return false;
      }
      if (canScrollHorizontally(-1))
      {
        setCurrentItem(mCurItem - 1);
        return true;
      }
      return false;
    }
  }
  
  static abstract interface OnAdapterChangeListener {}
  
  public static abstract interface OnPageChangeListener
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  public static abstract interface PageTransformer
  {
    public abstract void transformPage(View paramView, float paramFloat);
  }
  
  private final class PagerObserver
    extends DataSetObserver
  {
    private PagerObserver() {}
    
    public final void onChanged()
    {
      dataSetChanged();
    }
    
    public final void onInvalidated()
    {
      dataSetChanged();
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() {});
    Parcelable adapterState;
    ClassLoader loader;
    int position;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      position = paramParcel.readInt();
      adapterState = paramParcel.readParcelable(localClassLoader);
      loader = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(position);
      paramParcel.writeParcelable(adapterState, paramInt);
    }
  }
  
  public static class SimpleOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt) {}
  }
  
  static final class ViewPositionComparator
    implements Comparator<View>
  {}
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */