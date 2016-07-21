package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.R.anim;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class FloatingActionButtonEclairMr1
  extends FloatingActionButtonImpl
{
  private int mAnimationDuration;
  private boolean mIsHiding;
  ShadowDrawableWrapper mShadowDrawable;
  private StateListAnimator mStateListAnimator;
  
  FloatingActionButtonEclairMr1(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate);
    mAnimationDuration = paramVisibilityAwareImageButton.getResources().getInteger(17694720);
    mStateListAnimator = new StateListAnimator();
    mStateListAnimator.setTarget(paramVisibilityAwareImageButton);
    mStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, setupAnimation(new ElevateToTranslationZAnimation(null)));
    mStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, setupAnimation(new ElevateToTranslationZAnimation(null)));
    mStateListAnimator.addState(EMPTY_STATE_SET, setupAnimation(new ResetElevationAnimation(null)));
  }
  
  private static ColorStateList createColorStateList(int paramInt)
  {
    return new ColorStateList(new int[][] { FOCUSED_ENABLED_STATE_SET, PRESSED_ENABLED_STATE_SET, new int[0] }, new int[] { paramInt, paramInt, 0 });
  }
  
  private Animation setupAnimation(Animation paramAnimation)
  {
    paramAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    paramAnimation.setDuration(mAnimationDuration);
    return paramAnimation;
  }
  
  float getElevation()
  {
    return mElevation;
  }
  
  void getPadding(Rect paramRect)
  {
    mShadowDrawable.getPadding(paramRect);
  }
  
  void hide(final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if ((mIsHiding) || (mView.getVisibility() != 0))
    {
      if (paramInternalVisibilityChangedListener != null) {
        paramInternalVisibilityChangedListener.onHidden();
      }
      return;
    }
    Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.design_fab_out);
    localAnimation.setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new AnimationUtils.AnimationListenerAdapter()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        FloatingActionButtonEclairMr1.access$202(FloatingActionButtonEclairMr1.this, false);
        mView.internalSetVisibility(8, paramBoolean);
        if (paramInternalVisibilityChangedListener != null) {
          paramInternalVisibilityChangedListener.onHidden();
        }
      }
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        FloatingActionButtonEclairMr1.access$202(FloatingActionButtonEclairMr1.this, true);
      }
    });
    mView.startAnimation(localAnimation);
  }
  
  void jumpDrawableToCurrentState()
  {
    mStateListAnimator.jumpToCurrentState();
  }
  
  void onCompatShadowChanged() {}
  
  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    mStateListAnimator.setState(paramArrayOfInt);
  }
  
  void onElevationChanged(float paramFloat)
  {
    if (mShadowDrawable != null)
    {
      mShadowDrawable.setShadowSize(paramFloat, mPressedTranslationZ + paramFloat);
      updatePadding();
    }
  }
  
  void onTranslationZChanged(float paramFloat)
  {
    if (mShadowDrawable != null)
    {
      mShadowDrawable.setMaxShadowSize(mElevation + paramFloat);
      updatePadding();
    }
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    mShapeDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(mShapeDrawable, paramColorStateList);
    if (paramMode != null) {
      DrawableCompat.setTintMode(mShapeDrawable, paramMode);
    }
    mRippleDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(mRippleDrawable, createColorStateList(paramInt1));
    if (paramInt2 > 0)
    {
      mBorderDrawable = createBorderDrawable(paramInt2, paramColorStateList);
      paramColorStateList = new Drawable[3];
      paramColorStateList[0] = mBorderDrawable;
      paramColorStateList[1] = mShapeDrawable;
      paramColorStateList[2] = mRippleDrawable;
    }
    for (;;)
    {
      mContentBackground = new LayerDrawable(paramColorStateList);
      mShadowDrawable = new ShadowDrawableWrapper(mView.getResources(), mContentBackground, mShadowViewDelegate.getRadius(), mElevation, mElevation + mPressedTranslationZ);
      mShadowDrawable.setAddPaddingForCorners(false);
      mShadowViewDelegate.setBackgroundDrawable(mShadowDrawable);
      return;
      mBorderDrawable = null;
      paramColorStateList = new Drawable[2];
      paramColorStateList[0] = mShapeDrawable;
      paramColorStateList[1] = mRippleDrawable;
    }
  }
  
  void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mShapeDrawable != null) {
      DrawableCompat.setTintList(mShapeDrawable, paramColorStateList);
    }
    if (mBorderDrawable != null) {
      mBorderDrawable.setBorderTint(paramColorStateList);
    }
  }
  
  void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mShapeDrawable != null) {
      DrawableCompat.setTintMode(mShapeDrawable, paramMode);
    }
  }
  
  void setRippleColor(int paramInt)
  {
    if (mRippleDrawable != null) {
      DrawableCompat.setTintList(mRippleDrawable, createColorStateList(paramInt));
    }
  }
  
  void show(final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if ((mView.getVisibility() != 0) || (mIsHiding))
    {
      mView.clearAnimation();
      mView.internalSetVisibility(0, paramBoolean);
      localAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.design_fab_in);
      localAnimation.setDuration(200L);
      localAnimation.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
      localAnimation.setAnimationListener(new AnimationUtils.AnimationListenerAdapter()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (paramInternalVisibilityChangedListener != null) {
            paramInternalVisibilityChangedListener.onShown();
          }
        }
      });
      mView.startAnimation(localAnimation);
    }
    while (paramInternalVisibilityChangedListener == null)
    {
      Animation localAnimation;
      return;
    }
    paramInternalVisibilityChangedListener.onShown();
  }
  
  private abstract class BaseShadowAnimation
    extends Animation
  {
    private float mShadowSizeDiff;
    private float mShadowSizeStart;
    
    private BaseShadowAnimation() {}
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      mShadowDrawable.setShadowSize(mShadowSizeStart + mShadowSizeDiff * paramFloat);
    }
    
    protected abstract float getTargetShadowSize();
    
    public void reset()
    {
      super.reset();
      mShadowSizeStart = mShadowDrawable.getShadowSize();
      mShadowSizeDiff = (getTargetShadowSize() - mShadowSizeStart);
    }
  }
  
  private class ElevateToTranslationZAnimation
    extends FloatingActionButtonEclairMr1.BaseShadowAnimation
  {
    private ElevateToTranslationZAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return mElevation + mPressedTranslationZ;
    }
  }
  
  private class ResetElevationAnimation
    extends FloatingActionButtonEclairMr1.BaseShadowAnimation
  {
    private ResetElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return mElevation;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonEclairMr1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */