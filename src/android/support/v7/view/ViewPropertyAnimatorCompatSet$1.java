package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import java.util.ArrayList;

final class ViewPropertyAnimatorCompatSet$1
  extends ViewPropertyAnimatorListenerAdapter
{
  private int mProxyEndCount = 0;
  private boolean mProxyStarted = false;
  
  ViewPropertyAnimatorCompatSet$1(ViewPropertyAnimatorCompatSet paramViewPropertyAnimatorCompatSet) {}
  
  public final void onAnimationEnd(View paramView)
  {
    int i = mProxyEndCount + 1;
    mProxyEndCount = i;
    if (i == this$0.mAnimators.size())
    {
      if (this$0.mListener != null) {
        this$0.mListener.onAnimationEnd(null);
      }
      mProxyEndCount = 0;
      mProxyStarted = false;
      this$0.mIsStarted = false;
    }
  }
  
  public final void onAnimationStart(View paramView)
  {
    if (mProxyStarted) {}
    do
    {
      return;
      mProxyStarted = true;
    } while (this$0.mListener == null);
    this$0.mListener.onAnimationStart(null);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.ViewPropertyAnimatorCompatSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */