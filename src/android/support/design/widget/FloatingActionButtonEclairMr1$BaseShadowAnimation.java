package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

abstract class FloatingActionButtonEclairMr1$BaseShadowAnimation
  extends Animation
{
  private float mShadowSizeDiff;
  private float mShadowSizeStart;
  
  private FloatingActionButtonEclairMr1$BaseShadowAnimation(FloatingActionButtonEclairMr1 paramFloatingActionButtonEclairMr1) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this$0.mShadowDrawable.setShadowSize(mShadowSizeStart + mShadowSizeDiff * paramFloat);
  }
  
  protected abstract float getTargetShadowSize();
  
  public void reset()
  {
    super.reset();
    mShadowSizeStart = this$0.mShadowDrawable.getShadowSize();
    mShadowSizeDiff = (getTargetShadowSize() - mShadowSizeStart);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonEclairMr1.BaseShadowAnimation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */