package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class AppCompatCompoundButtonHelper
{
  ColorStateList mButtonTintList = null;
  PorterDuff.Mode mButtonTintMode = null;
  private final AppCompatDrawableManager mDrawableManager;
  private boolean mHasButtonTint = false;
  private boolean mHasButtonTintMode = false;
  private boolean mSkipNextApply;
  private final CompoundButton mView;
  
  AppCompatCompoundButtonHelper(CompoundButton paramCompoundButton, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    mView = paramCompoundButton;
    mDrawableManager = paramAppCompatDrawableManager;
  }
  
  private void applyButtonTint()
  {
    Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(mView);
    if ((localDrawable != null) && ((mHasButtonTint) || (mHasButtonTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      if (mHasButtonTint) {
        DrawableCompat.setTintList(localDrawable, mButtonTintList);
      }
      if (mHasButtonTintMode) {
        DrawableCompat.setTintMode(localDrawable, mButtonTintMode);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(mView.getDrawableState());
      }
      mView.setButtonDrawable(localDrawable);
    }
  }
  
  final int getCompoundPaddingLeft(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(mView);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = mView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(R.styleable.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          mView.setButtonDrawable(mDrawableManager.getDrawable(mView.getContext(), paramInt, false));
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTint)) {
        CompoundButtonCompat.setButtonTintList(mView, paramAttributeSet.getColorStateList(R.styleable.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
        CompoundButtonCompat.setButtonTintMode(mView, DrawableUtils.parseTintMode$49602678(paramAttributeSet.getInt(R.styleable.CompoundButton_buttonTintMode, -1)));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final void onSetButtonDrawable()
  {
    if (mSkipNextApply)
    {
      mSkipNextApply = false;
      return;
    }
    mSkipNextApply = true;
    applyButtonTint();
  }
  
  final void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    mButtonTintList = paramColorStateList;
    mHasButtonTint = true;
    applyButtonTint();
  }
  
  final void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    mButtonTintMode = paramMode;
    mHasButtonTintMode = true;
    applyButtonTint();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatCompoundButtonHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */