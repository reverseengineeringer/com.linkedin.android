package com.linkedin.android.feed.detail;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedUpdateDetailFragment$$ViewInjector<T extends FeedUpdateDetailFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
    contentContainer = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755763, "field 'contentContainer'"), 2131755763, "field 'contentContainer'"));
    footerContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755865, "field 'footerContainer'"), 2131755865, "field 'footerContainer'"));
    errorViewStub = ((ViewStub)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755762, "field 'errorViewStub'"), 2131755762, "field 'errorViewStub'"));
    detailRecyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755764, "field 'detailRecyclerView'"), 2131755764, "field 'detailRecyclerView'"));
    dismissComposeView = ((View)paramFinder.findRequiredView(paramObject, 2131755765, "field 'dismissComposeView'"));
    mentionsRecyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755766, "field 'mentionsRecyclerView'"), 2131755766, "field 'mentionsRecyclerView'"));
    loading = ((View)paramFinder.findRequiredView(paramObject, 2131755761, "field 'loading'"));
  }
  
  public void reset(T paramT)
  {
    toolbar = null;
    contentContainer = null;
    footerContainer = null;
    errorViewStub = null;
    detailRecyclerView = null;
    dismissComposeView = null;
    mentionsRecyclerView = null;
    loading = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */