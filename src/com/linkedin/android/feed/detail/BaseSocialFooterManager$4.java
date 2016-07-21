package com.linkedin.android.feed.detail;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.MentionsEditTextWithBackEvents;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import java.lang.ref.WeakReference;

final class BaseSocialFooterManager$4
  implements View.OnTouchListener
{
  BaseSocialFooterManager$4(BaseSocialFooterManager paramBaseSocialFooterManager) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    paramView = (MentionsEditTextWithBackEvents)this$0.replyEditText.get();
    if ((i == 1) && (paramView != null))
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        if (!FeedViewTransformerHelpers.isCommentDetailPage((FragmentComponent)this$0.fragmentComponent.get())) {
          break label109;
        }
      }
    }
    label109:
    for (paramView = "reply";; paramView = "comment")
    {
      new ControlInteractionEvent(this$0.tracker, paramView, ControlType.TEXTFIELD, InteractionType.SHORT_PRESS).send();
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.BaseSocialFooterManager.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */