package android.support.design.widget;

class TabLayout$1
  implements ValueAnimatorCompat.AnimatorUpdateListener
{
  TabLayout$1(TabLayout paramTabLayout) {}
  
  public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    this$0.scrollTo(paramValueAnimatorCompat.getAnimatedIntValue(), 0);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TabLayout.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */