package android.support.design.widget;

import android.view.animation.Animation;

class StateListAnimator$Tuple
{
  final Animation mAnimation;
  final int[] mSpecs;
  
  private StateListAnimator$Tuple(int[] paramArrayOfInt, Animation paramAnimation)
  {
    mSpecs = paramArrayOfInt;
    mAnimation = paramAnimation;
  }
  
  Animation getAnimation()
  {
    return mAnimation;
  }
  
  int[] getSpecs()
  {
    return mSpecs;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.StateListAnimator.Tuple
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */