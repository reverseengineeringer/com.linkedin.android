package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
  extends LinearLayout
  implements MenuView.ItemView
{
  private Drawable mBackground;
  private CheckBox mCheckBox;
  private Context mContext;
  private boolean mForceShowIcon;
  private ImageView mIconView;
  private LayoutInflater mInflater;
  private MenuItemImpl mItemData;
  private int mMenuType;
  private boolean mPreserveIconSpacing;
  private RadioButton mRadioButton;
  private TextView mShortcutView;
  private int mTextAppearance;
  private Context mTextAppearanceContext;
  private TextView mTitleView;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    mBackground = paramAttributeSet.getDrawable(R.styleable.MenuView_android_itemBackground);
    mTextAppearance = paramAttributeSet.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    mPreserveIconSpacing = paramAttributeSet.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    mTextAppearanceContext = paramContext;
    paramAttributeSet.recycle();
  }
  
  private LayoutInflater getInflater()
  {
    if (mInflater == null) {
      mInflater = LayoutInflater.from(mContext);
    }
    return mInflater;
  }
  
  private void insertCheckBox()
  {
    mCheckBox = ((CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false));
    addView(mCheckBox);
  }
  
  private void insertRadioButton()
  {
    mRadioButton = ((RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false));
    addView(mRadioButton);
  }
  
  private void setShortcut$25d965e(boolean paramBoolean)
  {
    if ((paramBoolean) && (mItemData.shouldShowShortcut())) {}
    char c;
    for (int i = 0;; i = 8)
    {
      if (i == 0)
      {
        TextView localTextView = mShortcutView;
        c = mItemData.getShortcut();
        if (c != 0) {
          break;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (mShortcutView.getVisibility() != i) {
        mShortcutView.setVisibility(i);
      }
      return;
    }
    Object localObject = new StringBuilder(MenuItemImpl.sPrependShortcutLabel);
    switch (c)
    {
    default: 
      ((StringBuilder)localObject).append(c);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      break;
      ((StringBuilder)localObject).append(MenuItemImpl.sEnterShortcutLabel);
      continue;
      ((StringBuilder)localObject).append(MenuItemImpl.sDeleteShortcutLabel);
      continue;
      ((StringBuilder)localObject).append(MenuItemImpl.sSpaceShortcutLabel);
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return mItemData;
  }
  
  public final void initialize$667f453d(MenuItemImpl paramMenuItemImpl)
  {
    int j = 0;
    mItemData = paramMenuItemImpl;
    mMenuType = 0;
    if (paramMenuItemImpl.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramMenuItemImpl.getTitleForItemView(this));
      setCheckable(paramMenuItemImpl.isCheckable());
      boolean bool = paramMenuItemImpl.shouldShowShortcut();
      paramMenuItemImpl.getShortcut();
      if ((!bool) || (!mItemData.shouldShowShortcut())) {
        break label148;
      }
    }
    char c;
    label148:
    for (int i = j;; i = 8)
    {
      if (i == 0)
      {
        TextView localTextView = mShortcutView;
        c = mItemData.getShortcut();
        if (c != 0) {
          break label154;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (mShortcutView.getVisibility() != i) {
        mShortcutView.setVisibility(i);
      }
      setIcon(paramMenuItemImpl.getIcon());
      setEnabled(paramMenuItemImpl.isEnabled());
      return;
      i = 8;
      break;
    }
    label154:
    Object localObject = new StringBuilder(MenuItemImpl.sPrependShortcutLabel);
    switch (c)
    {
    default: 
      ((StringBuilder)localObject).append(c);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      break;
      ((StringBuilder)localObject).append(MenuItemImpl.sEnterShortcutLabel);
      continue;
      ((StringBuilder)localObject).append(MenuItemImpl.sDeleteShortcutLabel);
      continue;
      ((StringBuilder)localObject).append(MenuItemImpl.sSpaceShortcutLabel);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setBackgroundDrawable(mBackground);
    mTitleView = ((TextView)findViewById(R.id.title));
    if (mTextAppearance != -1) {
      mTitleView.setTextAppearance(mTextAppearanceContext, mTextAppearance);
    }
    mShortcutView = ((TextView)findViewById(R.id.shortcut));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((mIconView != null) && (mPreserveIconSpacing))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)mIconView.getLayoutParams();
      if ((height > 0) && (width <= 0)) {
        width = height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (mRadioButton == null) && (mCheckBox == null)) {}
    label51:
    label133:
    label139:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (mItemData.isExclusiveCheckable())
      {
        if (mRadioButton == null) {
          insertRadioButton();
        }
        localObject1 = mRadioButton;
        localObject2 = mCheckBox;
        if (!paramBoolean) {
          break label139;
        }
        ((CompoundButton)localObject1).setChecked(mItemData.isChecked());
        if (!paramBoolean) {
          break label133;
        }
      }
      for (int i = 0;; i = 8)
      {
        if (((CompoundButton)localObject1).getVisibility() != i) {
          ((CompoundButton)localObject1).setVisibility(i);
        }
        if ((localObject2 == null) || (((CompoundButton)localObject2).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject2).setVisibility(8);
        return;
        if (mCheckBox == null) {
          insertCheckBox();
        }
        localObject1 = mCheckBox;
        localObject2 = mRadioButton;
        break label51;
      }
      if (mCheckBox != null) {
        mCheckBox.setVisibility(8);
      }
    } while (mRadioButton == null);
    mRadioButton.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (mItemData.isExclusiveCheckable()) {
      if (mRadioButton == null) {
        insertRadioButton();
      }
    }
    for (Object localObject = mRadioButton;; localObject = mCheckBox)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (mCheckBox == null) {
        insertCheckBox();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    mForceShowIcon = paramBoolean;
    mPreserveIconSpacing = paramBoolean;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if ((mItemData.mMenu.mOptionalIconsVisible) || (mForceShowIcon))
    {
      i = 1;
      if ((i != 0) || (mPreserveIconSpacing)) {
        break label39;
      }
    }
    label39:
    while ((mIconView == null) && (paramDrawable == null) && (!mPreserveIconSpacing))
    {
      return;
      i = 0;
      break;
    }
    if (mIconView == null)
    {
      mIconView = ((ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false));
      addView(mIconView, 0);
    }
    if ((paramDrawable != null) || (mPreserveIconSpacing))
    {
      ImageView localImageView = mIconView;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (mIconView.getVisibility() == 0) {
          break;
        }
        mIconView.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    mIconView.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      mTitleView.setText(paramCharSequence);
      if (mTitleView.getVisibility() != 0) {
        mTitleView.setVisibility(0);
      }
    }
    while (mTitleView.getVisibility() == 8) {
      return;
    }
    mTitleView.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */