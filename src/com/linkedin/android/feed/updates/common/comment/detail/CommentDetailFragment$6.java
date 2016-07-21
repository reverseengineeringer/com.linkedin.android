package com.linkedin.android.feed.updates.common.comment.detail;

import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import java.util.Iterator;
import java.util.List;

final class CommentDetailFragment$6
  implements ModelsTransformedCallback<Comment, CommentDataModel, FeedComponentViewModel>
{
  CommentDetailFragment$6(CommentDetailFragment paramCommentDetailFragment) {}
  
  public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramModelsData)
  {
    if ((!this$0.isAdded()) || (CommentDetailFragment.access$400(this$0) == null)) {}
    for (;;)
    {
      return;
      paramModelsData = viewModels.iterator();
      while (paramModelsData.hasNext())
      {
        FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)paramModelsData.next();
        if ((localFeedComponentViewModel instanceof FeedCommentViewModel)) {
          CommentDetailFragment.access$400(this$0).changeCommentWithId(commentUrn, localFeedComponentViewModel);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */