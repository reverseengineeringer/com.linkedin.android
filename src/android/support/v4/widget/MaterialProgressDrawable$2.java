package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class MaterialProgressDrawable$2
  implements Animation.AnimationListener
{
  MaterialProgressDrawable$2(MaterialProgressDrawable paramMaterialProgressDrawable, MaterialProgressDrawable.Ring paramRing) {}
  
  public final void onAnimationEnd(Animation paramAnimation) {}
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    val$ring.storeOriginals();
    MaterialProgressDrawable.Ring localRing = val$ring;
    localRing.setColorIndex(localRing.getNextColorIndex());
    val$ring.setStartTrim(val$ring.mEndTrim);
    if (this$0.mFinishing)
    {
      this$0.mFinishing = false;
      paramAnimation.setDuration(1332L);
      val$ring.setShowArrow(false);
      return;
    }
    MaterialProgressDrawable.access$402(this$0, (MaterialProgressDrawable.access$400(this$0) + 1.0F) % 5.0F);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    MaterialProgressDrawable.access$402(this$0, 0.0F);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */