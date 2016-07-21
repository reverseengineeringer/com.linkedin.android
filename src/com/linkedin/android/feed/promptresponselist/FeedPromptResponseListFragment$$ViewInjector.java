package com.linkedin.android.feed.promptresponselist;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.linkedin.android.feed.page.feed.BaseFeedFragment..ViewInjector;

public class FeedPromptResponseListFragment$$ViewInjector<T extends FeedPromptResponseListFragment>
  extends BaseFeedFragment..ViewInjector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    super.inject(paramFinder, paramT, paramObject);
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755797, "field 'recyclerView'"), 2131755797, "field 'recyclerView'"));
    errorViewStub = ((ViewStub)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755783, "field 'errorViewStub'"), 2131755783, "field 'errorViewStub'"));
    promptActor = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755832, "field 'promptActor'"), 2131755832, "field 'promptActor'"));
    promptQuestion = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755833, "field 'promptQuestion'"), 2131755833, "field 'promptQuestion'"));
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755831, "field 'toolbar'"), 2131755831, "field 'toolbar'"));
    appBarLayout = ((AppBarLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755829, "field 'appBarLayout'"), 2131755829, "field 'appBarLayout'"));
  }
  
  public void reset(T paramT)
  {
    super.reset(paramT);
    recyclerView = null;
    errorViewStub = null;
    promptActor = null;
    promptQuestion = null;
    toolbar = null;
    appBarLayout = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */