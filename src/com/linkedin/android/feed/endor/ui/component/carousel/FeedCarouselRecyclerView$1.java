package com.linkedin.android.feed.endor.ui.component.carousel;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.linkedin.android.infra.shared.JellyBeanUtils;

final class FeedCarouselRecyclerView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FeedCarouselRecyclerView$1(FeedCarouselRecyclerView paramFeedCarouselRecyclerView) {}
  
  public final void onGlobalLayout()
  {
    JellyBeanUtils.removeOnGlobalLayoutListener(this$0.getViewTreeObserver(), this);
    if ((FeedCarouselRecyclerView.access$200(this$0) >= 0) && (FeedCarouselRecyclerView.access$200(this$0) < FeedCarouselRecyclerView.access$300(this$0).getItemCount())) {
      FeedCarouselRecyclerView.access$500(this$0, FeedCarouselRecyclerView.access$400(this$0), FeedCarouselRecyclerView.access$200(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselRecyclerView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */