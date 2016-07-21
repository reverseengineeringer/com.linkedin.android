package android.support.design.internal;

import android.graphics.Rect;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

final class ScrimInsetsFrameLayout$1
  implements OnApplyWindowInsetsListener
{
  ScrimInsetsFrameLayout$1(ScrimInsetsFrameLayout paramScrimInsetsFrameLayout) {}
  
  public final WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (ScrimInsetsFrameLayout.access$000(this$0) == null) {
      ScrimInsetsFrameLayout.access$002(this$0, new Rect());
    }
    ScrimInsetsFrameLayout.access$000(this$0).set(paramWindowInsetsCompat.getSystemWindowInsetLeft(), paramWindowInsetsCompat.getSystemWindowInsetTop(), paramWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.getSystemWindowInsetBottom());
    this$0.onInsetsChanged(ScrimInsetsFrameLayout.access$000(this$0));
    paramView = this$0;
    if ((ScrimInsetsFrameLayout.access$000(this$0).isEmpty()) || (ScrimInsetsFrameLayout.access$100(this$0) == null)) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setWillNotDraw(bool);
      ViewCompat.postInvalidateOnAnimation(this$0);
      return paramWindowInsetsCompat.consumeSystemWindowInsets();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */