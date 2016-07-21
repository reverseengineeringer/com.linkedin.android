package android.support.design.widget;

class FloatingActionButtonEclairMr1$ElevateToTranslationZAnimation
  extends FloatingActionButtonEclairMr1.BaseShadowAnimation
{
  private FloatingActionButtonEclairMr1$ElevateToTranslationZAnimation(FloatingActionButtonEclairMr1 paramFloatingActionButtonEclairMr1)
  {
    super(paramFloatingActionButtonEclairMr1, null);
  }
  
  protected float getTargetShadowSize()
  {
    return this$0.mElevation + this$0.mPressedTranslationZ;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonEclairMr1.ElevateToTranslationZAnimation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */