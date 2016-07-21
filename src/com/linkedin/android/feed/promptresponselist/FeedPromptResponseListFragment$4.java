package com.linkedin.android.feed.promptresponselist;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.widget.TextView;

final class FeedPromptResponseListFragment$4
  implements AppBarLayout.OnOffsetChangedListener
{
  boolean offsetAdjusted;
  int scrollRange = -1;
  
  FeedPromptResponseListFragment$4(FeedPromptResponseListFragment paramFeedPromptResponseListFragment) {}
  
  public final void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
  {
    if (scrollRange == -1) {
      scrollRange = paramAppBarLayout.getTotalScrollRange();
    }
    if (scrollRange + paramInt == 0)
    {
      this$0.promptActor.setAlpha(0.0F);
      offsetAdjusted = true;
    }
    while (!offsetAdjusted) {
      return;
    }
    this$0.promptActor.setAlpha(1.0F);
    offsetAdjusted = false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */