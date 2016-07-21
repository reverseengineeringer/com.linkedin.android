package com.linkedin.android.feed.updates.common.comment.detail;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CommentDetailFragment$$ViewInjector<T extends CommentDetailFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
    detailContainer = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755597, "field 'detailContainer'"), 2131755597, "field 'detailContainer'"));
    detailRecyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755598, "field 'detailRecyclerView'"), 2131755598, "field 'detailRecyclerView'"));
    dismissComposeView = ((View)paramFinder.findRequiredView(paramObject, 2131755599, "field 'dismissComposeView'"));
    mentionsRecyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755600, "field 'mentionsRecyclerView'"), 2131755600, "field 'mentionsRecyclerView'"));
    loading = ((View)paramFinder.findRequiredView(paramObject, 2131755595, "field 'loading'"));
  }
  
  public void reset(T paramT)
  {
    toolbar = null;
    detailContainer = null;
    detailRecyclerView = null;
    dismissComposeView = null;
    mentionsRecyclerView = null;
    loading = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */