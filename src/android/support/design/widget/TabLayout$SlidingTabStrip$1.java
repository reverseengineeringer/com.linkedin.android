package android.support.design.widget;

class TabLayout$SlidingTabStrip$1
  implements ValueAnimatorCompat.AnimatorUpdateListener
{
  TabLayout$SlidingTabStrip$1(TabLayout.SlidingTabStrip paramSlidingTabStrip, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    float f = paramValueAnimatorCompat.getAnimatedFraction();
    TabLayout.SlidingTabStrip.access$2400(this$1, AnimationUtils.lerp(val$startLeft, val$targetLeft, f), AnimationUtils.lerp(val$startRight, val$targetRight, f));
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TabLayout.SlidingTabStrip.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */