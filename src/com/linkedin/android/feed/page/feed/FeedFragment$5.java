package com.linkedin.android.feed.page.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher.PendingSlideShareUpload;
import java.util.Map;

final class FeedFragment$5
  implements View.OnClickListener
{
  FeedFragment$5(FeedFragment paramFeedFragment, FeedSharePublisher.PendingSlideShareUpload paramPendingSlideShareUpload, Map paramMap) {}
  
  public final void onClick(View paramView)
  {
    this$0.fragmentComponent.sharePublisher().publishSlideShare(val$failedSlideShareUpload, val$trackingHeader);
    FeedFragment.access$1200(this$0);
    FeedFragment.access$1300(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */