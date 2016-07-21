package com.linkedin.android.feed.endor.ui.component.componentlist;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;

public class FeedComponentListViewHolder$$ViewInjector<T extends FeedComponentListViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    componentsView = ((FeedComponentsView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755644, "field 'componentsView'"), 2131755644, "field 'componentsView'"));
  }
  
  public void reset(T paramT)
  {
    componentsView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */