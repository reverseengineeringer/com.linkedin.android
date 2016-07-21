package android.support.v4.view;

import android.view.View;

final class ViewCompatHC
{
  static void offsetLeftAndRight(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    tickleInvalidationFlag(paramView);
    paramView = paramView.getParent();
    if ((paramView instanceof View)) {
      tickleInvalidationFlag((View)paramView);
    }
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    tickleInvalidationFlag(paramView);
    paramView = paramView.getParent();
    if ((paramView instanceof View)) {
      tickleInvalidationFlag((View)paramView);
    }
  }
  
  private static void tickleInvalidationFlag(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompatHC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */