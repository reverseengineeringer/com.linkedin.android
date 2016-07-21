package com.linkedin.android.feed.endor.ui.component.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedHeaderViewHolder$$ViewInjector<T extends FeedHeaderViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    container = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755668, "field 'container'"), 2131755668, "field 'container'"));
    text = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755669, "field 'text'"), 2131755669, "field 'text'"));
    controlMenu = ((View)paramFinder.findRequiredView(paramObject, 2131755671, "field 'controlMenu'"));
  }
  
  public void reset(T paramT)
  {
    container = null;
    text = null;
    controlMenu = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */