package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.bool;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder
  implements SupportMenu
{
  private static final int[] sCategoryToOrder = { 1, 4, 5, 3, 2, 0 };
  public ArrayList<MenuItemImpl> mActionItems;
  public Callback mCallback;
  public final Context mContext;
  private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
  public int mDefaultShowAsAction = 0;
  MenuItemImpl mExpandedItem;
  Drawable mHeaderIcon;
  CharSequence mHeaderTitle;
  View mHeaderView;
  private boolean mIsActionItemsStale;
  private boolean mIsClosing = false;
  private boolean mIsVisibleItemsStale;
  ArrayList<MenuItemImpl> mItems;
  private boolean mItemsChangedWhileDispatchPrevented = false;
  private ArrayList<MenuItemImpl> mNonActionItems;
  boolean mOptionalIconsVisible = false;
  public boolean mOverrideVisibleItems;
  public CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList();
  private boolean mPreventDispatchingItemsChanged = false;
  private boolean mQwertyMode;
  private final Resources mResources;
  private boolean mShortcutsVisible;
  private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList();
  private ArrayList<MenuItemImpl> mVisibleItems;
  
  public MenuBuilder(Context paramContext)
  {
    mContext = paramContext;
    mResources = paramContext.getResources();
    mItems = new ArrayList();
    mVisibleItems = new ArrayList();
    mIsVisibleItemsStale = true;
    mActionItems = new ArrayList();
    mNonActionItems = new ArrayList();
    mIsActionItemsStale = true;
    if ((mResources.getConfiguration().keyboard != 1) && (mResources.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent))) {}
    for (;;)
    {
      mShortcutsVisible = bool;
      return;
      bool = false;
    }
  }
  
  private static int findInsertIndex(ArrayList<MenuItemImpl> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (getmOrdering <= paramInt) {
        return i + 1;
      }
      i -= 1;
    }
    return 0;
  }
  
  private MenuItemImpl findItemWithShortcutForKey(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = mTempShortcutItemList;
    localArrayList.clear();
    findItemsWithShortcutForKey(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty()) {}
    for (;;)
    {
      return null;
      int k = paramKeyEvent.getMetaState();
      KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
      paramKeyEvent.getKeyData(localKeyData);
      int m = localArrayList.size();
      if (m == 1) {
        return (MenuItemImpl)localArrayList.get(0);
      }
      boolean bool = isQwertyMode();
      int i = 0;
      while (i < m)
      {
        paramKeyEvent = (MenuItemImpl)localArrayList.get(i);
        if (bool) {}
        for (int j = paramKeyEvent.getAlphabeticShortcut(); ((j == meta[0]) && ((k & 0x2) == 0)) || ((j == meta[2]) && ((k & 0x2) != 0)) || ((bool) && (j == 8) && (paramInt == 67)); j = paramKeyEvent.getNumericShortcut()) {
          return paramKeyEvent;
        }
        i += 1;
      }
    }
  }
  
  private void findItemsWithShortcutForKey(List<MenuItemImpl> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = isQwertyMode();
    int k = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int m = mItems.size();
    int i = 0;
    label49:
    MenuItemImpl localMenuItemImpl;
    if (i < m)
    {
      localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if (localMenuItemImpl.hasSubMenu()) {
        ((MenuBuilder)localMenuItemImpl.getSubMenu()).findItemsWithShortcutForKey(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {
        break label184;
      }
    }
    label184:
    for (int j = localMenuItemImpl.getAlphabeticShortcut();; j = localMenuItemImpl.getNumericShortcut())
    {
      if (((k & 0x5) == 0) && (j != 0) && ((j == meta[0]) || (j == meta[2]) || ((bool) && (j == 8) && (paramInt == 67))) && (localMenuItemImpl.isEnabled())) {
        paramList.add(localMenuItemImpl);
      }
      i += 1;
      break label49;
      break;
    }
  }
  
  private void removeItemAtInt(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= mItems.size())) {}
    do
    {
      return;
      mItems.remove(paramInt);
    } while (!paramBoolean);
    onItemsChanged(true);
  }
  
  public MenuItem add(int paramInt)
  {
    return addInternal(0, 0, 0, mResources.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addInternal(paramInt1, paramInt2, paramInt3, mResources.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return addInternal(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = mContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      paramInt4 = 0;
      if (paramInt4 >= i) {
        break label214;
      }
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (specificIndex >= 0) {
        break label201;
      }
    }
    label201:
    for (paramComponentName = paramIntent;; paramComponentName = paramArrayOfIntent[specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (specificIndex >= 0)) {
        paramArrayOfMenuItem[specificIndex] = paramComponentName;
      }
      paramInt4 += 1;
      break label52;
      i = 0;
      break;
    }
    label214:
    return i;
  }
  
  public final MenuItem addInternal(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i = (0xFFFF0000 & paramInt3) >> 16;
    if ((i < 0) || (i >= sCategoryToOrder.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    i = sCategoryToOrder[i] << 16 | 0xFFFF & paramInt3;
    paramCharSequence = new MenuItemImpl(this, paramInt1, paramInt2, paramInt3, i, paramCharSequence, mDefaultShowAsAction);
    if (mCurrentMenuInfo != null) {
      mMenuInfo = mCurrentMenuInfo;
    }
    mItems.add(findInsertIndex(mItems, i), paramCharSequence);
    onItemsChanged(true);
    return paramCharSequence;
  }
  
  public final void addMenuPresenter(MenuPresenter paramMenuPresenter)
  {
    addMenuPresenter(paramMenuPresenter, mContext);
  }
  
  public final void addMenuPresenter(MenuPresenter paramMenuPresenter, Context paramContext)
  {
    mPresenters.add(new WeakReference(paramMenuPresenter));
    paramMenuPresenter.initForMenu(paramContext, this);
    mIsActionItemsStale = true;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, mResources.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, mResources.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (MenuItemImpl)addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
    SubMenuBuilder localSubMenuBuilder = new SubMenuBuilder(mContext, this, paramCharSequence);
    paramCharSequence.setSubMenu(localSubMenuBuilder);
    return localSubMenuBuilder;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public void clear()
  {
    if (mExpandedItem != null) {
      collapseItemActionView(mExpandedItem);
    }
    mItems.clear();
    onItemsChanged(true);
  }
  
  public void clearHeader()
  {
    mHeaderIcon = null;
    mHeaderTitle = null;
    mHeaderView = null;
    onItemsChanged(false);
  }
  
  public void close()
  {
    close(true);
  }
  
  public final void close(boolean paramBoolean)
  {
    if (mIsClosing) {
      return;
    }
    mIsClosing = true;
    Iterator localIterator = mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        mPresenters.remove(localWeakReference);
      } else {
        localMenuPresenter.onCloseMenu(this, paramBoolean);
      }
    }
    mIsClosing = false;
  }
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool1;
    if ((mPresenters.isEmpty()) || (mExpandedItem != paramMenuItemImpl)) {
      bool1 = false;
    }
    boolean bool2;
    label104:
    do
    {
      return bool1;
      bool1 = false;
      stopDispatchingItemsChanged();
      Iterator localIterator = mPresenters.iterator();
      do
      {
        MenuPresenter localMenuPresenter;
        for (;;)
        {
          bool2 = bool1;
          if (!localIterator.hasNext()) {
            break label104;
          }
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          localMenuPresenter = (MenuPresenter)localWeakReference.get();
          if (localMenuPresenter != null) {
            break;
          }
          mPresenters.remove(localWeakReference);
        }
        bool2 = localMenuPresenter.collapseItemActionView$5c2da31d(paramMenuItemImpl);
        bool1 = bool2;
      } while (!bool2);
      startDispatchingItemsChanged();
      bool1 = bool2;
    } while (!bool2);
    mExpandedItem = null;
    return bool2;
  }
  
  boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (mCallback != null) && (mCallback.onMenuItemSelected(paramMenuBuilder, paramMenuItem));
  }
  
  public final void dispatchSaveInstanceState(Bundle paramBundle)
  {
    if (mPresenters.isEmpty()) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = mPresenters.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)((WeakReference)localObject).get();
      if (localMenuPresenter == null)
      {
        mPresenters.remove(localObject);
      }
      else
      {
        int i = localMenuPresenter.getId();
        if (i > 0)
        {
          localObject = localMenuPresenter.onSaveInstanceState();
          if (localObject != null) {
            localSparseArray.put(i, localObject);
          }
        }
      }
    }
    paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool1;
    if (mPresenters.isEmpty()) {
      bool1 = false;
    }
    boolean bool2;
    label96:
    do
    {
      return bool1;
      bool1 = false;
      stopDispatchingItemsChanged();
      Iterator localIterator = mPresenters.iterator();
      do
      {
        MenuPresenter localMenuPresenter;
        for (;;)
        {
          bool2 = bool1;
          if (!localIterator.hasNext()) {
            break label96;
          }
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          localMenuPresenter = (MenuPresenter)localWeakReference.get();
          if (localMenuPresenter != null) {
            break;
          }
          mPresenters.remove(localWeakReference);
        }
        bool2 = localMenuPresenter.expandItemActionView$5c2da31d(paramMenuItemImpl);
        bool1 = bool2;
      } while (!bool2);
      startDispatchingItemsChanged();
      bool1 = bool2;
    } while (!bool2);
    mExpandedItem = paramMenuItemImpl;
    return bool2;
  }
  
  public MenuItem findItem(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (MenuItemImpl)mItems.get(i);
      if (((MenuItemImpl)localObject).getItemId() == paramInt) {
        return (MenuItem)localObject;
      }
      if (((MenuItemImpl)localObject).hasSubMenu())
      {
        localObject = ((MenuItemImpl)localObject).getSubMenu().findItem(paramInt);
        if (localObject != null) {
          return (MenuItem)localObject;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public final void flagActionItems()
  {
    ArrayList localArrayList = getVisibleItems();
    if (!mIsActionItemsStale) {
      return;
    }
    int i = 0;
    Object localObject = mPresenters.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        mPresenters.remove(localWeakReference);
      } else {
        i |= localMenuPresenter.flagActionItems();
      }
    }
    if (i != 0)
    {
      mActionItems.clear();
      mNonActionItems.clear();
      int k = localArrayList.size();
      i = 0;
      if (i < k)
      {
        localObject = (MenuItemImpl)localArrayList.get(i);
        if (((MenuItemImpl)localObject).isActionButton()) {
          mActionItems.add(localObject);
        }
        for (;;)
        {
          int j;
          i += 1;
          break;
          mNonActionItems.add(localObject);
        }
      }
    }
    else
    {
      mActionItems.clear();
      mNonActionItems.clear();
      mNonActionItems.addAll(getVisibleItems());
    }
    mIsActionItemsStale = false;
  }
  
  protected String getActionViewStatesKey()
  {
    return "android:menu:actionviewstates";
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)mItems.get(paramInt);
  }
  
  public final ArrayList<MenuItemImpl> getNonActionItems()
  {
    flagActionItems();
    return mNonActionItems;
  }
  
  public MenuBuilder getRootMenu()
  {
    return this;
  }
  
  public final ArrayList<MenuItemImpl> getVisibleItems()
  {
    if (!mIsVisibleItemsStale) {
      return mVisibleItems;
    }
    mVisibleItems.clear();
    int j = mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if (localMenuItemImpl.isVisible()) {
        mVisibleItems.add(localMenuItemImpl);
      }
      i += 1;
    }
    mIsVisibleItemsStale = false;
    mIsActionItemsStale = true;
    return mVisibleItems;
  }
  
  public boolean hasVisibleItems()
  {
    if (mOverrideVisibleItems) {
      return true;
    }
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((MenuItemImpl)mItems.get(i)).isVisible()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean isQwertyMode()
  {
    return mQwertyMode;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return findItemWithShortcutForKey(paramInt, paramKeyEvent) != null;
  }
  
  public boolean isShortcutsVisible()
  {
    return mShortcutsVisible;
  }
  
  final void onItemActionRequestChanged$4da0fe86()
  {
    mIsActionItemsStale = true;
    onItemsChanged(true);
  }
  
  final void onItemVisibleChanged$4da0fe86()
  {
    mIsVisibleItemsStale = true;
    onItemsChanged(true);
  }
  
  public void onItemsChanged(boolean paramBoolean)
  {
    if (!mPreventDispatchingItemsChanged)
    {
      if (paramBoolean)
      {
        mIsVisibleItemsStale = true;
        mIsActionItemsStale = true;
      }
      if (!mPresenters.isEmpty())
      {
        stopDispatchingItemsChanged();
        Iterator localIterator = mPresenters.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
          if (localMenuPresenter == null) {
            mPresenters.remove(localWeakReference);
          } else {
            localMenuPresenter.updateMenuView(paramBoolean);
          }
        }
        startDispatchingItemsChanged();
      }
      return;
    }
    mItemsChangedWhileDispatchPrevented = true;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return performItemAction(findItem(paramInt1), null, paramInt2);
  }
  
  public final boolean performItemAction(MenuItem paramMenuItem, MenuPresenter paramMenuPresenter, int paramInt)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    paramMenuItem = (MenuItemImpl)paramMenuItem;
    if ((paramMenuItem == null) || (!paramMenuItem.isEnabled())) {
      bool1 = false;
    }
    boolean bool2;
    Object localObject;
    label95:
    label165:
    do
    {
      return bool1;
      bool2 = paramMenuItem.invoke();
      localObject = mActionProvider;
      if ((localObject != null) && (((ActionProvider)localObject).hasSubMenu())) {}
      for (int i = 1;; i = 0)
      {
        if (!paramMenuItem.hasCollapsibleActionView()) {
          break label95;
        }
        bool2 |= paramMenuItem.expandActionView();
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        close(true);
        return bool2;
      }
      if ((!paramMenuItem.hasSubMenu()) && (i == 0)) {
        break label283;
      }
      close(false);
      if (!paramMenuItem.hasSubMenu()) {
        paramMenuItem.setSubMenu(new SubMenuBuilder(mContext, this, paramMenuItem));
      }
      paramMenuItem = (SubMenuBuilder)paramMenuItem.getSubMenu();
      if (i != 0) {
        ((ActionProvider)localObject).onPrepareSubMenu(paramMenuItem);
      }
      if (!mPresenters.isEmpty()) {
        break;
      }
      bool2 |= bool1;
      bool1 = bool2;
    } while (bool2);
    close(true);
    return bool2;
    bool1 = bool3;
    if (paramMenuPresenter != null) {
      bool1 = paramMenuPresenter.onSubMenuSelected(paramMenuItem);
    }
    paramMenuPresenter = mPresenters.iterator();
    label214:
    while (paramMenuPresenter.hasNext())
    {
      localObject = (WeakReference)paramMenuPresenter.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)((WeakReference)localObject).get();
      if (localMenuPresenter == null)
      {
        mPresenters.remove(localObject);
      }
      else
      {
        if (bool1) {
          break label301;
        }
        bool1 = localMenuPresenter.onSubMenuSelected(paramMenuItem);
      }
    }
    label283:
    label301:
    for (;;)
    {
      break label214;
      break label165;
      bool1 = bool2;
      if ((paramInt & 0x1) != 0) {
        break;
      }
      close(true);
      return bool2;
    }
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = findItemWithShortcutForKey(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null) {
      bool = performItemAction(paramKeyEvent, null, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      close(true);
    }
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (((MenuItemImpl)mItems.get(i)).getGroupId() != paramInt) {}
    }
    for (;;)
    {
      label30:
      if (i >= 0)
      {
        int k = mItems.size();
        j = 0;
        for (;;)
        {
          if ((j < k - i) && (((MenuItemImpl)mItems.get(i)).getGroupId() == paramInt))
          {
            removeItemAtInt(i, false);
            j += 1;
            continue;
            i += 1;
            break;
            i = -1;
            break label30;
          }
        }
        onItemsChanged(true);
      }
    }
  }
  
  public void removeItem(int paramInt)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (((MenuItemImpl)mItems.get(i)).getItemId() != paramInt) {}
    }
    for (;;)
    {
      removeItemAtInt(i, true);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void removeMenuPresenter(MenuPresenter paramMenuPresenter)
  {
    Iterator localIterator = mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if ((localMenuPresenter == null) || (localMenuPresenter == paramMenuPresenter)) {
        mPresenters.remove(localWeakReference);
      }
    }
  }
  
  public final void restoreActionViewStates(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      int i;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(getActionViewStatesKey());
        int j = size();
        i = 0;
        while (i < j)
        {
          MenuItem localMenuItem = getItem(i);
          View localView = MenuItemCompat.getActionView(localMenuItem);
          if ((localView != null) && (localView.getId() != -1)) {
            localView.restoreHierarchyState(localSparseArray);
          }
          if (localMenuItem.hasSubMenu()) {
            ((SubMenuBuilder)localMenuItem.getSubMenu()).restoreActionViewStates(paramBundle);
          }
          i += 1;
        }
        i = paramBundle.getInt("android:menu:expandedactionview");
      } while (i <= 0);
      paramBundle = findItem(i);
    } while (paramBundle == null);
    MenuItemCompat.expandActionView(paramBundle);
  }
  
  public final void saveActionViewStates(Bundle paramBundle)
  {
    Object localObject1 = null;
    int j = size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = getItem(i);
      View localView = MenuItemCompat.getActionView(localMenuItem);
      Object localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (MenuItemCompat.isActionViewExpanded(localMenuItem))
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((SubMenuBuilder)localMenuItem.getSubMenu()).saveActionViewStates(paramBundle);
      }
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(getActionViewStatesKey(), (SparseArray)localObject1);
    }
  }
  
  public void setCallback(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if (localMenuItemImpl.getGroupId() == paramInt)
      {
        localMenuItemImpl.setExclusiveCheckable(paramBoolean2);
        localMenuItemImpl.setCheckable(paramBoolean1);
      }
      i += 1;
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int j = mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if (localMenuItemImpl.getGroupId() == paramInt) {
        localMenuItemImpl.setEnabled(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int m = mItems.size();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      int k = j;
      if (localMenuItemImpl.getGroupId() == paramInt)
      {
        k = j;
        if (localMenuItemImpl.setVisibleInt(paramBoolean)) {
          k = 1;
        }
      }
      i += 1;
      j = k;
    }
    if (j != 0) {
      onItemsChanged(true);
    }
  }
  
  protected final MenuBuilder setHeaderIconInt(Drawable paramDrawable)
  {
    setHeaderInternal$6c64639d(null, paramDrawable, null);
    return this;
  }
  
  final void setHeaderInternal$6c64639d(CharSequence paramCharSequence, Drawable paramDrawable, View paramView)
  {
    if (paramView != null)
    {
      mHeaderView = paramView;
      mHeaderTitle = null;
      mHeaderIcon = null;
    }
    for (;;)
    {
      onItemsChanged(false);
      return;
      if (paramCharSequence != null) {
        mHeaderTitle = paramCharSequence;
      }
      if (paramDrawable != null) {
        mHeaderIcon = paramDrawable;
      }
      mHeaderView = null;
    }
  }
  
  protected final MenuBuilder setHeaderTitleInt(CharSequence paramCharSequence)
  {
    setHeaderInternal$6c64639d(paramCharSequence, null, null);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    mQwertyMode = paramBoolean;
    onItemsChanged(false);
  }
  
  public int size()
  {
    return mItems.size();
  }
  
  public final void startDispatchingItemsChanged()
  {
    mPreventDispatchingItemsChanged = false;
    if (mItemsChangedWhileDispatchPrevented)
    {
      mItemsChangedWhileDispatchPrevented = false;
      onItemsChanged(true);
    }
  }
  
  public final void stopDispatchingItemsChanged()
  {
    if (!mPreventDispatchingItemsChanged)
    {
      mPreventDispatchingItemsChanged = true;
      mItemsChangedWhileDispatchPrevented = false;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem);
    
    public abstract void onMenuModeChange(MenuBuilder paramMenuBuilder);
  }
  
  public static abstract interface ItemInvoker
  {
    public abstract boolean invokeItem(MenuItemImpl paramMenuItemImpl);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */