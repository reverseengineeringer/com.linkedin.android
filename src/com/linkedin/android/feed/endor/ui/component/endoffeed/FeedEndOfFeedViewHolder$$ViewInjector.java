package com.linkedin.android.feed.endor.ui.component.endoffeed;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedEndOfFeedViewHolder$$ViewInjector<T extends FeedEndOfFeedViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    text = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755660, "field 'text'"), 2131755660, "field 'text'"));
    button = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755661, "field 'button'"), 2131755661, "field 'button'"));
    link = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755662, "field 'link'"), 2131755662, "field 'link'"));
  }
  
  public void reset(T paramT)
  {
    text = null;
    button = null;
    link = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.endoffeed.FeedEndOfFeedViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */