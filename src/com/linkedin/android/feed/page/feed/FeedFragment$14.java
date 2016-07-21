package com.linkedin.android.feed.page.feed;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.Callback;
import com.linkedin.android.axle.rta.RateTheApp;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import java.util.Map;

final class FeedFragment$14
  extends Snackbar.Callback
{
  FeedFragment$14(FeedFragment paramFeedFragment) {}
  
  public final void onDismissed(Snackbar paramSnackbar, int paramInt)
  {
    FeedFragment.access$1702$1bf405df(this$0);
    if ((FeedFragment.access$1800(this$0).isEmpty()) && (this$0.rateTheApp.rtaToDisplay))
    {
      this$0.rateTheApp.rtaToDisplay = false;
      this$0.rateTheApp.showRTA(this$0.fragmentComponent);
    }
    FeedFragment.access$1300(this$0);
  }
  
  public final void onShown(Snackbar paramSnackbar)
  {
    if (this$0.rateTheApp.rtaDisplayed)
    {
      paramSnackbar = this$0.rateTheApp;
      FragmentComponent localFragmentComponent = this$0.fragmentComponent;
      if (container != null) {
        container.removeView(rtaFrameView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */