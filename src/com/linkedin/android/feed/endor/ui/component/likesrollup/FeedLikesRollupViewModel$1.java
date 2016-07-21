package com.linkedin.android.feed.endor.ui.component.likesrollup;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.linkedin.android.feed.shared.rollup.RollupView;
import java.lang.ref.WeakReference;

final class FeedLikesRollupViewModel$1
  implements ViewTreeObserver.OnPreDrawListener
{
  FeedLikesRollupViewModel$1(FeedLikesRollupViewModel paramFeedLikesRollupViewModel, WeakReference paramWeakReference) {}
  
  public final boolean onPreDraw()
  {
    FeedLikesRollupViewHolder localFeedLikesRollupViewHolder = (FeedLikesRollupViewHolder)val$holderRef.get();
    if ((localFeedLikesRollupViewHolder != null) && (likesRollupView.getMeasuredWidth() > 0))
    {
      itemView.getViewTreeObserver().removeOnPreDrawListener(this);
      this$0.onWidthMeasured(localFeedLikesRollupViewHolder);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likesrollup.FeedLikesRollupViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */