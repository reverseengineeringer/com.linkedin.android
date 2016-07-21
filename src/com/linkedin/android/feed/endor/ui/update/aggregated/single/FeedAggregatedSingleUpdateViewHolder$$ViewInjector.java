package com.linkedin.android.feed.endor.ui.update.aggregated.single;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;

public class FeedAggregatedSingleUpdateViewHolder$$ViewInjector<T extends FeedAggregatedSingleUpdateViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    cardInterior = ((FeedComponentsView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755820, "field 'cardInterior'"), 2131755820, "field 'cardInterior'"));
  }
  
  public void reset(T paramT)
  {
    cardInterior = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedSingleUpdateViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */