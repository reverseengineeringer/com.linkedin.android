package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
class FloatingActionButtonLollipop
  extends FloatingActionButtonIcs
{
  private InsetDrawable mInsetDrawable;
  private final Interpolator mInterpolator;
  
  FloatingActionButtonLollipop(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate);
    if (paramVisibilityAwareImageButton.isInEditMode()) {}
    for (paramVisibilityAwareImageButton = null;; paramVisibilityAwareImageButton = AnimationUtils.loadInterpolator(mView.getContext(), 17563661))
    {
      mInterpolator = paramVisibilityAwareImageButton;
      return;
    }
  }
  
  private Animator setupAnimator(Animator paramAnimator)
  {
    paramAnimator.setInterpolator(mInterpolator);
    return paramAnimator;
  }
  
  public float getElevation()
  {
    return mView.getElevation();
  }
  
  void getPadding(Rect paramRect)
  {
    if (mShadowViewDelegate.isCompatPaddingEnabled())
    {
      float f1 = mShadowViewDelegate.getRadius();
      float f2 = getElevation() + mPressedTranslationZ;
      int i = (int)Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(f2, f1, false));
      int j = (int)Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  void jumpDrawableToCurrentState() {}
  
  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawableLollipop();
  }
  
  void onCompatShadowChanged()
  {
    updatePadding();
  }
  
  void onDrawableStateChanged(int[] paramArrayOfInt) {}
  
  public void onElevationChanged(float paramFloat)
  {
    mView.setElevation(paramFloat);
    if (mShadowViewDelegate.isCompatPaddingEnabled()) {
      updatePadding();
    }
  }
  
  void onPaddingUpdated(Rect paramRect)
  {
    if (mShadowViewDelegate.isCompatPaddingEnabled())
    {
      mInsetDrawable = new InsetDrawable(mRippleDrawable, left, top, right, bottom);
      mShadowViewDelegate.setBackgroundDrawable(mInsetDrawable);
      return;
    }
    mShadowViewDelegate.setBackgroundDrawable(mRippleDrawable);
  }
  
  void onTranslationZChanged(float paramFloat)
  {
    StateListAnimator localStateListAnimator = new StateListAnimator();
    localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(mView, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(mView, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(EMPTY_STATE_SET, setupAnimator(ObjectAnimator.ofFloat(mView, "translationZ", new float[] { 0.0F })));
    mView.setStateListAnimator(localStateListAnimator);
    if (mShadowViewDelegate.isCompatPaddingEnabled()) {
      updatePadding();
    }
  }
  
  boolean requirePreDrawListener()
  {
    return false;
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    mShapeDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(mShapeDrawable, paramColorStateList);
    if (paramMode != null) {
      DrawableCompat.setTintMode(mShapeDrawable, paramMode);
    }
    if (paramInt2 > 0) {
      mBorderDrawable = createBorderDrawable(paramInt2, paramColorStateList);
    }
    for (paramColorStateList = new LayerDrawable(new Drawable[] { mBorderDrawable, mShapeDrawable });; paramColorStateList = mShapeDrawable)
    {
      mRippleDrawable = new RippleDrawable(ColorStateList.valueOf(paramInt1), paramColorStateList, null);
      mContentBackground = mRippleDrawable;
      mShadowViewDelegate.setBackgroundDrawable(mRippleDrawable);
      return;
      mBorderDrawable = null;
    }
  }
  
  void setRippleColor(int paramInt)
  {
    if ((mRippleDrawable instanceof RippleDrawable))
    {
      ((RippleDrawable)mRippleDrawable).setColor(ColorStateList.valueOf(paramInt));
      return;
    }
    super.setRippleColor(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonLollipop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */