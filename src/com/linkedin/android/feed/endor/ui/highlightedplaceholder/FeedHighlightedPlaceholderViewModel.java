package com.linkedin.android.feed.endor.ui.highlightedplaceholder;

import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.infra.ViewHolderCreator;

public final class FeedHighlightedPlaceholderViewModel
  extends FeedItemViewModel<FeedHighlightedPlaceholderViewHolder>
{
  private CharSequence text;
  
  public FeedHighlightedPlaceholderViewModel(CharSequence paramCharSequence)
  {
    text = paramCharSequence;
  }
  
  public final ViewHolderCreator<FeedHighlightedPlaceholderViewHolder> getCreator()
  {
    return FeedHighlightedPlaceholderViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.highlightedplaceholder.FeedHighlightedPlaceholderViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */