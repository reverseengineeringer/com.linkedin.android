package com.linkedin.android.feed.endor.ui.component.comment;

import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import java.util.List;

public final class FeedCommentViewModelUtils
{
  public static FeedCommentViewModel getCommentViewModel(FeedComponentViewModel paramFeedComponentViewModel)
  {
    if ((paramFeedComponentViewModel instanceof FeedCommentViewModel)) {
      return (FeedCommentViewModel)paramFeedComponentViewModel;
    }
    if ((paramFeedComponentViewModel instanceof FeedComponentListViewModel))
    {
      paramFeedComponentViewModel = components;
      int i = 0;
      while (i < paramFeedComponentViewModel.size())
      {
        FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)paramFeedComponentViewModel.get(i);
        if ((localFeedComponentViewModel instanceof FeedCommentViewModel)) {
          return (FeedCommentViewModel)localFeedComponentViewModel;
        }
        i += 1;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModelUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */