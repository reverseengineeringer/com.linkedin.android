package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.R.color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class FloatingActionButtonImpl
{
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] FOCUSED_ENABLED_STATE_SET;
  static final int[] PRESSED_ENABLED_STATE_SET = { 16842919, 16842910 };
  static final int SHOW_HIDE_ANIM_DURATION = 200;
  CircularBorderDrawable mBorderDrawable;
  Drawable mContentBackground;
  float mElevation;
  private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
  float mPressedTranslationZ;
  Drawable mRippleDrawable;
  final ShadowViewDelegate mShadowViewDelegate;
  Drawable mShapeDrawable;
  private final Rect mTmpRect = new Rect();
  final VisibilityAwareImageButton mView;
  
  static
  {
    FOCUSED_ENABLED_STATE_SET = new int[] { 16842908, 16842910 };
  }
  
  FloatingActionButtonImpl(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    mView = paramVisibilityAwareImageButton;
    mShadowViewDelegate = paramShadowViewDelegate;
  }
  
  private void ensurePreDrawListener()
  {
    if (mPreDrawListener == null) {
      mPreDrawListener = new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          onPreDraw();
          return true;
        }
      };
    }
  }
  
  CircularBorderDrawable createBorderDrawable(int paramInt, ColorStateList paramColorStateList)
  {
    Resources localResources = mView.getResources();
    CircularBorderDrawable localCircularBorderDrawable = newCircularDrawable();
    localCircularBorderDrawable.setGradientColors(localResources.getColor(R.color.design_fab_stroke_top_outer_color), localResources.getColor(R.color.design_fab_stroke_top_inner_color), localResources.getColor(R.color.design_fab_stroke_end_inner_color), localResources.getColor(R.color.design_fab_stroke_end_outer_color));
    localCircularBorderDrawable.setBorderWidth(paramInt);
    localCircularBorderDrawable.setBorderTint(paramColorStateList);
    return localCircularBorderDrawable;
  }
  
  GradientDrawable createShapeDrawable()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  final Drawable getContentBackground()
  {
    return mContentBackground;
  }
  
  abstract float getElevation();
  
  abstract void getPadding(Rect paramRect);
  
  abstract void hide(InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean);
  
  abstract void jumpDrawableToCurrentState();
  
  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawable();
  }
  
  void onAttachedToWindow()
  {
    if (requirePreDrawListener())
    {
      ensurePreDrawListener();
      mView.getViewTreeObserver().addOnPreDrawListener(mPreDrawListener);
    }
  }
  
  abstract void onCompatShadowChanged();
  
  void onDetachedFromWindow()
  {
    if (mPreDrawListener != null)
    {
      mView.getViewTreeObserver().removeOnPreDrawListener(mPreDrawListener);
      mPreDrawListener = null;
    }
  }
  
  abstract void onDrawableStateChanged(int[] paramArrayOfInt);
  
  abstract void onElevationChanged(float paramFloat);
  
  void onPaddingUpdated(Rect paramRect) {}
  
  void onPreDraw() {}
  
  abstract void onTranslationZChanged(float paramFloat);
  
  boolean requirePreDrawListener()
  {
    return false;
  }
  
  abstract void setBackgroundDrawable(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2);
  
  abstract void setBackgroundTintList(ColorStateList paramColorStateList);
  
  abstract void setBackgroundTintMode(PorterDuff.Mode paramMode);
  
  final void setElevation(float paramFloat)
  {
    if (mElevation != paramFloat)
    {
      mElevation = paramFloat;
      onElevationChanged(paramFloat);
    }
  }
  
  final void setPressedTranslationZ(float paramFloat)
  {
    if (mPressedTranslationZ != paramFloat)
    {
      mPressedTranslationZ = paramFloat;
      onTranslationZChanged(paramFloat);
    }
  }
  
  abstract void setRippleColor(int paramInt);
  
  abstract void show(InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean);
  
  final void updatePadding()
  {
    Rect localRect = mTmpRect;
    getPadding(localRect);
    onPaddingUpdated(localRect);
    mShadowViewDelegate.setShadowPadding(left, top, right, bottom);
  }
  
  static abstract interface InternalVisibilityChangedListener
  {
    public abstract void onHidden();
    
    public abstract void onShown();
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */