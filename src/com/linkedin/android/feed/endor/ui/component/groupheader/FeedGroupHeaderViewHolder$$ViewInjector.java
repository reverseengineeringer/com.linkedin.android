package com.linkedin.android.feed.endor.ui.component.groupheader;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedGroupHeaderViewHolder$$ViewInjector<T extends FeedGroupHeaderViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    groupHeaderName = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755666, "field 'groupHeaderName'"), 2131755666, "field 'groupHeaderName'"));
    groupHeaderIcon = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755665, "field 'groupHeaderIcon'"), 2131755665, "field 'groupHeaderIcon'"));
  }
  
  public void reset(T paramT)
  {
    groupHeaderName = null;
    groupHeaderIcon = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.groupheader.FeedGroupHeaderViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */