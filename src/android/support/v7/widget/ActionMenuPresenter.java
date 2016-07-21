package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.integer;
import android.support.v7.appcompat.R.layout;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.PopupCallback;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;

final class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  boolean mExpandedActionViewsExclusive;
  int mMaxItems;
  boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  OverflowMenuButton mOverflowButton;
  OverflowPopup mOverflowPopup;
  Drawable mPendingOverflowIcon;
  boolean mPendingOverflowIconSet;
  private ActionMenuPopupCallback mPopupCallback;
  final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback((byte)0);
  OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private View mScrapActionButtonView;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  public final void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize$667f453d(paramMenuItemImpl);
    paramMenuItemImpl = (ActionMenuView)mMenuView;
    paramItemView = (ActionMenuItemView)paramItemView;
    paramItemView.setItemInvoker(paramMenuItemImpl);
    if (mPopupCallback == null) {
      mPopupCallback = new ActionMenuPopupCallback((byte)0);
    }
    paramItemView.setPopupCallback(mPopupCallback);
  }
  
  public final boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public final boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == mOverflowButton) {
      return false;
    }
    return super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public final boolean flagActionItems()
  {
    ArrayList localArrayList = mMenu.getVisibleItems();
    int i5 = localArrayList.size();
    int i = mMaxItems;
    int i4 = mActionItemWidthLimit;
    int i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)mMenuView;
    int j = 0;
    int m = 0;
    int i2 = 0;
    int n = 0;
    int k = 0;
    int i1;
    if (k < i5)
    {
      localObject1 = (MenuItemImpl)localArrayList.get(k);
      if (((MenuItemImpl)localObject1).requiresActionButton()) {
        j += 1;
      }
      for (;;)
      {
        i1 = i;
        if (mExpandedActionViewsExclusive)
        {
          i1 = i;
          if (((MenuItemImpl)localObject1).isActionViewExpanded()) {
            i1 = 0;
          }
        }
        k += 1;
        i = i1;
        break;
        if (((MenuItemImpl)localObject1).requestsActionButton()) {
          m += 1;
        } else {
          n = 1;
        }
      }
    }
    k = i;
    if (mReserveOverflow) {
      if (n == 0)
      {
        k = i;
        if (j + m <= i) {}
      }
      else
      {
        k = i - 1;
      }
    }
    k -= j;
    Object localObject1 = mActionButtonGroups;
    ((SparseBooleanArray)localObject1).clear();
    int i3 = 0;
    j = 0;
    if (mStrictWidthLimit)
    {
      j = i4 / mMinCellSize;
      i = mMinCellSize;
      i3 = mMinCellSize + i4 % i / j;
    }
    i = 0;
    n = i4;
    i4 = i;
    i = i2;
    if (i4 < i5)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(i4);
      Object localObject2;
      if (localMenuItemImpl.requiresActionButton())
      {
        localObject2 = getItemView(localMenuItemImpl, mScrapActionButtonView, localViewGroup);
        if (mScrapActionButtonView == null) {
          mScrapActionButtonView = ((View)localObject2);
        }
        if (mStrictWidthLimit)
        {
          j -= ActionMenuView.measureChildForCells((View)localObject2, i3, j, i6, 0);
          label310:
          i1 = ((View)localObject2).getMeasuredWidth();
          m = n - i1;
          n = i;
          if (i == 0) {
            n = i1;
          }
          i = localMenuItemImpl.getGroupId();
          if (i != 0) {
            ((SparseBooleanArray)localObject1).put(i, true);
          }
          localMenuItemImpl.setIsActionButton(true);
          i = n;
        }
      }
      for (;;)
      {
        i4 += 1;
        n = m;
        break;
        ((View)localObject2).measure(i6, i6);
        break label310;
        if (localMenuItemImpl.requestsActionButton())
        {
          int i7 = localMenuItemImpl.getGroupId();
          boolean bool = ((SparseBooleanArray)localObject1).get(i7);
          int i8;
          label438:
          int i9;
          if (((k > 0) || (bool)) && (n > 0) && ((!mStrictWidthLimit) || (j > 0)))
          {
            i8 = 1;
            i2 = j;
            i1 = i;
            i9 = i8;
            m = n;
            if (i8 != 0)
            {
              localObject2 = getItemView(localMenuItemImpl, mScrapActionButtonView, localViewGroup);
              if (mScrapActionButtonView == null) {
                mScrapActionButtonView = ((View)localObject2);
              }
              if (!mStrictWidthLimit) {
                break label625;
              }
              i1 = ActionMenuView.measureChildForCells((View)localObject2, i3, j, i6, 0);
              m = j - i1;
              j = m;
              if (i1 == 0)
              {
                i8 = 0;
                j = m;
              }
              label524:
              i2 = ((View)localObject2).getMeasuredWidth();
              m = n - i2;
              i1 = i;
              if (i == 0) {
                i1 = i2;
              }
              if (!mStrictWidthLimit) {
                break label642;
              }
              if (m < 0) {
                break label637;
              }
              i = 1;
              label563:
              i9 = i8 & i;
              i2 = j;
            }
            if ((i9 == 0) || (i7 == 0)) {
              break label669;
            }
            ((SparseBooleanArray)localObject1).put(i7, true);
            i = k;
          }
          label625:
          label637:
          label642:
          label669:
          do
          {
            k = i;
            if (i9 != 0) {
              k = i - 1;
            }
            localMenuItemImpl.setIsActionButton(i9);
            j = i2;
            i = i1;
            break;
            i8 = 0;
            break label438;
            ((View)localObject2).measure(i6, i6);
            break label524;
            i = 0;
            break label563;
            if (m + i1 > 0) {}
            for (i = 1;; i = 0)
            {
              i9 = i8 & i;
              i2 = j;
              break;
            }
            i = k;
          } while (!bool);
          ((SparseBooleanArray)localObject1).put(i7, false);
          j = 0;
          for (;;)
          {
            i = k;
            if (j >= i4) {
              break;
            }
            localObject2 = (MenuItemImpl)localArrayList.get(j);
            i = k;
            if (((MenuItemImpl)localObject2).getGroupId() == i7)
            {
              i = k;
              if (((MenuItemImpl)localObject2).isActionButton()) {
                i = k + 1;
              }
              ((MenuItemImpl)localObject2).setIsActionButton(false);
            }
            j += 1;
            k = i;
          }
        }
        localMenuItemImpl.setIsActionButton(false);
        m = n;
      }
    }
    return true;
  }
  
  public final View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.hasCollapsibleActionView())) {
      localView = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup);
    }
    if (paramMenuItemImpl.isActionViewExpanded()) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      paramMenuItemImpl = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramMenuItemImpl.checkLayoutParams(paramView)) {
        localView.setLayoutParams(ActionMenuView.generateLayoutParams(paramView));
      }
      return localView;
    }
  }
  
  public final MenuView getMenuView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getMenuView(paramViewGroup);
    ((ActionMenuView)paramViewGroup).setPresenter(this);
    return paramViewGroup;
  }
  
  public final boolean hideOverflowMenu()
  {
    if ((mPostedOpenRunnable != null) && (mMenuView != null))
    {
      ((View)mMenuView).removeCallbacks(mPostedOpenRunnable);
      mPostedOpenRunnable = null;
      return true;
    }
    OverflowPopup localOverflowPopup = mOverflowPopup;
    if (localOverflowPopup != null)
    {
      localOverflowPopup.dismiss();
      return true;
    }
    return false;
  }
  
  public final boolean hideSubMenus()
  {
    if (mActionButtonPopup != null)
    {
      mActionButtonPopup.dismiss();
      return true;
    }
    return false;
  }
  
  public final void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    boolean bool = true;
    super.initForMenu(paramContext, paramMenuBuilder);
    paramMenuBuilder = paramContext.getResources();
    paramContext = ActionBarPolicy.get(paramContext);
    int i;
    if (!mReserveOverflowSet)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        mReserveOverflow = bool;
      }
    }
    else
    {
      if (!mWidthLimitSet) {
        mWidthLimit = (mContext.getResources().getDisplayMetrics().widthPixels / 2);
      }
      if (!mMaxItemsSet) {
        mMaxItems = mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
      }
      i = mWidthLimit;
      if (!mReserveOverflow) {
        break label227;
      }
      if (mOverflowButton == null)
      {
        mOverflowButton = new OverflowMenuButton(mSystemContext);
        if (mPendingOverflowIconSet)
        {
          mOverflowButton.setImageDrawable(mPendingOverflowIcon);
          mPendingOverflowIcon = null;
          mPendingOverflowIconSet = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        mOverflowButton.measure(j, j);
      }
      i -= mOverflowButton.getMeasuredWidth();
    }
    for (;;)
    {
      mActionItemWidthLimit = i;
      mMinCellSize = ((int)(56.0F * getDisplayMetricsdensity));
      mScrapActionButtonView = null;
      return;
      if (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(mContext))) {
        break;
      }
      bool = false;
      break;
      label227:
      mOverflowButton = null;
    }
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return (mOverflowPopup != null) && (mOverflowPopup.isShowing());
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {}
    do
    {
      do
      {
        return;
        paramParcelable = (SavedState)paramParcelable;
      } while (openSubMenuId <= 0);
      paramParcelable = mMenu.findItem(openSubMenuId);
    } while (paramParcelable == null);
    onSubMenuSelected((SubMenuBuilder)paramParcelable.getSubMenu());
  }
  
  public final Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    openSubMenuId = mOpenSubMenuId;
    return localSavedState;
  }
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return false;
    }
    for (Object localObject1 = paramSubMenuBuilder; mParentMenu != mMenu; localObject1 = (SubMenuBuilder)mParentMenu) {}
    Object localObject2 = ((SubMenuBuilder)localObject1).getItem();
    ViewGroup localViewGroup = (ViewGroup)mMenuView;
    int i;
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      i = 0;
      if (i < j)
      {
        localObject1 = localViewGroup.getChildAt(i);
        if ((!(localObject1 instanceof MenuView.ItemView)) || (((MenuView.ItemView)localObject1).getItemData() != localObject2)) {}
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label139;
      }
      if (mOverflowButton != null) {
        break label133;
      }
      return false;
      i += 1;
      break;
      localObject1 = null;
    }
    label133:
    localObject2 = mOverflowButton;
    label139:
    mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
    mActionButtonPopup = new ActionButtonSubmenu(mContext, paramSubMenuBuilder);
    mActionButtonPopup.mAnchorView = ((View)localObject2);
    mActionButtonPopup.show();
    super.onSubMenuSelected(paramSubMenuBuilder);
    return true;
  }
  
  public final void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.onSubMenuSelected(null);
      return;
    }
    mMenu.close(false);
  }
  
  public final void setMenuView(ActionMenuView paramActionMenuView)
  {
    mMenuView = paramActionMenuView;
    mMenu = mMenu;
  }
  
  public final void setReserveOverflow$1385ff()
  {
    mReserveOverflow = true;
    mReserveOverflowSet = true;
  }
  
  public final boolean shouldIncludeItem$6edfc5cf(MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public final boolean showOverflowMenu()
  {
    if ((mReserveOverflow) && (!isOverflowMenuShowing()) && (mMenu != null) && (mMenuView != null) && (mPostedOpenRunnable == null) && (!mMenu.getNonActionItems().isEmpty()))
    {
      mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(mContext, mMenu, mOverflowButton));
      ((View)mMenuView).post(mPostedOpenRunnable);
      super.onSubMenuSelected(null);
      return true;
    }
    return false;
  }
  
  public final void updateMenuView(boolean paramBoolean)
  {
    ((View)mMenuView).getParent();
    super.updateMenuView(paramBoolean);
    ((View)mMenuView).requestLayout();
    Object localObject;
    int j;
    int i;
    if (mMenu != null)
    {
      localObject = mMenu;
      ((MenuBuilder)localObject).flagActionItems();
      localObject = mActionItems;
      j = ((ArrayList)localObject).size();
      i = 0;
      while (i < j)
      {
        ActionProvider localActionProvider = getmActionProvider;
        if (localActionProvider != null) {
          mSubUiVisibilityListener = this;
        }
        i += 1;
      }
    }
    if (mMenu != null)
    {
      localObject = mMenu.getNonActionItems();
      j = 0;
      i = j;
      if (mReserveOverflow)
      {
        i = j;
        if (localObject != null)
        {
          i = ((ArrayList)localObject).size();
          if (i != 1) {
            break label263;
          }
          if (((MenuItemImpl)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label258;
          }
          i = 1;
        }
      }
      label158:
      if (i == 0) {
        break label277;
      }
      if (mOverflowButton == null) {
        mOverflowButton = new OverflowMenuButton(mSystemContext);
      }
      localObject = (ViewGroup)mOverflowButton.getParent();
      if (localObject != mMenuView)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(mOverflowButton);
        }
        ((ActionMenuView)mMenuView).addView(mOverflowButton, ActionMenuView.generateOverflowButtonLayoutParams());
      }
    }
    for (;;)
    {
      ((ActionMenuView)mMenuView).setOverflowReserved(mReserveOverflow);
      return;
      localObject = null;
      break;
      label258:
      i = 0;
      break label158;
      label263:
      if (i > 0) {}
      for (i = 1;; i = 0) {
        break;
      }
      label277:
      if ((mOverflowButton != null) && (mOverflowButton.getParent() == mMenuView)) {
        ((ViewGroup)mMenuView).removeView(mOverflowButton);
      }
    }
  }
  
  private final class ActionButtonSubmenu
    extends MenuPopupHelper
  {
    private SubMenuBuilder mSubMenu;
    
    public ActionButtonSubmenu(Context paramContext, SubMenuBuilder paramSubMenuBuilder)
    {
      super(paramSubMenuBuilder, null, false, R.attr.actionOverflowMenuStyle);
      mSubMenu = paramSubMenuBuilder;
      boolean bool2;
      int j;
      int i;
      if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton())
      {
        if (mOverflowButton == null)
        {
          paramContext = (View)mMenuView;
          mAnchorView = paramContext;
        }
      }
      else
      {
        mPresenterCallback = mPopupPresenterCallback;
        bool2 = false;
        j = paramSubMenuBuilder.size();
        i = 0;
      }
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          this$1 = paramSubMenuBuilder.getItem(i);
          if ((isVisible()) && (getIcon() != null)) {
            bool1 = true;
          }
        }
        else
        {
          mForceShowIcon = bool1;
          return;
          paramContext = mOverflowButton;
          break;
        }
        i += 1;
      }
    }
    
    public final void onDismiss()
    {
      super.onDismiss();
      mActionButtonPopup = null;
      mOpenSubMenuId = 0;
    }
  }
  
  private final class ActionMenuPopupCallback
    extends ActionMenuItemView.PopupCallback
  {
    private ActionMenuPopupCallback() {}
    
    public final ListPopupWindow getPopup()
    {
      if (mActionButtonPopup != null) {
        return mActionButtonPopup.mPopup;
      }
      return null;
    }
  }
  
  private final class OpenOverflowRunnable
    implements Runnable
  {
    private ActionMenuPresenter.OverflowPopup mPopup;
    
    public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup paramOverflowPopup)
    {
      mPopup = paramOverflowPopup;
    }
    
    public final void run()
    {
      Object localObject = mMenu;
      if (mCallback != null) {
        mCallback.onMenuModeChange((MenuBuilder)localObject);
      }
      localObject = (View)mMenuView;
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (mPopup.tryShow())) {
        mOverflowPopup = mPopup;
      }
      mPostedOpenRunnable = null;
    }
  }
  
  private final class OverflowMenuButton
    extends AppCompatImageView
    implements ActionMenuView.ActionMenuChildView
  {
    private final float[] mTempPts = new float[2];
    
    public OverflowMenuButton(Context paramContext)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      setOnTouchListener(new ListPopupWindow.ForwardingListener(this)
      {
        public final ListPopupWindow getPopup()
        {
          if (mOverflowPopup == null) {
            return null;
          }
          return mOverflowPopup.mPopup;
        }
        
        public final boolean onForwardingStarted()
        {
          showOverflowMenu();
          return true;
        }
        
        public final boolean onForwardingStopped()
        {
          if (mPostedOpenRunnable != null) {
            return false;
          }
          hideOverflowMenu();
          return true;
        }
      });
    }
    
    public final boolean needsDividerAfter()
    {
      return false;
    }
    
    public final boolean needsDividerBefore()
    {
      return false;
    }
    
    public final boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      showOverflowMenu();
      return true;
    }
    
    protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt2 = getHeight();
        paramInt1 = Math.max(i, paramInt2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
        DrawableCompat.setHotspotBounds(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
  }
  
  private final class OverflowPopup
    extends MenuPopupHelper
  {
    public OverflowPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView)
    {
      super(paramMenuBuilder, paramView, true, R.attr.actionOverflowMenuStyle);
      mDropDownGravity = 8388613;
      mPresenterCallback = mPopupPresenterCallback;
    }
    
    public final void onDismiss()
    {
      super.onDismiss();
      if (mMenu != null) {
        mMenu.close();
      }
      mOverflowPopup = null;
    }
  }
  
  private final class PopupPresenterCallback
    implements MenuPresenter.Callback
  {
    private PopupPresenterCallback() {}
    
    public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if ((paramMenuBuilder instanceof SubMenuBuilder)) {
        mParentMenu.close(false);
      }
      MenuPresenter.Callback localCallback = mCallback;
      if (localCallback != null) {
        localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
      }
    }
    
    public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder == null) {
        return false;
      }
      mOpenSubMenuId = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
      MenuPresenter.Callback localCallback = mCallback;
      if (localCallback != null) {
        return localCallback.onOpenSubMenu(paramMenuBuilder);
      }
      return false;
    }
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int openSubMenuId;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      openSubMenuId = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(openSubMenuId);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */