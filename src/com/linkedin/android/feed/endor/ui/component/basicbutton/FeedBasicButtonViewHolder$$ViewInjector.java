package com.linkedin.android.feed.endor.ui.component.basicbutton;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedBasicButtonViewHolder$$ViewInjector<T extends FeedBasicButtonViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    button = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755611, "field 'button'"), 2131755611, "field 'button'"));
    topDivider = ((View)paramFinder.findRequiredView(paramObject, 2131755610, "field 'topDivider'"));
  }
  
  public void reset(T paramT)
  {
    button = null;
    topDivider = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */