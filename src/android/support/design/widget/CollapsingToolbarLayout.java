package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.R.id;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  private static final int SCRIM_ANIMATION_DURATION = 600;
  private final CollapsingTextHelper mCollapsingTextHelper;
  private boolean mCollapsingTitleEnabled;
  private Drawable mContentScrim;
  private int mCurrentOffset;
  private boolean mDrawCollapsingTitle;
  private View mDummyView;
  private int mExpandedMarginBottom;
  private int mExpandedMarginEnd;
  private int mExpandedMarginStart;
  private int mExpandedMarginTop;
  private WindowInsetsCompat mLastInsets;
  private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
  private boolean mRefreshToolbar = true;
  private int mScrimAlpha;
  private ValueAnimatorCompat mScrimAnimator;
  private boolean mScrimsAreShown;
  private Drawable mStatusBarScrim;
  private final Rect mTmpRect = new Rect();
  private Toolbar mToolbar;
  private View mToolbarDirectChild;
  private int mToolbarId;
  
  public CollapsingToolbarLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    mCollapsingTextHelper = new CollapsingTextHelper(this);
    mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CollapsingToolbarLayout, paramInt, R.style.Widget_Design_CollapsingToolbar);
    mCollapsingTextHelper.setExpandedTextGravity(paramContext.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    mCollapsingTextHelper.setCollapsedTextGravity(paramContext.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    paramInt = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
    mExpandedMarginBottom = paramInt;
    mExpandedMarginEnd = paramInt;
    mExpandedMarginTop = paramInt;
    mExpandedMarginStart = paramInt;
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
      mExpandedMarginStart = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
      mExpandedMarginEnd = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
      mExpandedMarginTop = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
      mExpandedMarginBottom = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    }
    mCollapsingTitleEnabled = paramContext.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(paramContext.getText(R.styleable.CollapsingToolbarLayout_title));
    mCollapsingTextHelper.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
    mCollapsingTextHelper.setCollapsedTextAppearance(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
      mCollapsingTextHelper.setExpandedTextAppearance(paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
      mCollapsingTextHelper.setCollapsedTextAppearance(paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    }
    setContentScrim(paramContext.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(paramContext.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
    mToolbarId = paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        return CollapsingToolbarLayout.this.setWindowInsets(paramAnonymousWindowInsetsCompat);
      }
    });
  }
  
  private void animateScrim(int paramInt)
  {
    ensureToolbar();
    Interpolator localInterpolator;
    if (mScrimAnimator == null)
    {
      mScrimAnimator = ViewUtils.createAnimator();
      mScrimAnimator.setDuration(600);
      ValueAnimatorCompat localValueAnimatorCompat = mScrimAnimator;
      if (paramInt > mScrimAlpha)
      {
        localInterpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        localValueAnimatorCompat.setInterpolator(localInterpolator);
        mScrimAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
          {
            CollapsingToolbarLayout.this.setScrimAlpha(paramAnonymousValueAnimatorCompat.getAnimatedIntValue());
          }
        });
      }
    }
    for (;;)
    {
      mScrimAnimator.setIntValues(mScrimAlpha, paramInt);
      mScrimAnimator.start();
      return;
      localInterpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
      break;
      if (mScrimAnimator.isRunning()) {
        mScrimAnimator.cancel();
      }
    }
  }
  
  private void ensureToolbar()
  {
    if (!mRefreshToolbar) {
      return;
    }
    mToolbar = null;
    mToolbarDirectChild = null;
    if (mToolbarId != -1)
    {
      mToolbar = ((Toolbar)findViewById(mToolbarId));
      if (mToolbar != null) {
        mToolbarDirectChild = findDirectChild(mToolbar);
      }
    }
    Object localObject2;
    int i;
    int j;
    if (mToolbar == null)
    {
      localObject2 = null;
      i = 0;
      j = getChildCount();
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = getChildAt(i);
        if ((localObject1 instanceof Toolbar)) {
          localObject1 = (Toolbar)localObject1;
        }
      }
      else
      {
        mToolbar = ((Toolbar)localObject1);
        updateDummyView();
        mRefreshToolbar = false;
        return;
      }
      i += 1;
    }
  }
  
  private View findDirectChild(View paramView)
  {
    View localView = paramView;
    for (paramView = paramView.getParent(); (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    return localView;
  }
  
  private static int getHeightWithMargins(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      return paramView.getHeight() + topMargin + bottomMargin;
    }
    return paramView.getHeight();
  }
  
  private static ViewOffsetHelper getViewOffsetHelper(View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper2 = (ViewOffsetHelper)paramView.getTag(R.id.view_offset_helper);
    ViewOffsetHelper localViewOffsetHelper1 = localViewOffsetHelper2;
    if (localViewOffsetHelper2 == null)
    {
      localViewOffsetHelper1 = new ViewOffsetHelper(paramView);
      paramView.setTag(R.id.view_offset_helper, localViewOffsetHelper1);
    }
    return localViewOffsetHelper1;
  }
  
  private void setScrimAlpha(int paramInt)
  {
    if (paramInt != mScrimAlpha)
    {
      if ((mContentScrim != null) && (mToolbar != null)) {
        ViewCompat.postInvalidateOnAnimation(mToolbar);
      }
      mScrimAlpha = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private WindowInsetsCompat setWindowInsets(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (mLastInsets != paramWindowInsetsCompat)
    {
      mLastInsets = paramWindowInsetsCompat;
      requestLayout();
    }
    return paramWindowInsetsCompat.consumeSystemWindowInsets();
  }
  
  private void updateDummyView()
  {
    if ((!mCollapsingTitleEnabled) && (mDummyView != null))
    {
      ViewParent localViewParent = mDummyView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(mDummyView);
      }
    }
    if ((mCollapsingTitleEnabled) && (mToolbar != null))
    {
      if (mDummyView == null) {
        mDummyView = new View(getContext());
      }
      if (mDummyView.getParent() == null) {
        mToolbar.addView(mDummyView, -1, -1);
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    ensureToolbar();
    if ((mToolbar == null) && (mContentScrim != null) && (mScrimAlpha > 0))
    {
      mContentScrim.mutate().setAlpha(mScrimAlpha);
      mContentScrim.draw(paramCanvas);
    }
    if ((mCollapsingTitleEnabled) && (mDrawCollapsingTitle)) {
      mCollapsingTextHelper.draw(paramCanvas);
    }
    if ((mStatusBarScrim != null) && (mScrimAlpha > 0)) {
      if (mLastInsets == null) {
        break label153;
      }
    }
    label153:
    for (int i = mLastInsets.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        mStatusBarScrim.setBounds(0, -mCurrentOffset, getWidth(), i - mCurrentOffset);
        mStatusBarScrim.mutate().setAlpha(mScrimAlpha);
        mStatusBarScrim.draw(paramCanvas);
      }
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    ensureToolbar();
    if ((paramView == mToolbar) && (mContentScrim != null) && (mScrimAlpha > 0))
    {
      mContentScrim.mutate().setAlpha(mScrimAlpha);
      mContentScrim.draw(paramCanvas);
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = mStatusBarScrim;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = mContentScrim;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(super.generateDefaultLayoutParams());
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCollapsedTitleGravity()
  {
    return mCollapsingTextHelper.getCollapsedTextGravity();
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    return mCollapsingTextHelper.getCollapsedTypeface();
  }
  
  public Drawable getContentScrim()
  {
    return mContentScrim;
  }
  
  public int getExpandedTitleGravity()
  {
    return mCollapsingTextHelper.getExpandedTextGravity();
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return mExpandedMarginBottom;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return mExpandedMarginEnd;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return mExpandedMarginStart;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return mExpandedMarginTop;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    return mCollapsingTextHelper.getExpandedTypeface();
  }
  
  final int getScrimTriggerOffset()
  {
    return ViewCompat.getMinimumHeight(this) * 2;
  }
  
  public Drawable getStatusBarScrim()
  {
    return mStatusBarScrim;
  }
  
  public CharSequence getTitle()
  {
    if (mCollapsingTitleEnabled) {
      return mCollapsingTextHelper.getText();
    }
    return null;
  }
  
  public boolean isTitleEnabled()
  {
    return mCollapsingTitleEnabled;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      if (mOnOffsetChangedListener == null) {
        mOnOffsetChangedListener = new OffsetUpdateListener(null);
      }
      ((AppBarLayout)localViewParent).addOnOffsetChangedListener(mOnOffsetChangedListener);
    }
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    if ((mOnOffsetChangedListener != null) && ((localViewParent instanceof AppBarLayout))) {
      ((AppBarLayout)localViewParent).removeOnOffsetChangedListener(mOnOffsetChangedListener);
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    label162:
    Object localObject;
    label179:
    int k;
    int m;
    if ((mCollapsingTitleEnabled) && (mDummyView != null))
    {
      if ((!ViewCompat.isAttachedToWindow(mDummyView)) || (mDummyView.getVisibility() != 0)) {
        break label315;
      }
      paramBoolean = true;
      mDrawCollapsingTitle = paramBoolean;
      if (mDrawCollapsingTitle)
      {
        j = 0;
        i = j;
        if (mToolbarDirectChild != null)
        {
          i = j;
          if (mToolbarDirectChild != this) {
            i = mToolbarDirectChild.getLayoutParams()).bottomMargin;
          }
        }
        ViewGroupUtils.getDescendantRect(this, mDummyView, mTmpRect);
        mCollapsingTextHelper.setCollapsedBounds(mTmpRect.left, paramInt4 - mTmpRect.height() - i, mTmpRect.right, paramInt4 - i);
        if (ViewCompat.getLayoutDirection(this) != 1) {
          break label320;
        }
        j = 1;
        localObject = mCollapsingTextHelper;
        if (j == 0) {
          break label326;
        }
        i = mExpandedMarginEnd;
        k = mTmpRect.bottom;
        m = mExpandedMarginTop;
        if (j == 0) {
          break label335;
        }
      }
    }
    label315:
    label320:
    label326:
    label335:
    for (int j = mExpandedMarginStart;; j = mExpandedMarginEnd)
    {
      ((CollapsingTextHelper)localObject).setExpandedBounds(i, m + k, paramInt3 - paramInt1 - j, paramInt4 - paramInt2 - mExpandedMarginBottom);
      mCollapsingTextHelper.recalculate();
      paramInt1 = 0;
      paramInt2 = getChildCount();
      while (paramInt1 < paramInt2)
      {
        localObject = getChildAt(paramInt1);
        if ((mLastInsets != null) && (!ViewCompat.getFitsSystemWindows((View)localObject)))
        {
          paramInt3 = mLastInsets.getSystemWindowInsetTop();
          if (((View)localObject).getTop() < paramInt3) {
            ViewCompat.offsetTopAndBottom((View)localObject, paramInt3);
          }
        }
        getViewOffsetHelper((View)localObject).onViewLayout();
        paramInt1 += 1;
      }
      paramBoolean = false;
      break;
      j = 0;
      break label162;
      i = mExpandedMarginStart;
      break label179;
    }
    if (mToolbar != null)
    {
      if ((mCollapsingTitleEnabled) && (TextUtils.isEmpty(mCollapsingTextHelper.getText()))) {
        mCollapsingTextHelper.setText(mToolbar.getTitle());
      }
      if ((mToolbarDirectChild == null) || (mToolbarDirectChild == this)) {
        setMinimumHeight(getHeightWithMargins(mToolbar));
      }
    }
    else
    {
      return;
    }
    setMinimumHeight(getHeightWithMargins(mToolbarDirectChild));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ensureToolbar();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (mContentScrim != null) {
      mContentScrim.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    mCollapsingTextHelper.setCollapsedTextGravity(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    mCollapsingTextHelper.setCollapsedTextAppearance(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    mCollapsingTextHelper.setCollapsedTextColor(paramInt);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    mCollapsingTextHelper.setCollapsedTypeface(paramTypeface);
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (mContentScrim != paramDrawable)
    {
      if (mContentScrim != null) {
        mContentScrim.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      mContentScrim = localDrawable;
      if (mContentScrim != null)
      {
        mContentScrim.setBounds(0, 0, getWidth(), getHeight());
        mContentScrim.setCallback(this);
        mContentScrim.setAlpha(mScrimAlpha);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    mCollapsingTextHelper.setExpandedTextColor(paramInt);
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    mCollapsingTextHelper.setExpandedTextGravity(paramInt);
  }
  
  public void setExpandedTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mExpandedMarginStart = paramInt1;
    mExpandedMarginTop = paramInt2;
    mExpandedMarginEnd = paramInt3;
    mExpandedMarginBottom = paramInt4;
    requestLayout();
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    mExpandedMarginBottom = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    mExpandedMarginEnd = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    mExpandedMarginStart = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    mExpandedMarginTop = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    mCollapsingTextHelper.setExpandedTextAppearance(paramInt);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    mCollapsingTextHelper.setExpandedTypeface(paramTypeface);
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    if ((ViewCompat.isLaidOut(this)) && (!isInEditMode())) {}
    for (boolean bool = true;; bool = false)
    {
      setScrimsShown(paramBoolean, bool);
      return;
    }
  }
  
  public void setScrimsShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 255;
    if (mScrimsAreShown != paramBoolean1)
    {
      if (!paramBoolean2) {
        break label36;
      }
      if (!paramBoolean1) {
        break label31;
      }
    }
    for (;;)
    {
      animateScrim(i);
      mScrimsAreShown = paramBoolean1;
      return;
      label31:
      i = 0;
    }
    label36:
    if (paramBoolean1) {}
    for (;;)
    {
      setScrimAlpha(i);
      break;
      i = 0;
    }
  }
  
  public void setStatusBarScrim(Drawable paramDrawable)
  {
    Drawable localDrawable = null;
    if (mStatusBarScrim != paramDrawable)
    {
      if (mStatusBarScrim != null) {
        mStatusBarScrim.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable = paramDrawable.mutate();
      }
      mStatusBarScrim = localDrawable;
      if (mStatusBarScrim != null)
      {
        if (mStatusBarScrim.isStateful()) {
          mStatusBarScrim.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(mStatusBarScrim, ViewCompat.getLayoutDirection(this));
        paramDrawable = mStatusBarScrim;
        if (getVisibility() != 0) {
          break label124;
        }
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      mStatusBarScrim.setCallback(this);
      mStatusBarScrim.setAlpha(mScrimAlpha);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mCollapsingTextHelper.setText(paramCharSequence);
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != mCollapsingTitleEnabled)
    {
      mCollapsingTitleEnabled = paramBoolean;
      updateDummyView();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((mStatusBarScrim != null) && (mStatusBarScrim.isVisible() != bool)) {
        mStatusBarScrim.setVisible(bool, false);
      }
      if ((mContentScrim != null) && (mContentScrim.isVisible() != bool)) {
        mContentScrim.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mContentScrim) || (paramDrawable == mStatusBarScrim);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    public static final int COLLAPSE_MODE_OFF = 0;
    public static final int COLLAPSE_MODE_PARALLAX = 2;
    public static final int COLLAPSE_MODE_PIN = 1;
    private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5F;
    int mCollapseMode = 0;
    float mParallaxMult = 0.5F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CollapsingAppBarLayout_LayoutParams);
      mCollapseMode = paramContext.getInt(R.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
      setParallaxMultiplier(paramContext.getFloat(R.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseParallaxMultiplier, 0.5F));
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(FrameLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public int getCollapseMode()
    {
      return mCollapseMode;
    }
    
    public float getParallaxMultiplier()
    {
      return mParallaxMult;
    }
    
    public void setCollapseMode(int paramInt)
    {
      mCollapseMode = paramInt;
    }
    
    public void setParallaxMultiplier(float paramFloat)
    {
      mParallaxMult = paramFloat;
    }
  }
  
  private class OffsetUpdateListener
    implements AppBarLayout.OnOffsetChangedListener
  {
    private OffsetUpdateListener() {}
    
    public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      boolean bool = false;
      CollapsingToolbarLayout.access$302(CollapsingToolbarLayout.this, paramInt);
      int i;
      int k;
      label51:
      Object localObject;
      CollapsingToolbarLayout.LayoutParams localLayoutParams;
      ViewOffsetHelper localViewOffsetHelper;
      if (mLastInsets != null)
      {
        i = mLastInsets.getSystemWindowInsetTop();
        k = paramAppBarLayout.getTotalScrollRange();
        j = 0;
        m = getChildCount();
        if (j >= m) {
          break label177;
        }
        localObject = getChildAt(j);
        localLayoutParams = (CollapsingToolbarLayout.LayoutParams)((View)localObject).getLayoutParams();
        localViewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper((View)localObject);
        switch (mCollapseMode)
        {
        }
      }
      for (;;)
      {
        j += 1;
        break label51;
        i = 0;
        break;
        if (getHeight() - i + paramInt >= ((View)localObject).getHeight())
        {
          localViewOffsetHelper.setTopAndBottomOffset(-paramInt);
          continue;
          localViewOffsetHelper.setTopAndBottomOffset(Math.round(-paramInt * mParallaxMult));
        }
      }
      label177:
      if ((mContentScrim != null) || (mStatusBarScrim != null))
      {
        localObject = CollapsingToolbarLayout.this;
        if (getHeight() + paramInt < getScrimTriggerOffset() + i) {
          bool = true;
        }
        ((CollapsingToolbarLayout)localObject).setScrimsShown(bool);
      }
      if ((mStatusBarScrim != null) && (i > 0)) {
        ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
      }
      int j = getHeight();
      int m = ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this);
      mCollapsingTextHelper.setExpansionFraction(Math.abs(paramInt) / (j - m - i));
      if (Math.abs(paramInt) == k)
      {
        ViewCompat.setElevation(paramAppBarLayout, paramAppBarLayout.getTargetElevation());
        return;
      }
      ViewCompat.setElevation(paramAppBarLayout, 0.0F);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */