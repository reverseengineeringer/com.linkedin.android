package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements NestedScrollingParent, DecorContentParent
{
  static final int[] ATTRS = { R.attr.actionBarSize, 16842841 };
  private final int ACTION_BAR_ANIMATE_DELAY = 600;
  private int mActionBarHeight;
  private ActionBarContainer mActionBarTop;
  private ActionBarVisibilityCallback mActionBarVisibilityCallback;
  private final Runnable mAddActionBarHideOffset = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
      ActionBarOverlayLayout.access$002(ActionBarOverlayLayout.this, ViewCompat.animate(mActionBarTop).translationY(-mActionBarTop.getHeight()).setListener(mTopAnimatorListener));
    }
  };
  private boolean mAnimatingForFling;
  private final Rect mBaseContentInsets = new Rect();
  private final Rect mBaseInnerInsets = new Rect();
  private ContentFrameLayout mContent;
  private final Rect mContentInsets = new Rect();
  private ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
  private DecorToolbar mDecorToolbar;
  private ScrollerCompat mFlingEstimator;
  private boolean mHasNonEmbeddedTabs;
  private boolean mHideOnContentScroll;
  private int mHideOnContentScrollReference;
  private boolean mIgnoreWindowContentOverlay;
  private final Rect mInnerInsets = new Rect();
  private final Rect mLastBaseContentInsets = new Rect();
  private final Rect mLastInnerInsets = new Rect();
  private int mLastSystemUiVisibility;
  public boolean mOverlayMode;
  private final NestedScrollingParentHelper mParentHelper;
  private final Runnable mRemoveActionBarHideOffset = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
      ActionBarOverlayLayout.access$002(ActionBarOverlayLayout.this, ViewCompat.animate(mActionBarTop).translationY(0.0F).setListener(mTopAnimatorListener));
    }
  };
  private final ViewPropertyAnimatorListener mTopAnimatorListener = new ViewPropertyAnimatorListenerAdapter()
  {
    public final void onAnimationCancel(View paramAnonymousView)
    {
      ActionBarOverlayLayout.access$002(ActionBarOverlayLayout.this, null);
      ActionBarOverlayLayout.access$102$1cca4512(ActionBarOverlayLayout.this);
    }
    
    public final void onAnimationEnd(View paramAnonymousView)
    {
      ActionBarOverlayLayout.access$002(ActionBarOverlayLayout.this, null);
      ActionBarOverlayLayout.access$102$1cca4512(ActionBarOverlayLayout.this);
    }
  };
  private Drawable mWindowContentOverlay;
  private int mWindowVisibility = 0;
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    mParentHelper = new NestedScrollingParentHelper(this);
  }
  
  private static boolean applyInsets$614d7dc0(View paramView, Rect paramRect, boolean paramBoolean)
  {
    boolean bool1 = false;
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (leftMargin != left)
    {
      bool1 = true;
      leftMargin = left;
    }
    if (topMargin != top)
    {
      bool1 = true;
      topMargin = top;
    }
    if (rightMargin != right)
    {
      bool1 = true;
      rightMargin = right;
    }
    boolean bool2 = bool1;
    if (paramBoolean)
    {
      bool2 = bool1;
      if (bottomMargin != bottom)
      {
        bool2 = true;
        bottomMargin = bottom;
      }
    }
    return bool2;
  }
  
  private void haltActionBarHideOffsetAnimations()
  {
    removeCallbacks(mRemoveActionBarHideOffset);
    removeCallbacks(mAddActionBarHideOffset);
    if (mCurrentActionBarTopAnimator != null) {
      mCurrentActionBarTopAnimator.cancel();
    }
  }
  
  private void init(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(ATTRS);
    mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    mWindowContentOverlay = localTypedArray.getDrawable(1);
    if (mWindowContentOverlay == null)
    {
      bool1 = true;
      setWillNotDraw(bool1);
      localTypedArray.recycle();
      if (getApplicationInfotargetSdkVersion >= 19) {
        break label91;
      }
    }
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      mIgnoreWindowContentOverlay = bool1;
      mFlingEstimator = ScrollerCompat.create(paramContext, null);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void pullChildren()
  {
    if (mContent == null)
    {
      mContent = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      mActionBarTop = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      localObject = findViewById(R.id.action_bar);
      if (!(localObject instanceof DecorToolbar)) {
        break label61;
      }
    }
    for (Object localObject = (DecorToolbar)localObject;; localObject = ((Toolbar)localObject).getWrapper())
    {
      mDecorToolbar = ((DecorToolbar)localObject);
      return;
      label61:
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + localObject.getClass().getSimpleName());
  }
  
  public final boolean canShowOverflowMenu()
  {
    pullChildren();
    return mDecorToolbar.canShowOverflowMenu();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final void dismissPopups()
  {
    pullChildren();
    mDecorToolbar.dismissPopupMenus();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((mWindowContentOverlay != null) && (!mIgnoreWindowContentOverlay)) {
      if (mActionBarTop.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(mActionBarTop.getBottom() + ViewCompat.getTranslationY(mActionBarTop) + 0.5F);; i = 0)
    {
      mWindowContentOverlay.setBounds(0, i, getWidth(), mWindowContentOverlay.getIntrinsicHeight() + i);
      mWindowContentOverlay.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    pullChildren();
    ViewCompat.getWindowSystemUiVisibility(this);
    boolean bool = applyInsets$614d7dc0(mActionBarTop, paramRect, false);
    mBaseInnerInsets.set(paramRect);
    ViewUtils.computeFitSystemWindows(this, mBaseInnerInsets, mBaseContentInsets);
    if (!mLastBaseContentInsets.equals(mBaseContentInsets))
    {
      bool = true;
      mLastBaseContentInsets.set(mBaseContentInsets);
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    if (mActionBarTop != null) {
      return -(int)ViewCompat.getTranslationY(mActionBarTop);
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return mParentHelper.mNestedScrollAxes;
  }
  
  public CharSequence getTitle()
  {
    pullChildren();
    return mDecorToolbar.getTitle();
  }
  
  public final boolean hideOverflowMenu()
  {
    pullChildren();
    return mDecorToolbar.hideOverflowMenu();
  }
  
  public final void initFeature(int paramInt)
  {
    pullChildren();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      mDecorToolbar.initProgress();
      return;
    case 5: 
      mDecorToolbar.initIndeterminateProgress();
      return;
    }
    setOverlayMode(true);
  }
  
  public final boolean isOverflowMenuShowPending()
  {
    pullChildren();
    return mDecorToolbar.isOverflowMenuShowPending();
  }
  
  public final boolean isOverflowMenuShowing()
  {
    pullChildren();
    return mDecorToolbar.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    init(getContext());
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    haltActionBarHideOffsetAnimations();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i = localView.getMeasuredWidth();
        int j = localView.getMeasuredHeight();
        int k = paramInt3 + leftMargin;
        int m = paramInt4 + topMargin;
        localView.layout(k, m, k + i, m + j);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    pullChildren();
    int i = 0;
    measureChildWithMargins(mActionBarTop, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)mActionBarTop.getLayoutParams();
    int i1 = Math.max(0, mActionBarTop.getMeasuredWidth() + leftMargin + rightMargin);
    int n = Math.max(0, mActionBarTop.getMeasuredHeight() + topMargin + bottomMargin);
    int m = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(mActionBarTop));
    int j;
    int k;
    if ((ViewCompat.getWindowSystemUiVisibility(this) & 0x100) != 0)
    {
      j = 1;
      if (j == 0) {
        break label432;
      }
      k = mActionBarHeight;
      i = k;
      if (mHasNonEmbeddedTabs)
      {
        i = k;
        if (mActionBarTop.getTabContainer() != null) {
          i = k + mActionBarHeight;
        }
      }
      label149:
      mContentInsets.set(mBaseContentInsets);
      mInnerInsets.set(mBaseInnerInsets);
      if ((mOverlayMode) || (j != 0)) {
        break label455;
      }
      localObject = mContentInsets;
      top += i;
      localObject = mContentInsets;
    }
    for (bottom += 0;; bottom += 0)
    {
      applyInsets$614d7dc0(mContent, mContentInsets, true);
      if (!mLastInnerInsets.equals(mInnerInsets))
      {
        mLastInnerInsets.set(mInnerInsets);
        mContent.dispatchFitSystemWindows(mInnerInsets);
      }
      measureChildWithMargins(mContent, paramInt1, 0, paramInt2, 0);
      localObject = (LayoutParams)mContent.getLayoutParams();
      i = Math.max(i1, mContent.getMeasuredWidth() + leftMargin + rightMargin);
      j = Math.max(n, mContent.getMeasuredHeight() + topMargin + bottomMargin);
      k = ViewUtils.combineMeasuredStates(m, ViewCompat.getMeasuredState(mContent));
      m = getPaddingLeft();
      n = getPaddingRight();
      j = Math.max(getPaddingTop() + getPaddingBottom() + j, getSuggestedMinimumHeight());
      setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), ViewCompat.resolveSizeAndState(j, paramInt2, k << 16));
      return;
      j = 0;
      break;
      label432:
      if (mActionBarTop.getVisibility() == 8) {
        break label149;
      }
      i = mActionBarTop.getMeasuredHeight();
      break label149;
      label455:
      localObject = mInnerInsets;
      top += i;
      localObject = mInnerInsets;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = 0;
    if ((!mHideOnContentScroll) || (!paramBoolean)) {
      return false;
    }
    mFlingEstimator.fling$69c647f5(0, 0, (int)paramFloat2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    if (mFlingEstimator.getFinalY() > mActionBarTop.getHeight()) {
      i = 1;
    }
    if (i != 0)
    {
      haltActionBarHideOffsetAnimations();
      mAddActionBarHideOffset.run();
    }
    for (;;)
    {
      mAnimatingForFling = true;
      return true;
      haltActionBarHideOffsetAnimations();
      mRemoveActionBarHideOffset.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mHideOnContentScrollReference += paramInt2;
    setActionBarHideOffset(mHideOnContentScrollReference);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    mParentHelper.mNestedScrollAxes = paramInt;
    mHideOnContentScrollReference = getActionBarHideOffset();
    haltActionBarHideOffsetAnimations();
    if (mActionBarVisibilityCallback != null) {
      mActionBarVisibilityCallback.onContentScrollStarted();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (mActionBarTop.getVisibility() != 0)) {
      return false;
    }
    return mHideOnContentScroll;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((mHideOnContentScroll) && (!mAnimatingForFling))
    {
      if (mHideOnContentScrollReference <= mActionBarTop.getHeight())
      {
        haltActionBarHideOffsetAnimations();
        postDelayed(mRemoveActionBarHideOffset, 600L);
      }
    }
    else {
      return;
    }
    haltActionBarHideOffsetAnimations();
    postDelayed(mAddActionBarHideOffset, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    pullChildren();
    int k = mLastSystemUiVisibility;
    mLastSystemUiVisibility = paramInt;
    int i;
    int j;
    if ((paramInt & 0x4) == 0)
    {
      i = 1;
      if ((paramInt & 0x100) == 0) {
        break label120;
      }
      j = 1;
      label49:
      if (mActionBarVisibilityCallback != null)
      {
        ActionBarVisibilityCallback localActionBarVisibilityCallback = mActionBarVisibilityCallback;
        if (j != 0) {
          break label125;
        }
        label66:
        localActionBarVisibilityCallback.enableContentAnimations(bool);
        if ((i == 0) && (j != 0)) {
          break label131;
        }
        mActionBarVisibilityCallback.showForSystem();
      }
    }
    for (;;)
    {
      if ((((k ^ paramInt) & 0x100) != 0) && (mActionBarVisibilityCallback != null)) {
        ViewCompat.requestApplyInsets(this);
      }
      return;
      i = 0;
      break;
      label120:
      j = 0;
      break label49;
      label125:
      bool = false;
      break label66;
      label131:
      mActionBarVisibilityCallback.hideForSystem();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    mWindowVisibility = paramInt;
    if (mActionBarVisibilityCallback != null) {
      mActionBarVisibilityCallback.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    haltActionBarHideOffsetAnimations();
    paramInt = Math.max(0, Math.min(paramInt, mActionBarTop.getHeight()));
    ViewCompat.setTranslationY(mActionBarTop, -paramInt);
  }
  
  public void setActionBarVisibilityCallback(ActionBarVisibilityCallback paramActionBarVisibilityCallback)
  {
    mActionBarVisibilityCallback = paramActionBarVisibilityCallback;
    if (getWindowToken() != null)
    {
      mActionBarVisibilityCallback.onWindowVisibilityChanged(mWindowVisibility);
      if (mLastSystemUiVisibility != 0)
      {
        onWindowSystemUiVisibilityChanged(mLastSystemUiVisibility);
        ViewCompat.requestApplyInsets(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    mHasNonEmbeddedTabs = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != mHideOnContentScroll)
    {
      mHideOnContentScroll = paramBoolean;
      if (!paramBoolean)
      {
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    pullChildren();
    mDecorToolbar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    pullChildren();
    mDecorToolbar.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    pullChildren();
    mDecorToolbar.setLogo(paramInt);
  }
  
  public final void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    pullChildren();
    mDecorToolbar.setMenu(paramMenu, paramCallback);
  }
  
  public final void setMenuPrepared()
  {
    pullChildren();
    mDecorToolbar.setMenuPrepared();
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    mOverlayMode = paramBoolean;
    if ((paramBoolean) && (getContextgetApplicationInfotargetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      mIgnoreWindowContentOverlay = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    pullChildren();
    mDecorToolbar.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    pullChildren();
    mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    pullChildren();
    return mDecorToolbar.showOverflowMenu();
  }
  
  public static abstract interface ActionBarVisibilityCallback
  {
    public abstract void enableContentAnimations(boolean paramBoolean);
    
    public abstract void hideForSystem();
    
    public abstract void onContentScrollStarted();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
    
    public abstract void showForSystem();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */