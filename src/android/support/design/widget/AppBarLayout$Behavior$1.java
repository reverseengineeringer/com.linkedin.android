package android.support.design.widget;

class AppBarLayout$Behavior$1
  implements ValueAnimatorCompat.AnimatorUpdateListener
{
  AppBarLayout$Behavior$1(AppBarLayout.Behavior paramBehavior, CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout) {}
  
  public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    this$0.setHeaderTopBottomOffset(val$coordinatorLayout, val$child, paramValueAnimatorCompat.getAnimatedIntValue());
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.AppBarLayout.Behavior.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */