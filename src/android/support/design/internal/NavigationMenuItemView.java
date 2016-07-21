package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.R.attr;
import android.support.design.R.dimen;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView.ItemView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  FrameLayout mActionArea;
  private final int mIconSize;
  private ColorStateList mIconTintList;
  private MenuItemImpl mItemData;
  final CheckedTextView mTextView;
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, this, true);
    mIconSize = paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
    mTextView = ((CheckedTextView)findViewById(R.id.design_menu_item_text));
    mTextView.setDuplicateParentStateEnabled(true);
  }
  
  private void setActionView(View paramView)
  {
    if (mActionArea == null) {
      mActionArea = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
    }
    mActionArea.removeAllViews();
    if (paramView != null) {
      mActionArea.addView(paramView);
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return mItemData;
  }
  
  public final void initialize$667f453d(MenuItemImpl paramMenuItemImpl)
  {
    mItemData = paramMenuItemImpl;
    int i;
    StateListDrawable localStateListDrawable;
    if (paramMenuItemImpl.isVisible())
    {
      i = 0;
      setVisibility(i);
      if (getBackground() == null)
      {
        TypedValue localTypedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true)) {
          break label156;
        }
        localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(data));
        localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      }
    }
    for (;;)
    {
      setBackgroundDrawable(localStateListDrawable);
      setCheckable(paramMenuItemImpl.isCheckable());
      setChecked(paramMenuItemImpl.isChecked());
      setEnabled(paramMenuItemImpl.isEnabled());
      setTitle(paramMenuItemImpl.getTitle());
      setIcon(paramMenuItemImpl.getIcon());
      setActionView(paramMenuItemImpl.getActionView());
      return;
      i = 8;
      break;
      label156:
      localStateListDrawable = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((mItemData != null) && (mItemData.isCheckable()) && (mItemData.isChecked())) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public final boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    mTextView.setChecked(paramBoolean);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        break label54;
      }
    }
    for (;;)
    {
      localObject = DrawableCompat.wrap(paramDrawable).mutate();
      ((Drawable)localObject).setBounds(0, 0, mIconSize, mIconSize);
      DrawableCompat.setTintList((Drawable)localObject, mIconTintList);
      TextViewCompat.setCompoundDrawablesRelative$16207aff(mTextView, (Drawable)localObject);
      return;
      label54:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    mIconTintList = paramColorStateList;
    if (mItemData != null) {
      setIcon(mItemData.getIcon());
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    mTextView.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mTextView.setText(paramCharSequence);
  }
}

/* Location:
 * Qualified Name:     android.support.design.internal.NavigationMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */