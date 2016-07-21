package com.linkedin.android.feed.page.feed;

import android.support.design.widget.EfficientCoordinatorLayout;
import com.linkedin.android.feed.utils.FeedShareHeaderManager;
import com.linkedin.android.feed.utils.animations.FeedAnimationHelper.FeedAnimationListener;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;

final class FeedFragment$FeedLoadingAnimationListener
  implements FeedAnimationHelper.FeedAnimationListener
{
  private FeedFragment$FeedLoadingAnimationListener(FeedFragment paramFeedFragment) {}
  
  public final void onAnimateRecyclerViewUpDone()
  {
    this$0.applicationComponent.flagshipSharedPreferences().setShowCustomizingYourFeedView(false);
    FeedFragment.access$702$571b359f(this$0);
  }
  
  public final void onDismissLoadingViewDone()
  {
    if ((this$0.updatesContainer != null) && (FeedFragment.access$2500(this$0) != null))
    {
      this$0.updatesContainer.removeView(FeedFragment.access$2500(this$0));
      FeedFragment.access$2502$5587b863(this$0);
      FeedFragment.access$800(this$0).setShareActionsVisibility(true, true);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.FeedLoadingAnimationListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */