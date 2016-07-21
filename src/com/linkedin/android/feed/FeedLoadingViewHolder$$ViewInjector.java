package com.linkedin.android.feed;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedLoadingViewHolder$$ViewInjector<T extends FeedLoadingViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    progressBar = ((ProgressBar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755826, "field 'progressBar'"), 2131755826, "field 'progressBar'"));
    text = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755827, "field 'text'"), 2131755827, "field 'text'"));
  }
  
  public void reset(T paramT)
  {
    progressBar = null;
    text = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedLoadingViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */