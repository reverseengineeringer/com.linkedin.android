package com.linkedin.android.feed.detail;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import java.lang.ref.WeakReference;

final class BaseSocialFooterManager$1
  implements View.OnFocusChangeListener
{
  BaseSocialFooterManager$1(BaseSocialFooterManager paramBaseSocialFooterManager) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      BaseSocialFooterManager localBaseSocialFooterManager = this$0;
      FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponent.get();
      String str = "comment";
      paramView = "expandCommentBox";
      if (FeedViewTransformerHelpers.isCommentDetailPage(localFragmentComponent))
      {
        str = "reply";
        paramView = "expandReplyBox";
      }
      localBaseSocialFooterManager.trackFAE(localFragmentComponent, str, ActionCategory.EXPAND, paramView);
    }
    paramView = this$0;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramView.setupSocialFooterState(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.BaseSocialFooterManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */