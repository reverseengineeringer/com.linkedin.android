package com.linkedin.android.feed.endor.ui.update.single;

import android.support.v7.widget.CardView;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;

public class FeedSingleUpdateViewHolder$$ViewInjector<T extends FeedSingleUpdateViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    cardView = ((CardView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755747, "field 'cardView'"), 2131755747, "field 'cardView'"));
    componentsView = ((FeedComponentsView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755821, "field 'componentsView'"), 2131755821, "field 'componentsView'"));
  }
  
  public void reset(T paramT)
  {
    cardView = null;
    componentsView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */