package com.linkedin.android.entities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CollapsingToolbarLayout;

final class EntityCoordinatorBaseFragment$1
  implements AppBarLayout.OnOffsetChangedListener
{
  int scrollRange = -1;
  
  EntityCoordinatorBaseFragment$1(EntityCoordinatorBaseFragment paramEntityCoordinatorBaseFragment, String paramString) {}
  
  public final void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
  {
    if ((this$0.collapsingToolbarLayout == null) || (!this$0.isResumed())) {}
    do
    {
      return;
      if (scrollRange == -1) {
        scrollRange = paramAppBarLayout.getTotalScrollRange();
      }
      if (EntityCoordinatorBaseFragment.access$000(this$0) == 2)
      {
        this$0.onOffsetChangedForOpenBar(paramInt, scrollRange);
        return;
      }
      paramAppBarLayout = this$0;
      String str = val$title;
      if (scrollRange + paramInt == 0)
      {
        collapsingToolbarLayout.setTitle(str);
        showingTitle = true;
        return;
      }
    } while (!showingTitle);
    collapsingToolbarLayout.setTitle(null);
    showingTitle = false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityCoordinatorBaseFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */