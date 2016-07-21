package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WindowDecorActionBar
  extends ActionBar
  implements ActionBarOverlayLayout.ActionBarVisibilityCallback
{
  private static final boolean ALLOW_SHOW_HIDE_ANIMATIONS;
  private static final Interpolator sHideInterpolator;
  private static final Interpolator sShowInterpolator;
  ActionModeImpl mActionMode;
  private Activity mActivity;
  private ActionBarContainer mContainerView;
  private boolean mContentAnimations = true;
  private View mContentView;
  private Context mContext;
  private ActionBarContextView mContextView;
  private int mCurWindowVisibility = 0;
  private ViewPropertyAnimatorCompatSet mCurrentShowAnim;
  private DecorToolbar mDecorToolbar;
  ActionMode mDeferredDestroyActionMode;
  ActionMode.Callback mDeferredModeDestroyCallback;
  private Dialog mDialog;
  private boolean mDisplayHomeAsUpSet;
  private boolean mHasEmbeddedTabs;
  private boolean mHiddenByApp;
  private boolean mHiddenBySystem;
  final ViewPropertyAnimatorListener mHideListener = new ViewPropertyAnimatorListenerAdapter()
  {
    public final void onAnimationEnd(View paramAnonymousView)
    {
      if ((mContentAnimations) && (mContentView != null))
      {
        ViewCompat.setTranslationY(mContentView, 0.0F);
        ViewCompat.setTranslationY(mContainerView, 0.0F);
      }
      mContainerView.setVisibility(8);
      mContainerView.setTransitioning(false);
      WindowDecorActionBar.access$302$78e390dc(WindowDecorActionBar.this);
      paramAnonymousView = WindowDecorActionBar.this;
      if (mDeferredModeDestroyCallback != null)
      {
        mDeferredModeDestroyCallback.onDestroyActionMode(mDeferredDestroyActionMode);
        mDeferredDestroyActionMode = null;
        mDeferredModeDestroyCallback = null;
      }
      if (mOverlayLayout != null) {
        ViewCompat.requestApplyInsets(mOverlayLayout);
      }
    }
  };
  boolean mHideOnContentScroll;
  private boolean mLastMenuVisibility;
  private ArrayList<Object> mMenuVisibilityListeners = new ArrayList();
  private boolean mNowShowing = true;
  private ActionBarOverlayLayout mOverlayLayout;
  private int mSavedTabPosition = -1;
  private TabImpl mSelectedTab;
  private boolean mShowHideAnimationEnabled;
  final ViewPropertyAnimatorListener mShowListener = new ViewPropertyAnimatorListenerAdapter()
  {
    public final void onAnimationEnd(View paramAnonymousView)
    {
      WindowDecorActionBar.access$302$78e390dc(WindowDecorActionBar.this);
      mContainerView.requestLayout();
    }
  };
  private boolean mShowingForMode;
  private ScrollingTabContainerView mTabScrollView;
  private ArrayList<TabImpl> mTabs = new ArrayList();
  private Context mThemedContext;
  final ViewPropertyAnimatorUpdateListener mUpdateListener = new ViewPropertyAnimatorUpdateListener()
  {
    public final void onAnimationUpdate$3c7ec8c3()
    {
      ((View)mContainerView.getParent()).invalidate();
    }
  };
  
  static
  {
    boolean bool2 = true;
    if (!WindowDecorActionBar.class.desiredAssertionStatus())
    {
      bool1 = true;
      $assertionsDisabled = bool1;
      sHideInterpolator = new AccelerateInterpolator();
      sShowInterpolator = new DecelerateInterpolator();
      if (Build.VERSION.SDK_INT < 14) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ALLOW_SHOW_HIDE_ANIMATIONS = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public WindowDecorActionBar(Activity paramActivity, boolean paramBoolean)
  {
    mActivity = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    init(paramActivity);
    if (!paramBoolean) {
      mContentView = paramActivity.findViewById(16908290);
    }
  }
  
  public WindowDecorActionBar(Dialog paramDialog)
  {
    mDialog = paramDialog;
    init(paramDialog.getWindow().getDecorView());
  }
  
  private static boolean checkShowingFlags(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private int getNavigationMode()
  {
    return mDecorToolbar.getNavigationMode();
  }
  
  private void init(View paramView)
  {
    mOverlayLayout = ((ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent));
    if (mOverlayLayout != null) {
      mOverlayLayout.setActionBarVisibilityCallback(this);
    }
    Object localObject = paramView.findViewById(R.id.action_bar);
    if ((localObject instanceof DecorToolbar)) {}
    for (localObject = (DecorToolbar)localObject;; localObject = ((Toolbar)localObject).getWrapper())
    {
      mDecorToolbar = ((DecorToolbar)localObject);
      mContextView = ((ActionBarContextView)paramView.findViewById(R.id.action_context_bar));
      mContainerView = ((ActionBarContainer)paramView.findViewById(R.id.action_bar_container));
      if ((mDecorToolbar != null) && (mContextView != null) && (mContainerView != null)) {
        break label199;
      }
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    if ("Can't make a decor toolbar out of " + localObject != null) {}
    for (paramView = localObject.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
    label199:
    mContext = mDecorToolbar.getContext();
    if ((mDecorToolbar.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        mDisplayHomeAsUpSet = true;
      }
      paramView = ActionBarPolicy.get(mContext);
      i = mContext.getApplicationInfo().targetSdkVersion;
      setHasEmbeddedTabs(paramView.hasEmbeddedTabs());
      paramView = mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (!paramView.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
        break label330;
      }
      if (mOverlayLayout.mOverlayMode) {
        break;
      }
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    mHideOnContentScroll = true;
    mOverlayLayout.setHideOnContentScrollEnabled(true);
    label330:
    i = paramView.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
    if (i != 0) {
      setElevation(i);
    }
    paramView.recycle();
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = mDecorToolbar.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      mDisplayHomeAsUpSet = true;
    }
    mDecorToolbar.setDisplayOptions(paramInt1 & paramInt2 | (paramInt2 ^ 0xFFFFFFFF) & i);
  }
  
  private void setHasEmbeddedTabs(boolean paramBoolean)
  {
    boolean bool = true;
    mHasEmbeddedTabs = paramBoolean;
    int i;
    label45:
    label78:
    Object localObject;
    if (!mHasEmbeddedTabs)
    {
      mDecorToolbar.setEmbeddedTabView(null);
      mContainerView.setTabContainer(mTabScrollView);
      if (getNavigationMode() != 2) {
        break label155;
      }
      i = 1;
      if (mTabScrollView != null)
      {
        if (i == 0) {
          break label160;
        }
        mTabScrollView.setVisibility(0);
        if (mOverlayLayout != null) {
          ViewCompat.requestApplyInsets(mOverlayLayout);
        }
      }
      localObject = mDecorToolbar;
      if ((mHasEmbeddedTabs) || (i == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((DecorToolbar)localObject).setCollapsible(paramBoolean);
      localObject = mOverlayLayout;
      if ((mHasEmbeddedTabs) || (i == 0)) {
        break label177;
      }
    }
    label155:
    label160:
    label172:
    label177:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      return;
      mContainerView.setTabContainer(null);
      mDecorToolbar.setEmbeddedTabView(mTabScrollView);
      break;
      i = 0;
      break label45;
      mTabScrollView.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void updateVisibility(boolean paramBoolean)
  {
    float f2;
    float f1;
    Object localObject1;
    Object localObject2;
    if (checkShowingFlags(mHiddenByApp, mHiddenBySystem, mShowingForMode)) {
      if (!mNowShowing)
      {
        mNowShowing = true;
        if (mCurrentShowAnim != null) {
          mCurrentShowAnim.cancel();
        }
        mContainerView.setVisibility(0);
        if ((mCurWindowVisibility != 0) || (!ALLOW_SHOW_HIDE_ANIMATIONS) || ((!mShowHideAnimationEnabled) && (!paramBoolean))) {
          break label271;
        }
        ViewCompat.setTranslationY(mContainerView, 0.0F);
        f2 = -mContainerView.getHeight();
        f1 = f2;
        if (paramBoolean)
        {
          localObject1 = new int[2];
          Object tmp107_105 = localObject1;
          tmp107_105[0] = 0;
          Object tmp111_107 = tmp107_105;
          tmp111_107[1] = 0;
          tmp111_107;
          mContainerView.getLocationInWindow((int[])localObject1);
          f1 = f2 - localObject1[1];
        }
        ViewCompat.setTranslationY(mContainerView, f1);
        localObject1 = new ViewPropertyAnimatorCompatSet();
        localObject2 = ViewCompat.animate(mContainerView).translationY(0.0F);
        ((ViewPropertyAnimatorCompat)localObject2).setUpdateListener(mUpdateListener);
        ((ViewPropertyAnimatorCompatSet)localObject1).play((ViewPropertyAnimatorCompat)localObject2);
        if ((mContentAnimations) && (mContentView != null))
        {
          ViewCompat.setTranslationY(mContentView, f1);
          ((ViewPropertyAnimatorCompatSet)localObject1).play(ViewCompat.animate(mContentView).translationY(0.0F));
        }
        ((ViewPropertyAnimatorCompatSet)localObject1).setInterpolator(sShowInterpolator);
        ((ViewPropertyAnimatorCompatSet)localObject1).setDuration$20eda383();
        ((ViewPropertyAnimatorCompatSet)localObject1).setListener(mShowListener);
        mCurrentShowAnim = ((ViewPropertyAnimatorCompatSet)localObject1);
        ((ViewPropertyAnimatorCompatSet)localObject1).start();
        if (mOverlayLayout != null) {
          ViewCompat.requestApplyInsets(mOverlayLayout);
        }
      }
    }
    label271:
    while (!mNowShowing) {
      for (;;)
      {
        return;
        ViewCompat.setAlpha(mContainerView, 1.0F);
        ViewCompat.setTranslationY(mContainerView, 0.0F);
        if ((mContentAnimations) && (mContentView != null)) {
          ViewCompat.setTranslationY(mContentView, 0.0F);
        }
        mShowListener.onAnimationEnd(null);
      }
    }
    mNowShowing = false;
    if (mCurrentShowAnim != null) {
      mCurrentShowAnim.cancel();
    }
    if ((mCurWindowVisibility == 0) && (ALLOW_SHOW_HIDE_ANIMATIONS) && ((mShowHideAnimationEnabled) || (paramBoolean)))
    {
      ViewCompat.setAlpha(mContainerView, 1.0F);
      mContainerView.setTransitioning(true);
      localObject1 = new ViewPropertyAnimatorCompatSet();
      f2 = -mContainerView.getHeight();
      f1 = f2;
      if (paramBoolean)
      {
        localObject2 = new int[2];
        Object tmp420_418 = localObject2;
        tmp420_418[0] = 0;
        Object tmp424_420 = tmp420_418;
        tmp424_420[1] = 0;
        tmp424_420;
        mContainerView.getLocationInWindow((int[])localObject2);
        f1 = f2 - localObject2[1];
      }
      localObject2 = ViewCompat.animate(mContainerView).translationY(f1);
      ((ViewPropertyAnimatorCompat)localObject2).setUpdateListener(mUpdateListener);
      ((ViewPropertyAnimatorCompatSet)localObject1).play((ViewPropertyAnimatorCompat)localObject2);
      if ((mContentAnimations) && (mContentView != null)) {
        ((ViewPropertyAnimatorCompatSet)localObject1).play(ViewCompat.animate(mContentView).translationY(f1));
      }
      ((ViewPropertyAnimatorCompatSet)localObject1).setInterpolator(sHideInterpolator);
      ((ViewPropertyAnimatorCompatSet)localObject1).setDuration$20eda383();
      ((ViewPropertyAnimatorCompatSet)localObject1).setListener(mHideListener);
      mCurrentShowAnim = ((ViewPropertyAnimatorCompatSet)localObject1);
      ((ViewPropertyAnimatorCompatSet)localObject1).start();
      return;
    }
    mHideListener.onAnimationEnd(null);
  }
  
  public final void animateToMode(boolean paramBoolean)
  {
    Object localObject;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat;
    label68:
    ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet;
    if (paramBoolean)
    {
      if (!mShowingForMode)
      {
        mShowingForMode = true;
        if (mOverlayLayout != null) {
          mOverlayLayout.setShowingForActionMode(true);
        }
        updateVisibility(false);
      }
      if (!paramBoolean) {
        break label176;
      }
      localObject = mDecorToolbar.setupAnimatorToVisibility(4, 100L);
      localViewPropertyAnimatorCompat = mContextView.setupAnimatorToVisibility(0, 200L);
      localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      mAnimators.add(localObject);
      localObject = (View)mView.get();
      if (localObject == null) {
        break label208;
      }
    }
    label176:
    label208:
    for (long l = ViewPropertyAnimatorCompat.IMPL.getDuration$66604b42((View)localObject);; l = 0L)
    {
      localViewPropertyAnimatorCompat.setStartDelay(l);
      mAnimators.add(localViewPropertyAnimatorCompat);
      localViewPropertyAnimatorCompatSet.start();
      return;
      if (!mShowingForMode) {
        break;
      }
      mShowingForMode = false;
      if (mOverlayLayout != null) {
        mOverlayLayout.setShowingForActionMode(false);
      }
      updateVisibility(false);
      break;
      localViewPropertyAnimatorCompat = mDecorToolbar.setupAnimatorToVisibility(0, 200L);
      localObject = mContextView.setupAnimatorToVisibility(8, 100L);
      break label68;
    }
  }
  
  public final boolean collapseActionView()
  {
    if ((mDecorToolbar != null) && (mDecorToolbar.hasExpandedActionView()))
    {
      mDecorToolbar.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void dispatchMenuVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean == mLastMenuVisibility) {}
    for (;;)
    {
      return;
      mLastMenuVisibility = paramBoolean;
      int j = mMenuVisibilityListeners.size();
      int i = 0;
      while (i < j)
      {
        mMenuVisibilityListeners.get(i);
        i += 1;
      }
    }
  }
  
  public final void enableContentAnimations(boolean paramBoolean)
  {
    mContentAnimations = paramBoolean;
  }
  
  public final int getDisplayOptions()
  {
    return mDecorToolbar.getDisplayOptions();
  }
  
  public final float getElevation()
  {
    return ViewCompat.getElevation(mContainerView);
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (mThemedContext == null)
    {
      TypedValue localTypedValue = new TypedValue();
      mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      i = resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (mThemedContext = new ContextThemeWrapper(mContext, i);; mThemedContext = mContext) {
      return mThemedContext;
    }
  }
  
  public final void hide()
  {
    if (!mHiddenByApp)
    {
      mHiddenByApp = true;
      updateVisibility(false);
    }
  }
  
  public final void hideForSystem()
  {
    if (!mHiddenBySystem)
    {
      mHiddenBySystem = true;
      updateVisibility(true);
    }
  }
  
  public final boolean isShowing()
  {
    int i = mContainerView.getHeight();
    return (mNowShowing) && ((i == 0) || (mOverlayLayout.getActionBarHideOffset() < i));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    setHasEmbeddedTabs(ActionBarPolicy.get(mContext).hasEmbeddedTabs());
  }
  
  public final void onContentScrollStarted()
  {
    if (mCurrentShowAnim != null)
    {
      mCurrentShowAnim.cancel();
      mCurrentShowAnim = null;
    }
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    mCurWindowVisibility = paramInt;
  }
  
  public final boolean requestFocus()
  {
    ViewGroup localViewGroup = mDecorToolbar.getViewGroup();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public final void selectTab(ActionBar.Tab paramTab)
  {
    int i = -1;
    if (getNavigationMode() != 2) {
      if (paramTab != null)
      {
        i = paramTab.getPosition();
        mSavedTabPosition = i;
      }
    }
    label120:
    label150:
    for (;;)
    {
      return;
      i = -1;
      break;
      FragmentTransaction localFragmentTransaction;
      if (((mActivity instanceof FragmentActivity)) && (!mDecorToolbar.getViewGroup().isInEditMode()))
      {
        localFragmentTransaction = ((FragmentActivity)mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        if (mSelectedTab != paramTab) {
          break label120;
        }
        if (mSelectedTab != null) {
          mTabScrollView.animateToTab(paramTab.getPosition());
        }
      }
      for (;;)
      {
        if ((localFragmentTransaction == null) || (localFragmentTransaction.isEmpty())) {
          break label150;
        }
        localFragmentTransaction.commit();
        return;
        localFragmentTransaction = null;
        break;
        ScrollingTabContainerView localScrollingTabContainerView = mTabScrollView;
        if (paramTab != null) {
          i = paramTab.getPosition();
        }
        localScrollingTabContainerView.setTabSelected(i);
        mSelectedTab = ((TabImpl)paramTab);
      }
    }
  }
  
  public final void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (!mDisplayHomeAsUpSet) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  public final void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      setDisplayOptions(i, 8);
      return;
    }
  }
  
  public final void setElevation(float paramFloat)
  {
    ViewCompat.setElevation(mContainerView, paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    mDecorToolbar.setNavigationContentDescription(paramInt);
  }
  
  public final void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    mDecorToolbar.setNavigationIcon(paramDrawable);
  }
  
  public final void setNavigationMode$13462e()
  {
    int i = -1;
    int j = mDecorToolbar.getNavigationMode();
    switch (j)
    {
    default: 
      if ((j != 0) && (!mHasEmbeddedTabs) && (mOverlayLayout != null)) {
        ViewCompat.requestApplyInsets(mOverlayLayout);
      }
      mDecorToolbar.setNavigationMode$13462e();
      mDecorToolbar.setCollapsible(false);
      mOverlayLayout.setHasNonEmbeddedTabs(false);
      return;
    }
    switch (mDecorToolbar.getNavigationMode())
    {
    }
    for (;;)
    {
      mSavedTabPosition = i;
      selectTab(null);
      mTabScrollView.setVisibility(8);
      break;
      if (mSelectedTab != null)
      {
        i = mSelectedTab.mPosition;
        continue;
        i = mDecorToolbar.getDropdownSelectedPosition();
      }
    }
  }
  
  public final void setShowHideAnimationEnabled(boolean paramBoolean)
  {
    mShowHideAnimationEnabled = paramBoolean;
    if ((!paramBoolean) && (mCurrentShowAnim != null)) {
      mCurrentShowAnim.cancel();
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setTitle(paramCharSequence);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    if (mHiddenByApp)
    {
      mHiddenByApp = false;
      updateVisibility(false);
    }
  }
  
  public final void showForSystem()
  {
    if (mHiddenBySystem)
    {
      mHiddenBySystem = false;
      updateVisibility(true);
    }
  }
  
  public final ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    if (mActionMode != null) {
      mActionMode.finish();
    }
    mOverlayLayout.setHideOnContentScrollEnabled(false);
    mContextView.killMode();
    paramCallback = new ActionModeImpl(mContextView.getContext(), paramCallback);
    if (paramCallback.dispatchOnCreate())
    {
      paramCallback.invalidate();
      mContextView.initForMode(paramCallback);
      animateToMode(true);
      mContextView.sendAccessibilityEvent(32);
      mActionMode = paramCallback;
      return paramCallback;
    }
    return null;
  }
  
  public final class ActionModeImpl
    extends ActionMode
    implements MenuBuilder.Callback
  {
    private final Context mActionModeContext;
    private ActionMode.Callback mCallback;
    private WeakReference<View> mCustomView;
    private final MenuBuilder mMenu;
    
    public ActionModeImpl(Context paramContext, ActionMode.Callback paramCallback)
    {
      mActionModeContext = paramContext;
      mCallback = paramCallback;
      this$1 = new MenuBuilder(paramContext);
      mDefaultShowAsAction = 1;
      mMenu = WindowDecorActionBar.this;
      mMenu.setCallback(this);
    }
    
    public final boolean dispatchOnCreate()
    {
      mMenu.stopDispatchingItemsChanged();
      try
      {
        boolean bool = mCallback.onCreateActionMode(this, mMenu);
        return bool;
      }
      finally
      {
        mMenu.startDispatchingItemsChanged();
      }
    }
    
    public final void finish()
    {
      if (mActionMode != this) {
        return;
      }
      if (!WindowDecorActionBar.access$700$49605cc3(mHiddenByApp, mHiddenBySystem))
      {
        mDeferredDestroyActionMode = this;
        mDeferredModeDestroyCallback = mCallback;
      }
      for (;;)
      {
        mCallback = null;
        animateToMode(false);
        ActionBarContextView localActionBarContextView = mContextView;
        if (mClose == null) {
          localActionBarContextView.killMode();
        }
        mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
        mOverlayLayout.setHideOnContentScrollEnabled(mHideOnContentScroll);
        mActionMode = null;
        return;
        mCallback.onDestroyActionMode(this);
      }
    }
    
    public final View getCustomView()
    {
      if (mCustomView != null) {
        return (View)mCustomView.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return mMenu;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new SupportMenuInflater(mActionModeContext);
    }
    
    public final CharSequence getSubtitle()
    {
      return mContextView.getSubtitle();
    }
    
    public final CharSequence getTitle()
    {
      return mContextView.getTitle();
    }
    
    public final void invalidate()
    {
      if (mActionMode != this) {
        return;
      }
      mMenu.stopDispatchingItemsChanged();
      try
      {
        mCallback.onPrepareActionMode(this, mMenu);
        return;
      }
      finally
      {
        mMenu.startDispatchingItemsChanged();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return mContextView.mTitleOptional;
    }
    
    public final boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
    {
      if (mCallback != null) {
        return mCallback.onActionItemClicked(this, paramMenuItem);
      }
      return false;
    }
    
    public final void onMenuModeChange(MenuBuilder paramMenuBuilder)
    {
      if (mCallback == null) {
        return;
      }
      invalidate();
      mContextView.showOverflowMenu();
    }
    
    public final void setCustomView(View paramView)
    {
      mContextView.setCustomView(paramView);
      mCustomView = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(mContext.getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      mContextView.setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(mContext.getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      mContextView.setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      mContextView.setTitleOptional(paramBoolean);
    }
  }
  
  public final class TabImpl
    extends ActionBar.Tab
  {
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    int mPosition;
    private CharSequence mText;
    
    public final CharSequence getContentDescription()
    {
      return mContentDesc;
    }
    
    public final View getCustomView()
    {
      return mCustomView;
    }
    
    public final Drawable getIcon()
    {
      return mIcon;
    }
    
    public final int getPosition()
    {
      return mPosition;
    }
    
    public final CharSequence getText()
    {
      return mText;
    }
    
    public final void select()
    {
      this$0.selectTab(this);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.WindowDecorActionBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */