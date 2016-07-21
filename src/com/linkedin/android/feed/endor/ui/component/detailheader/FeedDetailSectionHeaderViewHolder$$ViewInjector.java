package com.linkedin.android.feed.endor.ui.component.detailheader;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedDetailSectionHeaderViewHolder$$ViewInjector<T extends FeedDetailSectionHeaderViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755655, "field 'title'"), 2131755655, "field 'title'"));
    toggle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755656, "field 'toggle'"), 2131755656, "field 'toggle'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    toggle = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.detailheader.FeedDetailSectionHeaderViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */