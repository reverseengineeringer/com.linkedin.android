package android.support.v7.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

final class SupportMenuInflater$MenuState
{
  int groupCategory;
  int groupCheckable;
  boolean groupEnabled;
  int groupId;
  int groupOrder;
  boolean groupVisible;
  ActionProvider itemActionProvider;
  String itemActionProviderClassName;
  String itemActionViewClassName;
  int itemActionViewLayout;
  boolean itemAdded;
  char itemAlphabeticShortcut;
  int itemCategoryOrder;
  int itemCheckable;
  boolean itemChecked;
  boolean itemEnabled;
  int itemIconResId;
  int itemId;
  String itemListenerMethodName;
  char itemNumericShortcut;
  int itemShowAsAction;
  CharSequence itemTitle;
  CharSequence itemTitleCondensed;
  boolean itemVisible;
  Menu menu;
  
  public SupportMenuInflater$MenuState(SupportMenuInflater paramSupportMenuInflater, Menu paramMenu)
  {
    menu = paramMenu;
    resetGroup();
  }
  
  static char getShortcut(String paramString)
  {
    if (paramString == null) {
      return '\000';
    }
    return paramString.charAt(0);
  }
  
  public final SubMenu addSubMenuItem()
  {
    itemAdded = true;
    SubMenu localSubMenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
    setItem(localSubMenu.getItem());
    return localSubMenu;
  }
  
  final <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = SupportMenuInflater.access$100(this$0).getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, paramArrayOfClass);
    }
    return null;
  }
  
  public final void resetGroup()
  {
    groupId = 0;
    groupCategory = 0;
    groupOrder = 0;
    groupCheckable = 0;
    groupVisible = true;
    groupEnabled = true;
  }
  
  final void setItem(MenuItem paramMenuItem)
  {
    boolean bool = false;
    Object localObject = paramMenuItem.setChecked(itemChecked).setVisible(itemVisible).setEnabled(itemEnabled);
    if (itemCheckable > 0) {
      bool = true;
    }
    ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(itemTitleCondensed).setIcon(itemIconResId).setAlphabeticShortcut(itemAlphabeticShortcut).setNumericShortcut(itemNumericShortcut);
    if (itemShowAsAction >= 0) {
      MenuItemCompat.setShowAsAction(paramMenuItem, itemShowAsAction);
    }
    if (itemListenerMethodName != null)
    {
      if (SupportMenuInflater.access$100(this$0).isRestricted()) {
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.access$400(this$0), itemListenerMethodName));
    }
    if (itemCheckable >= 2)
    {
      if ((paramMenuItem instanceof MenuItemImpl)) {
        ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
      }
    }
    else
    {
      int i = 0;
      if (itemActionViewClassName != null)
      {
        MenuItemCompat.setActionView(paramMenuItem, (View)newInstance(itemActionViewClassName, SupportMenuInflater.access$500(), SupportMenuInflater.access$600(this$0)));
        i = 1;
      }
      if (itemActionViewLayout > 0)
      {
        if (i != 0) {
          break label351;
        }
        MenuItemCompat.setActionView(paramMenuItem, itemActionViewLayout);
      }
    }
    for (;;)
    {
      if (itemActionProvider != null) {
        MenuItemCompat.setActionProvider(paramMenuItem, itemActionProvider);
      }
      return;
      if (!(paramMenuItem instanceof MenuItemWrapperICS)) {
        break;
      }
      localObject = (MenuItemWrapperICS)paramMenuItem;
      try
      {
        if (mSetExclusiveCheckableMethod == null) {
          mSetExclusiveCheckableMethod = ((SupportMenuItem)mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
        }
        mSetExclusiveCheckableMethod.invoke(mWrappedObject, new Object[] { Boolean.valueOf(true) });
      }
      catch (Exception localException)
      {
        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
      }
      break;
      label351:
      Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.SupportMenuInflater.MenuState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */