package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.integer;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.MenuBuilder;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class AbsActionBarView
  extends ViewGroup
{
  protected ActionMenuPresenter mActionMenuPresenter;
  protected int mContentHeight;
  private boolean mEatingHover;
  private boolean mEatingTouch;
  protected ActionMenuView mMenuView;
  protected final Context mPopupContext;
  protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
  protected ViewPropertyAnimatorCompat mVisibilityAnim;
  
  AbsActionBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, paramAttributeSet, true)) && (resourceId != 0))
    {
      mPopupContext = new ContextThemeWrapper(paramContext, resourceId);
      return;
    }
    mPopupContext = paramContext;
  }
  
  protected static int measureChildView$1bb94239(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() + 0);
  }
  
  protected static int next(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  protected static int positionChild(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 += (paramInt3 - j) / 2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramInt2 + j);
    }
    for (;;)
    {
      paramInt1 = i;
      if (paramBoolean) {
        paramInt1 = -i;
      }
      return paramInt1;
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramInt2 + j);
    }
  }
  
  public int getAnimatedVisibility()
  {
    if (mVisibilityAnim != null) {
      return mVisAnimListener.mFinalVisibility;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return mContentHeight;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(R.styleable.ActionBar_height, 0));
    paramConfiguration.recycle();
    if (mActionMenuPresenter != null)
    {
      paramConfiguration = mActionMenuPresenter;
      if (!mMaxItemsSet) {
        mMaxItems = mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
      }
      if (mMenu != null) {
        mMenu.onItemsChanged(true);
      }
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 9) {
      mEatingHover = false;
    }
    if (!mEatingHover)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        mEatingHover = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      mEatingHover = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0) {
      mEatingTouch = false;
    }
    if (!mEatingTouch)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        mEatingTouch = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      mEatingTouch = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (mVisibilityAnim != null) {
        mVisibilityAnim.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int paramInt, long paramLong)
  {
    if (mVisibilityAnim != null) {
      mVisibilityAnim.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        ViewCompat.setAlpha(this, 0.0F);
      }
      localViewPropertyAnimatorCompat = ViewCompat.animate(this).alpha(1.0F);
      localViewPropertyAnimatorCompat.setDuration(paramLong);
      localViewPropertyAnimatorCompat.setListener(mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat, paramInt));
      return localViewPropertyAnimatorCompat;
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this).alpha(0.0F);
    localViewPropertyAnimatorCompat.setDuration(paramLong);
    localViewPropertyAnimatorCompat.setListener(mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat, paramInt));
    return localViewPropertyAnimatorCompat;
  }
  
  public boolean showOverflowMenu()
  {
    if (mActionMenuPresenter != null) {
      return mActionMenuPresenter.showOverflowMenu();
    }
    return false;
  }
  
  protected final class VisibilityAnimListener
    implements ViewPropertyAnimatorListener
  {
    private boolean mCanceled = false;
    int mFinalVisibility;
    
    protected VisibilityAnimListener() {}
    
    public final void onAnimationCancel(View paramView)
    {
      mCanceled = true;
    }
    
    public final void onAnimationEnd(View paramView)
    {
      if (mCanceled) {
        return;
      }
      mVisibilityAnim = null;
      AbsActionBarView.this.setVisibility(mFinalVisibility);
    }
    
    public final void onAnimationStart(View paramView)
    {
      AbsActionBarView.access$001$670ef754(AbsActionBarView.this);
      mCanceled = false;
    }
    
    public final VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, int paramInt)
    {
      mVisibilityAnim = paramViewPropertyAnimatorCompat;
      mFinalVisibility = paramInt;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AbsActionBarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */