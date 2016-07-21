package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import java.util.ArrayList;

public final class MenuItemImpl
  implements SupportMenuItem
{
  static String sDeleteShortcutLabel;
  static String sEnterShortcutLabel;
  static String sPrependShortcutLabel;
  static String sSpaceShortcutLabel;
  public android.support.v4.view.ActionProvider mActionProvider;
  private View mActionView;
  private final int mCategoryOrder;
  private MenuItem.OnMenuItemClickListener mClickListener;
  private int mFlags = 16;
  private final int mGroup;
  private Drawable mIconDrawable;
  private int mIconResId = 0;
  private final int mId;
  private Intent mIntent;
  private boolean mIsActionViewExpanded = false;
  private Runnable mItemCallback;
  MenuBuilder mMenu;
  ContextMenu.ContextMenuInfo mMenuInfo;
  private MenuItemCompat.OnActionExpandListener mOnActionExpandListener;
  final int mOrdering;
  private char mShortcutAlphabeticChar;
  private char mShortcutNumericChar;
  int mShowAsAction = 0;
  private SubMenuBuilder mSubMenu;
  private CharSequence mTitle;
  private CharSequence mTitleCondensed;
  
  MenuItemImpl(MenuBuilder paramMenuBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    mMenu = paramMenuBuilder;
    mId = paramInt2;
    mGroup = paramInt1;
    mCategoryOrder = paramInt3;
    mOrdering = paramInt4;
    mTitle = paramCharSequence;
    mShowAsAction = paramInt5;
  }
  
  private SupportMenuItem setActionView(View paramView)
  {
    mActionView = paramView;
    mActionProvider = null;
    if ((paramView != null) && (paramView.getId() == -1) && (mId > 0)) {
      paramView.setId(mId);
    }
    mMenu.onItemActionRequestChanged$4da0fe86();
    return this;
  }
  
  private void setCheckedInt(boolean paramBoolean)
  {
    int j = mFlags;
    int k = mFlags;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      mFlags = (i | k & 0xFFFFFFFD);
      if (j != mFlags) {
        mMenu.onItemsChanged(false);
      }
      return;
    }
  }
  
  public final boolean collapseActionView()
  {
    if ((mShowAsAction & 0x8) == 0) {}
    do
    {
      return false;
      if (mActionView == null) {
        return true;
      }
    } while ((mOnActionExpandListener != null) && (!mOnActionExpandListener.onMenuItemActionCollapse(this)));
    return mMenu.collapseItemActionView(this);
  }
  
  public final boolean expandActionView()
  {
    if (!hasCollapsibleActionView()) {}
    while ((mOnActionExpandListener != null) && (!mOnActionExpandListener.onMenuItemActionExpand(this))) {
      return false;
    }
    return mMenu.expandItemActionView(this);
  }
  
  public final android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (mActionView != null) {
      return mActionView;
    }
    if (mActionProvider != null)
    {
      mActionView = mActionProvider.onCreateActionView(this);
      return mActionView;
    }
    return null;
  }
  
  public final char getAlphabeticShortcut()
  {
    return mShortcutAlphabeticChar;
  }
  
  public final int getGroupId()
  {
    return mGroup;
  }
  
  public final Drawable getIcon()
  {
    if (mIconDrawable != null) {
      return mIconDrawable;
    }
    if (mIconResId != 0)
    {
      Drawable localDrawable = AppCompatDrawableManager.get().getDrawable(mMenu.mContext, mIconResId, false);
      mIconResId = 0;
      mIconDrawable = localDrawable;
      return localDrawable;
    }
    return null;
  }
  
  public final Intent getIntent()
  {
    return mIntent;
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return mMenuInfo;
  }
  
  public final char getNumericShortcut()
  {
    return mShortcutNumericChar;
  }
  
  public final int getOrder()
  {
    return mCategoryOrder;
  }
  
  final char getShortcut()
  {
    if (mMenu.isQwertyMode()) {
      return mShortcutAlphabeticChar;
    }
    return mShortcutNumericChar;
  }
  
  public final SubMenu getSubMenu()
  {
    return mSubMenu;
  }
  
  public final android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    return mActionProvider;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return mTitle;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (mTitleCondensed != null) {}
    for (CharSequence localCharSequence = mTitleCondensed;; localCharSequence = mTitle)
    {
      Object localObject = localCharSequence;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = localCharSequence;
        if (localCharSequence != null)
        {
          localObject = localCharSequence;
          if (!(localCharSequence instanceof String)) {
            localObject = localCharSequence.toString();
          }
        }
      }
      return (CharSequence)localObject;
    }
  }
  
  final CharSequence getTitleForItemView(MenuView.ItemView paramItemView)
  {
    if ((paramItemView != null) && (paramItemView.prefersCondensedTitle())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final boolean hasCollapsibleActionView()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((mShowAsAction & 0x8) != 0)
    {
      if ((mActionView == null) && (mActionProvider != null)) {
        mActionView = mActionProvider.onCreateActionView(this);
      }
      bool1 = bool2;
      if (mActionView != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean hasSubMenu()
  {
    return mSubMenu != null;
  }
  
  public final boolean invoke()
  {
    if ((mClickListener != null) && (mClickListener.onMenuItemClick(this))) {}
    do
    {
      do
      {
        return true;
      } while (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this));
      if (mItemCallback != null)
      {
        mItemCallback.run();
        return true;
      }
      if (mIntent != null) {
        try
        {
          mMenu.mContext.startActivity(mIntent);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
        }
      }
    } while ((mActionProvider != null) && (mActionProvider.onPerformDefaultAction()));
    return false;
  }
  
  public final boolean isActionButton()
  {
    return (mFlags & 0x20) == 32;
  }
  
  public final boolean isActionViewExpanded()
  {
    return mIsActionViewExpanded;
  }
  
  public final boolean isCheckable()
  {
    return (mFlags & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (mFlags & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (mFlags & 0x10) != 0;
  }
  
  public final boolean isExclusiveCheckable()
  {
    return (mFlags & 0x4) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((mActionProvider != null) && (mActionProvider.overridesItemVisibility())) {
      if (((mFlags & 0x8) != 0) || (!mActionProvider.isVisible())) {}
    }
    while ((mFlags & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean requestsActionButton()
  {
    return (mShowAsAction & 0x1) == 1;
  }
  
  public final boolean requiresActionButton()
  {
    return (mShowAsAction & 0x2) == 2;
  }
  
  public final MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final void setActionViewExpanded(boolean paramBoolean)
  {
    mIsActionViewExpanded = paramBoolean;
    mMenu.onItemsChanged(false);
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (mShortcutAlphabeticChar == paramChar) {
      return this;
    }
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar);
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = mFlags;
    int k = mFlags;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      mFlags = (i | k & 0xFFFFFFFE);
      if (j != mFlags) {
        mMenu.onItemsChanged(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((mFlags & 0x4) != 0)
    {
      MenuBuilder localMenuBuilder = mMenu;
      int j = getGroupId();
      int k = mItems.size();
      int i = 0;
      if (i < k)
      {
        MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
        if ((localMenuItemImpl.getGroupId() == j) && (localMenuItemImpl.isExclusiveCheckable()) && (localMenuItemImpl.isCheckable())) {
          if (localMenuItemImpl != this) {
            break label100;
          }
        }
        label100:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localMenuItemImpl.setCheckedInt(paramBoolean);
          i += 1;
          break;
        }
      }
    }
    else
    {
      setCheckedInt(paramBoolean);
    }
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (mFlags |= 0x10;; mFlags &= 0xFFFFFFEF)
    {
      mMenu.onItemsChanged(false);
      return this;
    }
  }
  
  public final void setExclusiveCheckable(boolean paramBoolean)
  {
    int j = mFlags;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      mFlags = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    mIconDrawable = null;
    mIconResId = paramInt;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    mIconResId = 0;
    mIconDrawable = paramDrawable;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    mIntent = paramIntent;
    return this;
  }
  
  public final void setIsActionButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mFlags |= 0x20;
      return;
    }
    mFlags &= 0xFFFFFFDF;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (mShortcutNumericChar == paramChar) {
      return this;
    }
    mShortcutNumericChar = paramChar;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    mClickListener = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    mShortcutNumericChar = paramChar1;
    mShortcutAlphabeticChar = Character.toLowerCase(paramChar2);
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    mShowAsAction = paramInt;
    mMenu.onItemActionRequestChanged$4da0fe86();
  }
  
  public final void setSubMenu(SubMenuBuilder paramSubMenuBuilder)
  {
    mSubMenu = paramSubMenuBuilder;
    paramSubMenuBuilder.setHeaderTitle(getTitle());
  }
  
  public final SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    if (mActionProvider != null)
    {
      android.support.v4.view.ActionProvider localActionProvider = mActionProvider;
      mVisibilityListener = null;
      mSubUiVisibilityListener = null;
    }
    mActionView = null;
    mActionProvider = paramActionProvider;
    mMenu.onItemsChanged(true);
    if (mActionProvider != null) {
      mActionProvider.setVisibilityListener(new ActionProvider.VisibilityListener()
      {
        public final void onActionProviderVisibilityChanged$1385ff()
        {
          mMenu.onItemVisibleChanged$4da0fe86();
        }
      });
    }
    return this;
  }
  
  public final SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    mOnActionExpandListener = paramOnActionExpandListener;
    return this;
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(mMenu.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    mMenu.onItemsChanged(false);
    if (mSubMenu != null) {
      mSubMenu.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    mTitleCondensed = paramCharSequence;
    mMenu.onItemsChanged(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (setVisibleInt(paramBoolean)) {
      mMenu.onItemVisibleChanged$4da0fe86();
    }
    return this;
  }
  
  final boolean setVisibleInt(boolean paramBoolean)
  {
    boolean bool = false;
    int j = mFlags;
    int k = mFlags;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      mFlags = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != mFlags) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  final boolean shouldShowShortcut()
  {
    return (mMenu.isShortcutsVisible()) && (getShortcut() != 0);
  }
  
  public final String toString()
  {
    if (mTitle != null) {
      return mTitle.toString();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuItemImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */