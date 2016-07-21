package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.Spinner;
import android.widget.TextView;

public final class ToolbarWidgetWrapper
  implements DecorToolbar
{
  private ActionMenuPresenter mActionMenuPresenter;
  private View mCustomView;
  private int mDefaultNavigationContentDescription = 0;
  private Drawable mDefaultNavigationIcon;
  private int mDisplayOpts;
  private final AppCompatDrawableManager mDrawableManager;
  private CharSequence mHomeDescription;
  private Drawable mIcon;
  private Drawable mLogo;
  boolean mMenuPrepared;
  private Drawable mNavIcon;
  private int mNavigationMode = 0;
  private Spinner mSpinner;
  private CharSequence mSubtitle;
  private View mTabView;
  CharSequence mTitle;
  private boolean mTitleSet;
  Toolbar mToolbar;
  Window.Callback mWindowCallback;
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
  }
  
  private ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    mToolbar = paramToolbar;
    mTitle = paramToolbar.getTitle();
    mSubtitle = paramToolbar.getSubtitle();
    boolean bool;
    int i;
    if (mTitle != null)
    {
      bool = true;
      mTitleSet = bool;
      mNavIcon = paramToolbar.getNavigationIcon();
      if (!paramBoolean) {
        break label688;
      }
      paramToolbar = TintTypedArray.obtainStyledAttributes$89ace2b(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle);
      Object localObject = paramToolbar.getText(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setTitle((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        mSubtitle = ((CharSequence)localObject);
        if ((mDisplayOpts & 0x8) != 0) {
          mToolbar.setSubtitle((CharSequence)localObject);
        }
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_logo);
      if (localObject != null) {
        setLogo((Drawable)localObject);
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_icon);
      if ((mNavIcon == null) && (localObject != null)) {
        setIcon((Drawable)localObject);
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
      if (localObject != null) {
        setNavigationIcon((Drawable)localObject);
      }
      setDisplayOptions(paramToolbar.getInt(R.styleable.ActionBar_displayOptions, 0));
      i = paramToolbar.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
      if (i != 0)
      {
        localObject = LayoutInflater.from(mToolbar.getContext()).inflate(i, mToolbar, false);
        if ((mCustomView != null) && ((mDisplayOpts & 0x10) != 0)) {
          mToolbar.removeView(mCustomView);
        }
        mCustomView = ((View)localObject);
        if ((localObject != null) && ((mDisplayOpts & 0x10) != 0)) {
          mToolbar.addView(mCustomView);
        }
        setDisplayOptions(mDisplayOpts | 0x10);
      }
      i = paramToolbar.getLayoutDimension(R.styleable.ActionBar_height, 0);
      if (i > 0)
      {
        localObject = mToolbar.getLayoutParams();
        height = i;
        mToolbar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int j = paramToolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
      i = paramToolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((j >= 0) || (i >= 0))
      {
        localObject = mToolbar;
        j = Math.max(j, 0);
        i = Math.max(i, 0);
        mContentInsets.setRelative(j, i);
      }
      i = paramToolbar.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
      Context localContext;
      if (i != 0)
      {
        localObject = mToolbar;
        localContext = mToolbar.getContext();
        mTitleTextAppearance = i;
        if (mTitleTextView != null) {
          mTitleTextView.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (i != 0)
      {
        localObject = mToolbar;
        localContext = mToolbar.getContext();
        mSubtitleTextAppearance = i;
        if (mSubtitleTextView != null) {
          mSubtitleTextView.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.getResourceId(R.styleable.ActionBar_popupTheme, 0);
      if (i != 0) {
        mToolbar.setPopupTheme(i);
      }
      mWrapped.recycle();
    }
    for (;;)
    {
      mDrawableManager = AppCompatDrawableManager.get();
      if (paramInt1 != mDefaultNavigationContentDescription)
      {
        mDefaultNavigationContentDescription = paramInt1;
        if (TextUtils.isEmpty(mToolbar.getNavigationContentDescription())) {
          setNavigationContentDescription(mDefaultNavigationContentDescription);
        }
      }
      mHomeDescription = mToolbar.getNavigationContentDescription();
      paramToolbar = mDrawableManager.getDrawable(mToolbar.getContext(), paramInt2, false);
      if (mDefaultNavigationIcon != paramToolbar)
      {
        mDefaultNavigationIcon = paramToolbar;
        updateNavigationIcon();
      }
      mToolbar.setNavigationOnClickListener(new View.OnClickListener()
      {
        final ActionMenuItem mNavItem = new ActionMenuItem(mToolbar.getContext(), mTitle);
        
        public final void onClick(View paramAnonymousView)
        {
          if ((mWindowCallback != null) && (mMenuPrepared)) {
            mWindowCallback.onMenuItemSelected(0, mNavItem);
          }
        }
      });
      return;
      bool = false;
      break;
      label688:
      i = 11;
      if (mToolbar.getNavigationIcon() != null) {
        i = 15;
      }
      mDisplayOpts = i;
    }
  }
  
  private void setLogo(Drawable paramDrawable)
  {
    mLogo = paramDrawable;
    updateToolbarLogo();
  }
  
  private void setTitleInt(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    if ((mDisplayOpts & 0x8) != 0) {
      mToolbar.setTitle(paramCharSequence);
    }
  }
  
  private void updateHomeAccessibility()
  {
    if ((mDisplayOpts & 0x4) != 0)
    {
      if (TextUtils.isEmpty(mHomeDescription)) {
        mToolbar.setNavigationContentDescription(mDefaultNavigationContentDescription);
      }
    }
    else {
      return;
    }
    mToolbar.setNavigationContentDescription(mHomeDescription);
  }
  
  private void updateNavigationIcon()
  {
    Toolbar localToolbar;
    if ((mDisplayOpts & 0x4) != 0)
    {
      localToolbar = mToolbar;
      if (mNavIcon == null) {
        break label32;
      }
    }
    label32:
    for (Drawable localDrawable = mNavIcon;; localDrawable = mDefaultNavigationIcon)
    {
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
  }
  
  private void updateToolbarLogo()
  {
    Drawable localDrawable = null;
    if ((mDisplayOpts & 0x2) != 0)
    {
      if ((mDisplayOpts & 0x1) == 0) {
        break label49;
      }
      if (mLogo == null) {
        break label41;
      }
      localDrawable = mLogo;
    }
    for (;;)
    {
      mToolbar.setLogo(localDrawable);
      return;
      label41:
      localDrawable = mIcon;
      continue;
      label49:
      localDrawable = mIcon;
    }
  }
  
  public final boolean canShowOverflowMenu()
  {
    Toolbar localToolbar = mToolbar;
    return (localToolbar.getVisibility() == 0) && (mMenuView != null) && (mMenuView.mReserveOverflow);
  }
  
  public final void collapseActionView()
  {
    mToolbar.collapseActionView();
  }
  
  public final void dismissPopupMenus()
  {
    Toolbar localToolbar = mToolbar;
    if (mMenuView != null) {
      mMenuView.dismissPopupMenus();
    }
  }
  
  public final Context getContext()
  {
    return mToolbar.getContext();
  }
  
  public final int getDisplayOptions()
  {
    return mDisplayOpts;
  }
  
  public final int getDropdownSelectedPosition()
  {
    if (mSpinner != null) {
      return mSpinner.getSelectedItemPosition();
    }
    return 0;
  }
  
  public final Menu getMenu()
  {
    return mToolbar.getMenu();
  }
  
  public final int getNavigationMode()
  {
    return mNavigationMode;
  }
  
  public final CharSequence getTitle()
  {
    return mToolbar.getTitle();
  }
  
  public final ViewGroup getViewGroup()
  {
    return mToolbar;
  }
  
  public final int getVisibility()
  {
    return mToolbar.getVisibility();
  }
  
  public final boolean hasExpandedActionView()
  {
    Toolbar localToolbar = mToolbar;
    return (mExpandedMenuPresenter != null) && (mExpandedMenuPresenter.mCurrentExpandedItem != null);
  }
  
  public final boolean hideOverflowMenu()
  {
    return mToolbar.hideOverflowMenu();
  }
  
  public final void initIndeterminateProgress()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public final void initProgress()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public final boolean isOverflowMenuShowPending()
  {
    Object localObject = mToolbar;
    if (mMenuView != null)
    {
      localObject = mMenuView;
      if (mPresenter != null)
      {
        localObject = mPresenter;
        if ((mPostedOpenRunnable != null) || (((ActionMenuPresenter)localObject).isOverflowMenuShowing()))
        {
          i = 1;
          if (i == 0) {
            break label62;
          }
        }
      }
      label62:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label67;
        }
        return true;
        i = 0;
        break;
      }
    }
    label67:
    return false;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return mToolbar.isOverflowMenuShowing();
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    mToolbar.setCollapsible(paramBoolean);
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    int i = mDisplayOpts ^ paramInt;
    mDisplayOpts = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label115;
        }
        updateNavigationIcon();
        updateHomeAccessibility();
      }
      if ((i & 0x3) != 0) {
        updateToolbarLogo();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label126;
        }
        mToolbar.setTitle(mTitle);
        mToolbar.setSubtitle(mSubtitle);
      }
    }
    for (;;)
    {
      if (((i & 0x10) != 0) && (mCustomView != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label145;
        }
        mToolbar.addView(mCustomView);
      }
      return;
      label115:
      mToolbar.setNavigationIcon(null);
      break;
      label126:
      mToolbar.setTitle(null);
      mToolbar.setSubtitle(null);
    }
    label145:
    mToolbar.removeView(mCustomView);
  }
  
  public final void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if ((mTabView != null) && (mTabView.getParent() == mToolbar)) {
      mToolbar.removeView(mTabView);
    }
    mTabView = paramScrollingTabContainerView;
    if ((paramScrollingTabContainerView != null) && (mNavigationMode == 2))
    {
      mToolbar.addView(mTabView, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)mTabView.getLayoutParams();
      width = -2;
      height = -2;
      gravity = 8388691;
      paramScrollingTabContainerView.setAllowCollapse(true);
    }
  }
  
  public final void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = mDrawableManager.getDrawable(mToolbar.getContext(), paramInt, false);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    mIcon = paramDrawable;
    updateToolbarLogo();
  }
  
  public final void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = mDrawableManager.getDrawable(mToolbar.getContext(), paramInt, false);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public final void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    if (mActionMenuPresenter == null)
    {
      mActionMenuPresenter = new ActionMenuPresenter(mToolbar.getContext());
      mActionMenuPresenter.mId = R.id.action_menu_presenter;
    }
    mActionMenuPresenter.mCallback = paramCallback;
    paramCallback = mToolbar;
    paramMenu = (MenuBuilder)paramMenu;
    ActionMenuPresenter localActionMenuPresenter = mActionMenuPresenter;
    if ((paramMenu != null) || (mMenuView != null))
    {
      paramCallback.ensureMenuView();
      MenuBuilder localMenuBuilder = mMenuView.mMenu;
      if (localMenuBuilder != paramMenu)
      {
        if (localMenuBuilder != null)
        {
          localMenuBuilder.removeMenuPresenter(mOuterActionMenuPresenter);
          localMenuBuilder.removeMenuPresenter(mExpandedMenuPresenter);
        }
        if (mExpandedMenuPresenter == null) {
          mExpandedMenuPresenter = new Toolbar.ExpandedActionViewMenuPresenter(paramCallback, (byte)0);
        }
        mExpandedActionViewsExclusive = true;
        if (paramMenu == null) {
          break label186;
        }
        paramMenu.addMenuPresenter(localActionMenuPresenter, mPopupContext);
        paramMenu.addMenuPresenter(mExpandedMenuPresenter, mPopupContext);
      }
    }
    for (;;)
    {
      mMenuView.setPopupTheme(mPopupTheme);
      mMenuView.setPresenter(localActionMenuPresenter);
      mOuterActionMenuPresenter = localActionMenuPresenter;
      return;
      label186:
      localActionMenuPresenter.initForMenu(mPopupContext, null);
      mExpandedMenuPresenter.initForMenu(mPopupContext, null);
      localActionMenuPresenter.updateMenuView(true);
      mExpandedMenuPresenter.updateMenuView(true);
    }
  }
  
  public final void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    Toolbar localToolbar = mToolbar;
    mActionMenuPresenterCallback = paramCallback;
    mMenuBuilderCallback = paramCallback1;
    if (mMenuView != null) {
      mMenuView.setMenuCallbacks(paramCallback, paramCallback1);
    }
  }
  
  public final void setMenuPrepared()
  {
    mMenuPrepared = true;
  }
  
  public final void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = null;; str = mToolbar.getContext().getString(paramInt))
    {
      mHomeDescription = str;
      updateHomeAccessibility();
      return;
    }
  }
  
  public final void setNavigationIcon(Drawable paramDrawable)
  {
    mNavIcon = paramDrawable;
    updateNavigationIcon();
  }
  
  public final void setNavigationMode$13462e()
  {
    int i = mNavigationMode;
    if (i != 0) {
      switch (i)
      {
      }
    }
    for (;;)
    {
      mNavigationMode = 0;
      return;
      if ((mSpinner != null) && (mSpinner.getParent() == mToolbar))
      {
        mToolbar.removeView(mSpinner);
        continue;
        if ((mTabView != null) && (mTabView.getParent() == mToolbar)) {
          mToolbar.removeView(mTabView);
        }
      }
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    mTitleSet = true;
    setTitleInt(paramCharSequence);
  }
  
  public final void setVisibility(int paramInt)
  {
    mToolbar.setVisibility(paramInt);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    mWindowCallback = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!mTitleSet) {
      setTitleInt(paramCharSequence);
    }
  }
  
  public final ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int paramInt, long paramLong)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(mToolbar);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F) {
      localViewPropertyAnimatorCompat.alpha(f).setDuration(paramLong).setListener(new ViewPropertyAnimatorListenerAdapter()
      {
        private boolean mCanceled = false;
        
        public final void onAnimationCancel(View paramAnonymousView)
        {
          mCanceled = true;
        }
        
        public final void onAnimationEnd(View paramAnonymousView)
        {
          if (!mCanceled) {
            mToolbar.setVisibility(paramInt);
          }
        }
        
        public final void onAnimationStart(View paramAnonymousView)
        {
          mToolbar.setVisibility(0);
        }
      });
    }
  }
  
  public final boolean showOverflowMenu()
  {
    return mToolbar.showOverflowMenu();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ToolbarWidgetWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */