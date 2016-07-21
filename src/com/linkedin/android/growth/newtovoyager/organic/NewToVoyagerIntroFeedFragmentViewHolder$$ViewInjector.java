package com.linkedin.android.growth.newtovoyager.organic;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class NewToVoyagerIntroFeedFragmentViewHolder$$ViewInjector<T extends NewToVoyagerIntroFeedFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    feedTrendTitleTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756046, "field 'feedTrendTitleTextView'"), 2131756046, "field 'feedTrendTitleTextView'"));
    feedPostTitleTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756049, "field 'feedPostTitleTextView'"), 2131756049, "field 'feedPostTitleTextView'"));
    trendingCardView = ((CardView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756045, "field 'trendingCardView'"), 2131756045, "field 'trendingCardView'"));
    postCardView = ((CardView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756048, "field 'postCardView'"), 2131756048, "field 'postCardView'"));
    trendingCardIcon = ((View)paramFinder.findRequiredView(paramObject, 2131756047, "field 'trendingCardIcon'"));
    postCardIcon = ((View)paramFinder.findRequiredView(paramObject, 2131756052, "field 'postCardIcon'"));
  }
  
  public void reset(T paramT)
  {
    feedTrendTitleTextView = null;
    feedPostTitleTextView = null;
    trendingCardView = null;
    postCardView = null;
    trendingCardIcon = null;
    postCardIcon = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFeedFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */