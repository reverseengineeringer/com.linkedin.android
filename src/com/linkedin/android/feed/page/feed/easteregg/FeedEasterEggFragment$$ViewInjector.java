package com.linkedin.android.feed.page.feed.easteregg;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedEasterEggFragment$$ViewInjector<T extends FeedEasterEggFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    container = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755768, "field 'container'"), 2131755768, "field 'container'"));
    message = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755769, "field 'message'"), 2131755769, "field 'message'"));
    scoreText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755770, "field 'scoreText'"), 2131755770, "field 'scoreText'"));
  }
  
  public void reset(T paramT)
  {
    container = null;
    message = null;
    scoreText = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */