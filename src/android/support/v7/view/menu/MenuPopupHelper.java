package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class MenuPopupHelper
  implements MenuPresenter, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
  private final MenuAdapter mAdapter;
  public View mAnchorView;
  private int mContentWidth;
  private final Context mContext;
  public int mDropDownGravity = 0;
  public boolean mForceShowIcon;
  private boolean mHasContentWidth;
  private final LayoutInflater mInflater;
  private ViewGroup mMeasureParent;
  private final MenuBuilder mMenu;
  private final boolean mOverflowOnly;
  public ListPopupWindow mPopup;
  private final int mPopupMaxWidth;
  private final int mPopupStyleAttr;
  private final int mPopupStyleRes;
  public MenuPresenter.Callback mPresenterCallback;
  private ViewTreeObserver mTreeObserver;
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView)
  {
    this(paramContext, paramMenuBuilder, paramView, false, R.attr.popupMenuStyle);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramMenuBuilder, paramView, paramBoolean, paramInt, (byte)0);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt, byte paramByte)
  {
    mContext = paramContext;
    mInflater = LayoutInflater.from(paramContext);
    mMenu = paramMenuBuilder;
    mAdapter = new MenuAdapter(mMenu);
    mOverflowOnly = paramBoolean;
    mPopupStyleAttr = paramInt;
    mPopupStyleRes = 0;
    Resources localResources = paramContext.getResources();
    mPopupMaxWidth = Math.max(getDisplayMetricswidthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    mAnchorView = paramView;
    paramMenuBuilder.addMenuPresenter(this, paramContext);
  }
  
  public final boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      mPopup.dismiss();
    }
  }
  
  public final boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public final boolean flagActionItems()
  {
    return false;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {}
  
  public final boolean isShowing()
  {
    return (mPopup != null) && (mPopup.mPopup.isShowing());
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (paramMenuBuilder != mMenu) {}
    do
    {
      return;
      dismiss();
    } while (mPresenterCallback == null);
    mPresenterCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onDismiss()
  {
    mPopup = null;
    mMenu.close();
    if (mTreeObserver != null)
    {
      if (!mTreeObserver.isAlive()) {
        mTreeObserver = mAnchorView.getViewTreeObserver();
      }
      mTreeObserver.removeGlobalOnLayoutListener(this);
      mTreeObserver = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = mAnchorView;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      dismiss();
    }
    label28:
    while (!isShowing()) {
      return;
    }
    mPopup.show();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = mAdapter;
    mAdapterMenu.performItemAction(paramAdapterView.getItem(paramInt), null, 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public final Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      MenuPopupHelper localMenuPopupHelper = new MenuPopupHelper(mContext, paramSubMenuBuilder, mAnchorView);
      mPresenterCallback = mPresenterCallback;
      boolean bool2 = false;
      int j = paramSubMenuBuilder.size();
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          MenuItem localMenuItem = paramSubMenuBuilder.getItem(i);
          if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null)) {
            bool1 = true;
          }
        }
        else
        {
          mForceShowIcon = bool1;
          if (!localMenuPopupHelper.tryShow()) {
            break;
          }
          if (mPresenterCallback != null) {
            mPresenterCallback.onOpenSubMenu(paramSubMenuBuilder);
          }
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public final void show()
  {
    if (!tryShow()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public final boolean tryShow()
  {
    mPopup = new ListPopupWindow(mContext, null, mPopupStyleAttr, mPopupStyleRes);
    mPopup.setOnDismissListener(this);
    mPopup.mItemClickListener = this;
    mPopup.setAdapter(mAdapter);
    mPopup.setModal$1385ff();
    View localView = mAnchorView;
    int i;
    int j;
    int m;
    if (localView != null)
    {
      if (mTreeObserver == null) {}
      for (i = 1;; i = 0)
      {
        mTreeObserver = localView.getViewTreeObserver();
        if (i != 0) {
          mTreeObserver.addOnGlobalLayoutListener(this);
        }
        mPopup.mDropDownAnchorView = localView;
        mPopup.mDropDownGravity = mDropDownGravity;
        if (!mHasContentWidth)
        {
          MenuAdapter localMenuAdapter = mAdapter;
          int n = View.MeasureSpec.makeMeasureSpec(0, 0);
          int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
          int i2 = localMenuAdapter.getCount();
          j = 0;
          int k = 0;
          localView = null;
          i = 0;
          m = i;
          if (j < i2)
          {
            m = localMenuAdapter.getItemViewType(j);
            if (m == k) {
              break label336;
            }
            k = m;
            localView = null;
            label195:
            if (mMeasureParent == null) {
              mMeasureParent = new FrameLayout(mContext);
            }
            localView = localMenuAdapter.getView(j, localView, mMeasureParent);
            localView.measure(n, i1);
            m = localView.getMeasuredWidth();
            if (m < mPopupMaxWidth) {
              break;
            }
            m = mPopupMaxWidth;
          }
          mContentWidth = m;
          mHasContentWidth = true;
        }
        mPopup.setContentWidth(mContentWidth);
        mPopup.setInputMethodMode$13462e();
        mPopup.show();
        mPopup.mDropDownList.setOnKeyListener(this);
        return true;
      }
    }
    return false;
    if (m > i) {
      i = m;
    }
    for (;;)
    {
      j += 1;
      break;
      label336:
      break label195;
    }
  }
  
  public final void updateMenuView(boolean paramBoolean)
  {
    mHasContentWidth = false;
    if (mAdapter != null) {
      mAdapter.notifyDataSetChanged();
    }
  }
  
  private final class MenuAdapter
    extends BaseAdapter
  {
    private MenuBuilder mAdapterMenu;
    private int mExpandedIndex = -1;
    
    public MenuAdapter(MenuBuilder paramMenuBuilder)
    {
      mAdapterMenu = paramMenuBuilder;
      findExpandedIndex();
    }
    
    private void findExpandedIndex()
    {
      MenuItemImpl localMenuItemImpl = mMenu.mExpandedItem;
      if (localMenuItemImpl != null)
      {
        ArrayList localArrayList = mMenu.getNonActionItems();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl)
          {
            mExpandedIndex = i;
            return;
          }
          i += 1;
        }
      }
      mExpandedIndex = -1;
    }
    
    public final int getCount()
    {
      if (mOverflowOnly) {}
      for (ArrayList localArrayList = mAdapterMenu.getNonActionItems(); mExpandedIndex < 0; localArrayList = mAdapterMenu.getVisibleItems()) {
        return localArrayList.size();
      }
      return localArrayList.size() - 1;
    }
    
    public final MenuItemImpl getItem(int paramInt)
    {
      if (mOverflowOnly) {}
      for (ArrayList localArrayList = mAdapterMenu.getNonActionItems();; localArrayList = mAdapterMenu.getVisibleItems())
      {
        int i = paramInt;
        if (mExpandedIndex >= 0)
        {
          i = paramInt;
          if (paramInt >= mExpandedIndex) {
            i = paramInt + 1;
          }
        }
        return (MenuItemImpl)localArrayList.get(i);
      }
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, paramViewGroup, false);
      }
      paramView = (MenuView.ItemView)localView;
      if (mForceShowIcon) {
        ((ListMenuItemView)localView).setForceShowIcon(true);
      }
      paramView.initialize$667f453d(getItem(paramInt));
      return localView;
    }
    
    public final void notifyDataSetChanged()
    {
      findExpandedIndex();
      super.notifyDataSetChanged();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuPopupHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */