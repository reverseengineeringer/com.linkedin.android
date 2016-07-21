package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.View;

class HeaderBehavior$FlingRunnable
  implements Runnable
{
  private final V mLayout;
  private final CoordinatorLayout mParent;
  
  HeaderBehavior$FlingRunnable(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    mParent = paramV;
    View localView;
    mLayout = localView;
  }
  
  public void run()
  {
    if ((mLayout != null) && (HeaderBehavior.access$000(this$0) != null))
    {
      if (HeaderBehavior.access$000(this$0).computeScrollOffset())
      {
        this$0.setHeaderTopBottomOffset(mParent, mLayout, HeaderBehavior.access$000(this$0).getCurrY());
        ViewCompat.postOnAnimation(mLayout, this);
      }
    }
    else {
      return;
    }
    this$0.onFlingFinished(mParent, mLayout);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.HeaderBehavior.FlingRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */