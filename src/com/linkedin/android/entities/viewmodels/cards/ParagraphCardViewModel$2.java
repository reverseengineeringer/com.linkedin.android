package com.linkedin.android.entities.viewmodels.cards;

import com.linkedin.android.entities.viewholders.ParagraphCardViewHolder;
import com.linkedin.android.infra.ui.EllipsizeTextView.OnEllipsizeListener;

final class ParagraphCardViewModel$2
  implements EllipsizeTextView.OnEllipsizeListener
{
  ParagraphCardViewModel$2(ParagraphCardViewModel paramParagraphCardViewModel, ParagraphCardViewHolder paramParagraphCardViewHolder) {}
  
  public final void onEllipsize(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this$0.setupExpandButton(val$holder, this$0.expandInNewPage);
      return;
    }
    ParagraphCardViewModel.resetExpandButtons(val$holder);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */