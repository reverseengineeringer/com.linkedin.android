package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;

final class AppCompatBackgroundHelper
{
  private TintInfo mBackgroundTint;
  private final AppCompatDrawableManager mDrawableManager;
  private TintInfo mInternalBackgroundTint;
  private TintInfo mTmpInfo;
  private final View mView;
  
  AppCompatBackgroundHelper(View paramView, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    mView = paramView;
    mDrawableManager = paramAppCompatDrawableManager;
  }
  
  final void applySupportBackgroundTint()
  {
    int i = 0;
    Drawable localDrawable = mView.getBackground();
    if (localDrawable != null)
    {
      if (Build.VERSION.SDK_INT != 21) {
        break label148;
      }
      if (mTmpInfo == null) {
        mTmpInfo = new TintInfo();
      }
      TintInfo localTintInfo = mTmpInfo;
      mTintList = null;
      mHasTintList = false;
      mTintMode = null;
      mHasTintMode = false;
      Object localObject = ViewCompat.getBackgroundTintList(mView);
      if (localObject != null)
      {
        mHasTintList = true;
        mTintList = ((ColorStateList)localObject);
      }
      localObject = ViewCompat.getBackgroundTintMode(mView);
      if (localObject != null)
      {
        mHasTintMode = true;
        mTintMode = ((PorterDuff.Mode)localObject);
      }
      if ((mHasTintList) || (mHasTintMode))
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, mView.getDrawableState());
        i = 1;
      }
      if (i == 0) {
        break label148;
      }
    }
    label148:
    do
    {
      return;
      if (mBackgroundTint != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, mBackgroundTint, mView.getDrawableState());
        return;
      }
    } while (mInternalBackgroundTint == null);
    AppCompatDrawableManager.tintDrawable(localDrawable, mInternalBackgroundTint, mView.getDrawableState());
  }
  
  final ColorStateList getSupportBackgroundTintList()
  {
    if (mBackgroundTint != null) {
      return mBackgroundTint.mTintList;
    }
    return null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (mBackgroundTint != null) {
      return mBackgroundTint.mTintMode;
    }
    return null;
  }
  
  final void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = mView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_android_background))
      {
        ColorStateList localColorStateList = mDrawableManager.getTintList(mView.getContext(), paramAttributeSet.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1));
        if (localColorStateList != null) {
          setInternalBackgroundTint(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
        ViewCompat.setBackgroundTintList(mView, paramAttributeSet.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
        ViewCompat.setBackgroundTintMode(mView, DrawableUtils.parseTintMode$49602678(paramAttributeSet.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1)));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final void onSetBackgroundResource(int paramInt)
  {
    if (mDrawableManager != null) {}
    for (ColorStateList localColorStateList = mDrawableManager.getTintList(mView.getContext(), paramInt);; localColorStateList = null)
    {
      setInternalBackgroundTint(localColorStateList);
      return;
    }
  }
  
  final void setInternalBackgroundTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (mInternalBackgroundTint == null) {
        mInternalBackgroundTint = new TintInfo();
      }
      mInternalBackgroundTint.mTintList = paramColorStateList;
      mInternalBackgroundTint.mHasTintList = true;
    }
    for (;;)
    {
      applySupportBackgroundTint();
      return;
      mInternalBackgroundTint = null;
    }
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new TintInfo();
    }
    mBackgroundTint.mTintList = paramColorStateList;
    mBackgroundTint.mHasTintList = true;
    applySupportBackgroundTint();
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new TintInfo();
    }
    mBackgroundTint.mTintMode = paramMode;
    mBackgroundTint.mHasTintMode = true;
    applySupportBackgroundTint();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatBackgroundHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */