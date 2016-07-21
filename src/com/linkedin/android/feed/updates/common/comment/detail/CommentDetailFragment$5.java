package com.linkedin.android.feed.updates.common.comment.detail;

import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.consistency.ModelListConsistencyCoordinator;

final class CommentDetailFragment$5
  implements ModelsTransformedCallback<Comment, CommentDataModel, FeedComponentViewModel>
{
  CommentDetailFragment$5(CommentDetailFragment paramCommentDetailFragment, int paramInt) {}
  
  public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramModelsData)
  {
    if ((!this$0.isAdded()) || (CommentDetailFragment.access$400(this$0) == null) || (CommentDetailFragment.access$800(this$0) == null)) {
      return;
    }
    if (CollectionUtils.isEmpty(viewModels))
    {
      CommentDetailFragment.access$900(this$0);
      return;
    }
    if (val$requestState == 5) {
      CommentDetailFragment.access$400(this$0).addNewComments(viewModels, 3, this$0.fragmentComponent, CommentDetailFragment.access$000(this$0));
    }
    for (;;)
    {
      CommentDetailFragment.access$800(this$0).listenForUpdates(inputModels, CommentDetailFragment.access$1000(this$0));
      return;
      if (val$requestState == 6) {
        CommentDetailFragment.access$400(this$0).addNewComments(viewModels, 2, this$0.fragmentComponent, CommentDetailFragment.access$000(this$0));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */