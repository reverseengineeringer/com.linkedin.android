package com.linkedin.android.feed.endor.ui.component.commentloading;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedCommentLoadingViewHolder$$ViewInjector<T extends FeedCommentLoadingViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755638, "field 'title'"), 2131755638, "field 'title'"));
    progressBar = ((ProgressBar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755641, "field 'progressBar'"), 2131755641, "field 'progressBar'"));
    spinner = ((ProgressBar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755642, "field 'spinner'"), 2131755642, "field 'spinner'"));
    topDivider = ((View)paramFinder.findRequiredView(paramObject, 2131755639, "field 'topDivider'"));
    bottomDivider = ((View)paramFinder.findRequiredView(paramObject, 2131755640, "field 'bottomDivider'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    progressBar = null;
    spinner = null;
    topDivider = null;
    bottomDivider = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */