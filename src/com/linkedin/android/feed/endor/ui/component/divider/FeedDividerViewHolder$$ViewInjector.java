package com.linkedin.android.feed.endor.ui.component.divider;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedDividerViewHolder$$ViewInjector<T extends FeedDividerViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    dividerView = ((View)paramFinder.findRequiredView(paramObject, 2131755658, "field 'dividerView'"));
  }
  
  public void reset(T paramT)
  {
    dividerView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */