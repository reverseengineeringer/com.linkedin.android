package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.OnAttachListener;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.support.v7.widget.TintContextWrapper;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

class AppCompatDelegateImplV7
  extends AppCompatDelegateImplBase
  implements LayoutInflaterFactory, MenuBuilder.Callback
{
  private ActionMenuPresenterCallback mActionMenuPresenterCallback;
  ActionMode mActionMode;
  PopupWindow mActionModePopup;
  ActionBarContextView mActionModeView;
  private AppCompatViewInflater mAppCompatViewInflater;
  private boolean mClosingActionMenu;
  private DecorContentParent mDecorContentParent;
  private boolean mEnableDefaultActionBarUp;
  ViewPropertyAnimatorCompat mFadeAnim = null;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private int mInvalidatePanelMenuFeatures;
  private boolean mInvalidatePanelMenuPosted;
  private final Runnable mInvalidatePanelMenuRunnable = new Runnable()
  {
    public final void run()
    {
      if ((mInvalidatePanelMenuFeatures & 0x1) != 0) {
        AppCompatDelegateImplV7.access$100(AppCompatDelegateImplV7.this, 0);
      }
      if ((mInvalidatePanelMenuFeatures & 0x1000) != 0) {
        AppCompatDelegateImplV7.access$100(AppCompatDelegateImplV7.this, 108);
      }
      AppCompatDelegateImplV7.access$202$3f79617f(AppCompatDelegateImplV7.this);
      AppCompatDelegateImplV7.access$002$3f79a161(AppCompatDelegateImplV7.this);
    }
  };
  private boolean mLongPressBackDown;
  private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  private PanelFeatureState[] mPanels;
  private PanelFeatureState mPreparedPanel;
  Runnable mShowActionModePopup;
  private View mStatusGuard;
  private ViewGroup mSubDecor;
  private boolean mSubDecorInstalled;
  private Rect mTempRect1;
  private Rect mTempRect2;
  private TextView mTitleView;
  
  AppCompatDelegateImplV7(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private void callOnPanelClosed(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < mPanels.length) {
            localPanelFeatureState = mPanels[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = menu;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!isOpen)) {}
    while (mIsDestroyed) {
      return;
    }
    mOriginalWindowCallback.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  private void checkCloseActionMenu(MenuBuilder paramMenuBuilder)
  {
    if (mClosingActionMenu) {
      return;
    }
    mClosingActionMenu = true;
    mDecorContentParent.dismissPopups();
    Window.Callback localCallback = mWindow.getCallback();
    if ((localCallback != null) && (!mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramMenuBuilder);
    }
    mClosingActionMenu = false;
  }
  
  private void closePanel(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (featureId == 0) && (mDecorContentParent != null) && (mDecorContentParent.isOverflowMenuShowing())) {
      checkCloseActionMenu(menu);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)mContext.getSystemService("window");
      if ((localWindowManager != null) && (isOpen) && (decorView != null))
      {
        localWindowManager.removeView(decorView);
        if (paramBoolean) {
          callOnPanelClosed(featureId, paramPanelFeatureState, null);
        }
      }
      isPrepared = false;
      isHandled = false;
      isOpen = false;
      shownPanelView = null;
      refreshDecorView = true;
    } while (mPreparedPanel != paramPanelFeatureState);
    mPreparedPanel = null;
  }
  
  private void endOnGoingFadeAnimation()
  {
    if (mFadeAnim != null) {
      mFadeAnim.cancel();
    }
  }
  
  private void ensureSubDecor()
  {
    Object localObject1;
    if (!mSubDecorInstalled)
    {
      localObject1 = mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
      if (!((TypedArray)localObject1).hasValue(R.styleable.AppCompatTheme_windowActionBar))
      {
        ((TypedArray)localObject1).recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      }
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false))
      {
        requestWindowFeature(1);
        if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
          requestWindowFeature(109);
        }
        if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
          requestWindowFeature(10);
        }
        mIsFloating = ((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        ((TypedArray)localObject1).recycle();
        mWindow.getDecorView();
        localObject1 = LayoutInflater.from(mContext);
        if (mWindowNoTitle) {
          break label459;
        }
        if (!mIsFloating) {
          break label288;
        }
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_dialog_title_material, null);
        mOverlayActionBar = false;
        mHasActionBar = false;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + mHasActionBar + ", windowActionBarOverlay: " + mOverlayActionBar + ", android:windowIsFloating: " + mIsFloating + ", windowActionModeOverlay: " + mOverlayActionMode + ", windowNoTitle: " + mWindowNoTitle + " }");
        if (!((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label288:
        if (!mHasActionBar) {
          break label1002;
        }
        localObject1 = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject1, true);
        if (resourceId != 0) {}
        for (localObject1 = new ContextThemeWrapper(mContext, resourceId);; localObject1 = mContext)
        {
          localObject1 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(R.layout.abc_screen_toolbar, null);
          mDecorContentParent = ((DecorContentParent)((ViewGroup)localObject1).findViewById(R.id.decor_content_parent));
          mDecorContentParent.setWindowCallback(mWindow.getCallback());
          if (mOverlayActionBar) {
            mDecorContentParent.initFeature(109);
          }
          if (mFeatureProgress) {
            mDecorContentParent.initFeature(2);
          }
          if (mFeatureIndeterminateProgress) {
            mDecorContentParent.initFeature(5);
          }
          break;
        }
        label459:
        if (mOverlayActionMode) {}
        for (localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple_overlay_action_mode, null);; localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label521;
          }
          ViewCompat.setOnApplyWindowInsetsListener((View)localObject1, new OnApplyWindowInsetsListener()
          {
            public final WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
            {
              int i = paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop();
              int j = AppCompatDelegateImplV7.access$300(AppCompatDelegateImplV7.this, i);
              WindowInsetsCompat localWindowInsetsCompat = paramAnonymousWindowInsetsCompat;
              if (i != j) {
                localWindowInsetsCompat = paramAnonymousWindowInsetsCompat.replaceSystemWindowInsets(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), j, paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
              }
              return ViewCompat.onApplyWindowInsets(paramAnonymousView, localWindowInsetsCompat);
            }
          });
          break;
        }
        label521:
        ((FitWindowsViewGroup)localObject1).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener()
        {
          public final void onFitSystemWindows(Rect paramAnonymousRect)
          {
            top = AppCompatDelegateImplV7.access$300(AppCompatDelegateImplV7.this, top);
          }
        });
        continue;
      }
      if (mDecorContentParent == null) {
        mTitleView = ((TextView)((ViewGroup)localObject1).findViewById(R.id.title));
      }
      ViewUtils.makeOptionalFitsSystemWindows((View)localObject1);
      Object localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(R.id.action_bar_activity_content);
      ViewGroup localViewGroup = (ViewGroup)mWindow.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          ((ContentFrameLayout)localObject2).addView(localView);
        }
        localViewGroup.setId(-1);
        ((ContentFrameLayout)localObject2).setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      mWindow.setContentView((View)localObject1);
      ((ContentFrameLayout)localObject2).setAttachListener(new ContentFrameLayout.OnAttachListener()
      {
        public final void onDetachedFromWindow()
        {
          AppCompatDelegateImplV7.access$400(AppCompatDelegateImplV7.this);
        }
      });
      mSubDecor = ((ViewGroup)localObject1);
      if ((mOriginalWindowCallback instanceof Activity)) {}
      for (localObject1 = ((Activity)mOriginalWindowCallback).getTitle();; localObject1 = mTitle)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          onTitleChanged((CharSequence)localObject1);
        }
        localObject1 = (ContentFrameLayout)mSubDecor.findViewById(16908290);
        localObject2 = mWindow.getDecorView();
        int i = ((View)localObject2).getPaddingLeft();
        int j = ((View)localObject2).getPaddingTop();
        int k = ((View)localObject2).getPaddingRight();
        int m = ((View)localObject2).getPaddingBottom();
        mDecorPadding.set(i, j, k, m);
        if (ViewCompat.isLaidOut((View)localObject1)) {
          ((ContentFrameLayout)localObject1).requestLayout();
        }
        localObject2 = mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, ((ContentFrameLayout)localObject1).getMinWidthMajor());
        ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, ((ContentFrameLayout)localObject1).getMinWidthMinor());
        if (((TypedArray)localObject2).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
          ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, ((ContentFrameLayout)localObject1).getFixedWidthMajor());
        }
        if (((TypedArray)localObject2).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
          ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, ((ContentFrameLayout)localObject1).getFixedWidthMinor());
        }
        if (((TypedArray)localObject2).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
          ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, ((ContentFrameLayout)localObject1).getFixedHeightMajor());
        }
        if (((TypedArray)localObject2).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
          ((TypedArray)localObject2).getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, ((ContentFrameLayout)localObject1).getFixedHeightMinor());
        }
        ((TypedArray)localObject2).recycle();
        ((ContentFrameLayout)localObject1).requestLayout();
        mSubDecorInstalled = true;
        localObject1 = getPanelState$5103c037(0);
        if ((!mIsDestroyed) && ((localObject1 == null) || (menu == null))) {
          invalidatePanelMenu(108);
        }
        return;
      }
      label1002:
      localObject1 = null;
    }
  }
  
  private PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = mPanels;
    int i;
    int j;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (menu == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  private PanelFeatureState getPanelState$5103c037(int paramInt)
  {
    Object localObject2 = mPanels;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      arrayOfPanelFeatureState = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, arrayOfPanelFeatureState, 0, localObject2.length);
      }
      localObject1 = arrayOfPanelFeatureState;
      mPanels = arrayOfPanelFeatureState;
    }
    PanelFeatureState[] arrayOfPanelFeatureState = localObject1[paramInt];
    localObject2 = arrayOfPanelFeatureState;
    if (arrayOfPanelFeatureState == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
    }
    return (PanelFeatureState)localObject2;
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    mInvalidatePanelMenuFeatures |= 1 << paramInt;
    if (!mInvalidatePanelMenuPosted)
    {
      ViewCompat.postOnAnimation(mWindow.getDecorView(), mInvalidatePanelMenuRunnable);
      mInvalidatePanelMenuPosted = true;
    }
  }
  
  private void openPanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if ((isOpen) || (mIsDestroyed)) {}
    Object localObject;
    int i;
    int j;
    label112:
    label117:
    label121:
    label123:
    WindowManager localWindowManager;
    label268:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (featureId == 0)
          {
            localObject = mContext;
            if ((getResourcesgetConfigurationscreenLayout & 0xF) != 4) {
              break label112;
            }
            i = 1;
            if (getApplicationInfotargetSdkVersion < 11) {
              break label117;
            }
          }
          for (j = 1;; j = 0)
          {
            if ((i != 0) && (j != 0)) {
              break label121;
            }
            localObject = mWindow.getCallback();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(featureId, menu))) {
              break label123;
            }
            closePanel(paramPanelFeatureState, true);
            return;
            i = 0;
            break;
          }
        }
        localWindowManager = (WindowManager)mContext.getSystemService("window");
      } while ((localWindowManager == null) || (!preparePanel(paramPanelFeatureState, paramKeyEvent)));
      j = -2;
      if ((decorView != null) && (!refreshDecorView)) {
        break label768;
      }
      if (decorView != null) {
        break label591;
      }
      localObject = getActionBarThemedContext();
      TypedValue localTypedValue = new TypedValue();
      paramKeyEvent = ((Context)localObject).getResources().newTheme();
      paramKeyEvent.setTo(((Context)localObject).getTheme());
      paramKeyEvent.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      if (resourceId != 0) {
        paramKeyEvent.applyStyle(resourceId, true);
      }
      paramKeyEvent.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      if (resourceId == 0) {
        break;
      }
      paramKeyEvent.applyStyle(resourceId, true);
      localObject = new ContextThemeWrapper((Context)localObject, 0);
      ((Context)localObject).getTheme().setTo(paramKeyEvent);
      listPresenterContext = ((Context)localObject);
      paramKeyEvent = ((Context)localObject).obtainStyledAttributes(R.styleable.AppCompatTheme);
      background = paramKeyEvent.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
      windowAnimations = paramKeyEvent.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
      paramKeyEvent.recycle();
      decorView = new ListMenuDecorView(listPresenterContext);
      gravity = 81;
    } while (decorView == null);
    label361:
    if (createdPanelView != null)
    {
      shownPanelView = createdPanelView;
      i = 1;
      label378:
      if (i == 0) {
        break label741;
      }
      if (shownPanelView == null) {
        break label763;
      }
      if (createdPanelView == null) {
        break label743;
      }
      i = 1;
      label398:
      if (i == 0) {
        break label766;
      }
      localObject = shownPanelView.getLayoutParams();
      paramKeyEvent = (KeyEvent)localObject;
      if (localObject == null) {
        paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
      }
      i = background;
      decorView.setBackgroundResource(i);
      localObject = shownPanelView.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(shownPanelView);
      }
      decorView.addView(shownPanelView, paramKeyEvent);
      i = j;
      if (!shownPanelView.hasFocus())
      {
        shownPanelView.requestFocus();
        i = j;
      }
    }
    for (;;)
    {
      isHandled = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, x, y, 1002, 8519680, -3);
      gravity = gravity;
      windowAnimations = windowAnimations;
      localWindowManager.addView(decorView, paramKeyEvent);
      isOpen = true;
      return;
      paramKeyEvent.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      break label268;
      label591:
      if ((!refreshDecorView) || (decorView.getChildCount() <= 0)) {
        break label361;
      }
      decorView.removeAllViews();
      break label361;
      if (menu != null)
      {
        if (mPanelMenuPresenterCallback == null) {
          mPanelMenuPresenterCallback = new PanelMenuPresenterCallback((byte)0);
        }
        paramKeyEvent = mPanelMenuPresenterCallback;
        if (menu == null) {}
        for (paramKeyEvent = null;; paramKeyEvent = listMenuPresenter.getMenuView(decorView))
        {
          shownPanelView = ((View)paramKeyEvent);
          if (shownPanelView == null) {
            break label738;
          }
          i = 1;
          break;
          if (listMenuPresenter == null)
          {
            listMenuPresenter = new ListMenuPresenter(listPresenterContext, R.layout.abc_list_menu_item_layout);
            listMenuPresenter.mCallback = paramKeyEvent;
            menu.addMenuPresenter(listMenuPresenter);
          }
        }
      }
      label738:
      i = 0;
      break label378;
      label741:
      break;
      label743:
      if (listMenuPresenter.getAdapter().getCount() > 0)
      {
        i = 1;
        break label398;
      }
      label763:
      i = 0;
      break label398;
      label766:
      break;
      label768:
      i = j;
      if (createdPanelView != null)
      {
        paramKeyEvent = createdPanelView.getLayoutParams();
        i = j;
        if (paramKeyEvent != null)
        {
          i = j;
          if (width == -1) {
            i = -1;
          }
        }
      }
    }
  }
  
  private boolean performPanelShortcut$1f243752(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!isPrepared) && (!preparePanel(paramPanelFeatureState, paramKeyEvent))) || (menu == null)) {
      return false;
    }
    return menu.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private boolean preparePanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (mIsDestroyed) {
      return false;
    }
    if (isPrepared) {
      return true;
    }
    if ((mPreparedPanel != null) && (mPreparedPanel != paramPanelFeatureState)) {
      closePanel(mPreparedPanel, false);
    }
    Window.Callback localCallback = mWindow.getCallback();
    if (localCallback != null) {
      createdPanelView = localCallback.onCreatePanelView(featureId);
    }
    int i;
    label89:
    Context localContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if ((featureId == 0) || (featureId == 108))
    {
      i = 1;
      if ((i != 0) && (mDecorContentParent != null)) {
        mDecorContentParent.setMenuPrepared();
      }
      if ((createdPanelView != null) || ((i != 0) && ((mActionBar instanceof ToolbarActionBar)))) {
        break label625;
      }
      if ((menu != null) && (!refreshMenuContent)) {
        break label495;
      }
      if (menu == null)
      {
        localContext = mContext;
        if (((featureId != 0) && (featureId != 108)) || (mDecorContentParent == null)) {
          break label653;
        }
        localTypedValue = new TypedValue();
        localTheme = localContext.getTheme();
        localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
        if (resourceId == 0) {
          break label472;
        }
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        label256:
        Object localObject2 = localObject1;
        if (resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(resourceId, true);
        }
        if (localObject2 == null) {
          break label653;
        }
        localObject1 = new ContextThemeWrapper(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new MenuBuilder((Context)localObject1);
      ((MenuBuilder)localObject1).setCallback(this);
      paramPanelFeatureState.setMenu((MenuBuilder)localObject1);
      if (menu == null) {
        break;
      }
      if ((i != 0) && (mDecorContentParent != null))
      {
        if (mActionMenuPresenterCallback == null) {
          mActionMenuPresenterCallback = new ActionMenuPresenterCallback((byte)0);
        }
        mDecorContentParent.setMenu(menu, mActionMenuPresenterCallback);
      }
      menu.stopDispatchingItemsChanged();
      if (!localCallback.onCreatePanelMenu(featureId, menu))
      {
        paramPanelFeatureState.setMenu(null);
        if ((i == 0) || (mDecorContentParent == null)) {
          break;
        }
        mDecorContentParent.setMenu(null, mActionMenuPresenterCallback);
        return false;
        i = 0;
        break label89;
        label472:
        localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        localObject1 = null;
        break label256;
      }
      refreshMenuContent = false;
      label495:
      menu.stopDispatchingItemsChanged();
      if (frozenActionViewState != null)
      {
        menu.restoreActionViewStates(frozenActionViewState);
        frozenActionViewState = null;
      }
      if (!localCallback.onPreparePanel(0, createdPanelView, menu))
      {
        if ((i != 0) && (mDecorContentParent != null)) {
          mDecorContentParent.setMenu(null, mActionMenuPresenterCallback);
        }
        menu.startDispatchingItemsChanged();
        return false;
      }
      if (paramKeyEvent != null)
      {
        i = paramKeyEvent.getDeviceId();
        if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
          break label647;
        }
      }
      label625:
      label647:
      for (boolean bool = true;; bool = false)
      {
        qwertyMode = bool;
        menu.setQwertyMode(qwertyMode);
        menu.startDispatchingItemsChanged();
        isPrepared = true;
        isHandled = false;
        mPreparedPanel = paramPanelFeatureState;
        return true;
        i = -1;
        break;
      }
      label653:
      localObject1 = localContext;
    }
  }
  
  private void throwFeatureRequestIfSubDecorInstalled()
  {
    if (mSubDecorInstalled) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)mSubDecor.findViewById(16908290)).addView(paramView, paramLayoutParams);
    mOriginalWindowCallback.onContentChanged();
  }
  
  View callActivityOnCreateView$1fef4371(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((mOriginalWindowCallback instanceof LayoutInflater.Factory))
    {
      paramString = ((LayoutInflater.Factory)mOriginalWindowCallback).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (mOriginalWindowCallback.dispatchKeyEvent(paramKeyEvent))) {}
    int i;
    label180:
    do
    {
      int j;
      do
      {
        do
        {
          return true;
          j = paramKeyEvent.getKeyCode();
          if (paramKeyEvent.getAction() == 0) {}
          for (i = 1; i != 0; i = 0) {
            switch (j)
            {
            default: 
              if (Build.VERSION.SDK_INT < 11) {
                onKeyShortcut(j, paramKeyEvent);
              }
              return false;
            }
          }
        } while (paramKeyEvent.getRepeatCount() != 0);
        localPanelFeatureState = getPanelState$5103c037(0);
      } while (isOpen);
      preparePanel(localPanelFeatureState, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        mLongPressBackDown = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (mActionMode != null);
    PanelFeatureState localPanelFeatureState = getPanelState$5103c037(0);
    if ((mDecorContentParent != null) && (mDecorContentParent.canShowOverflowMenu()) && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(mContext)))) {
      if (!mDecorContentParent.isOverflowMenuShowing())
      {
        if ((mIsDestroyed) || (!preparePanel(localPanelFeatureState, paramKeyEvent))) {
          break label495;
        }
        bool = mDecorContentParent.showOverflowMenu();
      }
    }
    label268:
    while (bool)
    {
      paramKeyEvent = (AudioManager)mContext.getSystemService("audio");
      if (paramKeyEvent == null) {
        break label394;
      }
      paramKeyEvent.playSoundEffect(0);
      return true;
      bool = mDecorContentParent.hideOverflowMenu();
      continue;
      if ((!isOpen) && (!isHandled)) {
        break label345;
      }
      bool = isOpen;
      closePanel(localPanelFeatureState, true);
    }
    label345:
    if (isPrepared)
    {
      if (!refreshMenuContent) {
        break label501;
      }
      isPrepared = false;
    }
    label394:
    label495:
    label501:
    for (boolean bool = preparePanel(localPanelFeatureState, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        openPanel(localPanelFeatureState, paramKeyEvent);
        bool = true;
        break label268;
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
        return true;
        bool = mLongPressBackDown;
        mLongPressBackDown = false;
        paramKeyEvent = getPanelState$5103c037(0);
        if ((paramKeyEvent != null) && (isOpen))
        {
          if (bool) {
            break;
          }
          closePanel(paramKeyEvent, true);
          return true;
        }
        if (mActionMode != null)
        {
          mActionMode.finish();
          i = 1;
        }
        while (i != 0)
        {
          return true;
          paramKeyEvent = getSupportActionBar();
          if ((paramKeyEvent != null) && (paramKeyEvent.collapseActionView())) {
            i = 1;
          } else {
            i = 0;
          }
        }
        break label180;
      }
      bool = false;
      break label268;
    }
  }
  
  public final View findViewById(int paramInt)
  {
    ensureSubDecor();
    return mWindow.findViewById(paramInt);
  }
  
  public final void initWindowDecorActionBar()
  {
    ensureSubDecor();
    if ((!mHasActionBar) || (mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((mOriginalWindowCallback instanceof Activity)) {
        mActionBar = new WindowDecorActionBar((Activity)mOriginalWindowCallback, mOverlayActionBar);
      }
      while (mActionBar != null)
      {
        mActionBar.setDefaultDisplayHomeAsUpEnabled(mEnableDefaultActionBarUp);
        return;
        if ((mOriginalWindowCallback instanceof Dialog)) {
          mActionBar = new WindowDecorActionBar((Dialog)mOriginalWindowCallback);
        }
      }
    }
  }
  
  public final void installViewFactory()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(mContext);
    if (localLayoutInflater.getFactory() == null) {
      LayoutInflaterCompat.setFactory(localLayoutInflater, this);
    }
    while ((LayoutInflaterCompat.getFactory(localLayoutInflater) instanceof AppCompatDelegateImplV7)) {
      return;
    }
    Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
  }
  
  public final void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.invalidateOptionsMenu())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((mHasActionBar) && (mSubDecorInstalled))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    applyDayNight();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (((mOriginalWindowCallback instanceof Activity)) && (NavUtils.getParentActivityName((Activity)mOriginalWindowCallback) != null))
    {
      paramBundle = mActionBar;
      if (paramBundle == null) {
        mEnableDefaultActionBarUp = true;
      }
    }
    else
    {
      return;
    }
    paramBundle.setDefaultDisplayHomeAsUpEnabled(true);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int j = 0;
    Object localObject1 = callActivityOnCreateView$1fef4371(paramString, paramContext, paramAttributeSet);
    if (localObject1 != null)
    {
      paramView = (View)localObject1;
      return paramView;
    }
    boolean bool1;
    label34:
    int i;
    label79:
    AppCompatViewInflater localAppCompatViewInflater;
    boolean bool2;
    if (Build.VERSION.SDK_INT < 21)
    {
      bool1 = true;
      if (mAppCompatViewInflater == null) {
        mAppCompatViewInflater = new AppCompatViewInflater();
      }
      if (!bool1) {
        break label436;
      }
      localObject1 = (ViewParent)paramView;
      if (localObject1 != null) {
        break label372;
      }
      i = 0;
      if (i == 0) {
        break label436;
      }
      i = 1;
      localAppCompatViewInflater = mAppCompatViewInflater;
      bool2 = VectorEnabledTintResources.shouldBeUsed();
      if ((i == 0) || (paramView == null)) {
        break label853;
      }
    }
    label248:
    label251:
    label372:
    label436:
    label853:
    for (paramView = paramView.getContext();; paramView = paramContext)
    {
      paramView = AppCompatViewInflater.themifyContext$52f2f7f3(paramView, paramAttributeSet, bool1);
      Object localObject2 = paramView;
      if (bool2) {
        localObject2 = TintContextWrapper.wrap(paramView);
      }
      paramView = null;
      switch (paramString.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = paramView;
          if (paramContext != localObject2) {
            localObject1 = localAppCompatViewInflater.createViewFromTag((Context)localObject2, paramString, paramAttributeSet);
          }
        }
        paramView = (View)localObject1;
        if (localObject1 == null) {
          break;
        }
        AppCompatViewInflater.checkOnClickListener((View)localObject1, paramAttributeSet);
        return (View)localObject1;
        bool1 = false;
        break label34;
        localObject2 = mWindow.getDecorView();
        for (;;)
        {
          if (localObject1 == null)
          {
            i = 1;
            break;
          }
          if ((localObject1 == localObject2) || (!(localObject1 instanceof View)) || (ViewCompat.isAttachedToWindow((View)localObject1)))
          {
            i = 0;
            break;
          }
          localObject1 = ((ViewParent)localObject1).getParent();
        }
        i = 0;
        break label79;
        if (!paramString.equals("TextView")) {
          break label248;
        }
        i = j;
        break label251;
        if (!paramString.equals("ImageView")) {
          break label248;
        }
        i = 1;
        break label251;
        if (!paramString.equals("Button")) {
          break label248;
        }
        i = 2;
        break label251;
        if (!paramString.equals("EditText")) {
          break label248;
        }
        i = 3;
        break label251;
        if (!paramString.equals("Spinner")) {
          break label248;
        }
        i = 4;
        break label251;
        if (!paramString.equals("ImageButton")) {
          break label248;
        }
        i = 5;
        break label251;
        if (!paramString.equals("CheckBox")) {
          break label248;
        }
        i = 6;
        break label251;
        if (!paramString.equals("RadioButton")) {
          break label248;
        }
        i = 7;
        break label251;
        if (!paramString.equals("CheckedTextView")) {
          break label248;
        }
        i = 8;
        break label251;
        if (!paramString.equals("AutoCompleteTextView")) {
          break label248;
        }
        i = 9;
        break label251;
        if (!paramString.equals("MultiAutoCompleteTextView")) {
          break label248;
        }
        i = 10;
        break label251;
        if (!paramString.equals("RatingBar")) {
          break label248;
        }
        i = 11;
        break label251;
        if (!paramString.equals("SeekBar")) {
          break label248;
        }
        i = 12;
        break label251;
        paramView = new AppCompatTextView((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatImageView((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatButton((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatEditText((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatSpinner((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatImageButton((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatCheckBox((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatRadioButton((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatCheckedTextView((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatAutoCompleteTextView((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatMultiAutoCompleteTextView((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatRatingBar((Context)localObject2, paramAttributeSet);
        continue;
        paramView = new AppCompatSeekBar((Context)localObject2, paramAttributeSet);
      }
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (mActionBar != null) {
      mActionBar.onDestroy();
    }
  }
  
  final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((mPreparedPanel == null) || (!performPanelShortcut$1f243752(mPreparedPanel, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (mPreparedPanel == null);
      mPreparedPanel.isHandled = true;
      return true;
      if (mPreparedPanel != null) {
        break;
      }
      localObject = getPanelState$5103c037(0);
      preparePanel((PanelFeatureState)localObject, paramKeyEvent);
      bool = performPanelShortcut$1f243752((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      isPrepared = false;
    } while (bool);
    return false;
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = mWindow.getCallback();
    if ((localCallback != null) && (!mIsDestroyed))
    {
      paramMenuBuilder = findMenuPanel(paramMenuBuilder.getRootMenu());
      if (paramMenuBuilder != null) {
        return localCallback.onMenuItemSelected(featureId, paramMenuItem);
      }
    }
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if ((mDecorContentParent != null) && (mDecorContentParent.canShowOverflowMenu()) && ((!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(mContext))) || (mDecorContentParent.isOverflowMenuShowPending())))
    {
      paramMenuBuilder = mWindow.getCallback();
      if (!mDecorContentParent.isOverflowMenuShowing()) {
        if ((paramMenuBuilder != null) && (!mIsDestroyed))
        {
          if ((mInvalidatePanelMenuPosted) && ((mInvalidatePanelMenuFeatures & 0x1) != 0))
          {
            mWindow.getDecorView().removeCallbacks(mInvalidatePanelMenuRunnable);
            mInvalidatePanelMenuRunnable.run();
          }
          PanelFeatureState localPanelFeatureState = getPanelState$5103c037(0);
          if ((menu != null) && (!refreshMenuContent) && (paramMenuBuilder.onPreparePanel(0, createdPanelView, menu)))
          {
            paramMenuBuilder.onMenuOpened(108, menu);
            mDecorContentParent.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        mDecorContentParent.hideOverflowMenu();
      } while (mIsDestroyed);
      paramMenuBuilder.onPanelClosed(108, getPanelState$5103c0370menu);
      return;
    }
    paramMenuBuilder = getPanelState$5103c037(0);
    refreshDecorView = true;
    closePanel(paramMenuBuilder, false);
    openPanel(paramMenuBuilder, null);
  }
  
  final boolean onMenuOpened$2fef5512(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.dispatchMenuVisibilityChanged(true);
      }
      return true;
    }
    return false;
  }
  
  final void onPanelClosed$2fef5516(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).dispatchMenuVisibilityChanged(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = getPanelState$5103c037(paramInt);
    } while (!isOpen);
    closePanel((PanelFeatureState)localObject, false);
  }
  
  public final void onPostCreate$79e5e33f()
  {
    ensureSubDecor();
  }
  
  public final void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public final void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  final void onTitleChanged(CharSequence paramCharSequence)
  {
    if (mDecorContentParent != null) {
      mDecorContentParent.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (mActionBar != null)
      {
        mActionBar.setWindowTitle(paramCharSequence);
        return;
      }
    } while (mTitleView == null);
    mTitleView.setText(paramCharSequence);
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    int i;
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      i = 108;
    }
    while ((mWindowNoTitle) && (i == 108))
    {
      return false;
      i = paramInt;
      if (paramInt == 9)
      {
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        i = 109;
      }
    }
    if ((mHasActionBar) && (i == 1)) {
      mHasActionBar = false;
    }
    switch (i)
    {
    default: 
      return mWindow.requestFeature(i);
    case 108: 
      throwFeatureRequestIfSubDecorInstalled();
      mHasActionBar = true;
      return true;
    case 109: 
      throwFeatureRequestIfSubDecorInstalled();
      mOverlayActionBar = true;
      return true;
    case 10: 
      throwFeatureRequestIfSubDecorInstalled();
      mOverlayActionMode = true;
      return true;
    case 2: 
      throwFeatureRequestIfSubDecorInstalled();
      mFeatureProgress = true;
      return true;
    case 5: 
      throwFeatureRequestIfSubDecorInstalled();
      mFeatureIndeterminateProgress = true;
      return true;
    }
    throwFeatureRequestIfSubDecorInstalled();
    mWindowNoTitle = true;
    return true;
  }
  
  public final void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(mContext).inflate(paramInt, localViewGroup);
    mOriginalWindowCallback.onContentChanged();
  }
  
  public final void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    mOriginalWindowCallback.onContentChanged();
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    mOriginalWindowCallback.onContentChanged();
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(mOriginalWindowCallback instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof WindowDecorActionBar)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    mMenuInflater = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new ToolbarActionBar(paramToolbar, ((Activity)mContext).getTitle(), mAppCompatWindowCallback);
      mActionBar = paramToolbar;
      mWindow.setCallback(mWindowCallback);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      mActionBar = null;
      mWindow.setCallback(mAppCompatWindowCallback);
    }
  }
  
  public final ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (mActionMode != null) {
      mActionMode.finish();
    }
    paramCallback = new ActionModeCallbackWrapperV7(paramCallback);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      mActionMode = localActionBar.startActionMode(paramCallback);
      if ((mActionMode != null) && (mAppCompatCallback != null)) {
        mAppCompatCallback.onSupportActionModeStarted(mActionMode);
      }
    }
    if (mActionMode == null) {
      mActionMode = startSupportActionModeFromWindow(paramCallback);
    }
    return mActionMode;
  }
  
  final ActionMode startSupportActionModeFromWindow(ActionMode.Callback paramCallback)
  {
    endOnGoingFadeAnimation();
    if (mActionMode != null) {
      mActionMode.finish();
    }
    ActionModeCallbackWrapperV7 localActionModeCallbackWrapperV7 = new ActionModeCallbackWrapperV7(paramCallback);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (mAppCompatCallback != null)
    {
      localObject1 = localObject3;
      if (mIsDestroyed) {}
    }
    try
    {
      localObject1 = mAppCompatCallback.onWindowStartingSupportActionMode(localActionModeCallbackWrapperV7);
      if (localObject1 != null) {
        mActionMode = ((ActionMode)localObject1);
      }
      for (;;)
      {
        if ((mActionMode != null) && (mAppCompatCallback != null)) {
          mAppCompatCallback.onSupportActionModeStarted(mActionMode);
        }
        return mActionMode;
        if (mActionModeView == null)
        {
          if (!mIsFloating) {
            break label501;
          }
          localObject3 = new TypedValue();
          localObject1 = mContext.getTheme();
          ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject3, true);
          if (resourceId != 0)
          {
            Resources.Theme localTheme = mContext.getResources().newTheme();
            localTheme.setTo((Resources.Theme)localObject1);
            localTheme.applyStyle(resourceId, true);
            localObject1 = new ContextThemeWrapper(mContext, 0);
            ((Context)localObject1).getTheme().setTo(localTheme);
            label216:
            mActionModeView = new ActionBarContextView((Context)localObject1);
            mActionModePopup = new PopupWindow((Context)localObject1, null, R.attr.actionModePopupWindowStyle);
            PopupWindowCompat.setWindowLayoutType(mActionModePopup, 2);
            mActionModePopup.setContentView(mActionModeView);
            mActionModePopup.setWidth(-1);
            ((Context)localObject1).getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject3, true);
            int i = TypedValue.complexToDimensionPixelSize(data, ((Context)localObject1).getResources().getDisplayMetrics());
            mActionModeView.setContentHeight(i);
            mActionModePopup.setHeight(-2);
            mShowActionModePopup = new Runnable()
            {
              public final void run()
              {
                mActionModePopup.showAtLocation(mActionModeView, 55, 0, 0);
                AppCompatDelegateImplV7.this.endOnGoingFadeAnimation();
                ViewCompat.setAlpha(mActionModeView, 0.0F);
                mFadeAnim = ViewCompat.animate(mActionModeView).alpha(1.0F);
                mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter()
                {
                  public final void onAnimationEnd(View paramAnonymous2View)
                  {
                    ViewCompat.setAlpha(mActionModeView, 1.0F);
                    mFadeAnim.setListener(null);
                    mFadeAnim = null;
                  }
                  
                  public final void onAnimationStart(View paramAnonymous2View)
                  {
                    mActionModeView.setVisibility(0);
                  }
                });
              }
            };
          }
        }
        else
        {
          label334:
          if (mActionModeView == null) {
            break label546;
          }
          endOnGoingFadeAnimation();
          mActionModeView.killMode();
          localObject1 = mActionModeView.getContext();
          localObject3 = mActionModeView;
          if (mActionModePopup != null) {
            break label548;
          }
        }
        label501:
        label546:
        label548:
        for (boolean bool = true;; bool = false)
        {
          localObject1 = new StandaloneActionMode((Context)localObject1, (ActionBarContextView)localObject3, localActionModeCallbackWrapperV7, bool);
          if (!paramCallback.onCreateActionMode((ActionMode)localObject1, ((ActionMode)localObject1).getMenu())) {
            break label553;
          }
          ((ActionMode)localObject1).invalidate();
          mActionModeView.initForMode((ActionMode)localObject1);
          mActionMode = ((ActionMode)localObject1);
          ViewCompat.setAlpha(mActionModeView, 0.0F);
          mFadeAnim = ViewCompat.animate(mActionModeView).alpha(1.0F);
          mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter()
          {
            public final void onAnimationEnd(View paramAnonymousView)
            {
              ViewCompat.setAlpha(mActionModeView, 1.0F);
              mFadeAnim.setListener(null);
              mFadeAnim = null;
            }
            
            public final void onAnimationStart(View paramAnonymousView)
            {
              mActionModeView.setVisibility(0);
              mActionModeView.sendAccessibilityEvent(32);
              if (mActionModeView.getParent() != null) {
                ViewCompat.requestApplyInsets((View)mActionModeView.getParent());
              }
            }
          });
          if (mActionModePopup == null) {
            break;
          }
          mWindow.getDecorView().post(mShowActionModePopup);
          break;
          localObject1 = mContext;
          break label216;
          localObject1 = (ViewStubCompat)mSubDecor.findViewById(R.id.action_mode_bar_stub);
          if (localObject1 == null) {
            break label334;
          }
          ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
          mActionModeView = ((ActionBarContextView)((ViewStubCompat)localObject1).inflate());
          break label334;
          break;
        }
        label553:
        mActionMode = null;
      }
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private ActionMenuPresenterCallback() {}
    
    public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      AppCompatDelegateImplV7.this.checkCloseActionMenu(paramMenuBuilder);
    }
    
    public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      Window.Callback localCallback = mWindow.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramMenuBuilder);
      }
      return true;
    }
  }
  
  final class ActionModeCallbackWrapperV7
    implements ActionMode.Callback
  {
    private ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapperV7(ActionMode.Callback paramCallback)
    {
      mWrapped = paramCallback;
    }
    
    public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public final void onDestroyActionMode(ActionMode paramActionMode)
    {
      mWrapped.onDestroyActionMode(paramActionMode);
      if (mActionModePopup != null) {
        mWindow.getDecorView().removeCallbacks(mShowActionModePopup);
      }
      if (mActionModeView != null)
      {
        AppCompatDelegateImplV7.this.endOnGoingFadeAnimation();
        mFadeAnim = ViewCompat.animate(mActionModeView).alpha(0.0F);
        mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter()
        {
          public final void onAnimationEnd(View paramAnonymousView)
          {
            mActionModeView.setVisibility(8);
            if (mActionModePopup != null) {
              mActionModePopup.dismiss();
            }
            for (;;)
            {
              mActionModeView.removeAllViews();
              mFadeAnim.setListener(null);
              mFadeAnim = null;
              return;
              if ((mActionModeView.getParent() instanceof View)) {
                ViewCompat.requestApplyInsets((View)mActionModeView.getParent());
              }
            }
          }
        });
      }
      if (mAppCompatCallback != null) {
        mAppCompatCallback.onSupportActionModeFinished(mActionMode);
      }
      mActionMode = null;
    }
    
    public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
  
  private final class ListMenuDecorView
    extends ContentFrameLayout
  {
    public ListMenuDecorView(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImplV7.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((i < -5) || (j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppCompatDelegateImplV7.access$1400$3f79a154(AppCompatDelegateImplV7.this);
          return true;
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(getContext(), paramInt, false));
    }
  }
  
  private static final class PanelFeatureState
  {
    int background;
    View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      featureId = paramInt;
      refreshDecorView = false;
    }
    
    final void setMenu(MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder == menu) {}
      do
      {
        return;
        if (menu != null) {
          menu.removeMenuPresenter(listMenuPresenter);
        }
        menu = paramMenuBuilder;
      } while ((paramMenuBuilder == null) || (listMenuPresenter == null));
      paramMenuBuilder.addMenuPresenter(listMenuPresenter);
    }
  }
  
  private final class PanelMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private PanelMenuPresenterCallback() {}
    
    public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
      if (localMenuBuilder != paramMenuBuilder) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImplV7 localAppCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
        if (i != 0) {
          paramMenuBuilder = localMenuBuilder;
        }
        paramMenuBuilder = localAppCompatDelegateImplV7.findMenuPanel(paramMenuBuilder);
        if (paramMenuBuilder != null)
        {
          if (i == 0) {
            break;
          }
          AppCompatDelegateImplV7.this.callOnPanelClosed(featureId, paramMenuBuilder, localMenuBuilder);
          AppCompatDelegateImplV7.this.closePanel(paramMenuBuilder, true);
        }
        return;
      }
      AppCompatDelegateImplV7.this.closePanel(paramMenuBuilder, paramBoolean);
    }
    
    public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if ((paramMenuBuilder == null) && (mHasActionBar))
      {
        Window.Callback localCallback = mWindow.getCallback();
        if ((localCallback != null) && (!mIsDestroyed)) {
          localCallback.onMenuOpened(108, paramMenuBuilder);
        }
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */