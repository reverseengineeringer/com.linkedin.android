package android.support.design.widget;

import android.view.animation.Animation;

class FloatingActionButtonEclairMr1$2
  extends AnimationUtils.AnimationListenerAdapter
{
  FloatingActionButtonEclairMr1$2(FloatingActionButtonEclairMr1 paramFloatingActionButtonEclairMr1, FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (val$listener != null) {
      val$listener.onShown();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonEclairMr1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */