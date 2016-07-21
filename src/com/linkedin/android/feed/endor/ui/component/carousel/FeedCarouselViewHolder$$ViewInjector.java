package com.linkedin.android.feed.endor.ui.component.carousel;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedCarouselViewHolder$$ViewInjector<T extends FeedCarouselViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    carousel = ((FeedCarouselRecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755613, "field 'carousel'"), 2131755613, "field 'carousel'"));
  }
  
  public void reset(T paramT)
  {
    carousel = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */