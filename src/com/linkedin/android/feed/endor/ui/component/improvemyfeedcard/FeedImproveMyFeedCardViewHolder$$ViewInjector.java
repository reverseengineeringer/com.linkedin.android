package com.linkedin.android.feed.endor.ui.component.improvemyfeedcard;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedImproveMyFeedCardViewHolder$$ViewInjector<T extends FeedImproveMyFeedCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    actionButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755689, "field 'actionButton'"), 2131755689, "field 'actionButton'"));
  }
  
  public void reset(T paramT)
  {
    actionButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.improvemyfeedcard.FeedImproveMyFeedCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */