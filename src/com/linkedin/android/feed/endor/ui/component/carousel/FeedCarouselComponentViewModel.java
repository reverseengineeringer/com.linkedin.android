package com.linkedin.android.feed.endor.ui.component.carousel;

import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;

public abstract class FeedCarouselComponentViewModel<VIEW_HOLDER extends BaseFeedViewHolder, LAYOUT extends FeedComponentLayout<VIEW_HOLDER>>
  extends FeedComponentViewModel<VIEW_HOLDER, LAYOUT>
{
  public int verticalPos = -1;
  
  public FeedCarouselComponentViewModel(LAYOUT paramLAYOUT)
  {
    super(paramLAYOUT);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselComponentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */