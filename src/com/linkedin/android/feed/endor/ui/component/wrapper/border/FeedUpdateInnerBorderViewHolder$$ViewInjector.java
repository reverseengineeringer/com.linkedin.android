package com.linkedin.android.feed.endor.ui.component.wrapper.border;

import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedUpdateInnerBorderViewHolder$$ViewInjector<T extends FeedUpdateInnerBorderViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    wrapperArea = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755691, "field 'wrapperArea'"), 2131755691, "field 'wrapperArea'"));
    leftBorder = ((View)paramFinder.findRequiredView(paramObject, 2131755692, "field 'leftBorder'"));
    rightBorder = ((View)paramFinder.findRequiredView(paramObject, 2131755693, "field 'rightBorder'"));
    topBorder = ((View)paramFinder.findRequiredView(paramObject, 2131755694, "field 'topBorder'"));
    bottomBorder = ((View)paramFinder.findRequiredView(paramObject, 2131755695, "field 'bottomBorder'"));
  }
  
  public void reset(T paramT)
  {
    wrapperArea = null;
    leftBorder = null;
    rightBorder = null;
    topBorder = null;
    bottomBorder = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.wrapper.border.FeedUpdateInnerBorderViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */