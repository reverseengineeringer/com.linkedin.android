package android.support.design.widget;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class CoordinatorLayout$ApplyInsetsListener
  implements OnApplyWindowInsetsListener
{
  private CoordinatorLayout$ApplyInsetsListener(CoordinatorLayout paramCoordinatorLayout) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return CoordinatorLayout.access$200(this$0, paramWindowInsetsCompat);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.ApplyInsetsListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */