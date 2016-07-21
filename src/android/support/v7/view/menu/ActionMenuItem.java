package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class ActionMenuItem
  implements SupportMenuItem
{
  private final int mCategoryOrder;
  private MenuItem.OnMenuItemClickListener mClickListener;
  private Context mContext;
  private int mFlags = 16;
  private final int mGroup;
  private Drawable mIconDrawable;
  private int mIconResId = 0;
  private final int mId;
  private Intent mIntent;
  private final int mOrdering;
  private char mShortcutAlphabeticChar;
  private char mShortcutNumericChar;
  private CharSequence mTitle;
  private CharSequence mTitleCondensed;
  
  public ActionMenuItem(Context paramContext, CharSequence paramCharSequence)
  {
    mContext = paramContext;
    mId = 16908332;
    mGroup = 0;
    mCategoryOrder = 0;
    mOrdering = 0;
    mTitle = paramCharSequence;
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final boolean expandActionView()
  {
    return false;
  }
  
  public final android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public final View getActionView()
  {
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
    return mIconDrawable;
  }
  
  public final Intent getIntent()
  {
    return mIntent;
  }
  
  public final int getItemId()
  {
    return mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public final char getNumericShortcut()
  {
    return mShortcutNumericChar;
  }
  
  public final int getOrder()
  {
    return mOrdering;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return mTitle;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (mTitleCondensed != null) {
      return mTitleCondensed;
    }
    return mTitle;
  }
  
  public final boolean hasSubMenu()
  {
    return false;
  }
  
  public final boolean isActionViewExpanded()
  {
    return false;
  }
  
  public final boolean isCheckable()
  {
    return (mFlags & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (mFlags & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (mFlags & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (mFlags & 0x8) == 0;
  }
  
  public final MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    mShortcutAlphabeticChar = paramChar;
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = mFlags;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      mFlags = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = mFlags;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      mFlags = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = mFlags;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      mFlags = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    mIconResId = paramInt;
    mIconDrawable = ContextCompat.getDrawable(mContext, paramInt);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    mIconDrawable = paramDrawable;
    mIconResId = 0;
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    mShortcutNumericChar = paramChar;
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    mClickListener = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    mShortcutNumericChar = paramChar1;
    mShortcutAlphabeticChar = paramChar2;
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    return this;
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    mTitle = mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    mTitleCondensed = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = mFlags;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      mFlags = (i | j & 0x8);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */