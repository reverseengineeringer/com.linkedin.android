package com.linkedin.android.feed.endor.ui.component.carousel;

import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.infra.components.FragmentComponent;
import java.util.List;

public final class FeedCarouselViewTransformer
{
  public static FeedCarouselViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List<FeedCarouselComponentViewModel> paramList)
  {
    return new FeedCarouselViewModel(paramFragmentComponent, new FeedCarouselLayout(), paramFeedComponentsViewPool, paramList);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */