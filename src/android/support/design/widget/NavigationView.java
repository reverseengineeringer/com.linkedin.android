package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.R.attr;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.NavigationMenuPresenter.NavigationMenuAdapter;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavigationView
  extends ScrimInsetsFrameLayout
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] DISABLED_STATE_SET = { -16842910 };
  private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
  private OnNavigationItemSelectedListener mListener;
  private int mMaxWidth;
  private final NavigationMenu mMenu;
  private MenuInflater mMenuInflater;
  private final NavigationMenuPresenter mPresenter = new NavigationMenuPresenter();
  
  public NavigationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    mMenu = new NavigationMenu(paramContext);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.NavigationView, paramInt, R.style.Widget_Design_NavigationView);
    setBackgroundDrawable(localTypedArray.getDrawable(R.styleable.NavigationView_android_background));
    if (localTypedArray.hasValue(R.styleable.NavigationView_elevation)) {
      ViewCompat.setElevation(this, localTypedArray.getDimensionPixelSize(R.styleable.NavigationView_elevation, 0));
    }
    ViewCompat.setFitsSystemWindows(this, localTypedArray.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
    mMaxWidth = localTypedArray.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
    if (localTypedArray.hasValue(R.styleable.NavigationView_itemIconTint)) {}
    for (ColorStateList localColorStateList = localTypedArray.getColorStateList(R.styleable.NavigationView_itemIconTint);; localColorStateList = createDefaultColorStateList(16842808))
    {
      int i = 0;
      paramInt = 0;
      if (localTypedArray.hasValue(R.styleable.NavigationView_itemTextAppearance))
      {
        paramInt = localTypedArray.getResourceId(R.styleable.NavigationView_itemTextAppearance, 0);
        i = 1;
      }
      paramAttributeSet = null;
      if (localTypedArray.hasValue(R.styleable.NavigationView_itemTextColor)) {
        paramAttributeSet = localTypedArray.getColorStateList(R.styleable.NavigationView_itemTextColor);
      }
      Object localObject = paramAttributeSet;
      if (i == 0)
      {
        localObject = paramAttributeSet;
        if (paramAttributeSet == null) {
          localObject = createDefaultColorStateList(16842806);
        }
      }
      paramAttributeSet = localTypedArray.getDrawable(R.styleable.NavigationView_itemBackground);
      mMenu.setCallback(new MenuBuilder.Callback()
      {
        public boolean onMenuItemSelected(MenuBuilder paramAnonymousMenuBuilder, MenuItem paramAnonymousMenuItem)
        {
          return (mListener != null) && (mListener.onNavigationItemSelected(paramAnonymousMenuItem));
        }
        
        public void onMenuModeChange(MenuBuilder paramAnonymousMenuBuilder) {}
      });
      mPresenter.mId = 1;
      mPresenter.initForMenu(paramContext, mMenu);
      mPresenter.setItemIconTintList(localColorStateList);
      if (i != 0) {
        mPresenter.setItemTextAppearance(paramInt);
      }
      mPresenter.setItemTextColor((ColorStateList)localObject);
      mPresenter.setItemBackground(paramAttributeSet);
      mMenu.addMenuPresenter(mPresenter);
      paramContext = mPresenter;
      if (mMenuView == null)
      {
        mMenuView = ((NavigationMenuView)mLayoutInflater.inflate(R.layout.design_navigation_menu, this, false));
        if (mAdapter == null) {
          mAdapter = new NavigationMenuPresenter.NavigationMenuAdapter(paramContext);
        }
        mHeaderLayout = ((LinearLayout)mLayoutInflater.inflate(R.layout.design_navigation_item_header, mMenuView, false));
        mMenuView.setAdapter(mAdapter);
      }
      addView((View)mMenuView);
      if (localTypedArray.hasValue(R.styleable.NavigationView_menu)) {
        inflateMenu(localTypedArray.getResourceId(R.styleable.NavigationView_menu, 0));
      }
      if (localTypedArray.hasValue(R.styleable.NavigationView_headerLayout)) {
        inflateHeaderView(localTypedArray.getResourceId(R.styleable.NavigationView_headerLayout, 0));
      }
      localTypedArray.recycle();
      return;
    }
  }
  
  private ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = getResources().getColorStateList(resourceId);
    } while (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true));
    paramInt = data;
    int i = localColorStateList.getDefaultColor();
    localObject = DISABLED_STATE_SET;
    int[] arrayOfInt1 = CHECKED_STATE_SET;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(DISABLED_STATE_SET, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (mMenuInflater == null) {
      mMenuInflater = new SupportMenuInflater(getContext());
    }
    return mMenuInflater;
  }
  
  public void addHeaderView(View paramView)
  {
    mPresenter.addHeaderView(paramView);
  }
  
  public int getHeaderCount()
  {
    return mPresenter.mHeaderLayout.getChildCount();
  }
  
  public View getHeaderView(int paramInt)
  {
    return mPresenter.mHeaderLayout.getChildAt(paramInt);
  }
  
  public Drawable getItemBackground()
  {
    return mPresenter.mItemBackground;
  }
  
  public ColorStateList getItemIconTintList()
  {
    return mPresenter.mIconTintList;
  }
  
  public ColorStateList getItemTextColor()
  {
    return mPresenter.mTextColor;
  }
  
  public Menu getMenu()
  {
    return mMenu;
  }
  
  public View inflateHeaderView(int paramInt)
  {
    NavigationMenuPresenter localNavigationMenuPresenter = mPresenter;
    View localView = mLayoutInflater.inflate(paramInt, mHeaderLayout, false);
    localNavigationMenuPresenter.addHeaderView(localView);
    return localView;
  }
  
  public void inflateMenu(int paramInt)
  {
    mPresenter.setUpdateSuspended(true);
    getMenuInflater().inflate(paramInt, mMenu);
    mPresenter.setUpdateSuspended(false);
    mPresenter.updateMenuView(false);
  }
  
  protected void onInsetsChanged(Rect paramRect)
  {
    NavigationMenuPresenter localNavigationMenuPresenter = mPresenter;
    int i = top;
    if (mPaddingTopDefault != i)
    {
      mPaddingTopDefault = i;
      if (mHeaderLayout.getChildCount() == 0) {
        mMenuView.setPadding(0, mPaddingTopDefault, 0, mMenuView.getPaddingBottom());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i = paramInt1;
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      return;
      i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), mMaxWidth), 1073741824);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(mMaxWidth, 1073741824);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      Object localObject1 = (SavedState)paramParcelable;
      super.onRestoreInstanceState(((SavedState)localObject1).getSuperState());
      paramParcelable = mMenu;
      localObject1 = menuState.getSparseParcelableArray("android:menu:presenters");
      if ((localObject1 != null) && (!mPresenters.isEmpty()))
      {
        Iterator localIterator = mPresenters.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (WeakReference)localIterator.next();
          MenuPresenter localMenuPresenter = (MenuPresenter)((WeakReference)localObject2).get();
          if (localMenuPresenter == null)
          {
            mPresenters.remove(localObject2);
          }
          else
          {
            int i = localMenuPresenter.getId();
            if (i > 0)
            {
              localObject2 = (Parcelable)((SparseArray)localObject1).get(i);
              if (localObject2 != null) {
                localMenuPresenter.onRestoreInstanceState((Parcelable)localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    menuState = new Bundle();
    mMenu.dispatchSaveInstanceState(menuState);
    return localSavedState;
  }
  
  public void removeHeaderView(View paramView)
  {
    NavigationMenuPresenter localNavigationMenuPresenter = mPresenter;
    mHeaderLayout.removeView(paramView);
    if (mHeaderLayout.getChildCount() == 0) {
      mMenuView.setPadding(0, mPaddingTopDefault, 0, mMenuView.getPaddingBottom());
    }
  }
  
  public void setCheckedItem(int paramInt)
  {
    Object localObject = mMenu.findItem(paramInt);
    if (localObject != null)
    {
      NavigationMenuPresenter localNavigationMenuPresenter = mPresenter;
      localObject = (MenuItemImpl)localObject;
      mAdapter.setCheckedItem((MenuItemImpl)localObject);
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    mPresenter.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    setItemBackground(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    mPresenter.setItemIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearance(int paramInt)
  {
    mPresenter.setItemTextAppearance(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    mPresenter.setItemTextColor(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    mListener = paramOnNavigationItemSelectedListener;
  }
  
  public static abstract interface OnNavigationItemSelectedListener
  {
    public abstract boolean onNavigationItemSelected(MenuItem paramMenuItem);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public final NavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new NavigationView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public final NavigationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new NavigationView.SavedState[paramAnonymousInt];
      }
    });
    public Bundle menuState;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      menuState = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(menuState);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.NavigationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */