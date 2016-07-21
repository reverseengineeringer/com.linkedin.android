package com.linkedin.android.entities.viewholders;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PremiumRankCardViewHolder$$ViewInjector<T extends PremiumRankCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    value = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755440, "field 'value'"), 2131755440, "field 'value'"));
    description = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755443, "field 'description'"), 2131755443, "field 'description'"));
    link = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755444, "field 'link'"), 2131755444, "field 'link'"));
    cardRoot = ((CardView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755437, "field 'cardRoot'"), 2131755437, "field 'cardRoot'"));
    cardLayout = ((View)paramFinder.findRequiredView(paramObject, 2131755438, "field 'cardLayout'"));
    topText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755439, "field 'topText'"), 2131755439, "field 'topText'"));
    applicantText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755441, "field 'applicantText'"), 2131755441, "field 'applicantText'"));
    growthText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755442, "field 'growthText'"), 2131755442, "field 'growthText'"));
  }
  
  public void reset(T paramT)
  {
    value = null;
    description = null;
    link = null;
    cardRoot = null;
    cardLayout = null;
    topText = null;
    applicantText = null;
    growthText = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.PremiumRankCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */