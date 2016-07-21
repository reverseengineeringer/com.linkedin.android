package com.linkedin.android.feed.endor.ui.component.seeallcard;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedSeeAllCardViewHolder$$ViewInjector<T extends FeedSeeAllCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    stackedImages = ((View)paramFinder.findRequiredView(paramObject, 2131755725, "field 'stackedImages'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755726, "field 'title'"), 2131755726, "field 'title'"));
    actionButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755728, "field 'actionButton'"), 2131755728, "field 'actionButton'"));
  }
  
  public void reset(T paramT)
  {
    stackedImages = null;
    title = null;
    actionButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.seeallcard.FeedSeeAllCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */