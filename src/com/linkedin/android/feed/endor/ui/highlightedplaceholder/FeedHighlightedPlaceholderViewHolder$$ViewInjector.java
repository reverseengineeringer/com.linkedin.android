package com.linkedin.android.feed.endor.ui.highlightedplaceholder;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedHighlightedPlaceholderViewHolder$$ViewInjector<T extends FeedHighlightedPlaceholderViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    text = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755814, "field 'text'"), 2131755814, "field 'text'"));
  }
  
  public void reset(T paramT)
  {
    text = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.highlightedplaceholder.FeedHighlightedPlaceholderViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */