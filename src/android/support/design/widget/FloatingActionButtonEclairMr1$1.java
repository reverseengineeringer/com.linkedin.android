package android.support.design.widget;

import android.view.animation.Animation;

class FloatingActionButtonEclairMr1$1
  extends AnimationUtils.AnimationListenerAdapter
{
  FloatingActionButtonEclairMr1$1(FloatingActionButtonEclairMr1 paramFloatingActionButtonEclairMr1, boolean paramBoolean, FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FloatingActionButtonEclairMr1.access$202(this$0, false);
    this$0.mView.internalSetVisibility(8, val$fromUser);
    if (val$listener != null) {
      val$listener.onHidden();
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    FloatingActionButtonEclairMr1.access$202(this$0, true);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonEclairMr1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */