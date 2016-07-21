package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.view.LayoutInflater;
import android.view.View;

public final class TabLayout$Tab
{
  public static final int INVALID_POSITION = -1;
  private CharSequence mContentDesc;
  private View mCustomView;
  private Drawable mIcon;
  private TabLayout mParent;
  private int mPosition = -1;
  private Object mTag;
  private CharSequence mText;
  private TabLayout.TabView mView;
  
  private void reset()
  {
    mParent = null;
    mView = null;
    mTag = null;
    mIcon = null;
    mText = null;
    mContentDesc = null;
    mPosition = -1;
    mCustomView = null;
  }
  
  private void updateView()
  {
    if (mView != null) {
      mView.update();
    }
  }
  
  public final CharSequence getContentDescription()
  {
    return mContentDesc;
  }
  
  public final View getCustomView()
  {
    return mCustomView;
  }
  
  public final Drawable getIcon()
  {
    return mIcon;
  }
  
  public final int getPosition()
  {
    return mPosition;
  }
  
  public final Object getTag()
  {
    return mTag;
  }
  
  public final CharSequence getText()
  {
    return mText;
  }
  
  public final boolean isSelected()
  {
    if (mParent == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return mParent.getSelectedTabPosition() == mPosition;
  }
  
  public final void select()
  {
    if (mParent == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    mParent.selectTab(this);
  }
  
  public final Tab setContentDescription(int paramInt)
  {
    if (mParent == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return setContentDescription(mParent.getResources().getText(paramInt));
  }
  
  public final Tab setContentDescription(CharSequence paramCharSequence)
  {
    mContentDesc = paramCharSequence;
    updateView();
    return this;
  }
  
  public final Tab setCustomView(int paramInt)
  {
    return setCustomView(LayoutInflater.from(mView.getContext()).inflate(paramInt, mView, false));
  }
  
  public final Tab setCustomView(View paramView)
  {
    mCustomView = paramView;
    updateView();
    return this;
  }
  
  public final Tab setIcon(int paramInt)
  {
    if (mParent == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return setIcon(AppCompatDrawableManager.get().getDrawable(mParent.getContext(), paramInt, false));
  }
  
  public final Tab setIcon(Drawable paramDrawable)
  {
    mIcon = paramDrawable;
    updateView();
    return this;
  }
  
  final void setPosition(int paramInt)
  {
    mPosition = paramInt;
  }
  
  public final Tab setTag(Object paramObject)
  {
    mTag = paramObject;
    return this;
  }
  
  public final Tab setText(int paramInt)
  {
    if (mParent == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return setText(mParent.getResources().getText(paramInt));
  }
  
  public final Tab setText(CharSequence paramCharSequence)
  {
    mText = paramCharSequence;
    updateView();
    return this;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TabLayout.Tab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */